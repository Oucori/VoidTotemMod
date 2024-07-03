package gg.wildblood.void_totem.item;

import gg.wildblood.void_totem.item.custom.VoidTotemItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final VoidTotemItem VOID_TOTEM = new VoidTotemItem(new QuiltItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));

	public static void register(ModContainer mod) {
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "void_totem"), VOID_TOTEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((group) -> group.addItem(VOID_TOTEM));
	}

}
