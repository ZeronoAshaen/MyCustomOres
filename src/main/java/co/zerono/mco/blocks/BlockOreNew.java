package co.zerono.pc.blocks;

import java.util.Random;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.pc.creativeTab.CreativeTabPC;
import co.zerono.pc.reference.Reference;
import co.zerono.pc.reference.Textures;
import co.zerono.pc.utility.LogHelper;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockOreNew extends BlockPC
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
	
	public BlockOreNew(String oreName, String oreType, String underlyingHex, String toolClass, Integer harvestLevel, Integer oreXP, Integer chunkChance, Integer maxY, Integer minY, Integer orePerVein, Integer veinsPerChunk, Float hardness, Float resistance)
	{
		super(Material.rock);
		setBlockName("ore" + oreType + WordUtils.capitalizeFully(oreName));
		setName(oreName);
		setUnderlyingHex(underlyingHex);
		setOreDictName("ore" + oreType + oreName);
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
		this.setHardness(getHardness());
		this.setResistance(getResistance());
		this.setHarvestLevel(getToolClass(), getHarvestLevel());
		this.setCreativeTab(CreativeTabPC.PC_ORE_TAB);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
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
		texture = new GetTexture(this);
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
	public BlockPC setBlockName(String unlocalizedName)
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
}
