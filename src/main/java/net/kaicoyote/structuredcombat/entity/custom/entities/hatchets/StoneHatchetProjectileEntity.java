package net.kaicoyote.structuredcombat.entity.custom.entities.hatchets;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StoneHatchetProjectileEntity extends HatchetProjectileEntity {
    public StoneHatchetProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.STONE_HATCHET.get());
    }

    public StoneHatchetProjectileEntity(EntityType<StoneHatchetProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public float damage() {
        return 8f;
    }
}
