package net.kaicoyote.structuredcombat.entity.custom.entities.spears;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StoneSpearProjectileEntity extends SpearProjectileEntity {
    public StoneSpearProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.STONE_SPEAR.get());
    }

    public StoneSpearProjectileEntity(EntityType<StoneSpearProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public float damage() {
        return 6.5f;
    }
}
