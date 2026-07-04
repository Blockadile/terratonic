package net.terratonic;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import net.terratonic.block.ModBlocks;
import net.terratonic.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Terratonic implements ModInitializer {
	public static final String MOD_ID = "terratonic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
