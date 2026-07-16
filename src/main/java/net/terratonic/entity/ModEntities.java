package net.terratonic.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;
import net.terratonic.entity.custom.CushionEntity;

public class ModEntities {

    public static final EntityType<CushionEntity> CUSHION = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Terratonic.MOD_ID, "cushion"),
            EntityType.Builder.<CushionEntity>create(CushionEntity::new, SpawnGroup.MISC)
                    .dimensions(1.001f, 0.251f)
                    .build()
    );

    public static void registerModEntities() {
        Terratonic.LOGGER.info("Registering Mod Entities for " + Terratonic.MOD_ID);
    }
}
