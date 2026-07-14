package net.terratonic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.block.ModBlocks;
import net.terratonic.entity.ModEntities;
import net.terratonic.item.components.ModFoodComponents;
import net.terratonic.item.custom.CushionItem;
import net.terratonic.item.custom.DuelingSwordItem;
import net.terratonic.item.custom.ScytheItem;
import net.terratonic.item.custom.SickleItem;

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
    public static final Item WOODEN_DUELING_SWORD = registerItem("wooden_dueling_sword", new DuelingSwordItem(ToolMaterials.WOOD, new Item.Settings()
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
        public static final Item STONE_DUELING_SWORD = registerItem("stone_dueling_sword", new DuelingSwordItem(ToolMaterials.STONE, new Item.Settings()
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
            new DuelingSwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,
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
    public static final Item IRON_DUELING_SWORD = registerItem("iron_dueling_sword", new DuelingSwordItem(ToolMaterials.IRON, new Item.Settings()
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
    public static final Item GOLDEN_DUELING_SWORD = registerItem("golden_dueling_sword", new DuelingSwordItem(ToolMaterials.GOLD, new Item.Settings()
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
    public static final Item DIAMOND_DUELING_SWORD = registerItem("diamond_dueling_sword", new DuelingSwordItem(ToolMaterials.DIAMOND, new Item.Settings()
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
    public static final Item NETHERITE_DUELING_SWORD = registerItem("netherite_dueling_sword", new DuelingSwordItem(ToolMaterials.NETHERITE, new Item.Settings()
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
    // Wooden Hoes
    public static final Item WOODEN_SICKLE = registerItem("wooden_sickle", new SickleItem(ToolMaterials.WOOD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("12098574092000"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("55069211904233"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Stone Hoes
    public static final Item STONE_SICKLE = registerItem("stone_sickle", new SickleItem(ToolMaterials.STONE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,2.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("01928501784928"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("67209467596932"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Copper Hoes
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER,
                    0, -3.0F))));
    public static final Item COPPER_SICKLE = registerItem("copper_sickle", new SickleItem(ModToolMaterials.COPPER, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,2.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("29384756102938"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("12903478561290"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Iron Hoes
    public static final Item IRON_SICKLE = registerItem("iron_sickle", new SickleItem(ToolMaterials.IRON, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,3.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("01298347651029"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("10101029294757"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Golden Hoes
    public static final Item GOLDEN_SICKLE = registerItem("golden_sickle", new SickleItem(ToolMaterials.GOLD, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("69420120929299"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("80081928476566"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Diamond Hoes
    public static final Item DIAMOND_SICKLE = registerItem("diamond_sickle", new SickleItem(ToolMaterials.DIAMOND, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,4.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("01293749845755"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("12094767549867"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Netherite Hoes
    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle", new SickleItem(ToolMaterials.NETHERITE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(new AttributeModifiersComponent(List.of(
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,5.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                            Item.BASE_ATTACK_SPEED_MODIFIER_ID,-1.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("09809853487232"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND),
                    new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(
                            Identifier.of("42369864238191"),-0.5F, EntityAttributeModifier.Operation.ADD_VALUE
                    ), AttributeModifierSlot.MAINHAND)),true))));

    // Colored Items
    public static final Item WHITE_CUSHION = registerItem("white_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.WHITE, new Item.Settings()));
    public static final Item LIGHT_GRAY_CUSHION = registerItem("light_gray_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.LIGHT_GRAY, new Item.Settings()));
    public static final Item GRAY_CUSHION = registerItem("gray_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.GRAY, new Item.Settings()));
    public static final Item BLACK_CUSHION = registerItem("black_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.BLACK, new Item.Settings()));
    public static final Item BROWN_CUSHION = registerItem("brown_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.BROWN, new Item.Settings()));
    public static final Item RED_CUSHION = registerItem("red_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.RED, new Item.Settings()));
    public static final Item ORANGE_CUSHION = registerItem("orange_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.ORANGE, new Item.Settings()));
    public static final Item YELLOW_CUSHION = registerItem("yellow_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.YELLOW, new Item.Settings()));
    public static final Item LIME_CUSHION = registerItem("lime_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.LIME, new Item.Settings()));
    public static final Item GREEN_CUSHION = registerItem("green_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.GREEN, new Item.Settings()));
    public static final Item CYAN_CUSHION = registerItem("cyan_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.CYAN, new Item.Settings()));
    public static final Item LIGHT_BLUE_CUSHION = registerItem("light_blue_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.LIGHT_BLUE, new Item.Settings()));
    public static final Item BLUE_CUSHION = registerItem("blue_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.BLUE, new Item.Settings()));
    public static final Item PURPLE_CUSHION = registerItem("purple_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.PURPLE, new Item.Settings()));
    public static final Item MAGENTA_CUSHION = registerItem("magenta_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.MAGENTA, new Item.Settings()));
    public static final Item PINK_CUSHION = registerItem("pink_cushion",
            new CushionItem(ModEntities.CUSHION, DyeColor.PINK, new Item.Settings()));

    // Food
    public static final Item GARLIC = registerItem("garlic", new AliasedBlockItem(ModBlocks.GARLICS, (new Item.Settings()
            .food(ModFoodComponents.GARLIC))));

    // Misc
    public static final Item ORNATE_OIL_BOTTLE = registerItem("ornate_oil_bottle", new Item(new Item.Settings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));


    // Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Terratonic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Terratonic.LOGGER.info("Registering Mod Items for " + Terratonic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Blocks.PINK_BED, ModItems.WHITE_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.WHITE_CUSHION, ModItems.LIGHT_GRAY_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.LIGHT_GRAY_CUSHION, ModItems.GRAY_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.GRAY_CUSHION, ModItems.BLACK_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.BLACK_CUSHION, ModItems.BROWN_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.BROWN_CUSHION, ModItems.RED_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.RED_CUSHION, ModItems.ORANGE_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.ORANGE_CUSHION, ModItems.YELLOW_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.YELLOW_CUSHION, ModItems.LIME_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.LIME_CUSHION, ModItems.GREEN_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.GREEN_CUSHION, ModItems.CYAN_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.CYAN_CUSHION, ModItems.LIGHT_BLUE_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.LIGHT_BLUE_CUSHION, ModItems.BLUE_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.BLUE_CUSHION, ModItems.PURPLE_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.PURPLE_CUSHION, ModItems.MAGENTA_CUSHION);
            fabricItemGroupEntries.addAfter(ModItems.MAGENTA_CUSHION, ModItems.PINK_CUSHION);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.BEETROOT, ModItems.GARLIC);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_SHOVEL);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_PICKAXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_AXE);
            fabricItemGroupEntries.addBefore(Items.IRON_SHOVEL, ModItems.COPPER_HOE);

            fabricItemGroupEntries.addAfter(Items.WOODEN_HOE, ModItems.WOODEN_SICKLE);
            fabricItemGroupEntries.addAfter(Items.STONE_HOE, ModItems.STONE_SICKLE);
            fabricItemGroupEntries.addAfter(ModItems.COPPER_HOE, ModItems.COPPER_SICKLE);
            fabricItemGroupEntries.addAfter(Items.IRON_HOE, ModItems.IRON_SICKLE);
            fabricItemGroupEntries.addAfter(Items.GOLDEN_HOE, ModItems.GOLDEN_SICKLE);
            fabricItemGroupEntries.addAfter(Items.DIAMOND_HOE, ModItems.DIAMOND_SICKLE);
            fabricItemGroupEntries.addAfter(Items.NETHERITE_HOE, ModItems.NETHERITE_SICKLE);
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
            fabricItemGroupEntries.addAfter(Items.IRON_NUGGET, ModItems.COPPER_NUGGET);
            fabricItemGroupEntries.addAfter(Items.EXPERIENCE_BOTTLE, ModItems.ORNATE_OIL_BOTTLE);
        });
    }
}
