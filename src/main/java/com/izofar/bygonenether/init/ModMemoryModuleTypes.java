package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import java.util.Optional;

import com.izofar.bygonenether.BygoneNetherMod;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public abstract class ModMemoryModuleTypes {

public static final DeferredRegister<MemoryModuleType<?>> MODDED_MEMORY_MODULE_TYPES = DeferredRegister.create(Registries.MEMORY_MODULE_TYPE, BygoneNetherMod.MODID);
	
	public static final DeferredHolder<MemoryModuleType<?>, MemoryModuleType<Player>> NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GILD = MODDED_MEMORY_MODULE_TYPES.register("nearest_targetable_player_not_wearing_gild", () -> new MemoryModuleType<>(Optional.empty())); 
	
	public static void register(IEventBus eventBus) { MODDED_MEMORY_MODULE_TYPES.register(eventBus); }
	
}
