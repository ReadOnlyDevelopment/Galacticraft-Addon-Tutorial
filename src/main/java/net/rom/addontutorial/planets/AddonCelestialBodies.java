package net.rom.addontutorial.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeSpaceStation;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import micdoodle8.mods.galacticraft.planets.mars.dimension.TeleportTypeMars;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.rom.addontutorial.AddonConfig;
import net.rom.addontutorial.AddonConfig.Dimension;
import net.rom.addontutorial.AddonConfig.PlanetSettings;
import net.rom.addontutorial.Const;
import net.rom.addontutorial.moon.WorldProviderPlanetOneMoon;
import net.rom.addontutorial.planets.planetone.WorldProviderPlanetOne;
import net.rom.addontutorial.planets.planetone.biome.PlanetOneBiomes;
import net.rom.addontutorial.planets.planettwo.WorldProviderPlanetTwo;
import net.rom.addontutorial.spacestation.WorldProviderPlanetTwoStation;

;

/**
 * Class AddonCelestialBodies
 * 
 * This is where we will store the public static Fields for all of our
 * CelestalObjects: - SolarSystems - Planets - Moons - SpaceStations (aka:
 * Satellites)
 * 
 * Each field can be called from other classes directly
 * 
 */
public class AddonCelestialBodies {

	// Systems
	public static SolarSystem customSystem;

	// Planets
	public static Planet planetOne;
	public static Planet planetTwo;

	// Moons
	public static Moon planetOneMoon;

	// SpaceStations
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

		registerAll();
		setTeleportsAndGuis();
	}

	/**
	 * Register solar systems.
	 * 
	 * These must be created first so we can add our planets to the new system. If
	 * these are not created first then we will get a NullPointExemption crash when
	 * loading gets to the planets since it cannot find a system that has not been
	 * created yet.
	 * 
	 */
	private static void registerSolarSystems_1st_Task() {

		// Build our custom solar system, we set "milky_way" so our solar system shows
		// up on the normal celestial map screen

		// its also important to always have the 3rd Vector3 float set to 0.0F, so the
		// solar system zoom actually zooms in on the system
		customSystem = new SolarSystem("custom_system", "milky_way").setMapPosition(new Vector3(1.0F, -1.4f, 0.0f));
		Star starSol = (Star) new Star("custom_star").setParentSolarSystem(customSystem).setTierRequired(-1);
		starSol.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		customSystem.setMainStar(starSol);
	}

	/**
	 * Register planets.
	 */
	private static void registerPlanets_2nd_Task() {

		// build planetOne
		planetOne = new Planet("planet_one").setParentSolarSystem(customSystem);
		planetOne.setTierRequired(3);
		planetOne.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetOne.setPhaseShift(1.45F);
		planetOne.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F));
		planetOne.setRelativeOrbitTime(1.0F);
		planetOne.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetOne.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/planetOne.png"));
		planetOne.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		planetOne.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetOne.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		planetOne.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(planetOne);

		// build planetTwo
		planetTwo = new Planet("planet_one").setParentSolarSystem(customSystem);
		planetTwo.setTierRequired(3);
		planetTwo.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetTwo.setPhaseShift(1.45F);
		planetTwo.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F));
		planetTwo.setRelativeOrbitTime(1.0F);
		planetTwo.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetTwo.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/planetTwo.png"));
		planetTwo.setDimensionInfo(dim.idPlanetTwo, WorldProviderPlanetTwo.class);
		planetTwo.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetTwo.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		setMobInfo(planetTwo);

	}

	/**
	 * Register moon.
	 */
	private static void registerMoon_3rd_Task() {

		planetOneMoon = new Moon("planet_one_moon").setParentPlanet(planetOne);
		planetOneMoon.setPhaseShift(2.436F);
		planetOneMoon.setRingColorRGB(0.1F, 0.1F, 0.6F);
		planetOneMoon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
		planetOneMoon.setRelativeOrbitTime(75.0F);
		planetOneMoon.setTierRequired(7);
		planetOneMoon.setRelativeSize(0.3867F);
		planetOneMoon.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		planetOneMoon.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX , "textures/gui/celestialbodies/planetOneMoon.png"));
		planetOneMoon.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		planetOneMoon.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		planetOneMoon.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		//TRITON.setBiomeInfo(TritonBiomes.triton, TritonBiomes.tritonIceLands, TritonBiomes.tritonIceSea);
		
	}

	/**
	 * Register space station.
	 */
	private static void registerSpaceStation_4th_Task() {

		planetTwoSpaceStation = new Satellite("space_station.eris").setParentBody(planetTwo);
		planetTwoSpaceStation.setRelativeSize(0.2667F);
		planetTwoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
		planetTwoSpaceStation.setRelativeOrbitTime(20.0F);
		planetTwoSpaceStation.setTierRequired(planetTwo.getTierRequirement());
		planetTwoSpaceStation.setDimensionInfo(dim.idSpaceStation, dim.StaticidSpaceStation, WorldProviderPlanetTwoStation.class);
		planetTwoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
		planetTwoSpaceStation.addChecklistKeys("equip_oxygen_suit", "equip_parachute");
		planetTwoSpaceStation.setBiomeInfo(BiomeOrbit.space);
	}

	private static void setMobInfo(CelestialBody body) {
		body.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
	}

	private static void setTeleportsAndGuis() {
		// registerTeleportType is pretty important. If we don't set one for our planets
		// then
		// you will not be able to travel to said planet.

		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOne.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwo.class, new TeleportTypeMoon());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwoStation.class, new TeleportTypeSpaceStation());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOneMoon.class, new TeleportTypeMars());
	}

	private static void registerAll() {
		// Now we register each Celestial Body after we have created and defined them

		GalaxyRegistry.registerSolarSystem(customSystem);
		GalaxyRegistry.registerSolarSystem(customSystem);
		GalaxyRegistry.registerPlanet(planetOne);
		GalaxyRegistry.registerPlanet(planetTwo);
		GalaxyRegistry.registerMoon(planetOneMoon);
		GalaxyRegistry.registerSatellite(planetTwoSpaceStation);

	}

}
