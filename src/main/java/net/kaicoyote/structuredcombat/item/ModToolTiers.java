package net.kaicoyote.structuredcombat.item;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import java.util.List;

public class ModToolTiers {
    public static final Tier WOODEN = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 15 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            new ResourceLocation(StructuredCombat.MOD_ID, "wood"), List.of(Tiers.WOOD), List.of());
    public static final Tier STONE = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 5 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)),
            new ResourceLocation(StructuredCombat.MOD_ID, "stone"), List.of(Tiers.STONE), List.of());
    public static final Tier IRON = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 14 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(StructuredCombat.MOD_ID, "iron"), List.of(Tiers.IRON), List.of());
    public static final Tier GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 22 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(StructuredCombat.MOD_ID, "gold"), List.of(Tiers.GOLD), List.of());
    public static final Tier DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 10 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(Items.DIAMOND)),
            new ResourceLocation(StructuredCombat.MOD_ID, "diamond"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier NETHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(0, 0, 0, 0, 15 , ModTags.Blocks.NEEDS_STRUCTURED_COMBAT_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT)),
            new ResourceLocation(StructuredCombat.MOD_ID, "netherite"), List.of(Tiers.NETHERITE), List.of());
}
