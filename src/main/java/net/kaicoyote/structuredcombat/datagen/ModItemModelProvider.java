package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        //Sabres
        handHeldItem(ModItems.WOODEN_SPEAR);
        handHeldItem(ModItems.STONE_SPEAR);
        handHeldItem(ModItems.IRON_SPEAR);
        handHeldItem(ModItems.GOLD_SPEAR);
        handHeldItem(ModItems.DIAMOND_SPEAR);
        handHeldItem(ModItems.NETHERITE_SPEAR);

        //Items
        handHeldItem(ModItems.DIAMOND_UPGRADE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StructuredCombat.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StructuredCombat.MOD_ID,"block/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(StructuredCombat.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(StructuredCombat.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(StructuredCombat.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(StructuredCombat.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StructuredCombat.MOD_ID,"item/" + item.getId().getPath()));
    }
}
