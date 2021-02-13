package net.pingmod.updater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.pingmod.profile.GuiTransaktionenList;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiChangeLog extends GuiScreen{

	public static GuiChangeLogList listGui;
	private int selected = -1;
	
	@Override
	public void initGui() {
		this.listGui = new GuiChangeLogList(mc, UpdateAviable.list);
		this.listGui.setDimensions(this.width, this.height, 38, this.height - 32);
		
		this.buttonList.add(new UIButton(0, 5, 5, 65, 20, "Zurück"));
		
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiUpdateAviable());
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
