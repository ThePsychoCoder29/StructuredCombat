package net.kaicoyote.structuredcombat.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import org.jetbrains.annotations.NotNull;

public class LabrysSpinEffect extends MobEffect {
    public LabrysSpinEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void addAttributeModifiers(LivingEntity pLivingEntity, @NotNull AttributeMap pAttributeMap, int pAmplifier) {
        pLivingEntity.setYBodyRot(0);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, @NotNull AttributeMap pAttributeMap, int pAmplifier) {
        pLivingEntity.setYBodyRot(0);
    }
}
