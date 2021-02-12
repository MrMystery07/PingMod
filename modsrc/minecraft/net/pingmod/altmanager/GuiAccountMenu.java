package net.pingmod.altmanager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import net.pingmod.utils.UIButton;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.Session;
import net.pingmod.profile.GuiProfile;
import net.pingmod.utils.PingMod;
import net.pingmod.utils.UIButton;

public class GuiAccountMenu extends GuiScreen {

	public static GuiAccountList listGui;
	private int selected = -1;
	public static GuiButton multiplayerButton;
	public static GuiButton tsButton;
	public static GuiButton btnEditServer;
	public static GuiButton btnSelectServer;
	public static GuiButton btnDeleteServer;
	public static List<String> accountList = new ArrayList<String>();

	public GuiAccountMenu() {
		
			AccountUtils.loadList();
		
		for (String s : AccountUtils.list) {
			accountList.add(s);
		}
	}

	@Override
	public void onGuiClosed() {
		accountList.clear();
		super.onGuiClosed();
	}
	
	@Override
	public void initGui() {
		for(int i = 0; i < accountList.size(); i++) {
			File file = new File(
					"C:/Users/cziep/Desktop/PingMod-All/PingMod-1.8.0/workspace/src/minecraft/assets/minecraft/pingmod/"
							+ accountList.get(i).split(":")[0] + ".png");
			if(!file.exists()) {
			try {
				try {
					InputStream in = new URL("https://cravatar.eu/helmavatar/" + accountList.get(i).split(":")[0] + "/64.png").openStream();					Files.copy(in, Paths.get(file.getAbsolutePath()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}catch (Exception e) {
			}
		}
		}
		GuiButton accountsButton;
		this.listGui = new GuiAccountList(mc, accountList);
		this.listGui.setDimensions(this.width, this.height, 38, this.height - 64);
		this.buttonList.add(new UIButton(0, this.width - 70, 5, 65, 20, "Dein Profil"));
		this.buttonList.add(accountsButton = new UIButton(1, this.width - 140, 5, 65, 20, "Accounts"));
		this.buttonList.add(multiplayerButton = new UIButton(2, 5, 5, 65, 20, "Mehrspieler"));
//		this.buttonList.add(tsButton = new UIButton(3, 72, 5, 60, 20, "Teamspeak"));

		this.buttonList.add(
				this.btnEditServer = new UIButton(11, this.width / 2 - 154, this.height - 28, 70, 20, "Bearbeiten"));
		this.buttonList
				.add(this.btnDeleteServer = new UIButton(6, this.width / 2 - 74, this.height - 28, 70, 20, "Löschen"));
		this.buttonList.add(
				this.btnSelectServer = new UIButton(5, this.width / 2 - 154, this.height - 52, 100, 20, "Einloggen"));
		this.buttonList.add(new UIButton(8, this.width / 2 - 50, this.height - 52, 100, 20, "Direkt einloggen"));
		this.buttonList.add(new UIButton(7, this.width / 2 + 4 + 50, this.height - 52, 100, 20, "Account Hinzufügen"));
		this.buttonList.add(new UIButton(12, this.width / 2 + 4, this.height - 28, 70, 20, "Aktualisieren"));
		this.buttonList.add(new UIButton(4, this.width / 2 + 4 + 76, this.height - 28, 75, 20, "Abbrechen"));

		btnEditServer.enabled = false;
		btnDeleteServer.enabled = false;
		btnSelectServer.enabled = false;

		accountsButton.enabled = false;
		super.initGui();
	}

	@Override
	public void updateScreen() {

		if(this.listGui.selected != -1) {
			btnEditServer.enabled = true;
			btnDeleteServer.enabled = true;
			btnSelectServer.enabled = true;
		}else {
			btnEditServer.enabled = false;
			btnDeleteServer.enabled = false;
			btnSelectServer.enabled = false;
		}
		
		super.updateScreen();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled) {
			if (button.id == 2) {
				this.mc.displayGuiScreen(new GuiMultiplayer(this, 0));
			}
			if (button.id == 3) {
//				tsButton.enabled = false;
			}
			if (button.id == 4) {
				this.mc.displayGuiScreen(new GuiMainMenu());
			}
			if (button.id == 7) {
				this.mc.displayGuiScreen(new GuiAddAccount(this));
			}
			if(button.id == 12) {
				this.listGui.selected = -1;
				accountList.clear();
				AccountUtils.loadList();
				
				for (String s : AccountUtils.list) {
					accountList.add(s);
				}
			}
			if(button.id == 8) {
				this.mc.displayGuiScreen(new GuiDirectLogin(this));
			}
			if(button.id == 6) {
				this.mc.displayGuiScreen(new GuiConfirmDelete(this.listGui.getSelectedAccount().split(":")[0]));
			}
			if(button.id == 11) {
				this.mc.displayGuiScreen(new GuiAccountEdit(this, this.listGui.getSelectedAccount().split(":")[0], this.listGui.getSelectedAccount().split(":")[1], this.listGui.getSelectedAccount().split(":")[2]));
			}
			if(button.id == 5) {
				YggdrasilUserAuthentication a = (YggdrasilUserAuthentication) new YggdrasilAuthenticationService(
						Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
				a.setUsername(this.listGui.getSelectedAccount().split(":")[1].trim());
				a.setPassword(this.listGui.getSelectedAccount().split(":")[2].trim());
				try {
					a.logIn();
					mc.session = new Session(a.getSelectedProfile().getName(),
							a.getSelectedProfile().getId().toString(), a.getAuthenticatedToken(), "mojang");
				} catch (Exception e) {
				}
				this.listGui.selected = -1;
				accountList.clear();
				AccountUtils.loadList();
				
				for (String s : AccountUtils.list) {
					accountList.add(s);
				}
			}
		}
		if(button.id == 0) {
			this.mc.displayGuiScreen(new GuiProfile());
		}
		super.actionPerformed(button);
	}
	
	  protected void mouseClicked(int par1, int par2, int par3) throws IOException {
		    if (par2 >= 36 && par2 <= this.height - 57 && (
		      par1 >= this.width / 2 + 140 || par1 <= this.width / 2 - 126))
		      this.listGui.elementClicked(-1, false, 0, 0); 
		    super.mouseClicked(par1, par2, par3);
		  }
		  
		  public void handleMouseInput() throws IOException {
		    super.handleMouseInput();
		    this.listGui.handleMouseInput();
		  }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		this.listGui.drawScreen(mouseX, mouseY, partialTicks);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

}
