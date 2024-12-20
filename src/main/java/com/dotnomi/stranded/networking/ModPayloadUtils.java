package com.dotnomi.stranded.networking;

import com.dotnomi.stranded.StrandedMod;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public final class ModPayloadUtils {
  public static <T extends CustomPacketPayload> CustomPacketPayload.Type<T> createType(final String name) {
    return new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(StrandedMod.MOD_ID, name));
  }
}
