package com.dotnomi.stranded.networking.handler;

import com.dotnomi.stranded.data.LevelDataStorage;
import com.dotnomi.stranded.data.LevelDataStorageManager;
import com.dotnomi.stranded.networking.packet.KeyInputC2SPacket;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.slf4j.Logger;

public class ServerPayloadHandler {
  private static final Logger LOGGER = LogUtils.getLogger();

  public static void handleKeyInput(KeyInputC2SPacket payload, IPayloadContext context) {
    context.enqueueWork(() -> {
      ServerPlayer player = (ServerPlayer) context.player();

      LOGGER.debug("Received KeyInputC2SPacket {keyMappingName:{}}", payload.keyMappingName());
    }).exceptionally(exception -> {
      context.disconnect(Component.translatable("stranded.networking.failed", exception.getMessage()));
      LOGGER.error(exception.getMessage(), exception);
      return null;
    });
  }
}
