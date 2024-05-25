package net.kaicoyote.structuredcombat.mixin;

import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BowItem.class)
public abstract class EagleEyesInBowMixin {

    @Unique
    public float kaiCoyote_sMod$getPower(int pCharge){
        float f = (float)pCharge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    @Unique
    public BowItem self(){
        return (BowItem) (Object) this;
    }

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"), cancellable = true)
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft, CallbackInfo ci){
            if(pEntityLiving instanceof Player shooter) {
                boolean bool = shooter.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
                int duration = self().getUseDuration(pStack) - pTimeLeft;
                ItemStack projectile = shooter.getProjectile(pStack);
                boolean bool2 = shooter.getAbilities().instabuild || projectile.getItem() instanceof ArrowItem && ((ArrowItem)projectile.getItem()).isInfinite(projectile, pStack, shooter);
                duration = ForgeEventFactory.onArrowLoose(pStack, pLevel, shooter, duration, !projectile.isEmpty() || bool);
                float f = kaiCoyote_sMod$getPower(duration);
                AbstractArrow arrow = new SpectralArrow(pLevel, shooter);
                arrow = self().customArrow(arrow);
                arrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, f * 3.0F, 1.0F);
                Random random = new Random();
                ArrowItem arrowitem = (ArrowItem)(projectile.getItem() instanceof ArrowItem ? projectile.getItem() : Items.ARROW);
                AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, projectile, shooter);
                abstractarrow = self().customArrow(abstractarrow);
                abstractarrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, f * 3.0F, 1.0F);
                int chance = random.nextInt(5);
                if(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EAGLE_EYES.get(), pStack) > 0) {
                    if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EAGLE_EYES.get(), pStack) == 1) {
                        if (chance == 1) {
                            pLevel.addFreshEntity(arrow);
                        }
                        else {
                            pLevel.addFreshEntity(abstractarrow);
                        }
                        pLevel.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                        if (!bool2 && !shooter.getAbilities().instabuild) {
                            projectile.shrink(1);
                            if (projectile.isEmpty()) {
                                shooter.getInventory().removeItem(projectile);
                            }
                        }
                        shooter.awardStat(Stats.ITEM_USED.get(self()));
                        ci.cancel();
                    } else if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EAGLE_EYES.get(), pStack) == 2) {
                        if (chance == 1 || chance == 2) {
                            pLevel.addFreshEntity(arrow);
                        } else {
                            pLevel.addFreshEntity(abstractarrow);
                        }
                        pLevel.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                        if (!bool2 && !shooter.getAbilities().instabuild) {
                            projectile.shrink(1);
                            if (projectile.isEmpty()) {
                                shooter.getInventory().removeItem(projectile);
                            }
                        }
                        shooter.awardStat(Stats.ITEM_USED.get(self()));
                        ci.cancel();
                    }
                }
            }
    }
}
