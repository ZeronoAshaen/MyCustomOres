package co.zerono.mco.init;

import co.zerono.mco.item.ItemMCO;
import co.zerono.mco.item.ItemPlaceHolder;
import co.zerono.mco.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems 
{
	public static final ItemMCO itemPlaceHolder = new ItemPlaceHolder();
	
	public static void Init()
	{
		GameRegistry.registerItem(itemPlaceHolder, "PlaceHolder");
	}
}
