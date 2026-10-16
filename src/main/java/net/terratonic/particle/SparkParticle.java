package net.terratonic.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class SparkParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    public SparkParticle(ClientWorld clientWorld, double x, double y, double z,
                    SpriteProvider spriteProvider) {
        super(clientWorld, x, y, z);
        this.maxAge = 5;
        this.setVelocity(0,0,0);

        this.spacingXZ = 0;
        this.spacingY = 0;

        this.spriteProvider = spriteProvider;
        this.setSpriteForAge(spriteProvider);
        this.scale(6);

        this.collidesWithWorld = false;
    }

    @Override
    public void tick() {
        this.setSpriteForAge(this.spriteProvider);
        super.tick();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Override
    public int getBrightness(float tint) {
        return 15728880;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z,
                                                 double velocityX, double velocityY, double velocityZ) {
            return new SparkParticle(world, x, y, z, this.spriteProvider);
        }
    }
}
