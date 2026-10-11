package codes.atomys.advr.qa;

import codes.atomys.advr.config.Configuration;
import codes.atomys.advr.config.gui.ConfigurationScreen;
import codes.atomys.advr.screens.AdvancementReloadedScreen;
import codes.atomys.advr.screens.AdvancementReloadedTab;
import codes.atomys.advr.utils.Memory;
import com.mojang.logging.LogUtils;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Synthetic data, real Minecraft rendering. Never included in a release JAR. */
@Mod.EventBusSubscriber(modid = "advancements_reloaded", value = Dist.CLIENT)
public final class BackportRuntimeQa {
  private static int phase, ticks;
  private static ClientAdvancements manager;
  private static Advancement child;
  private static AdvancementReloadedScreen screen;

  @SubscribeEvent
  public static void tick(TickEvent.ClientTickEvent event) {
    if (!Boolean.getBoolean("advr.qa") || event.phase != TickEvent.Phase.END) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc.getOverlay() != null || (phase == 0 && mc.screen == null)) return;
    if (++ticks < 35) return;
    ticks = 0;
    try {
      switch (phase++) {
        case 0 -> {
          mc.options.guiScale().set(2);
          mc.resizeDisplay();
          manager = new ClientAdvancements(mc, null);
          Advancement zeta = root("zeta", "Zeta category");
          Advancement alpha = root("alpha", "Alpha category");
          Advancement.Builder builder = Advancement.Builder.advancement().parent(alpha)
              .display(Items.DIAMOND, Component.literal("A long checklist"),
                  Component.literal("Runtime fixture: 40 criteria with partial progress"),
                  null, FrameType.CHALLENGE, false, false, false);
          for (int i = 0; i < 39; i++) builder.addCriterion(String.format("criterion_%02d", i),
              new ImpossibleTrigger.TriggerInstance());
          builder.addCriterion("Custom Name With Spaces", new ImpossibleTrigger.TriggerInstance());
          child = builder.build(new ResourceLocation("advrqa:alpha/checklist"));
          TreeNodePosition.run(alpha);
          TreeNodePosition.run(zeta);
          Map<ResourceLocation, AdvancementProgress> progress = new HashMap<>();
          for (Advancement advancement : List.of(zeta, alpha, child)) {
            AdvancementProgress p = new AdvancementProgress();
            p.update(advancement.getCriteria(), advancement.getRequirements());
            p.grantProgress(advancement.getCriteria().keySet().iterator().next());
            progress.put(advancement.getId(), p);
          }
          manager.update(new ClientboundUpdateAdvancementsPacket(true, List.of(zeta, alpha, child), Set.of(), progress));
          child = manager.getAdvancements().get(child.getId());
          screen = new AdvancementReloadedScreen(manager);
          mc.setScreen(screen);
          screen.setSelectedWidget(screen.getAdvancementWidget(child));
          require(screen.getSelectedWidget().getSteps().size() == 40, "all criteria preserved");
          require(screen.getSelectedWidget().getSteps().stream().filter(s -> s.isObtained()).count() == 1,
              "partial progress preserved");
          Field tabs = AdvancementReloadedScreen.class.getDeclaredField("tabs");
          tabs.setAccessible(true);
          Collection<?> values = ((Map<?, ?>) tabs.get(screen)).values();
          require(((AdvancementReloadedTab) values.iterator().next()).getTitle().getString().startsWith("Alpha"),
              "alphabetical root tabs");
        }
        case 1 -> {
          capture(mc, "qa-sidebar.png");
          screen.mouseScrolled(screen.width - 30, Configuration.headerHeight + 50, -4);
          Field scroll = AdvancementReloadedScreen.class.getDeclaredField("scrollOffset");
          scroll.setAccessible(true);
          require(scroll.getInt(screen) > 0, "criteria scrollbar moves");
        }
        case 2 -> {
          capture(mc, "qa-scrolled.png");
          Configuration.backgroundStyle = Configuration.BackgroundStyle.ACHIEVEMENT;
        }
        case 3 -> {
          capture(mc, "qa-achievement-background.png");
          Configuration.backgroundStyle = Configuration.BackgroundStyle.BLACK;
          mc.options.guiScale().set(3);
          mc.resizeDisplay();
          require(screen.getSelectedWidget() != null && screen.getSelectedWidget().getAdvancement().equals(child),
              "resize restores selection");
        }
        case 4 -> {
          capture(mc, "qa-scale3.png");
          mc.setScreen(ConfigurationScreen.screen(screen));
        }
        case 5 -> {
          capture(mc, "qa-config.png");
          mc.setScreen(screen);
          require(screen.getSelectedWidget() != null, "reopen restores selection");
          manager.update(new ClientboundUpdateAdvancementsPacket(true, List.of(), Set.of(), Map.of()));
          require(screen.getSelectedWidget() == null && Memory.getWidget() == null, "server reset clears stale selection");
        }
        case 6 -> capture(mc, "qa-empty.png");
        case 7 -> {
          for (String name : List.of("qa-sidebar.png", "qa-scrolled.png", "qa-achievement-background.png",
              "qa-scale3.png", "qa-config.png", "qa-empty.png")) {
            require(Files.size(mc.gameDirectory.toPath().resolve("screenshots").resolve(name)) > 1000,
                "saved screenshot " + name);
          }
          LogUtils.getLogger().info("[ADVR-QA] PASS: rendered sidebar, scroll, three backgrounds, GUI scale, config, reopen, reset, empty state");
          mc.stop();
        }
        default -> {}
      }
    } catch (Throwable failure) {
      LogUtils.getLogger().error("[ADVR-QA] FAIL", failure);
      mc.stop();
    }
  }

  private static Advancement root(String id, String title) {
    return Advancement.Builder.advancement().display(Items.BOOK, Component.literal(title),
        Component.literal("Synthetic QA category"), new ResourceLocation("textures/block/stone.png"),
        FrameType.TASK, false, false, false)
        .addCriterion("root", new ImpossibleTrigger.TriggerInstance())
        .build(new ResourceLocation("advrqa:" + id));
  }

  private static void capture(Minecraft mc, String name) {
    Screenshot.grab(mc.gameDirectory, name, mc.getMainRenderTarget(), message -> {});
  }

  private static void require(boolean condition, String message) {
    if (!condition) throw new AssertionError(message);
    LogUtils.getLogger().info("[ADVR-QA] OK: {}", message);
  }
}
