package co.zerono.pc.handlers;

import java.io.File;

import scala.actors.threadpool.Arrays;
import co.zerono.pc.helpers.MathHelper;
import co.zerono.pc.reference.Messages;
import co.zerono.pc.reference.Names;
import co.zerono.pc.reference.Reference;
import co.zerono.pc.reference.Settings;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

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
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_MASTER, StatCollector.translateToLocal(Messages.Configuration.MASTER_COMMENT));
		
		Settings.Master.GEN_POOR = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_POOR", false).getBoolean();
		Settings.Master.GEN_ORE = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_ORE", false).getBoolean();
		Settings.Master.GEN_DENSE = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_DENSE", false).getBoolean();
		
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_ORES, StatCollector.translateToLocal(Messages.Configuration.GEN_ORES_COMMENT));
		
		Settings.Ore.ORE_NAMES = seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_NAMES", Names.Blocks.ORE_NAMES_DEFAULT).getString());
		Settings.Ore.ORE_TOOL_CLASS = seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_TOOL_CLASS", Names.Blocks.ORE_TOOL_CLASS_DEFAULT).getString());
		Settings.Ore.ORE_HARVEST_LEVEL = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_HARVEST_LEVEL", Names.Blocks.ORE_HARVEST_LEVEL_DEFAULT).getString()));
		Settings.Ore.ORE_XP = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_XP", Names.Blocks.ORE_XP_DEFAULT).getString()));
		Settings.Ore.ORE_CHUNK_CHANCE = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_CHUNK_CHANCE", Names.Blocks.ORE_CHUNK_CHANCE_DEFAULT).getString()));
		Settings.Ore.ORE_MAX_Y = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_MAX_Y", Names.Blocks.ORE_MAX_Y_DEFAULT).getString()));
		Settings.Ore.ORE_MIN_Y = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_MIN_Y", Names.Blocks.ORE_MIN_Y_DEFAULT).getString()));
		Settings.Ore.ORE_PER_VEIN = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_PER_VEIN", Names.Blocks.ORE_PER_VEIN_DEFAULT).getString()));
		Settings.Ore.ORE_VEINS_PER_CHUNK = MathHelper.stringToInteger(seperateOnComma(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_VEINS_PER_CHUNK", Names.Blocks.ORE_VIENS_PER_CHUNK_DEFAULT).getString()));
		
		
		ConfigurationHandler.saveChanges();
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
