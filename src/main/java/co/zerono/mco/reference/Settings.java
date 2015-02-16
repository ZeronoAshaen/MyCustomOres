package co.zerono.pc.reference;

import co.zerono.pc.helpers.MathHelper;

public class Settings 
{
	public static class Master
	{
		public static Boolean GEN_POOR;
		public static Boolean GEN_ORE;
		public static Boolean GEN_DENSE;
	}
	public static class Ore
	{
		public static String[] ORE_NAMES;
		public static String[] ORE_TOOL_CLASS;
		public static Integer[] ORE_HARVEST_LEVEL;
		
		public static Integer[] ORE_XP;
		public static Integer[] ORE_CHUNK_CHANCE;
		public static Integer[] ORE_MAX_Y;
		public static Integer[] ORE_MIN_Y;
		public static Integer[] ORE_PER_VEIN;
		public static Integer[] ORE_VEINS_PER_CHUNK;
	}
}