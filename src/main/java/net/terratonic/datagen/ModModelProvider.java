package net.terratonic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.terratonic.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORNATE_OIL_BOTTLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS, Models.GENERATED);

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
    }
}
