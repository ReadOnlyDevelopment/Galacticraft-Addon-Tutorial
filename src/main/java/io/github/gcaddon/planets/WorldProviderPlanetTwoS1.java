package io.github.gcaddon.planets;

import java.util.LinkedList;
import java.util.List;

import io.github.gcaddon.AddonConfig;
import io.github.gcaddon.init.AddonDimensions;
import io.github.gcaddon.init.AddonPlanets;
import io.github.gcaddon.planets.planettwo_s1.ChunkProviderPlanetTwoS1;
import io.github.gcaddon.planets.planettwo_s1.biome.BiomeProviderPlanetTwoS1;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderPlanetTwoS1 extends WorldProviderSpace implements ISolarLevel {

	@Override
	public Vector3 getFogColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public void updateWeather() {
		super.updateWeather();
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		return 24000L;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderPlanetTwoS1.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		BiomeAdaptive.setBodyMultiBiome(AddonPlanets.planetTwoS1);
		return BiomeProviderPlanetTwoS1.class;
	}

	@Override
	public int getAverageGroundLevel() {
		return 70;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}

	@Override
	public float getGravity() {
		return 0.045F;
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 0.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= AddonConfig.addon_planet_settings.planetTwoTier;
	}

	@Override
	public float getFallDamageModifier() {
		return 0.10F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 1.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return AddonPlanets.planetTwoS1;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return true;
	}

	@Override
	public float getThermalLevelModifier() {
		return 0.0F;
	}

	@Override
	public float getWindLevel() {
		return 0.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 2.0F;
	}

	@Override
	public boolean shouldDisablePrecipitation() {
		return true;
	}

	@Override
	public boolean shouldCorrodeArmor() {
		return false;
	}

	@Override
	public DimensionType getDimensionType() {
		return AddonDimensions.dimPlanetTwoS1;
	}

	@Override
	public boolean isDaytime() {
		final float a = this.world.getCelestialAngle(0F);
		return a < 0.42F || a > 0.58F;
	}

	@Override
	public int getDungeonSpacing() {
		return 0;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(MarsBlocks.marsBlock);
		return list;
	}
}
