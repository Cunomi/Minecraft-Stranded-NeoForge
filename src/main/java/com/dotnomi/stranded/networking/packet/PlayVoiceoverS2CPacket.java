package com.dotnomi.stranded.networking.packet;

import com.dotnomi.stranded.networking.ModPayloadUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record PlayVoiceoverS2CPacket(String voiceoverId) implements CustomPacketPayload {
  public static Type<PlayVoiceoverS2CPacket> TYPE = ModPayloadUtils.createType("s2c-play-voiceover");

  public static StreamCodec<ByteBuf, PlayVoiceoverS2CPacket> CODEC = StreamCodec.composite(
    ByteBufCodecs.STRING_UTF8,
    PlayVoiceoverS2CPacket::voiceoverId,
    PlayVoiceoverS2CPacket::new
  );

  @Override
  public @NotNull Type<? extends CustomPacketPayload> type() {
    return TYPE;
  }
}
