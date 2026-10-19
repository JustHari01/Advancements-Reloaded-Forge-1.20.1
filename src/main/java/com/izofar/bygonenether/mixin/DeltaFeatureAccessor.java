package com.izofar.bygonenether.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DeltaFeature.class)
public interface DeltaFeatureAccessor {
    @Mutable
    @Accessor("CANNOT_REPLACE")
    static void bygonenether$setCannotReplace(ImmutableList<Block> blocks) {
        throw new AssertionError();
    }
}
