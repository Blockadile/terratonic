package net.terratonic.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.terratonic.Terratonic;
import net.terratonic.world.tree.custom.PalmFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = Registry.register(
            Registries.FOLIAGE_PLACER_TYPE, Identifier.of(Terratonic.MOD_ID, "pine_foliage_placer"), new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));

    public static void registerModFoliage() {
        Terratonic.LOGGER.info("Registering Mod Foliage Placers for " + Terratonic.MOD_ID);
    }
}
