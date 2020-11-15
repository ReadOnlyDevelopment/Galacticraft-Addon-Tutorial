package io.github.gcaddon.planets.planetone_s1.biome.gen;

import java.util.List;

import com.google.common.collect.Lists;

import io.github.gcaddon.planets.planetone_s1.biome.PlanetOneS1Biomes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomePlanetOneS1Sea extends PlanetOneS1Biomes {

	public BiomePlanetOneS1Sea(BiomeProperties properties) {
		super(properties);
        this.topBlock = Blocks.MYCELIUM.getDefaultState(); //TODO change this
        this.fillerBlock = Blocks.OBSIDIAN.getDefaultState(); //TODO change this
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}

	@Override
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<Biome.SpawnListEntry> newArrayList();
	}

	@Override
	public void registerTypes(Biome b) {
            BiomeDictionary.addTypes(b, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OCEAN);
	}
}
