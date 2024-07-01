package gg.wildblood.void_totem;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class VoidTotemClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		VoidTotem.LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
	}
}
