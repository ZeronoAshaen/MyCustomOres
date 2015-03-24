package co.zerono.mco.blocks;

import java.util.Random;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.creativeTab.CreativeTabMCO;
import co.zerono.mco.item.ItemIngot;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.AlloyTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class BlockAlloy extends BlockMCO 
{
	private String alloyName;
	private String underlyingHex;
	private String oreDictName;
	private String toolClass;
	private Integer harvestLevel;
	private Float hardness;
	private Float resistance;
	private Float lightLevel;
	private BlockOre baseOre;
	
	public BlockAlloy(BlockOre baseOre, ItemIngot itemIngot)
	{
		super(Material.iron);
		setBaseOre(baseOre);
		setAlloyName(baseOre.getOreName());
		setUnderlyingHex(baseOre.getUnderlyingHex());
		setOreDictName("block" + WordUtils.capitalizeFully(getAlloyName()));
		setAlloyToolClass(baseOre.getToolClass());
		setAlloyHarvestLevel(baseOre.getHarvestLevel());
		setAlloyHardness(baseOre.getOreHardness());
		setAlloyResistance(baseOre.getOreResistance());
		setAlloyLightLevel(baseOre.getLight());
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
				texture = new AlloyTexture(this);
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
			GameRegistry.addRecipe(new ShapedOreRecipe(this, "iii","iii","iii",'i',"ingot" + getAlloyName()));
		}
	}
	public BlockOre getBaseOre()
	{
		return baseOre;
	}
	public void setBaseOre(BlockOre baseOre)
	{
		this.baseOre = baseOre;
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
	public Integer getAlloyHarvestLevel()
	{
		return harvestLevel;
	}
	public void setAlloyHarvestLevel(Integer harvestLevel)
	{
		this.harvestLevel = harvestLevel;
	}
	public Float getAlloyHardness()
	{
		return hardness;
	}
	public void setAlloyHardness(Float hardness)
	{
		this.hardness = hardness;
	}
	public Float getAlloyResistance()
	{
		return resistance;
	}
	public void setAlloyResistance(Float resistance)
	{
		this.resistance = resistance;
	}
	public Float getAlloyLightLevel()
	{
		return lightLevel;
	}
	public void setAlloyLightLevel(Float lightLevel)
	{
		this.lightLevel = lightLevel;
	}
}
