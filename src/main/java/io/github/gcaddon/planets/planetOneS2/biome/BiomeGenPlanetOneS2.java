package io.github.gcaddon.planets.planetOneS2.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenPlanetOneS2 extends BiomePlanetOneS2
{
    public BiomeGenPlanetOneS2(BiomeProperties properties)
    {
        super(properties);
    }
    
    @Override
    public void registerTypes(Biome b)
    {
        BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
    }
}
