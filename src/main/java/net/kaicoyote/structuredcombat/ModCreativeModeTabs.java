package net.kaicoyote.structuredcombat;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.betterzoos.BetterZoos;
import net.mrmisc.betterzoos.block.ModBlocks;
import net.mrmisc.betterzoos.item.ModItems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterZoos.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEMS_CREATIVE_MODE_TAB =
        CREATIVE_MODE_TABS.register("items_creative_mode_tab",
                ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Items.DIAMOND))
                        .title(Component.translatable("creativetab.betterzoos.tab_item"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            output.accept(ModItems.VILLAGER_LEAD.get());
                            output.accept(ModItems.TURKEY_LEG.get());
                            output.accept(ModItems.TRANQUILIZER_DART.get());
                        }))
                        .build());
    public static final RegistryObject<CreativeModeTab> BLOCKS_CREATIVE_MODE_TAB =
        CREATIVE_MODE_TABS.register("blocks_creative_mode_tab",
                ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Blocks.GRASS_BLOCK))
                        .title(Component.translatable("creativetab.betterzoos.tab_blocks"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            output.accept(ModBlocks.ZOO_GLASS.get());
                        }))
                        .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
