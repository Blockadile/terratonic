package net.terratonic.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.function.BiFunction;

public class LeafLitterBlock extends Block {
    public static final MapCodec<LeafLitterBlock> CODEC = createCodec(LeafLitterBlock::new);
    public static final DirectionProperty FACING;
    public static final IntProperty AMOUNT;
    private static final BiFunction<Direction, Integer, VoxelShape> FACING_AND_AMOUNT_TO_SHAPE;

    public MapCodec<LeafLitterBlock> getCodec() {
        return CODEC;
    }

    public LeafLitterBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(AMOUNT, 1));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos floorPos = pos.down();
        return sideCoversSmallSquare(world, floorPos, Direction.UP);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().isOf(this.asItem()) && state.get(AMOUNT) < 4 ? true : super.canReplace(state, context);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FACING_AND_AMOUNT_TO_SHAPE.apply(state.get(FACING), state.get(AMOUNT));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        return blockState.isOf(this) ? blockState.with(AMOUNT, Math.min(4, blockState.get(AMOUNT) + 1)) : this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, AMOUNT);
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        AMOUNT = Properties.FLOWER_AMOUNT;
        FACING_AND_AMOUNT_TO_SHAPE = Util.memoize((facing, flowerAmount) -> {
            VoxelShape[] voxelShapes = new VoxelShape[]{
                    Block.createCuboidShape(8.0F, 0.0F, 8.0F, 16.0F, 3.0F, 16.0F),
                    Block.createCuboidShape(8.0F, 0.0F, 0.0F, 16.0F, 3.0F, 8.0F),
                    Block.createCuboidShape(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 8.0F),
                    Block.createCuboidShape(0.0F, 0.0F, 8.0F, 8.0F, 3.0F, 16.0F)
            };
            VoxelShape voxelShape = VoxelShapes.empty();

            for(int i = 0; i < flowerAmount; ++i) {
                int j = Math.floorMod(i - facing.getHorizontal(), 4);
                voxelShape = VoxelShapes.union(voxelShape, voxelShapes[j]);
            }

            return voxelShape.asCuboid();
        });
    }
}
