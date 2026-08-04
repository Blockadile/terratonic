package net.terratonic.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.terratonic.Terratonic;
import net.terratonic.world.tree.custom.FruitTreeDecorator;

public class ModTreeDecorators {

    public static final TreeDecoratorType<FruitTreeDecorator> FRUIT_DECORATOR =
            Registry.register(
                    Registries.TREE_DECORATOR_TYPE,
                    Identifier.of(Terratonic.MOD_ID, "fruit_decorator"),
                    new TreeDecoratorType<>(FruitTreeDecorator.CODEC)
            );

    public static void registerModTreeDecorators() {
        Terratonic.LOGGER.info("Registering Mod Tree Decorators for " + Terratonic.MOD_ID);
    }
}
