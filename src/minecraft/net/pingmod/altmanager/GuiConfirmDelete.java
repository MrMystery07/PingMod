package net.pingmod.altmanager;

import java.awt.Color;
import java.io.IOException;import net.pingmod.utils.UIButton;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiConfirmDelete extends GuiScreen{

	String deleteName;
	
	public GuiConfirmDelete(String name) {
		deleteName = name;
	}
	
	@Override
	public void initGui() {
        this.buttonList.add(new UIButton(0, this.width / 2 - 155, this.height / 6 + 96, 150, 20,"Löschen"));
        this.buttonList.add(new UIButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, 150, 20, "Abbrechen"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		if(button.id == 0) {
			AccountUtils.deleteAccount(deleteName);
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		super.actionPerformed(button);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ColorUtils.background();
		this.drawCenteredString(this.fontRendererObj, "Bist du sicher, dass du diesen Account entfernen möchtest?", this.width / 2, 70, 16777215);
        this.drawCenteredString(this.fontRendererObj, "Der Account wird für immer verloren sein! (Eine lange Zeit!)", this.width / 2, 90, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	
}
