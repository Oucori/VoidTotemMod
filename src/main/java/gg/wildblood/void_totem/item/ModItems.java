package gg.wildblood.void_totem.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item VOID_TOTEM = new Item(new QuiltItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));

	public static void register(ModContainer mod) {
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "void_totem"), VOID_TOTEM);
	}

}
