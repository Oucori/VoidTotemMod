package gg.wildblood.void_totem.mixin;

import gg.wildblood.void_totem.VoidTotem;
import gg.wildblood.void_totem.item.ModItems;
import gg.wildblood.void_totem.multiplayer.VoidTotemNetworkingConstants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@SuppressWarnings("UnreachableCode")
	@Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
	public void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> callbackInfo) {
		@SuppressWarnings("DataFlowIssue") LivingEntity self = (LivingEntity)(Object)this;

		if(!source.getType().getMessageId().equals("outOfWorld")) return;

		ItemStack itemStack = null;

		for (Hand hand : Hand.values()) {
			ItemStack itemStack2 = self.getStackInHand(hand);
			if (itemStack2.isOf(ModItems.VOID_TOTEM)) {
				itemStack = itemStack2.copy();
				itemStack2.decrement(1);
				break;
			}
		}

		if (itemStack != null) {
			self.setHealth(2.0F);
			self.teleport(self.getX(), 325.00D, self.getZ());
			self.clearStatusEffects();
			self.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 1));
			self.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 500, 2));

			if(self.isPlayer()) {
				ServerPlayNetworking.send((ServerPlayerEntity)self, VoidTotemNetworkingConstants.PLAY_VOID_TOTEM_ANIM, PacketByteBufs.empty());
			}
		}

		callbackInfo.setReturnValue(itemStack != null);
	}
}
