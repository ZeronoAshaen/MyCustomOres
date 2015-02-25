package co.zerono.mco.textures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.text.WordUtils;

import co.zerono.mco.blocks.BlockOre;
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

public class RawOreTexture extends TextureAtlasSprite 
{
	private BlockOre blockOre;
	
	public RawOreTexture(BlockOre blockOre) 
	{
		super(Textures.RESOURCE_PREFIX + blockOre.getOreDictName());
		this.blockOre = blockOre;
	}
	
	@Override
	public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
	{
        ResourceLocation location1 = new ResourceLocation(location.getResourceDomain(), String.format("%s/%s%s", new Object[]{"textures/blocks", location.getResourcePath(), ".png"}));
        try 
        {
        	manager.getResource(location1);
        	LogHelper.info("Detected override for " + blockOre.getOreDictName() + ".");
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
		
		BufferedImage[] ore_image = new BufferedImage[mp];
		
		BufferedImage alphaImage;
		BufferedImage underlyingColor;
		int width;
		
        AnimationMetadataSection animation;
		try 
		{
			IResource iResourceAlpha = manager.getResource(ResourceLocationHelper.getResourceLocation("textures/blocks/ore" + WordUtils.capitalizeFully(blockOre.getOreType()) + ".png"));
			IResource iResourceBase = manager.getResource(ResourceLocationHelper.getResourceLocation("minecraft", "textures/blocks/coal_ore.png"));
			
			animation = (AnimationMetadataSection) iResourceBase.getMetadata("animation");
			
			alphaImage = ImageIO.read(iResourceAlpha.getInputStream());
			
			underlyingColor = new BufferedImage(alphaImage.getHeight(), alphaImage.getWidth(), BufferedImage.TYPE_3BYTE_BGR);
			Graphics g= underlyingColor.getGraphics();
			g.setColor(hex2Rgb(blockOre.getUnderlyingHex()));
			g.fillRect(0, 0, alphaImage.getHeight(), alphaImage.getWidth());
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

		ore_image[0] = texture;
		
		this.loadSprite(ore_image, animation, Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1.0F);
		return false;
	}
	
	/**
	 * 
	 * @param colorStr e.g. "#FFFFFF"
	 * @return 
	 */
	public static Color hex2Rgb(String colorStr) 
	{
		return new Color(Integer.parseInt(colorStr, 16));
	}
}
