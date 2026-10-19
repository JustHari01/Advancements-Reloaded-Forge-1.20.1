package com.izofar.bygonenether;

import com.izofar.bygonenether.client.renderer.ModShieldRenderer;
import com.izofar.bygonenether.init.*;
import com.izofar.bygonenether.event.ModBlockEvents;
import com.izofar.bygonenether.event.ModEntityEvents;
import com.izofar.bygonenether.util.ModStructureUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BygoneNetherMod.MODID)
public class BygoneNetherMod
{
    public static final String MODID = "bygonenether";
    public static final Logger LOGGER = LogManager.getLogger();

    public BygoneNetherMod(IEventBus eventBus, ModContainer modContainer, Dist dist) {

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModCreativeModeTabs.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModStructures.register(eventBus);
        ModSensorTypes.register(eventBus);
        ModMemoryModuleTypes.register(eventBus);
        ModFeatures.register(eventBus);
        ModSounds.register(eventBus);
        ModLootModifiers.register(eventBus);

        eventBus.register(RegistryEvents.class);
        NeoForge.EVENT_BUS.register(ModBlockEvents.class);
        NeoForge.EVENT_BUS.register(ModEntityEvents.class);

        eventBus.addListener(this::commonSetup);
        if (dist == Dist.CLIENT) {
            eventBus.addListener(this::clientSetup);
            eventBus.register(ClientRegistryEvents.class);
            eventBus.register(ModShieldRenderer.class);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModStructureUtils.addBasaltRestrictions();
            ModEntityTypes.modifyPiglinMemoryAndSensors();
            ModTags.initTags();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ModShieldRenderer.addShieldPropertyOverrides();
        });
    }

}
