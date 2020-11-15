package io.github.gcaddon.planets.planettwo_s1.biome.gen;

import io.github.gcaddon.planets.planetone_s1.biome.PlanetOneS1Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomePlanetTwoS1Plains extends PlanetOneS1Biomes {

	public BiomePlanetTwoS1Plains(BiomeProperties properties) {
		super(properties);
        this.topBlock = Blocks.GRASS.getDefaultState(); //TODO change this
        this.fillerBlock = Blocks.STONE.getDefaultState(); //TODO change this
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void registerTypes(Biome b) {
            BiomeDictionary.addTypes(b, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);

	}
}
