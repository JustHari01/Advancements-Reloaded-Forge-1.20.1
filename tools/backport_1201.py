from pathlib import Path

root = Path(__file__).resolve().parents[1]

def write(name, text):
    path = root / name
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(text, encoding='utf-8')

write('build.gradle', '''plugins {
    id 'java'
    id 'net.minecraftforge.gradle' version '[6.0,6.2)'
    id 'org.spongepowered.mixin' version '0.7-SNAPSHOT'
}
group = 'codes.atomys.advr'
version = '0.6.1-hari.1'
base.archivesName = 'advancements-reloaded-forge-1.20.1'
java.toolchain.languageVersion = JavaLanguageVersion.of(17)
java.withSourcesJar()
minecraft {
    mappings channel: 'official', version: '1.20.1'
    runs {
        client {
            workingDirectory project.file('run-client')
            property 'forge.logging.console.level', 'info'
            property 'advr.qa', project.findProperty('qa') ?: 'false'
            mods { advancements_reloaded { source sourceSets.main } }
        }
        server {
            workingDirectory project.file('run-server')
            args '--nogui'
            mods { advancements_reloaded { source sourceSets.main } }
        }
    }
}
sourceSets.main {
    java.srcDirs = ['common/src/main/java', 'forge/src/main/java']
    resources.srcDirs = ['common/src/main/resources', 'forge/src/main/resources']
    resources.exclude 'advancements_reloaded.accesswidener'
}
repositories {
    maven { url = 'https://maven.shedaniel.me/' }
    mavenCentral()
}
dependencies {
    minecraft 'net.minecraftforge:forge:1.20.1-47.4.20'
    implementation fg.deobf('me.shedaniel.cloth:cloth-config-forge:11.1.136')
    annotationProcessor 'org.spongepowered:mixin:0.8.5:processor'
}
mixin {
    add sourceSets.main, 'advancements_reloaded.refmap.json'
    config 'advancements_reloaded.mixins.json'
}
processResources {
    inputs.property 'version', project.version
    filesMatching('META-INF/mods.toml') { expand version: project.version }
}
tasks.withType(JavaCompile).configureEach {
    options.encoding = 'UTF-8'
    options.release = 17
}
jar {
    from('LICENSE.txt')
    from('HARI-PORT-NOTICE.md')
    manifest.attributes('MixinConfigs': 'advancements_reloaded.mixins.json')
    finalizedBy 'reobfJar'
}
sourcesJar {
    from('LICENSE.txt')
    from('HARI-PORT-NOTICE.md')
}
''')
write('settings.gradle', '''pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = 'https://maven.minecraftforge.net/' }
        maven { url = 'https://repo.spongepowered.org/repository/maven-public/' }
    }
}
rootProject.name = 'advancements-reloaded-forge-1.20.1'
''')
write('gradle.properties', 'org.gradle.jvmargs=-Xmx3G\norg.gradle.daemon=false\n')
write('HARI-PORT-NOTICE.md', '''# Unofficial Forge 1.20.1 backport

Based on Advancements Reloaded by 42atomys, tag `v0.6.1-1.21.1`:
https://github.com/42atomys/mc-advancements-reloaded

Advancements Reloaded continues AdvancementInfo by gbl:
https://github.com/gbl/AdvancementInfo

Original copyright and MIT license are retained in LICENSE.txt. Original source,
translations and bundled UI textures remain credited to their authors.
This backport is maintained by Hari (JustHari01) and is not endorsed by the
upstream authors.

Changes: Forge 1.20.1 / Java 17 build, the legacy advancement data model,
Minecraft 1.20.1 GUI rendering and input, and backport-specific fixes.
The backport implementation and publishing text were produced with Codex AI.
The upstream project is independently human-authored; this notice does not
attribute AI use to the upstream authors.
''')

for p in (root / 'common/src/main/java').rglob('*.java'):
    s = p.read_text(encoding='utf-8')
    s = s.replace('import net.minecraft.advancements.AdvancementHolder;\n', '')
    s = s.replace('import net.minecraft.advancements.AdvancementNode;', 'import net.minecraft.advancements.Advancement;')
    s = s.replace('import net.minecraft.util.CommonColors;', 'import codes.atomys.advr.compat.LegacyColors;')
    s = s.replace('CommonColors.', 'LegacyColors.')
    s = s.replace('AdvancementHolder', 'Advancement').replace('AdvancementNode', 'Advancement')
    s = s.replace('.holder().value()', '').replace('.holder()', '').replace('.advancement()', '')
    s = s.replace('.requirements().size()', '.getRequirements().length')
    s = s.replace('.parent()', '.getParent()').replace('.root()', '.getRoot()').replace('.id()', '.getId()')
    s = s.replace('.display()', '.getDisplay()').replace('.getType()', '.getFrame()')
    s = s.replace('ResourceLocation.parse(', 'new ResourceLocation(')
    s = s.replace('ResourceLocation.withDefaultNamespace(', 'new ResourceLocation(')
    s = s.replace('.withDefaultNamespace(', '.withDefaultNamespace(')  # line-wrapped calls handled below
    s = s.replace('ResourceLocation\n      .parse(', 'new ResourceLocation(')
    s = s.replace('ResourceLocation\n      .withDefaultNamespace(', 'new ResourceLocation(')
    s = s.replace('case Configuration.BackgroundStyle.', 'case ')
    # Forge 1.20.1 uses nullable display/background rather than Optional.
    s = s.replace('final Optional<DisplayInfo> optional = root.getDisplay();', 'final Optional<DisplayInfo> optional = Optional.ofNullable(root.getDisplay());')
    s = s.replace('final Optional<DisplayInfo> optional = advancement.getDisplay();', 'final Optional<DisplayInfo> optional = Optional.ofNullable(advancement.getDisplay());')
    s = s.replace('advancement.getDisplay().isEmpty()', 'advancement.getDisplay() == null')
    s = s.replace('!advancement.getDisplay() == null', 'advancement.getDisplay() != null')
    s = s.replace('.getDisplay().get()', '.getDisplay()')
    s = s.replace('this.getSelectedWidget().getAdvancement().name().get()', 'this.getSelectedWidget().getAdvancement().getDisplay().getTitle()')
    s = s.replace('tab.getRoot().name().orElse(Component.literal(tab.getRoot().toString()))', 'tab.getTitle()')
    s = s.replace('renderBackground(context, mouseX, mouseY, delta);', 'renderBackground(context);')
    s = s.replace('this.selectedTab = null;', 'this.selectedTab = Optional.empty();')
    s = s.replace('final double mouseY, final double horizontalAmount,\n      final double verticalAmount)', 'final double mouseY, final double verticalAmount)')
    s = s.replace('horizontalAmount * 16.0', '(Screen.hasShiftDown() ? verticalAmount : 0.0) * 16.0')
    s = s.replace('verticalAmount * 16.0);', '(Screen.hasShiftDown() ? 0.0 : verticalAmount) * 16.0);')
    # Java duplicate imports caused by merging the node/holder/value data model.
    lines = s.splitlines()
    seen = set()
    lines = [line for line in lines if not (line.startswith('import ') and (line in seen or seen.add(line)))]
    p.write_text('\n'.join(lines)+'\n', encoding='utf-8')

display = root / 'common/src/main/java/codes/atomys/advr/ReloadedDisplayInfo.java'
s = display.read_text().replace('AdvancementType', 'FrameType').replace('final Optional<ResourceLocation> background', 'final ResourceLocation background')
display.write_text(s, encoding='utf-8')
toml = root / 'forge/src/main/resources/META-INF/mods.toml'
s = toml.read_text().replace('loaderVersion = "*"', 'loaderVersion = "[47,)"').replace('[48,)', '[47,)').replace('[1.21,)', '[1.20.1,1.20.2)').replace('[15.0.0,)', '[11.1.136,12)')
s = s.replace('displayName = "Advancements Reloaded"', 'displayName = "Advancements Reloaded: Hari Backport"')
s = s.replace('authors = "@42atomys"', 'authors = "42atomys, gbl; unofficial backport by Hari"')
s = '\n'.join(line for line in s.splitlines() if not line.startswith(('updateJSONURL=', 'issueTrackerURL=')))+'\n'
toml.write_text(s, encoding='utf-8')
write('common/src/main/java/codes/atomys/advr/compat/LegacyColors.java', '''package codes.atomys.advr.compat;

public final class LegacyColors {
    public static final int BLACK = 0xff000000;
    public static final int WHITE = 0xffffffff;
    public static final int LIGHT_GRAY = 0xffc0c0c0;
    public static final int GREEN = 0xff00ff00;
    public static final int RED = 0xffff0000;
    private LegacyColors() { }
}
''')
print('Prepared Forge 1.20.1 build and legacy advancement model.')
