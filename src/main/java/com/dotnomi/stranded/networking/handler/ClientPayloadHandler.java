package com.dotnomi.stranded.networking.handler;

import com.dotnomi.stranded.networking.packet.PlayVoiceoverS2CPacket;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.slf4j.Logger;

public class ClientPayloadHandler {
  private static final Logger LOGGER = LogUtils.getLogger();

  public static void handlePlayVoiceover(final PlayVoiceoverS2CPacket payload, final IPayloadContext context) {
    context.enqueueWork(() -> {
      LOGGER.debug("Received PlayVoiceoverS2CPacket {voiceoverId:{}}", payload.voiceoverId());
    }).exceptionally(exception -> {
      context.disconnect(Component.translatable("stranded.networking.failed", exception.getMessage()));
      LOGGER.error(exception.getMessage(), exception);
      return null;
    });
  }
}
