package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.custom.LanceItem;
import net.kaicoyote.structuredcombat.util.ModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
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
            if(player.isPassenger() && player.getVehicle() != null){
                LivingEntity entity = (LivingEntity) player.getVehicle();
                float speed = getSpeed(entity);
                LanceItem.setSpd(speed);
            }
            else {
                float speed = getSpeed(player);
                LanceItem.setSpd(speed);
            }
        }
    }

    public static float getSpeed(LivingEntity entity){
        Vector3d lastPos = new Vector3d(entity.xOld, entity.yOld, entity.zOld);
        Vector3d pos = new Vector3d(entity.getX(), entity.getY(), entity.getZ());
        return (float) Math.abs(lastPos.distance(pos) * 20);
    }
}
