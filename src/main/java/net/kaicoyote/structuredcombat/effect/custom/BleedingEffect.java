package net.kaicoyote.structuredcombat.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class BleedingEffect extends MobEffect {
    public static int durationTick = 20;
    public BleedingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.hurt(pLivingEntity.damageSources().magic(), 1);
    }
    @Override
    public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
    }

    public static int returnTickDuration(){
        return durationTick;
    }

    public static void setTickDuration(int duration){
        durationTick = duration % 2;
    }

    public static int getTickDuration() {
        return durationTick;
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return getTickDuration() == 0;
    }
}
