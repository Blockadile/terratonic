package net.terratonic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.terratonic.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PALM_LEAVES, leavesDrops(ModBlocks.PALM_LEAVES, ModBlocks.PALM_SAPLING, 0.0625F));
        addDrop(ModBlocks.PALM_LOG);
        addDrop(ModBlocks.PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_PALM_WOOD);
        addDrop(ModBlocks.PALM_PLANKS);
        addDrop(ModBlocks.PALM_STAIRS);
        addDrop(ModBlocks.PALM_SLAB, slabDrops(ModBlocks.PALM_SLAB));
        addDrop(ModBlocks.PALM_FENCE);
        addDrop(ModBlocks.PALM_FENCE_GATE);
        addDrop(ModBlocks.PALM_PRESSURE_PLATE);
        addDrop(ModBlocks.PALM_BUTTON);

        addDrop(ModBlocks.COBBLED_SLATE);
        addDrop(ModBlocks.COBBLED_SLATE_STAIRS);
        addDrop(ModBlocks.COBBLED_SLATE_SLAB, slabDrops(ModBlocks.COBBLED_SLATE_SLAB));
        addDrop(ModBlocks.COBBLED_SLATE_WALL);
        addDrop(ModBlocks.MOSSY_COBBLED_SLATE);
        addDrop(ModBlocks.MOSSY_COBBLED_SLATE_STAIRS);
        addDrop(ModBlocks.MOSSY_COBBLED_SLATE_SLAB, slabDrops(ModBlocks.MOSSY_COBBLED_SLATE_SLAB));
        addDrop(ModBlocks.MOSSY_COBBLED_SLATE_WALL);
        addDrop(ModBlocks.SLATE_BRICKS);
        addDrop(ModBlocks.CRACKED_SLATE_BRICKS);
        addDrop(ModBlocks.SLATE_BRICK_STAIRS);
        addDrop(ModBlocks.SLATE_BRICK_SLAB, slabDrops(ModBlocks.SLATE_BRICK_SLAB));
        addDrop(ModBlocks.SLATE_BRICK_WALL);
        addDrop(ModBlocks.MOSSY_SLATE_BRICKS);
        addDrop(ModBlocks.MOSSY_SLATE_BRICK_STAIRS);
        addDrop(ModBlocks.MOSSY_SLATE_BRICK_SLAB, slabDrops(ModBlocks.MOSSY_SLATE_BRICK_SLAB));
        addDrop(ModBlocks.MOSSY_SLATE_BRICK_WALL);

        addDrop(ModBlocks.SHALE);

        addDrop(ModBlocks.TANGLED_ROOTS);
        addDrop(ModBlocks.PALM_SAPLING);

        addDrop(ModBlocks.THATCH);
        addDrop(ModBlocks.THATCH_STAIRS);
        addDrop(ModBlocks.THATCH_SLAB, slabDrops(ModBlocks.THATCH_SLAB));
    }
}
