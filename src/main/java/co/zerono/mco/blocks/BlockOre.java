package co.zerono.pc.blocks;

import java.util.List;
import java.util.Random;

import co.zerono.pc.helpers.RegisterHelpers;
import co.zerono.pc.reference.Names;
import co.zerono.pc.reference.Settings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre extends BlockPC
{
	@SideOnly(Side.CLIENT)
	private IIcon texture;
	
	public BlockOre()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		for (int i=0; i<Settings.Ore.ORE_NAMES.length; i++)
		{
			if(this.getUnlocalizedName().substring(3) == Settings.Ore.ORE_NAMES[i])
			{
				this.setHarvestLevel(RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i));
			}
			else if (this.getUnlocalizedName().substring(7) == Settings.Ore.ORE_NAMES[i])
			{
				this.setHarvestLevel(RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i));
			}
			else if (this.getUnlocalizedName().substring(8) == Settings.Ore.ORE_NAMES[i])
			{
				this.setHarvestLevel(RegisterHelpers.getToolClass(i), RegisterHelpers.getHarvestLevel(i));
			}
			else
			{
				this.setHarvestLevel("pickaxe", 1);
			}
		}
	}
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		texture = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_texture");
	}
}
