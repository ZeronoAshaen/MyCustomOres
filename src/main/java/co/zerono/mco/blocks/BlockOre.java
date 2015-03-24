package co.zerono.mco.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.creativeTab.CreativeTabMCO;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.textures.RawOreTexture;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
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
	private BlockOre baseBlock;
	
	public BlockOre(String oreName, String oreType, String underlyingHex, String toolClass, Integer harvestLevel, Integer oreXP, Integer chunkChance, Integer maxY, Integer minY, Integer orePerVein, Integer veinsPerChunk, Float hardness, Float resistance, Float lightLevel, BlockOre baseBlock)
	{
		super(Material.rock);
		setBaseBlock(baseBlock);
		String thisOreType = (oreType == null) ? "" : oreType;
		setOreType(thisOreType);
		setBlockName("ore" + WordUtils.capitalizeFully(getOreType()) + WordUtils.capitalizeFully(oreName));
		setOreName(oreName);
		setUnderlyingHex(underlyingHex);
		setOreDictName("ore" + WordUtils.capitalizeFully(getOreType()) + WordUtils.capitalizeFully(oreName));
		setToolClass(toolClass);
		setHarvestLevel(harvestLevel);
		setOreXP(oreXP);
		setChunkChance(chunkChance);
		setMaxY(maxY);
		setMinY(minY);
		setOrePerVein(orePerVein);
		setVeinsPerChunk(veinsPerChunk);
		setOreHardness(hardness);
		setOreResistance(resistance);
		setLight(lightLevel);
		this.setHardness(getOreHardness());
		this.setResistance(getOreResistance());
		this.setHarvestLevel(getToolClass(), getHarvestLevel());
		this.setCreativeTab(CreativeTabMCO.MCO_ORE_TAB);
		this.setLightLevel(getLight());
	}
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		
		if(getOreType().length() == 5)
		{
			Random ran = new Random();
			int dropAmt = 2;
			if(fortune>0)
			{
				dropAmt = ran.nextInt(fortune + 2) - 1;
				if(dropAmt<2)
				{
					dropAmt = 2;
				}
			}
			for(int i=0; i<dropAmt; i++)
			{
				ret.addAll(baseBlock.getDrops(world, x, y, z, meta, fortune));
			}
		}
		else
		{
			ret.add(new ItemStack(this));
		}
		
		return ret;
	}
	/*@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		if(getOreType().toLowerCase() == "dense")
		{
			return Item.getItemFromBlock(baseBlock);
		}
		else
		{
			return Item.getItemFromBlock(this);
		}
	}*/
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
					LogHelper.error(getOreName() + ": Could not add texture after creation!");
				}
			}
			blockIcon = mp.getTextureExtry(oreName);
		}
	}
	public BlockOre getBaseBlock()
	{
		return baseBlock;
	}
	public void setBaseBlock(BlockOre baseBlock)
	{
		this.baseBlock = baseBlock;
	}
	public Float getLight()
	{
		return lightLevel;
	}
	public void setLight(Float lightLevel)
	{
		this.lightLevel = lightLevel;
	}
	public Float getOreResistance()
	{
		return resistance;
	}
	public void setOreResistance(Float resistance)
	{
		this.resistance = resistance;
	}
	public Float getOreHardness()
	{
		return hardness;
	}
	public void setOreHardness(Float hardness)
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
		super.setBlockName(unlocalizedName);
		return this;
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
