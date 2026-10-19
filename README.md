# Moar Concrete — Fabric 1.20.1 unofficial backport

This project backports **Moar Concrete 1.3.1** by McJamweasel from Minecraft 1.21.1 to Fabric 1.20.1. It preserves the upstream block set and recipes: all 16 concrete colors with stairs, slabs, walls, fences, fence gates, buttons, concrete bricks and brick slabs, and concrete panels. Blocks use Minecraft's vanilla concrete textures.

The port is unofficial and is not endorsed by McJamweasel. Upstream project and source:

- Modrinth: https://modrinth.com/mod/moar-concrete
- Source branch: https://github.com/mcjamweasel/moar-concrete-mod-1.21/tree/1.3.1

## Requirements

- Minecraft 1.20.1
- Fabric Loader 0.15.11 or newer
- Fabric API for Minecraft 1.20.1
- Java 17 or newer

Install the matching Fabric API and this backport on both the client and server. The project uses MIT, as declared by the upstream Modrinth project and its `fabric.mod.json`; the original author is credited above and in `LICENSE`.

## Build and data generation

```powershell
.\gradlew.bat clean runDatagen --no-daemon
.\gradlew.bat processResources build --no-daemon
```

AI disclosure: AI tools assisted with the 1.20.1 API adaptation and release documentation.
