package com.dotnomi.stranded;

import com.dotnomi.stranded.client.input.KeyMappings;
import com.dotnomi.stranded.client.input.handler.DebugKeyInputHandler;
import com.dotnomi.stranded.client.input.handler.VoiceoverSkipKeyInputHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = StrandedMod.MOD_ID, dist = Dist.CLIENT)
public class StrandedModClient {
  public StrandedModClient(final IEventBus modEventBus) {
    // Perform logic in that should only be executed on the client
    registerKeyInput(modEventBus);
  }

  private void registerKeyInput(final IEventBus modEventBus) {
    // Register all key binds
    modEventBus.addListener(KeyMappings::register);

    // Register all event handlers for key press events
    NeoForge.EVENT_BUS.register(new DebugKeyInputHandler());
    NeoForge.EVENT_BUS.register(new VoiceoverSkipKeyInputHandler());
  }
}
