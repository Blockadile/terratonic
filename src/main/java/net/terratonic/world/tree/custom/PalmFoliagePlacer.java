package net.terratonic.world.tree.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.terratonic.world.tree.ModFoliagePlacerTypes;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance).apply(instance, PalmFoliagePlacer::new)
    );

    public PalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos center = treeNode.getCenter();

        BlockPos layer0 = center.down(1);
        placeLeaf(world, placer, random, config, layer0.east());
        placeLeaf(world, placer, random, config, layer0.west());
        placeLeaf(world, placer, random, config, layer0.north());
        placeLeaf(world, placer, random, config, layer0.south());

        placeLeaf(world, placer, random, config, layer0.east(3));
        placeLeaf(world, placer, random, config, layer0.west(3));
        placeLeaf(world, placer, random, config, layer0.north(3));
        placeLeaf(world, placer, random, config, layer0.south(3));

        placeLeaf(world, placer, random, config, layer0.east(4));
        placeLeaf(world, placer, random, config, layer0.west(4));
        placeLeaf(world, placer, random, config, layer0.north(4));
        placeLeaf(world, placer, random, config, layer0.south(4));

        placeLeaf(world, placer, random, config, layer0.add(2, 0, 2));
        placeLeaf(world, placer, random, config, layer0.add(-2, 0, 2));
        placeLeaf(world, placer, random, config, layer0.add(2, 0, -2));
        placeLeaf(world, placer, random, config, layer0.add(-2, 0, -2));

        BlockPos layer1 = center;

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (x == 0 && z == 0) continue; // Trunk block center
                placeLeaf(world, placer, random, config, layer1.add(x, 0, z));
            }
        }

        for (int i = 2; i <= 3; i++) {
            placeLeaf(world, placer, random, config, layer1.east(i));
            placeLeaf(world, placer, random, config, layer1.west(i));
            placeLeaf(world, placer, random, config, layer1.north(i));
            placeLeaf(world, placer, random, config, layer1.south(i));
        }

        placeLeaf(world, placer, random, config, layer1.add(2, 0, 2));
        placeLeaf(world, placer, random, config, layer1.add(2, 0, 1));
        placeLeaf(world, placer, random, config, layer1.add(1, 0, 2));
        placeLeaf(world, placer, random, config, layer1.add(-2, 0, 2));
        placeLeaf(world, placer, random, config, layer1.add(-2, 0, 1));
        placeLeaf(world, placer, random, config, layer1.add(-1, 0, 2));
        placeLeaf(world, placer, random, config, layer1.add(2, 0, -2));
        placeLeaf(world, placer, random, config, layer1.add(2, 0, -1));
        placeLeaf(world, placer, random, config, layer1.add(1, 0, -2));
        placeLeaf(world, placer, random, config, layer1.add(-2, 0, -2));
        placeLeaf(world, placer, random, config, layer1.add(-2, 0, -1));
        placeLeaf(world, placer, random, config, layer1.add(-1, 0, -2));

        BlockPos layer2 = center.up(1);

        placeFoliageBlock(world, placer, random, config, layer2);
        placeLeaf(world, placer, random, config, layer2.east());
        placeLeaf(world, placer, random, config, layer2.west());
        placeLeaf(world, placer, random, config, layer2.north());
        placeLeaf(world, placer, random, config, layer2.south());
    }

    private void placeLeaf(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos) {
        placeFoliageBlock(world, placer, random, config, pos);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 3;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giant) {
        return false;
    }
}
