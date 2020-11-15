package io.github.gcaddon.init;

import io.github.gcaddon.AddonConfig.Dimension;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;

public class AddonDimensions {

	public static DimensionType dimPlanetOneS1;
	public static DimensionType dimPlanetTwoS1;
	public static DimensionType dimPlanetOneS2;

	public static void init() {

		AddonDimensions.dimPlanetOneS1 = WorldUtil.getDimensionTypeById(Dimension.p1s1Id);
		AddonDimensions.dimPlanetTwoS1 = WorldUtil.getDimensionTypeById(Dimension.p2s1Id);
		
		AddonDimensions.dimPlanetOneS2 = WorldUtil.getDimensionTypeById(Dimension.p1s2Id);

	}
}
