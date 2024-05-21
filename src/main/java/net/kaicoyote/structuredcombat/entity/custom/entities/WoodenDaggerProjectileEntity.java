package net.kaicoyote.structuredcombat.entity.custom.entities;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class WoodenDaggerProjectileEntity extends DaggerProjectileEntity {
    public WoodenDaggerProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.WOODEN_DAGGER.get());
    }

    public WoodenDaggerProjectileEntity(EntityType<? extends WoodenDaggerProjectileEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    public float damage() {
        return 3.0f;
    }
}
