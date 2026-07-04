package net.terratonic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;

public class ModBlocks {



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

        });
    }
}
