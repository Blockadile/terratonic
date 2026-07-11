package net.terratonic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.terratonic.block.ModBlocks;
import net.terratonic.client.model.ModModelLayers;
import net.terratonic.client.model.entity.CushionModel;
import net.terratonic.client.render.entity.CushionRenderer;
import net.terratonic.entity.ModEntities;

public class TerratonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLICS, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CUSHION, CushionRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUSHION, CushionModel::getTexturedModelData);
    }
}
