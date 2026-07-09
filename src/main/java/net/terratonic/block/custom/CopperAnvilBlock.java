package net.terratonic.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.terratonic.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class CopperAnvilBlock extends FallingBlock {
    public static final MapCodec<CopperAnvilBlock> CODEC = createCodec(CopperAnvilBlock::new);
    public static final DirectionProperty FACING;
    private static final VoxelShape BASE_SHAPE;
    private static final VoxelShape X_STEP_SHAPE;
    private static final VoxelShape X_STEM_SHAPE;
    private static final VoxelShape X_FACE_SHAPE;
    private static final VoxelShape Z_STEP_SHAPE;
    private static final VoxelShape Z_STEM_SHAPE;
    private static final VoxelShape Z_FACE_SHAPE;
    private static final VoxelShape X_AXIS_SHAPE;
    private static final VoxelShape Z_AXIS_SHAPE;
    private static final float FALLING_BLOCK_ENTITY_DAMAGE_MULTIPLIER = 2.0F;
    private static final int FALLING_BLOCK_ENTITY_MAX_DAMAGE = 40;

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return CODEC;
    }

    public CopperAnvilBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().rotateYClockwise());
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
    }

    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(2.0F, 40);
    }

    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            world.syncWorldEvent(1031, pos, 0);
        }

    }

    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            world.syncWorldEvent(1029, pos, 0);
        }

    }

    public DamageSource getDamageSource(Entity attacker) {
        return attacker.getDamageSources().fallingAnvil(attacker);
    }

    @Nullable
    public static BlockState getLandingState(BlockState fallingState) {
        return ModBlocks.COPPER_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING));
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        BASE_SHAPE = Block.createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)4.0F, (double)14.0F);
        X_STEP_SHAPE = Block.createCuboidShape((double)3.0F, (double)4.0F, (double)4.0F, (double)13.0F, (double)5.0F, (double)12.0F);
        X_STEM_SHAPE = Block.createCuboidShape((double)4.0F, (double)5.0F, (double)6.0F, (double)12.0F, (double)10.0F, (double)10.0F);
        X_FACE_SHAPE = Block.createCuboidShape((double)0.0F, (double)10.0F, (double)3.0F, (double)16.0F, (double)16.0F, (double)13.0F);
        Z_STEP_SHAPE = Block.createCuboidShape((double)4.0F, (double)4.0F, (double)3.0F, (double)12.0F, (double)5.0F, (double)13.0F);
        Z_STEM_SHAPE = Block.createCuboidShape((double)6.0F, (double)5.0F, (double)4.0F, (double)10.0F, (double)10.0F, (double)12.0F);
        Z_FACE_SHAPE = Block.createCuboidShape((double)3.0F, (double)10.0F, (double)0.0F, (double)13.0F, (double)16.0F, (double)16.0F);
        X_AXIS_SHAPE = VoxelShapes.union(BASE_SHAPE, new VoxelShape[]{X_STEP_SHAPE, X_STEM_SHAPE, X_FACE_SHAPE});
        Z_AXIS_SHAPE = VoxelShapes.union(BASE_SHAPE, new VoxelShape[]{Z_STEP_SHAPE, Z_STEM_SHAPE, Z_FACE_SHAPE});
    }
}
