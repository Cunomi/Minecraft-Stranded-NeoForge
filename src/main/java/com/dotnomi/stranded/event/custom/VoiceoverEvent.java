package com.dotnomi.stranded.event.custom;

import net.neoforged.bus.api.Event;

public class VoiceoverEvent extends Event {
    private final String voiceoverId;

    public VoiceoverEvent(String voiceoverId) {
        this.voiceoverId = voiceoverId;
    }

    public String getVoiceoverId() {
        return voiceoverId;
    }
}
