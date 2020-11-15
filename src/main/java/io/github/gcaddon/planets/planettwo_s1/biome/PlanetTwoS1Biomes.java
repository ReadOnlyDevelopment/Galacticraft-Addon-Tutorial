package io.github.gcaddon.planets.planettwo_s1.biome;

import java.util.Random;

import io.github.gcaddon.planets.planettwo_s1.biome.gen.BiomePlanetTwoS1Marsh;
import io.github.gcaddon.planets.planettwo_s1.biome.gen.BiomePlanetTwoS1Mountains;
import io.github.gcaddon.planets.planettwo_s1.biome.gen.BiomePlanetTwoS1Plains;
import io.github.gcaddon.planets.planettwo_s1.biome.gen.BiomePlanetTwoS1Sea;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class PlanetTwoS1Biomes extends BiomeGenBaseGC {

	public static final Biome planetTwoS1_Plains = new BiomePlanetTwoS1Plains(new BiomeProperties("Planet OneS1 Plains").setBaseHeight(0.145F).setHeightVariation(0.5F).setRainfall(0.0F).setRainDisabled());
	public static final Biome planetTwoS1_Mountains = new BiomePlanetTwoS1Mountains(new BiomeProperties("Planet OneS1 Mountains").setBaseHeight(0.9F).setHeightVariation(0.999F).setRainfall(0.0F).setRainDisabled());
	public static final Biome planetTwoS1_Marsh = new BiomePlanetTwoS1Marsh(new BiomeProperties("Planet OneS1 Marsh").setBaseHeight(0.045F).setHeightVariation(0.2F).setRainfall(0.0F).setRainDisabled());
	public static final Biome planetTwos1_sea = new BiomePlanetTwoS1Sea(new BiomeProperties("Planet OneS1 Sea").setBaseHeight(-1.1F).setHeightVariation(0.2F).setRainfall(0.0F).setRainDisabled());

	public static final Biome[] biomes = {planetTwoS1_Plains, planetTwoS1_Mountains, planetTwoS1_Marsh, planetTwos1_sea};
	
	protected PlanetTwoS1Biomes(BiomeProperties properties) {
		super(properties, true);
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		generateBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	public final void generateBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 5.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunk.setBlockState(i1, j1, l, Blocks.BEDROCK.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == Blocks.GRASS.getDefaultState()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
						} else if (j1 >= 63 - 4 && j1 <= 63 + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}

						if (j1 < 63 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
							if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
								iblockstate = Blocks.ICE.getDefaultState();
							} else {
								iblockstate = Blocks.WATER.getDefaultState();
							}
						}

						j = k;

						if (j1 >= 63 - 1) {
							chunk.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < 63 - 7 - k) {
							iblockstate = null;
							iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
							chunk.setBlockState(i1, j1, l, Blocks.GRAVEL.getDefaultState());
						} else {
							chunk.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						--j;
						chunk.setBlockState(i1, j1, l, iblockstate1);
					}
				}
			}
		}
	}
}
