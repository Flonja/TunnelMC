package me.THEREALWWEFAN231.tunnelmc.mixins;

import me.THEREALWWEFAN231.tunnelmc.connection.bedrock.BedrockConnectionAccessor;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public class MixinAbstractClientPlayerEntity {

	//TODO: probably want to use PlayerSkinProvider.loadSkin instead, it should work with PlayerListHud as well
	//disabled these because they crash often, kind of
	@Inject(method = "getSkinTexture", at = @At("HEAD"), cancellable = true)
	public void getSkinTexture(CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
		if (!BedrockConnectionAccessor.isConnectionOpen()) {
			return;
		}
		//callbackInfoReturnable.setReturnValue(PlayerListPacketTranslator.skins.get(AbstractClientPlayerEntity.class.cast(this).getGameProfile().getName()).texture);
	}

	@Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
	public void getModel(CallbackInfoReturnable<String> callbackInfoReturnable) {
		if (!BedrockConnectionAccessor.isConnectionOpen()) {
			return;
		}
		//boolean isSlim = PlayerListPacketTranslator.skins.get(AbstractClientPlayerEntity.class.cast(this).getGameProfile().getName()).slim;
		//callbackInfoReturnable.setReturnValue(isSlim ? "slim" : "default");
	}
}
