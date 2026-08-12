package net.terratonic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ColorResolver;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.biome.GrassColors;
import net.terratonic.block.ModBlocks;
import net.terratonic.client.model.ModModelLayers;
import net.terratonic.client.model.entity.CushionModel;
import net.terratonic.client.render.entity.CushionRenderer;
import net.terratonic.entity.ModEntities;

public class TerratonicClient implements ClientModInitializer {

    private static final int BAMBOO_DEFAULT = 0xA4FF26;
    private static final int BAMBOO_WARM = 0xD0FF72;
    private static final int BAMBOO_BADLANDS = 0xF2FF66;

    private static final int BAMBOO_NODE_DEFAULT = 0xB8FF68;
    private static final int BAMBOO_NODE_WARM = 0xCEFF7F;
    private static final int BAMBOO_NODE_BADLANDS = 0xE9FF7F;

    @Override
    public void onInitializeClient() {
        // Color Maps
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 1) {
                if (world != null && pos != null) {
                    return BiomeColors.getGrassColor(world, pos);
                }
                return GrassColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.WILDFLOWERS, ModBlocks.PURPLE_WILDFLOWERS);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 0) {
                if (world != null && pos != null) {
                    return BiomeColors.getFoliageColor(world, pos);
                }
                return FoliageColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.PALM_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0) {
                return FoliageColors.getColor(0.75, 0.99);
            }
            return -1;
        }, ModBlocks.PALM_LEAVES.asItem());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 0) {
                if (world != null && pos != null) {
                    return BiomeColors.getGrassColor(world, pos);
                }
                return GrassColors.getDefaultColor();
            } else if (tintIndex == 1) {
                if (world != null && pos != null) {
                    return BiomeColors.getGrassColor(world, pos);
                }
                return GrassColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.BUSH, ModBlocks.CLOVERS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0) {
                return GrassColors.getColor(0.5, 1.0);
            }
            return -1;
        }, ModBlocks.BUSH.asItem(), ModBlocks.CLOVERS.asItem());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return tintIndex == 1 ? BAMBOO_NODE_DEFAULT : BAMBOO_DEFAULT;
            }

            RegistryEntry<Biome> biomeEntry = world.getBiomeFabric(pos);
            Biome biome = biomeEntry.value();

            boolean isBadlands = biomeEntry.isIn(BiomeTags.IS_BADLANDS);
            boolean isHot = biome.getTemperature() >= 0.95f || biomeEntry.isIn(BiomeTags.IS_SAVANNA);

            if (tintIndex == 0) {
                if (isBadlands) return BAMBOO_BADLANDS;
                if (isHot)      return BAMBOO_WARM;
                return BAMBOO_DEFAULT;
            } else if (tintIndex == 1) {
                if (isBadlands) return BAMBOO_NODE_BADLANDS;
                if (isHot)      return BAMBOO_NODE_WARM;
                return BAMBOO_NODE_DEFAULT;
            }

            return -1;
        }, Blocks.BAMBOO);

        // Transparency
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLICS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_CAVE_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_CAVE_ROOTS_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPLE_WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOVERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUSH, RenderLayer.getCutout());

        // Entities
        EntityRendererRegistry.register(ModEntities.CUSHION, CushionRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUSHION, CushionModel::getTexturedModelData);
    }
}
