package net.terratonic.world;

import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.terratonic.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.terratonic.Terratonic;
import net.terratonic.world.tree.custom.FruitTreeDecorator;
import net.terratonic.world.tree.custom.HugeWhiteMushroomFoliagePlacer;
import net.terratonic.world.tree.custom.PalmFoliagePlacer;
import net.terratonic.world.tree.custom.PalmTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM = registerKey("huge_white_mushroom");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // Palm
        ConfiguredFeatures.register(context, PALM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.PALM_LOG),
                        new PalmTrunkPlacer(6, 3, 2),
                        BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                        new PalmFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(List.of(new FruitTreeDecorator(
                                0.44f,
                                0.5f,
                                0.25f,
                                -2,
                                BlockStateProvider.of(ModBlocks.COCONUT)))
                ).build()
        );

        // White Mushroom
        ConfiguredFeatures.register(context, HUGE_WHITE_MUSHROOM, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.MUSHROOM_STEM.getDefaultState()
                        .with(MushroomBlock.UP, true)
                        .with(MushroomBlock.DOWN, true)),
                new StraightTrunkPlacer(4, 2, 1),
                BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM_BLOCK.getDefaultState()
                        .with(MushroomBlock.DOWN, true)),
                new HugeWhiteMushroomFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2))).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Terratonic.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
