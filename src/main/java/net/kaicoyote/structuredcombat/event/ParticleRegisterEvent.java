package net.kaicoyote.structuredcombat.event;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.particle.ModParticleTypes;
import net.kaicoyote.structuredcombat.particle.custom.LanceMaxDamageParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StructuredCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegisterEvent {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticleTypes.LANCE_MAX_DAMAGE.get(), LanceMaxDamageParticles.Provider::new);
    }
}
