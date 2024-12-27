package com.dotnomi.stranded.networking.packet;

import com.dotnomi.stranded.networking.ModPayloadUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record KeyInputC2SPacket(String keyMappingName) implements CustomPacketPayload {
  public static Type<KeyInputC2SPacket> TYPE = ModPayloadUtils.createType("c2s-key-input");

  public static StreamCodec<ByteBuf, KeyInputC2SPacket> CODEC = StreamCodec.composite(
    ByteBufCodecs.STRING_UTF8,
    KeyInputC2SPacket::keyMappingName,
    KeyInputC2SPacket::new
  );

  @Override
  public @NotNull Type<? extends CustomPacketPayload> type() {
    return TYPE;
  }
}
