package com.sirsquidly.oe.enchantment.resonance;

import com.sirsquidly.oe.Main;
import com.sirsquidly.oe.entity.EntityDrowned;
import com.sirsquidly.oe.entity.EntityDrownedSummon;
import com.sirsquidly.oe.entity.ai.EntityAISummonCrew;
import com.sirsquidly.oe.init.OESounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class ResonanceCaptainCall extends Resonance
{
    /** The name placed upon the Magic Conch. */
    protected static String itemName;

    public ResonanceCaptainCall(String nameIn, int resonanceRangeIn)
    {
        super(nameIn, resonanceRangeIn);
    }

    @Override
    public void onUse(EntityLivingBase user, ItemStack item)
    {
        if (user.world.isRemote) return;
        Main.proxy.spawnParticle(3, user.world, user.posX, user.posY + user.getEyeHeight(), user.posZ, 0, 0.01, 0, 2);

        if (item.hasDisplayName()) itemName = item.getDisplayName();
        doDrownedSummon(user);
        spawnResonanceManyParticles(user, user.width, 80);
    }

    /** Summons a Drowned, who is friendly to the player. */
    private static void doDrownedSummon(EntityLivingBase user)
    {
        BlockPos pos = new BlockPos(user);
        int maxAttempts = 80;

        for (int i = 0; i < maxAttempts; i++)
        {
            EntityDrowned entity = new EntityDrowned(user.world);

            if (user instanceof EntityPlayer)
            {
                entity = new EntityDrownedSummon(user.world);
                ((EntityDrownedSummon) entity).setOwnerId(user.getUniqueID());
            }

            int offsetX = user.world.rand.nextInt(10 * 2) - 10;
            int offsetZ = user.world.rand.nextInt(10 * 2) - 10;
            int offsetY = user.world.rand.nextInt(5) - 2;
            BlockPos spawnPos = pos.add(offsetX, offsetY, offsetZ);

            if (spawnPos.distanceSq(pos) < 2 * 2) continue;

            entity.setLocationAndAngles(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, user.world.rand.nextFloat() * 360.0F, 0.0F);

            if (user.world.checkNoEntityCollision(entity.getEntityBoundingBox(), entity) && user.world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty())
            {
                BlockPos groundPos = spawnPos.down();

                if (user.world.getBlockState(spawnPos).getMaterial() == Material.WATER || i > maxAttempts / 2 && user.world.getBlockState(groundPos).isSideSolid(user.world, groundPos, EnumFacing.UP))
                {
                    entity.targetTasks.taskEntries.clear();
                    entity.targetTasks.addTask(3, new EntityAIHurtByTarget(entity, false));
                    entity.tasks.addTask(4, new EntityAISummonCrew(entity, user));

                    entity.playSound(OESounds.ENTITY_TRIDENT_THUNDER, 1.0F, 1.0F);

                    for (int j = 0; j < 80; j++)
                    {
                        Main.proxy.spawnParticle(2, user.world, entity.posX + (user.world.rand.nextFloat() - user.world.rand.nextFloat()), entity.posY + 1 + (user.world.rand.nextFloat() - user.world.rand.nextFloat()), entity.posZ + (user.world.rand.nextFloat() - user.world.rand.nextFloat()), 0, 0, 0, 4, 128, 255, 192);
                    }

                    if(itemName != null)
                    { entity.setCustomNameTag(itemName); }

                    entity.setAttackTarget(user.getLastAttackedEntity());

                    user.world.spawnEntity(entity);
                    break;
                }
            }
        }
    }

    @Override
    public void spawnResonanceParticle(EntityLivingBase user, float distance)
    {
        double posX = (double)user.posX + ((user.getRNG().nextFloat() * 2 - 1) * distance);
        double posY = (double)user.posY + ((user.getRNG().nextFloat() * 2 - 1) * distance);
        double posZ = (double)user.posZ + ((user.getRNG().nextFloat() * 2 - 1) * distance);
        double speedX = (user.getRNG().nextFloat() * 2 - 1) * 0.2F;
        double speedZ = (user.getRNG().nextFloat() * 2 - 1) * 0.2F;

        if (distance == user.width) posY += user.height/2;

        Main.proxy.spawnParticle(4, user.world, posX, posY, posZ, speedX, 0.03F, speedZ, 2);
    }
}
