# Skyboxify 1.20.1 Fabric Backport (Unofficial)

This repository is an unofficial community backport of [Skyboxify / OptiBoxes](https://github.com/Legacy-Visuals-Project/Skyboxify) for Fabric on Minecraft 1.20.1. It is not an official release and is not affiliated with the upstream maintainers.

The client-side mod reads OptiFine/MCPatcher sky properties from enabled resource packs and renders cubemap sky layers in the Overworld, Nether, and End. Layer properties supported by the upstream format include time fades, blend modes, rotation, weather, biome, height, and day conditions. Use the original project documentation for resource-pack authoring conventions.

## Build

Use JDK 21 and run:

```powershell
.\gradlew.bat :1.20.1-fabric:build --console=plain
```

The Fabric JAR is written to `versions/1.20.1-fabric/build/libs/`.

## Local QA

The port was built and launched in a separate Gradle client profile with Minecraft 1.20.1, Fabric Loader 0.16.14, Fabric API 0.92.2+1.20.1, and Mod Menu 7.2.2. A locally generated six-color 3x2 cubemap pack was detected, shown in a new world, retained after an F3+T resource reload, and reported by `/optiboxes debug`. The Mod Menu config screen also opened and closed successfully.

This is a smoke test of the 1.20.1 rendering and reload path. It does not certify compatibility with every OptiFine sky pack, other rendering mods, Iris, or shader packs.

## Credits and licenses

Upstream authors: lowercasebtw, FlashyReese, and AMereBagatelle. The upstream GPLv3 license and Minecraft Linking Exception are in `LICENSE`; the original MIT notice by AMereBagatelle is retained in `ORIGINAL_LICENSE`. Both notices are also included in the built JAR under `META-INF/licenses/optiboxes/`.

The upstream project's logo contribution is credited to UsernameGeri and Zenith. Please report backport-specific problems in this repository's issue tracker and upstream issues to the official project.

The CurseForge project icon in `branding/` is a new graphic drawn for this backport; it does not reuse the upstream logo.

AI disclosure: AI tools assisted with the 1.20.1 port and release documentation.
