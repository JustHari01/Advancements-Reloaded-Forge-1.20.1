# Advancements Reloaded (UNOFFICIAL)

An **AI-assisted unofficial Forge 1.20.1 backport** of Advancements Reloaded, based on upstream **v0.6.1-1.21.1**. It expands the advancement tree to use the screen, shows completed and missing criteria in a sidebar, sorts tabs and criteria alphabetically, and remembers the selected advancement when reopening the screen.

This is a community backport maintained by Hari, not an official release from or endorsed by the original authors. **The backport code and release descriptions were prepared with AI assistance.** This disclosure applies to this port's work, not the upstream authors' work.

## Features

- Full-screen advancement tree with scrolling and dragging.
- Criteria sidebar showing completed and missing requirements.
- Alphabetical tab and criteria ordering.
- Remembered selection and configurable layout/background.
- Cloth Config settings accessible from the Forge Mods screen.

## Installation

Requires **Minecraft 1.20.1**, **Forge 47**, **Java 17** and **Cloth Config 11.1.136 or a compatible newer 11.x Forge release**. Install on the client; the server does not need this mod. Open Advancements with the usual key (default **L**) or through the pause menu.

This beta ports the 0.6.1 feature set. Advancement search from later upstream releases is not included. Other advancement-screen replacement mods may conflict; do not install another build with the same `advancements_reloaded` mod ID. The inherited transparent-background limitation on Forge remains.

Validation: a Minecraft 1.20.1 / Forge 47.4.20 development client passed fixture checks for 40 criteria, partial progress, alphabetical tabs, scrolling, backgrounds, GUI scale, configuration, reopening, reset and empty state. This does not certify every modpack or multiplayer setup.

## Credits and source

- Original Advancements Reloaded by **42atomys**: https://github.com/42atomys/mc-advancements-reloaded
- Earlier AdvancementInfo by **gbl**: https://github.com/gbl/AdvancementInfo
- Original Modrinth project: https://modrinth.com/mod/advancements-reloaded
- This Forge backport's source and support: https://github.com/JustHari01/Advancements-Reloaded-Forge-1.20.1

**MIT License.** The original copyright/license notice is preserved. The upstream icon and translations remain credited to their authors. Source code and port notices are available in the repository and source attachment. Please report backport issues to this fork.
