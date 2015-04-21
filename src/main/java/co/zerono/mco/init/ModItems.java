package co.zerono.mco.init;

import net.minecraft.block.Block;
import co.zerono.mco.item.ItemDust;
import co.zerono.mco.item.ItemIngot;
import co.zerono.mco.item.ItemMCO;
import co.zerono.mco.item.ItemNugget;
import co.zerono.mco.item.ItemPlaceHolder;
import co.zerono.mco.item.ItemSpecialDust;
import co.zerono.mco.item.ItemSpecialIngot;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems 
{
	public static  ItemMCO itemPlaceHolder = new ItemPlaceHolder();
	public static void preInit()
	{
		if(Settings.Master.GEN_INGOTS)
		{
			for(ItemIngot itemIngot : Reference.INGOT_LIST)
			{
				GameRegistry.registerItem(itemIngot, itemIngot.getOreDictName());
			}
			for(ItemSpecialIngot specialIngot : Reference.SPECIAL_INGOT)
			{
				GameRegistry.registerItem(specialIngot, specialIngot.getOreDictName());
			}
		}
		if(Settings.Master.GEN_NUGGETS || Settings.Master.GEN_POOR)
		{
			for(ItemNugget itemNugget : Reference.NUGGET_LIST)
			{
				GameRegistry.registerItem(itemNugget, itemNugget.getOreDictName());
			}
		}
		if(Settings.Master.GEN_DUSTS)
		{
			for(ItemDust itemDust : Reference.DUST_LIST)
			{
				GameRegistry.registerItem(itemDust, itemDust.getOreDictName());
			}
			for(ItemSpecialDust specialDust : Reference.SPECIAL_DUST)
			{
				GameRegistry.registerItem(specialDust, specialDust.getOreDictName());
			}
		}
		if(Settings.Master.GEN_TINY_DUST)
		{
			for(ItemDust itemTinyDust : Reference.TINY_DUST_LIST)
			{
				GameRegistry.registerItem(itemTinyDust, itemTinyDust.getOreDictName());
			}
		}
	}
	public static void init()
	{
		if(Settings.Master.GEN_INGOTS)
		{
			for(ItemIngot itemIngot : Reference.INGOT_LIST)
			{
				itemIngot.registerOreDict();
				itemIngot.registerCrafting();
				itemIngot.registerSmelting();
			}
			for(ItemSpecialIngot specialIngot : Reference.SPECIAL_INGOT)
			{
				specialIngot.registerOreDict();
				specialIngot.registerCrafting();
			}
		}
		if(Settings.Master.GEN_NUGGETS || Settings.Master.GEN_POOR)
		{
			for(ItemNugget itemNugget : Reference.NUGGET_LIST)
			{
				itemNugget.registerOreDict();
				itemNugget.registerCrafting();
				itemNugget.registerSmelting();
			}
		}
		if(Settings.Master.GEN_DUSTS)
		{
			for(ItemDust itemDust : Reference.DUST_LIST)
			{
				itemDust.registerOreDict();
				itemDust.registerCrafting();
				itemDust.registerSmelting();
			}
			for(ItemSpecialDust specialDust : Reference.SPECIAL_DUST)
			{
				specialDust.registerOreDict();
				specialDust.registerCrafting();
				specialDust.registerSmelting();
			}
		}
		if(Settings.Master.GEN_TINY_DUST)
		{
			for(ItemDust itemTinyDust : Reference.TINY_DUST_LIST)
			{
				itemTinyDust.registerOreDict();
				itemTinyDust.registerCrafting();
				itemTinyDust.registerSmelting();
			}
		}
	}
}
