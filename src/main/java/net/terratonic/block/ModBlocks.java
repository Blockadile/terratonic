package net.terratonic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.block.custom.CopperAnvilBlock;
import net.terratonic.block.custom.GarlicsBlock;

public class ModBlocks {

    // Rocks/Minerals
    public static final Block SLATE = registerBlock("slate",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SLATE_BRICKS = registerBlock("slate_bricks",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SLATE_BRICK_STAIRS = registerBlock("slate_brick_stairs",
            new StairsBlock(ModBlocks.SLATE_BRICKS.getDefaultState()
                    , AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SLATE_BRICK_SLAB = registerBlock("slate_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SLATE_BRICK_WALL = registerBlock("slate_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE))
    );
    public static final Block SHALE = registerBlock("shale",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.TUFF))
    );

    // Crops
    public static final Block GARLICS = registerUnobtainableBlock("garlics",
            new GarlicsBlock(AbstractBlock.Settings.copy(Blocks.CARROTS))
    );

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
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE_BRICK_SLAB);
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE_BRICK_STAIRS);
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE_BRICKS);
            fabricItemGroupEntries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.SLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.STONE, ModBlocks.SHALE);
            fabricItemGroupEntries.addAfter(Blocks.STONE, ModBlocks.SLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.DAMAGED_ANVIL, ModBlocks.COPPER_ANVIL);
        });
    }
}
