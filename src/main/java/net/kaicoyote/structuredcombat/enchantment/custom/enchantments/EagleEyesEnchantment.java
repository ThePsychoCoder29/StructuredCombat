package net.kaicoyote.structuredcombat.enchantment.custom.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EagleEyesEnchantment extends Enchantment {
    public EagleEyesEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return super.getMaxCost(pLevel);
    }
}
