package net.terratonic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.item.components.ModFoodComponents;

public class ModItems {

    public static final Item GARLIC = registerItem("garlic", new Item(new Item.Settings()
            .food(ModFoodComponents.GARLIC).maxCount(16)));

    // Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Terratonic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Terratonic.LOGGER.info("Registering Mod Items for " + Terratonic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.CARROT, ModItems.GARLIC);
        });
    }
}
