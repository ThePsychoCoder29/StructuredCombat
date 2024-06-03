package net.kaicoyote.structuredcombat.mixin;

import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.kaicoyote.structuredcombat.event.ArrowShotEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(LivingEntity.class)
public abstract class ReimbursementInLivingEntityMixin {

    @Unique
    public LivingEntity self(){
        return (LivingEntity) (Object) this;
    }

    @Unique
    public boolean getIsShotFromBow(){
        return ArrowShotEvent.getShotFromBow();
    }

    @Unique
    public ItemStack bow(){
        return ArrowShotEvent.getBow();
    }
    @Unique
    public ItemEntity arrow = new ItemEntity(self().level(), self().getBlockX(), self().getBlockY(), self().getBlockZ(), new ItemStack(Items.ARROW, 5));

    @Inject(method = "dropAllDeathLoot", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;dropEquipment()V"))
    protected void dropAllDeathLoot(DamageSource pDamageSource, CallbackInfo ci){
        Entity attacker = pDamageSource.getEntity();
        Entity cause = pDamageSource.getDirectEntity();
        Random random = new Random();
        int chance = random.nextInt(6);
        if(cause instanceof AbstractArrow){
            if(attacker instanceof Player){
                if(getIsShotFromBow()){
                    ItemStack stack = bow();
                    int level = stack.getEnchantmentLevel(ModEnchantments.REIMBURSEMENT.get());
                    if(level > 0){
                        if(level == 1){
                            if(chance == 1){
                                Objects.requireNonNull(self().captureDrops()).add(arrow);
                            }
                        }
                        else if (level == 2) {
                            if(chance < 3){
                                Objects.requireNonNull(self().captureDrops()).add(arrow);
                            }
                        }
                        else if (level == 3) {
                            if(chance < 4){
                                Objects.requireNonNull(self().captureDrops()).add(arrow);
                            }
                        }
                        else if (level == 4) {
                            if(chance < 5){
                                Objects.requireNonNull(self().captureDrops()).add(arrow);
                            }
                        }
                        else {
                            Objects.requireNonNull(self().captureDrops()).add(arrow);
                        }
                    }
                }
            }
        }
    }
}
