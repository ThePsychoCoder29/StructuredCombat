package net.kaicoyote.structuredcombat.util;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(StructuredCombat.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> CRIT_KATANAS = tag("crit_katanas");
        public static final TagKey<Item> PILLAGER_SABRES = tag("pillager_sabres");
        public static final TagKey<Item> VINDICATOR_HATCHETS = tag("vindicator_hatchets");
        public static final TagKey<Item> DROWNED_SPEARS = tag("drowned_spears");
        public static final TagKey<Item> DRAGON_LONGSWORDS = tag("dragon_longswords");
        public static final TagKey<Item> SPEED_LANCES = tag("speed_lances");
        public static final TagKey<Item> CROP_SCYTHES = tag("crop_scythes");
        public static final TagKey<Item> WOODEN_TOOLS = tag("wooden_tools");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(StructuredCombat.MOD_ID, name));

        }
    }
}
