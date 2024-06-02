package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.effect.ModEffects;
import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID)
public class ParalyzeTargetOnCriticalHitEvent {
    @SubscribeEvent
    public static void paralyze(CriticalHitEvent event){
        Player player = event.getEntity();
        LivingEntity target = (LivingEntity) event.getTarget();
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        int paralyzeEnchantmentValue = stack.getEnchantmentLevel(ModEnchantments.PARALYZED.get());
        MobEffectInstance paralyze = new MobEffectInstance(ModEffects.PARALYZE_EFFECT.get(), 30, 1, false, false, false);
        boolean isCrit = event.isVanillaCritical();
        Random random = new Random();
        int chance = random.nextInt(5);
        if(isCrit){
            if(paralyzeEnchantmentValue == 1){
                if(chance == 1){
                    target.addEffect(paralyze);
                }
            }
            else if (paralyzeEnchantmentValue == 2) {
                if(chance < 3) {
                    target.addEffect(paralyze);
                }

            }
            else if (paralyzeEnchantmentValue == 3) {
                if(chance != 4){
                    target.addEffect(paralyze);
                }
            }
        }
    }
}
