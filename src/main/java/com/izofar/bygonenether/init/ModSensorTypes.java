package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import com.izofar.bygonenether.entity.ai.sensing.PiglinBruteSpecificSensor;
import com.izofar.bygonenether.entity.ai.sensing.PiglinPrisonerSpecificSensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public abstract class ModSensorTypes {

	public static final DeferredRegister<SensorType<?>> MODDED_SENSOR_TYPES = DeferredRegister.create(Registries.SENSOR_TYPE, "bygonenether");
	
	public static final DeferredHolder<SensorType<?>, SensorType<PiglinBruteSpecificSensor>> PIGLIN_BRUTE_SPECIFIC_SENSOR = MODDED_SENSOR_TYPES.register("piglin_brute_specific_sensor", () -> new SensorType<>(PiglinBruteSpecificSensor::new));
	public static final DeferredHolder<SensorType<?>, SensorType<PiglinPrisonerSpecificSensor>> PIGLIN_PRISONER_SPECIFIC_SENSOR = MODDED_SENSOR_TYPES.register("piglin_prisoner_specific_sensor", () -> new SensorType<>(PiglinPrisonerSpecificSensor::new));

	public static void register(IEventBus eventBus) { MODDED_SENSOR_TYPES.register(eventBus); }
	
}
