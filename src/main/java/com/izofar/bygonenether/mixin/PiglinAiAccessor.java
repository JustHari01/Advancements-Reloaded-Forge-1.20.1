package com.izofar.bygonenether.mixin;

import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PiglinAi.class)
public interface PiglinAiAccessor {
    @Invoker("isIdle")
    static boolean bygonenether$isIdle(AbstractPiglin piglin) {
        throw new AssertionError();
    }
}
