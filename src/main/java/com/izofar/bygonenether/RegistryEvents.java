package com.izofar.bygonenether;

import com.izofar.bygonenether.entity.*;
import com.izofar.bygonenether.init.ModEntityTypes;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;

public abstract class RegistryEvents {

	@SubscribeEvent
	public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.PIGLIN_PRISONER.get(), PiglinPrisoner.createAttributes().build());
		event.put(ModEntityTypes.PIGLIN_HUNTER.get(), PiglinBrute.createAttributes().build());
		event.put(ModEntityTypes.WEX.get(), Wex.createAttributes().build());
		event.put(ModEntityTypes.WARPED_ENDERMAN.get(), WarpedEnderMan.createAttributes().build());
		event.put(ModEntityTypes.WRAITHER.get(), Wraither.createAttributes().build());
		event.put(ModEntityTypes.WITHER_SKELETON_KNIGHT.get(), WitherSkeletonKnight.createAttributes().build());
		event.put(ModEntityTypes.CORPOR.get(), Corpor.createAttributes().build());
		event.put(ModEntityTypes.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorse.createAttributes().build());
	}

}
