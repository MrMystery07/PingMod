package net.pingmod.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiAddScam extends GuiScreen{
	public GuiTextField displayName;
	public static List<String> list = new ArrayList<String>();
	
	@Override
	public void initGui() {
		
		Keyboard.enableRepeatEvents(true);
		this.buttonList.add(new UIButton(1, this.width / 2 - 100, this.height / 4 + 96 + 28, "Hinzufügen"));
		this.buttonList.add(new UIButton(2, this.width / 2 - 100, this.height / 4 + 120 + 28, "Abbrechen"));
		displayName = new GuiTextField(5, fontRendererObj, width / 2 - 200, 76, 400, 20);
		displayName.setText("Name");
		displayName.setFocused(true);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiTrustlist());
		}
		if(button.id == 1) {
			ProfileUitls.saveAccountScam(displayName.getText());
			this.mc.displayGuiScreen(new GuiTrustlist());
		}
		super.actionPerformed(button);
	}
	
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		displayName.textboxKeyTyped(typedChar, keyCode);
		
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public void updateScreen() {
		displayName.updateCursorCounter();
		super.updateScreen();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ColorUtils.background();
		
		displayName.drawTextBox();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}

