package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        //Daggers
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_DAGGER.get())
                .pattern("   ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_DAGGER.get())
                .pattern("   ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C',  ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_DAGGER.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern(" S ")
                .define('G',  Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        smithingTableRecipeDiamond(ModItems.IRON_DAGGER.get(), ModItems.DIAMOND_DAGGER.get(), pWriter, "diamond_dagger");
        smithingTableRecipeNetherite(ModItems.DIAMOND_DAGGER.get(), ModItems.NETHERITE_DAGGER.get(), pWriter, "netherite_dagger");

        //Hatchets
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_HATCHET.get())
                .pattern("PP")
                .pattern("S ")
                .define('P',  ItemTags.PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HATCHET.get())
                .pattern("CC")
                .pattern("S ")
                .define('C',  ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_HATCHET.get())
                .pattern("GG")
                .pattern("S ")
                .define('G',  Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        smithingTableRecipeDiamond(ModItems.IRON_HATCHET.get(), ModItems.DIAMOND_HATCHET.get(), pWriter, "diamond_hatchet");
        smithingTableRecipeNetherite(ModItems.DIAMOND_HATCHET.get(), ModItems.NETHERITE_HATCHET.get(), pWriter, "netherite_hatchet");

        //Katanas
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_KATANA.get())
                .pattern("  P")
                .pattern(" P ")
                .pattern("S  ")
                .define('P',  ItemTags.PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_KATANA.get())
                .pattern("  C")
                .pattern(" C ")
                .pattern("S  ")
                .define('C',  ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_KATANA.get())
                .pattern("  G")
                .pattern(" G ")
                .pattern("S  ")
                .define('G',  Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);

        smithingTableRecipeDiamond(ModItems.IRON_KATANA.get(), ModItems.DIAMOND_KATANA.get(), pWriter, "diamond_katana");
        smithingTableRecipeNetherite(ModItems.DIAMOND_KATANA.get(), ModItems.NETHERITE_KATANA.get(), pWriter, "netherite_katana");

        //Sabres
//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_SABRE.get())
//                .pattern("  P")
//                .pattern(" P ")
//                .pattern("S  ")
//                .define('P',  ItemTags.PLANKS)
//                .define('S', Items.STICK)
//                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
//                .showNotification(true)
//                .save(pWriter);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_SABRE.get())
//                .pattern("  C")
//                .pattern(" C ")
//                .pattern("S  ")
//                .define('C',  ItemTags.STONE_TOOL_MATERIALS)
//                .define('S', Items.STICK)
//                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
//                .showNotification(true)
//                .save(pWriter);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_SABRE.get())
//                .pattern("  G")
//                .pattern(" G ")
//                .pattern("S  ")
//                .define('G',  Items.GOLD_INGOT)
//                .define('S', Items.STICK)
//                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
//                .showNotification(true)
//                .save(pWriter);

        smithingTableRecipeDiamond(ModItems.IRON_SABRE.get(), ModItems.DIAMOND_SABRE.get(), pWriter, "diamond_sabre");
        smithingTableRecipeNetherite(ModItems.DIAMOND_SABRE.get(), ModItems.NETHERITE_SABRE.get(), pWriter, "netherite_sabre");

        //Items
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE.get(), 2)
                .pattern("ESE")
                .pattern("EUE")
                .pattern("EDE")
                .define('E', Items.EMERALD)
                .define('S', Items.STONE_BRICKS)
                .define('D', Items.DIAMOND)
                .define('U', ModItems.DIAMOND_UPGRADE.get())
                .unlockedBy(getHasName(Items.EMERALD), has(ModItems.DIAMOND_UPGRADE.get()))
                .showNotification(true)
                .save(pWriter);

    }

    @SuppressWarnings("UnusedReturnValue")
    public static void smithingTableRecipeDiamond(Item input, Item output, Consumer<FinishedRecipe> writer, String name){
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.DIAMOND_UPGRADE.get()),
                Ingredient.of(input),
                Ingredient.of(Items.DIAMOND),
                RecipeCategory.TOOLS,
                output
            )
                .unlocks(getHasName(ModItems.DIAMOND_UPGRADE.get()), has(ModTags.Items.SMITHING_WEAPONS))
                .save(writer, name + "_from_smithing_table");
    }
    @SuppressWarnings("UnusedReturnValue")
    public static void smithingTableRecipeNetherite(Item input, Item output, Consumer<FinishedRecipe> writer, String name){
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(input),
                Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS,
                output
            )
                .unlocks(getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), has(ModTags.Items.SMITHING_WEAPONS))
                .save(writer, name + "_from_smithing_table");
    }
}