package net.terratonic;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

import net.terratonic.block.ModBlocks;
import net.terratonic.entity.ModEntities;
import net.terratonic.item.ModItems;
import net.terratonic.sounds.ModSounds;
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
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
