package com.dotnomi.stranded.client.input;

import net.minecraft.client.KeyMapping;

public interface IKeyInputHandler {
  void onKeyPress(KeyMapping keyMapping);
  void onKeyUp(KeyMapping keyMapping);
  void onKeyDown(KeyMapping keyMapping);
}
