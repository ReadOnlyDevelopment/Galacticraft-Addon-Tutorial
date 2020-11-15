package io.github.gcaddon.planets.planetOneS2;

import io.github.gcaddon.planets.planetOneS2.biome.BiomePlanetOneS2;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderPlanetOneS2 extends BiomeProviderSpace {
	
	@Override
	public Biome getBiome() {
		return BiomePlanetOneS2.planetOneS2;
	}

}
