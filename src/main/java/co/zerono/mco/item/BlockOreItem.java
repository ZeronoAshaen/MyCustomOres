package co.zerono.mco.item;

import co.zerono.mco.blocks.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class BlockOreItem extends ItemBlock
{
	private BlockOre blockOre;
	
	public BlockOreItem(Block blockOre) 
	{
		super(blockOre);
		setOre((BlockOre) blockOre);
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemStack)
	{
		String prefix = ("" + StatCollector.translateToLocal("blockOre.prefix")).trim();
		return prefix;
	}
	public BlockOre getBlockOre()
	{
		return blockOre;
	}
	public void setOre(BlockOre blockOre)
	{
		this.blockOre = blockOre;
	}
}
