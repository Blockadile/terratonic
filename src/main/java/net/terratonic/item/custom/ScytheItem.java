package net.terratonic.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ScytheItem extends HoeItem {
    public ScytheItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        BlockPos start = pos.add(-1, 0, -1);
        BlockPos end = pos.add(1, 0, 1);
        boolean harvest = false;
        boolean till = false;

        for (BlockPos currentPos : BlockPos.iterate(start, end)) {
            mutablePos.set(currentPos);
            BlockState state = world.getBlockState(currentPos);

            if (tryHarvest(world, mutablePos, state, context.getPlayer())) {
                harvest = true;
            }
            if (tryTill(world, mutablePos, state, context)) {
                till = true;
            }
        }

        if (harvest) {
            world.playSound(
                    (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                    SoundEvents.BLOCK_CROP_BREAK,
                    SoundCategory.BLOCKS,
                    1.0f, // Volume
                    1.0f, // Pitch
                    false
            );
            if (!world.isClient && context.getPlayer() instanceof ServerPlayerEntity serverPlayer) {
                ItemStack hoeStack = context.getStack();
                hoeStack.damage(1, (ServerWorld) world, serverPlayer, (item) -> {
                    serverPlayer.sendEquipmentBreakStatus(item, LivingEntity.getSlotForHand(context.getHand()));
                });
            }
            return ActionResult.success(world.isClient);
        } else if (till) {
            world.playSound(
                    (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                    SoundEvents.ITEM_HOE_TILL,
                    SoundCategory.BLOCKS,
                    1.0f, // Volume
                    1.0f, // Pitch
                    false
            );
            if (!world.isClient && context.getPlayer() instanceof ServerPlayerEntity serverPlayer) {
                ItemStack hoeStack = context.getStack();
                hoeStack.damage(1, (ServerWorld) world, serverPlayer, (item) -> {
                    serverPlayer.sendEquipmentBreakStatus(item, LivingEntity.getSlotForHand(context.getHand()));
                });
            }
            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

    private boolean tryHarvest(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.getBlock() instanceof CropBlock crop && crop.isMature(state)) {
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) world;

                LootContextParameterSet.Builder builder = new LootContextParameterSet.Builder(serverWorld)
                        .add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos))
                        .add(LootContextParameters.TOOL, player.getStackInHand(player.getActiveHand()));

                List<ItemStack> drops = state.getDroppedStacks(builder);

                for (ItemStack drop : drops) {
                    Block.dropStack(world, pos, drop);
                }

                world.setBlockState(pos, crop.withAge(0), 2);

            }
            return true;
        }
        return false;
    }

    private boolean tryTill(World world, BlockPos pos, BlockState state, ItemUsageContext context) {
        var tillingAction = TILLING_ACTIONS.get(state.getBlock());
        if (tillingAction == null) {
            return false;
        }

        BlockHitResult hitResult = new BlockHitResult(context.getHitPos(), context.getSide(), pos.toImmutable(), context.hitsInsideBlock());
        ItemUsageContext itemUsageContext = new ItemUsageContext(
                context.getPlayer(), context.getHand(), hitResult.withBlockPos(pos.toImmutable()));

        Predicate<ItemUsageContext> canTill = tillingAction.getFirst();
        Consumer<ItemUsageContext> doTill = tillingAction.getSecond();

        if (canTill.test(itemUsageContext)) {
            if (!world.isClient) {
                doTill.accept(itemUsageContext);
            }
            return true;
        }
        return false;
    }
}
