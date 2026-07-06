package net.terratonic.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(HoeItem.class)
public class HoeItemMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void onUseBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        BlockPos start = pos.add(-1, 0, -1);
        BlockPos end = pos.add(1, 0, 1);
        boolean harvest = false;

        for (BlockPos currentPos : BlockPos.iterate(start, end)) {
            BlockState state = world.getBlockState(currentPos);

            if (tryHarvest(world, currentPos, state, context.getPlayer())) {
                harvest = true;
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
            cir.setReturnValue(ActionResult.success(world.isClient));
        }
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
}
