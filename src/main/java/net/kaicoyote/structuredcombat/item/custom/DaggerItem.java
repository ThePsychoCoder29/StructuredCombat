package net.kaicoyote.structuredcombat.item.custom;

import net.kaicoyote.structuredcombat.entity.custom.*;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DaggerItem extends Item {
    public DaggerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        if(stack.is(ModItems.WOODEN_DAGGER.get())){
            return 3;
        }
        else if (stack.is(ModItems.STONE_DAGGER.get())){
            return (int) 3.75;
        }
        else if (stack.is(ModItems.IRON_DAGGER.get())){
            return (int) 4.5;
        }
        else if (stack.is(ModItems.GOLD_DAGGER.get())){
            return 3;
        }
        else if (stack.is(ModItems.DIAMOND_DAGGER.get())){
            return (int) 5.25;
        }
        return 6;
    }

    @Override
    public int getDamage(ItemStack stack) {
        return this.getMaxDamage(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            player.sendSystemMessage(Component.literal("used dagger"));
            int duration = this.getUseDuration(stack) - pTimeLeft;
            if (duration >= 10) {
                if (!pLevel.isClientSide()) {
                    stack.hurtAndBreak(1, player, (broadcastPlayer) -> broadcastPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                    if(stack.is(ModItems.WOODEN_DAGGER.get())){
                        WoodenDaggerProjectileEntity dagger = new WoodenDaggerProjectileEntity(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else if (stack.is(ModItems.STONE_DAGGER.get())) {
                        StoneDaggerProjectileEntity dagger = new StoneDaggerProjectileEntity(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else if (stack.is(ModItems.IRON_DAGGER.get())) {
                        IronDaggerProjectileEntity dagger = new IronDaggerProjectileEntity(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else if (stack.is(ModItems.DIAMOND_DAGGER.get())) {
                        DiamondDaggerProjectileEntity dagger = new DiamondDaggerProjectileEntity(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else if (stack.is(ModItems.NETHERITE_DAGGER.get())) {
                        NetheriteDaggerProjectileEntity dagger = new NetheriteDaggerProjectileEntity(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
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

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack dagger = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        ItemCooldowns cooldowns = pPlayer.getCooldowns();
        if(!pLevel.isClientSide()){
            this.releaseUsing(pPlayer.getItemInHand(pHand), pLevel, pPlayer, 20);
            pPlayer.sendSystemMessage(Component.literal("used dagger with use"));
            if(dagger.is(ModItems.WOODEN_DAGGER.get()) || dagger.is(ModItems.STONE_DAGGER.get()) || dagger.is(ModItems.IRON_DAGGER.get())){
                cooldowns.addCooldown(dagger.getItem(), 60);
            } else if (dagger.is(ModItems.GOLD_DAGGER.get())) {
                cooldowns.addCooldown(dagger.getItem(), 80);
            } else if (dagger.is(ModItems.DIAMOND_DAGGER.get()) || dagger.is(ModItems.NETHERITE_DAGGER.get())) {
                cooldowns.addCooldown(dagger.getItem(), 70);
            }
        }
        return InteractionResultHolder.success(dagger);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        return true;
    }
}
