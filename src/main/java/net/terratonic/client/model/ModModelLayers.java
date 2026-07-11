package net.terratonic.client.model;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.terratonic.Terratonic;

public class ModModelLayers {

    public static final EntityModelLayer CUSHION = new EntityModelLayer(
            Identifier.of(Terratonic.MOD_ID, "cushion"),
            "main"
    );
}
