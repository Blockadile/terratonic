package net.terratonic.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class SmallSparkParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    public SmallSparkParticle(ClientWorld clientWorld, double x, double y, double z,
                    SpriteProvider spriteProvider, double XVel, double YVel, double ZVel) {
        super(clientWorld, x, y, z, XVel, YVel, ZVel);
        this.maxAge = Random.create().nextBetween(10, 30);
        this.scale = Random.create().nextBetween(1, 3)/100f;
        //this.setVelocity(0,0,0);

        this.spacingXZ = 0;
        this.spacingY = 0;

        this.spriteProvider = spriteProvider;
        this.setSpriteForAge(spriteProvider);
        this.gravityStrength = (float) 0.6;


        this.collidesWithWorld = true;
    }

    @Override
    public void tick() {
        this.setSpriteForAge(this.spriteProvider);
        super.tick();
        if (this.age >= this.maxAge/2) {
            this.setAlpha(1.0F - ((float) this.age - (float) (this.maxAge / 2)) / (float) this.maxAge);
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
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
            return new SmallSparkParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}