package net.terratonic.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class ShelfMushroomBlock extends Block implements Fertilizable {
    public static final int MAX_AGE = 1;
    public static final IntProperty AGE = IntProperty.of("age", 0, 1);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    // Shapes
    private static final VoxelShape SHAPE_NORTH_SMALL = Block.createCuboidShape(3, 9, 9, 13, 11, 16);
    private static final VoxelShape SHAPE_SOUTH_SMALL = Block.createCuboidShape(5, 3, 0, 11, 13, 2);
    private static final VoxelShape SHAPE_EAST_SMALL = Block.createCuboidShape(0, 3, 5, 2, 13, 11);
    private static final VoxelShape SHAPE_WEST_SMALL = Block.createCuboidShape(14, 3, 5, 16, 13, 11);

    private static final VoxelShape SHAPE_NORTH_LARGE = Block.createCuboidShape(5, 3, 14, 11, 13, 16);
    private static final VoxelShape SHAPE_SOUTH_LARGE = Block.createCuboidShape(5, 3, 0, 11, 13, 2);
    private static final VoxelShape SHAPE_EAST_LARGE = Block.createCuboidShape(0, 3, 5, 2, 13, 11);
    private static final VoxelShape SHAPE_WEST_LARGE = Block.createCuboidShape(14, 3, 5, 16, 13, 11);

    public ShelfMushroomBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(AGE, 0).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE, FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        int age = state.get(AGE);

        if (age == 0) {
            return switch (facing) {
                case NORTH -> SHAPE_NORTH_SMALL;
                case SOUTH -> SHAPE_SOUTH_SMALL;
                case EAST -> SHAPE_EAST_SMALL;
                case WEST -> SHAPE_WEST_SMALL;
                default -> SHAPE_NORTH_SMALL;
            };
        } else {
            return switch (facing) {
                case NORTH -> SHAPE_NORTH_LARGE;
                case SOUTH -> SHAPE_SOUTH_LARGE;
                case EAST -> SHAPE_EAST_LARGE;
                case WEST -> SHAPE_WEST_LARGE;
                default -> SHAPE_NORTH_LARGE;
            };
        }
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int age = state.get(AGE);
        if (age < MAX_AGE) {
            BlockState blockState = state.with(AGE, age + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    }
}
