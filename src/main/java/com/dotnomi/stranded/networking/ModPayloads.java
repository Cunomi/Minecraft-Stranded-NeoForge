package com.dotnomi.stranded.networking;

import com.dotnomi.stranded.networking.handler.ClientPayloadHandler;
import com.dotnomi.stranded.networking.handler.ServerPayloadHandler;
import com.dotnomi.stranded.networking.packet.KeyInputC2SPacket;
import com.dotnomi.stranded.networking.packet.PlayVoiceoverS2CPacket;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

public class ModPayloads {
  private static final Logger LOGGER = LogUtils.getLogger();

  @SubscribeEvent
  public static void register(final RegisterPayloadHandlersEvent event) {
    final PayloadRegistrar registrar = event.registrar("1").executesOn(HandlerThread.NETWORK);

    LOGGER.info("Registering ModPayloads");

    registerClientPackets(registrar);
    registerServerPackets(registrar);
    registerBidirectionalPackets(registrar);
  }

  private static void registerClientPackets(PayloadRegistrar registrar) {
    LOGGER.info("Registering Client Packets");

    registrar.playToClient(
      PlayVoiceoverS2CPacket.TYPE,
      PlayVoiceoverS2CPacket.CODEC,
      ClientPayloadHandler::handlePlayVoiceover
    );
  }

  private static void registerServerPackets(PayloadRegistrar registrar) {
    LOGGER.info("Registering Server Packets");

    registrar.playToServer(
      KeyInputC2SPacket.TYPE,
      KeyInputC2SPacket.CODEC,
      ServerPayloadHandler::handleKeyInput
    );
  }

  private static void registerBidirectionalPackets(PayloadRegistrar registrar) {
    LOGGER.info("Registering Bidirectional Packets");
  }
}
