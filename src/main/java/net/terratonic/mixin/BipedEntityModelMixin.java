package net.terratonic.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;

import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.terratonic.item.custom.DuelingSwordItem;
import net.terratonic.util.ModTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
@Environment(EnvType.CLIENT)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead {
    @Shadow
    @Mutable
    @Final
    public ModelPart rightArm;
    @Shadow
    @Mutable
    @Final
    public ModelPart leftArm;
    @Shadow
    @Mutable
    @Final
    public ModelPart head;

    @Shadow
    abstract protected void positionRightArm(LivingEntity livingEntity);

    @Shadow
    abstract protected void positionLeftArm(LivingEntity livingEntity);

    @Shadow
    public BipedEntityModel.ArmPose rightArmPose;

    @Shadow
    public BipedEntityModel.ArmPose leftArmPose;

    @Inject(method = "setAngles*", at = @At(value = "TAIL"))
    private void setAnglesMixin(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo info) {
        if (!livingEntity.isSwimming() && !livingEntity.hasVehicle() && livingEntity.getMainHandStack() != null) {
            if ((livingEntity.getMainHandStack().isIn(ModTags.Items.TWO_HANDED_HANDHELD))) { // Two-handed item code, stolen and modified from Wind Charged Weaponry
                this.rightArm.pitch = -0.8727F; // + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15)
                this.rightArm.yaw = -0.5672F;
                this.rightArm.roll = 0.0F;
                this.leftArm.pitch = -1.0472F; // + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15)
                this.leftArm.yaw = 0.829F;
                this.leftArm.roll = -0.0436F;
                if (this.handSwingProgress > 0) {
                    float gx = 1.0F - this.handSwingProgress;
                    float hx = MathHelper.sin(gx * 3.1415927F);
                    float kx = this.head.pitch;
                    if (kx < 0) {
                        kx = 0.25F;
                    }
                    float ix = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
                    this.rightArm.pitch = (float) ((double) this.rightArm.pitch - ((double) hx * 1.2D + (double) ix));
                    this.leftArm.pitch = (float) ((double) this.leftArm.pitch - ((double) hx * 1.2D + (double) ix) * 1.2D) * 0.75F;
                }
            } else {
                if (livingEntity.getActiveItem().getItem() instanceof SwordItem) {
                    this.rightArm.yaw = 0.0F;
                    this.leftArm.yaw = 0.0F;
                    boolean prefersRightArm = livingEntity.getMainArm() == Arm.RIGHT;
                    if (livingEntity.isUsingItem()) {
                        boolean usingMainHand = livingEntity.getActiveHand() == Hand.MAIN_HAND;
                        if (livingEntity.getActiveItem().getItem() instanceof DuelingSwordItem) {
                            if (usingMainHand == prefersRightArm) {
                                rightArm.yaw = 0.2f + (head.pitch * -1f);
                                rightArm.pitch = (float) (-Math.PI / 2f) + head.yaw / 2.5f;
                                rightArm.roll = 1.5f;
                            } else {
                                leftArm.yaw = -(0.2f + (head.pitch * -1f));
                                leftArm.pitch = (float) (-Math.PI / 2f) + head.yaw / -2.5f;
                                leftArm.roll = -1.5f;
                            }
                        }else {
                            if (usingMainHand == prefersRightArm) {
                                this.rightArmPose = BipedEntityModel.ArmPose.BLOCK;
                                this.positionRightArm(livingEntity);
                            } else {
                                this.leftArmPose = BipedEntityModel.ArmPose.BLOCK;
                                this.positionLeftArm(livingEntity);
                            }
                        }
                    }
                }
            }
        }
    }


}
