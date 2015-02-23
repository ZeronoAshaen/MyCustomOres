package co.zerono.mco.helpers;

import co.zerono.mco.reference.Settings;

public class RegisterHelpers 
{
	public static String getOreName(int meta)
	{
		if (Settings.Ore.ORE_NAMES.length-1>= meta)
		{
			return Settings.Ore.ORE_NAMES[meta];
		}
		else
		{
			return "Zero";
		}
	}
	public static String getUnderlyingHex(int meta)
	{
		if (Settings.Ore.ORE_HEX.length-1>=meta)
		{
			return Settings.Ore.ORE_HEX[meta];
		}
		else
		{
			return "FFFFFF";
		}
	}
	public static String getToolClass(int meta)
	{
		if(Settings.Ore.ORE_TOOL_CLASS.length-1>=meta)
		{
			return Settings.Ore.ORE_TOOL_CLASS[meta];
		}
		else
		{
			return "pickaxe";
		}
	}
	public static int getHarvestLevel(int meta)
	{
		if(Settings.Ore.ORE_HARVEST_LEVEL.length-1>=meta)
		{
			return Settings.Ore.ORE_HARVEST_LEVEL[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getOreXP(int meta)
	{
		if(Settings.Ore.ORE_XP.length-1>=meta)
		{
			return Settings.Ore.ORE_XP[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getChunkChance(int meta)
	{
		if(Settings.Ore.ORE_CHUNK_CHANCE.length-1>=meta)
		{
			return Settings.Ore.ORE_CHUNK_CHANCE[meta];
		}
		else
		{
			return 100;
		}
	}
	public static int getMaxY(int meta)
	{
		if(Settings.Ore.ORE_MAX_Y.length-1>=meta)
		{
			return Settings.Ore.ORE_MAX_Y[meta];
		}
		else
		{
			return 128;
		}
	}
	public static int getMinY(int meta)
	{
		if(Settings.Ore.ORE_MIN_Y.length-1>=meta)
		{
			return Settings.Ore.ORE_MIN_Y[meta];
		}
		else
		{
			return 0;
		}
	}
	public static int getOrePerVein(int meta)
	{
		if(Settings.Ore.ORE_PER_VEIN.length-1>=meta)
		{
			return Settings.Ore.ORE_PER_VEIN[meta];
		}
		else
		{
			return 1;
		}
	}
	public static int getVeinsPerChunk(int meta)
	{
		if(Settings.Ore.ORE_VEINS_PER_CHUNK.length-1>=meta)
		{
			return Settings.Ore.ORE_VEINS_PER_CHUNK[meta];
		}
		else
		{
			return 1;
		}
	}
	public static float getHardness(int meta)
	{
		if(Settings.Ore.ORE_HARDNESS.length-1>=meta)
		{
			return Settings.Ore.ORE_HARDNESS[meta];
		}
		else
		{
			return 1.0F;
		}
	}
	public static float getResistance(int meta)
	{
		if(Settings.Ore.ORE_RESISTANCE.length-1>=meta)
		{
			return Settings.Ore.ORE_RESISTANCE[meta];
		}
		else
		{
			return 1.0F;
		}
	}
	public static float getLight(int meta)
	{
		if(Settings.Ore.ORE_LIGHT_LEVEL.length-1>=meta)
		{
			return Settings.Ore.ORE_LIGHT_LEVEL[meta];
		}
		else
		{
			return 0.0F;
		}
	}
}
