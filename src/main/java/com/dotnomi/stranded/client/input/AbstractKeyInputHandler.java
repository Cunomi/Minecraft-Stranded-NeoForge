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
        onKeyDown();
      }
      if (wasPressed) {
        onKeyPress();
      }
    }

    if (!keyMapping.isDown() && wasPressed) {
      onKeyUp();
      wasPressed = false;
    }
  }

  @SuppressWarnings("unused")
  public abstract void onClientTick(ClientTickEvent.Post event);

  @Override
  public void onKeyPress() {}

  @Override
  public void onKeyUp() {}

  @Override
  public void onKeyDown() {}
}
