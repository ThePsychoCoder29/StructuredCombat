package net.kaicoyote.structuredcombat.item.custom;

import net.kaicoyote.structuredcombat.entity.custom.entities.*;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

public class DaggerItem extends Item {
    private final TriFunction<Level, Player, ItemStack, DaggerProjectileEntity> constructor;
    public DaggerItem(TriFunction<Level, Player, ItemStack, DaggerProjectileEntity> constructor, Properties pProperties) {
        super(pProperties);
        this.constructor = constructor;
    }


    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }


    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean durationCheck = durationCheck(stack, pTimeLeft);
            if (durationCheck) {
                if (!pLevel.isClientSide()) {
                    stack.hurtAndBreak(1, player, (broadcastPlayer) -> broadcastPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                    if(stack.is(this)){
                        DaggerProjectileEntity dagger = this.constructor.apply(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.062640088593577F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.ALLOWED;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    if (!player.getAbilities().instabuild) {
                        player.getInventory().removeItem(stack);
                    }
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    public boolean durationCheck(ItemStack stack, int timeLeft) {
        int useDur = this.getUseDuration(stack);
        int duration = useDur - timeLeft;
        if(stack.is(ModItems.WOODEN_DAGGER.get()) || stack.is(ModItems.STONE_DAGGER.get()) || stack.is(ModItems.IRON_DAGGER.get())){
            return duration >= 60;
        } else if (stack.is(ModItems.DIAMOND_DAGGER.get()) || stack.is(ModItems.NETHERITE_DAGGER.get())) {
            return duration >= 70;
        }
        return duration >= 80;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack dagger = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(dagger);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        return true;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPEAR;
    }
}
