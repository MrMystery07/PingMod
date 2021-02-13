package net.pingmod.updater;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.pingmod.addons.AddonUtils;
import net.pingmod.altmanager.AccountUtils;

public class GuiChangeLogList extends GuiSlot {

	int selected = -1;
	public static List<String> accountList;

	public GuiChangeLogList(Minecraft mcIn, List<String> list) {
		super(mcIn, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight, 36,
				Minecraft.getMinecraft().displayHeight - 56, 30);
		accountList = list;
	}

	protected boolean isSelected(int id) {
		return (this.selected == id);
	}

	protected int getSelectedSlot() {
		return this.selected;
	}

	public void setSelectedSlot(int selectedSlot) {
		this.selected = selectedSlot;
	}

	protected String getSelectedAccount() {
		if (this.selected < 0 || this.selected >= accountList.size())
			return null;
		return accountList.get(this.selected);
	}

	protected int getSize() {
		return accountList.size();
	}

	protected void drawSlot(int p_180791_1_, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_,
			int p_180791_6_) {
		
		String alt = accountList.get(p_180791_1_);
		this.mc.fontRendererObj.drawString("§e" + alt.split("/")[0], p_180791_2_ + 31, p_180791_3_ + 3, 0xffffff);
		String tags = alt.split("/")[1];
		this.mc.fontRendererObj.drawString("§d" + tags, p_180791_2_ + 31, p_180791_3_ + 15, 0xffffff);
		AddonUtils.drawAltFace(p_180791_2_ + 1, p_180791_3_ + 1, 24, 24, isSelected(p_180791_1_));
	}

	protected void elementClicked(int index, boolean doubleClick, int var3, int var4) {
		if (index >= 0 && index < accountList.size())
			this.selected = index;
	}

	protected void drawBackground() {
	}

	protected int getScrollBarX() {
		return super.getScrollBarX() + 30;
	}

	/**
	 * Gets the width of the list
	 */
	public int getListWidth() {
		return super.getListWidth() + 85;
	}

}
