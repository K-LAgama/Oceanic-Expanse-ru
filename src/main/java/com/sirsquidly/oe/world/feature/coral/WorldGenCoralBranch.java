package com.sirsquidly.oe.world.feature.coral;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.google.common.collect.Lists;

public class WorldGenCoralBranch extends CoralGen
{
	/** The chance the branch has to decide to go up while generating. Doesn't control how side branches are automatically shifted up on the first parts.*/
	private double upChance = 0.25F;
	
	public WorldGenCoralBranch(int type) 
	{
		super();
		this.coralType = type;
	}

	public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
		if (this.coralType == 0)
		{
			this.coralType = rand.nextInt(5)+1;
		}
		
		/** Decides how many times to loop the branch generator.*/
		int branch = 2 + rand.nextInt(2);
		/** Determines the overall direction the thing generates in, so North makes every branch reach North, ect.*/
        EnumFacing firstFacing = EnumFacing.Plane.HORIZONTAL.random(rand);
        /** firstFacing, along with both immedient sides, get put in a list and shuffled. This is because there's a change for a branch to be missing(determined by int branch) when looped in the actual generation.*/
        List<EnumFacing> list = Lists.newArrayList(firstFacing, firstFacing.rotateY(), firstFacing.rotateYCCW());
        Collections.shuffle(list, rand);
        
        /** The first piece, auto-placed incase the firstFacing wasn't picked at all.*/
        this.placeCoralBlockAt(worldIn, pos, this.coralType);
        
        /** Does all the actual generation. I'm actually proud of this.*/
        for (EnumFacing enumfacing : list.subList(0, branch))
        {
        	BlockPos blockpos = pos;
        	/** Gives branches a random length.*/
        	int brnchLngh = rand.nextInt(4) + 1;
        	
        	/** This is just to pull the branches to the side, with a chance to go out by 2.*/
        	if (enumfacing != firstFacing)
        	{
        		blockpos = pos.up();
                
                for (int i = 1; i <= Math.max(rand.nextInt(6) - 3, 1); ++i)
                {
                	blockpos = pos.offset(enumfacing, i).up();
                	this.placeCoralBlockAt(worldIn, blockpos, this.coralType);
                }
        	}

        	for (int i = 0; i <= brnchLngh; ++i)
            {
        		this.placeCoralBlockAt(worldIn, blockpos, this.coralType);
                blockpos = blockpos.offset(firstFacing);
                
                if (rand.nextFloat() < upChance)
            	{
            		blockpos = blockpos.up();
            	}
            }
        }
		return true;
    }
}