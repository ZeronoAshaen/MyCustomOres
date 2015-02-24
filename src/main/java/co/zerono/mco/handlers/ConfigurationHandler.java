package co.zerono.mco.handlers;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import co.zerono.mco.helpers.MathHelper;
import co.zerono.mco.reference.Messages;
import co.zerono.mco.reference.Names;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler 
{
	private static Configuration configuration;

	public static void init(File configFile)
	{
		if(configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
    private static void saveChanges()
    {

        if (ConfigurationHandler.configuration.hasChanged())
        {
        	ConfigurationHandler.configuration.save();
        }
    }
	public static void loadConfiguration()
	{
		configuration.setCategoryComment("general", StatCollector.translateToLocal(Messages.Configuration.GENERAL_COMMENT));
		
		masterConfiguration();
		oreConfiguration();
		ingotConfiguration();
		// TODO dustConfiguration();
		// TODO smallDustConfiguration();
		
		
		ConfigurationHandler.saveChanges();
	}
	public static void masterConfiguration()
	{
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_MASTER, StatCollector.translateToLocal(Messages.Configuration.MASTER_COMMENT));
		
		Settings.Master.GEN_POOR = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_POOR", false).getBoolean();
		Settings.Master.GEN_ORE = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_ORE", false).getBoolean();
		Settings.Master.GEN_DENSE = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_DENSE", false).getBoolean();
		Settings.Master.GEN_INGOTS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_INGOTS", false).getBoolean();
		Settings.Master.GEN_DUSTS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_DUSTS", false).getBoolean();
		Settings.Master.GEN_NUGGETS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_NUGGETS", false).getBoolean();
		Settings.Master.ADD_SMELTING = configuration.get(Messages.Configuration.CATEGORY_MASTER, "ADD_SMELTING", false).getBoolean();
		Settings.Master.ADD_CRAFTING = configuration.get(Messages.Configuration.CATEGORY_MASTER, "ADD_CRAFTING", false).getBoolean();
		Settings.Master.GEN_SMALL_DUST = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_SMALL_DUST", false).getBoolean();
	}
	public static void oreConfiguration()
	{
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_ORES, StatCollector.translateToLocal(Messages.Configuration.GEN_ORES_COMMENT));
		
		Settings.Ore.ORE_NAMES = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_NAME_ARRAY", Names.Blocks.ORE_NAME_DEFAULT).getStringList();
		Settings.Ore.ORE_HEX = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_HEX_COLOR", Names.Blocks.ORE_HEX_DEFAULT).getStringList();
		Settings.Ore.ORE_TOOL_CLASS = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_TOOL_CLASS", Names.Blocks.ORE_TOOL_CLASS_DEFAULT).getStringList();
		Settings.Ore.ORE_HARVEST_LEVEL = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_HARVEST_LEVEL", Names.Blocks.ORE_HARVEST_LEVEL_DEFAULT).getIntList();
		Settings.Ore.ORE_XP = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_XP", Names.Blocks.ORE_XP_DEFAULT).getIntList();
		Settings.Ore.ORE_CHUNK_CHANCE = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_CHUNK_CHANCE", Names.Blocks.ORE_CHUNK_CHANCE_DEFAULT).getIntList();
		Settings.Ore.ORE_MAX_Y = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_MAX_Y", Names.Blocks.ORE_MAX_Y_DEFAULT).getIntList();
		Settings.Ore.ORE_MIN_Y = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_MIN_Y", Names.Blocks.ORE_MIN_Y_DEFAULT).getIntList();
		Settings.Ore.ORE_PER_VEIN = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_PER_VEIN", Names.Blocks.ORE_PER_VEIN_DEFAULT).getIntList();
		Settings.Ore.ORE_VEINS_PER_CHUNK = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_VEINS_PER_CHUNK", Names.Blocks.ORE_VIENS_PER_CHUNK_DEFAULT).getIntList();
		Settings.Ore.ORE_HARDNESS = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_HARDNESS", Names.Blocks.ORE_HARD_RES_DEFAULT).getDoubleList());
		Settings.Ore.ORE_RESISTANCE = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_RESISTANCE", Names.Blocks.ORE_HARD_RES_DEFAULT).getDoubleList());
		Settings.Ore.ORE_LIGHT_LEVEL = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_LIGHT_LEVEL", Names.Blocks.ORE_HARD_RES_DEFAULT).getDoubleList());
	}
	public static void ingotConfiguration()
	{
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_INGOTS, StatCollector.translateToLocal(Messages.Configuration.GEN_INGOTS_COMMENT));
		
		Settings.Ingot.INGOT_NAMES = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "INGOT_NAMES", Names.Items.INGOT_NAMES_DEFAULT).getStringList();
		Settings.Ingot.INGOT_HEX = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "INGOT_HEX", Names.Items.INGOT_HEX_DEFAULT).getStringList();
		Settings.Ingot.COOK_TIME = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "COOK_TIME", Names.Items.COOK_TIME_DEFAULT).getIntList();
		Settings.Ingot.SMELT_XP = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_INGOTS, "SMELT_XP", Names.Items.SMELT_XP_DEFAULT).getDoubleList());
	}
	
	@SubscribeEvent
	public void conConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}
	
	private static String[] seperateOnComma(String string)
	{
		string = string.replaceAll("\\s+", "");
		string = string.trim();
		
		String[] stringArray = string.split(",", -1);
		return stringArray;
	}
}
