package me.THEREALWWEFAN231.tunnelmc.translator.container.screenhandler;

import java.util.HashMap;

import me.THEREALWWEFAN231.tunnelmc.bedrockconnection.caches.container.BedrockContainer;
import me.THEREALWWEFAN231.tunnelmc.translator.container.screenhandler.translators.GenericContainerScreenHandlerTranslator;
import me.THEREALWWEFAN231.tunnelmc.translator.container.screenhandler.translators.PlayerScreenHandlerTranslator;
import net.minecraft.screen.ScreenHandler;

public class ScreenHandlerTranslatorManager {
	
	private static final HashMap<Class<? extends ScreenHandler>, ScreenHandlerTranslator<?>> REGISTRY = new HashMap<Class<? extends ScreenHandler>, ScreenHandlerTranslator<?>>();
	
	public static void load() {
		ScreenHandlerTranslatorManager.add(new PlayerScreenHandlerTranslator());
		ScreenHandlerTranslatorManager.add(new GenericContainerScreenHandlerTranslator());
	}
	
	private static void add(ScreenHandlerTranslator<?> translator) {
		ScreenHandlerTranslatorManager.REGISTRY.put(translator.getScreenHandlerClass(), translator);
	}
	
	private static ScreenHandlerTranslator<ScreenHandler> getTranslator(ScreenHandler screenHandler){
		Class<? extends ScreenHandler> screenHandlerClass = screenHandler.getClass();
		ScreenHandlerTranslator<ScreenHandler> translator = (ScreenHandlerTranslator<ScreenHandler>) ScreenHandlerTranslatorManager.REGISTRY.get(screenHandlerClass);
		
		if(translator == null) {
			System.out.println("No screen handler found for " + screenHandlerClass);
			return null;
		}
		
		return translator;
	}

	public static BedrockContainer getBedrockContainerFromJava(ScreenHandler javaContainer, int javaSlotId) {
		ScreenHandlerTranslator<ScreenHandler> translator = ScreenHandlerTranslatorManager.getTranslator(javaContainer);
		if(translator == null) {
			return null;
		}

		return translator.getBedrockContainerFromJava(javaContainer, javaSlotId);
	}

	public static Integer getJavaSlotFromBedrockContainer(ScreenHandler javaContainer, BedrockContainer bedrockContainer, int bedrockSlotId) {
		ScreenHandlerTranslator<ScreenHandler> translator = ScreenHandlerTranslatorManager.getTranslator(javaContainer);
		if(translator == null) {
			return null;
		}

		return translator.getJavaSlotFromBedrockContainer(javaContainer, bedrockContainer, bedrockSlotId);
	}

	public static Integer getBedrockSlotFromJavaContainer(ScreenHandler javaContainer, int javaSlotId, BedrockContainer bedrockContainer) {
		ScreenHandlerTranslator<ScreenHandler> translator = ScreenHandlerTranslatorManager.getTranslator(javaContainer);
		if(translator == null) {
			return null;
		}

		return translator.getBedrockSlotFromJavaContainer(javaContainer, javaSlotId, bedrockContainer);
	}
}
