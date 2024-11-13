package com.sirsquidly.oe.potion;

import com.sirsquidly.oe.Main;
import com.sirsquidly.oe.init.OEPotions;
import com.sirsquidly.oe.util.handlers.ConfigHandler;

import git.jbredwards.fluidlogged_api.api.util.FluidState;
import git.jbredwards.fluidlogged_api.api.util.FluidloggedUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;

/** 
 *  Currently hosts the effects for all the mod's potion effects. 
 *  I will split this up into multiple classes if many more effects are added.
 *  
 * */
public class PotionBase extends Potion
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/gui/potion_effects.png");
	
	public PotionBase(String name, boolean isBadEffectIn, int liquidColorIn, int icon)
	{
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("effect." + Main.MOD_ID + "." + name);
		this.setRegistryName(name);
		this.setIconIndex(icon % 8, icon / 8);
	}
	
	@Override
    public void performEffect(EntityLivingBase entity, int amplifier)
    {
		if(entity.isPotionActive(OEPotions.CONDUIT_POWER))
		{
			if ( entity.getActivePotionEffect(OEPotions.CONDUIT_POWER).getDuration() > 1)
			{
				if (isEntityHeadSubmerged(entity))
				{
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 210, 0, true, false));

					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 210, 0, true, false));

					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 210, entity.getActivePotionEffect(OEPotions.CONDUIT_POWER).getAmplifier(), true, false));
				}
				else
				{ removeConduitEffects(entity); }
			}
			else
			{ removeConduitEffects(entity); }
        }
		if(entity.isPotionActive(OEPotions.DESCENT))
		{
			int modDes = entity.getActivePotionEffect(OEPotions.DESCENT).getAmplifier() + 1;
			boolean onSlime = entity.onGround && entity.world.getBlockState(new BlockPos(entity.posX, entity.posY-1, entity.posZ)).getBlock() == Blocks.SLIME_BLOCK;
			
			/* This check is so players in Creative and Spectator aren't dragged down **/
			if (entity instanceof EntityPlayer) if (((EntityPlayer)entity).capabilities.isFlying) return;
			
			
			if (entity.isInWater())
			{
				if (entity instanceof EntityPlayer)
				{
					entity.motionY -= (ConfigHandler.effect.descent.descentWaterPull * modDes - entity.motionY) * 0.1D;
					
					/* Additional pull if Aqua Acrobatics is installed, as swimming is really fast with that mod. **/
					if (ConfigHandler.effect.descent.descentAqAcWaterPull != 0 && Loader.isModLoaded("aquaacrobatics") && entity.world.getBlockState(entity.getPosition().add(0, entity.getEyeHeight(), 0)).getMaterial() != Material.AIR)
					{
						entity.motionY = entity.motionY - (ConfigHandler.effect.descent.descentAqAcWaterPull * modDes);
					}
				}
				
				else entity.motionY -= (ConfigHandler.effect.descent.descentWaterPull * modDes - entity.motionY) * 0.1D;
			}
			else if (entity.motionY < 0.0)
			{
				entity.motionY -= (ConfigHandler.effect.descent.descentFallPull * modDes - entity.motionY) * 0.1D;
			}
			
			/** Extra hard-coded check to make sure the momentum is SLOWED when landing on a Slime Block. */
			if (onSlime && ConfigHandler.effect.descent.descentSlimeFix)
			{
				entity.motionY *= 0.4D;
			}
        }
    }
	
	/** Specific for Conduit Power. Removes the potion effects.*/
	public static void removeConduitEffects(EntityLivingBase entity)
	{
		if (entity.isPotionActive(MobEffects.WATER_BREATHING) && entity.getActivePotionEffect(MobEffects.WATER_BREATHING).getDuration() < 210) entity.removePotionEffect(MobEffects.WATER_BREATHING);
		if (entity.isPotionActive(MobEffects.NIGHT_VISION) && entity.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() < 210) entity.removePotionEffect(MobEffects.NIGHT_VISION);
		if (entity.isPotionActive(MobEffects.HASTE) && entity.getActivePotionEffect(MobEffects.HASTE).getDuration() < 210) entity.removePotionEffect(MobEffects.HASTE);
		return;
	}

	/** Tells if the given entity has their head underwater */
	public static boolean isEntityHeadSubmerged(Entity entity)
	{
		/* Special Checks required if Fluidlogged API is being used */
		if (Main.proxy.fluidlogged_enable)
		{
			final FluidState fluidState = FluidloggedUtils.getFluidState(entity.world, new BlockPos(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ));

			if(!fluidState.isEmpty() && fluidState.getMaterial() == Material.WATER && fluidState.isValid())
			{ return true; }
		}
		else if (entity.world.getBlockState(new BlockPos(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ)).getMaterial() == Material.WATER)
		{ return true; }

		return false;
	}

	/** Required so the effect actually runs. */
	public boolean isReady(int duration, int amplifier)
    { return true; }
	
	@Override
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		return super.getStatusIconIndex();
	}
}