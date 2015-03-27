package co.zerono.mco.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.DustTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDust extends ItemMCO
{
	private String dustName;
	private String oreName;
	private String underlyingHex;
	private String oreDictName;
	private int cookTime;
	private float smeltingXP;
	private ItemIngot itemIngot;
	private boolean isTiny;
	private ItemNugget itemNugget;
	
	public ItemDust(String oreName, String underlyingHex, int cookTime, float smeltingXP, ItemIngot itemIngot, boolean isTiny, ItemNugget itemNugget)
	{
		super();
		this.setMaxStackSize(64);
		this.setOreName(WordUtils.capitalizeFully(oreName));
		this.setDustName((isTiny ? "tinyDust" : "dust") + getOreName());
		this.setUnderlyingHex(underlyingHex);
		this.setOreDictName(getDustName());
		this.setUnlocalizedName(getOreDictName());
		this.setItemIngot(itemIngot);
		this.setCookTime(cookTime);
		this.setSmeltingXP(smeltingXP);
		this.setIsTiny(isTiny);
		this.setItemNugget(itemNugget);
	}
	
	public void registerSmelting()
	{
		if(Settings.Master.ADD_SMELTING)
		{
			if(isTiny)
			{
				GameRegistry.addSmelting(this, new ItemStack(getItemNugget()), smeltingXP);
			}
			else
			{
				GameRegistry.addSmelting(this, new ItemStack(getItemIngot()), smeltingXP);
			}
		}
	}
	public void registerCrafting()
	{
		if(Settings.Master.ADD_CRAFTING)
		{
			if(!isTiny)
			{
				GameRegistry.addRecipe(new ShapedOreRecipe(this, "ttt","ttt","ttt",'t',"tinyDust" + getOreName()));
			}
		}
	}
	public void registerOreDict()
	{
		OreDictionary.registerOre(getOreDictName(), this);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		if(iconRegister instanceof TextureMap)
		{
			TextureMap mp = (TextureMap) iconRegister;
			String name = Textures.RESOURCE_PREFIX + getOreDictName();
			
			TextureAtlasSprite texture = mp.getTextureExtry(name);
			if(texture == null)
			{
				texture = new DustTexture(this);
				if(!mp.setTextureEntry(name, texture))
				{
					LogHelper.error(getOreDictName() + ": Could not add texture after creation!");
				}
			}
			itemIcon = mp.getTextureExtry(name);
		}
	}
	public String getDustName()
	{
		return dustName;
	}
	public void setDustName(String dustName)
	{
		this.dustName = dustName;
	}
	public String getOreName()
	{
		return oreName;
	}
	public void setOreName(String oreName)
	{
		this.oreName = oreName;
	}
	public String getUnderlyingHex()
	{
		return underlyingHex;
	}
	public void setUnderlyingHex(String underlyingHex)
	{
		this.underlyingHex = underlyingHex;
	}
	public String getOreDictName()
	{
		return oreDictName;
	}
	public void setOreDictName(String oreDictName)
	{
		this.oreDictName = oreDictName;
	}
	public int getCookTime()
	{
		return cookTime;
	}
	public void setCookTime(int cookTime)
	{
		this.cookTime = cookTime;
	}
	public float getSmeltingXP()
	{
		return smeltingXP;
	}
	public void setSmeltingXP(float smeltingXP)
	{
		this.smeltingXP = smeltingXP;
	}
	public ItemIngot getItemIngot()
	{
		return itemIngot;
	}
	public void setItemIngot(ItemIngot itemIngot)
	{
		this.itemIngot = itemIngot;
	}
	public boolean getIsTiny()
	{
		return isTiny;
	}
	public void setIsTiny(boolean isTiny)
	{
		this.isTiny = isTiny;
	}
	public ItemNugget getItemNugget()
	{
		return itemNugget;
	}
	public void setItemNugget(ItemNugget itemNugget)
	{
		this.itemNugget = itemNugget;
	}
}
