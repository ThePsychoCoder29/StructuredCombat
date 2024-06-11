package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.effect.ModEffects;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScytheItem extends HoeItem {

    public ScytheItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    @NotNull
    private static List<BlockPos> getBlockPos(BlockPos pos) {
        List<BlockPos> blockPosList = new ArrayList<>();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        blockPosList.add(new BlockPos(x, y, z));
        blockPosList.add(new BlockPos(x + 1, y, z));
        blockPosList.add(new BlockPos(x - 1, y, z));
        blockPosList.add(new BlockPos(x, y, z + 1));
        blockPosList.add(new BlockPos(x, y, z - 1));
        blockPosList.add(new BlockPos(x + 1, y, z + 1));
        blockPosList.add(new BlockPos(x - 1, y, z - 1));
        blockPosList.add(new BlockPos(x - 1, y, z + 1));
        blockPosList.add(new BlockPos(x + 1, y, z - 1));
        return blockPosList;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity pMiningEntity) {
        stack.hurtAndBreak(1, pMiningEntity, user -> user.broadcastBreakEvent(pMiningEntity.getUsedItemHand()));
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.STONE_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.IRON_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(9));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.6));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(10.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.8));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(13));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.8));
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
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.scythe.tooltip"));
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
        if (pState.is(BlockTags.MINEABLE_WITH_HOE)) {
            return 15.0F;
        }
        else {
            return 1.5F;
        }
    }

    public void applyBleeding(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker){
        InteractionHand hand = pAttacker.getUsedItemHand();
        MobEffect effect = ModEffects.BLEEDING_EFFECT.get();
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(hand));
        MobEffectInstance scytheEffect = new MobEffectInstance(ModEffects.BLEEDING_EFFECT.get(), 140, 1, false, false, true);
        pTarget.addEffect(scytheEffect);
        if(pTarget.hasEffect(effect)){
            MobEffectInstance bleedingEffect = pTarget.getEffect(effect);
            assert bleedingEffect != null;
            if((bleedingEffect).getAmplifier() > 0){
                int amplifier = bleedingEffect.getAmplifier();
                if(amplifier == 1){
                    pAttacker.sendSystemMessage(Component.literal("bleeding"));
                }
            }
        }
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker){
        applyBleeding(pStack, pTarget, pAttacker);
        return true;
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction) || super.canPerformAction(stack, toolAction);
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
