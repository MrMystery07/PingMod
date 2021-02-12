package net.pingmod.settings;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import net.pingmod.utils.UIButton;

public class GuiPingModSettings extends GuiScreen{

	public static boolean jumpEnabled = false;
	
	int i = 0;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(fontRendererObj, "§cHier scheint es nocht nichts zu geben :(", width/2, height/2, 0xffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
//		this.buttonList.add(new UIButton(0, 4, 4, 100, 20, "Fullbright"));
//		this.buttonList.add(new UIButton(1, 4, 4 + 20 + 4, 100, 20, "Autojump"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if(button.id == 0) {
			if(Minecraft.getMinecraft().gameSettings.gammaSetting <= 10) {
			Minecraft.getMinecraft().gameSettings.gammaSetting = 100.0F;
			}else {
				Minecraft.getMinecraft().gameSettings.gammaSetting = 0.0F;
			}
		}
		if(button.id == 1) {
			jumpEnabled = !jumpEnabled;
		}
		super.actionPerformed(button);
	}
	
	
	
	public static void onTick() {
		if(jumpEnabled) {
			if(Minecraft.getMinecraft().thePlayer.onGround) {
				Minecraft.getMinecraft().thePlayer.jump();
			}
		}
	}
	
}
