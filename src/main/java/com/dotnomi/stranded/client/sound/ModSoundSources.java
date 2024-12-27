package com.dotnomi.stranded.client.sound;

import net.minecraft.sounds.SoundSource;

public class ModSoundSources {
  private static ModSoundSources instance;

  private static SoundSource voiceoverSoundSource;

  private ModSoundSources() {}

  public static ModSoundSources getInstance() {
    if (instance == null) {
      instance = new ModSoundSources();
    }
    return instance;
  }

  public void setVoiceoverSoundCategory(SoundSource soundSource) {
    ModSoundSources.voiceoverSoundSource = soundSource;
  }

  public SoundSource getVoiceoverSoundSource() {
    return voiceoverSoundSource;
  }
}
