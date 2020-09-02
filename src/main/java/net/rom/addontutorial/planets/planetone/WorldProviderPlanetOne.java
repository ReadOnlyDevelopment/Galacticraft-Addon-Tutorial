package net.rom.addontutorial.planets.planetone;

import java.util.LinkedList;
import java.util.List;

import net.rom.addontutorial.AddonConfig;
import net.rom.addontutorial.dimension.AddonDimensions;
import net.rom.addontutorial.planets.AddonCelestialBodies;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;

import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.world.gen.BiomeProviderVenus;
import micdoodle8.mods.galacticraft.planets.venus.world.gen.ChunkProviderVenus;

public class WorldProviderPlanetOne extends WorldProviderSpace implements ISolarLevel {

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
		return 500L;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderVenus.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderVenus.class;
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
		return 2.0F;
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 600.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 0.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= AddonConfig.addon_planet_settings.planetOneTier;
	}

	@Override
	public float getFallDamageModifier() {
		return 0.0F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 15.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return AddonCelestialBodies.planetOne;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		return 0.0F;
	}

	@Override
	public float getWindLevel() {
		return 16.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 50.0D;
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
		return AddonDimensions.dimPlanetOne;
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
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return super.calculateCelestialAngle(p_76563_1_, p_76563_3_);
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(VenusBlocks.venusBlock);
		return list;
	}
}
