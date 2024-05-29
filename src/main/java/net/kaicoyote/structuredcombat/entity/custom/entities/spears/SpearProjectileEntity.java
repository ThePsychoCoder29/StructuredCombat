package net.kaicoyote.structuredcombat.entity.custom.entities.spears;

import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SpearProjectileEntity extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_RECALL;
    private ItemStack spearItem;
    private boolean dealtDamage;
    private int clientSideReturnTridentTickCount;

    public SpearProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack, EntityType<? extends SpearProjectileEntity> dagger) {
        super(dagger, pShooter, pLevel);
        this.spearItem = pStack.copy();
        this.entityData.set(ID_RECALL, (byte)pStack.getEnchantmentLevel(ModEnchantments.RECALL.get()));
    }

    public SpearProjectileEntity(EntityType<? extends SpearProjectileEntity> entity, Level pLevel){
        super(entity, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_RECALL, (byte)0);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity owner = this.getOwner();
        int recall_data = this.entityData.get(ID_RECALL);
        if (recall_data > 0 && (this.dealtDamage || this.isNoPhysics()) && owner != null) {
            if (!this.isAcceptableReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 owner_pos = owner.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + owner_pos.y * 0.015 * (double)recall_data, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }

                double scale_factor = 0.05 * (double)recall_data;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(owner_pos.normalize().scale(scale_factor)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnTridentTickCount;
            }
        }
        super.tick();
    }

    @Override
    protected boolean tryPickup(@NotNull Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }

    private boolean isAcceptableReturnOwner() {
        Entity owner = this.getOwner();
        if (owner != null && owner.isAlive()) {
            return !(owner instanceof ServerPlayer) || !owner.isSpectator();
        } else {
            return false;
        }
    }

    public float damage(){
        return 0;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        float damageAmt = this.damage();
        Entity owner = this.getOwner();
        DamageSource damageSource = this.damageSources().trident(this, owner == null ? this : owner);
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.TRIDENT_HIT;
        if (entity.hurt(damageSource, damageAmt)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                if (owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, owner);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingEntity);
                }

                this.doPostHurtEffects(livingEntity);
            }
        }
        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        float vol = 1.0F;
        this.playSound(soundEvent, vol, 1.0F);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return this.spearItem.copy();
    }

    @Override
    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(ID_RECALL, ((byte) spearItem.getEnchantmentLevel(ModEnchantments.RECALL.get())));
    }

    @Override
    protected void tickDespawn() {
        int recall = this.entityData.get(ID_RECALL);
        if (this.pickup != Pickup.ALLOWED || recall <= 0) {
            super.tickDespawn();
        }
    }

    static {
        ID_RECALL = SynchedEntityData.defineId(SpearProjectileEntity.class, EntityDataSerializers.BYTE);
    }
}
