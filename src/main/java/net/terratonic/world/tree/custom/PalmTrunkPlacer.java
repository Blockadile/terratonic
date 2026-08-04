package net.terratonic.world.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.terratonic.world.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, PalmTrunkPlacer::new)
    );

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);

        Direction bendDirection = Direction.Type.HORIZONTAL.random(random);
        BlockPos.Mutable mutable = startPos.mutableCopy();

        int minBendHeight = 3;
        int maxBendHeight = Math.max(minBendHeight, height - 3);

        int bendHeight = minBendHeight + (maxBendHeight > minBendHeight ? random.nextInt(maxBendHeight - minBendHeight + 1) : 0);

        BlockPos topLogPos = mutable.toImmutable();

        for (int i = 0; i < height; i++) {
            if (i == bendHeight) {
                mutable.move(bendDirection);

                BlockPos connectorPos = mutable.down();
                if (TreeFeature.canReplace(world, connectorPos)) {
                    this.getAndSetState(world, replacer, random, connectorPos, config);
                }
            }

            if (TreeFeature.canReplace(world, mutable)) {
                this.getAndSetState(world, replacer, random, mutable, config);
            }

            if (i == height - 1) {
                topLogPos = mutable.toImmutable();
            } else {
                mutable.move(Direction.UP);
            }
        }

        List<FoliagePlacer.TreeNode> nodes = Lists.newArrayList();
        nodes.add(new FoliagePlacer.TreeNode(topLogPos, 0, false));

        return nodes;
    }
}