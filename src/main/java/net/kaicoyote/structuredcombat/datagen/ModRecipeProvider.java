package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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
                .define('P',  Items.OAK_PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_DAGGER.get())
                .pattern("   ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C',  Items.STONE)
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

        //Hatchets
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_HATCHET.get())
                .pattern("PP")
                .pattern("S ")
                .define('P',  Items.OAK_PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HATCHET.get())
                .pattern("CC")
                .pattern("S ")
                .define('C',  Items.STONE)
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

        //Katanas
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_KATANA.get())
                .pattern("  P")
                .pattern(" P ")
                .pattern("S  ")
                .define('P',  Items.OAK_PLANKS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.STICK))
                .showNotification(true)
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_KATANA.get())
                .pattern("  C")
                .pattern(" C ")
                .pattern("S  ")
                .define('C',  Items.STONE)
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
}