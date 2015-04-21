package co.zerono.mco.handlers;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import co.zerono.mco.blocks.BlockAlloy;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.blocks.BlockSpecialAlloy;
import co.zerono.mco.helpers.MathHelper;
import co.zerono.mco.helpers.RegisterHelpers;
import co.zerono.mco.item.ItemDust;
import co.zerono.mco.item.ItemIngot;
import co.zerono.mco.item.ItemNugget;
import co.zerono.mco.item.ItemSpecialDust;
import co.zerono.mco.item.ItemSpecialIngot;
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
		alloyConfiguration();
		
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
	public static void alloyConfiguration()
	{
		configuration.setCategoryComment(Messages.Configuration.CATEGORY_ALLOY, StatCollector.translateToLocal(Messages.Configuration.GEN_ALLOY_COMMENT));
		
		Settings.Alloy.ALLOY_NAME = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "ALLOY_NAMES", Names.Items.ALLOY_NAMES_DEFAULT).getStringList();
		Settings.Alloy.ALLOY_HEX = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "ALLOY_HEX", Names.Items.ALLOY_HEX_DEFAULT).getStringList();
		Settings.Alloy.PRODUCED_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "PRODUCED_AMOUNT", Names.Items.PRODUCED_AMOUNT_DEFAULT).getIntList();
		Settings.Alloy.DUST_A_NAME = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "DUST_A_NAME", Names.Items.DUST_A_NAME_DEFAULT).getStringList();
		Settings.Alloy.DUST_A_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "DUST_A_AMOUNT", Names.Items.DUST_A_AMOUNT_DEFAULT).getIntList();
		Settings.Alloy.DUST_B_NAME = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "DUST_B_NAME", Names.Items.DUST_B_NAME_DEFAULT).getStringList();
		Settings.Alloy.DUST_B_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "DUST_B_AMOUNT", Names.Items.DUST_B_AMOUNT_DEFAULT).getIntList();
		Settings.Alloy.DUST_C_NAME = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "DUST_C_NAME", Names.Items.DUST_C_NAME_DEFUALT).getStringList();
		Settings.Alloy.DUST_C_AMOUNT = configuration.get(Messages.Configuration.CATEGORY_ALLOY, " DUST_C_AMOUNT", Names.Items.DUST_C_AMOUNT_DEFAULT).getIntList();
		Settings.Alloy.COOK_TIME = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "COOK_TIME", Names.Items.COOK_TIME_DEFAULT).getIntList();
		Settings.Alloy.SMELT_XP = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ALLOY, "SMELT_XP", Names.Items.SMELT_XP_DEFAULT).getDoubleList());
		Settings.Alloy.HARVEST_LEVEL = configuration.get(Messages.Configuration.CATEGORY_ALLOY, "HARVEST_LEVEL", Names.Items.HARVEST_LEVEL_DEFAULT).getIntList();
		Settings.Alloy.HARDNESS = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ALLOY, "HARDNESS", Names.Items.ALLOY_HARDNESS_DEFAULT).getDoubleList());
		Settings.Alloy.RESISTANCE = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ALLOY, "RESISTANCE", Names.Items.ALLOY_RESISTANCE_DEFAULT).getDoubleList());
		Settings.Alloy.LIGHT_LEVEL = MathHelper.doubleArrayToFloatArray(configuration.get(Messages.Configuration.CATEGORY_ALLOY, "LIGHT_LEVEL", Names.Items.ALLOY_LIGHT_LEVEL_DEFAULT).getDoubleList());
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
			BlockOre blockOre = new BlockOre(Settings.Ore.ORE_NAMES[i], null, RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i, Settings.Ore.ORE_TOOL_CLASS), RegisterHelpers.getHarvestLevel(i, Settings.Ore.ORE_HARVEST_LEVEL), RegisterHelpers.getOreXP(i, Settings.Ore.ORE_XP), RegisterHelpers.getChunkChance(i, Settings.Ore.ORE_CHUNK_CHANCE), RegisterHelpers.getMaxY(i, Settings.Ore.ORE_MAX_Y), RegisterHelpers.getMinY(i, Settings.Ore.ORE_MIN_Y), RegisterHelpers.getOrePerVein(i, Settings.Ore.ORE_PER_VEIN), RegisterHelpers.getVeinsPerChunk(i, Settings.Ore.ORE_VEINS_PER_CHUNK), RegisterHelpers.getHardness(i, Settings.Ore.ORE_HARDNESS), RegisterHelpers.getResistance(i, Settings.Ore.ORE_RESISTANCE), RegisterHelpers.getLight(i, Settings.Ore.ORE_LIGHT_LEVEL), null);
			Reference.ORE_LIST.add(blockOre);
			BlockOre denseOre = new BlockOre(Settings.Ore.ORE_NAMES[i], "Dense", RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i, Settings.Ore.ORE_TOOL_CLASS), RegisterHelpers.getHarvestLevel(i, Settings.Ore.ORE_HARVEST_LEVEL), RegisterHelpers.getOreXP(i, Settings.Ore.ORE_XP), RegisterHelpers.getChunkChance(i, Settings.Ore.ORE_CHUNK_CHANCE), RegisterHelpers.getMaxY(i, Settings.Ore.ORE_MAX_Y), RegisterHelpers.getMinY(i, Settings.Ore.ORE_MIN_Y), RegisterHelpers.getOrePerVein(i, Settings.Ore.ORE_PER_VEIN), RegisterHelpers.getVeinsPerChunk(i, Settings.Ore.ORE_VEINS_PER_CHUNK), RegisterHelpers.getHardness(i, Settings.Ore.ORE_HARDNESS), RegisterHelpers.getResistance(i, Settings.Ore.ORE_RESISTANCE), RegisterHelpers.getLight(i, Settings.Ore.ORE_LIGHT_LEVEL), blockOre);
			Reference.ORE_DENSE_LIST.add(denseOre);
			BlockOre poorOre = new BlockOre(Settings.Ore.ORE_NAMES[i], "Poor", RegisterHelpers.getUnderlyingHex(i, Settings.Ore.ORE_HEX), RegisterHelpers.getToolClass(i, Settings.Ore.ORE_TOOL_CLASS), RegisterHelpers.getHarvestLevel(i, Settings.Ore.ORE_HARVEST_LEVEL), RegisterHelpers.getOreXP(i, Settings.Ore.ORE_XP), RegisterHelpers.getChunkChance(i, Settings.Ore.ORE_CHUNK_CHANCE), RegisterHelpers.getMaxY(i, Settings.Ore.ORE_MAX_Y), RegisterHelpers.getMinY(i, Settings.Ore.ORE_MIN_Y), RegisterHelpers.getOrePerVein(i, Settings.Ore.ORE_PER_VEIN), RegisterHelpers.getVeinsPerChunk(i, Settings.Ore.ORE_VEINS_PER_CHUNK), RegisterHelpers.getHardness(i, Settings.Ore.ORE_HARDNESS), RegisterHelpers.getResistance(i, Settings.Ore.ORE_RESISTANCE), RegisterHelpers.getLight(i, Settings.Ore.ORE_LIGHT_LEVEL), null);
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
			LogHelper.debug(Settings.Ore.ORE_NAMES[i]);
		}
		for(int i=0; i<Settings.Alloy.ALLOY_NAME.length; i++)
		{
			BlockSpecialAlloy specialAlloy = new BlockSpecialAlloy(Settings.Alloy.ALLOY_NAME[i], RegisterHelpers.getUnderlyingHex(i, Settings.Alloy.ALLOY_HEX), RegisterHelpers.getHarvestLevel(i, Settings.Alloy.HARVEST_LEVEL), RegisterHelpers.getHardness(i, Settings.Alloy.HARDNESS), RegisterHelpers.getResistance(i, Settings.Alloy.RESISTANCE), RegisterHelpers.getLight(i, Settings.Alloy.LIGHT_LEVEL));
			Reference.SPECIAL_ALLOY.add(specialAlloy);
			ItemSpecialIngot specialIngot = new ItemSpecialIngot(Settings.Alloy.ALLOY_NAME[i], RegisterHelpers.getUnderlyingHex(i, Settings.Alloy.ALLOY_HEX), specialAlloy);
			Reference.SPECIAL_INGOT.add(specialIngot);
			ItemSpecialDust specialDust = new ItemSpecialDust(RegisterHelpers.getOreName(i, Settings.Alloy.ALLOY_NAME), RegisterHelpers.getUnderlyingHex(i, Settings.Alloy.ALLOY_HEX), RegisterHelpers.getCookTime(i, Settings.Alloy.COOK_TIME), RegisterHelpers.getSmeltXP(i, Settings.Alloy.SMELT_XP), specialIngot, RegisterHelpers.intHelper(i, Settings.Alloy.PRODUCED_AMOUNT), RegisterHelpers.stringHelper(i, Settings.Alloy.DUST_A_NAME), RegisterHelpers.intHelper(i, Settings.Alloy.DUST_A_AMOUNT), RegisterHelpers.stringHelper(i, Settings.Alloy.DUST_B_NAME), RegisterHelpers.intHelper(i, Settings.Alloy.DUST_B_AMOUNT));
			Reference.SPECIAL_DUST.add(specialDust);
		}
		// TODO get vanilla ores setup
		//BlockOre ironDense = new BlockOre("Iron","Dense","FFFFFF",64,8,24,Blocks.iron_ore);
		//Reference.VANILLA_DENSE_LIST.add(ironDense);
		//BlockOre goldDense = new BlockOre("Gold","Dense","FFFF0B",32,3,16,Blocks.gold_ore);
		//Reference.VANILLA_DENSE_LIST.add(goldDense);

		//BlockOre ironPoor = new BlockOre("Iron","Poor","FFFFFF",64,8,24,Blocks.iron_ore);
		//Reference.VANILLA_POOR_LIST.add(ironPoor);
		//BlockOre goldPoor = new BlockOre("Gold","Poor","FFFF0B",32,3,16,Blocks.gold_ore);
		//Reference.VANILLA_POOR_LIST.add(goldPoor);
	}
}
