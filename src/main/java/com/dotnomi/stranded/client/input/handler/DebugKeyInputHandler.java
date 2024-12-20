package com.dotnomi.stranded.client.input.handler;

import com.dotnomi.stranded.client.input.AbstractKeyInputHandler;
import com.dotnomi.stranded.client.input.KeyMappings;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.slf4j.Logger;

public class DebugKeyInputHandler extends AbstractKeyInputHandler {
  private static final Logger LOGGER = LogUtils.getLogger();

  public DebugKeyInputHandler() {
    super(KeyMappings.KEY_DEBUG.get());
  }

  @Override
  @SubscribeEvent
  public void onClientTick(ClientTickEvent.Post event) {
    handleClientTick();
  }

  @Override
  public void onKeyPress() {
    LOGGER.info("Debug key pressed");
  }
}
