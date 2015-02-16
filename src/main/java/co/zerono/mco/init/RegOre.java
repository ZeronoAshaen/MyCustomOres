package co.zerono.pc.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import co.zerono.pc.blocks.BlockPC;
import co.zerono.pc.reference.Settings;

public class RegOre 
{
	public static void init()
	{
		for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
		{
			OreDictionary.registerOre("ore"+Settings.Ore.ORE_NAMES[i], new ItemStack(BlockPC.getBlockFromName("ore"+Settings.Ore.ORE_NAMES[i])));
		}
	}
}
