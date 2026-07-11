package net.terratonic.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.terratonic.entity.custom.CushionEntity;

public class CushionItem extends Item {
    private final DyeColor color;
    private final EntityType<? extends CushionEntity> entityType;

    public CushionItem(EntityType<? extends CushionEntity> type, DyeColor color, Settings settings) {
        super(settings);
        this.color = color;
        this.entityType = type;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos clickedPos = context.getBlockPos();
        Direction side = context.getSide();

        if (side != Direction.UP) {
            return ActionResult.FAIL;
        }

        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        double spawnX = clickedPos.getX() + 0.5;
        double spawnY = context.getHitPos().y;
        double spawnZ = clickedPos.getZ() + 0.5;

        BlockPos permissionCheckPos = clickedPos.up();
        if (player != null && !player.canPlaceOn(permissionCheckPos, side, stack)) {
            return ActionResult.FAIL;
        }

        if (!world.isClient) {
            CushionEntity cushion = new CushionEntity(this.entityType, world, spawnX, spawnY, spawnZ, clickedPos);
            cushion.setColor(this.color);

            if (player != null) {
                cushion.setFacing(player.getHorizontalFacing().getOpposite());
            }

            NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT);
            if (!nbtComponent.isEmpty()) {
                EntityType.loadFromEntityNbt(world, player, cushion, nbtComponent);
            }

            world.emitGameEvent(player, GameEvent.ENTITY_PLACE, cushion.getPos());
            world.spawnEntity(cushion);

            stack.decrement(1);
            return ActionResult.SUCCESS;
        }

        return ActionResult.success(world.isClient);
    }
}
