package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.custom.LanceItem;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3d;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class PlayerSpeedEvent {

    @SubscribeEvent
    public static void playerSpeed(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if(stack.is(ModTags.Items.SPEED_LANCES)) {
            Vector3d lastPos = new Vector3d(player.xOld, player.yOld, player.zOld);
            Vector3d pos = new Vector3d(player.getX(), player.getY(), player.getZ());
            LanceItem.setSpd((float) Math.abs(lastPos.distance(pos) * 20));
        }
    }
}
