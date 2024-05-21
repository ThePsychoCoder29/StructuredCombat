package net.kaicoyote.structuredcombat.entity.custom.entities;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class GoldDaggerProjectileEntity extends DaggerProjectileEntity {
    public GoldDaggerProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.GOLD_DAGGER.get());
    }

    public GoldDaggerProjectileEntity(EntityType<GoldDaggerProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public float damage() {
        return 3.0F;
    }
}
