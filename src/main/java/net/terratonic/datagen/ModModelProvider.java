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
        itemModelGenerator.register(ModItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_DUELING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_BROADSWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_SHORT_SWORD, Models.HANDHELD);
    }
}
