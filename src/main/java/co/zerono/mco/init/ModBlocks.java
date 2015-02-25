package co.zerono.mco.init;

import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.oredict.OreDictionary;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.blocks.BlockMCO;
import co.zerono.mco.helpers.RegisterHelpers;
import co.zerono.mco.item.BlockOreItem;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks 
{
	public static void preInit()
	{
		if(Settings.Master.GEN_ORE)
		{
			for(BlockOre blockOre : Reference.ORE_LIST)
			{
				GameRegistry.registerBlock(blockOre, blockOre.getOreDictName());
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for(BlockOre blockOre : Reference.ORE_POOR_LIST)
			{
				GameRegistry.registerBlock(blockOre, blockOre.getOreDictName());
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for(BlockOre blockOre : Reference.ORE_DENSE_LIST)
			{
				GameRegistry.registerBlock(blockOre, blockOre.getOreDictName());
			}
		}
		LogHelper.info("Ores Created");
		//initOreBlocks();
	}
	
	public static void init()
	{
		if(Settings.Master.GEN_ORE)
		{
			for(BlockOre blockOre : Reference.ORE_LIST)
			{
				blockOre.registerOreDict();
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for(BlockOre blockOre : Reference.ORE_DENSE_LIST)
			{
				blockOre.registerOreDict();
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for(BlockOre blockOre : Reference.ORE_POOR_LIST)
			{
				blockOre.registerOreDict();
			}
		}
		LogHelper.info("Ores Registered");
	}
	
	public static void initOreBlocks()
	{

		if(Settings.Master.GEN_ORE)
		{
			for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				GameRegistry.registerBlock(new BlockOre(RegisterHelpers.getOreName(i), null, RegisterHelpers.getUnderlyingHex(i), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i)), Settings.Ore.ORE_NAMES[i]);
				LogHelper.info("Creating " + Settings.Ore.ORE_NAMES[i] + " ore." );
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				GameRegistry.registerBlock(new BlockOre(RegisterHelpers.getOreName(i), "Poor", RegisterHelpers.getUnderlyingHex(i), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i)), "poor" + Settings.Ore.ORE_NAMES[i]);
				LogHelper.info("Creating Poor " + Settings.Ore.ORE_NAMES[i] + " ore." );
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				GameRegistry.registerBlock(new BlockOre(RegisterHelpers.getOreName(i), "Dense", RegisterHelpers.getUnderlyingHex(i), RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i), RegisterHelpers.getOreXP(i), RegisterHelpers.getChunkChance(i), RegisterHelpers.getMaxY(i), RegisterHelpers.getMinY(i), RegisterHelpers.getOrePerVein(i), RegisterHelpers.getVeinsPerChunk(i), RegisterHelpers.getHardness(i), RegisterHelpers.getResistance(i), RegisterHelpers.getLight(i)), "dense" + Settings.Ore.ORE_NAMES[i]);
				LogHelper.info("Creating Dense " + Settings.Ore.ORE_NAMES[i] + " ore." );
			}
		}
	}
}
