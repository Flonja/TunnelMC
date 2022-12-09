package me.THEREALWWEFAN231.tunnelmc.javaconnection;

import java.util.HashMap;
import java.util.Map;

import me.THEREALWWEFAN231.tunnelmc.javaconnection.packet.*;
import me.THEREALWWEFAN231.tunnelmc.javaconnection.packet.movement.BothTranslator;
import me.THEREALWWEFAN231.tunnelmc.javaconnection.packet.movement.LookOnlyTranslator;
import me.THEREALWWEFAN231.tunnelmc.javaconnection.packet.movement.PlayerMoveTranslator;
import me.THEREALWWEFAN231.tunnelmc.javaconnection.packet.movement.PositionOnlyTranslator;
import me.THEREALWWEFAN231.tunnelmc.translator.PacketTranslator;
import net.minecraft.network.Packet;

public class JavaPacketTranslatorManager {

	private final Map<Class<?>, PacketTranslator<?>> packetTranslatorsByPacketClass = new HashMap<>();

	public JavaPacketTranslatorManager() {
		this.addTranslator(new HandSwingC2SPacketTranslator());
		this.addTranslator(new PlayerMoveTranslator());
		this.addTranslator(new LookOnlyTranslator());
		this.addTranslator(new PositionOnlyTranslator());
		this.addTranslator(new BothTranslator());
		this.addTranslator(new ChatMessageC2SPacketTranslator());
		this.addTranslator(new UpdateSelectedSlotC2SPacketTranslator());
		this.addTranslator(new PlayerActionTranslator());
		this.addTranslator(new PlayerInteractBlockC2SPacketTranslator());
		this.addTranslator(new PlayerInteractItemC2SPacketTranslator());
		this.addTranslator(new PlayerInteractEntityC2SPacketTranslator());
		this.addTranslator(new ClientCommandC2SPacketTranslator());
		this.addTranslator(new CloseHandledScreenC2SPacketTranslator());
		this.addTranslator(new ClickSlotC2SPacketTranslator());
		this.addTranslator(new UpdatePlayerAbilitiesTranslator());
		this.addTranslator(new ClientStatusC2SPacketTranslator());
		this.addTranslator(new CommandExecutionC2SPacketTranslator());
	}

	private void addTranslator(PacketTranslator<?> translator) {
		this.packetTranslatorsByPacketClass.put(translator.getPacketClass(), translator);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void translatePacket(Packet<?> packet) {
		PacketTranslator packetTranslator = this.packetTranslatorsByPacketClass.get(packet.getClass());
		if (packetTranslator != null) {
			packetTranslator.translate(packet);
		} else {
			//System.out.println("Could not find a packet translator for the packet: " + packet.getClass());
		}
	}
}
