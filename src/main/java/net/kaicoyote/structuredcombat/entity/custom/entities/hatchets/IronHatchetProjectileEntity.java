package net.kaicoyote.structuredcombat.entity.custom.entities.hatchets;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IronHatchetProjectileEntity extends HatchetProjectileEntity {
    public IronHatchetProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.IRON_HATCHET.get());
    }
    public IronHatchetProjectileEntity(EntityType<IronHatchetProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public float damage() {
        return 8f;
    }
}
