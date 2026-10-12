# Borderless Mining (Unofficial) — Fabric 1.21.1

An unofficial Fabric 1.21.1 port of [Borderless Mining](https://github.com/comp500/BorderlessMining) by comp500. This port is AI-assisted and is not an official release or endorsed by the original author.

The port preserves the upstream behavior: borderless fullscreen, the video-settings toggle, optional Mod Menu configuration, monitor selection, custom window dimensions, and the existing translations and icon. Its code and bundled assets remain under the upstream MIT license; see [LICENSE](LICENSE) and [UPSTREAM_README.md](UPSTREAM_README.md) for attribution.

## Build

- Minecraft 1.21.1
- Fabric Loader 0.19.5 or newer
- Java 21

Run `./gradlew build` (Windows: `gradlew.bat build`). The distributable is written to `build/libs/`.

## Validation boundary

Compilation and launch checks do not establish compatibility with every operating system, display driver, multi-monitor layout, shader, or other window-management mod. Report port-specific bugs here; report issues in the original version to the upstream project.

## Credits and license

- Original project and implementation: comp500, [BorderlessMining](https://github.com/comp500/BorderlessMining)
- Port maintenance: JustHari01
- AI assistance: used during the 1.21.1 port
- License: MIT, preserved from upstream
