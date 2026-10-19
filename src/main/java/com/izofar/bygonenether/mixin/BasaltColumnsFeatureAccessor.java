package com.izofar.bygonenether.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BasaltColumnsFeature.class)
public interface BasaltColumnsFeatureAccessor {
    @Mutable
    @Accessor("CANNOT_PLACE_ON")
    static void bygonenether$setCannotPlaceOn(ImmutableList<Block> blocks) {
        throw new AssertionError();
    }
}
