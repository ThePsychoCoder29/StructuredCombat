package net.kaicoyote.structuredcombat.enchantment.custom.curse;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.List;

public class CurseOfHandling extends Enchantment {
    public CurseOfHandling(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if(!pTarget.level().isClientSide()){
            if(pTarget instanceof AbstractHorse horse){
                List<Entity> entities =  horse.getPassengers();
                for(Entity entity : entities){
                    entity.hurt(horse.damageSources().generic(), pLevel);
                }
            }
        }
    }
}
