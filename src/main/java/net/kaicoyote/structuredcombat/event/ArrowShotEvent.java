package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class ArrowShotEvent {
    private static boolean shotFromBow;
    private static ItemStack bow;

    @SubscribeEvent
    public static void arrowShot(ArrowLooseEvent event){
        Player player = event.getEntity();
        ItemStack item = event.getBow();
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());
        if(stack == item){
            setShotFromBow(true);
            bowStack(stack);
        }
    }

    public static void setShotFromBow(boolean bow) {
        shotFromBow = bow;
    }

    public static boolean getShotFromBow(){
        return shotFromBow;
    }

    public static void bowStack(ItemStack stack){
        bow = stack;
    }

    public static ItemStack getBow(){
        return bow;
    }
}
