package net.pingmod.profile;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.pingmod.altmanager.AccountUtils;

public class UIButtonForTrustlistPlayer extends GuiButton{

	public static String playerName;
	
	public UIButtonForTrustlistPlayer(int buttonId, int x, int y, String playerName2) {
		this(buttonId, x, y, 60, 40, playerName2);
	}

	public UIButtonForTrustlistPlayer(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		
		if(this.visible) {
			int x = this.xPosition;
			int y = this.yPosition;
			FontRenderer fontrenderer = mc.fontRendererObj;
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
//            if(this.enabled && this.hovered) {
//            	FontRenderer var4 = mc.fontRendererObj;
//            	Gui.drawRect(x, y, x + 60, y + 40, new Color(38, 222, 129).getRGB());
//        	        		
//				AccountUtils.drawAltFace(x + 15, y + 5, 23, 23, false, playerName);
//            }else if(this.enabled && !this.hovered) {
//            	FontRenderer var4 = mc.fontRendererObj;
//            	Gui.drawRect(x, y, x + 60, y + 40, new Color(38, 222, 129).getRGB());
//				AccountUtils.drawAltFace(x + 15, y + 5, 23, 23, false, playerName);
//        		
//            }
            if(this.enabled && this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
        		
				Gui.drawRect(x, y, x + 60, y + 40, new Color(38, 222, 129).getRGB());
				Gui.drawRect(x + 17, y + 7, x + 43, y + 33, new Color(38, 222, 129).getRGB());
				GlStateManager.scale(0.5, 0.5, 0.5);
				drawCenteredString(fontrenderer, this.displayString, (x + 30) * 2, (y + 30) * 2, 0xffffff);
				GlStateManager.scale(2, 2, 2);
            }else if(this.enabled && !this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
				Gui.drawRect(x, y, x + 60, y + 40, new Color(43, 203, 186).getRGB());
				Gui.drawRect(x + 17, y + 7, x + 43, y + 33, new Color(43, 203, 186).getRGB());
				GlStateManager.scale(0.5, 0.5, 0.5);
				drawCenteredString(fontrenderer, this.displayString, (x + 30) * 2, (y + 30) * 2, 0xffffff);
				GlStateManager.scale(2, 2, 2);
            }
		}
		
	}
	
}

