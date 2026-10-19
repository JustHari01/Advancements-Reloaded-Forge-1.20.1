package com.izofar.bygonenether.client.renderer;

import com.izofar.bygonenether.BygoneNetherMod;
import com.izofar.bygonenether.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.bus.api.SubscribeEvent;


public class ModShieldRenderer extends BlockEntityWithoutLevelRenderer {

    private static ModShieldRenderer instance;
    private final EntityModelSet entityModelSet;
    private ShieldModel shieldModel;

    private static final ClampedItemPropertyFunction isBlocking = (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
    private static final Material GILDED_NETHERITE_SHIELD_BASE_LOCATION = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "entity/shield/gilded_netherite_shield_base"));
    private static final Material GILDED_NETHERITE_SHIELD_BASE_NOPATTERN_LOCATION = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "entity/shield/gilded_netherite_shield_base_nopattern"));

    public ModShieldRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet) {
        super(dispatcher, modelSet);
        this.entityModelSet = modelSet;
    }

    @SubscribeEvent
    public static void onRegisterReloadListener(RegisterClientReloadListenersEvent event) {
        instance = new ModShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels());
        event.registerReloadListener(instance);
    }

    public static void addShieldPropertyOverrides() {
        ItemProperties.register(ModItems.GILDED_NETHERITE_SHIELD.get(), ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "blocking"), isBlocking);
    }

    public static ModShieldRenderer getInstance() {
        return instance;
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        this.shieldModel = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.scale(1, -1, -1);
        boolean flag = stack.has(DataComponents.BANNER_PATTERNS);
        Material rendermaterial = flag ? ModelBakery.SHIELD_BASE
                : ModelBakery.NO_PATTERN_SHIELD;

        Item shield = stack.getItem();
        if (shield == ModItems.GILDED_NETHERITE_SHIELD.get()) {
            rendermaterial = flag ? GILDED_NETHERITE_SHIELD_BASE_LOCATION : GILDED_NETHERITE_SHIELD_BASE_NOPATTERN_LOCATION;
        }

        VertexConsumer vertexConsumer = rendermaterial.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.shieldModel.renderType(rendermaterial.atlasLocation()), true, stack.hasFoil()));
        this.shieldModel.handle().render(poseStack, vertexConsumer, packedLight, packedOverlay, -1);
        if (flag) {
            BannerRenderer.renderPatterns(poseStack, buffer, packedLight, packedOverlay, this.shieldModel.plate(), rendermaterial, false,
                    stack.getOrDefault(DataComponents.BASE_COLOR, DyeColor.WHITE),
                    stack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY), stack.hasFoil());
        } else {
            this.shieldModel.plate().render(poseStack, vertexConsumer, packedLight, packedOverlay, -1);
        }
        poseStack.popPose();
    }
}
