package net.terratonic.block.custom;

import com.mojang.serialization.MapCodec;
import net.terratonic.block.ModBlocks;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineLogic;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

public class HangingCaveRootsBlock extends AbstractPlantStemBlock {
    public static final MapCodec<HangingCaveRootsBlock> CODEC = HangingCaveRootsBlock.createCodec(HangingCaveRootsBlock::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)4.0F, (double)9.0F, (double)4.0F, (double)12.0F, (double)16.0F, (double)12.0F);

    public HangingCaveRootsBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }

    @Override
    protected MapCodec<? extends AbstractPlantStemBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.HANGING_CAVE_ROOTS_PLANT;
    }

    @Override
    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
}
