package net.terratonic.client.model.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CushionModel extends EntityModel<Entity> {
    private final ModelPart CUSHION;

    public CushionModel(ModelPart root) {
        this.CUSHION = root.getChild("CUSHION");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("CUSHION", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-7.999F, 0.0F, -7.999F, 15.998F, 4.0F, 15.998F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        CUSHION.render(matrices, vertices, light, overlay, color);
    }
}
