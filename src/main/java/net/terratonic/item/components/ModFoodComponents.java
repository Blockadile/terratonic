package net.terratonic.item.components;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent GARLIC = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F).build();
}
