package net.rom.addontutorial.planets;

import net.rom.addontutorial.AddonConfig;
import net.rom.addontutorial.AddonConfig.Dimension;
import net.rom.addontutorial.AddonConfig.PlanetSettings;
import net.rom.addontutorial.moon.WorldProviderPlanetOneMoon;
import net.rom.addontutorial.planets.planetone.WorldProviderPlanetOne;
import net.rom.addontutorial.planets.planettwo.WorldProviderPlanetTwo;
import net.rom.addontutorial.spacestation.WorldProviderPlanetTwoStation;
import net.rom.addontutorial.util.GCRegister;

import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;

import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeSpaceStation;

import micdoodle8.mods.galacticraft.planets.mars.dimension.TeleportTypeMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.BiomeMars;
import micdoodle8.mods.galacticraft.planets.venus.world.gen.BiomeVenus;;

/**
 * Class AddonCelestialBodies
 * 
 * This is where we will store the public static Fields for all of our
 * CelestalObjects: - SolarSystems - Planets - Moons - SpaceStations (aka:
 * Satellites)
 * 
 * Each field can be called from other classes directly
 * 
 * The class uses a custom builder for our Celestial Objects, each builder
 * method is documented with what the paremeters are
 * 
 * @see net.rom.addontutorial.util.GCRegister
 * 
 */
public class AddonCelestialBodies {

	/**
	 * custom solar system
	 * 
	 * @implNote remember this does not set the name of the solar system
	 */
	public static SolarSystem customSystem;

	/**
	 * Planet PlanetOne
	 * 
	 * @implNote remember this does not set the name of the planet
	 */
	public static Planet planetOne;

	/**
	 * Planet PlanetTwo
	 * 
	 * @implNote remember this does not set the name of the planet
	 */
	public static Planet planetTwo;

	/**
	 * moon for PlanetOne
	 * 
	 * @implNote remember this does not set the name of the moon
	 */
	public static Moon planetOneMoon;

	/**
	 * space-station for PlanetTwo
	 *
	 */
	public static Satellite planetTwoSpaceStation;

	/**
	 * These are used to keep the building method parameters shorter when calling
	 * the config options value
	 * 
	 */
	static Dimension dim = AddonConfig.addon_dimension;
	static PlanetSettings pl = AddonConfig.addon_planet_settings;

	/**
	 * this is our initialization method that will be called in the mods main class
	 * to build our celestial bodies
	 * 
	 * the order these are in are an important part of this compiling correctly
	 */
	public static void init() {
		// we need to register a custom solar system first
		registerSolarSystems_1st_Task();
		// so our custom planets can be placed into that system
		registerPlanets_2nd_Task();
		// whatever planet the moons orbit need to be build first
		registerMoon_3rd_Task();
		// same goes for space station
		registerSpaceStation_4th_Task();

		setAtomosphereInfo();
		registerAll();
		setTeleportsAndGuis();
	}

	/**
	 * Register solar systems.
	 * 
	 * These must be created first so we can add our planets to the new system.
	 * If these are not created first then we will get a NullPointExemption
	 * crash when loading gets to the planets since it cannot find a system
	 * that has not been created yet.
	 * 
	 */
	private static void registerSolarSystems_1st_Task() {

		// Build our custom solar system, we set "milky_way" so our solar system shows
		// up on the normal celestial map screen

		// its also important to always have the 3rd Vector3 float set to 0.0F, so the
		// solar system zoom actually zooms in on the system
		customSystem = GCRegister.buildSolarSystem("custom_system", "milky_way", new Vector3(2.0F, -1.7f, 0.0f), "custom_star");
	}

	/**
	 * Register planets.
	 */
	private static void registerPlanets_2nd_Task() {

		// to keep the builder parameters shorter i chose to set the ring color outside
		// of the builder

		// build planetOne
		planetOne = GCRegister.buildPlanet(customSystem, "planet_one", WorldProviderPlanetOne.class, 1.0F, dim.idPlanetOne, pl.planetOneTier, 4.0F, 2.0f, 1.5F);
		planetOne.setRingColorRGB(0.9F, 0.1F, 0.6F);
		GCRegister.setBiomes(planetOne, BiomeMars.marsFlat);
		// buildPlanetTwo
		planetTwo = GCRegister.buildPlanet(customSystem, "planet_two", WorldProviderPlanetTwo.class, 1.0F, dim.idPlanetTwo, pl.planetTwoTier, 1.8F, 3.7f, 4.5F);
		planetOne.setRingColorRGB(0.9F, 0.1F, 0.6F);
		GCRegister.setBiomes(planetTwo, BiomeVenus.venusValley, BiomeVenus.venusMountain, BiomeVenus.venusFlat);

	}

	/**
	 * Register moon.
	 */
	private static void registerMoon_3rd_Task() {

		planetOneMoon = GCRegister.buildMoon(planetOne, "planet_one_moon", WorldProviderPlanetOneMoon.class, dim.idMoon, pl.planetOneTier, 4.55F, 1.0F, 0.5F, 0.95F);
		planetOne.setRingColorRGB(0.1F, 0.1F, 0.6F);
	}

	/**
	 * Register space station.
	 */
	private static void registerSpaceStation_4th_Task() {

		planetTwoSpaceStation = GCRegister.buildSpaceStation(planetTwo, WorldProviderPlanetTwoStation.class, dim.idSpaceStation, dim.StaticidSpaceStation, 0.8411561F, 1.0F, 5.5F, 2.0F, false, null);
		planetOne.setRingColorRGB(0.1F, 0.1F, 0.6F);
	}

	private static void setAtomosphereInfo() {
		
		// Lets set the gasses that will be in our planets atmospheres
		EnumAtmosphericGas[] planetOneGases = { EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON };
		EnumAtmosphericGas[] planetTwoGases = { EnumAtmosphericGas.METHANE, EnumAtmosphericGas.WATER };
		
		// Now lets add the above arrays to the planets
		GCRegister.setAtmosphereComponentList(planetOne, planetOneGases);
		GCRegister.setAtmosphereComponentList(planetTwo, planetTwoGases);

		GCRegister.setAtmosphere(planetOne, false, false, true, 2.0F, 5.0F, 3.0F);
		GCRegister.setAtmosphere(planetTwo, false, false, false, 0.0F, 1.0F, 15.0F);
	}

	private static void setTeleportsAndGuis() {
		// registerTeleportType is pretty important. If we don't set one for our planets then 
		// you will not be able to travel to said planet.
		
		GCRegister.registerTeleportType(WorldProviderPlanetOne.class, new TeleportTypeMars());
		GCRegister.registerTeleportType(WorldProviderPlanetTwo.class, new TeleportTypeMoon());
		GCRegister.registerTeleportType(WorldProviderPlanetTwoStation.class, new TeleportTypeSpaceStation());
		GCRegister.registerTeleportType(WorldProviderPlanetOneMoon.class, new TeleportTypeMars());
	}

	private static void registerAll() {
		// Now we register each Celestial Body after we have created and defined them
		
		GCRegister.registerSolarSystem(customSystem);
		GCRegister.registerPlanet(planetOne);
		GCRegister.registerPlanet(planetTwo);
		GCRegister.registerMoon(planetOneMoon);
		GCRegister.registerSpaceStation(planetTwoSpaceStation);

	}

}
