package net.terratonic.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.terratonic.Terratonic;
import net.terratonic.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator PALM_TREE = new SaplingGenerator(Terratonic.MOD_ID + ":palm_tree", 0.25F,
            Optional.empty(), Optional.empty(),
            Optional.of(ModConfiguredFeatures.PALM_TREE_KEY), Optional.empty(),
            Optional.empty(), Optional.empty());
}
