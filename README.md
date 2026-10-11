# Advancements Reloaded (UNOFFICIAL)

An AI-assisted unofficial **Forge 1.20.1 backport** of Advancements Reloaded **v0.6.1-1.21.1**. View the advancement tree across the screen, inspect completed and missing criteria in a sidebar, sort tabs and criteria alphabetically, and configure the layout through Cloth Config.

This is a community backport maintained by Hari. It is not an official release from, or endorsed by, 42atomys or gbl. **The port code and this documentation were prepared with AI assistance.** This statement concerns the backport work; it does not describe the original authors' work.

## Installation

- Minecraft Java Edition **1.20.1**, **Forge 47**, and **Java 17**.
- Install **Cloth Config 11.1.136 or a compatible newer 11.x Forge release**.
- Put the release JAR in the client's `mods` directory. Servers do not need it.
- Open Advancements with the usual key (default `L`) or the pause menu. Click an advancement to inspect its criteria; scroll the sidebar or drag the tree. Open the configuration through the Forge Mods screen.

Do not install alongside another build of AdvancementInfo / Advancements Reloaded with the same mod ID. Other advancement-screen replacement mods may conflict.

## Scope and limitations

This beta ports the 0.6.1 feature set. Advancement search introduced in later upstream versions is not included. The inherited transparent-background limitation on Forge remains. Test a copied profile before adding this beta to a large modpack.

The automated fixture harness launched a real Minecraft 1.20.1 / Forge 47.4.20 client and checked alphabetical tabs, 40 criteria including a name with spaces, partial progress, sidebar scrolling, three backgrounds, GUI scaling, configuration rendering, reopening, server reset and empty state. Six screenshots were visually checked. These tests use synthetic packets and do not certify an installed modpack, multiplayer session or every datapack.

## Credits and license

- Original Advancements Reloaded by **42atomys**: https://github.com/42atomys/mc-advancements-reloaded
- Base tag: **v0.6.1-1.21.1**.
- Earlier AdvancementInfo by **gbl**: https://github.com/gbl/AdvancementInfo
- Original release: https://modrinth.com/mod/advancements-reloaded
- This backport's source and support: https://github.com/JustHari01/Advancements-Reloaded-Forge-1.20.1

The upstream MIT license and copyright notice are retained in `LICENSE`. See `HARI-PORT-NOTICE.md` for backport attribution. The icon is the upstream MIT-licensed icon. Minecraft GUI textures are referenced from the installed game and are not redistributed here.

## Build and reproduce checks

With JDK 17, run `./gradlew build` (`gradlew.bat build` on Windows). Release files are in `build/libs`.

For the fixture UI check, run `./gradlew runClient -Pqa=true`. The QA harness exists only in that explicitly requested QA build and shuts down after printing `[ADVR-QA] PASS` or `FAIL`. Screenshots are written in `run-client/screenshots`. **Run `./gradlew clean build` without `-Pqa` afterwards** to produce a release without the harness.

The root Gradle project builds only Forge 1.20.1. Historical Fabric/NeoForge directories are retained for upstream provenance and are not release targets of this fork. The scripts in `tools` record the one-time migration; they are not required to build and should not be rerun on the finished tree.

