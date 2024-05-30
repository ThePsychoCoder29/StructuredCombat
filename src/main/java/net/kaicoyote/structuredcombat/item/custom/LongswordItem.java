package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class LongswordItem extends Item {
    public LongswordItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.2));
                builder.build();
            }
            if (stack.is(ModItems.STONE_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(8));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.2));
                builder.build();
            }
            if (stack.is(ModItems.IRON_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(10));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.2));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.8));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(12.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_LONGSWORD.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(15));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
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
    public boolean hurtEnemy(@NotNull ItemStack pStack, LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(pTarget.getArmorValue() > 0) {
            MobEffectInstance weakness = new MobEffectInstance(MobEffects.WEAKNESS, 40, 2, true, true, true);
            MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2, true, true, true);
            pTarget.addEffect(weakness);
            pTarget.addEffect(slowness);
        }
        InteractionHand hand = pAttacker.getUsedItemHand();
        pStack.hurtAndBreak(1, pAttacker, user -> user.broadcastBreakEvent(hand));
        return true;
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
