package io.github.gcaddon.init;

import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.Constants;
import net.minecraft.util.ResourceLocation;

public class AddonSolarSystems {
	
	public static SolarSystem addonSystem1;
	public static SolarSystem addonSystem2;
	
	public AddonSolarSystems() {
		this.createSolarSystems();
		this.registerSolarSystems();
	}
	
	private void createSolarSystems() {

		addonSystem1 = new SolarSystem("addon_system_1", "milky_way").setMapPosition(new Vector3(1.0F, -1.0f, 0.0f));
		Star iStar = new Star("system1star").setParentSolarSystem(addonSystem1);
		iStar.setTierRequired(-1);
		iStar.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		addonSystem1.setMainStar(iStar);
		
		addonSystem2 = new SolarSystem("addon_system_1", "milky_way").setMapPosition(new Vector3(-1.0F, 1.0f, 0.0f));
		Star jStar = new Star("system2star").setParentSolarSystem(addonSystem2);
		jStar.setTierRequired(-1);
		jStar.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		addonSystem2.setMainStar(jStar);
	}

	private void registerSolarSystems() {
		
		GalaxyRegistry.registerSolarSystem(addonSystem1);
		GalaxyRegistry.registerSolarSystem(addonSystem2);
		
	}

}
