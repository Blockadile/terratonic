package net.terratonic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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
    public static final Block COBBLED_SLATE = registerBlock("cobbled_slate",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block COBBLED_SLATE_STAIRS = registerBlock("cobbled_slate_stairs",
            new StairsBlock(ModBlocks.COBBLED_SLATE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block COBBLED_SLATE_SLAB = registerBlock("cobbled_slate_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block COBBLED_SLATE_WALL = registerBlock("cobbled_slate_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block MOSSY_COBBLED_SLATE = registerBlock("mossy_cobbled_slate",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block MOSSY_COBBLED_SLATE_STAIRS = registerBlock("mossy_cobbled_slate_stairs",
            new StairsBlock(ModBlocks.MOSSY_COBBLED_SLATE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_STAIRS).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block MOSSY_COBBLED_SLATE_SLAB = registerBlock("mossy_cobbled_slate_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_SLAB).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block MOSSY_COBBLED_SLATE_WALL = registerBlock("mossy_cobbled_slate_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_WALL).sounds(BlockSoundGroup.DEEPSLATE))
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
        // Tangled Roots
    public static final Block TANGLED_ROOTS = registerBlock("tangled_roots",
            new Block(AbstractBlock.Settings.copy(Blocks.DIRT).sounds(ModSoundGroups.TANGLED_ROOTS))
    );
        // Crops
    public static final Block GARLICS = registerUnobtainableBlock("garlics",
            new GarlicsBlock(AbstractBlock.Settings.copy(Blocks.CARROTS))
    );
        // Dry Grss
    public static final Block SHORT_DRY_GRASS = registerBlock("short_dry_grass",
            new ShortDryGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)));
    public static final Block TALL_DRY_GRASS = registerBlock("tall_dry_grass",
            new TallDryGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)));
        // Flowers
    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .sounds(BlockSoundGroup.PINK_PETALS)
                    .pistonBehavior(PistonBehavior.DESTROY))
    );
    // Misc Plants
    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .noCollision()
                    .sounds(ModSoundGroups.LEAF_LITTER)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BUSH = registerBlock("bush",
            new TallDryGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)));

    // Misc
    public static final Block COPPER_ANVIL = registerBlock("copper_anvil",
            new CopperAnvilBlock(AbstractBlock.Settings.copy(Blocks.ANVIL))
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
            fabricItemGroupEntries.addAfter(ModBlocks.SLATE, ModBlocks.COBBLED_SLATE);
            fabricItemGroupEntries.addAfter(ModBlocks.COBBLED_SLATE, ModBlocks.COBBLED_SLATE_STAIRS);
            fabricItemGroupEntries.addAfter(ModBlocks.COBBLED_SLATE_STAIRS, ModBlocks.COBBLED_SLATE_SLAB);
            fabricItemGroupEntries.addAfter(ModBlocks.COBBLED_SLATE_SLAB, ModBlocks.COBBLED_SLATE_WALL);
            fabricItemGroupEntries.addAfter(ModBlocks.COBBLED_SLATE_WALL, ModBlocks.MOSSY_COBBLED_SLATE);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_COBBLED_SLATE, ModBlocks.MOSSY_COBBLED_SLATE_STAIRS);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_COBBLED_SLATE_STAIRS, ModBlocks.MOSSY_COBBLED_SLATE_SLAB);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_COBBLED_SLATE_SLAB, ModBlocks.MOSSY_COBBLED_SLATE_WALL);
            fabricItemGroupEntries.addAfter(ModBlocks.MOSSY_COBBLED_SLATE_WALL, ModBlocks.SLATE_BRICKS);
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
            fabricItemGroupEntries.addAfter(Blocks.FERN, ModBlocks.SHORT_DRY_GRASS);
            fabricItemGroupEntries.addAfter(ModBlocks.SHORT_DRY_GRASS, ModBlocks.BUSH);
            fabricItemGroupEntries.addAfter(Blocks.LARGE_FERN, ModBlocks.TALL_DRY_GRASS);
            fabricItemGroupEntries.addAfter(Blocks.PINK_PETALS, ModBlocks.WILDFLOWERS);
            fabricItemGroupEntries.addAfter(ModBlocks.WILDFLOWERS, ModBlocks.LEAF_LITTER);
            fabricItemGroupEntries.addBefore(Blocks.VINE, ModBlocks.HANGING_CAVE_ROOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.DAMAGED_ANVIL, ModBlocks.COPPER_ANVIL);
        });
    }
}
