package co.zerono.mco.reference;

import co.zerono.mco.reference.Names.Blocks;

public class Settings_old 
{
	public static class General
	{
		
	}
	public static class Ore
	{
		public static class Master
		{
			public static Boolean GEN_POOR;
			public static Boolean GEN_ORE;
			public static Boolean GEN_DENSE;
		}
		public static class Gen
		{
			public static Boolean GEN_LITHIUM;
			public static Boolean GEN_SODIUM;
			public static Boolean GEN_BERYLLIUM;
			public static Boolean GEN_MAGNESIUM;
			public static Boolean GEN_URANIUM;
			public static Boolean GEN_NEPTUNIUM;
			public static Boolean GEN_PLUTONIUM;
			public static Boolean GEN_TITANIUM;
			public static Boolean GEN_CHROMIUM;
			public static Boolean GEN_IRON;
			public static Boolean GEN_COBALT;
			public static Boolean GEN_NICKEL;
			public static Boolean GEN_COPPER;
			public static Boolean GEN_PALLADIUM;
			public static Boolean GEN_SILVER;
			public static Boolean GEN_TUNGSTEN;
			public static Boolean GEN_IRIDIUM;
			public static Boolean GEN_PLATINUM;
			public static Boolean GEN_GOLD;
			public static Boolean GEN_ALUMINIUM;
			public static Boolean GEN_ZINC;
			public static Boolean GEN_TIN;
			public static Boolean GEN_LEAD;
			public static Boolean GEN_SILICON;
			public static Boolean GEN_PHOSPHORUS;
			public static Boolean GEN_SULFUR;
			public static Boolean GEN_LAPIS;
			public static Boolean GEN_COAL;

		}
		public static class GenType
		{
			public static String[] GEN_TYPE_DEFAULT = {"UNIFORM"};
			public static String GEN_TYPE_VALID = "UNIFORM, VEIN, CLUMP, SPHERE";
			public static String[] GEN_LITHIUM_TYPE;
			public static String[] GEN_SODIUM_TYPE;
			public static String[] BERYLLIUM_GEN_TYPE;
			public static String[] MAGNESIUM_GEN_TYPE;
			public static String[] URANIUM_GEN_TYPE;
			public static String[] NEPTUNIUM_GEN_TYPE;
			public static String[] PLUTONIUM_GEN_TYPE;
			public static String[] TITANIUM_GEN_TYPE;
			public static String[] CHROMIUM_GEN_TYPE;
			public static String[] IRON_GEN_TYPE;
			public static String[] COBALT_GEN_TYPE;

		}
		public static class GenDensity
		{
			public static Integer GEN_LITHIUM_DENSITY;
			public static Integer GEN_SODIUM_DENSITY;
			public static Integer BERYLLIUM_GEN_DENSITY;
			public static Integer MAGNESIUM_GEN_DENSITY;		
			public static Integer URANIUM_GEN_DENSITY;		
			public static Integer NEPTUNIUM_GEN_DENSITY;		
			public static Integer PLUTONIUM_GEN_DENSITY;		
			public static Integer TITANIUM_GEN_DENSITY;		
			public static Integer CHROMIUM_GEN_DENSITY;		
			public static Integer IRON_GEN_DENSITY;		
			public static Integer COBALT_GEN_DENSITY;		

		}
		public static class Ymin
		{
			public static Integer GEN_LITHIUM_YMIN;
		}
		public static class Ymax
		{
			public static Integer GEN_LITHIUM_YMAX;
		}
		public static class HarvestLevel
		{
			public static Integer GEN_ALUMINIUM_HARVEST;
			public static Integer GEN_BERYLLIUM_HARVEST;
			public static Integer GEN_CHROMIUM_HARVEST;
			public static Integer GEN_COAL_HARVEST;
			public static Integer GEN_COBALT_HARVEST;
			public static Integer GEN_COPPER_HARVEST;
			public static Integer GEN_GOLD_HARVEST;
			public static Integer GEN_IRIDIUM_HARVEST;
			public static Integer GEN_IRON_HARVEST;
			public static Integer GEN_LAPIS_HARVEST;
			public static Integer GEN_LEAD_HARVEST;
			public static Integer GEN_LITHIUM_HARVEST;
			public static Integer GEN_MAGNESIUM_HARVEST;
			public static Integer GEN_NEPTUNIUM_HARVEST;
			public static Integer GEN_NICKEL_HARVEST;
			public static Integer GEN_PALLADIUM_HARVEST;
			public static Integer GEN_PHOSPHORUS_HARVEST;
			public static Integer GEN_PLATINUM_HARVEST;
			public static Integer GEN_PLUTONIUM_HARVEST;
			public static Integer GEN_SILICON_HARVEST;
			public static Integer GEN_SILVER_HARVEST;
			public static Integer GEN_SODIUM_HARVEST;
			public static Integer GEN_SULFUR_HARVEST;
			public static Integer GEN_TIN_HARVEST;
			public static Integer GEN_TITANIUM_HARVEST;
			public static Integer GEN_TUNGSTEN_HARVEST;
			public static Integer GEN_URANIUM_HARVEST;
			public static Integer GEN_ZINC_HARVEST;
			
		}
		
		
		public static Integer NICKEL_GEN_TYPE;
		public static Integer NICKEL_GEN_DENSITY;		
		public static Integer COPPER_GEN_TYPE;
		public static Integer COPPER_GEN_DENSITY;		
		public static Integer PALLADIUM_GEN_TYPE;
		public static Integer PALLADIUM_GEN_DENSITY;		
		public static Integer SILVER_GEN_TYPE;
		public static Integer SILVER_GEN_DENSITY;		
		public static Integer TUNGSTEN_GEN_TYPE;
		public static Integer TUNGSTEN_GEN_DENSITY;		
		public static Integer IRIDIUM_GEN_TYPE;
		public static Integer IRIDIUM_GEN_DENSITY;		
		public static Integer PLATINUM_GEN_TYPE;
		public static Integer PLATINUM_GEN_DENSITY;		
		public static Integer GOLD_GEN_TYPE;
		public static Integer GOLD_GEN_DENSITY;		
		public static Integer ALUMINIUM_GEN_TYPE;
		public static Integer ALUMINIUM_GEN_DENSITY;		
		public static Integer ZINC_GEN_TYPE;
		public static Integer ZINC_GEN_DENSITY;		
		public static Integer TIN_GEN_TYPE;
		public static Integer TIN_GEN_DENSITY;		
		public static Integer LEAD_GEN_TYPE;
		public static Integer LEAD_GEN_DENSITY;		
		public static Integer SILICON_GEN_TYPE;
		public static Integer SILICON_GEN_DENSITY;		
		public static Integer PHOSPHORUS_GEN_TYPE;
		public static Integer PHOSPHORUS_GEN_DENSITY;		
		public static Integer SULFUR_GEN_TYPE;
		public static Integer SULFUR_GEN_DENSITY;		
		public static Integer LAPIS_GEN_TYPE;
		public static Integer LAPIS_GEN_DENSITY;		
	}
	public static class Gems
	{
		public static Boolean AQUAMARINE_GEN;
		public static Integer AQUAMARINE_GEN_TYPE;
		public static Integer AQUAMARINE_GEN_DENSITY;		
		public static Boolean EMERALD_GEN;
		public static Integer EMERALD_GEN_TYPE;
		public static Integer EMERALD_GEN_DENSITY;		
		public static Boolean BLOODSTONE_GEN;
		public static Integer BLOODSTONE_GEN_TYPE;
		public static Integer BLOODSTONE_GEN_DENSITY;		
		public static Boolean ALEXANDRITE_GEN;
		public static Integer ALEXANDRITE_GEN_TYPE;
		public static Integer ALEXANDRITE_GEN_DENSITY;		
		public static Boolean CATSEYE_GEN;
		public static Integer CATSEYE_GEN_TYPE;
		public static Integer CATSEYE_GEN_DENSITY;		
		public static Boolean RUBY_GEN;
		public static Integer RUBY_GEN_TYPE;
		public static Integer RUBY_GEN_DENSITY;		
		public static Boolean SAPPHIRE_GEN;
		public static Integer SAPPHIRE_GEN_TYPE;
		public static Integer SAPPHIRE_GEN_DENSITY;		
		public static Boolean DIAMOND_GEN;
		public static Integer DIAMOND_GEN_TYPE;
		public static Integer DIAMOND_GEN_DENSITY;		
		public static Boolean MOONSTONE_GEN;
		public static Integer MOONSTONE_GEN_TYPE;
		public static Integer MOONSTONE_GEN_DENSITY;		
		public static Boolean SUNSTONE_GEN;
		public static Integer SUNSTONE_GEN_TYPE;
		public static Integer SUNSTONE_GEN_DENSITY;		
		public static Boolean GARNET_GEN;
		public static Integer GARNET_GEN_TYPE;
		public static Integer GARNET_GEN_DENSITY;		
		public static Boolean JADE_GEN;
		public static Integer JADE_GEN_TYPE;
		public static Integer JADE_GEN_DENSITY;		
		public static Boolean PERIDOT_GEN;
		public static Integer PERIDOT_GEN_TYPE;
		public static Integer PERIDOT_GEN_DENSITY;		
		public static Boolean PYRITE_GEN;
		public static Integer PYRITE_GEN_TYPE;
		public static Integer PYRITE_GEN_DENSITY;		
		public static Boolean AMETHYST_GEN;
		public static Integer AMETHYST_GEN_TYPE;
		public static Integer AMETHYST_GEN_DENSITY;		
		public static Boolean TIGERSEYE_GEN;
		public static Integer TIGERSEYE_GEN_TYPE;
		public static Integer TIGERSEYE_GEN_DENSITY;		
		public static Boolean AGATE_GEN;
		public static Integer AGATE_GEN_TYPE;
		public static Integer AGATE_GEN_DENSITY;		
		public static Boolean ONYX_GEN;
		public static Integer ONYX_GEN_TYPE;
		public static Integer ONYX_GEN_DENSITY;		
		public static Boolean QUARTZ_GEN;
		public static Integer QUARTZ_GEN_TYPE;
		public static Integer QUARTZ_GEN_DENSITY;		
		public static Boolean TOPAZ_GEN;
		public static Integer TOPAZ_GEN_TYPE;
		public static Integer TOPAZ_GEN_DENSITY;		
		public static Boolean TURQUOISE_GEN;
		public static Integer TURQUOISE_GEN_TYPE;
		public static Integer TURQUOISE_GEN_DENSITY;		
		public static Boolean TANZANITE_GEN;
		public static Integer TANZANITE_GEN_TYPE;
		public static Integer TANZANITE_GEN_DENSITY;		
		public static Boolean AMBER_GEN;
		public static Integer AMBER_GEN_TYPE;
		public static Integer AMBER_GEN_DENSITY;		
		public static Boolean JET_GEN;
		public static Integer JET_GEN_TYPE;
		public static Integer JET_GEN_DENSITY;		
		public static Boolean OPAL_GEN;
		public static Integer OPAL_GEN_TYPE;
		public static Integer OPAL_GEN_DENSITY;		

		public static String Nacre;
		public static String Pearl;
	}
	
}
