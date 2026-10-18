# Detail Armor Bar Reconstructed — 1.20.1 Fabric Port

An unofficial Minecraft 1.20.1 Fabric port of [Detail Armor Bar Reconstructed](https://modrinth.com/mod/detail-armor-bar-reconstructed), based on its upstream Fabric 1.21.1 source.

The port keeps the upstream armor bar, enchantment overlays and per-piece coloring, thorns indicator, armor-trim overlay, durability notifications, configuration screen, resource-pack definitions, and developer API. The original textures and icon are included unchanged.

## Compatibility

- Minecraft 1.20.1
- Fabric Loader 0.16.14 or newer
- Fabric API 0.92.12+1.20.1
- Mod Menu 7.2.2 is optional and provides the configuration screen
- Client-side only

## Build

Run `gradlew build` with Java 21. The compiled mod targets Java 17 bytecode. The distributable JAR is created in `build/libs/`.

## Attribution and license

The original mod was created by RedLime and is maintained by coredex-source. This port is maintained by JustHari01 and is not an official release or endorsed by the upstream maintainers. The original MIT license is included in the JAR as `LICENSE_DetailArmorBarReconstructed`.

Porting work used AI assistance. Original code and assets remain attributed to their respective upstream contributors.
