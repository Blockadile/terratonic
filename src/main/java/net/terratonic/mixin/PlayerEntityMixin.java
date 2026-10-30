package net.terratonic.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.terratonic.item.custom.DuelingSwordItem;
import net.terratonic.item.custom.ScytheItem;
import net.terratonic.item.custom.SickleItem;
import net.terratonic.particle.ModParticles;
import net.terratonic.util.ModAttributes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
    @Shadow
    public abstract void attack(Entity target);

    @Shadow
    public abstract void playSound(SoundEvent sound, float volume, float pitch);

    @Shadow
    @Final
    private ItemCooldownManager itemCooldownManager;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "createPlayerAttributes", at = @At("RETURN"), cancellable = true)
    private static void Injected(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir){
        cir.setReturnValue(cir.getReturnValue()
                .add(ModAttributes.BLOCKING_AMOUNT));
    }

    @ModifyVariable(method = "attack", at = @At("STORE"), ordinal = 3)
    private boolean weaponSweep(boolean originalValue) {
        ItemStack handStack = this.getStackInHand(Hand.MAIN_HAND);

        if (handStack.getItem() instanceof SickleItem || handStack.getItem() instanceof ScytheItem) {
            return true;
        }

        return originalValue;
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float halveDamage(float amount, DamageSource source) {
        boolean blockable = false;
        if (!source.isIn(DamageTypeTags.BYPASSES_SHIELD)) {
            Vec3d vec3d = source.getPosition();
            if (vec3d != null) {
                Vec3d vec3d2 = this.getRotationVector(0.0F, this.getHeadYaw());
                Vec3d vec3d3 = vec3d.relativize(this.getPos());
                vec3d3 = (new Vec3d(vec3d3.x, (double) 0.0F, vec3d3.z)).normalize();
                blockable = vec3d3.dotProduct(vec3d2) < (double) 0.0F;
            }
        }

        if (this.activeItemStack != null && activeItemStack.getItem() instanceof SwordItem && blockable) {
            if (activeItemStack.getItem() instanceof DuelingSwordItem) {
                Vec3d startingVec3d = this.getVelocity();

                double d = -MathHelper.sin(this.getYaw() * (float) (Math.PI / 180.0));
                double e = MathHelper.cos(this.getYaw() * (float) (Math.PI / 180.0));
                if (this.getWorld() instanceof ServerWorld) {
                    if (source.getPosition() != null) {
                        d = source.getPosition().getX() - this.getX();
                        e = source.getPosition().getZ() - this.getZ();
                    }

                    this.takeKnockback(0.4, d, e);
                    this.scheduleVelocityUpdate();

                    this.playSound(SoundEvents.BLOCK_ANVIL_FALL);

                    ((ServerWorld)this.getWorld()).spawnParticles(ModParticles.SPARK_PARTICLE, this.getX() + d, this.getBodyY(0.5) + 0.5, this.getZ() + e, 0, d, 0.0, e, 0.0);
                    for (int i=0; i<10; i++) {
                        ((ServerWorld)this.getWorld()).spawnParticles(ModParticles.SMALL_SPARK_PARTICLE, this.getX() + d, this.getBodyY(0.5) + 0.5, this.getZ() + e, 0, d + startingVec3d.x, 0.0, e + startingVec3d.z, 0.0);
                    }
                }
                System.out.println(this.getVelocity());
                if (source.getSource() != null) {
                    attack(source.getSource());
                    source.getSource().addVelocity((d / 3) + (startingVec3d.x/2), 0f, (e / 3) + (startingVec3d.z/2));
                }
                activeItemStack.damage(1, this, getSlotForHand(Hand.MAIN_HAND));
                stopUsingItem();
                return 0;
            }
            System.out.println(this.getAttributeValue(ModAttributes.BLOCKING_AMOUNT));
            amount *= (float) this.getAttributeValue(ModAttributes.BLOCKING_AMOUNT);
            activeItemStack.damage(3, this, getSlotForHand(Hand.MAIN_HAND));
        }
        return amount;
    }
}
