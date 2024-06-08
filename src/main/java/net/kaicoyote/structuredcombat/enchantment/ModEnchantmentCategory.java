package net.kaicoyote.structuredcombat.enchantment;

import net.kaicoyote.structuredcombat.item.custom.*;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ModEnchantmentCategory {
    public static EnchantmentCategory PROJECTILE = EnchantmentCategory.create("recall", (item) -> item instanceof HatchetItem || item instanceof DaggerItem || item instanceof SpearItem);
    public static EnchantmentCategory BOW_AND_CROSSBOW = EnchantmentCategory.create("bow", (item) -> item instanceof ProjectileWeaponItem);
    public static EnchantmentCategory ALL_WEAPONS = EnchantmentCategory.create("all_weapons", (item) -> item instanceof DaggerItem || item instanceof HatchetItem || item instanceof KatanaItem || item instanceof LabrysItem || item instanceof LanceItem || item instanceof LongswordItem || item instanceof SabreItem || item instanceof ScytheItem || item instanceof SpearItem);
    public static EnchantmentCategory SWORDS_AND_AXES = EnchantmentCategory.create("swords_and_axes", (item) -> item instanceof SwordItem || item instanceof AxeItem);
}
