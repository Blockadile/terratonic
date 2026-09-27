package net.terratonic.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.terratonic.Terratonic;
import net.terratonic.screen.custom.WorkbenchScreenHandler;

public class ModScreenHandlers {
    public static final ScreenHandlerType<WorkbenchScreenHandler> WORKBENCH_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Terratonic.MOD_ID, "workbench_screen_handler"),
                    new ExtendedScreenHandlerType<>(WorkbenchScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Terratonic.LOGGER.info("Registering Screen Handlers for " + Terratonic.MOD_ID);
    }
}
