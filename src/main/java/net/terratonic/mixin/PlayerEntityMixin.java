package net.terratonic.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
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
