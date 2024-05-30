package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class KatanaCriticalHitEvent {
    @SubscribeEvent
    public static void katanaCritHit(CriticalHitEvent event){
        ItemStack stack = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND);
        if(event.isVanillaCritical() && stack.is(ModTags.Items.CRIT_KATANAS)){
            event.setDamageModifier(2f);
        }
    }
}
