package btw.lowercase.optiboxes.config;

import btw.lowercase.lightconfig.lib.ConfigTranslate;
import btw.lowercase.lightconfig.lib.v1.field.BooleanConfigField;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public class OptiBoxesConfigScreen extends Screen {
    private final Screen parent;
    private final OptiBoxesConfig config;

    public OptiBoxesConfigScreen(Screen parent, Component title, OptiBoxesConfig config) {
        super(title);
        this.parent = parent;
        this.config = config;
    }

    @Override
    protected void init() {
        StringWidget titleWidget = new StringWidget(this.getTitle(), this.font);
        titleWidget.setPosition((this.width - titleWidget.getWidth()) / 2, 12);
        this.addRenderableWidget(titleWidget);

        int left = this.width / 2 - 205;
        int right = this.width / 2 + 5;
        int firstRow = 38;
        int rowGap = 26;

        this.addField(this.config.enabled, left, firstRow, null);
        this.addField(this.config.showOverworldForUnknownDimension, right, firstRow, null);
        this.addField(this.config.processOptiFine, left, firstRow + rowGap, this::reloadPacks);
        this.addField(this.config.processMCPatcher, right, firstRow + rowGap, this::reloadPacks);
        this.addField(this.config.renderSunMoon, left, firstRow + rowGap * 2, null);
        this.addField(this.config.renderStars, right, firstRow + rowGap * 2, null);
        this.addField(this.config.ignoreBrokenSkies, left, firstRow + rowGap * 3, this::reloadPacks);

        int footerY = this.height - 30;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, button -> this.onClose())
                .bounds(this.width / 2 - 130, footerY, 125, 20).build());
        this.addRenderableWidget(Button.builder(ConfigTranslate.RESET, button -> {
            this.config.reset();
            this.config.save();
            this.reloadPacks();
            this.rebuildWidgets();
        }).bounds(this.width / 2 + 5, footerY, 125, 20).build());
    }

    private void addField(BooleanConfigField field, int x, int y, Runnable onClick) {
        Button button = field.createWidget(onClick == null ? () -> { } : onClick);
        button.setWidth(200);
        button.setPosition(x, y);
        this.addRenderableWidget(button);
    }

    private void reloadPacks() {
        this.minecraft.reloadResourcePacks();
    }

    @Override
    public void onClose() {
        this.config.save();
        this.minecraft.setScreen(this.parent);
    }
}
