package net.terratonic.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CoinSpin extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    public CoinSpin(ClientWorld clientWorld, double x, double y, double z,
                                  SpriteProvider spriteProvider, double XVel, double YVel, double ZVel) {
        super(clientWorld, x, y, z, XVel, YVel, ZVel);
        this.maxAge = 40;
        //this.setVelocity(0,0,0);

        this.spacingXZ = 0;
        this.spacingY = 0;

        this.spriteProvider = spriteProvider;
        this.setSprite(spriteProvider);
        this.gravityStrength = (float) 0.5;


        this.collidesWithWorld = true;
    }

    @Override
    public void tick() {
        this.setSpriteForAge(this.spriteProvider);
        super.tick();
        if (this.onGround) {
            this.gravityStrength = 0;
            this.setVelocity(0,0,0);
            this.setPos(prevPosX,prevPosY, prevPosZ);
        }

    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z,
                                                 double velocityX, double velocityY, double velocityZ) {
            return new CoinSpin(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
