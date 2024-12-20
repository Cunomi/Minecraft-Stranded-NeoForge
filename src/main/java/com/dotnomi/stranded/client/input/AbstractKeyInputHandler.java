package com.dotnomi.stranded.client.input;

import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.ClientTickEvent;

public abstract class AbstractKeyInputHandler implements IKeyInputHandler {
  private final KeyMapping keyMapping;
  private boolean wasPressed = false;

  public AbstractKeyInputHandler(KeyMapping keyMapping) {
    this.keyMapping = keyMapping;
  }

  public void handleClientTick() {
    while (keyMapping.consumeClick()) {
      if (!wasPressed) {
        wasPressed = true;
        onKeyDown(keyMapping);
      }
      if (wasPressed) {
        onKeyPress(keyMapping);
      }
    }

    if (!keyMapping.isDown() && wasPressed) {
      onKeyUp(keyMapping);
      wasPressed = false;
    }
  }

  @SuppressWarnings("unused")
  public abstract void onClientTick(ClientTickEvent.Post event);

  @Override
  public void onKeyPress(KeyMapping keyMapping) {}

  @Override
  public void onKeyUp(KeyMapping keyMapping) {}

  @Override
  public void onKeyDown(KeyMapping keyMapping) {}
}
