package com.dotnomi.stranded;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = StrandedMod.MOD_ID, dist = Dist.DEDICATED_SERVER)
public class StrandedModServer {
  public StrandedModServer(IEventBus modEventBus) {
    // Perform logic in that should only be executed on the physical server
  }
}
