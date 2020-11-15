package io.github.gcaddon.planets.planetOneS2;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.github.gcaddon.world.MapGenAddonCaveGen;
import io.github.gcaddon.world.MapGenCavern;
import io.github.gcaddon.world.chunk.ChunkProviderAddonSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderPlanetOneS2 extends ChunkProviderAddonSpace {
	
	private final BiomeDecoratorPlanetOneS2 biomeDecorator = new BiomeDecoratorPlanetOneS2();
    private final MapGenCavern cavernGenerator = new MapGenCavern();
    private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Sets.newHashSet(getStoneBlock(), getDirtBlock()));

	public ChunkProviderPlanetOneS2(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return biomeDecorator;
	}

	@Override
	protected Biome[] getBiomesForGeneration() {
		return new Biome[] { BiomeAdaptive.biomeDefault };
	}

	@Override
	protected int getSeaLevel() {
		return 86;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
        List<MapGenBaseMeta> generators = Lists.newArrayList();
        generators.add(this.caveGenerator);
        generators.add(this.cavernGenerator);
        return generators;
	}

	@Override
	protected Block getGrassBlock() {
		return Blocks.GRASS_PATH;
	}

	@Override
	protected Block getDirtBlock() {
		return Blocks.DIRT;
	}

	@Override
	protected Block getStoneBlock() {
		return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE).getBlock();
	}

	@Override
	public double getHeightModifier() {
		return 8;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 31;
	}

	@Override
	public double getMountainHeightModifier() {
		return 136;
	}

	@Override
	public double getValleyHeightModifier() {
		return 28;
	}

	@Override
	public int getCraterProbability() {
		return 3500;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
	}

	@Override
	public void onPopulate(int cX, int cZ) {
	}

}
