package net.pingmod.shop;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class UIShopButton extends GuiButton {
  public UIShopButton(int buttonId, int x, int y, String buttonText) {
    this(buttonId, x, y, 200, 20, buttonText);
  }
  
  public UIShopButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
    super(buttonId, x, y, widthIn, heightIn, buttonText);
  }
  
  public void drawButton(Minecraft mc, int mouseX, int mouseY) {
    if (this.visible) {
      FontRenderer fontrenderer = mc.fontRendererObj;
      this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
      if (this.enabled && this.hovered) {
        FontRenderer var4 = mc.fontRendererObj;
        Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1, (
            new Color(38, 222, 129)).getRGB());
        drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, 
            this.yPosition + (this.height - 8) / 2, 16777120);
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2884);
        GL11.glEnable(3042);
        GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
        GL11.glBegin(7);
        GL11.glVertex2d((this.xPosition + 2), (this.yPosition + 2));
        GL11.glVertex2d((this.xPosition + this.width - 3), (this.yPosition + 2));
        GL11.glVertex2d((this.xPosition + this.width - 3), (this.yPosition + this.height - 3));
        GL11.glVertex2d((this.xPosition + 2), (this.yPosition + this.height - 3));
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
      } else if (this.enabled && !this.hovered) {
        FontRenderer var4 = mc.fontRendererObj;
        Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1, (
            new Color(43, 203, 186)).getRGB());
        drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, 
            this.yPosition + (this.height - 8) / 2, 16777215);
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2884);
        GL11.glEnable(3042);
        GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
        GL11.glBegin(7);
        GL11.glVertex2d((this.xPosition + 2), (this.yPosition + 2));
        GL11.glVertex2d((this.xPosition + this.width - 3), (this.yPosition + 2));
        GL11.glVertex2d((this.xPosition + this.width - 3), (this.yPosition + this.height - 3));
        GL11.glVertex2d((this.xPosition + 2), (this.yPosition + this.height - 3));
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
      } else if (!this.enabled) {
        FontRenderer var4 = mc.fontRendererObj;
        Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1, (
            new Color(116, 125, 140)).getRGB());
        drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, 
            this.yPosition + (this.height - 8) / 2, 11911366);
      } 
    } 
  }
}
