package co.zerono.pc.creativeTab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import co.zerono.pc.init.ModBlocks;
import co.zerono.pc.init.ModItems;
import co.zerono.pc.reference.Reference;

public class CreativeTabPC 
{
	public static final CreativeTabs PC_ORE_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".ore")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.itemPlaceHolder;
		}
	};
	public static final CreativeTabs PC_ITEMS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".items")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.itemPlaceHolder;
		}
	};
}
