package com.redlimerl.detailab.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.redlimerl.detailab.render.ArmorBarRenderer;
import static com.redlimerl.detailab.DetailArmorBar.getConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class ArmorBarMixin {

    @Shadow private int lastHealth;
    @Shadow private int displayHealth;
    @Shadow protected abstract Player getCameraPlayer();

    @Inject(method = "renderPlayerHealth", at = @At("TAIL"))
    private void renderArmorOverlay(GuiGraphics context, CallbackInfo ci) {
        Player player = this.getCameraPlayer();
        if (player == null) return;

        float maxHealth = Math.max((float) player.getAttributeValue(Attributes.MAX_HEALTH),
                Math.max(this.lastHealth, this.displayHealth));
        int absorption = Mth.ceil(player.getAbsorptionAmount());
        int numRows = Mth.ceil((maxHealth + absorption) / 2.0F / 10.0F);
        int lineWidth = Math.max(10 - (numRows - 2), 3);
        if (getConfig().getOptions().toggleCompatibleHeartMod) numRows = 1;

        int yBase = Minecraft.getInstance().getWindow().getGuiScaledHeight() - 39;
        int y = yBase - (numRows - 1) * lineWidth - 10;
        ArmorBarRenderer.INSTANCE.render(context, player, y);
    }

    @WrapOperation(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getArmorValue()I"))
    private int suppressGameArmorRenderer(Player playerEntity, Operation<Integer> operation) {
        return 0;
    }
}
