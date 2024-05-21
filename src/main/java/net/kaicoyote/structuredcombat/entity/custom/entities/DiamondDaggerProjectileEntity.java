package net.kaicoyote.structuredcombat.entity.custom.entities;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DiamondDaggerProjectileEntity extends DaggerProjectileEntity {
    public DiamondDaggerProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.DIAMOND_DAGGER.get());
    }
    public DiamondDaggerProjectileEntity(EntityType<DiamondDaggerProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public float damage() {
        return 5.25f;
    }
}
