package net.terratonic.sounds;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class ModSoundGroups {

    public static final BlockSoundGroup TANGLED_ROOTS = new BlockSoundGroup(
            1.0F, // volume
            1.0F, // pitch
            SoundEvents.BLOCK_MANGROVE_ROOTS_BREAK,
            SoundEvents.BLOCK_MANGROVE_ROOTS_STEP,
            SoundEvents.ITEM_CROP_PLANT,
            SoundEvents.BLOCK_GRASS_HIT,
            SoundEvents.BLOCK_MANGROVE_ROOTS_FALL
    );
    public static final BlockSoundGroup LEAF_LITTER = new BlockSoundGroup(
            1.0F, // volume
            1.0F, // pitch
            ModSounds.LEAF_LITTER_BREAK,
            ModSounds.LEAF_LITTER_STEP,
            ModSounds.LEAF_LITTER_PLACE,
            ModSounds.LEAF_LITTER_STEP,
            ModSounds.LEAF_LITTER_STEP
    );
    public static final BlockSoundGroup THATCH = new BlockSoundGroup(
            1.0F, // volume
            1.0F, // pitch
            ModSounds.THATCH_BREAK,
            ModSounds.THATCH_STEP,
            ModSounds.THATCH_PLACE,
            ModSounds.THATCH_HIT,
            ModSounds.THATCH_STEP
    );
}
