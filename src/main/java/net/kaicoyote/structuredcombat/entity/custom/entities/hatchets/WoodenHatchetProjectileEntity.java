package net.kaicoyote.structuredcombat.entity.custom.entities.hatchets;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class WoodenHatchetProjectileEntity extends HatchetProjectileEntity {
    public WoodenHatchetProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.WOODEN_HATCHET.get());
    }

    public WoodenHatchetProjectileEntity(EntityType<? extends WoodenHatchetProjectileEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    public float damage() {
        return 6.5f;
    }
}
