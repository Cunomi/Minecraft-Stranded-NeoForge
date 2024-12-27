package com.dotnomi.stranded.client.input.handler;

import com.dotnomi.stranded.client.input.AbstractKeyInputHandler;
import com.dotnomi.stranded.client.input.KeyMappings;
import com.dotnomi.stranded.event.VoiceoverEvent;
import com.dotnomi.stranded.networking.packet.KeyInputC2SPacket;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;
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
  public void onKeyPress(KeyMapping keyMapping) {
    LOGGER.debug("Debug key pressed");
  }

  @Override
  public void onKeyDown(KeyMapping keyMapping) {
    PacketDistributor.sendToServer(new KeyInputC2SPacket(keyMapping.getName()));
    NeoForge.EVENT_BUS.post(new VoiceoverEvent("test"));
  }
}
