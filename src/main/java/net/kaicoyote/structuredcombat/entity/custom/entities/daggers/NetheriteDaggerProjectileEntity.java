package net.kaicoyote.structuredcombat.entity.custom.entities.daggers;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NetheriteDaggerProjectileEntity extends DaggerProjectileEntity {
    public NetheriteDaggerProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.NETHERITE_DAGGER.get());
    }
    public NetheriteDaggerProjectileEntity(EntityType<NetheriteDaggerProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public float damage() {
        return 6.0f;
    }
}
