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
	@Override
	public void generate(Random random, int cX, int cZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		
	}
	
	private void generateOre(Random random, int cX, int cZ, World world)
	{
		for(BlockOre blockOre : Reference.ORE_LIST)
		{
			addOreSpawn(blockOre, world, random, cX, cZ, blockOre.getOrePerVein(), blockOre.getChunkChance(), blockOre.getMinY(), blockOre.getMaxY());
			
		}
	}
	
	public void addOreSpawn(BlockOre blockOre, World world, Random random, int blockPosX, int blockPosZ, int orePerVein, int chunkChance, int minY, int maxY)
	{
		int oreMin = (orePerVein == 2) ? 1 : orePerVein;
		int oreMax = orePerVein;

		for(int i=0; i<chunkChance; i++)
		{
			int posX = blockPosX + random.nextInt(16);
			int posZ = blockPosZ + random.nextInt(16);
			int posY = minY + random.nextInt(16);
			new WorldGenMinable(blockOre, (oreMin + random.nextInt(oreMax - oreMin)), Blocks.stone).generate(world, random, posX, posY, posZ);
		}
	}
	
	private void generateNether(Random random, int cX, int cZ, World world)
	{
		// TODO
	}
	
	private void generateEnd(Random random, int cX, int cZ, World world)
	{
		// TODO
	}
	
	private void generateSurface(Random random, int cX, int cZ, World world)
	{
		
	}
	
	
}
