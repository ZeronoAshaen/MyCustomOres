package co.zerono.mco.creativeTab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import co.zerono.mco.init.ModBlocks;
import co.zerono.mco.init.ModItems;
import co.zerono.mco.reference.Reference;

public class CreativeTabMCO 
{
	public static final CreativeTabs MCO_ORE_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".ore")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.itemPlaceHolder;
		}
	};
	public static final CreativeTabs MCO_ITEMS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".items")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.itemPlaceHolder;
		}
	};
}
