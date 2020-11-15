package io.github.gcaddon;

import net.minecraftforge.common.config.Config;

/**
 * Configuration Options Layout is from More-Planets addon for its simplicity
 * since it uses the annotation base Config options from Forge
 * 
 * Even though its modified to fit this tutorial all credit for the design go to
 * him.
 * 
 * https://github.com/SteveKunG/MorePlanets/blob/1.12.2/src/main/java/stevekung/mods/moreplanets/core/config/ConfigManagerMP.java
 */
@Config(modid = ModInfo.ID)
public class AddonConfig {

	@Config.LangKey(value = "addon_general")
	@Config.Comment(value = "Base Addon Configuration: Version Checker, Debug, Mod Option. etc.")
	public static final General addon_general = new General();

	@Config.LangKey(value = "addon_dimension")
	@Config.Comment(value = "Planet or Moon Dimension IDs Configuration.")
	public static final Dimension addon_dimension = new Dimension();

	@Config.LangKey(value = "addon_dimension")
	@Config.Comment(value = "Solar System Configuration.")
	public static final SolarSystemSettings addon_solarsystem = new SolarSystemSettings();

	@Config.LangKey(value = "addon_planet_settings")
	@Config.Comment(value = "Planet Configuration.")
	public static final PlanetSettings addon_planet_settings = new PlanetSettings();

	@Config.LangKey(value = "addon_spacestation_settings")
	@Config.Comment(value = "SpaceStation Configuration.")
	public static final SpaceStationSettings addon_spacestation_settings = new SpaceStationSettings();

	@Config.LangKey(value = "addon_world_gen")
	@Config.Comment(value = "World Gen Configuration.")
	public static final WorldGenSettings addon_world_gen_settings = new WorldGenSettings();

	@Config.LangKey(value = "addon_misc")
	@Config.Comment(value = "Miscellaneous Configuration.")
	public static final Misc addon_other = new Misc();

	public static class General {
		@Config.Name(value = "Enable Debug Logging")
		public boolean enableDebug = false;

		@Config.Name(value = "Use Colored Star in the Sky")
		@Config.RequiresWorldRestart
		public boolean useColoredStar = true;

		@Config.Name(value = "Use Fancy Star in the Sky")
		@Config.RequiresWorldRestart
		public boolean useFancyStar = true;
	}

	public static class SolarSystemSettings {

	}

	public static class Dimension {

		@Config.Name(value = "PlanetOneS1 Dimension ID")
		public static final int p1s1Id = -650;

		@Config.Name(value = "PlanetTwoS1 Dimension ID")
		public static final int p2s1Id = -651;
		
		@Config.Name(value = "PlanetOneS2 Dimension ID")
		public static final int p1s2Id = -660;

		@Config.Name(value = "PlanetOne Moon Dimension ID")
		public int idMoon = -4402;

		@Config.Name(value = "PlanetTwo Space Station Dimension ID")
		public int idSpaceStation = -4450;

		@Config.Name(value = "PlanetTwo Space Station Dimension Static ID")
		public int StaticidSpaceStation = -4451;

	}

	public static class PlanetSettings {

		@Config.Name(value = "PlanetOne Tier")
		@Config.RequiresMcRestart
		public int planetOneTier = -1;

		@Config.Name(value = "PlanetTwo Tier")
		@Config.RequiresMcRestart
		public int planetTwoTier = 3;

	}

	public static class WorldGenSettings {

		@Config.Name(value = "Disable Vanilla Ore Gen on all planets")
		@Config.Comment(value = "Disables all non-modded ores on worlds: Lapis, Coal, Iron, etc")
		public boolean disableVanillaOreGenAllPlanets = false;

		@Config.Name(value = "Disable Vanilla Ore on PlanetOne")
		public boolean disableVanillaPlanetOneOre = false;

		@Config.Name(value = "Disable Vanilla Ore on PlanetTwo")
		public boolean disableVanillaPlanetTwoOre = false;

		@Config.Name(value = "Disable Vanilla Ore on PlanetTwo Moon")
		public boolean disableVanillaplTwoMoonOre = false;
	}

	public static class SpaceStationSettings {

		@Config.Name(value = "PlanetTwo Space Station Dimension Static ID")
		public int staticIdSpaceStation = -4451;

	}

	public static class Misc {

		@Config.Name(value = "Base Schematic ID")
		public int idBaseSchematic = 750;

		@Config.Name(value = "Base Schematic GUI ID")
		public int idBaseSchematicGui = 780;

	}

}
