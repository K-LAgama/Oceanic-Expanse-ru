package com.sirsquidly.oe.world.feature.coral;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.google.common.collect.Lists;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCoralStalk extends WorldGenerator
{
	private IBlockState blockState;
	/** If all the branches of the stalk should generate at the top only, like in Java Edition.*/
	private boolean uniformBranchPlacement;
	
	public WorldGenCoralStalk(IBlockState blockStateIn)
	{ this.blockState = blockStateIn; }

	public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
		uniformBranchPlacement = false;
		/** The height to the base stalk.*/
        int baseHeight = rand.nextInt(3) + 1;
        /** Decides how many times to loop the branch generator.*/
        int branch = 2 + rand.nextInt(3);
        /** Shuffles all possible branch directions.*/
        List<EnumFacing> list = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL);
        Collections.shuffle(list, rand);
        /** used for counting the list spot if using the random branch height gen.*/
        int counter = 0;
        
        BlockPos blockpos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        
        for (int i = 0; i <= baseHeight; ++i)
        {
			this.setBlockAndNotifyAdequately(worldIn, blockpos, blockState);
        	/** Used to place branches in random spots along the base stalk, like Bedrock Edition.*/
            if (!uniformBranchPlacement && counter != 4 && rand.nextFloat() < 0.75f)
            {
            	genBranch(worldIn, rand, blockpos, list.get(counter));
            	counter += 1;
            }
            blockpos = blockpos.up();
        }
        
        /** If random branch placement isn't enabled, places them all in a uniform manner, like Java Edition..*/
        if (uniformBranchPlacement)
        {
        	blockpos = blockpos.down();
        	
        	for (EnumFacing enumfacing : list.subList(0, branch))
            { genBranch(worldIn, rand, blockpos, enumfacing); }
        }
		return true;
    }
	
	public void genBranch(World worldIn, Random rand, BlockPos pos, EnumFacing facing)
	{
    	/** The height of any branch.*/
        int branchHeight = 1 + rand.nextInt(4);
        
    	BlockPos posRotate = pos;
    	
    	for (int i = 0; i <= branchHeight; ++i)
        {
        	if (worldIn.getBlockState(posRotate).getMaterial() != Material.WATER)
            {
                posRotate = posRotate.up();
                
                if (i <= 1)
            	{ posRotate = posRotate.offset(facing); }
                else if ( i != 0 && rand.nextFloat() < 0.25f)
                {
                	if (!uniformBranchPlacement)
                	{ facing = EnumFacing.Plane.HORIZONTAL.random(rand); }
                	posRotate = posRotate.offset(facing);
                }

				this.setBlockAndNotifyAdequately(worldIn, posRotate, blockState);
            }
        }
	}
}