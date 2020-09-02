package net.rom.addontutorial.util;

import net.minecraft.world.biome.Biome;

public abstract class BiomeBase extends Biome {

	public BiomeBase(BiomeProperties properties) {
		super(properties);
	}

	public void registerTypes() {
	}

}
