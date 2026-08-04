package net.terratonic;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.util.Identifier;

import net.terratonic.block.ModBlocks;
import net.terratonic.entity.ModEntities;
import net.terratonic.item.ModItems;
import net.terratonic.sounds.ModSounds;
import net.terratonic.util.ModAttributes;
import net.terratonic.world.tree.ModFoliagePlacerTypes;
import net.terratonic.world.tree.ModTreeDecorators;
import net.terratonic.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;

public class Terratonic implements ModInitializer {
	public static final String MOD_ID = "terratonic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModSounds.registerModSounds();
		ModAttributes.registerAttributes();
		ModFoliagePlacerTypes.registerModFoliage();
		ModTrunkPlacerTypes.registerModTrunks();
		ModTreeDecorators.registerModTreeDecorators();

		StrippableBlockRegistry.register(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PALM_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PALM_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALM_FENCE_GATE, 5, 20);
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
