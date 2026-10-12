package btw.lowercase.optiboxes.skybox;

import btw.lowercase.optiboxes.utils.CommonUtils;
import btw.lowercase.optiboxes.utils.UVRange;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.AxisAngle4f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public final class OptiFineSkyRenderer {
    public static final OptiFineSkyRenderer INSTANCE = new OptiFineSkyRenderer();

    private VertexBuffer skyBuffer;

    private OptiFineSkyRenderer() {
        Minecraft.getInstance().execute(this::buildSky);
    }

    private void buildSky() {
        VertexFormat format = DefaultVertexFormat.POSITION_TEX;
        BufferBuilder builder = new BufferBuilder(format.getVertexSize() * 24);
        builder.begin(VertexFormat.Mode.QUADS, format);

        for (int face = 0; face < 6; face++) {
            UVRange uv = CommonUtils.getUvRangeForFace(face);
            Matrix4f rotation = CommonUtils.getRotationMatrixForFace(face);
            float size = 100.0F;
            addVertex(builder, rotation, -size, -size, -size, uv.minU(), uv.minV());
            addVertex(builder, rotation, -size, -size, size, uv.minU(), uv.maxV());
            addVertex(builder, rotation, size, -size, size, uv.maxU(), uv.maxV());
            addVertex(builder, rotation, size, -size, -size, uv.maxU(), uv.minV());
        }

        skyBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
        skyBuffer.bind();
        skyBuffer.upload(builder.end());
        VertexBuffer.unbind();
    }

    private static void addVertex(BufferBuilder builder, Matrix4f matrix, float x, float y, float z, float u, float v) {
        Vector3f point = CommonUtils.getMatrixTransform(matrix, x, y, z);
        builder.vertex(point.x, point.y, point.z).uv(u, v).endVertex();
    }

    public void renderSkybox(OptiFineSkybox skybox, PoseStack poseStack, Level level, float tickDelta) {
        long dayTime = level.getDayTime();
        int timeOfDay = (int) (dayTime % 24000L);
        float skyAngle = level.getTimeOfDay(tickDelta);
        float thunder = level.getThunderLevel(tickDelta);
        float rain = level.getRainLevel(tickDelta);
        if (rain > 0.0F) {
            thunder /= rain;
        }

        for (OptiFineSkyLayer layer : skybox.getLayers()) {
            if (layer.isActive(dayTime, timeOfDay)) {
                renderSkyLayer(layer, poseStack, level, timeOfDay, skyAngle, rain, thunder,
                        skybox.getConditionAlphaFor(layer));
            }
        }
    }

    private void renderSkyLayer(OptiFineSkyLayer layer, PoseStack poseStack, Level level, int timeOfDay,
                                float skyAngle, float rain, float thunder, float conditionAlpha) {
        float weatherAlpha = CommonUtils.getWeatherAlpha(layer.weatherConditions(), rain, thunder);
        float fadeAlpha = layer.fade().getAlpha(timeOfDay);
        float alpha = Mth.clamp(conditionAlpha * weatherAlpha * fadeAlpha, 0.0F, 1.0F);
        if (alpha < 1.0E-4F || skyBuffer == null) {
            return;
        }

        poseStack.pushPose();
        try {
            if (layer.rotate()) {
                poseStack.mulPose(new Quaternionf(new AxisAngle4f(getAngle(level, skyAngle, layer.speed()), layer.axis())));
            }

            RenderSystem.setShaderTexture(0, layer.source());
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            layer.blend().apply(alpha);

            skyBuffer.bind();
            skyBuffer.drawWithShader(poseStack.last().pose(), RenderSystem.getProjectionMatrix(), RenderSystem.getShader());
            VertexBuffer.unbind();
        } finally {
            poseStack.popPose();
        }
    }

    private float getAngle(Level level, float skyAngle, float speed) {
        float dayStart = 0.0F;
        if (speed != (float) Math.round(speed)) {
            long currentWorldDay = (level.getDayTime() + 18000L) / 24000L;
            double anglePerDay = speed % 1.0F;
            double currentAngle = currentWorldDay * anglePerDay;
            dayStart = (float) (currentAngle % 1.0D);
        }

        return (float) Math.toRadians(360.0F * (dayStart + skyAngle * speed));
    }

    public void clearCache() {
        // The vertex buffer is independent of resource-pack textures and stays valid across reloads.
    }
}
