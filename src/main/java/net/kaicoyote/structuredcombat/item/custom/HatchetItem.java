package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class HatchetItem extends AxeItem {
    private final TriFunction<Level, Player, ItemStack, HatchetProjectileEntity> constructor;

    public HatchetItem(Tier pTier, TriFunction<Level, Player, ItemStack, HatchetProjectileEntity> constructor, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
        this.constructor = constructor;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker){
        InteractionHand hand = pAttacker.getUsedItemHand();
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(hand));
        return true;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if(slot == EquipmentSlot.MAINHAND) {
            if (stack.is(ModItems.WOODEN_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.6));
                builder.build();
            }
            if (stack.is(ModItems.STONE_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.6));
                builder.build();
            }
            if (stack.is(ModItems.IRON_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.6));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.4));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.5));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.5));
                builder.build();
            }
        }
        return builder.build();
    }

    public AttributeModifier attributeDmg(double amountDmg) {
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }

    public  AttributeModifier attributeSpd(double amountSpd) {
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int duration = this.getUseDuration(stack) - pTimeLeft;
            if (duration >= 10) {
                if (!pLevel.isClientSide()) {
                    stack.hurtAndBreak(1, player, (broadcastPlayer) -> broadcastPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                    if(stack.is(this)){
                        HatchetProjectileEntity hatchet = this.constructor.apply(pLevel, player, stack);
                        hatchet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.125F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            hatchet.pickup = Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(hatchet);
                        pLevel.playSound(null, hatchet, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
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
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack hatchet = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(hatchet);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.hatchet.tooltip"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack pStack) {
        return true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }
}
