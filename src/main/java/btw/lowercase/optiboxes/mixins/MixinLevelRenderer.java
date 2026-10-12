package btw.lowercase.optiboxes.mixins;

import btw.lowercase.optiboxes.OptiBoxesClient;
import btw.lowercase.optiboxes.skybox.OptiFineSkyRenderer;
import btw.lowercase.optiboxes.skybox.OptiFineSkybox;
import btw.lowercase.optiboxes.skybox.SkyboxManager;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LevelRenderer.class)
public abstract class MixinLevelRenderer {
    @Shadow
    @Nullable
    private ClientLevel level;

    @Inject(
            method = "renderSky",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;blendFuncSeparate(Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;)V")
    )
    private void optiboxes$renderNormalSkyboxes(PoseStack poseStack, Matrix4f projectionMatrix, float tickDelta,
                                                 Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
        this.optiboxes$renderSkyboxes(poseStack, tickDelta, false);
    }

    @Inject(method = "renderSky", at = @At("TAIL"))
    private void optiboxes$renderNonNormalSkyboxes(PoseStack poseStack, Matrix4f projectionMatrix, float tickDelta,
                                                    Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
        if (this.level != null && this.level.effects().skyType() != DimensionSpecialEffects.SkyType.NORMAL) {
            this.optiboxes$renderSkyboxes(poseStack, tickDelta, true);
        }
    }

    @WrapOperation(
            method = "renderSky",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferUploader;drawWithShader(Lcom/mojang/blaze3d/vertex/BufferBuilder$RenderedBuffer;)V", ordinal = 1)
    )
    private void optiboxes$toggleSun(BufferBuilder.RenderedBuffer renderedBuffer, Operation<Void> original) {
        if (this.optiboxes$renderSunMoon()) {
            original.call(renderedBuffer);
        }
    }

    @WrapOperation(
            method = "renderSky",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferUploader;drawWithShader(Lcom/mojang/blaze3d/vertex/BufferBuilder$RenderedBuffer;)V", ordinal = 2)
    )
    private void optiboxes$toggleMoon(BufferBuilder.RenderedBuffer renderedBuffer, Operation<Void> original) {
        if (this.optiboxes$renderSunMoon()) {
            original.call(renderedBuffer);
        }
    }

    @WrapOperation(
            method = "renderSky",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexBuffer;drawWithShader(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/renderer/ShaderInstance;)V", ordinal = 1)
    )
    private void optiboxes$toggleStars(VertexBuffer instance, Matrix4f modelViewMatrix, Matrix4f projectionMatrix,
                                       ShaderInstance shader, Operation<Void> original) {
        if (this.level == null || !OptiBoxesClient.getConfig().enabled.isEnabled()
                || OptiBoxesClient.getConfig().renderStars.isEnabled()) {
            original.call(instance, modelViewMatrix, projectionMatrix, shader);
        }
    }

    private boolean optiboxes$renderSunMoon() {
        return this.level == null || !OptiBoxesClient.getConfig().enabled.isEnabled()
                || OptiBoxesClient.getConfig().renderSunMoon.isEnabled();
    }

    private void optiboxes$renderSkyboxes(PoseStack poseStack, float tickDelta, boolean restoreDepthMask) {
        if (!SkyboxManager.INSTANCE.isEnabled(this.level)) {
            return;
        }

        List<OptiFineSkybox> activeSkyboxes = SkyboxManager.INSTANCE.getActiveSkyboxes();
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
        RenderSystem.depthMask(false);
        try {
            for (OptiFineSkybox skybox : activeSkyboxes) {
                OptiFineSkyRenderer.INSTANCE.renderSkybox(skybox, poseStack, this.level, tickDelta);
            }
        } finally {
            poseStack.popPose();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.defaultBlendFunc();
            if (restoreDepthMask) {
                RenderSystem.depthMask(true);
                RenderSystem.disableBlend();
            } else {
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
            }
        }
    }
}
