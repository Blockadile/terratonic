package net.terratonic.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.terratonic.Terratonic;
import net.terratonic.world.tree.custom.PalmTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = Registry.register(
            Registries.TRUNK_PLACER_TYPE, Identifier.of(Terratonic.MOD_ID, "pine_trunk_placer"), new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));

    public static void registerModTrunks() {
        Terratonic.LOGGER.info("Registering Mod Trunk Placers for " + Terratonic.MOD_ID);
    }
}
