package com.dotnomi.stranded;

import com.dotnomi.stranded.logging.LoggerConfig;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = StrandedMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLE_DEBUG_MODE = BUILDER
      .comment("The debug mode shows debug log messages and enables other debug features")
      .define("enableDebugMode", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean isDebugModeEnabled;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        isDebugModeEnabled = ENABLE_DEBUG_MODE.get();
        LoggerConfig.setDebugMode(isDebugModeEnabled);
    }
}
