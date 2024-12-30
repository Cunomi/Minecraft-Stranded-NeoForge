package com.dotnomi.stranded.event.handler;

import com.dotnomi.stranded.data.LevelDataStorage;
import com.dotnomi.stranded.data.LevelDataStorageManager;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.UUID;

public class PlayerLoggedInHandler {
  @SubscribeEvent
  public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
    if (!(event.getEntity() instanceof ServerPlayer player)) {
      return;
    }

    ServerPlayer serverPlayer = (ServerPlayer) player;
    ServerLevel level = serverPlayer.serverLevel();

    LevelDataStorage data = LevelDataStorageManager.getPersistentData(level);

    UUID playerUUID = player.getUUID();
    if (!data.isPlayerKnown(playerUUID)) {
      data.addPlayer(playerUUID);
      player.sendSystemMessage(Component.literal("Hi " + player.getName().getString() + "!"));
    }
  }
}
