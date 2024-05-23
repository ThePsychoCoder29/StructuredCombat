package net.kaicoyote.structuredcombat.util;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StructuredCombat.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEMS_CREATIVE_MODE_TAB =
        CREATIVE_MODE_TABS.register("items_creative_mode_tab",
                ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.WOODEN_DAGGER.get()))
                        .title(Component.translatable("creativetab.structuredcombat.tab"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            //Daggers
                            output.accept(ModItems.WOODEN_DAGGER.get());
                            output.accept(ModItems.STONE_DAGGER.get());
                            output.accept(ModItems.IRON_DAGGER.get());
                            output.accept(ModItems.GOLD_DAGGER.get());
                            output.accept(ModItems.DIAMOND_DAGGER.get());
                            output.accept(ModItems.NETHERITE_DAGGER.get());
                            //Hatchets
                            output.accept(ModItems.WOODEN_HATCHET.get());
                            output.accept(ModItems.STONE_HATCHET.get());
                            output.accept(ModItems.IRON_HATCHET.get());
                            output.accept(ModItems.GOLD_HATCHET.get());
                            output.accept(ModItems.DIAMOND_HATCHET.get());
                            output.accept(ModItems.NETHERITE_HATCHET.get());
                        }))
                        .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
