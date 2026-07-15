package net.terratonic.item.custom;

import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class ProspectingPickaxeItem extends PickaxeItem {
    public ProspectingPickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        return ActionResult.success(world.isClient);
    }
}
