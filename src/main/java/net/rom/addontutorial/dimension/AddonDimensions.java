package net.rom.addontutorial.dimension;

import net.rom.addontutorial.AddonConfig;

import net.minecraft.world.DimensionType;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;

public class AddonDimensions {

	public static DimensionType dimPlanetOne;
	public static DimensionType dimPlanetTwo;
	public static DimensionType dimMoonPlanetOne;
	public static DimensionType dimSpaceStationPlanetTwo;

	public static void init() {

		dimPlanetOne = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPlanetOne);
		dimPlanetTwo = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPlanetTwo);
		dimMoonPlanetOne = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idMoon);
		dimSpaceStationPlanetTwo = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idSpaceStation);

	}
}
