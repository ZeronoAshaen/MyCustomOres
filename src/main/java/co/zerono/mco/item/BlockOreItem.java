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
		ItemStack temp = new ItemStack(getOreBlock(), 1);
		return temp.getDisplayName();
	}
	public BlockOre getOreBlock()
	{
		return blockOre;
	}
	public void setOre(BlockOre blockOre)
	{
		this.blockOre = blockOre;
	}
}
