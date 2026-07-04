package net.terratonic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.item.components.ModFoodComponents;

public class ModItems {

    // Copper Armor
    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(11))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(11))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(11))));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(11))));

    // Copper Tools
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    3, -2.4F))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    1, -2.8F))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    1.5F, -3.0F))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    7, -3.2F))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    0, -3.0F))));

    // Food
    public static final Item GARLIC = registerItem("garlic", new Item(new Item.Settings()
            .food(ModFoodComponents.GARLIC)));

    // Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Terratonic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Terratonic.LOGGER.info("Registering Mod Items for " + Terratonic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.CARROT, ModItems.GARLIC);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_HOE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_AXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_PICKAXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_SHOVEL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addBefore(Items.IRON_SWORD, ModItems.COPPER_SWORD);
            fabricItemGroupEntries.addBefore(Items.IRON_AXE, ModItems.COPPER_AXE);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_BOOTS);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_LEGGINGS);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_CHESTPLATE);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_HELMET);
        });
    }
}
