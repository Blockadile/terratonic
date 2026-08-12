package net.terratonic.item.components;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent GARLIC = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F).build();
    public static final FoodComponent BLUE_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
}
