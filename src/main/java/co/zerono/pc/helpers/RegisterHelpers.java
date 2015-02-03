package co.zerono.pc.helpers;

import co.zerono.pc.reference.Settings;

public class RegisterHelpers 
{
	public static Integer getHarvestLevel(int meta)
	{
		if(Settings.Ore.ORE_HARVEST_LEVEL[meta] != null)
		{
			return Settings.Ore.ORE_HARVEST_LEVEL[meta];
		}
		else
		{
			return 1;
		}
	}
	public static String getToolClass(int meta)
	{
		if(Settings.Ore.ORE_TOOL_CLASS[meta] != null)
		{
			return Settings.Ore.ORE_TOOL_CLASS[meta];
		}
		else
		{
			return "pickaxe";
		}
	}
}
