package io.github.gcaddon.planets.planetone_s1;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.github.gcaddon.planets.planetone_s1.biome.BiomeDecoratorPlanetOneS1;
import io.github.gcaddon.world.MapGenAddonCaveGen;
import io.github.gcaddon.world.MapGenAddonRavinGen;
import io.github.gcaddon.world.chunk.ChunkProviderBase;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderPlanetOneS1 extends ChunkProviderBase {

    private final BiomeDecoratorPlanetOneS1 decorator = new BiomeDecoratorPlanetOneS1();
    private final MapGenAddonRavinGen ravineGenerator = new MapGenAddonRavinGen();
    private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.LAVA.getDefaultState(),
            Sets.newHashSet(Blocks.HARDENED_CLAY, Blocks.BLACK_GLAZED_TERRACOTTA));

    public ChunkProviderPlanetOneS1(World par1World, long seed, boolean mapFeaturesEnabled) {
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
