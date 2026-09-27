package net.terratonic.screen.custom;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.terratonic.block.ModBlocks;
import net.terratonic.screen.ModScreenHandlers;
import org.jetbrains.annotations.Nullable;

public class WorkbenchScreenHandler extends ScreenHandler {
    //private final Inventory inventory;
    private final ScreenHandlerContext context;

    public WorkbenchScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public WorkbenchScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.WORKBENCH_SCREEN_HANDLER, syncId);
        this.context = context;

        //this.addSlot(new Slot(inventory, 0 , 46, 38));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

//    @Override
//    public ItemStack quickMove(PlayerEntity player, int invSlot) {
//        ItemStack newStack = ItemStack.EMPTY;
//        Slot slot = this.slots.get(invSlot);
//        if (slot != null && slot.hasStack()) {
//            ItemStack originalStack = slot.getStack();
//            newStack = originalStack.copy();
//            if (invSlot < this.inventory.size()) {
//                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            }
//            else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (originalStack.isEmpty()) {
//                slot.setStack(ItemStack.EMPTY);
//            } else {
//                slot.markDirty();
//            }
//        }
//        return newStack;
//    }

//    public void onClosed(PlayerEntity player) {
//        super.onClosed(player);
//        this.context.run((world, pos) -> this.dropInventory(player, this.input));
//    }

    @Override //delete later to replace with commented version of method
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory,(9 * (i + 1)) + l, 8 + l *18, 84 + i *18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + (i * 18), 142));
        }
    }
}
