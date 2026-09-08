package net.terratonic.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.terratonic.world.tree.ModFoliagePlacerTypes;

public class HugeWhiteMushroomFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<HugeWhiteMushroomFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            fillFoliagePlacerFields(instance)
                    .and(Codec.intRange(0, 12).fieldOf("height").forGetter(p -> p.height))
                    .apply(instance, (radius, offset, height) -> new HugeWhiteMushroomFoliagePlacer(radius, offset, height))
    );
    private final int height;

    public HugeWhiteMushroomFoliagePlacer(IntProvider radius, IntProvider offset, Integer height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.HUGE_WHITE_MUSHROOM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, FoliagePlacer.TreeNode treeNode, int foliageHeight, int radius, int offset) {

        generateSquare(world, placer, random, config, treeNode.getCenter().up(-3), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(-2), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(-1), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 0, 0, treeNode.isGiantTrunk());
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == -1) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        } else {
            return dx == radius && dz == radius && radius > 0;
        }
    }
}
