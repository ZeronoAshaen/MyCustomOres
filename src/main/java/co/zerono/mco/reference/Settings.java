package co.zerono.mco.reference;

import co.zerono.mco.helpers.MathHelper;

public class Settings 
{
	public static class Master
	{
		public static Boolean GEN_POOR;
		public static Boolean GEN_ORE;
		public static Boolean GEN_DENSE;
		public static Boolean GEN_BLOCKS;
		public static Boolean GEN_INGOTS;
		public static Boolean GEN_DUSTS;
		public static Boolean GEN_NUGGETS;
		public static Boolean ADD_SMELTING;
		public static Boolean ADD_CRAFTING;
		public static Boolean PULVERISE_POOR_ORE;
		public static Boolean GEN_TINY_DUST;
	}
	public static class Ore
	{
		public static String[] ORE_NAMES;
		public static String[] ORE_TOOL_CLASS;
		public static int[] ORE_HARVEST_LEVEL;
		
		public static int[] ORE_XP;
		public static int[] ORE_CHUNK_CHANCE;
		public static int[] ORE_MAX_Y;
		public static int[] ORE_MIN_Y;
		public static int[] ORE_PER_VEIN;
		public static int[] ORE_VEINS_PER_CHUNK;
		public static String[] ORE_HEX;
		public static float[] ORE_HARDNESS;
		public static float[] ORE_RESISTANCE;
		public static float[] ORE_LIGHT_LEVEL;
		public static int[] ORE_COOK_TIME;
		public static float[] SMELT_XP;
	}
	public static class Ingot
	{
		public static String[] INGOT_NAMES;
		public static String[] INGOT_HEX;
		public static int[] COOK_TIME;
		public static float[] SMELT_XP;
	}
}
