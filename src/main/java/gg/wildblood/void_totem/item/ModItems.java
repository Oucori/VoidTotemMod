package gg.wildblood.void_totem.item;

import gg.wildblood.void_totem.item.custom.VoidTotemItem;
import gg.wildblood.void_totem.multiplayer.VoidTotemNetworkingConstants;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class ModItems {
	public static final Item VOID_TOTEM = new Item(new QuiltItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));

	public static void register(ModContainer mod) {
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "void_totem"), VOID_TOTEM);
		ClientPlayNetworking.registerGlobalReceiver(VoidTotemNetworkingConstants.PLAY_VOID_TOTEM_ANIM, VoidTotemItem::handleClientAnimationPlay);
	}

}
