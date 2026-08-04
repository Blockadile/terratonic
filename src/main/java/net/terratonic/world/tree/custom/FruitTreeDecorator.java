package net.terratonic.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.terratonic.world.tree.ModTreeDecorators;

import java.util.List;

public class FruitTreeDecorator extends TreeDecorator {
    public static final MapCodec<FruitTreeDecorator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.fieldOf("spawn_chance").forGetter(d -> d.spawnChance),
                    Codec.FLOAT.fieldOf("cardinal_chance").forGetter(d -> d.cardinalChance),
                    Codec.FLOAT.fieldOf("diagonal_chance").forGetter(d -> d.diagonalChance),
                    Codec.INT.fieldOf("y_offset").forGetter(d -> d.yOffset),
                    BlockStateProvider.TYPE_CODEC.fieldOf("provider").forGetter(d -> d.provider)
            ).apply(instance, FruitTreeDecorator::new)
    );

    private final float spawnChance;
    private final float cardinalChance;
    private final float diagonalChance;
    private final int yOffset;
    private final BlockStateProvider provider;

    public FruitTreeDecorator(float spawnChance, float cardinalChance, float diagonalChance, int yOffset, BlockStateProvider provider) {
        this.spawnChance = spawnChance;
        this.cardinalChance = cardinalChance;
        this.diagonalChance = diagonalChance;
        this.yOffset = yOffset;
        this.provider = provider;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.FRUIT_DECORATOR;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        List<BlockPos> logPositions = generator.getLogPositions();

        if (logPositions.isEmpty()) return;

        BlockPos topLogPos = logPositions.get(0);
        for (BlockPos pos : logPositions) {
            if (pos.getY() > topLogPos.getY()) {
                topLogPos = pos;
            }
        }

        BlockPos targetPos = topLogPos.up(this.yOffset);

        for (Direction direction : Direction.Type.HORIZONTAL) {
            if (random.nextFloat() < this.cardinalChance && random.nextFloat() < this.spawnChance) {
                BlockPos spawnPos = targetPos.offset(direction);
                placeFruit(generator, random, spawnPos);
            }
        }

        int[][] diagonals = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
        for (int[] offset : diagonals) {
            if (random.nextFloat() < this.diagonalChance && random.nextFloat() < this.spawnChance) {
                BlockPos spawnPos = targetPos.add(offset[0], 0, offset[1]);
                placeFruit(generator, random, spawnPos);
            }
        }
    }

    private void placeFruit(Generator generator, Random random, BlockPos pos) {
        if (generator.isAir(pos)) {
            BlockState state = this.provider.get(random, pos);
            generator.replace(pos, state);
        }
    }
}