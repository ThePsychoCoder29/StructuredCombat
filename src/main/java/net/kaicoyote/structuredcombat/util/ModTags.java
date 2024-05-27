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
        public static final TagKey<Item> SMITHING_WEAPONS = tag("smithing_weapons");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(StructuredCombat.MOD_ID, name));

        }
    }
}
