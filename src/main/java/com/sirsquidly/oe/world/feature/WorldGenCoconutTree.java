package com.sirsquidly.oe.world.feature;

import java.util.Random;

import com.sirsquidly.oe.init.OEBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenCoconutTree extends WorldGenAbstractTree
{
	public static final IBlockState LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
	public static final IBlockState LEAF = OEBlocks.COCONUT_LEAVES.getDefaultState();
	public static final IBlockState LEAF_FLOWERING = OEBlocks.COCONUT_LEAVES_FLOWERING.getDefaultState();
	
	/** The minimum height of the trunk*/
	public int minHeight = 5;
	/** A random number between this and zero get added to the minimum height*/
	public int plusRanHeight = 2;
	/** The max amount of block the trunk can bend out, like Acacia tree*/
	public int plusRanBend = 2;
	
	public WorldGenCoconutTree() 
	{
		super(false);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
        int i = rand.nextInt(plusRanHeight + 1) + minHeight;

        boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256)
        {
            for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == pos.getY())
                { k = 0; }

                if (j >= pos.getY() + 1 + i - 2)
                { k = 2; }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < worldIn.getHeight())
                        {
                            if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = pos.down();
                IBlockState state = worldIn.getBlockState(down);
                boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP, (IPlantable)OEBlocks.COCONUT_SAPLING);

                
                if (isSoil && pos.getY() < worldIn.getHeight() - i - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, down, pos);
                	
                    EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
                    int k2 = i/2 - rand.nextInt(2);
                    int l2 = (plusRanBend) - rand.nextInt(plusRanBend + 1);
                    int i3 = pos.getX();
                    int j1 = pos.getZ();
                    int k1 = 0;

                    for (int l1 = 0; l1 < i; ++l1)
                    {
                        int i2 = pos.getY() + l1;

                        if (l1 >= k2 && l2 > 0)
                        {
                            i3 += enumfacing.getFrontOffsetX();
                            j1 += enumfacing.getFrontOffsetZ();
                            --l2;
                        }

                        BlockPos blockpos = new BlockPos(i3, i2, j1);
                        state = worldIn.getBlockState(blockpos);

                        if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos))
                        {
                            this.placeLogAt(worldIn, blockpos);
                            k1 = i2;
                        }
                    }
                    
                    BlockPos blockpos2 = new BlockPos(i3, k1, j1);
                    
                    this.placeLeafAt(worldIn, blockpos2);
            		this.placeLeafAt(worldIn, blockpos2.up());
                	this.placeFloweringLeafAt(worldIn, blockpos2.north());
                	this.placeLeafAt(worldIn, blockpos2.north(2));
                	this.placeLeafAt(worldIn, blockpos2.north(3).down());
                	this.placeFloweringLeafAt(worldIn, blockpos2.south());
                	this.placeLeafAt(worldIn, blockpos2.south(2));
                	this.placeLeafAt(worldIn, blockpos2.south(3).down());
                	this.placeFloweringLeafAt(worldIn, blockpos2.east());
                	this.placeLeafAt(worldIn, blockpos2.east(2));
                	this.placeLeafAt(worldIn, blockpos2.east(3).down());
                	this.placeFloweringLeafAt(worldIn, blockpos2.west());
                	this.placeLeafAt(worldIn, blockpos2.west(2));
                	this.placeLeafAt(worldIn, blockpos2.west(3).down());
                	this.placeLeafAt(worldIn, blockpos2.north().west().down());
                	this.placeLeafAt(worldIn, blockpos2.north().east().down());
                	this.placeLeafAt(worldIn, blockpos2.south().west().down());
                	this.placeLeafAt(worldIn, blockpos2.south().east().down());
                	
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
	
	private void placeLogAt(World worldIn, BlockPos pos)
    { this.setBlockAndNotifyAdequately(worldIn, pos, LOG); }
	
	private void placeLeafAt(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);

        if (state.getBlock().isAir(state, worldIn, pos) || state.getBlock().isLeaves(state, worldIn, pos))
        { this.setBlockAndNotifyAdequately(worldIn, pos, LEAF); }
    }
	
	private void placeFloweringLeafAt(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);

        if (state.getBlock().isAir(state, worldIn, pos) || state.getBlock().isLeaves(state, worldIn, pos))
        { this.setBlockAndNotifyAdequately(worldIn, pos, LEAF_FLOWERING); }
    }
	
	@Override
	protected boolean canGrowInto(Block blockType)
	{
		Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || material == Material.GROUND || blockType == Blocks.GRASS || blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;
	}
}
