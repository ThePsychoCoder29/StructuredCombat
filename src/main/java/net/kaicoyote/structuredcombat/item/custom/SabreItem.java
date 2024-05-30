package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public class SabreItem extends Item {
    public SabreItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.BLOCK;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.SWORD_SWEEP.equals(toolAction);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0.5));
                builder.build();
            }
            if (stack.is(ModItems.STONE_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0.5));
                builder.build();
            }
            if (stack.is(ModItems.IRON_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0.5));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0.5));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6.25));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_SABRE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(0));
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
    public void onUseTick(@NotNull Level pLevel, @NotNull LivingEntity pLivingEntity, @NotNull ItemStack pStack, int pRemainingUseDuration) {
        if(pLivingEntity instanceof Player player){
            int duration = this.getUseDuration(pStack) - pRemainingUseDuration;
            if(duration >= 20 && duration <= 40){
                player.sendSystemMessage(Component.literal("20-40"));
                player.setAbsorptionAmount(100);
            }
            if(duration >= 40 && duration <= 60){
                player.sendSystemMessage(Component.literal("40-60"));
            }
            if(duration >= 60 && duration <= 80){
                player.sendSystemMessage(Component.literal("60-80"));
            }
        }
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
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