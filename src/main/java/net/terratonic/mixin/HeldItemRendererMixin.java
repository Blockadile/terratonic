package net.terratonic.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {
    // There's too many mixins bruh
    // This is just for the first person sword blocking animations
    @Inject(method = "renderFirstPersonItem",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/HeldItemRenderer;applyEquipOffset(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/Arm;F)V",
                    ordinal = 2, shift = At.Shift.AFTER))
    private void swordBlockAnimation(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand,
                                     float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices,
                                     VertexConsumerProvider vertexConsumers, int light, CallbackInfo callbackInfo) {
        if (item.getItem() instanceof SwordItem) {
            boolean isRightArm = (hand == Hand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite()) == Arm.RIGHT;
            int sideMultiplier = isRightArm ? 1 : -1;

            matrices.translate((float)sideMultiplier * 0.0F, 0.05F, 0.025F);

            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)sideMultiplier * 80.0F));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.0F));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)sideMultiplier * 95.0F));

            matrices.translate((float)sideMultiplier * -0.1F, 0.1F, 0.0F);
        }
    }
}
