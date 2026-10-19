package com.izofar.bygonenether.loot;
import net.minecraft.core.registries.BuiltInRegistries;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.fml.ModList;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ReplaceItemLootModifier extends LootModifier {

    public static final Supplier<MapCodec<ReplaceItemLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(
            inst -> codecStart(inst).and(
                    inst.group(
                            ResourceLocation.CODEC.fieldOf("target").forGetter(m -> m.target),
                            ResourceLocation.CODEC.fieldOf("replacement").forGetter(m -> m.replacement),
                            Codec.STRING.fieldOf("mod_dependency").forGetter(m -> m.modDependency)
                    )
            ).apply(inst, ReplaceItemLootModifier::new)));

    private final ResourceLocation target;
    private final ResourceLocation replacement;
    private final String modDependency;

    protected ReplaceItemLootModifier(LootItemCondition[] conditions, ResourceLocation target, ResourceLocation replacement, String modDependency) {
        super(conditions);
        this.target = target;
        this.replacement = replacement;
        this.modDependency = modDependency;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!ModList.get().isLoaded(this.modDependency)) {
            return generatedLoot;
        }

        var targetItem = BuiltInRegistries.ITEM.getOptional(this.target).orElse(null);
        var replacementItem = BuiltInRegistries.ITEM.getOptional(this.replacement).orElse(null);
        if (targetItem == null || replacementItem == null) {
            return generatedLoot;
        }

        generatedLoot.replaceAll(itemStack -> itemStack.getItem() == targetItem
                ? new ItemStack(replacementItem, itemStack.getCount())
                : itemStack);
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
