package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import com.izofar.bygonenether.BygoneNetherMod;
import com.izofar.bygonenether.block.NetheriteBellBlock;
import com.izofar.bygonenether.block.VerticalSlabBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public abstract class ModBlocks {

	public static final DeferredRegister<Block> MODDED_BLOCKS = DeferredRegister.create(Registries.BLOCK, BygoneNetherMod.MODID);

	public static final DeferredHolder<Block, Block> COBBLED_BLACKSTONE = MODDED_BLOCKS.register("cobbled_blackstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));

	public static final DeferredHolder<Block, Block> WITHERED_BLACKSTONE = MODDED_BLOCKS.register("withered_blackstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(2.5F, 1200.0F).sound(SoundType.DEEPSLATE)));
	public static final DeferredHolder<Block, Block> WITHERED_BLACKSTONE_STAIRS = MODDED_BLOCKS.register("withered_blackstone_stairs", () -> new StairBlock(WITHERED_BLACKSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));
	public static final DeferredHolder<Block, Block> WITHERED_BLACKSTONE_SLAB = MODDED_BLOCKS.register("withered_blackstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));

	public static final DeferredHolder<Block, Block> CRACKED_WITHERED_BLACKSTONE = MODDED_BLOCKS.register("cracked_withered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));
	public static final DeferredHolder<Block, Block> CRACKED_WITHERED_BLACKSTONE_STAIRS = MODDED_BLOCKS.register("cracked_withered_blackstone_stairs", () -> new StairBlock(WITHERED_BLACKSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));
	public static final DeferredHolder<Block, Block> CRACKED_WITHERED_BLACKSTONE_SLAB = MODDED_BLOCKS.register("cracked_withered_blackstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));

	public static final DeferredHolder<Block, Block> CHISELED_WITHERED_BLACKSTONE = MODDED_BLOCKS.register("chiseled_withered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE.get())));

	public static final DeferredHolder<Block, Block> WITHERED_BASALT = MODDED_BLOCKS.register("withered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
	public static final DeferredHolder<Block, Block> WITHERED_COAL_BLOCK = MODDED_BLOCKS.register("withered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
	public static final DeferredHolder<Block, Block> WITHERED_QUARTZ_BLOCK = MODDED_BLOCKS.register("withered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));

	public static final DeferredHolder<Block, Block> WITHERED_DEBRIS = MODDED_BLOCKS.register("withered_debris", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)));
	public static final DeferredHolder<Block, Block> SOUL_STONE = MODDED_BLOCKS.register("soul_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	
	public static final DeferredHolder<Block, Block> WARPED_NETHER_BRICKS = MODDED_BLOCKS.register("warped_nether_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
	public static final DeferredHolder<Block, Block> CHISELED_WARPED_NETHER_BRICKS = MODDED_BLOCKS.register("chiseled_warped_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(WARPED_NETHER_BRICKS.get())));
	public static final DeferredHolder<Block, Block> WARPED_NETHER_BRICK_STAIRS = MODDED_BLOCKS.register("warped_nether_brick_stairs", () -> new StairBlock(WARPED_NETHER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(WARPED_NETHER_BRICKS.get())));
	public static final DeferredHolder<Block, Block> WARPED_NETHER_BRICK_SLAB = MODDED_BLOCKS.register("warped_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(WARPED_NETHER_BRICKS.get())));

	public static final DeferredHolder<Block, Block> NETHERITE_BELL = MODDED_BLOCKS.register("netherite_bell", () -> new NetheriteBellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(50.0F, 1200.0F).sound(SoundType.ANVIL).forceSolidOn().pushReaction(PushReaction.DESTROY)));

	public static DeferredHolder<Block, Block> WITHERED_BLACKSTONE_VERTICAL_SLAB;
	public static DeferredHolder<Block, Block> CRACKED_WITHERED_BLACKSTONE_VERTICAL_SLAB;
	public static DeferredHolder<Block, Block> WARPED_NETHER_BRICK_VERTICAL_SLAB;

	public static void register(IEventBus eventBus) {
		registerModCompatibilityBlocks();
		MODDED_BLOCKS.register(eventBus);
	}

	private static void registerModCompatibilityBlocks() {
		if (ModList.get().isLoaded("quark")) {
			WITHERED_BLACKSTONE_VERTICAL_SLAB = MODDED_BLOCKS.register("withered_blackstone_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(WITHERED_BLACKSTONE_SLAB.get())));
			CRACKED_WITHERED_BLACKSTONE_VERTICAL_SLAB = MODDED_BLOCKS.register("cracked_withered_blackstone_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(CRACKED_WITHERED_BLACKSTONE_SLAB.get())));
			WARPED_NETHER_BRICK_VERTICAL_SLAB = MODDED_BLOCKS.register("warped_nether_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(WARPED_NETHER_BRICK_SLAB.get())));
		}
	}

}
