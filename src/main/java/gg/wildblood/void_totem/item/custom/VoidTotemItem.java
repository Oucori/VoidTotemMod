package gg.wildblood.void_totem.item.custom;

import gg.wildblood.void_totem.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import org.quiltmc.qsl.networking.api.PacketSender;

public class VoidTotemItem extends Item {
	public VoidTotemItem(Settings settings) {
		super(settings);
	}

	public static void handleClientAnimationPlay(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
		client.execute(() -> {
			MinecraftClient.getInstance().gameRenderer.showFloatingItem(ModItems.VOID_TOTEM.getDefaultStack());
			if(client.player == null || client.world == null) return;
			client.world.playSound(client.player.getX(), client.player.getY(), client.player.getZ(), SoundEvents.ENTITY_CHICKEN_HURT, client.player.getSoundCategory(), 1.2F, 1.0F, false);
		});
	}



}
