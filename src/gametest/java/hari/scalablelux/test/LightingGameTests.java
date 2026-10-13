package hari.scalablelux.test;

import ca.spottedleaf.starlight.common.chunk.ExtendedChunk;
import ca.spottedleaf.starlight.common.config.Config;
import ca.spottedleaf.starlight.common.light.SWMRNibbleArray;
import ca.spottedleaf.starlight.common.util.SaveUtil;
import ca.spottedleaf.starlight.common.util.WorldUtil;
import ca.spottedleaf.starlight.common.world.ExtendedWorld;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.chunk.storage.ChunkSerializer;

public class LightingGameTests {
    private static final String TEMPLATE = "scalablelux_gametest:empty_48";

    @GameTest(template = TEMPLATE, timeoutTicks = 400)
    public void blockLightCrossesChunkBorderAndIsRemoved(GameTestHelper helper) {
        BlockPos origin = helper.absolutePos(new BlockPos(0, 6, 24));
        int borderX = ((origin.getX() + 16) & ~15) + 15;
        BlockPos source = new BlockPos(borderX, origin.getY(), origin.getZ());
        helper.getLevel().setBlockAndUpdate(source, Blocks.GLOWSTONE.defaultBlockState());
        helper.startSequence()
                .thenWaitUntil(() -> {
                    assertLight(helper, LightLayer.BLOCK, source, 15);
                    assertLight(helper, LightLayer.BLOCK, source.east(), 14);
                    assertLight(helper, LightLayer.BLOCK, source.east(14), 1);
                })
                .thenExecute(() -> helper.getLevel().setBlockAndUpdate(source, Blocks.AIR.defaultBlockState()))
                .thenWaitUntil(() -> {
                    assertLight(helper, LightLayer.BLOCK, source, 0);
                    assertLight(helper, LightLayer.BLOCK, source.east(), 0);
                    assertLight(helper, LightLayer.BLOCK, source.east(14), 0);
                })
                .thenSucceed();
    }

    @GameTest(template = TEMPLATE, timeoutTicks = 800)
    public void skylightTracksRoofOpeningAndClosing(GameTestHelper helper) {
        for (int x = 0; x < 48; x++) {
            for (int z = 0; z < 48; z++) {
                helper.setBlock(x, 8, z, Blocks.STONE);
            }
        }
        BlockPos sample = helper.absolutePos(new BlockPos(24, 6, 24));
        helper.startSequence()
                .thenWaitUntil(() -> assertLight(helper, LightLayer.SKY, sample, 0))
                .thenExecute(() -> helper.setBlock(24, 8, 24, Blocks.AIR))
                .thenWaitUntil(() -> assertLight(helper, LightLayer.SKY, sample, 15))
                .thenExecute(() -> helper.setBlock(24, 8, 24, Blocks.STONE))
                .thenWaitUntil(() -> assertLight(helper, LightLayer.SKY, sample, 0))
                .thenSucceed();
    }

    @GameTest(template = TEMPLATE, timeoutTicks = 400)
    public void lightDataSurvivesChunkSerialization(GameTestHelper helper) {
        BlockPos source = helper.absolutePos(new BlockPos(24, 6, 24));
        helper.getLevel().setBlockAndUpdate(source, Blocks.GLOWSTONE.defaultBlockState());
        helper.startSequence()
                .thenWaitUntil(() -> assertLight(helper, LightLayer.BLOCK, source.east(), 14))
                .thenExecute(() -> {
                    ServerLevel level = helper.getLevel();
                    LevelChunk original = level.getChunkAt(source);
                    CompoundTag saved = ChunkSerializer.write(level, original);
                    helper.assertTrue(saved.getInt("starlight.light_version") == SaveUtil.getLightVersion(), "Missing lighting version in chunk save");
                    helper.assertFalse(saved.getBoolean("isLightOn"), "Vanilla must recalculate light if this mod is removed");
                    ProtoChunk restored = ChunkSerializer.read(level, level.getPoiManager(), original.getPos(), saved);
                    helper.assertTrue(restored.isLightCorrect(), "Chunk was not restored as correctly lit");
                    assertSavedNibble(helper, original, restored, source.east(), false);
                    assertSavedNibble(helper, original, restored, source.above(10), true);
                })
                .thenSucceed();
    }

    @GameTest(template = TEMPLATE, timeoutTicks = 400)
    public void immediateChunkLookupsRespectBothCoordinates(GameTestHelper helper) {
        ServerLevel level = helper.getLevel();
        level.getChunk(7, -9);
        level.getChunk(-8, 5);
        helper.startSequence()
                .thenWaitUntil(() -> {
                    ExtendedWorld extended = (ExtendedWorld) level;
                    helper.assertTrue(extended.getAnyChunkImmediately(7, -9) != null, "Missing positive-X/negative-Z chunk");
                    helper.assertTrue(extended.getAnyChunkImmediately(7, -9).getPos().x == 7
                            && extended.getAnyChunkImmediately(7, -9).getPos().z == -9, "Wrong asymmetric chunk coordinates");
                    helper.assertTrue(extended.getChunkAtImmediately(-8, 5) != null, "Missing negative-X/positive-Z full chunk");
                    helper.assertTrue(extended.getChunkAtImmediately(-8, 5).getPos().x == -8
                            && extended.getChunkAtImmediately(-8, 5).getPos().z == 5, "Wrong full chunk coordinates");
                })
                .thenExecute(() -> System.out.println("[ScalableLux test] Lighting checks completed with parallelism=" + Config.PARALLELISM))
                .thenSucceed();
    }

    private static void assertLight(GameTestHelper helper, LightLayer layer, BlockPos absolute, int expected) {
        int actual = helper.getLevel().getBrightness(layer, absolute);
        helper.assertTrue(actual == expected, layer + " light at " + absolute + ": expected " + expected + ", got " + actual);
    }

    private static void assertSavedNibble(GameTestHelper helper, LevelChunk original, ProtoChunk restored, BlockPos pos, boolean sky) {
        int index = (pos.getY() >> 4) - WorldUtil.getMinLightSection(helper.getLevel());
        SWMRNibbleArray[] before = sky ? ((ExtendedChunk) original).getSkyNibbles() : ((ExtendedChunk) original).getBlockNibbles();
        SWMRNibbleArray[] after = sky ? ((ExtendedChunk) restored).getSkyNibbles() : ((ExtendedChunk) restored).getBlockNibbles();
        int expected = before[index].getVisible(pos.getX() & 15, pos.getY() & 15, pos.getZ() & 15);
        int actual = after[index].getVisible(pos.getX() & 15, pos.getY() & 15, pos.getZ() & 15);
        helper.assertTrue(expected == actual, (sky ? "Sky" : "Block") + " light changed during serialization: " + expected + " -> " + actual);
    }
}
