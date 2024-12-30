package com.dotnomi.stranded.data;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class LevelDataStorageManager {
  public static LevelDataStorage getPersistentData(ServerLevel level) {
    return level.getDataStorage().computeIfAbsent(
      new SavedData.Factory<>(
        LevelDataStorage::create,
        LevelDataStorage::load
      ),
      LevelDataStorage.DATA_NAME
    );
  }
}
