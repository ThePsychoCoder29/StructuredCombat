package net.kaicoyote.structuredcombat.entity.custom.entities.hatchets;

import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NetheriteHatchetProjectileEntity extends HatchetProjectileEntity {
    public NetheriteHatchetProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(pLevel, pShooter, pStack, ModEntities.NETHERITE_HATCHET.get());
    }
    public NetheriteHatchetProjectileEntity(EntityType<NetheriteHatchetProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public float damage() {
        return 9.5f;
    }
}
