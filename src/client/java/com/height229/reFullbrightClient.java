package com.height229;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class reFullbrightClient implements ClientModInitializer {
    public static KeyBinding hotkey;
    public static int waitUntil = 0;

    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        hotkey = KeyBindingHelper.registerKeyBinding(new KeyBinding("refullbright.key.togglefullbright", InputUtil.Type.KEYSYM, 71, "key.categories.misc"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (hotkey.isPressed() && waitUntil > 5) {
                reFullbright.enabled = !reFullbright.enabled;
                waitUntil = 0;
            }
            waitUntil++;
        });
    }
}