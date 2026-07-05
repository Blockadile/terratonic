package net.terratonic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.block.ModBlocks;
import net.terratonic.item.components.ModFoodComponents;

import java.util.List;

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

        // Weapons
    // Wooden Swords
    public static final Item WOODEN_DUELING_SWORD = registerItem("wooden_dueling_sword", new SwordItem(ToolMaterials.WOOD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item WOODEN_WIDE_SWORD = registerItem("wooden_wide_sword", new SwordItem(ToolMaterials.WOOD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item WOODEN_SHORT_SWORD = registerItem("wooden_short_sword", new SwordItem(ToolMaterials.WOOD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Stone Swords
        public static final Item STONE_DUELING_SWORD = registerItem("stone_dueling_sword", new SwordItem(ToolMaterials.STONE, new Item.Settings()
                .maxCount(1)
                .attributeModifiers(new AttributeModifiersComponent(List.of(
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                                Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4F, EntityAttributeModifier.Operation.ADD_VALUE
                        ), AttributeModifierSlot.MAINHAND),
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                                Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                        ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item STONE_WIDE_SWORD = registerItem("stone_wide_sword", new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item STONE_SHORT_SWORD = registerItem("stone_short_sword", new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Copper Swords
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    3, -2.4F))));
    public static final Item COPPER_DUELING_SWORD = registerItem("copper_dueling_sword", new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item COPPER_WIDE_SWORD = registerItem("copper_wide_sword", new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item COPPER_SHORT_SWORD = registerItem("copper_short_sword", new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Iron Swords
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
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
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
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Golden Swords
    public static final Item GOLDEN_DUELING_SWORD = registerItem("golden_dueling_sword", new SwordItem(ToolMaterials.GOLD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item GOLDEN_WIDE_SWORD = registerItem("golden_wide_sword", new SwordItem(ToolMaterials.GOLD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item GOLDEN_SHORT_SWORD = registerItem("golden_short_sword", new SwordItem(ToolMaterials.GOLD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Diamond Swords
    public static final Item DIAMOND_DUELING_SWORD = registerItem("diamond_dueling_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,6F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item DIAMOND_WIDE_SWORD = registerItem("diamond_wide_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,6F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item DIAMOND_SHORT_SWORD = registerItem("diamond_short_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Netherite Swords
    public static final Item NETHERITE_DUELING_SWORD = registerItem("netherite_dueling_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.4F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item NETHERITE_WIDE_SWORD = registerItem("netherite_wide_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2.7F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(
                            Identifier.of("0123581106710"),0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));
    public static final Item NETHERITE_SHORT_SWORD = registerItem("netherite_short_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,6F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-2F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("2906341806710"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10157301586103"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

        // Tools
    // Pickaxes
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    1, -2.8F))));

    // Shovels
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    1.5F, -3.0F))));

    // Axes
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    7, -3.2F))));

    // Hoes
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    0, -3.0F))));

    // Food
    public static final Item GARLIC = registerItem("garlic", new AliasedBlockItem(ModBlocks.GARLICS, (new Item.Settings()
            .food(ModFoodComponents.GARLIC))));

    // Misc
    public static final Item ORNATE_OIL_BOTTLE = registerItem("ornate_oil_bottle", new Item(new Item.Settings()));


    // Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Terratonic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Terratonic.LOGGER.info("Registering Mod Items for " + Terratonic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.BEETROOT, ModItems.GARLIC);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_SHOVEL);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_PICKAXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_AXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {

            fabricItemGroupEntries.addBefore(Items.IRON_SWORD, ModItems.COPPER_SWORD);

                // Sword Variants
            // Wooden Swords
            fabricItemGroupEntries.addAfter(Items.WOODEN_SWORD, ModItems.WOODEN_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.WOODEN_DUELING_SWORD, ModItems.WOODEN_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.WOODEN_WIDE_SWORD, ModItems.WOODEN_SHORT_SWORD);
            // Stone Swords
            fabricItemGroupEntries.addAfter(Items.STONE_SWORD, ModItems.STONE_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.STONE_DUELING_SWORD, ModItems.STONE_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.STONE_WIDE_SWORD, ModItems.STONE_SHORT_SWORD);
            // Copper Swords
            fabricItemGroupEntries.addAfter(ModItems.COPPER_SWORD, ModItems.COPPER_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.COPPER_DUELING_SWORD, ModItems.COPPER_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.COPPER_WIDE_SWORD, ModItems.COPPER_SHORT_SWORD);
            // Iron Swords
            fabricItemGroupEntries.addAfter(Items.IRON_SWORD, ModItems.IRON_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.IRON_DUELING_SWORD, ModItems.IRON_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.IRON_WIDE_SWORD, ModItems.IRON_SHORT_SWORD);
            // Golden Swords
            fabricItemGroupEntries.addAfter(Items.GOLDEN_SWORD, ModItems.GOLDEN_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.GOLDEN_DUELING_SWORD, ModItems.GOLDEN_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.GOLDEN_WIDE_SWORD, ModItems.GOLDEN_SHORT_SWORD);
            // Diamond Swords
            fabricItemGroupEntries.addAfter(Items.DIAMOND_SWORD, ModItems.DIAMOND_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.DIAMOND_DUELING_SWORD, ModItems.DIAMOND_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.DIAMOND_WIDE_SWORD, ModItems.DIAMOND_SHORT_SWORD);
            // Netherite Swords
            fabricItemGroupEntries.addAfter(Items.NETHERITE_SWORD, ModItems.NETHERITE_DUELING_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.NETHERITE_DUELING_SWORD, ModItems.NETHERITE_WIDE_SWORD);
            fabricItemGroupEntries.addAfter(ModItems.NETHERITE_WIDE_SWORD, ModItems.NETHERITE_SHORT_SWORD);


            fabricItemGroupEntries.addBefore(Items.IRON_AXE, ModItems.COPPER_AXE);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_BOOTS);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_LEGGINGS);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_CHESTPLATE);
            fabricItemGroupEntries.addAfter(Items.LEATHER_BOOTS, ModItems.COPPER_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.EXPERIENCE_BOTTLE, ModItems.ORNATE_OIL_BOTTLE);
        });
    }
}
