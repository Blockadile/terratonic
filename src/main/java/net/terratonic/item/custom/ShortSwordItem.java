package net.terratonic.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ShortSwordItem extends SwordItem {
    public ShortSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (remainingUseTicks == 71980) {
            user.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER);
        }
        super.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (remainingUseTicks <= 71980 && user.isOnGround()) {
            double distance = 1.5f;
            double d = -MathHelper.sin(user.getYaw() * (float) (Math.PI / 180.0));
            double e = MathHelper.cos(user.getYaw() * (float) (Math.PI / 180.0));
            double p = -(user.getPitch() * (float) (Math.PI / 180.0));
            user.addVelocity(d *  distance,0.2 + (p/6) * distance,e * distance);
        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
}
