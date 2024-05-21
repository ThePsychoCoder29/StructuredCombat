package net.kaicoyote.structuredcombat;

import com.mojang.logging.LogUtils;
import net.kaicoyote.structuredcombat.block.ModBlocks;
import net.kaicoyote.structuredcombat.entity.ModEntities;
import net.kaicoyote.structuredcombat.entity.client.renderer.*;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.util.ModCreativeModeTabs;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StructuredCombat.MOD_ID)
public class StructuredCombat
{
    public static final String MOD_ID = "structuredcombat";
    private static final Logger LOGGER = LogUtils.getLogger();

    public StructuredCombat()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.WOODEN_DAGGER.get(), WoodenDaggerRenderer::new);
            EntityRenderers.register(ModEntities.STONE_DAGGER.get(), StoneDaggerRenderer::new);
            EntityRenderers.register(ModEntities.IRON_DAGGER.get(), IronDaggerRenderer::new);
            EntityRenderers.register(ModEntities.GOLD_DAGGER.get(), GoldDaggerRenderer::new);
            EntityRenderers.register(ModEntities.DIAMOND_DAGGER.get(), DiamondDaggerRenderer::new);
            EntityRenderers.register(ModEntities.NETHERITE_DAGGER.get(), NetheriteDaggerRenderer::new);
        }
    }
}