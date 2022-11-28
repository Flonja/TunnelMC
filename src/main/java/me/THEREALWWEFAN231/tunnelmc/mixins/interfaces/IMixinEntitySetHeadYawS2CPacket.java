package me.THEREALWWEFAN231.tunnelmc.mixins.interfaces;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket;

@Mixin(EntitySetHeadYawS2CPacket.class)
public interface IMixinEntitySetHeadYawS2CPacket {
	@Accessor("entity")
	void setEntityId(int newValue);

	@Accessor("headYaw")
	void setYaw(byte newValue);
}
