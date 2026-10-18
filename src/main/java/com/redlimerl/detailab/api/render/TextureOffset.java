package com.redlimerl.detailab.api.render;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.util.ExtraCodecs;
import java.util.List;

public class TextureOffset {
    public static final Codec<TextureOffset> CODEC = ExtraCodecs.NON_NEGATIVE_INT.listOf().comapFlatMap(
            ints -> ints.size() == 2
                    ? DataResult.success(new TextureOffset(ints.get(0), ints.get(1)))
                    : DataResult.error(() -> "Expected exactly two texture offset values"),
            texoff -> List.of(texoff.x, texoff.y)
    );

    public final int x;
    public final int y;

    public TextureOffset(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
