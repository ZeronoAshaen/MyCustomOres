package co.zerono.mco.reference;

import net.minecraft.block.Block;

public class Names 
{
	public static final class Blocks
	{
		public static final String ORE_BLOCK = "oreBlock";
		public static final String ORE_POOR_BLOCK = "orePoorBlock";
		public static final String ORE_DENSE_BLOCK = "oreDenseBlock";
		
		public static final String[] ORE_NAME_DEFAULT = {"Aluminium","Copper","Lead","Silver","Tin","Uranium"};
		public static final String[] ORE_HEX_DEFAULT = {"F5FFF5","CC6600","A3A3CC","C6EBEB","FFF5F5","00FF00"};
		public static final String[] ORE_TOOL_CLASS_DEFAULT = {"pickaxe","pickaxe","pickaxe","pickaxe","pickaxe","pickaxe"};
		public static final int[] ORE_HARVEST_LEVEL_DEFAULT = {1,1,2,2,1,2};
		public static final int[] ORE_XP_DEFAULT = {1,1,1,1,1,1};
		public static final int[] ORE_CHUNK_CHANCE_DEFAULT = {100,100,75,65,100,50};
		public static final int[] ORE_MAX_Y_DEFAULT = {128,128,64,54,128,46};
		public static final int[] ORE_MIN_Y_DEFAULT = {1,1,1,1,1,1};
		public static final int[] ORE_PER_VEIN_DEFAULT = {8,6,5,4,7,5};
		public static final int[] ORE_VIENS_PER_CHUNK_DEFAULT = {7,6,4,4,8,3};
		public static final double[] ORE_HARD_RES_DEFAULT = {2.0,2.0,4.0,4.0,2.0,4.0};
		public static final double[] ORE_LIGHT_LEVEL_DEFAULT = {0.0,0.0,0.0,0.0,0.0,0.0};
		public static final double[] COOK_TIME_DEFAULT = {1.0,1.0,1.0,1.0,1.0,1.0};
		public static final double[] SMELT_XP_DEFAULT = {1.0,1.0,1.0,1.0,1.0,1.0};
		
		public static final String[] VANILLA_ORE_HEX = {"363636", "FFFFFF", "FFFF0B"};
		public static final int[] VANILLA_ORE_MAX_Y = {120,64,32};
		public static final int[] VANILLA_ORE_VEINS_PER_CHUNK = {12,8,3};
		public static final int[] VANILLA_ORE_PER_VEIN = {32,24,16};
	}
	public static final class Items
	{
		public static String[] ALLOY_NAMES_DEFAULT = {"Zero", "Blargh"};
		public static String[] ALLOY_HEX_DEFAULT = {"232323", "323232"};
		public static int[] PRODUCED_AMOUNT_DEFAULT = {5,5};
		public static String[] DUST_A_NAME_DEFAULT = {"silver", "lead"};
		public static int[] DUST_A_AMOUNT_DEFAULT = {3,3};
		public static String[] DUST_B_NAME_DEFAULT = {"lead","silver"};
		public static int[] DUST_B_AMOUNT_DEFAULT = {2,2};
		public static String[] DUST_C_NAME_DEFUALT = {};
		public static int[]	DUST_C_AMOUNT_DEFAULT = {};
		public static double[] COOK_TIME_DEFAULT = {1.0,1.0};
		public static double[] SMELT_XP_DEFAULT = {1.0,1.0};
		public static int[] HARVEST_LEVEL_DEFAULT = {2,2};
		public static double[] ALLOY_HARDNESS_DEFAULT = {2.0,2.0};
		public static double[] ALLOY_RESISTANCE_DEFAULT = {2.0,2.0};
		public static double[] ALLOY_LIGHT_LEVEL_DEFAULT = {0.0,0.0};
	}
}
