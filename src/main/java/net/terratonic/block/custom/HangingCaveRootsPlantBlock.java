package net.terratonic.block.custom;

import com.mojang.serialization.MapCodec;
import net.terratonic.block.ModBlocks;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class HangingCaveRootsPlantBlock extends AbstractPlantBlock {
    public static final MapCodec<HangingCaveRootsPlantBlock> CODEC = HangingCaveRootsPlantBlock.createCodec(HangingCaveRootsPlantBlock::new);
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);

    public HangingCaveRootsPlantBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected MapCodec<? extends AbstractPlantBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) ModBlocks.HANGING_CAVE_ROOTS;
    }
}
