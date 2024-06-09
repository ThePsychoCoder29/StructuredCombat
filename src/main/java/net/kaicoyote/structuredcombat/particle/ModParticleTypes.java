package net.kaicoyote.structuredcombat.particle;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, StructuredCombat.MOD_ID);

    public static final RegistryObject<SimpleParticleType> LANCE_MAX_DAMAGE =
            PARTICLE_TYPES.register("lance_max_damage", ()-> new SimpleParticleType(true));

    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
