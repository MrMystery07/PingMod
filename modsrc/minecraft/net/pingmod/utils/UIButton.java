package net.pingmod.utils;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;

public class UIButton extends GuiButton{

	public UIButton(int buttonId, int x, int y, String buttonText) {
		this(buttonId, x, y, 200, 20, buttonText);
	}

	public UIButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		
		if(this.visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            if(this.enabled && this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
        		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(38, 222, 129).getRGB());
        		drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2,
        				this.yPosition + (this.height - 8) / 2, 16777120);
            }else if(this.enabled && !this.hovered) {
            	FontRenderer var4 = mc.fontRendererObj;
        		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(43, 203, 186).getRGB());
        		drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2,
        				this.yPosition + (this.height - 8) / 2, 0xffffff);
            }else if(!this.enabled) {
            	FontRenderer var4 = mc.fontRendererObj;
        		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1,
        				new Color(116, 125, 140).getRGB());
        		drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2,
        				this.yPosition + (this.height - 8) / 2, 0xb5c0c6);
            }
		}
		
	}
	
}
