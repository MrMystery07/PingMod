package net.pingmod.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.pingmod.altmanager.GuiAccountList;
import net.pingmod.altmanager.GuiAccountMenu;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiTransaktionen extends GuiScreen{

	public static GuiTransaktionenList listGui;
	private int selected = -1;
	public static GuiButton deleteButton;
	
	public static List<String> transaktionen = new ArrayList<String>();
	
	@Override
	public void initGui() {
		transaktionen.clear();
//		transaktionen.add("1000:DevManuu:01.01.1970:give:");
//		transaktionen.add("5000:_qlow:01.01.1970:got:");
//		transaktionen.add("10000:FlooTastisch:01.01.1970:give:");
		this.listGui = new GuiTransaktionenList(mc, transaktionen);
		this.listGui.setDimensions(this.width, this.height, 38, this.height - 32);
		GuiButton profileButton;
		GuiButton profileButton2;
		this.buttonList.add(profileButton = new UIButton(0, this.width - 70, 5, 65, 20, "Dein Profil"));
		this.buttonList.add(new UIButton(1, this.width - 140, 5, 65, 20, "Accounts"));
		this.buttonList.add(new UIButton(2, 5, 5, 65, 20, "Mehrspieler"));
//		this.buttonList.add(new UIButton(3, 72, 5, 60, 20, "Teamspeak"));
		this.buttonList.add(new UIButton(4, 5, 27, 80, 12, "Mein Profil"));
		this.buttonList.add(new UIButton(5, 87, 27, 70, 12, "Trustlisten"));
		this.buttonList.add(profileButton2 = new UIButton(6, 87 + 72, 27, 85, 12, "Transaktionen"));
		this.buttonList.add(new UIButton(7, 87 + 72 + 87, 27, 65, 12, "Pinnwand"));
		this.buttonList.add(deleteButton = new UIButton(10, this.width/2 - 100, this.height - 24, "Löschen"));
		deleteButton.enabled = false;
		profileButton.enabled = false;
		profileButton2.enabled = false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 10) {
			this.listGui.accountList.remove(this.listGui.selected);
		}
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu(), 0));
		}
		if(button.id == 1) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		if(button.id == 4) {
			this.mc.displayGuiScreen(new GuiProfile());
		}
		if(button.id == 5) {
			this.mc.displayGuiScreen(new GuiTrustlist());
		}
		if(button.id == 7) {
			this.mc.displayGuiScreen(new GuiPinnwall(false));
		}
		super.actionPerformed(button);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ColorUtils.background();
		this.listGui.drawScreen(mouseX, mouseY, partialTicks);
		super.drawScreen(mouseX, mouseY, partialTicks);
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
	
}
