package co.zerono.pc.init;

import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.oredict.OreDictionary;
import co.zerono.pc.blocks.BlockOre;
import co.zerono.pc.blocks.BlockPC;
import co.zerono.pc.helpers.RegisterHelpers;
import co.zerono.pc.reference.Reference;
import co.zerono.pc.reference.Settings;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks 
{
	
	public static void init()
	{
		initBlocks();
	}
	
	public static void initBlocks()
	{
		if(Settings.Master.GEN_ORE)
		{
			for(int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				OreDictionary.registerOre("ore"+Settings.Ore.ORE_NAMES[i], GameRegistry.registerBlock(new BlockOre(), Settings.Ore.ORE_NAMES[i]).setBlockName("ore"+Settings.Ore.ORE_NAMES[i]));
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for(int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				OreDictionary.registerOre("orePoor"+Settings.Ore.ORE_NAMES[i], GameRegistry.registerBlock(new BlockOre(), Settings.Ore.ORE_NAMES[i]).setBlockName("orePoor"+Settings.Ore.ORE_NAMES[i]));
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for(int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
			{
				OreDictionary.registerOre("oreDense"+Settings.Ore.ORE_NAMES[i], GameRegistry.registerBlock(new BlockOre(), Settings.Ore.ORE_NAMES[i]).setBlockName("oreDense"+Settings.Ore.ORE_NAMES[i]));
			}
		}
		for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
		{
			//BlockPC.getBlockFromName("ore"+Settings.Ore.ORE_NAMES[i]).setHarvestLevel(RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i));
		}
	}
}
