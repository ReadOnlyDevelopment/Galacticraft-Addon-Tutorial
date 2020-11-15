package io.github.gcaddon.planets.planetOneS2.biome;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomePlanetOneS2 extends BiomeGenBaseGC {
	public static final Biome planetOneS2 = new BiomeGenPlanetOneS2(new BiomeProperties("Planet Two S2")
			.setBaseHeight(2.1F).setHeightVariation(0.8F).setRainfall(0.0F).setRainDisabled());

	public static final Block BLOCK_TOP = Blocks.CONCRETE_POWDER;
	public static final Block BLOCK_FILL = Blocks.MAGMA;
	public static final Block BLOCK_LOWER = Blocks.GRAVEL;

	BiomePlanetOneS2(BiomeProperties properties) {
		super(properties, true);
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.fillerBlock = BLOCK_LOWER.getDefaultState();
		this.topBlock = BLOCK_TOP.getDefaultState();
		super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
}
