package co.zerono.mco.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.creativeTab.CreativeTabMCO;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.RawOreTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre extends BlockMCO
{
	private String oreName;
	private String oreType;
	private String underlyingHex;
	private String oreDictName;
	private String toolClass;
	private Integer harvestLevel;
	private Integer oreXP;
	private Integer chunkChance;
	private Integer maxY;
	private Integer minY;
	private Integer orePerVein;
	private Integer veinsPerChunk;
	private Float hardness;
	private Float resistance;
	private Float lightLevel;
	boolean initSmelt = false;
	private ItemStack smelt;
	
	public BlockOre(String oreName, String oreType, String underlyingHex, String toolClass, Integer harvestLevel, Integer oreXP, Integer chunkChance, Integer maxY, Integer minY, Integer orePerVein, Integer veinsPerChunk, Float hardness, Float resistance, Float lightLevel)
	{
		super(Material.rock);
		if(oreType == null)
		{
			setBlockName("ore");
			setBlockName("ore"+ WordUtils.capitalizeFully(oreName));
			setOreType("");
		}
		else
		{
			setBlockName("ore" + oreType + WordUtils.capitalizeFully(oreName));
			setOreType(oreType);
		}
		setName(oreName);
		setUnderlyingHex(underlyingHex);
		if (oreType == null)
		{
			setOreDictName("ore" + oreName);
		}
		else
		{
			setOreDictName("ore" + oreType + oreName);
		}
		setToolClass(toolClass);
		setHarvestLevel(harvestLevel);
		setOreXP(oreXP);
		setChunkChance(chunkChance);
		setMaxY(maxY);
		setMinY(minY);
		setOrePerVein(orePerVein);
		setVeinsPerChunk(veinsPerChunk);
		setHardness(hardness);
		setResistance(resistance);
		setLight(lightLevel);
		this.setHardness(getHardness());
		this.setResistance(getResistance());
		this.setHarvestLevel(getToolClass(), getHarvestLevel());
		this.setCreativeTab(CreativeTabMCO.MCO_ORE_TAB);
		this.setLightLevel(getLight());
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
		if (iconRegister instanceof TextureMap)
		{
			TextureMap mp = (TextureMap) iconRegister;
			
			String oreName = Textures.RESOURCE_PREFIX + getOreDictName();
			
			TextureAtlasSprite texture = mp.getTextureExtry(oreName);
			if (texture == null)
			{
				texture = new RawOreTexture(this);
				if (!mp.setTextureEntry(oreName, texture))
				{
					LogHelper.error(getName() + ": Could not add texture after creation!");
				}
			}
			blockIcon = mp.getTextureExtry(oreName);
		}
	}
	public Float getLight()
	{
		return lightLevel;
	}
	public void setLight(Float lightLevel)
	{
		this.lightLevel = lightLevel;
	}
	public Float getResistance()
	{
		return resistance;
	}
	public void setResistance(Float resistance)
	{
		this.resistance = resistance;
	}
	public Float getHardness()
	{
		return hardness;
	}
	public void setHardness(Float hardness)
	{
		this.hardness = hardness;
	}
	public Integer getVeinsPerChunk()
	{
		return veinsPerChunk;
	}
	public void setVeinsPerChunk(Integer veinsPerChunk)
	{
		this.veinsPerChunk = veinsPerChunk;
	}
	public Integer getOrePerVein()
	{
		return orePerVein;
	}
	public void setOrePerVein(Integer orePerVein)
	{
		this.orePerVein = orePerVein;
	}
	public Integer getMinY()
	{
		return minY;
	}
	public void setMinY(Integer minY)
	{
		this.minY = minY;
	}
	public Integer getMaxY()
	{
		return maxY;
	}
	public void setMaxY(Integer maxY)
	{
		this.maxY = maxY;
	}
	public Integer getChunkChance()
	{
		return chunkChance;
	}
	public void setChunkChance(Integer chunkChance)
	{
		this.chunkChance = chunkChance;
	}
	public Integer getOreXP()
	{
		return oreXP;
	}
	public void setOreXP(Integer oreXP)
	{
		this.oreXP = oreXP;
	}
	public Integer getHarvestLevel()
	{
		return harvestLevel;
	}
	public void setHarvestLevel(Integer harvestLevel)
	{
		this.harvestLevel = harvestLevel;
	}
	public String getToolClass()
	{
		return toolClass;
	}
	public void setToolClass(String toolClass)
	{
		this.toolClass = toolClass;
	}
	public String getOreDictName()
	{
		return oreDictName;
	}
	public void setOreDictName(String oreDictName)
	{
		this.oreDictName = oreDictName;
	}
	@Override
	public BlockMCO setBlockName(String unlocalizedName)
	{
		super.setBlockName(Textures.RESOURCE_PREFIX + unlocalizedName);
		return this;
	}
	public String getName()
	{
		return oreName;
	}
	public void setName(String oreName)
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
	public String getOreType()
	{
		return oreType;
	}
	public void setOreType(String oreType)
	{
		this.oreType = oreType;
	}
	public void registerOreDict()
	{
		OreDictionary.registerOre(getOreDictName(), this);
	}
	
	
}
