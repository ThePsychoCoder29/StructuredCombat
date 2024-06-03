package net.kaicoyote.structuredcombat.enchantment.custom.enchantments;

import net.kaicoyote.structuredcombat.enchantment.ModEnchantments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChainingEnchantment extends Enchantment {
    public ChainingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        Level level = pAttacker.level();
        AABB area = pTarget.getBoundingBox().inflate(5);
        List<Entity> entities = level.getEntitiesOfClass(Entity.class, area);
        float hurt = 15;
        if(pAttacker instanceof ServerPlayer player){
            if(player.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(ModEnchantments.CHAINING.get()) > 0) {
                for (Entity entity : entities) {
                    if (!(entity == player)) {
                        EntityType.LIGHTNING_BOLT.spawn((ServerLevel) level, entity.blockPosition(), MobSpawnType.TRIGGERED);
                        entity.hurt(entity.damageSources().lightningBolt(), hurt);
                        hurt = (float) (hurt * 0.005);
                    }
                }
            }
        }
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.SWEEPING_EDGE;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
