# ScalableLux unofficial Fabric 1.20.1 backport

Maintained by Hari. This is an independent community backport, not an official
release from or endorsement by Spottedleaf, ishland, PaperMC, or RelativityMC.

The lighting engine and its upstream fixes come from RelativityMC/ScalableLux,
branch `ver/1.21.1`, commit `d0d58ab` (version 0.1.0.1). Original authors and
copyright notices are retained. This project remains LGPL-3.0-only; see LICENSE.

FlowSched is included at commit
`5210232ae17375c663aca4ea90b0f3528c55ca68`. It is MIT-licensed, copyright 2023
ishland. Its complete license is preserved in the submodule and included in the
binary as `META-INF/licenses/FlowSched-MIT.txt`.

Port changes dated 2026-10-13:

- Adapt ChunkStatus, ChunkHolder/Either, BlockStateBase, chunk packet, and chunk
  serialization APIs to Minecraft 1.20.1.
- Restore Minecraft 1.20.1's LIGHT ticket release after chunk lighting.
- Fix the immediate client chunk lookup to use the requested Z coordinate.
- Restrict the release to Minecraft 1.20.1 and identify the unofficial backport.
- Include upstream licenses and separate development-only lighting GameTests.

The upstream lighting engine, scheduling, and configuration work remain
credited to their authors. The icon in this backport is an original, newly created port graphic. No third-party credentials are included.

The backport code, release descriptions, and port icon were prepared with AI assistance;
this does not describe the upstream authors' work.
