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
                ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.DIAMOND_UPGRADE.get()))
                        .title(Component.translatable("creativetab.structuredcombat.tab"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            //Items
                            output.accept(ModItems.DIAMOND_UPGRADE.get());

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

                            //Katanas
                            output.accept(ModItems.WOODEN_KATANA.get());
                            output.accept(ModItems.STONE_KATANA.get());
                            output.accept(ModItems.IRON_KATANA.get());
                            output.accept(ModItems.GOLD_KATANA.get());
                            output.accept(ModItems.DIAMOND_KATANA.get());
                            output.accept(ModItems.NETHERITE_KATANA.get());

                            //Sabres
                            output.accept(ModItems.WOODEN_SABRE.get());
                            output.accept(ModItems.STONE_SABRE.get());
                            output.accept(ModItems.IRON_SABRE.get());
                            output.accept(ModItems.GOLD_SABRE.get());
                            output.accept(ModItems.DIAMOND_SABRE.get());
                            output.accept(ModItems.NETHERITE_SABRE.get());
                        }))
                        .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
