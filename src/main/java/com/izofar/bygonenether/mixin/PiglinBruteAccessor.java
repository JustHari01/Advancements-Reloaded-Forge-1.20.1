package com.izofar.bygonenether.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PiglinBrute.class)
public interface PiglinBruteAccessor {
    @Mutable
    @Accessor("SENSOR_TYPES")
    static void bygonenether$setSensorTypes(ImmutableList<SensorType<? extends Sensor<? super PiglinBrute>>> sensors) {
        throw new AssertionError();
    }

    @Mutable
    @Accessor("MEMORY_TYPES")
    static void bygonenether$setMemoryTypes(ImmutableList<MemoryModuleType<?>> memories) {
        throw new AssertionError();
    }
}
