package net.terratonic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.GrassColors;
import net.terratonic.block.ModBlocks;
import net.terratonic.client.model.ModModelLayers;
import net.terratonic.client.model.entity.CushionModel;
import net.terratonic.client.render.entity.CushionRenderer;
import net.terratonic.entity.ModEntities;

public class TerratonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 1) {
                if (world != null && pos != null) {
                    return BiomeColors.getGrassColor(world, pos);
                }
                return GrassColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.WILDFLOWERS);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 0) {
                if (world != null && pos != null) {
                    return BiomeColors.getGrassColor(world, pos);
                }
                return GrassColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.BUSH);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0) {
                return GrassColors.getColor(0.5, 1.0);
            }
            return -1;
        }, ModBlocks.BUSH.asItem());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLICS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_CAVE_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_CAVE_ROOTS_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUSH, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CUSHION, CushionRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUSHION, CushionModel::getTexturedModelData);
    }
}
