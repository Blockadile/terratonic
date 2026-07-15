package net.terratonic.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.terratonic.Terratonic;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1))
    private void onInit(CallbackInfo ci) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("wooden_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("stone_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("copper_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("iron_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("golden_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("diamond_scythe_2d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Terratonic.id("netherite_scythe_2d")));


    }
}