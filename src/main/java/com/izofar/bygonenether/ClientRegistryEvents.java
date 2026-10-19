package com.izofar.bygonenether;

import com.izofar.bygonenether.client.renderer.*;
import com.izofar.bygonenether.init.ModEntityTypes;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public final class ClientRegistryEvents {
    private ClientRegistryEvents() {}

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.PIGLIN_PRISONER.get(), PiglinPrisonerRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PIGLIN_HUNTER.get(), PiglinHunterRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WEX.get(), WexRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WARPED_ENDERMAN.get(), WarpedEnderManRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WRAITHER.get(), WraitherRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WITHER_SKELETON_KNIGHT.get(), WitherSkeletonKnightRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.CORPOR.get(), CorporRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.WARPED_ENDER_PEARL.get(), ThrownItemRenderer::new);
        event.registerBlockEntityRenderer(ModEntityTypes.NETHERITE_BELL.get(), NetheriteBellRenderer::new);
    }
}
