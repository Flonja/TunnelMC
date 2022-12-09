package me.THEREALWWEFAN231.tunnelmc.connection.java.network.translators.movement;

import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import me.THEREALWWEFAN231.tunnelmc.connection.PacketIdentifier;
import me.THEREALWWEFAN231.tunnelmc.connection.PacketTranslator;
import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.Client;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.LookAndOnGround;

@PacketIdentifier(LookAndOnGround.class)
public class LookOnlyTranslator extends PacketTranslator<PlayerMoveC2SPacket.LookAndOnGround> {

	@Override
	public void translate(LookAndOnGround packet, Client client) {
		PlayerMoveTranslator.translateMovementPacket(packet, MovePlayerPacket.Mode.HEAD_ROTATION, client);
	}
}
