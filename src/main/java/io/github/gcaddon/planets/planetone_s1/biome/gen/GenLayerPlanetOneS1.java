package io.github.gcaddon.planets.planetone_s1.biome.gen;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerPlanetOneS1 extends GenLayer {
	public GenLayerPlanetOneS1(long l) {
		super(l);
	}

	public static GenLayer[] createWorld(long l) {
		GenLayer biomes = new GenLayerPlanetOneS1Biomes(l);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);
		GenLayer genLayerVeronoiZoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(l);
		genLayerVeronoiZoom.initWorldGenSeed(l);

		return new GenLayer[] { biomes, genLayerVeronoiZoom };
	}
}