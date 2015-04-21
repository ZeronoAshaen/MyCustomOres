package co.zerono.mco.init;

import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.oredict.OreDictionary;
import co.zerono.mco.blocks.BlockAlloy;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.blocks.BlockMCO;
import co.zerono.mco.blocks.BlockSpecialAlloy;
import co.zerono.mco.helpers.RegisterHelpers;
import co.zerono.mco.item.ItemSpecialIngot;
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
		preInitOreBlocks();
		preInitAlloyBlocks();
	}
	
	public static void init()
	{
		initOreBlocks();
		initAlloyBlocks();
		initBlockCrafting();
	}
	public static void preInitOreBlocks()
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
		LogHelper.debug("Ores Created");
	}
	public static void preInitAlloyBlocks()
	{
		if(Settings.Master.GEN_BLOCKS)
		{
			for(BlockAlloy blockAlloy : Reference.BLOCK_ALLOY_LIST)
			{
				GameRegistry.registerBlock(blockAlloy, blockAlloy.getOreDictName());
			}
			for(BlockSpecialAlloy specialAlloy : Reference.SPECIAL_ALLOY)
			{
				GameRegistry.registerBlock(specialAlloy, specialAlloy.getOreDictName());
			}
		}
		LogHelper.debug("Alloy Blocks Registered.");
	}
	public static void initOreBlocks()
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
		LogHelper.debug("Ores Registered");
	}
	public static void initAlloyBlocks()
	{
		if(Settings.Master.GEN_BLOCKS)
		{
			for(BlockAlloy blockAlloy : Reference.BLOCK_ALLOY_LIST)
			{
				blockAlloy.registerOreDict();
			}
			for(BlockSpecialAlloy specialAlloy : Reference.SPECIAL_ALLOY)
			{
				specialAlloy.registerOreDict();
			}
		}
		LogHelper.debug("Alloy Blocks Registered.");
	}
	public static void initBlockCrafting()
	{
		if(Settings.Master.ADD_CRAFTING)
		{
			if(Settings.Master.GEN_BLOCKS)
			{
				for(BlockAlloy blockAlloy : Reference.BLOCK_ALLOY_LIST)
				{
					blockAlloy.registerCrafting();
				}
				for(BlockSpecialAlloy specialAlloy : Reference.SPECIAL_ALLOY)
				{
					specialAlloy.registerCrafting();
				}
			}
		}
		LogHelper.debug("Block Crafting Registered");
	}
}
