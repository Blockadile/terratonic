package net.terratonic.util;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import org.spongepowered.asm.lib.Attribute;

public class ModAttributes {
    public static final RegistryEntry<EntityAttribute> BLOCKING_AMOUNT = register("generic.blocking_amount", new ClampedEntityAttribute( // The amount that incoming damage is multiplied by when sword blocking. Closer to 0 = less damage.
            "attribute.terratonic.generic.blocking_amount",
            0.5,
            0.0,
            1.0).setTracked(true).setCategory(EntityAttribute.Category.NEGATIVE));

    private static RegistryEntry<EntityAttribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, Identifier.of(Terratonic.MOD_ID,id), attribute);
    }

    public static void registerAttributes() {
        Terratonic.LOGGER.info("Registering mod attributes!");
    }
}
