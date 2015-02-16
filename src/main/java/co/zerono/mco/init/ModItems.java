package co.zerono.pc.init;

import co.zerono.pc.item.ItemPC;
import co.zerono.pc.item.ItemPlaceHolder;
import co.zerono.pc.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems 
{
	public static final ItemPC itemPlaceHolder = new ItemPlaceHolder();
	
	public static void Init()
	{
		GameRegistry.registerItem(itemPlaceHolder, "PlaceHolder");
	}
}
