package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.particle.ModParticleTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LanceItem extends SwordItem {

    private static float spd = 0;

    public LanceItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.STONE_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.IRON_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.6));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.2));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_LANCE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
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

    public static void setSpd(float amt){
        spd = amt;
    }

    public float getDmg(){
        float damage = spd;
        float multiplier = damage - 6;
        if (multiplier >= 8) {
            return 4;
        }
        else if (multiplier <= 0) {
            return 1;
        }
        else {
            return (float) ((multiplier * 0.25) + 1);
        }
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
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(pAttacker instanceof Player player) {
            Level level = pTarget.level();
            int x = pTarget.getBlockX();
            int y = pTarget.getBlockY();
            int z = pTarget.getBlockZ();
            pStack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(player.getUsedItemHand()));
            float amount = (float) (player.getAttributeValue(Attributes.ATTACK_DAMAGE) * getDmg());
            if(getDmg() >= 4){
                for(int i = 0; i < 360; i++) {
                    if(i % 20 == 0) {
                        level.addParticle(ModParticleTypes.LANCE_MAX_DAMAGE.get(),
                                x, y + 1, z,
                                Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
                    }
                }            }
            return pTarget.hurt(pAttacker.damageSources().playerAttack(player), amount);
        }
        pStack.hurtAndBreak(1, pAttacker, user -> user.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        return true;
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return false;
    }
}