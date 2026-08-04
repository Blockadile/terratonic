package net.terratonic.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.terratonic.item.custom.ScytheItem;
import net.terratonic.item.custom.SickleItem;
import net.terratonic.util.ModAttributes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
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
            System.out.println(this.getAttributeValue(ModAttributes.BLOCKING_AMOUNT));
            amount *= (float) this.getAttributeValue(ModAttributes.BLOCKING_AMOUNT);
            activeItemStack.damage(3, this, getSlotForHand(Hand.MAIN_HAND));
        }
        return amount;
    }
}
