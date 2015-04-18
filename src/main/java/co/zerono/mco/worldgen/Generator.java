package co.zerono.mco.worldgen;

import java.util.Random;

import co.zerono.mco.blocks.BlockOre;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int cX, int cZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		Chunk chunk = world.getChunkFromBlockCoords(cX, cZ);
		if(Settings.Master.GEN_ORE)
		{
			for (BlockOre blockOre : Reference.ORE_LIST)
			{
				if(blockOre.getVeinsPerChunk() !=0 && blockOre.getMaxY() != 0 && blockOre.getOrePerVein() != 0)
				{
					genOre(blockOre, random, world, cX, cZ);
				}
			}
		}
		if(Settings.Master.GEN_POOR)
		{
			for(BlockOre blockOre : Reference.ORE_POOR_LIST)
			{
				if(blockOre.getVeinsPerChunk() !=0 && blockOre.getMaxY() != 0 && blockOre.getOrePerVein() != 0)
				{
					genOre(blockOre, random, world, cX, cZ);
				}
			}
		}
		if(Settings.Master.GEN_DENSE)
		{
			for(BlockOre blockOre : Reference.ORE_DENSE_LIST)
			{
				if(blockOre.getVeinsPerChunk() !=0 && blockOre.getMaxY() != 0 && blockOre.getOrePerVein() != 0)
				{
					genOre(blockOre, random, world, cX, cZ);
				}
			}
		}
	}
	
	public void genOre(BlockOre blockOre, Random random, World world, int cX, int cZ)
	{
		for(int i=0; i <= blockOre.getVeinsPerChunk(); i++)
		{
			new WorldGenMinable(blockOre, 0, blockOre.getOrePerVein(), Blocks.stone).generate(world, random, cX*16+random.nextInt(16), random.nextInt(blockOre.getMaxY()-blockOre.getMinY()) + blockOre.getMinY(), cZ*15+random.nextInt(16));
		}
	}
}
