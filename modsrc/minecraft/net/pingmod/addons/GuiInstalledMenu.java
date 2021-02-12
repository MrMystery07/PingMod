package net.pingmod.addons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.pingmod.altmanager.GuiAccountList;

public class GuiInstalledMenu extends GuiScreen{

	public static GuiAddonList listGui;
	private int selected = -1;
	public static List<String> addonList = new ArrayList<String>();
	
	public GuiInstalledMenu() {
		addonList.add("Test Addon:Das ist mein erstes Adddon!");
		
	}
	
	@Override
	public void onGuiClosed() {
		addonList.clear();
		super.onGuiClosed();
	}
	
	@Override
	public void initGui() {
		this.listGui = new GuiAddonList(mc, addonList);
		this.listGui.setDimensions(this.width, this.height, 38, this.height - 64);
		super.initGui();
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
