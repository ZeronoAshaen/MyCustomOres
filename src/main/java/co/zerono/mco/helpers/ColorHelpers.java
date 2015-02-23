package co.zerono.mco.helpers;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ColorHelpers 
{
	/**
	 * 
	 * @param colorStr e.g. "#FFFFFF"
	 * @return 
	 */
	public static Color hex2Rgb(String colorStr) 
	{
		return new Color(Integer.parseInt(colorStr, 16));
	}
	public static int getAlpha(BufferedImage image, int x, int y)
	{
		int color = image.getRGB(x, y);
		int alpha = (color>>24) & 0xff;
		return alpha;
	}
}
