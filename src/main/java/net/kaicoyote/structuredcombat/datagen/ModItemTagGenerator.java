package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, StructuredCombat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.SMITHING_WEAPONS)
                .add(ModItems.IRON_DAGGER.get())
                .add(ModItems.IRON_HATCHET.get())
                .add(ModItems.IRON_KATANA.get())
                .add(ModItems.IRON_SABRE.get());
    }
}
