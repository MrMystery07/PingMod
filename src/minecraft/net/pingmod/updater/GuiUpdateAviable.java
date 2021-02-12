package net.pingmod.updater;

import java.io.IOException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiUpdateAviable extends GuiScreen{

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		ColorUtils.background();
		GlStateManager.scale(2.0, 2.0, 2.0);
		drawCenteredString(fontRendererObj, "�r�fEs gibt eine neue Version der �b�lPingMod�r�f!", Integer.valueOf((int) (this.width/2*0.5)), Integer.valueOf((int) (this.height/2*0.5-this.height/6)), 0xffffff);
		GlStateManager.scale(0.5, 0.5, 0.5);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new UIButton(0, this.width/2-49, this.height/2, 98, 20, "Aktualisieren"));
		this.buttonList.add(new UIButton(1, this.width/2-49, this.height/2 + 24, 98, 20, "Zum Hauptmen�"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
		}
		if(button.id == 0) {
        	UpdateAviable.openWebpage(new URL("https://github.com/MrMystery07/PingMod"));
		}
		super.actionPerformed(button);
	}
	
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		super.updateScreen();
	}
	
	
}