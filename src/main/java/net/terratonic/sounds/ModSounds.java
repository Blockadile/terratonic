package net.terratonic.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;

public class ModSounds {

    public static final SoundEvent CUSHION_BREAK = registerSound("cushion_break");

    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(Terratonic.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        Terratonic.LOGGER.info("Registering Mod Sounds for " + Terratonic.MOD_ID);
    }
}