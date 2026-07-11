package net.terratonic.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.terratonic.item.ModItems;
import net.terratonic.sounds.ModSounds;

public class CushionEntity extends Entity {
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(CushionEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Direction> FACING = DataTracker.registerData(CushionEntity.class, TrackedDataHandlerRegistry.FACING);
    private BlockPos attachedBlockPos;

    public CushionEntity(EntityType<?> type, World world) {
        super(type, world);
        this.attachedBlockPos = BlockPos.ORIGIN;
    }

    public CushionEntity(EntityType<?> type, World world, double x, double y, double z, BlockPos clickedBlock) {
        this(type, world);
        this.setPosition(x, y, z);
        this.attachedBlockPos = clickedBlock;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isRemoved() || this.getWorld().isClient) {
            return false;
        }

        if (source.getAttacker() instanceof PlayerEntity player && !player.isCreative()) {
            Item itemToDrop = getCushionItemByColor(this.getColor());
            this.dropItem(itemToDrop);
        }

        this.discard();
        return true;
    }

    private Item getCushionItemByColor(DyeColor color) {
        return switch (color) {
            case WHITE -> ModItems.WHITE_CUSHION;
            case LIGHT_GRAY -> ModItems.LIGHT_GRAY_CUSHION;
            case GRAY -> ModItems.GRAY_CUSHION;
            case BLACK -> ModItems.BLACK_CUSHION;
            case BROWN -> ModItems.BROWN_CUSHION;
            case RED -> ModItems.RED_CUSHION;
            case ORANGE -> ModItems.ORANGE_CUSHION;
            case YELLOW -> ModItems.YELLOW_CUSHION;
            case LIME -> ModItems.LIME_CUSHION;
            case GREEN -> ModItems.GREEN_CUSHION;
            case CYAN -> ModItems.CYAN_CUSHION;
            case LIGHT_BLUE -> ModItems.LIGHT_BLUE_CUSHION;
            case BLUE -> ModItems.BLUE_CUSHION;
            case PURPLE -> ModItems.PURPLE_CUSHION;
            case MAGENTA -> ModItems.MAGENTA_CUSHION;
            case PINK -> ModItems.PINK_CUSHION;
        };
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        }

        if (!this.getWorld().isClient) {
            if (this.getPassengerList().isEmpty()) {
                player.startRiding(this);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.success(this.getWorld().isClient);
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scale) {
        return new Vec3d(0.0, 0.25, 0.0);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient) {
            if (this.getWorld().getBlockState(this.getBlockPos()).isOf(Blocks.MOVING_PISTON)) {
                Item itemToDrop = getCushionItemByColor(this.getColor());
                this.dropItem(itemToDrop);
                this.discard();
                return;
            }
        }

        this.baseTick();
    }

    @Override
    public boolean canHit() {
        return !this.isRemoved();
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(COLOR, 0); // The default is white
        builder.add(FACING, Direction.NORTH);
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.dataTracker.get(COLOR));
    }

    public void setColor(DyeColor color) {
        this.dataTracker.set(COLOR, color.getId());
    }

    public Direction getFacing() {
        return this.dataTracker.get(FACING);
    }

    public void setFacing(Direction direction) {
        this.dataTracker.set(FACING, direction);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setColor(DyeColor.byName(nbt.getString("Color"), DyeColor.WHITE));
        this.setFacing(Direction.byName(nbt.getString("Facing")));
        if (nbt.contains("TileX", 99) && nbt.contains("TileZ", 99) && nbt.contains("TileZ", 99)) {
            this.attachedBlockPos = new BlockPos(nbt.getInt("TileX"), nbt.getInt("TileY"), nbt.getInt("TileZ"));
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString("Color", this.getColor().getName());
        nbt.putString("Facing", this.getFacing().getName());
        nbt.putInt("TileX", this.attachedBlockPos.getX());
        nbt.putInt("TileY", this.attachedBlockPos.getY());
        nbt.putInt("TileZ", this.attachedBlockPos.getZ());
    }
}
