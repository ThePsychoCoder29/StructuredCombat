package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.custom.SabreItem;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class SabreBlockEvent{

    public static double getDamagePercent(){
        return SabreItem.getDamagePercent();
    }

    @SubscribeEvent
    public static void sabreBlock(ShieldBlockEvent event){
        event.setBlockedDamage((float) (event.getBlockedDamage() * (1 - getDamagePercent())));
    }
}
