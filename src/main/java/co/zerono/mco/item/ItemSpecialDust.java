package co.zerono.mco.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.SpecialDustTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpecialDust extends ItemMCO
{
	private String dustName;
	private String oreName;
	private String underlyingHex;
	private String oreDictName;
	private String dustAName;
	private int amountA;
	private String dustBName;
	private int amountB;
	private String dustCName;
	private int amountC;
	private int cookTime;
	private float smeltingXP;
	private ItemSpecialIngot combinedIngot;
	private int producedAmount;
	private String[] allDust;
	
	public ItemSpecialDust(String oreName, String underlyingHex, int cookTime, float smeltingXP, ItemSpecialIngot combinedIngot, int producedAmount, String dustAName, int amountA, String dustBName, int amountB, String dustCName, int amountC)
	{
		super();
		setMaxStackSize(64);
		setOreName(WordUtils.capitalizeFully(oreName));
		setDustName("dust"+getOreName());
		setUnderlyingHex(underlyingHex);
		setOreDictName(getDustName());
		setCombinedIngot(combinedIngot);
		setCookTime(cookTime);
		setSmeltingXP(smeltingXP);
		setProducedAmount(producedAmount);
		setDustAName((amountA>0) ? WordUtils.capitalizeFully(dustAName) : null);
		setDustBName((amountB>0) ? WordUtils.capitalizeFully(dustBName) : null);
		setDustCName((amountC>0) ? WordUtils.capitalizeFully(dustCName) : null);
		setDustAAmount(amountA);
		setDustBAmount(amountB);
		setDustCAmount(amountC);
		setAllDusts(getDustAName(), getDustAAmount(), getDustBName(), getDustBAmount(), getDustCName(), getDustCAmount());
		this.setUnlocalizedName(getOreDictName());
	}
	public ItemSpecialDust(String oreName, String underlyingHex, int cookTime, float smeltingXP, ItemSpecialIngot specialIngot, int producedAmount, String dustAName, int amountA, String dustBName, int amountB)
	{
		this(oreName, underlyingHex, cookTime, smeltingXP, specialIngot, producedAmount, dustAName, amountA, dustBName, amountB, null, 0);
	}
	public void registerSmelting()
	{
		if(Settings.Master.ADD_SMELTING)
		{
			GameRegistry.addSmelting(this, new ItemStack(getCombinedIngot()), smeltingXP);
		}
	}
	public void registerCrafting()
	{
		String[] allDusts = getAllDusts();
		switch (allDusts.length)
		{
			case 1: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0]));
			break;
			case 2: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1]));
			break;
			case 3: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2]));
			break;
			case 4: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3]));
			break;
			case 5: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3], allDusts[4]));
			break;
			case 6: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3], allDusts[4], allDusts[5]));
			break;
			case 7: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3], allDusts[4], allDusts[5], allDusts[6]));
			break;
			case 8: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3], allDusts[4], allDusts[5], allDusts[6], allDusts[7]));
			break;
			case 9: GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, getProducedAmount()), allDusts[0], allDusts[1], allDusts[2], allDusts[3], allDusts[4], allDusts[5], allDusts[6], allDusts[7], allDusts[8]));
			break;
			default: LogHelper.error("Invalid Recipe for " + getOreDictName());
			break;
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
				texture = new SpecialDustTexture(this);
				if(!mp.setTextureEntry(name, texture))
				{
					LogHelper.error(getOreDictName() + ": Could not add texture after creation!");
				}
			}
			itemIcon = mp.getTextureExtry(name);
		}
	}
	public String[] getAllDusts()
	{
		return allDust;
	}
	public void setAllDusts(String dustA, int amountA, String dustB, int amountB, String dustC, int amountC)
	{
		String[] allDusts = new String[amountA+amountB];
		if(amountA>0)
		{
			for(int i=0; i<amountA; i++)
			{
				allDusts[i] = "dust" + WordUtils.capitalizeFully(dustA);
			}
		}
		if(amountB>0)
		{
			for(int i=amountA; i<amountA+amountB; i++)
			{
				allDusts[i] = "dust" + WordUtils.capitalizeFully(dustB);
			}
		}
		if(amountC>0)
		{
			for(int i=(amountA+amountB);i<(amountA+amountB+amountC);i++)
			{
				allDusts[i] = "dust" + WordUtils.capitalizeFully(dustC);
			}
		}
		this.allDust = allDusts;
	}
	public int getProducedAmount()
	{
		return producedAmount;
	}
	public void setProducedAmount(int producedAmount)
	{
		this.producedAmount = producedAmount;
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
	public String getDustAName()
	{
		return dustAName;
	}
	public void setDustAName(String dustAName)
	{
		this.dustAName = dustAName;
	}
	public int getDustAAmount()
	{
		return amountA;
	}
	public void setDustAAmount(int dustAAmount)
	{
		this.amountA = dustAAmount;
	}
	public String getDustBName()
	{
		return dustBName;
	}
	public void setDustBName(String dustBName)
	{
		this.dustBName = dustBName;
	}
	public int getDustBAmount()
	{
		return amountB;
	}
	public void setDustBAmount(int dustBAmount)
	{
		this.amountB = dustBAmount;
	}
	public String getDustCName()
	{
		return dustCName;
	}
	public void setDustCName(String dustCName)
	{
		this.dustCName = dustCName;
	}
	public int getDustCAmount()
	{
		return amountC;
	}
	public void setDustCAmount(int amountC)
	{
		this.amountC = amountC;
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
	public ItemSpecialIngot getCombinedIngot()
	{
		return combinedIngot;
	}
	public void setCombinedIngot(ItemSpecialIngot combinedIngot)
	{
		this.combinedIngot = combinedIngot;
	}
}
