package net.terratonic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.terratonic.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SLATE)
                .add(ModBlocks.SLATE_BRICKS)
                .add(ModBlocks.SLATE_BRICK_STAIRS)
                .add(ModBlocks.SLATE_BRICK_SLAB)
                .add(ModBlocks.SLATE_BRICK_WALL)
                .add(ModBlocks.SHALE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SLATE_BRICK_WALL);
    }
}
