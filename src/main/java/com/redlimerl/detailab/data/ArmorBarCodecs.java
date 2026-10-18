package com.redlimerl.detailab.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.datafixers.util.Either;
import net.minecraft.util.ExtraCodecs;

import java.awt.*;
import java.util.List;

public final class ArmorBarCodecs {

    public static final Codec<Color> NUM_COLOR_CODEC = Codec.INT.xmap(
            Color::new,
            Color::getRGB
    );

    public static final Codec<Color> HEX_COLOR_CODEC = Codec.STRING.xmap(
            hexCode -> new Color(Integer.parseInt(hexCode, 16)),
            col -> Integer.toHexString(col.getRGB())
    );

    public static final Codec<Color> RGB_COLOR_CODEC = ExtraCodecs.NON_NEGATIVE_INT.listOf().comapFlatMap(
            ints -> ints.size() == 3
                    ? DataResult.success(new Color(ints.get(0), ints.get(1), ints.get(2)))
                    : DataResult.error(() -> "Expected exactly three RGB color values"),
            col -> List.of(col.getRed(), col.getGreen(), col.getBlue())
    );

    public static final Codec<Color> COLOR_CODEC = Codec.either(NUM_COLOR_CODEC, Codec.either(RGB_COLOR_CODEC, HEX_COLOR_CODEC))
            .xmap(value -> value.map(color -> color, nested -> nested.map(color -> color, color -> color)),
                    color -> Either.left(color));


}
