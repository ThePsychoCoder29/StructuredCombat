package net.kaicoyote.structuredcombat.entity.custom.entities.spears;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class GoldSpearProjectileEntity extends SpearProjectileEntity {
    public GoldSpearProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.GOLD_SPEAR.get());
    }

    public GoldSpearProjectileEntity(EntityType<GoldSpearProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public float damage() {
        return 5F;
    }
}
