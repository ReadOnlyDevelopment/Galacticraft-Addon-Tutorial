package io.github.gcaddon.init;

import static io.github.gcaddon.AddonConfig.Dimension.*;

import io.github.gcaddon.ModInfo;
import io.github.gcaddon.planets.WorldProviderPlanetOneS1;
import io.github.gcaddon.planets.WorldProviderPlanetOneS2;
import io.github.gcaddon.planets.WorldProviderPlanetTwoS1;
import io.github.gcaddon.planets.planetOneS2.biome.BiomePlanetOneS2;
import io.github.gcaddon.planets.planetone_s1.biome.PlanetOneS1Biomes;
import io.github.gcaddon.planets.planettwo_s1.biome.PlanetTwoS1Biomes;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.planets.mars.dimension.TeleportTypeMars;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.SpawnListEntry;

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
public class AddonPlanets {

	// Planets for addonSystem1
	public static Planet planetOneS1;
	public static Planet planetTwoS1;
	
	// Planets for addonSystem2
	public static Planet planetOneS2;

	/**
	 * this is our initialization method that will be called in the mods main class
	 * to build our celestial bodies
	 * 
	 * the order these are in are an important part of this compiling correctly
	 */
	public AddonPlanets() {
		this.createPlanets();
		this.registerPlanetTeleportTypes();
		this.registerPlanets();
	}

	private void createPlanets() {
		
		// Solar System 1 Planets
		
		planetOneS1 = new Planet("planet_one_s1").setParentSolarSystem(AddonSolarSystems.addonSystem1);
		planetOneS1.setTierRequired(3);
		planetOneS1.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetOneS1.setPhaseShift((float) (Math.PI * 0.5F));
		planetOneS1.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F));
		planetOneS1.setRelativeOrbitTime(1.0F);
		planetOneS1.setBodyIcon(new ResourceLocation(ModInfo.ID, "textures/gui/celestialbodies/planetOne.png"));
		planetOneS1.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetOneS1.setDimensionInfo(p1s1Id, WorldProviderPlanetOneS1.class);
		planetOneS1.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetOneS1.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		planetOneS1.setBiomeInfo(PlanetOneS1Biomes.biomes);
		
		planetTwoS1 = new Planet("planet_two_s1").setParentSolarSystem(AddonSolarSystems.addonSystem1);
		planetTwoS1.setTierRequired(3);
		planetTwoS1.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetTwoS1.setPhaseShift((float) (Math.PI / 5.8748F));
		planetTwoS1.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.9F, 1.9F));
		planetTwoS1.setRelativeOrbitTime(1.6F);
		planetTwoS1.setBodyIcon(new ResourceLocation(ModInfo.ID, "textures/gui/celestialbodies/planetTwo.png"));
		planetTwoS1.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetTwoS1.setDimensionInfo(p2s1Id, WorldProviderPlanetTwoS1.class);
		planetTwoS1.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetTwoS1.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		planetTwoS1.setBiomeInfo(PlanetTwoS1Biomes.biomes);
		
		// Solar System 2 Planets
		
		planetOneS2 = new Planet("planet_one_s2").setParentSolarSystem(AddonSolarSystems.addonSystem2);
		planetOneS2.setTierRequired(3);
		planetOneS2.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetOneS2.setPhaseShift((float) (Math.PI * 1.45F));
		planetOneS2.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.7F, 0.7F));
		planetOneS2.setRelativeOrbitTime(1.0F);
		planetOneS2.setBodyIcon(new ResourceLocation(ModInfo.ID, "textures/gui/celestialbodies/planetOne.png"));
		planetOneS2.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetOneS2.setDimensionInfo(p1s2Id, WorldProviderPlanetOneS2.class);
		planetOneS2.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetOneS2.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		planetOneS2.setBiomeInfo(BiomePlanetOneS2.planetOneS2);

	}

	private static void setMobInfo(CelestialBody body) {
		body.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
	}

	private void registerPlanetTeleportTypes() {

		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOneS1.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwoS1.class, new TeleportTypeMoon());
		
	}

	private void registerPlanets() {

		GalaxyRegistry.registerPlanet(planetOneS1);
		GalaxyRegistry.registerPlanet(planetTwoS1);
		
		GalaxyRegistry.registerPlanet(planetOneS2);

	}

}
