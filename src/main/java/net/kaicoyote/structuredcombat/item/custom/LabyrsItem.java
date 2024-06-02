package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LabyrsItem extends Item{
    public LabyrsItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(9));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.STONE_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(10));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.IRON_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(12));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(9));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.7));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(16));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_LABYRS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(20));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
        }

        return builder.build();
    }

    public AttributeModifier attributeDmg(double amountDmg){
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }
    public AttributeModifier attributeSpd(double amountSpd){
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.labyrs.tooltip"));
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
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        if(pState.is(BlockTags.MINEABLE_WITH_AXE)){
            return 15f;
        }
        else {
            return 1.0f;
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}
