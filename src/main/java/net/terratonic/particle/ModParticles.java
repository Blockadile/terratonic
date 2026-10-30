package net.terratonic.particle;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;

public class ModParticles {

    public static final SimpleParticleType COIN_SPIN =
            registerParticle("coin_spin", FabricParticleTypes.simple(true));
    public static final SimpleParticleType SPARK_PARTICLE =
            registerParticle("spark_particle", FabricParticleTypes.simple(true));
    public static final SimpleParticleType SMALL_SPARK_PARTICLE =
            registerParticle("small_spark_particle", FabricParticleTypes.simple(true));

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Terratonic.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        Terratonic.LOGGER.info("Registering Particles for" + Terratonic.MOD_ID);
    }
}
