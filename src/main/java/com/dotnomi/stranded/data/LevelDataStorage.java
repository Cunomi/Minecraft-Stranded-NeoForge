package com.dotnomi.stranded.data;

import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LevelDataStorage extends SavedData {
  public static final String DATA_NAME = "stranded_data";
  private static final Logger LOGGER = LogUtils.getLogger();
  private ServerLevel level;

  private final Set<UUID> playerList = new HashSet<>();

  public static LevelDataStorage create() {
    return new LevelDataStorage();
  }

  @Override
  public @NotNull CompoundTag save(CompoundTag tag, HolderLookup.@NotNull Provider registries) {
    LOGGER.debug("Saving Level Data Storage");

    ListTag playerListTag = new ListTag();
    for (UUID uuid : playerList) {
      CompoundTag uuidTag = new CompoundTag();
      uuidTag.putUUID("uuid", uuid);
      playerListTag.add(uuidTag);
    }
    tag.put("playerList", playerListTag);

    return tag;
  }

  public static LevelDataStorage load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
    LOGGER.debug("Loading Level Data Storage");
    LevelDataStorage data = create();

    ListTag playerListTag = tag.getList("playerList", CompoundTag.TAG_COMPOUND);
    for (int i = 0; i < playerListTag.size(); i++) {
      CompoundTag uuidTag = playerListTag.getCompound(i);
      data.playerList.add(uuidTag.getUUID("uuid"));
    }

    return data;
  }

  public boolean isPlayerKnown(UUID playerUUID) {
    return playerList.contains(playerUUID);
  }

  public void addPlayer(UUID playerUUID) {
    if (playerList.add(playerUUID)) {
      this.setDirty();
    }
  }
}
