package com.dotnomi.stranded;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(value = StrandedMod.MOD_ID, dist = Dist.DEDICATED_SERVER)
public class StrandedModServer {
  private static final Logger LOGGER = LogUtils.getLogger();

  public StrandedModServer(IEventBus modEventBus) {
    // Perform logic in that should only be executed on the physical server
  }
}
