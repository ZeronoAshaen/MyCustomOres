package co.zerono.mco.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.creativeTab.CreativeTabMCO;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.SpecialAlloyTexture;
import co.zerono.mco.utility.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpecialAlloy extends BlockMCO
{
	private String oreName;
	private String alloyName;
	private String underlyingHex;
	private String oreDictName;
	private String toolClass;
	private Integer harvestLevel;
	private Float hardness;
	private Float resistance;
	private Float lightLevel;

	public BlockSpecialAlloy(String oreName, String underlyingHex, int harvestLevel, float hardness, float resistance, float lightLevel)
	{
		super(Material.iron);
		setOreName(oreName);
		setAlloyName("block" + WordUtils.capitalizeFully(getOreName()));
		setUnderlyingHex(underlyingHex);
		setOreDictName(getAlloyName());
		setAlloyToolClass("pickaxe");
		setAlloyHarvestLevel(harvestLevel);
		setAlloyHardness(hardness);
		setAlloyResistance(resistance);
		setAlloyLightLevel(lightLevel);
		setBlockName(getOreDictName());
		this.setHardness(getAlloyHardness());
		this.setResistance(getAlloyResistance());
		this.setHarvestLevel(getAlloyToolClass(), getAlloyHarvestLevel());
		this.setCreativeTab(CreativeTabMCO.MCO_ITEMS_TAB);
		this.setLightLevel(getAlloyLightLevel());
	}
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		if(iconRegister instanceof TextureMap)
		{
			TextureMap mp = (TextureMap) iconRegister;
			
			String alloyName = Textures.RESOURCE_PREFIX + getOreDictName();
			
			TextureAtlasSprite texture = mp.getTextureExtry(alloyName);
			if(texture == null)
			{
				texture = new SpecialAlloyTexture(this);
				if(!mp.setTextureEntry(alloyName, texture))
				{
					LogHelper.error(getOreDictName() + ": Coult not add texture after creation!");
				}
			}
			blockIcon = mp.getTextureExtry(alloyName);
		}
	}
	@Override
	public BlockMCO setBlockName (String unlocalizedName)
	{
		super.setBlockName(unlocalizedName);
		return this;
	}
	public void registerOreDict()
	{
		OreDictionary.registerOre(getOreDictName(), this);
	}
	public void registerCrafting()
	{
		if(Settings.Master.ADD_CRAFTING)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(this, "iii","iii","iii",'i',"ingot" + getOreName()));
		}
	}
	public String getOreName()
	{
		return oreName;
	}
	public void setOreName(String oreName)
	{
		this.oreName = oreName;
	}
	public String getAlloyName()
	{
		return alloyName;
	}
	public void setAlloyName(String alloyName)
	{
		this.alloyName = alloyName;
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
	public String getAlloyToolClass()
	{
		return toolClass;
	}
	public void setAlloyToolClass(String toolClass)
	{
		this.toolClass = toolClass;
	}
	public int getAlloyHarvestLevel()
	{
		return harvestLevel;
	}
	public void setAlloyHarvestLevel(int harvestLevel)
	{
		this.harvestLevel = harvestLevel;
	}
	public float getAlloyHardness()
	{
		return hardness;
	}
	public void setAlloyHardness(float hardness)
	{
		this.hardness = hardness;
	}
	public float getAlloyResistance()
	{
		return resistance;
	}
	public void setAlloyResistance(float resistance)
	{
		this.resistance = resistance;
	}
	public float getAlloyLightLevel()
	{
		return lightLevel;
	}
	public void setAlloyLightLevel(float lightLevel)
	{
		this.lightLevel = lightLevel;
	}
}
