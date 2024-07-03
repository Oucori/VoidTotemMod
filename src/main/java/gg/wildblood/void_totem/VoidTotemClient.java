package gg.wildblood.void_totem;

import gg.wildblood.void_totem.item.custom.VoidTotemItem;
import gg.wildblood.void_totem.multiplayer.VoidTotemNetworkingConstants;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class VoidTotemClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		VoidTotem.LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());

		ClientPlayNetworking.registerGlobalReceiver(VoidTotemNetworkingConstants.PLAY_VOID_TOTEM_ANIM, VoidTotemItem::handleClientAnimationPlay);
	}
}
