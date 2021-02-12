package net.pingmod.profile;

import java.awt.Color;
import java.io.IOException;import net.pingmod.utils.UIButton;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Session;
import net.pingmod.utils.UIButton;

public class GuiPinnwallAdd extends GuiScreen {
	public GuiTextField email;
	public GuiTextField password;
	public GuiTextField displayName;
	public GuiScreen alterScreen;
	public static GuiButton saveButton;

	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.add(saveButton = new UIButton(1, this.width / 2 - 100, this.height / 4 + 96 + 28, "Speichern"));
		this.buttonList.add(new UIButton(2, this.width / 2 - 100, this.height / 4 + 120 + 28, "Abbrechen"));
		saveButton.enabled = false;
		email = new GuiTextField(3, fontRendererObj, width / 2 - 200, 116, 400, 20);
		password = new GuiTextField(4, fontRendererObj, width / 2 - 200, 156, 400, 20);
		displayName = new GuiTextField(5, fontRendererObj, width / 2 - 200, 76, 400, 20);
		email.setMaxStringLength(50);
		password.setMaxStringLength(50);
		displayName.setMaxStringLength(50);
		email.setText("Beschreibung");
		email.setMaxStringLength(43);
		displayName.setText("Titel");
		displayName.setMaxStringLength(10);
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {
		email.updateCursorCounter();
		password.updateCursorCounter();
		displayName.updateCursorCounter();
		
		if(!displayName.getText().contains(" ")) {
			saveButton.enabled = true;
		}else {
			saveButton.enabled = false;
		}
		
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		email.mouseClicked(mouseX, mouseY, mouseButton);
		password.mouseClicked(mouseX, mouseY, mouseButton);
		displayName.mouseClicked(mouseX, mouseY, mouseButton);
		try {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void keyTyped(char c, int i) {
		email.textboxKeyTyped(c, i);
		password.textboxKeyTyped(c, i);
		displayName.textboxKeyTyped(c, i);
		if (c == '\t') {
			if (email.isFocused()) {
				email.setFocused(false);
				password.setFocused(true);
			} else {
				email.setFocused(true);
				password.setFocused(false);
			}
		}
		if (c == '\r') {
			try {
				actionPerformed((GuiButton) buttonList.get(0));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String status;

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	Color color = new Color(55, 66, 255);
		for (int i = 0; i < 170; i++) {
			Gui.drawRect(0 + i, i, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight,
					new Color(i, i, 236).getRGB());
		}
		email.drawTextBox();
//		password.drawTextBox();
		displayName.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiPinnwall(false));
		}
		if(button.id == 1) {
			
			PinnwallUtils.saveList(displayName.getText() + ":" + email.getText(), String.valueOf(this.width / 2 - 100), String.valueOf(this.height / 2));
			
			this.mc.displayGuiScreen(new GuiPinnwall(true));
		}
	}
}

