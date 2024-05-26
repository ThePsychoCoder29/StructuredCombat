package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class AnvilRecipeEvent {

    @SubscribeEvent
    public static void ironDaggerUpgradeEvent(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        boolean diamondUpgrade = left.is(ModItems.DIAMOND_UPGRADE.get()) || right.is(ModItems.DIAMOND_UPGRADE.get());
        boolean netheriteUpgrade = left.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE) || right.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        boolean ironDagger = left.is(ModItems.IRON_DAGGER.get()) || right.is(ModItems.IRON_DAGGER.get());
        boolean diamondDagger = left.is(ModItems.DIAMOND_DAGGER.get()) || right.is(ModItems.DIAMOND_DAGGER.get());
        if (diamondUpgrade && ironDagger) {
            event.setOutput(new ItemStack(ModItems.DIAMOND_DAGGER.get(), 1));
            event.setCost(5);
        }
        if (netheriteUpgrade && diamondDagger) {
            event.setOutput(new ItemStack(ModItems.NETHERITE_DAGGER.get(), 1));
            event.setCost(10);
        }
    }

    @SubscribeEvent
    public static void ironHatchetUpgradeEvent(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        boolean diamondUpgrade = left.is(ModItems.DIAMOND_UPGRADE.get()) || right.is(ModItems.DIAMOND_UPGRADE.get());
        boolean netheriteUpgrade = left.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE) || right.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        boolean ironHatchet = left.is(ModItems.IRON_HATCHET.get()) || right.is(ModItems.IRON_HATCHET.get());
        boolean diamondHatchet = left.is(ModItems.DIAMOND_HATCHET.get()) || right.is(ModItems.DIAMOND_HATCHET.get());
        if (diamondUpgrade && ironHatchet) {
            event.setOutput(new ItemStack(ModItems.DIAMOND_HATCHET.get(), 1));
            event.setCost(5);
        }
        if (netheriteUpgrade && diamondHatchet) {
            event.setOutput(new ItemStack(ModItems.NETHERITE_HATCHET.get(), 1));
            event.setCost(10);
        }
    }

    @SubscribeEvent
    public static void ironKatanaUpgradeEvent(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        boolean diamondUpgrade = left.is(ModItems.DIAMOND_UPGRADE.get()) || right.is(ModItems.DIAMOND_UPGRADE.get());
        boolean netheriteUpgrade = left.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE) || right.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        boolean ironKatana = left.is(ModItems.IRON_KATANA.get()) || right.is(ModItems.IRON_KATANA.get());
        boolean diamondKatana = left.is(ModItems.DIAMOND_KATANA.get()) || right.is(ModItems.DIAMOND_KATANA.get());
        if (diamondUpgrade && ironKatana) {
            event.setOutput(new ItemStack(ModItems.DIAMOND_KATANA.get(), 1));
            event.setCost(5);
        }
        if (netheriteUpgrade && diamondKatana) {
            event.setOutput(new ItemStack(ModItems.NETHERITE_KATANA.get(), 1));
            event.setCost(10);
        }
    }
}
