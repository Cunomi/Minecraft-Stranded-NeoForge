package com.dotnomi.stranded.mixin;

import com.dotnomi.stranded.client.sound.ModSoundSources;
import com.mojang.logging.LogUtils;
import net.minecraft.sounds.SoundSource;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Mixin(SoundSource.class)
public class SoundSourceMixin {
  @Unique
  private static final Logger minecraft_Stranded_NeoForge$LOGGER = LogUtils.getLogger();

  @Final
  @Shadow
  @Mutable
  private static SoundSource[] $VALUES;

  @Invoker("<init>")
  private static SoundSource createSoundSource(String internalName, int internalId, String name) {
    throw new AssertionError();
  }

  @Inject(method = "<clinit>", at = @At("RETURN"))
  private static void addCustomSoundSource(CallbackInfo callbackInfo) {
    ArrayList<SoundSource> soundSources = new ArrayList<>(Arrays.asList($VALUES));
    try {
      ModSoundSources.getInstance().setVoiceoverSoundCategory(
        minecraft_Stranded_NeoForge$addSoundSource(soundSources, "stranded_voiceover")
      );
      minecraft_Stranded_NeoForge$LOGGER.debug("Added custom SoundSource: STRANDED_VOICEOVER");
    } catch (Exception exception) {
      minecraft_Stranded_NeoForge$LOGGER.error("Failed to add custom sound source", exception);
    }
    $VALUES = soundSources.toArray(new SoundSource[0]);
  }

  @Unique
  @SuppressWarnings("SameParameterValue")
  private static SoundSource minecraft_Stranded_NeoForge$addSoundSource(ArrayList<SoundSource> sources, String name) {
    SoundSource soundSource = createSoundSource(
      name.toUpperCase(Locale.ROOT),
      sources.getLast().ordinal() + 1,
      name.toLowerCase(Locale.ROOT)
    );
    sources.add(soundSource);
    return soundSource;
  }
}
