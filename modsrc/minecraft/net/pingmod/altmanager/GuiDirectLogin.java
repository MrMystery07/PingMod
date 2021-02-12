package net.pingmod.altmanager;

import java.awt.Color;
import java.io.IOException;import net.pingmod.utils.UIButton;
import java.net.Proxy;
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
import net.minecraft.util.Session;
import net.pingmod.utils.UIButton;

public class GuiDirectLogin extends GuiScreen{

	public GuiTextField email;
	public GuiTextField password;
	public GuiScreen alterScreen;
	public static String name;
	private UUID uuid;
	public static GuiButton saveButton;

	public GuiDirectLogin(GuiScreen alt) {
		alterScreen = alt;
		name = Minecraft.getMinecraft().getSession().getUsername();
		uuid = Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().getSession().getProfile());
	}

	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.add(saveButton = new UIButton(1, this.width / 2 - 100, this.height / 4 + 96 + 28, "Einloggen"));
		this.buttonList.add(new UIButton(2, this.width / 2 - 100, this.height / 4 + 120 + 28, "Abbrechen"));
		saveButton.enabled = false;
		email = new GuiTextField(3, fontRendererObj, width / 2 - 200, 116, 400, 20);
		password = new GuiTextField(4, fontRendererObj, width / 2 - 200, 156, 400, 20);
		email.setMaxStringLength(50);
		password.setMaxStringLength(50);
		email.setText("EMail");
		password.setText("Passwort");
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {
		email.updateCursorCounter();
		password.updateCursorCounter();
		if(email.getText() != "" && password.getText() != "" && email.getText() != "EMail" && password.getText() != "Passwort") {
			saveButton.enabled = true;
		}else {
			saveButton.enabled = false;
		}
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		email.mouseClicked(mouseX, mouseY, mouseButton);
		password.mouseClicked(mouseX, mouseY, mouseButton);
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
		this.drawString(this.fontRendererObj, "§8Benutzername: §a" + name, this.width / 2 - 200, this.height / 2 - 45, 0xfffff);
		this.drawString(this.fontRendererObj, "§8UUID: §a" + uuid, this.width / 2 - 200, this.height / 2 - 25, 0xfffff);
		email.drawTextBox();
		password.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		if(button.id == 1) {
				
					YggdrasilUserAuthentication a = (YggdrasilUserAuthentication) new YggdrasilAuthenticationService(
							Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
					a.setUsername(email.getText().trim());
					a.setPassword(password.getText().trim());
					try {
						a.logIn();
						mc.session = new Session(a.getSelectedProfile().getName(),
								a.getSelectedProfile().getId().toString(), a.getAuthenticatedToken(), "mojang");
						name = Minecraft.getMinecraft().getSession().getUsername();
						uuid = Minecraft.getMinecraft().thePlayer.getUniqueID();
					} catch (Exception e) {
					}
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
	}
	
}
