package net.kaicoyote.structuredcombat.effect;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.effect.custom.BleedingEffect;
import net.kaicoyote.structuredcombat.effect.custom.LabrysSpinEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, StructuredCombat.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING_EFFECT = EFFECTS.register("bleeding",
            ()-> new BleedingEffect(MobEffectCategory.HARMFUL, 11141120));

    public static final RegistryObject<MobEffect> LABRYS_SPIN = EFFECTS.register("labrys_spin",
            ()-> new LabrysSpinEffect(MobEffectCategory.HARMFUL, 11141120));

    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }

}
