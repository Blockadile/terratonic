package net.terratonic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.terratonic.block.ModBlocks;
import net.terratonic.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SLATE)
                .add(ModBlocks.COBBLED_SLATE)
                .add(ModBlocks.COBBLED_SLATE_STAIRS)
                .add(ModBlocks.COBBLED_SLATE_SLAB)
                .add(ModBlocks.COBBLED_SLATE_WALL)
                .add(ModBlocks.MOSSY_COBBLED_SLATE)
                .add(ModBlocks.MOSSY_COBBLED_SLATE_STAIRS)
                .add(ModBlocks.MOSSY_COBBLED_SLATE_SLAB)
                .add(ModBlocks.MOSSY_COBBLED_SLATE_WALL)
                .add(ModBlocks.SLATE_BRICKS)
                .add(ModBlocks.CRACKED_SLATE_BRICKS)
                .add(ModBlocks.SLATE_BRICK_STAIRS)
                .add(ModBlocks.SLATE_BRICK_SLAB)
                .add(ModBlocks.SLATE_BRICK_WALL)
                .add(ModBlocks.MOSSY_SLATE_BRICKS)
                .add(ModBlocks.MOSSY_SLATE_BRICK_STAIRS)
                .add(ModBlocks.MOSSY_SLATE_BRICK_SLAB)
                .add(ModBlocks.MOSSY_SLATE_BRICK_WALL)
                .add(ModBlocks.SHALE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PALM_LOG)
                .add(ModBlocks.PALM_WOOD)
                .add(ModBlocks.STRIPPED_PALM_LOG)
                .add(ModBlocks.STRIPPED_PALM_WOOD)
                .add(ModBlocks.PALM_PLANKS)
                .add(ModBlocks.PALM_STAIRS)
                .add(ModBlocks.PALM_SLAB)
                .add(ModBlocks.PALM_FENCE)
                .add(ModBlocks.PALM_FENCE_GATE)
                .add(ModBlocks.PALM_PRESSURE_PLATE)
                .add(ModBlocks.PALM_BUTTON);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.TANGLED_ROOTS)
                .add(ModBlocks.THATCH)
                .add(ModBlocks.THATCH_STAIRS)
                .add(ModBlocks.THATCH_SLAB)
                .add(ModBlocks.CLOVERS)
                .add(ModBlocks.LEAF_LITTER);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.CLOVERS)
                .add(ModBlocks.LEAF_LITTER);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.PALM_LEAVES);

        getOrCreateTagBuilder(ModTags.Blocks.PALM_LOGS)
                .add(ModBlocks.PALM_LOG)
                .add(ModBlocks.PALM_WOOD)
                .add(ModBlocks.STRIPPED_PALM_LOG)
                .add(ModBlocks.STRIPPED_PALM_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .addTag(ModTags.Blocks.PALM_LOGS);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.PALM_LOGS);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.PALM_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PALM_FENCE);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.PALM_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PALM_SLAB);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PALM_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.PALM_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALM_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.PALM_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALM_BUTTON);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.COBBLED_SLATE_WALL)
                .add(ModBlocks.MOSSY_COBBLED_SLATE_WALL)
                .add(ModBlocks.SLATE_BRICK_WALL)
                .add(ModBlocks.MOSSY_SLATE_BRICK_WALL);
    }
}
