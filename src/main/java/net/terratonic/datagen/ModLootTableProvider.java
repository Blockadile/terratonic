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
        addDrop(ModBlocks.SLATE);
        addDrop(ModBlocks.SLATE_BRICKS);
        addDrop(ModBlocks.SLATE_BRICK_STAIRS);
        addDrop(ModBlocks.SLATE_BRICK_SLAB, slabDrops(ModBlocks.SLATE_BRICK_SLAB));
        addDrop(ModBlocks.SLATE_BRICK_WALL);

        addDrop(ModBlocks.SHALE);

        addDrop(ModBlocks.TANGLED_ROOTS);
    }
}
