package co.zerono.mco.reference;

import java.util.LinkedList;

import co.zerono.mco.blocks.BlockAlloy;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.item.ItemDust;
import co.zerono.mco.item.ItemIngot;
import co.zerono.mco.item.ItemNugget;

public class Reference 
{
	public static final String MOD_ID = "MCO";
	public static final String LOWERCASE_MOD_ID = MOD_ID.toLowerCase();
	public static final String MOD_NAME = "My Custom Ores";
	public static final String FINGERPRINT = "@FINGERPRINT@";
	public static final String VERSION = "@VERSION@";
	public static final String SERVER_PROXY_CLASS = "co.zerono.mco.proxy.ServerProxy";
	public static final String CLIENT_PROXY_CLASS = "co.zerono.mco.proxy.ClientProxy";
	public static final String GUI_FACTORY_CLASS = "co.zerono.mco.client.GuiFactory";
	
	public static LinkedList<BlockOre> ORE_LIST = new LinkedList<BlockOre>();
	public static LinkedList<BlockOre> ORE_DENSE_LIST = new LinkedList<BlockOre>();
	public static LinkedList<BlockOre> ORE_POOR_LIST = new LinkedList<BlockOre>();
	public static LinkedList<BlockAlloy> BLOCK_ALLOY_LIST = new LinkedList<BlockAlloy>();
	public static LinkedList<ItemIngot> INGOT_LIST = new LinkedList<ItemIngot>();
	public static LinkedList<ItemDust> DUST_LIST = new LinkedList<ItemDust>();
	public static LinkedList<ItemNugget> NUGGET_LIST = new LinkedList<ItemNugget>();
	public static LinkedList<ItemDust> TINY_DUST_LIST = new LinkedList<ItemDust>();
	
}
