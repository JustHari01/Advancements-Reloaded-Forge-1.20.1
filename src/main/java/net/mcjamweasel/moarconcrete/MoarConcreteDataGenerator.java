package net.mcjamweasel.moarconcrete;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mcjamweasel.moarconcrete.datagen.ModBlockTagProvider;
import net.mcjamweasel.moarconcrete.datagen.ModLootTableProvider;
import net.mcjamweasel.moarconcrete.datagen.ModModelProvider;
import net.mcjamweasel.moarconcrete.datagen.ModRecipeProvider;

public class MoarConcreteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
