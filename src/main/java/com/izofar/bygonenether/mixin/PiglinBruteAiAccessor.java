package com.izofar.bygonenether.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.PiglinBruteAi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Optional;

@Mixin(PiglinBruteAi.class)
public interface PiglinBruteAiAccessor {
    @Invoker("setAngerTarget")
    static void bygonenether$setAngerTarget(PiglinBrute piglin, LivingEntity target) {
        throw new AssertionError();
    }

    @Invoker("getTargetIfWithinRange")
    static Optional<? extends LivingEntity> bygonenether$getTargetIfWithinRange(
            AbstractPiglin piglin,
            MemoryModuleType<? extends LivingEntity> memoryType
    ) {
        throw new AssertionError();
    }
}
