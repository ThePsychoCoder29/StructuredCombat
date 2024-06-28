package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class ArrowKillEvent {
    public static ItemStack bow;
    public static String entityName;
    public static int arrowDropCount;

    @SubscribeEvent
    public static void arrowShot(ArrowLooseEvent event){
        Player player = event.getEntity();
        ItemStack item = event.getBow();
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());
        if(stack == item){
            bow = stack;
        }
    }

    @SubscribeEvent
    public static void arrowKill(LivingDeathEvent event){
        Entity entity = event.getSource().getEntity();
        Random random = new Random();
        int chance = random.nextInt(6);
        if(entity instanceof Player player){
            ItemStack stack = player.getItemInHand(player.getUsedItemHand());
            if(stack == bow){
                LivingEntity killedEntity = event.getEntity();
                if(!(killedEntity instanceof ArmorStand)) {
                    if (killedEntity instanceof Sheep sheep) {
                        entityName = "entities/sheep/" + sheep.getColor().getName();
                    } else {
                        entityName = "entities/" + event.getEntity().getType().getDescription().getString();
                    }
                }
                int level = stack.getEnchantmentLevel(ModEnchantments.REIMBURSEMENT.get());
                if(level > 0){
                    if(level == 1){
                        if(chance == 1){
                            arrowDropCount = 5;
                        }
                    }
                    else if (level == 2) {
                        if(chance < 3){
                            arrowDropCount = 5;
                        }
                    }
                    else if (level == 3) {
                        if(chance < 4){
                            arrowDropCount = 5;
                        }
                    }
                    else if (level == 4) {
                        if(chance < 5){
                            arrowDropCount = 5;
                        }
                    }
                    else {
                        arrowDropCount = 5;
                    }
                }
            }
        }
    }

    public static String getEntityName(){
        return entityName;
        }

    public static int getArrowDropCount(){
        return arrowDropCount;
    }
}

