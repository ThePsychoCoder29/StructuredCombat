package net.kaicoyote.structuredcombat.enchantment.custom.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ReimbursementEnchantment extends Enchantment {
    public ReimbursementEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
}
