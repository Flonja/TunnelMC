package me.THEREALWWEFAN231.tunnelmc.connection.bedrock.network.caches.container.containers;

import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.network.caches.container.BedrockContainer;
import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.network.caches.container.BedrockContainers;

public class PlayerContainerCursorContainer extends BedrockContainer {
	
	public static final int SIZE = 1;

	public PlayerContainerCursorContainer() {
		super(PlayerContainerCursorContainer.SIZE, BedrockContainers.PLAYER_CONTAINER_CURSOR_COTNAINER_ID);
	}

}
