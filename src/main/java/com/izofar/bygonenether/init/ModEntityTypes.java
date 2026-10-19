package com.izofar.bygonenether.init;
import net.minecraft.core.registries.Registries;

import com.google.common.collect.ImmutableList;
import com.izofar.bygonenether.BygoneNetherMod;
import com.izofar.bygonenether.block.entity.NetheriteBellBlockEntity;
import com.izofar.bygonenether.entity.*;
import com.izofar.bygonenether.mixin.PiglinBruteAccessor;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public abstract class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> MOD_ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, BygoneNetherMod.MODID);
	public static final DeferredRegister<BlockEntityType<?>> MOD_BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BygoneNetherMod.MODID);

	public static final DeferredHolder<EntityType<?>, EntityType<Wex>> WEX = MOD_ENTITY_TYPES.register("wex", () -> EntityType.Builder.of(Wex::new, MobCategory.MONSTER).fireImmune().sized(0.4F, 0.8F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "wex").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<WarpedEnderMan>> WARPED_ENDERMAN = MOD_ENTITY_TYPES.register("warped_enderman", () -> EntityType.Builder.of(WarpedEnderMan::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 2.9F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "warped_enderman").toString()));
	
	public static final DeferredHolder<EntityType<?>, EntityType<PiglinPrisoner>> PIGLIN_PRISONER = MOD_ENTITY_TYPES.register("piglin_prisoner", () -> EntityType.Builder.of(PiglinPrisoner::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "piglin_prisoner").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<PiglinHunter>> PIGLIN_HUNTER = MOD_ENTITY_TYPES.register("piglin_hunter", () -> EntityType.Builder.of(PiglinHunter::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "piglin_hunter").toString()));

	public static final DeferredHolder<EntityType<?>, EntityType<Wraither>> WRAITHER = MOD_ENTITY_TYPES.register("wraither", () -> EntityType.Builder.of(Wraither::new, MobCategory.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(0.7F, 2.4F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "wraither").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<WitherSkeletonKnight>> WITHER_SKELETON_KNIGHT = MOD_ENTITY_TYPES.register("wither_skeleton_knight", () -> EntityType.Builder.of(WitherSkeletonKnight::new, MobCategory.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(0.7F, 2.4F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "wither_skeleton_knight").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<Corpor>> CORPOR = MOD_ENTITY_TYPES.register("corpor", () -> EntityType.Builder.of(Corpor::new, MobCategory.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(0.7F, 2.4F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "corpor").toString()));

	public static final DeferredHolder<EntityType<?>, EntityType<WitherSkeletonHorse>> WITHER_SKELETON_HORSE = MOD_ENTITY_TYPES.register("wither_skeleton_horse", () -> EntityType.Builder.of(WitherSkeletonHorse::new, MobCategory.CREATURE).fireImmune().sized(1.3964844F, 1.6F).clientTrackingRange(10).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "wither_skeleton_horse").toString()));

	public static final DeferredHolder<EntityType<?>, EntityType<ThrownWarpedEnderpearl>> WARPED_ENDER_PEARL = MOD_ENTITY_TYPES.register("warped_ender_pearl", () -> EntityType.Builder.<ThrownWarpedEnderpearl>of(ThrownWarpedEnderpearl::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "warped_ender_pearl").toString()));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NetheriteBellBlockEntity>> NETHERITE_BELL = MOD_BLOCK_ENTITY_TYPES.register("netherite_bell", () -> BlockEntityType.Builder.of(NetheriteBellBlockEntity::new, ModBlocks.NETHERITE_BELL.get()).build(Util.fetchChoiceType(References.BLOCK_ENTITY, ResourceLocation.fromNamespaceAndPath(BygoneNetherMod.MODID, "netherite_bell").toString())));

	public static void register(IEventBus eventBus) {
		MOD_ENTITY_TYPES.register(eventBus);
		MOD_BLOCK_ENTITY_TYPES.register(eventBus);
	}

	public static void modifyPiglinMemoryAndSensors() {
		PiglinBruteAccessor.bygonenether$setSensorTypes(ImmutableList.of(
				SensorType.NEAREST_LIVING_ENTITIES,
				SensorType.NEAREST_PLAYERS,
				SensorType.NEAREST_ITEMS,
				SensorType.HURT_BY,
				ModSensorTypes.PIGLIN_BRUTE_SPECIFIC_SENSOR.get()
		));

		PiglinBruteAccessor.bygonenether$setMemoryTypes(ImmutableList.of(
				MemoryModuleType.LOOK_TARGET,
				MemoryModuleType.DOORS_TO_CLOSE,
				MemoryModuleType.NEAREST_LIVING_ENTITIES,
				MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
				MemoryModuleType.NEAREST_VISIBLE_PLAYER,
				MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER,
				MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
				MemoryModuleType.NEARBY_ADULT_PIGLINS,
				MemoryModuleType.HURT_BY,
				MemoryModuleType.HURT_BY_ENTITY,
				MemoryModuleType.WALK_TARGET,
				MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
				MemoryModuleType.ATTACK_TARGET,
				MemoryModuleType.ATTACK_COOLING_DOWN,
				MemoryModuleType.INTERACTION_TARGET,
				MemoryModuleType.PATH,
				MemoryModuleType.ANGRY_AT,
				MemoryModuleType.NEAREST_VISIBLE_NEMESIS,
				MemoryModuleType.HOME,
				MemoryModuleType.UNIVERSAL_ANGER,
				ModMemoryModuleTypes.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GILD.get()
		));
	}
}
