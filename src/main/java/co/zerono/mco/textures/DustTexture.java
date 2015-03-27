package co.zerono.mco.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import co.zerono.mco.helpers.ColorHelpers;
import co.zerono.mco.helpers.ResourceLocationHelper;
import co.zerono.mco.item.ItemDust;
import co.zerono.mco.reference.Textures;
import co.zerono.mco.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.util.ResourceLocation;

public class DustTexture extends TextureAtlasSprite
{
	private ItemDust itemDust;
	
	public DustTexture(ItemDust itemDust)
	{
		super(Textures.RESOURCE_PREFIX + itemDust.getOreDictName());
		this.itemDust = itemDust;
	}
	
	@Override
	public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
	{
		ResourceLocation location1 = new ResourceLocation(location.getResourceDomain(), String.format("%s/$s%s", new Object[]{"textures/items", location.getResourcePath(), ".png"}));
		try
		{
			manager.getResource(location1);
			LogHelper.info("Detected override for " + itemDust.getOreDictName() + ".");
			return false;
		}
		catch (IOException e)
		{
			return true;
		}
	}
	@Override
	public boolean load(IResourceManager manager, ResourceLocation location)
	{
		int mp = Minecraft.getMinecraft().gameSettings.mipmapLevels + 1;
		
		BufferedImage[] dustImage = new BufferedImage[mp];
		
		BufferedImage alphaImage;
		BufferedImage underlyingColor;
		BufferedImage shapeImage;
		int width;
		
		AnimationMetadataSection animation;
		try
		{
			IResource iResourceAlpha = manager.getResource(ResourceLocationHelper.getResourceLocation("textures/items/" + (itemDust.getIsTiny() ? "tinyDust" : "dust") + ".png"));
			IResource iResourceShape = manager.getResource(ResourceLocationHelper.getResourceLocation("textures/items/" + (itemDust.getIsTiny() ? "tinyDust" : "dust") + "Shape.png"));
			IResource iResourceBase = manager.getResource(ResourceLocationHelper.getResourceLocation("minecraft","textures/items/gold_nugget.png"));
			animation = (AnimationMetadataSection) iResourceBase.getMetadata("animation");
			alphaImage = ImageIO.read(iResourceAlpha.getInputStream());
			shapeImage = ImageIO.read(iResourceShape.getInputStream());
			
			underlyingColor = new BufferedImage(alphaImage.getHeight(), alphaImage.getWidth(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics g = underlyingColor.getGraphics();
			g.setColor(ColorHelpers.hex2Rgb(itemDust.getUnderlyingHex()));
			for(int i=0; i<alphaImage.getHeight(); i++)
			{
				for(int j=0; j<alphaImage.getWidth(); j++)
				{
					int alphaLevel = ColorHelpers.getAlpha(shapeImage, j, i);
					if(alphaLevel > 0)
					{
						g.drawLine(j, i, j, i);
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return true;
		}
		BufferedImage texture = new BufferedImage(alphaImage.getWidth(), alphaImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		Graphics cg = texture.getGraphics();
		cg.drawImage(underlyingColor, 0, 0, null);
		cg.drawImage(alphaImage, 0, 0, null);
		
		dustImage[0] = texture;
		this.loadSprite(dustImage, animation, Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1.0F);
		return false;
	}
}
