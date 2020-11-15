package io.github.gcaddon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gcaddon.init.AddonDimensions;
import io.github.gcaddon.init.AddonPlanets;
import io.github.gcaddon.init.AddonSolarSystems;
import io.github.gcaddon.proxy.Proxy;
import io.github.gcaddon.util.Utils;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = ModInfo.ID,	
		name = ModInfo.NAME,
		version = ModInfo.VERSION,
		acceptedMinecraftVersions = ModInfo.ACCEPTED_MC_VERSION,
		dependencies = ModInfo.DEPENDENCIES_FORGE + ModInfo.DEPENDENCIES_MODS,
		certificateFingerprint = ModInfo.CERTIFICATEFINGERPRINT)
public class GCAddon {

	public static final Logger LOGGER   = LogManager.getLogger(ModInfo.ID);

	@SidedProxy(
			clientSide = "io.github.gcaddon.proxy.ClientProxy",
			serverSide = "io.github.gcaddon.proxy.ServerProxy")
	private static Proxy proxy;

	@EventHandler
	public static void onFingerprintViolation (final FMLFingerprintViolationEvent event) {
		if (!Utils.developerEnvironment) {
			// This complains if jar not signed, even if certificateFingerprint is blank
			// But only when not in our Development Environment
			LOGGER.warn("Invalid Fingerprint");
		}
	}

	@EventHandler
	public static void preInit (final FMLPreInitializationEvent event) {

		// call this in the preInit (MAKE SURE YOU REGISTER ANY BLOCKS OR ITEMS FIRST)
		new AddonSolarSystems();
		new AddonPlanets();

		proxy.preInit(event);
	}

	@EventHandler
	public static void init (final FMLInitializationEvent event) {
		proxy.init(event);

	}

	@EventHandler
	public static void receiveIMC (final IMCEvent event) {
		proxy.receiveIMC(event);
	}

	@EventHandler
	public static void postInit (final FMLPostInitializationEvent event) {
		// Register addons dimensions used by planets/moonds/etc.. in postInit
		AddonDimensions.init();
		proxy.postInit(event);
	}

	public static World getWorld () {
		return proxy.getWorld();
	}
}
