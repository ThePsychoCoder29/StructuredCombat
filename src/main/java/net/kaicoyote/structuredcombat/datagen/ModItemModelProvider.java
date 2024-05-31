package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StructuredCombat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Daggers
        handHeldItem(ModItems.WOODEN_DAGGER);
        handHeldItem(ModItems.STONE_DAGGER);
        handHeldItem(ModItems.IRON_DAGGER);
        handHeldItem(ModItems.GOLD_DAGGER);
        handHeldItem(ModItems.DIAMOND_DAGGER);
        handHeldItem(ModItems.NETHERITE_DAGGER);

        //Hatchets
        handHeldItem(ModItems.WOODEN_HATCHET);
        handHeldItem(ModItems.STONE_HATCHET);
        handHeldItem(ModItems.IRON_HATCHET);
        handHeldItem(ModItems.GOLD_HATCHET);
        handHeldItem(ModItems.DIAMOND_HATCHET);
        handHeldItem(ModItems.NETHERITE_HATCHET);

        //Katanas
        handHeldItem(ModItems.WOODEN_KATANA);
        handHeldItem(ModItems.STONE_KATANA);
        handHeldItem(ModItems.IRON_KATANA);
        handHeldItem(ModItems.GOLD_KATANA);
        handHeldItem(ModItems.DIAMOND_KATANA);
        handHeldItem(ModItems.NETHERITE_KATANA);

        //Sabres
        handHeldItem(ModItems.WOODEN_SABRE);
        handHeldItem(ModItems.STONE_SABRE);
        handHeldItem(ModItems.IRON_SABRE);
        handHeldItem(ModItems.GOLD_SABRE);
        handHeldItem(ModItems.DIAMOND_SABRE);
        handHeldItem(ModItems.NETHERITE_SABRE);

        //Spears
        //Manually done due to small size in hand

        //Longswords
        handHeldItem(ModItems.WOODEN_LONGSWORD);
        handHeldItem(ModItems.STONE_LONGSWORD);
        handHeldItem(ModItems.IRON_LONGSWORD);
        handHeldItem(ModItems.GOLD_LONGSWORD);
        handHeldItem(ModItems.DIAMOND_LONGSWORD);
        handHeldItem(ModItems.NETHERITE_LONGSWORD);

        //Scythe
        handHeldItem(ModItems.WOODEN_SCYTHE);
        handHeldItem(ModItems.STONE_SCYTHE);
        handHeldItem(ModItems.IRON_SCYTHE);
        handHeldItem(ModItems.GOLD_SCYTHE);
        handHeldItem(ModItems.DIAMOND_SCYTHE);
        handHeldItem(ModItems.NETHERITE_SCYTHE);

        //Items
        simpleItem(ModItems.DIAMOND_UPGRADE);
        simpleItem(ModItems.STRUCTURED_COMBAT_LOGO);
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StructuredCombat.MOD_ID, "item/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    public ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(StructuredCombat.MOD_ID, "item/" + item.getId().getPath()));
    }
}
