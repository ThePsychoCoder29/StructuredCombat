package net.kaicoyote.structuredcombat.enchantment.custom.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

public class ReimbursementEnchantment extends Enchantment {
    public ReimbursementEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return pOther != Enchantments.INFINITY_ARROWS;
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
