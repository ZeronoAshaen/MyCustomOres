package co.zerono.mco.item;

import org.apache.commons.lang3.text.WordUtils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.NuggetTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNugget extends ItemMCO
{
	private String nuggetName;
	private String oreName;
	private String underlyingHex;
	private String oreDictName;
	private int cookTime;
	private float smeltingXP;
	private BlockOre blockOre;
	
	public ItemNugget(String oreName, String underlyingHex, int cookTime, BlockOre blockOre, float smeltingXP)
	{
		super();
		this.setMaxStackSize(64);
		this.setOreName(WordUtils.capitalizeFully(oreName));
		this.setNuggetName("nugget" + getOreName());
		this.setUnderlyingHex(underlyingHex);
		this.setOreDictName(getNuggetName());
		this.setUnlocalizedName(getOreDictName());
		this.setBlockOre(blockOre);
		this.setCookTime(cookTime);
		this.setSmeltingXP(smeltingXP);
	}
	public void registerSmelting()
	{
		if(Settings.Master.ADD_SMELTING)
		{
			GameRegistry.addSmelting(this.getBlockOre(), new ItemStack(this), this.smeltingXP);
		}
	}
	public void registerCrafting()
	{
		if(Settings.Master.ADD_CRAFTING)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 9), "ingot" + getOreName()));
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
				texture = new NuggetTexture(this);
				if(!mp.setTextureEntry(name, texture))
				{
					LogHelper.error(getOreDictName() + ": Could not add texture after creation!");
				}
			}
			itemIcon = mp.getTextureExtry(name);
		}
	}
	public String getNuggetName()
	{
		return nuggetName;
	}
	public void setNuggetName(String nuggetName)
	{
		this.nuggetName = nuggetName;
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
	public BlockOre getBlockOre()
	{
		return blockOre;
	}
	public void setBlockOre(BlockOre blockOre)
	{
		this.blockOre = blockOre;
	}
}
