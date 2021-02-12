package net.pingmod.altmanager;

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

public class GuiAccountList extends GuiSlot {

	int selected = -1;
	public static List<String> accountList;

	public GuiAccountList(Minecraft mcIn, List<String> list) {
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
		this.mc.fontRendererObj.drawString(alt.split(":")[0], p_180791_2_ + 31, p_180791_3_ + 3, 0xffffff);
		String tags = "";
		int length = alt.split(":")[2].length();
		String password = "";
		for (int i = 0; i < length; i++) {
			password += "*";
		}
		tags = "§7" + alt.split(":")[1] + "§8, §7" + password;

		this.mc.fontRendererObj.drawString(tags, p_180791_2_ + 31, p_180791_3_ + 15, 0xffffff);
		AccountUtils.drawAltFace(p_180791_2_ + 1, p_180791_3_ + 1, 23, 23, isSelected(p_180791_1_), alt.split(":")[0]);
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
