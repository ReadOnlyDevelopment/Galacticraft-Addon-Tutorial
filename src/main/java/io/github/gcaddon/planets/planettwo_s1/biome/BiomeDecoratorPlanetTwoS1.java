package io.github.gcaddon.planets.planettwo_s1.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorPlanetTwoS1 extends BiomeDecoratorSpace {

    private World currentWorld;


    public BiomeDecoratorPlanetTwoS1() {
    }

    @Override
    protected void setCurrentWorld(World world) {
        this.currentWorld = world;
    }

    @Override
    protected World getCurrentWorld() {
        return this.currentWorld;
    }

    @Override
    protected void decorate() {
    }
}
