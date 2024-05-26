package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KatanaItem extends Item {

    public KatanaItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
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

    public AttributeModifier attributeDmg(double amountDmg){
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }
    public AttributeModifier attributeSpd(double amountSpd){
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        boolean shieldCheck = pTarget.isBlocking();
        if(pTarget.getArmorSlots().iterator().hasNext() && shieldCheck) {
            pStack.hurtAndBreak(3, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        }
        else if(pTarget.getArmorSlots().iterator().hasNext()){
            pStack.hurtAndBreak(2, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        }
        else if (shieldCheck) {
            pStack.hurtAndBreak(3, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        }
        else {
            pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        }
        return true;
    }
}
