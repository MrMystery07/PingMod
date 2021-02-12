package net.pingmod.shop;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

public class GuiShop extends GuiScreen {
  public void initGui() {
    this.buttonList.add(new UIShopButton(0, 12, this.height / 6 + 8, 120, 150, ""));
    this.buttonList.add(new UIShopButton(1, 134, this.height / 6 + 8, 58, 75, ""));
    this.buttonList.add(new UIShopButton(2, 134, this.height / 6 + 8 + 75, 58, 75, ""));
    this.buttonList.add(new UIShopButton(3, 194, this.height / 6 + 8, 58, 75, ""));
    this.buttonList.add(new UIShopButton(4, 194, this.height / 6 + 8 + 75, 58, 75, ""));
    this.buttonList.add(new UIShopButton(5, 254, this.height / 6 + 8, 58, 75, ""));
    this.buttonList.add(new UIShopButton(6, 254, this.height / 6 + 8 + 75, 58, 75, ""));
    this.buttonList.add(new UIButton(7, this.width/2 - 100, this.height - 28, "Zurück zum Hauptmenü"));
    super.initGui();
  }
  
  @Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 7) {
			this.mc.displayGuiScreen(new GuiMainMenu());
		}
		super.actionPerformed(button);
	}
  
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    ColorUtils.background();
    GL11.glDisable(3042);
    GL11.glDisable(3553);
    GL11.glDisable(2884);
    GL11.glEnable(3042);
    GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
    GL11.glBegin(7);
    int x = 100;
    int y = 100;
    GL11.glVertex2d(x, (x + 100));
    GL11.glVertex2d(y, (y + 100));
    GL11.glVertex2d(y, (y + 100));
    GL11.glVertex2d(x, (x + 100));
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glEnable(2884);
    GL11.glDisable(3042);
    for (int var4 = 0; var4 < this.buttonList.size(); var4++)
      ((GuiButton)this.buttonList.get(var4)).drawButton(this.mc, mouseX, mouseY); 
    GlStateManager.disableLighting();
    GlStateManager.disableFog();
    Tessellator var6 = Tessellator.getInstance();
    WorldRenderer var7 = var6.getWorldRenderer();
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    float var8 = 32.0F;
    GlStateManager.disableDepth();
    byte var11 = 4;
    GlStateManager.enableBlend();
    GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
    GlStateManager.disableAlpha();
    GlStateManager.shadeModel(7425);
    GlStateManager.func_179090_x();
    var7.startDrawingQuads();
    var7.func_178974_a(0, 0);
    var7.addVertexWithUV(0.0D, (10 + var11 + 28), 0.0D, 0.0D, 1.0D);
    var7.addVertexWithUV(this.width + 10000.0D, (10 + var11 + 28), 0.0D, 1.0D, 1.0D);
    var7.func_178974_a(0, 255);
    var7.addVertexWithUV(this.width + 10000.0D, 38.0D, 0.0D, 1.0D, 0.0D);
    var7.addVertexWithUV(0.0D, 38.0D, 0.0D, 0.0D, 0.0D);
    var6.draw();
    var7.startDrawingQuads();
    var7.func_178974_a(0, 255);
    var7.addVertexWithUV(0.0D, this.height - 36.0D, 0.0D, 0.0D, 1.0D);
    var7.addVertexWithUV(this.width, this.height - 36.0D, 0.0D, 1.0D, 1.0D);
    var7.func_178974_a(0, 0);
    var7.addVertexWithUV(this.width, (this.height - 36 - var11), 0.0D, 1.0D, 0.0D);
    var7.addVertexWithUV(0.0D, (this.height - 36 - var11), 0.0D, 0.0D, 0.0D);
    var6.draw();
    GlStateManager.func_179098_w();
    GlStateManager.shadeModel(7424);
    GlStateManager.enableAlpha();
    GlStateManager.disableBlend();
    super.drawScreen(mouseX, mouseY, partialTicks);
  }
}
