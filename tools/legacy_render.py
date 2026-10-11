from pathlib import Path
root = Path(__file__).resolve().parents[1]
base = root / 'common/src/main/java/codes/atomys/advr'
widget = base / 'screens/AdvancementReloadedWidget.java'
s = widget.read_text(encoding='utf-8')
s = s.replace('new ResourceLocation("advancements/title_box")', 'new ResourceLocation("textures/gui/advancements/widgets.png")')
s = s.replace('context.blitSprite(advancementObtainedStatus.frameSprite(this.display.getFrame()),', 'context.blit(TITLE_BOX_TEXTURE,')
s = s.replace('context.blitSprite(advancementObtainedStatus3.frameSprite(this.display.getFrame()),', 'context.blit(TITLE_BOX_TEXTURE,')
s = s.replace('y + this.y, 26, 26);', 'y + this.y, this.display.getFrame().getTexture(), 128 + advancementObtainedStatus.getIndex() * 26, 26, 26);')
s = s.replace('originY + this.y, 26, 26);', 'originY + this.y, this.display.getFrame().getTexture(), 128 + advancementObtainedStatus3.getIndex() * 26, 26, 26);')
s = s.replace('context.blitSprite(TITLE_BOX_TEXTURE, m, l + 26 - n, this.width, n);', 'context.blitNineSliced(TITLE_BOX_TEXTURE, m, l + 26 - n, this.width, n, 10, 200, 26, 0, 52);')
s = s.replace('context.blitSprite(TITLE_BOX_TEXTURE, m, l, this.width, n);', 'context.blitNineSliced(TITLE_BOX_TEXTURE, m, l, this.width, n, 10, 200, 26, 0, 52);')
s = s.replace('context.blitSprite(advancementObtainedStatus.boxSprite(), 200, 26, 0, 0, m, l, j, 26);', 'context.blit(TITLE_BOX_TEXTURE, m, l, 0, advancementObtainedStatus.getIndex() * 26, j, 26);')
s = s.replace('context.blitSprite(advancementObtainedStatus2.boxSprite(), 200, 26, 200 - k, 0, m + j, l, k, 26);', 'context.blit(TITLE_BOX_TEXTURE, m + j, l, 200 - k, advancementObtainedStatus2.getIndex() * 26, k, 26);')
widget.write_text(s, encoding='utf-8')
tab = base / 'screens/AdvancementReloadedTab.java'
s = tab.read_text(encoding='utf-8').replace('new ResourceLocation("advancements/task_frame_obtained")', 'new ResourceLocation("textures/gui/advancements/widgets.png")').replace('new ResourceLocation("advancements/task_frame_unobtained")', 'new ResourceLocation("textures/gui/advancements/widgets.png")')
s = s.replace('context.blitSprite(texture, this.tab_x, this.tab_y, this.type.getWidth(), this.type.getHeight());', 'context.blitNineSliced(texture, this.tab_x, this.tab_y, this.type.getWidth(), this.type.getHeight(), 4, 26, 26, 0, selected ? 128 : 154);')
tab.write_text(s, encoding='utf-8')
screen = base / 'screens/AdvancementReloadedScreen.java'
s = screen.read_text(encoding='utf-8')
s = s.replace('tab.getDisplay().getBackground()\n              .orElse(TextureManager.INTENTIONAL_MISSING_TEXTURE)', 'Optional.ofNullable(tab.getDisplay().getBackground()).orElse(TextureManager.INTENTIONAL_MISSING_TEXTURE)')
s = s.replace('display.getBackground()\n          .orElse(TextureManager.INTENTIONAL_MISSING_TEXTURE)', 'Optional.ofNullable(display.getBackground()).orElse(TextureManager.INTENTIONAL_MISSING_TEXTURE)')
s = s.replace('context.blitSprite(SCROLLER_BACKGROUND_TEXTURE, width - 6, Configuration.headerHeight,\n        6, drawingHeight);', 'context.fill(width - 6, Configuration.headerHeight, width, Configuration.headerHeight + drawingHeight, 0x80000000);')
s = s.replace('context.blitSprite(SCROLLER_TEXTURE, width - 6, scrollBarY, 6, scrollBarHeight);', 'context.fill(width - 6, scrollBarY, width, scrollBarY + scrollBarHeight, 0xffaaaaaa);')
s = s.replace('Screen.INWORLD_HEADER_SEPARATOR', 'criteriasSeparator').replace('Screen.INWORLD_FOOTER_SEPARATOR', 'criteriasSeparator')
s = s.replace('context.blit(criteriasSeparator, 0,\n        Configuration.headerHeight - 1, 0.0F, 0.0F,\n        width, 2, 32, 2);', 'context.fill(0, Configuration.headerHeight - 1, width, Configuration.headerHeight + 1, 0xff808080);')
s = s.replace('context.blit(criteriasSeparator, 0,\n        height - Configuration.footerHeight - 1, 0.0F,\n        0.0F, width, 2, 32, 2);', 'context.fill(0, height - Configuration.footerHeight - 1, width, height - Configuration.footerHeight + 1, 0xff808080);')
s = s.replace('advancementTab.getFrame()', 'advancementTab.getType()')
# The original achievement-background branch leaves a pose pushed across frames.
s = s.replace('        context.pose().pushPose();\n        context.pose().translate(0.0F, 0.0F, 300.0F);\n        break;', '        break;')
screen.write_text(s, encoding='utf-8')
print('Adapted widgets, tooltip atlas, scrollbars and backgrounds to 1.20.1.')
