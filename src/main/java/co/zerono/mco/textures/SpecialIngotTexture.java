package co.zerono.mco.textures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.item.ItemSpecialIngot;
import co.zerono.mco.helpers.ColorHelpers;
import co.zerono.mco.helpers.ResourceLocationHelper;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.util.ResourceLocation;

public class SpecialIngotTexture extends TextureAtlasSprite
{
	private ItemSpecialIngot itemIngot;
	
	public SpecialIngotTexture(ItemSpecialIngot itemIngot)
	{
		super(Textures.RESOURCE_PREFIX + itemIngot.getOreDictName());
		setIngot(itemIngot);
	}
	public ItemSpecialIngot getIngot()
	{
		return itemIngot;
	}
	public void setIngot(ItemSpecialIngot itemIngot)
	{
		this.itemIngot = itemIngot;
	}
	
	@Override
	public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
	{
        ResourceLocation location1 = new ResourceLocation(location.getResourceDomain(), String.format("%s/%s%s", new Object[]{"textures/items", location.getResourcePath(), ".png"}));
        try
        {
        	manager.getResource(location1);
        	LogHelper.info("Detected override for " + itemIngot.getOreDictName() + ".");
        	return false;
        }
        catch(IOException e)
        {
        	return true;
        }
	}
	
	@Override
	public boolean load(IResourceManager manager, ResourceLocation location)
	{
		int mp = Minecraft.getMinecraft().gameSettings.mipmapLevels + 1;
		BufferedImage[] ingotImage = new BufferedImage[mp];
		
		BufferedImage alphaImage;
		BufferedImage shapeImage;
		BufferedImage underlyingColor;
		int width;
		
		AnimationMetadataSection animation;
		try
		{
			IResource iResourceAlpha = manager.getResource(ResourceLocationHelper.getResourceLocation("textures/items/ingot.png"));
			IResource iResourceShape = manager.getResource(ResourceLocationHelper.getResourceLocation("textures/items/ingotShape.png"));
			IResource iResourceBase = manager.getResource(ResourceLocationHelper.getResourceLocation("minecraft", "textures/items/iron_ingot.png"));
			animation = (AnimationMetadataSection) iResourceBase.getMetadata("animation");
			alphaImage = ImageIO.read(iResourceAlpha.getInputStream());
			shapeImage = ImageIO.read(iResourceShape.getInputStream());
			
			underlyingColor = new BufferedImage(alphaImage.getHeight(), alphaImage.getWidth(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics g= underlyingColor.getGraphics();
			g.setColor(ColorHelpers.hex2Rgb(itemIngot.getUnderlyingHex()));
			for(int i=0; i<alphaImage.getHeight(); i++)
			{
				for (int j=0; j<alphaImage.getWidth(); j++)
				{
					int alphaLevel = ColorHelpers.getAlpha(shapeImage, j, i);
					if(alphaLevel > 0)
					{
						g.drawLine(j, i, j, i);
					}
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return true;
		}
		BufferedImage texture = new BufferedImage(alphaImage.getWidth(), alphaImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		Graphics cg = texture.getGraphics();
		cg.drawImage(underlyingColor, 0, 0, null);
		cg.drawImage(alphaImage, 0, 0, null);
		
		ingotImage[0] = texture;
		this.loadSprite(ingotImage, animation, Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1.0F);
		return false;
	}
}
