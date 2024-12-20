package com.dotnomi.stranded.client.input.handler;

import com.dotnomi.stranded.client.input.AbstractKeyInputHandler;
import com.dotnomi.stranded.client.input.KeyMappings;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.slf4j.Logger;

public class VoiceoverSkipKeyInputHandler extends AbstractKeyInputHandler {
  private static final Logger LOGGER = LogUtils.getLogger();

  public VoiceoverSkipKeyInputHandler() {
    super(KeyMappings.KEY_SKIP_VOICE_OVER.get());
  }

  @Override
  @SubscribeEvent
  public void onClientTick(ClientTickEvent.Post event) {
    handleClientTick();
  }

  @Override
  public void onKeyPress(KeyMapping keyMapping) {
    LOGGER.debug("Voiceover skip key pressed");
  }
}
