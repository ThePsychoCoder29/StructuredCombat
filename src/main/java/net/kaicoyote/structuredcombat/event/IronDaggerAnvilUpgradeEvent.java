package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class IronDaggerAnvilUpgradeEvent {
    @SubscribeEvent
    public static void ironDaggerUpgradeEvent(AnvilUpdateEvent event){
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        boolean diamondUpgrade = left.is(ModItems.DIAMOND_UPGRADE.get()) || right.is(ModItems.DIAMOND_UPGRADE.get());
        boolean netheriteUpgrade = left.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE) || right.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        boolean ironDagger = left.is(ModItems.IRON_DAGGER.get()) || right.is(ModItems.IRON_DAGGER.get());
        if(diamondUpgrade && ironDagger) {
            event.setOutput(new ItemStack(ModItems.DIAMOND_DAGGER.get()));
        }
        if(netheriteUpgrade && ironDagger){
            event.setOutput(new ItemStack(ModItems.NETHERITE_DAGGER.get()));
        }
    }
}
