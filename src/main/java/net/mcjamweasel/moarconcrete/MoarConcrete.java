package net.mcjamweasel.moarconcrete;

import net.fabricmc.api.ModInitializer;

import net.mcjamweasel.moarconcrete.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoarConcrete implements ModInitializer {
	public static final String MOD_ID = "moarconcrete";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
	}
}