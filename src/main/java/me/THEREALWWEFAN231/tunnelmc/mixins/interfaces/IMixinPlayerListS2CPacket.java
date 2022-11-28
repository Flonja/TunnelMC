package me.THEREALWWEFAN231.tunnelmc.mixins.interfaces;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;

@Mixin(PlayerListS2CPacket.class)
public interface IMixinPlayerListS2CPacket {

	/**
	 * Needed because the constructor only takes in ServerPlayerEntity
	 */
	@Accessor("entries")
	void setEntries(List<PlayerListS2CPacket.Entry> newValue);
}
