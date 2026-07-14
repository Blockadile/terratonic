package net.terratonic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.terratonic.block.ModBlocks;
import net.terratonic.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool slate_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SLATE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SLATE_BRICKS);
        slate_brick_pool.stairs(ModBlocks.SLATE_BRICK_STAIRS);
        slate_brick_pool.slab(ModBlocks.SLATE_BRICK_SLAB);
        slate_brick_pool.wall(ModBlocks.SLATE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool mossy_slate_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_SLATE_BRICKS);
        mossy_slate_brick_pool.stairs(ModBlocks.MOSSY_SLATE_BRICK_STAIRS);
        mossy_slate_brick_pool.slab(ModBlocks.MOSSY_SLATE_BRICK_SLAB);
        mossy_slate_brick_pool.wall(ModBlocks.MOSSY_SLATE_BRICK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANGLED_ROOTS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Foods
        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);

        // Misc
        itemModelGenerator.register(ModItems.ORNATE_OIL_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);

        // Copper Armor
        itemModelGenerator.register(ModItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS, Models.GENERATED);

        // Copper Tools
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

            // Sword Variants
        // Wooden Swords
        itemModelGenerator.register(ModItems.WOODEN_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOODEN_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOODEN_SHORT_SWORD, Models.HANDHELD);
        // Stone Swords
        itemModelGenerator.register(ModItems.STONE_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SHORT_SWORD, Models.HANDHELD);
        // Copper Swords
        itemModelGenerator.register(ModItems.COPPER_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHORT_SWORD, Models.HANDHELD);
        // Iron Swords
        itemModelGenerator.register(ModItems.IRON_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_SHORT_SWORD, Models.HANDHELD);
        // Golden Swords
        itemModelGenerator.register(ModItems.GOLDEN_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_SHORT_SWORD, Models.HANDHELD);
        // Diamond Swords
        itemModelGenerator.register(ModItems.DIAMOND_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_SHORT_SWORD, Models.HANDHELD);
        // Netherite Swords
        itemModelGenerator.register(ModItems.NETHERITE_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_WIDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_SHORT_SWORD, Models.HANDHELD);

            // Hoe Variants
        // Scythes

        // Sickles
        itemModelGenerator.register(ModItems.WOODEN_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_SICKLE, Models.HANDHELD);

        // Colored Items
        itemModelGenerator.register(ModItems.WHITE_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_GRAY_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAY_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROWN_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIME_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.CYAN_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_BLUE_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGENTA_CUSHION, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_CUSHION, Models.GENERATED);
    }
}
