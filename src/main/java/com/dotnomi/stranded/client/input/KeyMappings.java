package com.dotnomi.stranded.client.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class KeyMappings {
  public static final Lazy<KeyMapping> KEY_DEBUG = Lazy.of(() -> new KeyMapping(
    "key.stranded.debug",
    InputConstants.Type.KEYSYM,
    GLFW.GLFW_KEY_O,
    "key.categories.stranded"
  ));

  public static final Lazy<KeyMapping> KEY_SKIP_VOICE_OVER = Lazy.of(() -> new KeyMapping(
    "key.stranded.skip_voice_over",
    InputConstants.Type.KEYSYM,
    GLFW.GLFW_KEY_ENTER,
    "key.categories.stranded"
  ));

  public static void register(RegisterKeyMappingsEvent event) {
    event.register(KEY_DEBUG.get());
    event.register(KEY_SKIP_VOICE_OVER.get());
  }
}
