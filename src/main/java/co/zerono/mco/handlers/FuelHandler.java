package co.zerono.mco.handlers;

import co.zerono.mco.item.ItemIngot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if(fuel.getItem() instanceof ItemIngot)
		{
			ItemIngot ingot = (ItemIngot) fuel.getItem();
			return ingot.getCookTime();
		}
		/*else if(fuel.getItem() instanceof ItemDust)
		{
			ItemDust dust = (ItemDust) fuel.getItem();
			return dust.getCookTime();
		}
		else if(fuel.getItem() instanceof ItemNugget)
		{
			ItemNugget nugget = (ItemNugget) fuel.getItem();
			return nugget.getCookTime();
		}
		else if(fuel.getItem() instanceof ItemSmallDust)
		{
			ItemSmallDust smallDust = (ItemSmallDust) fuel.getItem();
			return smallDust.getCookTime();
		}
		*/
		else
		{
			return 0;
		}
	}
}
