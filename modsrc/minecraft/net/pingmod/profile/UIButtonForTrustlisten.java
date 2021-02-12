package net.pingmod.profile;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;

public class UIButtonForTrustlisten extends GuiButton{

	public UIButtonForTrustlisten(int buttonId, int x, int y) {
		this(buttonId, x, y, 60, 40, "");
	}

	public UIButtonForTrustlisten(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		
		if(this.visible) {
			int x = this.xPosition;
			int y = this.yPosition;
			FontRenderer fontrenderer = mc.fontRendererObj;
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            if(this.enabled && this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
        		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(38, 222, 129).getRGB());
        		
				Gui.drawRect(x, y, x + 60, y + 40, new Color(38, 222, 129).getRGB());
				Gui.drawRect(x + 15, y + 5, x + 45, y + 35, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 17, y + 7, x + 43, y + 33, new Color(38, 222, 129).getRGB());
				Gui.drawRect(x + 29, y + 9, x + 31, y + 31, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 29, y + 9, x + 31, y + 31, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 41, y + 19, x + 19, y + 21, new Color(255, 255, 255).getRGB());
        		
            }else if(this.enabled && !this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
				Gui.drawRect(x, y, x + 60, y + 40, new Color(43, 203, 186).getRGB());
				Gui.drawRect(x + 15, y + 5, x + 45, y + 35, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 17, y + 7, x + 43, y + 33, new Color(43, 203, 186).getRGB());
				Gui.drawRect(x + 29, y + 9, x + 31, y + 31, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 29, y + 9, x + 31, y + 31, new Color(255, 255, 255).getRGB());
				Gui.drawRect(x + 41, y + 19, x + 19, y + 21, new Color(255, 255, 255).getRGB());
        		
        		
            }
		}
		
	}
	
}

