package net.terratonic.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.terratonic.item.custom.ScytheItem;
import net.terratonic.item.custom.SickleItem;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "attack", at = @At("STORE"), ordinal = 3)
    private boolean weaponSweep(boolean originalValue) {
        ItemStack handStack = this.getStackInHand(Hand.MAIN_HAND);

        if (handStack.getItem() instanceof SickleItem || handStack.getItem() instanceof ScytheItem) {
            return true;
        }

        return originalValue;
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float halveDamage(float amount) {
        if (this.activeItemStack != null && activeItemStack.getItem() instanceof SwordItem) {
            amount *= 0.5f;
            activeItemStack.damage(3, this, getSlotForHand(Hand.MAIN_HAND));
        }
        return amount;
    }
}
