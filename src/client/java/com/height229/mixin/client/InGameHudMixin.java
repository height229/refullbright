package com.height229.mixin.client;

import com.height229.reFullbright;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("RETURN"))
    public void changeGamma(DrawContext context, float tickDelta, CallbackInfo ci) {
        if(reFullbright.enabled) {
            MinecraftClient client = MinecraftClient.getInstance();
            client.options.getGamma().setValue(1500.0);
        }else {
            MinecraftClient client = MinecraftClient.getInstance();
            client.options.getGamma().setValue(1.0);
        }
    }

}