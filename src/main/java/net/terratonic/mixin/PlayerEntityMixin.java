package net.terratonic.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.terratonic.item.custom.ScytheItem;
import net.terratonic.item.custom.SickleItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @ModifyVariable(method = "attack", at = @At("STORE"), ordinal = 3)
    private boolean sweepingWeapons(boolean value) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);

        if (itemStack.getItem() instanceof SickleItem || itemStack.getItem() instanceof ScytheItem) {
            return true;
        }
        return value;
    }
}
