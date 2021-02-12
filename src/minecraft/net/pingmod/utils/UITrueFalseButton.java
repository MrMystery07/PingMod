package net.pingmod.utils;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;

public class UITrueFalseButton extends GuiButton{

	public UITrueFalseButton(int buttonId, int x, int y, String buttonText) {
		this(buttonId, x, y, 50, 20, buttonText);
	}

	public UITrueFalseButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		
		if(this.visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            if(this.enabled) {
            	FontRenderer var4 = mc.fontRendererObj;
            	Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(116, 125, 140).getRGB());
        		
            	Gui.drawRect(this.xPosition + this.width, this.yPosition, this.xPosition + this.width - 5, this.yPosition + this.height - 1,
        				new Color(0, 255, 0).getRGB());
            	
        		drawCenteredString(var4, "ON", this.xPosition + this.width / 2,
        				this.yPosition + (this.height - 8) / 2, 0xffffff);
        		
            }
            if(!this.enabled) {
            	FontRenderer var4 = mc.fontRendererObj;
        		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(116, 125, 140).getRGB());
        		
            	Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + 5, this.yPosition + this.height - 1,
        				new Color(255, 0, 0).getRGB());
            	
        		drawCenteredString(var4, "OFF", this.xPosition + this.width / 2,
        				this.yPosition + (this.height - 8) / 2, 0xffffff);
            }
		}
		
	}
	
	
}
