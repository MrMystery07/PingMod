package net.pingmod.utils;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ColorUtils {
 
	public static void background() {
    	Color color = new Color(55, 66, 255);
		for (int i = 0; i < 170; i++) {
			Gui.drawRect(0 + i, i, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight,
					new Color(i, i, 236).getRGB());
		}
	}

	public static Color rainbowEffect(long offset, float fade) {
		float hue = (float)(System.nanoTime() + offset) / 1.0E10F % 1.0F;
		long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 16);
		Color c = new Color((int)color);
		return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
	}
}
