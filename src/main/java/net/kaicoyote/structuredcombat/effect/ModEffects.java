package net.kaicoyote.structuredcombat.effect;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.effect.custom.BleedingEffect;
import net.kaicoyote.structuredcombat.effect.custom.ParalyzeEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, StructuredCombat.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING_EFFECT = EFFECTS.register("bleeding",
            ()-> new BleedingEffect(MobEffectCategory.HARMFUL, 11141120));
    public static final RegistryObject<MobEffect> PARALYZE_EFFECT = EFFECTS.register("paralyze",
            ()-> new ParalyzeEffect(MobEffectCategory.HARMFUL, 11141120).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", 0 , AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }

}
