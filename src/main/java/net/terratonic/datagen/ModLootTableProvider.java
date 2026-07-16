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

        addDrop(ModBlocks.THATCH);
        addDrop(ModBlocks.THATCH_STAIRS);
        addDrop(ModBlocks.THATCH_SLAB, slabDrops(ModBlocks.THATCH_SLAB));
    }
}
