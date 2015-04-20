package co.zerono.mco.handlers;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import co.zerono.mco.blocks.BlockAlloy;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.helpers.MathHelper;
import co.zerono.mco.helpers.RegisterHelpers;
import co.zerono.mco.item.ItemDust;
import co.zerono.mco.item.ItemIngot;
import co.zerono.mco.item.ItemNugget;
import co.zerono.mco.reference.Messages;
import co.zerono.mco.reference.Names;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Names.Items;
import co.zerono.mco.utility.LogHelper;
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
		fillLinkedLists();
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
		Settings.Master.GEN_BLOCKS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_BLOCKS", false).getBoolean();
		Settings.Master.GEN_INGOTS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_INGOTS", false).getBoolean();
		Settings.Master.GEN_DUSTS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_DUSTS", false).getBoolean();
		Settings.Master.GEN_NUGGETS = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_NUGGETS", false).getBoolean();
		Settings.Master.ADD_SMELTING = configuration.get(Messages.Configuration.CATEGORY_MASTER, "ADD_SMELTING", false).getBoolean();
		Settings.Master.ADD_CRAFTING = configuration.get(Messages.Configuration.CATEGORY_MASTER, "ADD_CRAFTING", false).getBoolean();
		Settings.Master.GEN_TINY_DUST = configuration.get(Messages.Configuration.CATEGORY_MASTER, "GEN_TINY_DUST", false).getBoolean();
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
		Settings.Ore.ORE_COOK_TIME = configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_SMELT_TIME", Names.Blocks.COOK_TIME_DEFAULT).getIntList();
		Settings.Ore.SMELT_XP = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ORES, "ORE_SMELT_XP", Names.Blocks.SMELT_XP_DEFAULT).getDoubleList());
	}
	public static void ingotConfiguration()
	{
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_INGOTS, StatCollector.translateToLocal(Messages.Configuration.GEN_INGOTS_COMMENT));
		
		Settings.Ingot.INGOT_NAME = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "INGOT_NAMES", Names.Items.INGOT_NAMES_DEFAULT).getStringList();
		Settings.Ingot.INGOT_HEX = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "INGOT_HEX", Names.Items.INGOT_HEX_DEFAULT).getStringList();
		Settings.Ingot.DUST_A_NAME = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "DUST_A_NAME", Names.Items.DUST_A_NAME_DEFAULT).getStringList();
		Settings.Ingot.DUST_A_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "DUST_A_AMOUNT", Names.Items.DUST_A_AMOUNT_DEFAULT).getIntList();
		Settings.Ingot.DUST_B_NAME = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "DUST_B_NAME", Names.Items.DUST_B_NAME_DEFAULT).getStringList();
		Settings.Ingot.DUST_B_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_INGOTS, "DUST_B_AMOUNT", Names.Items.DUST_B_AMOUNT_DEFAULT).getIntList();
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
	public static void fillLinkedLists()
	{
		for(int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
		{
			BlockOre blockOre = new BlockOre(Settings.Ore.ORE_NAMES[i], null, RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i), null);
			Reference.ORE_LIST.add(blockOre);
			BlockOre denseOre = new BlockOre(Settings.Ore.ORE_NAMES[i], "Dense", RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i), blockOre);
			Reference.ORE_DENSE_LIST.add(denseOre);
			BlockOre poorOre = new BlockOre(Settings.Ore.ORE_NAMES[i], "Poor", RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i), null);
			Reference.ORE_POOR_LIST.add(poorOre);
			ItemIngot itemIngot = new ItemIngot(Settings.Ore.ORE_NAMES[i], RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getCookTime(i, Settings.Ore.ORE_COOK_TIME), blockOre, RegisterHelpers.getSmeltXP(i, Settings.Ore.SMELT_XP));
			Reference.INGOT_LIST.add(itemIngot);
			BlockAlloy blockAlloy = new BlockAlloy(blockOre, itemIngot);
			Reference.BLOCK_ALLOY_LIST.add(blockAlloy);
			ItemNugget itemNugget = new ItemNugget(Settings.Ore.ORE_NAMES[i], RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getCookTime(i, Settings.Ore.ORE_COOK_TIME), poorOre, RegisterHelpers.getSmeltXP(i, Settings.Ore.SMELT_XP));
			Reference.NUGGET_LIST.add(itemNugget);
			ItemDust itemDust = new ItemDust(Settings.Ore.ORE_NAMES[i], RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getCookTime(i, Settings.Ore.ORE_COOK_TIME), RegisterHelpers.getSmeltXP(i, Settings.Ore.SMELT_XP), itemIngot, false, itemNugget);
			Reference.DUST_LIST.add(itemDust);
			ItemDust itemTinyDust = new ItemDust(Settings.Ore.ORE_NAMES[i], RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getCookTime(i, Settings.Ore.ORE_COOK_TIME), RegisterHelpers.getSmeltXP(i, Settings.Ore.SMELT_XP), itemIngot, true, itemNugget);
			Reference.TINY_DUST_LIST.add(itemTinyDust);
		}
		// TODO get vanilla ores setup
		//BlockOre ironDense = new BlockOre("Iron","Dense","FFFFFF",64,8,24,Blocks.iron_ore);
		//Reference.VANILLA_DENSE_LIST.add(ironDense);
		//BlockOre goldDense = new BlockOre("Gold","Desne","FFFF0B",32,3,16,Blocks.gold_ore);
		//Reference.VANILLA_DENSE_LIST.add(goldDense);

		//BlockOre ironPoor = new BlockOre("Iron","Poor","FFFFFF",64,8,24,Blocks.iron_ore);
		//Reference.VANILLA_POOR_LIST.add(ironPoor);
		//BlockOre goldPoor = new BlockOre("Gold","Poor","FFFF0B",32,3,16,Blocks.gold_ore);
		//Reference.VANILLA_POOR_LIST.add(goldPoor);
	}
}
