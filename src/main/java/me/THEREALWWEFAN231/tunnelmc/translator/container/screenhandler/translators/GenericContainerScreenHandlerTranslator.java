package me.THEREALWWEFAN231.tunnelmc.translator.container.screenhandler.translators;

import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.BedrockConnectionAccessor;
import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.network.caches.container.BedrockContainer;
import me.THEREALWWEFAN231.tunnelmc.translator.container.screenhandler.ScreenHandlerTranslator;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;

public class GenericContainerScreenHandlerTranslator extends ScreenHandlerTranslator<GenericContainerScreenHandler> {

	@Override
	public BedrockContainer getBedrockContainerFromJava(GenericContainerScreenHandler javaContainer, int javaSlotId) {
		int slotsInContainer = javaContainer.getRows() * 9;

		if (javaSlotId < slotsInContainer) {
			return BedrockConnectionAccessor.getCurrentConnection().getWrappedContainers().getCurrentlyOpenContainer();
		}

		return BedrockConnectionAccessor.getCurrentConnection().getWrappedContainers().getPlayerInventory();
	}

	@Override
	public int getBedrockSlotFromJavaContainer(GenericContainerScreenHandler javaContainer, int javaSlotId, BedrockContainer bedrockContainer) {
		int slotsInContainer = javaContainer.getRows() * 9;
		if (javaSlotId < slotsInContainer) {//the ids are the same in java and bedrock for chest containers
			return javaSlotId;
		}

		javaSlotId -= slotsInContainer;

		if (javaSlotId > 26) {//hotbar
			return javaSlotId - 27;
		}

		return javaSlotId + 9;
	}

	@Override
	public Class<? extends ScreenHandler> getScreenHandlerClass() {
		return GenericContainerScreenHandler.class;
	}

}
