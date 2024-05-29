package net.kaicoyote.structuredcombat.entity.custom.entities.spears;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class WoodenSpearProjectileEntity extends SpearProjectileEntity {
    public WoodenSpearProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.WOODEN_SPEAR.get());
    }

    public WoodenSpearProjectileEntity(EntityType<? extends WoodenSpearProjectileEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    public float damage() {
        return 5f;
    }
}
