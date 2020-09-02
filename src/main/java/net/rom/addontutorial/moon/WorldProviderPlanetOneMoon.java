package net.rom.addontutorial.moon;

import java.util.LinkedList;
import java.util.List;

import net.rom.addontutorial.AddonConfig;
import net.rom.addontutorial.dimension.AddonDimensions;
import net.rom.addontutorial.planets.AddonCelestialBodies;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;

import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;

public class WorldProviderPlanetOneMoon extends WorldProviderSpace {

	@Override
	public float getGravity() {
		return 0.015F;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 0.5D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= AddonConfig.addon_planet_settings.planetOneTier;
	}

	@Override
	public float getFallDamageModifier() {
		return 0;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return AddonCelestialBodies.planetOneMoon;
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

	@Override
	public Vector3 getFogColor() {
		return null;
	}

	@Override
	public Vector3 getSkyColor() {
		return null;
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		return 64000L;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return null;
	}

	@Override
	public DimensionType getDimensionType() {
		return AddonDimensions.dimMoonPlanetOne;
	}

}
