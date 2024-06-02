package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;
public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, StructuredCombat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        this.tag(ModTags.Items.CRIT_KATANAS)
                .add(ModItems.WOODEN_KATANA.get())
                .add(ModItems.STONE_KATANA.get())
                .add(ModItems.IRON_KATANA.get())
                .add(ModItems.GOLD_KATANA.get())
                .add(ModItems.DIAMOND_KATANA.get())
                .add(ModItems.NETHERITE_KATANA.get());

        this.tag(ModTags.Items.PILLAGER_SABRES)
                .add(ModItems.WOODEN_SABRE.get())
                .add(ModItems.STONE_SABRE.get())
                .add(ModItems.IRON_SABRE.get())
                .add(ModItems.GOLD_SABRE.get())
                .add(ModItems.DIAMOND_SABRE.get())
                .add(ModItems.NETHERITE_SABRE.get());

        this.tag(ModTags.Items.VINDICATOR_HATCHETS)
                .add(ModItems.WOODEN_HATCHET.get())
                .add(ModItems.STONE_HATCHET.get())
                .add(ModItems.IRON_HATCHET.get())
                .add(ModItems.GOLD_HATCHET.get())
                .add(ModItems.DIAMOND_HATCHET.get())
                .add(ModItems.NETHERITE_HATCHET.get());

        this.tag(ModTags.Items.DROWNED_SPEARS)
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.STONE_SPEAR.get())
                .add(ModItems.IRON_SPEAR.get())
                .add(ModItems.GOLD_SPEAR.get())
                .add(ModItems.DIAMOND_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get());

        this.tag(ModTags.Items.SPEED_LANCES)
                .add(ModItems.WOODEN_LANCE.get())
                .add(ModItems.STONE_LANCE.get())
                .add(ModItems.IRON_LANCE.get())
                .add(ModItems.GOLD_LANCE.get())
                .add(ModItems.DIAMOND_LANCE.get())
                .add(ModItems.NETHERITE_LANCE.get());

        this.tag(ModTags.Items.DRAGON_LONGSWORDS)
                .add(ModItems.WOODEN_LONGSWORD.get())
                .add(ModItems.STONE_LONGSWORD.get())
                .add(ModItems.IRON_LONGSWORD.get())
                .add(ModItems.GOLD_LONGSWORD.get())
                .add(ModItems.DIAMOND_LONGSWORD.get())
                .add(ModItems.NETHERITE_LONGSWORD.get());

        this.tag(ModTags.Items.WOODEN_TOOLS)
                .add(ModItems.WOODEN_DAGGER.get())
                .add(ModItems.WOODEN_HATCHET.get())
                .add(ModItems.WOODEN_KATANA.get())
                .add(ModItems.WOODEN_SABRE.get())
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.WOODEN_LONGSWORD.get())
                .add(ModItems.WOODEN_SCYTHE.get());

        this.tag(ModTags.Items.CROP_SCYTHES)
                .add(ModItems.WOODEN_SCYTHE.get())
                .add(ModItems.STONE_SCYTHE.get())
                .add(ModItems.IRON_SCYTHE.get())
                .add(ModItems.GOLD_SCYTHE.get())
                .add(ModItems.DIAMOND_SCYTHE.get())
                .add(ModItems.NETHERITE_SCYTHE.get());
    }
}
