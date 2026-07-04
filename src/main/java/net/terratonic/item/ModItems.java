package net.terratonic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.item.components.ModFoodComponents;

import java.util.List;

public class ModItems {
    public static final Item IRON_DUELING_SWORD = registerItem("iron_dueling_sword", new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item IRON_WIDE_SWORD = registerItem("iron_wide_sword", new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),1F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item IRON_SHORT_SWORD = registerItem("iron_short_sword", new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.25F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

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
