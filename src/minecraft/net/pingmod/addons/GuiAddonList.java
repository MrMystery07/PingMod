package net.pingmod.addons;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.GlStateManager;
import net.pingmod.altmanager.AccountUtils;
import net.pingmod.utils.UIButton;

public class GuiAddonList extends GuiSlot {

	int selected = -1;
	public static List<String> addonList;

	public GuiAddonList(Minecraft mcIn, List<String> list) {
		super(mcIn, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight, 36,
				Minecraft.getMinecraft().displayHeight - 56, 30);
		addonList = list;
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
		if (this.selected < 0 || this.selected >= addonList.size())
			return null;
		return addonList.get(this.selected);
	}

	protected int getSize() {
		return addonList.size();
	}

	protected void drawSlot(int p_180791_1_, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_,
			int p_180791_6_) {

		String alt = addonList.get(p_180791_1_);
		this.mc.fontRendererObj.drawString(alt.split(":")[0], p_180791_2_ + 31, p_180791_3_ + 3, 0xffffff);
		String tags = "";
		tags = "§7" + alt.split(":")[1];

		this.mc.fontRendererObj.drawString(tags, p_180791_2_ + 31, p_180791_3_ + 15, 0xffffff);
		AddonUtils.drawAltFace(p_180791_2_ + 1, p_180791_3_ + 1, 24, 24, isSelected(p_180791_1_));
	}

	public void elementClicked(int index, boolean doubleClick, int var3, int var4) {
		if (index >= 0 && index < addonList.size())
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
