package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import com.izofar.bygonenether.BygoneNetherMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, BygoneNetherMod.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> WITHER_WALTZ = register("wither_waltz");

    public static final DeferredHolder<SoundEvent, SoundEvent> WEX_CHARGE = register("entity.wex.charge");
    public static final DeferredHolder<SoundEvent, SoundEvent> WEX_DEATH = register("entity.wex.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> WEX_HURT = register("entity.wex.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> WEX_AMBIENT = register("entity.wex.ambient");

    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_DEATH = register("entity.warped_enderman.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_HURT = register("entity.warped_enderman.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_AMBIENT = register("entity.warped_enderman.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_TELEPORT = register("entity.warped_enderman.teleport");
    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_SCREAM = register("entity.warped_enderman.scream");
    public static final DeferredHolder<SoundEvent, SoundEvent> WARPED_ENDERMAN_STARE = register("entity.warped_enderman.stare");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) { SOUND_EVENTS.register(eventBus); }
}