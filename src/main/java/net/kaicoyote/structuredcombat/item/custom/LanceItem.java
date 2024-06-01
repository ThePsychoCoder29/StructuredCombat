package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LanceItem extends Item {

    public LanceItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.STONE_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.IRON_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.2));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
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
    public static float dmgWithSpd(Player player){
        double deltaX = player.getX() - player.xOld;
        double deltaY = player.getY() - player.yOld;
        double deltaZ = player.getZ() - player.zOld;
        double speed = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2));
        if(speed >= 14) {
            return 3;
        }
        else if (speed < 14 && speed >= 12) {
            return 2.5f;
        }
        else if (speed < 12 && speed >= 10) {
            return 2f;
        }
        else if (speed < 10 && speed >= 8) {
            return 1.5f;
        }
        return 1;
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.lance.tooltip"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.lance_shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(pAttacker instanceof Player player) {
            float amount = (float) (player.getAttributeValue(Attributes.ATTACK_DAMAGE) * dmgWithSpd(player));
            return pTarget.hurt(pAttacker.damageSources().playerAttack(player), amount);
        }
        return true;
    }
}