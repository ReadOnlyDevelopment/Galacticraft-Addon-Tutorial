package net.rom.addontutorial.planets.planetone.biome;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.rom.addontutorial.util.world.chunk.ChunkProviderBase;
import net.rom.addontutorial.util.world.chunk.MapGenAddonCaveGen;
import net.rom.addontutorial.util.world.chunk.MapGenAddonRavinGen;
import net.rom.addontutorial.util.world.chunk.MapGenBaseMeta;

public class ChunkProviderPlanetOne extends ChunkProviderBase {

    private final BiomeDecoratorPlanetOne decorator = new BiomeDecoratorPlanetOne();
    private final MapGenAddonRavinGen ravineGenerator = new MapGenAddonRavinGen();
    private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.LAVA.getDefaultState(),
            Sets.newHashSet(Blocks.HARDENED_CLAY, Blocks.BLACK_GLAZED_TERRACOTTA));

    public ChunkProviderPlanetOne(World par1World, long seed, boolean mapFeaturesEnabled) {
        super(par1World, seed, mapFeaturesEnabled);
        this.stoneBlock = Blocks.STONE.getDefaultState();
        this.waterBlock =Blocks.WATER.getDefaultState();
    }

    @Override
    protected List<MapGenBaseMeta> getWorldGenerators() {
        List<MapGenBaseMeta> generators = Lists.newArrayList();
        generators.add(this.caveGenerator);
        return generators;
    }

    @Override
    public int getCraterProbability() {
        return 2000;
    }

    @Override
    public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
        this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
    }

    @Override
    public void onPopulate(int cX, int cZ) {

    }

    @Override
    public void recreateStructures(Chunk chunk, int x, int z) {
    }

    @Override
    protected void decoratePlanet(World world, Random rand, int x, int z) {
        this.decorator.decorate(this.worldObj, rand, x, z);
    }
}
