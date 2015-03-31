package co.zerono.mco.worldgen;

import java.util.Random;

import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator
{
	private static Random rand = new Random();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
			default:
				generateDim(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z)
	{
		
	}
	private void generateNether(World world, Random random, int x,int z)
	{
		
	}
	private void generateDim(World world, Random random, int x, int z)
	{
		if(Settings.Master.GEN_ORE)
		{
			for(BlockOre blockOre : Reference.ORE_LIST)
			{
				this.addOreSpawn(blockOre, world, random, x, z, 16, 16, blockOre.getOrePerVein(), blockOre.getChunkChance(), blockOre.getMinY(), blockOre.getMaxY());
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for(BlockOre blockOre : Reference.ORE_DENSE_LIST)
			{
				this.addOreSpawn(blockOre, world, random, x, z, 16, 16, blockOre.getOrePerVein(), blockOre.getChunkChance(), blockOre.getMinY(), blockOre.getMaxY());
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for(BlockOre blockOre : Reference.ORE_POOR_LIST)
			{
				this.addOreSpawn(blockOre, world, random, x, z, 16, 16, blockOre.getOrePerVein(), blockOre.getChunkChance(), blockOre.getMinY(), blockOre.getMaxY());
			}
		}
	}
	public void addOreSpawn(BlockOre blockOre, World world, Random random, int xPos, int zPos, int maxX, int maxZ, int orePerVein, int chunkChance, int minY, int maxY)
	{
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int difMinMaxY = maxY - minY;
		for (int x = 0; x < chunkChance; x++)
		{
			int posX = xPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(difMinMaxY);
			int posZ = zPos + random.nextInt(maxZ);
			(new WorldGenMinable(blockOre, orePerVein)).generate(world, random, posX, posY, posZ);
		}
	}
}
