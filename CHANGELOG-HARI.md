# 0.6.1-hari.1 (beta)

- Unofficial AI-assisted backport of upstream v0.6.1-1.21.1 to Minecraft 1.20.1 Forge.
- Adapted advancement data, screen listeners, widgets and tooltips to the 1.20.1 APIs.
- Uses the vanilla 1.20.1 GUI atlas at runtime; Minecraft textures are not bundled.
- Retains full-screen tree, criteria sidebar, alphabetical sorting, remembered selection and Cloth Config screen.
- Handles non-resource-location criterion names without crashing and clears remembered details when the server resets advancements.
- Java 17, Forge 47, Cloth Config 11.1.136+ (11.x) required on the client.
- Tested with Forge 47.4.20 in a development client using synthetic advancement packets and real rendering. This is not a full modpack compatibility certification.
- Advancement search from later upstream versions is not part of the 0.6.1 base.

AI disclosure: the port adaptations and release documentation were prepared with AI assistance. Original upstream content remains credited to its authors.
