# ScalableLux (Unofficial 1.20.1 Fabric Backport)

This independent Fabric backport brings the Starlight-based lighting engine and configurable parallel lighting from ScalableLux 0.1.0.1 to Minecraft 1.20.1. It preserves the upstream lighting and scheduling code and adapts its Minecraft interfaces for 1.20.1.

The release is Java 17 bytecode for Minecraft 1.20.1 and Fabric Loader 0.15.11 or newer. MixinExtras 0.3.5 or newer is required. Install on both sides for single-player and on the server and clients for multiplayer. Do not use a second mod that replaces the light engine, such as Starlight or Phosphor. Back up worlds before testing any lighting-engine replacement.

The released mod shades FlowSched. Both its full MIT license and the project's LGPL-3.0-only license are included in the JAR. The full FlowSched license is also in the `FlowSched` submodule. Read [HARI-PORT-NOTICE.md](HARI-PORT-NOTICE.md) and [LICENSE](LICENSE) before redistributing modified builds.

## Build

Use JDK 17 or newer and run `gradlew build`. The release JAR is written to `build/libs`; it includes the upstream and port notices. Source stays Java 17 compatible.

## Verification

The 1.20.1 Fabric GameTest run passed four checks with both one and four configured light workers: block light propagation and removal across a chunk border, sky light through a roof opening and closure, saved and reloaded block/sky light arrays, and immediate chunk lookup with positive and negative asymmetric coordinates. The upstream client startup was also smoke-tested, with all server and client light-engine mixins applied. These tests do not certify every world, modpack, shader, or third-party lighting interaction.

This community release is not official, approved, endorsed, or maintained by Spottedleaf, ishland, PaperMC, or RelativityMC. Report 1.20.1 backport issues here; report upstream issues to [RelativityMC/ScalableLux](https://github.com/RelativityMC/ScalableLux).

The backport code, release description, and original project logo were prepared with AI assistance; this disclosure does not describe the upstream authors' work.
