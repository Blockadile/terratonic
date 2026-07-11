package net.terratonic.client.render.entity;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.terratonic.client.model.ModModelLayers;
import net.terratonic.client.model.entity.CushionModel;
import net.terratonic.entity.custom.CushionEntity;

import java.util.EnumMap;
import java.util.Map;

public class CushionRenderer extends EntityRenderer<CushionEntity> {
    private static final Map<DyeColor, Identifier> TEXTURES = Util.make(new EnumMap<>(DyeColor.class), map -> {
        for (DyeColor color : DyeColor.values()) {
            map.put(color, Identifier.of("terratonic", "textures/entity/cushion/" + color.getName() + "_cushion.png"));
        }
    });

    private final CushionModel model;

    public CushionRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new CushionModel(context.getPart(ModModelLayers.CUSHION));
    }

    @Override
    public Identifier getTexture(CushionEntity entity) {
        return TEXTURES.getOrDefault(entity.getColor(), TEXTURES.get(DyeColor.WHITE));
    }

    @Override
    public void render(CushionEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        float rotation = entity.getFacing().asRotation();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-rotation));

        matrices.translate(0.0D, -1.5D, 0.0D);

        Identifier texture = this.getTexture(entity);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.model.getLayer(texture));
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 0xFFFFFFFF);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}
