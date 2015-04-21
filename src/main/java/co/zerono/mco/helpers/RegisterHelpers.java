package co.zerono.mco.helpers;

import co.zerono.mco.reference.Settings;

public class RegisterHelpers 
{
	public static String stringHelper(int meta, String[] stringArray)
	{
		if(stringArray.length-1>= meta)
		{
			return stringArray[meta];
		}
		else
		{
			return "ERROR";
		}
	}
	public static int intHelper(int meta, int[] integerArray)
	{
		if(integerArray.length-1>=meta)
		{
			return integerArray[meta];
		}
		else
		{
			return 1;
		}
	}
	public static String getOreName(int meta, String[] oreNames)
	{
		if (oreNames.length-1>= meta)
		{
			return oreNames[meta];
		}
		else
		{
			return "Zero";
		}
	}
	public static String getUnderlyingHex(int meta, String[] hexString)
	{
		if (hexString.length-1>=meta)
		{
			return hexString[meta];
		}
		else
		{
			return "FFFFFF";
		}
	}
	public static String getToolClass(int meta, String[] toolClass)
	{
		if(toolClass.length-1>=meta)
		{
			return toolClass[meta];
		}
		else
		{
			return "pickaxe";
		}
	}
	public static int getHarvestLevel(int meta, int[] harvestLevel)
	{
		if(harvestLevel.length-1>=meta)
		{
			return harvestLevel[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getOreXP(int meta, int[] oreXP)
	{
		if(oreXP.length-1>=meta)
		{
			return oreXP[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getChunkChance(int meta, int[] chunkChance)
	{
		if(chunkChance.length-1>=meta)
		{
			return chunkChance[meta];
		}
		else
		{
			return 100;
		}
	}
	public static int getMaxY(int meta, int[] maxY)
	{
		if(maxY.length-1>=meta)
		{
			return maxY[meta];
		}
		else
		{
			return 128;
		}
	}
	public static int getMinY(int meta, int[] minY)
	{
		if(minY.length-1>=meta)
		{
			return minY[meta];
		}
		else
		{
			return 0;
		}
	}
	public static int getOrePerVein(int meta, int[] perVein)
	{
		if(perVein.length-1>=meta)
		{
			return perVein[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getVeinsPerChunk(int meta, int[] perChunk)
	{
		if(perChunk.length-1>=meta)
		{
			return perChunk[meta];
		}
		else
		{
			return 1;
		}
	}
	public static float getHardness(int meta, float[] hardness)
	{
		if(hardness.length-1>=meta)
		{
			return hardness[meta];
		}
		else
		{
			return 1.0F;
		}
	}
	public static float getResistance(int meta, float[] resistance)
	{
		if(resistance.length-1>=meta)
		{
			return resistance[meta];
		}
		else
		{
			return 1.0F;
		}
	}
	public static float getLight(int meta, float[] lightLevel)
	{
		if(lightLevel.length-1>=meta)
		{
			return lightLevel[meta];
		}
		else
		{
			return 0.0F;
		}
	}
	public static int getCookTime(int meta, int[] cookTimeArray)
	{
		if(cookTimeArray.length-1>=meta)
		{
			return cookTimeArray[meta];
		}
		else
		{
			return 1;
		}
	}
	public static float getSmeltXP(int meta, float[] smeltXP)	{
		if(smeltXP.length-1>=meta)
		{
			return smeltXP[meta];
		}
		else
		{
			return 0.0F;
		}
	}
}
