# Forge 1.20.1 runtime validation

2026-10-11: Java 17, Forge 47.4.20, Cloth Config 11.1.136, NVIDIA GTX 1050 Ti.
The fixture harness ran a real Minecraft client using synthetic advancement packets. PASS: alphabetical root tabs; 40 criteria (including spaces/uppercase); one obtained criterion; sidebar scrolling; three background modes; GUI scaling; Cloth Config rendering; remembered selection; server reset clearing stale selection; empty screen. Six PNG screenshots were saved and visually inspected.

This is a development-client check, not a test in a user's installed modpack or a live multiplayer server. Release mixin refmap contains both key and pause-menu targets. The final release JAR includes MIT LICENSE and port attribution, and excludes the QA harness and Minecraft source/textures.
