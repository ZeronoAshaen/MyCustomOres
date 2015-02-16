package co.zerono.pc.handlers.texture;

import co.zerono.pc.blocks.BlockOreNew;
import co.zerono.pc.reference.Reference;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class GetTexture extends TextureAtlasSprite 
{
	private BlockOreNew blockOre;
	protected GetTexture(BlockOreNew blockOre) 
	{
		super(Reference.MOD_ID.toLowerCase() + ":ore" + blockOre.getOreType() + blockOre.getName());
		this.blockOre = blockOre;
	}

}
