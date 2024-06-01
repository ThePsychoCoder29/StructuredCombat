package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.client.ModModelLayers;
import net.kaicoyote.structuredcombat.entity.custom.models.DaggerModel;
import net.kaicoyote.structuredcombat.entity.custom.models.HatchetModel;
import net.kaicoyote.structuredcombat.entity.custom.models.SpearWithGuardModel;
import net.kaicoyote.structuredcombat.entity.custom.models.SpearWithoutGuardModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityLayerRegisterEvent {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        //Daggers
        event.registerLayerDefinition(ModModelLayers.WOODEN_DAGGER, DaggerModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.STONE_DAGGER, DaggerModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_DAGGER, DaggerModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.GOLD_DAGGER, DaggerModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.DIAMOND_DAGGER, DaggerModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.NETHERITE_DAGGER, DaggerModel::createLayer);

        //Hatchets
        event.registerLayerDefinition(ModModelLayers.WOODEN_HATCHET, HatchetModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.STONE_HATCHET, HatchetModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_HATCHET, HatchetModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.GOLD_HATCHET, HatchetModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.DIAMOND_HATCHET, HatchetModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.NETHERITE_HATCHET, HatchetModel::createLayer);

        //Spears
        event.registerLayerDefinition(ModModelLayers.WOODEN_SPEAR, SpearWithoutGuardModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.STONE_SPEAR, SpearWithoutGuardModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_SPEAR, SpearWithGuardModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.GOLD_SPEAR, SpearWithGuardModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.DIAMOND_SPEAR, SpearWithGuardModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.NETHERITE_SPEAR, SpearWithGuardModel::createLayer);
    }
}
