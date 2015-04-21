package co.zerono.mco.item;

import org.apache.commons.lang3.text.WordUtils;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import co.zerono.mco.blocks.BlockSpecialAlloy;
import co.zerono.mco.creativeTab.CreativeTabMCO;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.SpecialIngotTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpecialIngot extends ItemMCO
{
	private String ingotName;
	private String oreName;
	private String underlyingHex;
	private String oreDictName;
	private BlockSpecialAlloy alloyBlock;
	
	public ItemSpecialIngot(String oreName, String underlyingHex, BlockSpecialAlloy alloyBlock)
	{
		super();
		setOreName(WordUtils.capitalizeFully(oreName));
		setIngotName("ingot" + getOreName());
		setOreDictName(getIngotName());
		setUnlocalizedName(getOreDictName());
		setAlloyBlock(alloyBlock);
		setCreativeTab(CreativeTabMCO.MCO_ITEMS_TAB);
		setUnderlyingHex(underlyingHex);
	}
	
	public String getIngotName()
	{
		return ingotName;
	}
	public void setIngotName(String ingotName)
	{
		this.ingotName = ingotName;
	}
	public String getOreName()
	{
		return oreName;
	}
	public void setOreName(String oreName)
	{
		this.oreName = oreName;
	}
	public BlockSpecialAlloy getAlloyBlock()
	{
		return alloyBlock;
	}
	public void setAlloyBlock(BlockSpecialAlloy alloyBlock)
	{
		this.alloyBlock = alloyBlock;
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
	public void registerCrafting()
	{
		if(Settings.Master.ADD_CRAFTING)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 9), "block" + getOreName()));
			GameRegistry.addRecipe(new ShapedOreRecipe(this, "nnn","nnn","nnn",'n', "nugget" + getOreName()));
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		if (iconRegister instanceof TextureMap)
		{
			TextureMap mp = (TextureMap) iconRegister;
			String name = Textures.RESOURCE_PREFIX + getOreDictName();
			
			TextureAtlasSprite texture = mp.getTextureExtry(name);
			if (texture == null)
			{
				texture = new SpecialIngotTexture(this);
				if(!mp.setTextureEntry(name, texture))
				{
					LogHelper.error(getOreDictName() + ": Could not add texture after creation!");
				}
			}
			itemIcon = mp.getTextureExtry(name);
		}
	}
	public void registerOreDict()
	{
		OreDictionary.registerOre(getOreDictName(), this);
	}
}
