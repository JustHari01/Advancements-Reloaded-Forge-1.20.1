package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import com.izofar.bygonenether.BygoneNetherMod;
import com.izofar.bygonenether.loot.ReplaceItemLootModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public abstract class ModLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BygoneNetherMod.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>> REPLACE_ITEM = LOOT_MODIFIER_SERIALIZERS.register("replace_item", ReplaceItemLootModifier.CODEC);

    public static void register(IEventBus bus) { LOOT_MODIFIER_SERIALIZERS.register(bus); }

}
