package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KatanaItem extends SwordItem {

    public KatanaItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND) {
            if (stack.is(ModItems.WOODEN_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0));
                builder.build();
            }
            if (stack.is(ModItems.STONE_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0));
                builder.build();
            }
            if (stack.is(ModItems.IRON_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(1));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0.5));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_KATANA.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0.5));
                builder.build();
            }
        }

        return builder.build();
    }

    public AttributeModifier attributeDmg(double amountDmg) {
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }

    public AttributeModifier attributeSpd(double amountSpd) {
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        InteractionHand hand = pAttacker.getUsedItemHand();
        if (pTarget.isBlocking()) {
            pStack.hurtAndBreak(3, pAttacker, user -> user.broadcastBreakEvent(hand));
        }
        else if (pTarget.getArmorValue() > 0) {
            pStack.hurtAndBreak(2, pAttacker, user -> user.broadcastBreakEvent(hand));
        }
        else {
            pStack.hurtAndBreak(1, pAttacker, user -> user.broadcastBreakEvent(hand));
        }
        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.katana.tooltip"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return pState.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
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
