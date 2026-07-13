package net.terratonic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.block.custom.*;
import net.terratonic.sounds.ModSoundGroups;

public class ModBlocks {

    // Rocks/Minerals
    public static final Block SLATE = registerBlock("slate",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SLATE_BRICKS = registerBlock("slate_bricks",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block CRACKED_SLATE_BRICKS = registerBlock("cracked_slate_bricks",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block SLATE_BRICK_STAIRS = registerBlock("slate_brick_stairs",
            new StairsBlock(ModBlocks.SLATE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block SLATE_BRICK_SLAB = registerBlock("slate_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block SLATE_BRICK_WALL = registerBlock("slate_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block MOSSY_SLATE_BRICKS = registerBlock("mossy_slate_bricks",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block MOSSY_SLATE_BRICK_STAIRS = registerBlock("mossy_slate_brick_stairs",
            new StairsBlock(ModBlocks.MOSSY_SLATE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block MOSSY_SLATE_BRICK_SLAB = registerBlock("mossy_slate_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block MOSSY_SLATE_BRICK_WALL = registerBlock("mossy_slate_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE_BRICKS))
    );
    public static final Block SHALE = registerBlock("shale",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.TUFF))
    );

    // Plants
        // Hanging Cave Roots
    public static final Block HANGING_CAVE_ROOTS = registerBlock("hanging_cave_roots",
            new HangingCaveRootsBlock(FabricBlockSettings.copy(Blocks.WEEPING_VINES).sounds(BlockSoundGroup.CROP))
    );
    public static final Block HANGING_CAVE_ROOTS_PLANT = registerUnobtainableBlock("hanging_cave_roots_plant",
            new HangingCaveRootsPlantBlock(FabricBlockSettings.copy(Blocks.WEEPING_VINES_PLANT).sounds(BlockSoundGroup.CROP))
    );
        // Crops
    public static final Block GARLICS = registerUnobtainableBlock("garlics",
            new GarlicsBlock(AbstractBlock.Settings.copy(Blocks.CARROTS))
    );

    // Misc
    public static final Block COPPER_ANVIL = registerBlock("copper_anvil",
            new CopperAnvilBlock(AbstractBlock.Settings.copy(Blocks.ANVIL))
    );
    public static final Block TANGLED_ROOTS = registerBlock("tangled_roots",
            new Block(AbstractBlock.Settings.copy(Blocks.DIRT).sounds(ModSoundGroups.TANGLED_ROOTS))
    );


    // Methods
    private static Block registerUnobtainableBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Terratonic.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registeringBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Terratonic.MOD_ID, name), block);
    }

    private static void registeringBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Terratonic.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Terratonic.LOGGER.info("Registering Mod Blocks for " + Terratonic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE_BRICK_WALL);
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE);
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE, ModBlocks.SLATE_BRICKS);
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE_BRICKS, ModBlocks.CRACKED_SLATE_BRICKS);
            fabricItemGroupEntries.addAfter(ModBlocks.CRACKED_SLATE_BRICKS, ModBlocks.SLATE_BRICK_STAIRS);
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE_BRICK_STAIRS, ModBlocks.SLATE_BRICK_SLAB);
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE_BRICK_SLAB, ModBlocks.SLATE_BRICK_WALL);
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE_BRICK_WALL, ModBlocks.MOSSY_SLATE_BRICKS);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_SLATE_BRICKS, ModBlocks.MOSSY_SLATE_BRICK_STAIRS);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_SLATE_BRICK_STAIRS, ModBlocks.MOSSY_SLATE_BRICK_SLAB);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_SLATE_BRICK_SLAB, ModBlocks.MOSSY_SLATE_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.STONE, ModBlocks.SHALE);
            fabricItemGroupEntries.addAfter(Blocks.STONE, ModBlocks.SLATE);
            fabricItemGroupEntries.addBefore(Blocks.VINE, ModBlocks.HANGING_CAVE_ROOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.DAMAGED_ANVIL, ModBlocks.COPPER_ANVIL);
        });
    }
}
