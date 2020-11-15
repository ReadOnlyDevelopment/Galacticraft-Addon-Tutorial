package io.github.gcaddon.util;

import net.minecraft.launchwrapper.Launch;

public class Utils {
	
	public static final boolean developerEnvironment = (boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");


}
