package net.kaicoyote.structuredcombat.entity.custom.entities;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StoneDaggerProjectileEntity extends DaggerProjectileEntity {
    public StoneDaggerProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.STONE_DAGGER.get());
    }

    public StoneDaggerProjectileEntity(EntityType<StoneDaggerProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public float damage() {
        return 3.75f;
    }
}
