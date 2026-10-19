package com.izofar.bygonenether.event;

import com.izofar.bygonenether.entity.PiglinPrisoner;
import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;
import net.neoforged.bus.api.SubscribeEvent;

public abstract class ModEntityEvents {

	@SubscribeEvent
	public static void preventPiglinPrisonersFromDespawning(MobDespawnEvent event) {
		if (event.getEntity() instanceof PiglinPrisoner) {
			event.setResult(MobDespawnEvent.Result.DENY);
		}
	}

}
