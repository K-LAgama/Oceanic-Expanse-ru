package com.sirsquidly.oe.blocks;

import java.util.Random;

import com.sirsquidly.oe.Main;
import com.sirsquidly.oe.init.OESounds;
import com.sirsquidly.oe.util.handlers.ConfigHandler;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDulse extends BlockBush implements IGrowable, IChecksWater
{
	/** Note that Age 4 is exclusive for a top-half block. So, at age 3, a top block (at age 4 for rendering purposes) is also added.*/
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 4);
	public static final PropertyBool SHEARED = PropertyBool.create("sheared");
	
	protected static final AxisAlignedBB[] DULSE_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.5625D, 0.8125D), new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.8125D, 0.8125D), new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D), new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D), new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D)};
	
	@SuppressWarnings("deprecation")
	public BlockDulse()
	{
		super(Material.WATER);
		this.setSoundType(OESounds.WET_GRASS);
		this.setTickRandomly(true);
		this.setLightOpacity(Blocks.WATER.getLightOpacity(Blocks.WATER.getDefaultState()));
		setDefaultState(blockState.getBaseState().withProperty(SHEARED, false));
	}

	@SuppressWarnings("deprecation")
	public Material getMaterial(IBlockState state)
	{
		if(Main.proxy.fluidlogged_enable) { return Material.PLANTS; }
		return super.getMaterial(state);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return DULSE_AABB[(Integer) state.getValue(AGE)];
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && checkPlaceWater(worldIn, pos, false);
    }
	
	/** Checks if the Double tall 4th age crop can be placed here.*/
	public boolean canPlaceFullAge(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && (worldIn.getBlockState(pos).getBlock() == this || checkPlaceWater(worldIn, pos, false)) && checkPlaceWater(worldIn, pos.up(), true);
    }
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
		if (checkSurfaceWater(worldIn, pos, state)) return false;

		int age = state.getValue(AGE);
		/* Age 3 requires Dulse above it, AND the normal check at the bottom! */
		if (age == 3 && worldIn.getBlockState(pos.up()).getBlock() != this) return false;
		/* The top of the double-tall Dulse (age 4) only requires Dulse below it to be accepted */
		if (age == 4 && worldIn.getBlockState(pos.down()).getBlock() == this) return true;

        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP);
    }
	
	@Override
	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!this.canBlockStay(worldIn, pos, state)) 
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
		}
	}
	
	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) 
	{ worldIn.setBlockState(pos, Blocks.WATER.getDefaultState()); }

	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    { return false; }
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	super.updateTick(worldIn, pos, state, rand);
        if (worldIn.isRemote || (Boolean) state.getValue(SHEARED)) return;

		/* Default is 5% chance to grow, as Dulse doesn't have lots of ages */
		int growRate = 20;
		/* Encourages more spaced growth, as Dulse is a greedy crop */
		for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL)
		{ if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this) growRate += 5; }

        if (worldIn.isAreaLoaded(pos, 1) && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(growRate) == 0))
        {
        	this.grow(worldIn, rand, pos, state);
    		net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
        }
    }

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		
		if (!(Boolean) state.getValue(SHEARED) && ConfigHandler.block.dulse.dulseShears)
        {
			if (item instanceof ItemShears)
	        {
				worldIn.setBlockState(pos, state.withProperty(SHEARED, true));
				worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
	            return true;
	        }
        }
		return false;
    }
	
	public void placeAt(World worldIn, BlockPos lowerPos, int flags)
    {
        worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(SHEARED, true).withProperty(AGE, 3), flags);
        worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(SHEARED, true).withProperty(AGE, Integer.valueOf(4)));
    }
	
	/**
     * Bonemeal Growing
     */
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    { 
    	if (state.getValue(AGE) > 2) return false;
		return (worldIn.getBlockState(pos.up()).getBlock() == Blocks.WATER || Main.proxy.fluidlogged_enable); 
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    { 
    	if (state.getValue(AGE) > 2) return false;
    	return (worldIn.getBlockState(pos.up()).getBlock() == Blocks.WATER || Main.proxy.fluidlogged_enable);
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
    	int i = (Integer) state.getValue(AGE);

    	if(i != 4 && !(Boolean) state.getValue(SHEARED))
		{ 
    		if (i < 2) worldIn.setBlockState(pos, state.withProperty(AGE, i + 1));
    		if (i == 2 && this.canPlaceFullAge(worldIn, pos))
    		{ this.placeAt(worldIn, pos, 2); }
		}
    }

	/** Drops 3 Dulse if fully grown. */
    @Override public int quantityDropped(IBlockState state, int fortune, Random random){ return (Integer)state.getValue(AGE) != 4 ? (Math.min(4, (Integer)state.getValue(AGE) + 1)) : 0; }
	
	public IBlockState getStateFromMeta(int meta)
    {
		int gogle = meta;
		
		if (meta > 4)
		{ gogle -= 8; }
		
		return this.getDefaultState().withProperty(AGE, gogle).withProperty(SHEARED, (meta & 8) != 0);
    }
 
	public int getMetaFromState(IBlockState state)
	{
	    int i = 0;
	    i = i | (Integer) state.getValue(AGE);
	    
	    if ((Boolean) state.getValue(SHEARED))
	    { i |= 8; }
	    return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockLiquid.LEVEL, AGE, SHEARED);
	}
}