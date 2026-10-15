package net.terratonic.block.custom;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.terratonic.screen.custom.WorkbenchScreenHandler;
import org.jetbrains.annotations.Nullable;

public class Workbench extends CraftingTableBlock {
    public static final MapCodec<Workbench> CODEC = createCodec(Workbench::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final Text TITLE = Text.translatable("container.workbench");

    public MapCodec<Workbench> getCodec() {
        return CODEC;
    }

    public Workbench(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
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

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            return ActionResult.CONSUME;
        }
        return ActionResult.SUCCESS;
    }

    protected ExtendedScreenHandlerFactory<BlockPos> createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new ExtendedScreenHandlerFactory<>() {
            @Override
            public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
                return pos;
            }

            @Override
            public Text getDisplayName() {
                return Text.empty();
            }

            @Override
            public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                return new WorkbenchScreenHandler(syncId, playerInventory, ScreenHandlerContext.create(world, pos));
            }
        };
//        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new WorkbenchScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE);
    }
}