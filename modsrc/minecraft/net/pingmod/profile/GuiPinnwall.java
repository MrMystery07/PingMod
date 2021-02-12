package net.pingmod.profile;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.MathHelper;
import net.pingmod.altmanager.GuiAccountMenu;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;

public class GuiPinnwall extends GuiScreen {

	public static List<String> toDo = new ArrayList<String>();
	public static List<String> x = new ArrayList<String>();
	public static List<String> y = new ArrayList<String>();
	public static boolean clicked = false;
	public static boolean update = false;
	public static int initMouse = 0;
	public static boolean deleteEnabled = false;
	public static GuiButton deleteButton;

	public GuiPinnwall(boolean clicked2) {
		clicked = clicked2;
	}

	@Override
	public void initGui() {

		this.buttonList.add(new UIButton(0, this.width / 2 - 100, this.height - 30, 98, 20, "Hinzufügen"));
		this.buttonList.add(deleteButton = new UIButton(9, this.width / 2, this.height - 30, 98, 20, "Löschen"));
		GuiButton profileButton;
		GuiButton profileButton2;
		this.buttonList.add(profileButton = new UIButton(1, this.width - 70, 5, 65, 20, "Dein Profil"));
		this.buttonList.add(new UIButton(2, this.width - 140, 5, 65, 20, "Accounts"));
		this.buttonList.add(new UIButton(3, 5, 5, 65, 20, "Mehrspieler"));
//		this.buttonList.add(new UIButton(4, 72, 5, 60, 20, "Teamspeak"));
		this.buttonList.add(new UIButton(5, 5, 27, 80, 12, "Mein Profil"));
		this.buttonList.add(new UIButton(6, 87, 27, 70, 12, "Trustlisten"));
		this.buttonList.add(new UIButton(7, 87 + 72, 27, 85, 12, "Transaktionen"));
		this.buttonList.add(profileButton2 = new UIButton(8, 87 + 72 + 87, 27, 65, 12, "Pinnwand"));
		toDo.clear();
		x.clear();
		y.clear();
		PinnwallUtils.loadLists();
		
		for (int i = 0; i < PinnwallUtils.list.size(); i++) {
			
			toDo.add(PinnwallUtils.list.get(i).split(":")[2] + ":" + PinnwallUtils.list.get(i).split(":")[3]);
			
			x.add(PinnwallUtils.list.get(i).split(":")[0]);
			
			y.add(PinnwallUtils.list.get(i).split(":")[1]);
		}
		
		profileButton.enabled = false;
		profileButton2.enabled = false;

		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 0) {
			this.mc.displayGuiScreen(new GuiPinnwallAdd());
		}
		if(button.id == 9) {
			deleteEnabled = true;
			deleteButton.enabled = false;
		}
		
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		if(button.id == 3) {
			this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu(), 0));
		}
		if(button.id == 5) {
			this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu(), 0));
		}
		if(button.id == 6) {
			this.mc.displayGuiScreen(new GuiTrustlist());
		}
		if(button.id == 7) {
			this.mc.displayGuiScreen(new GuiTransaktionen());
		}
		super.actionPerformed(button);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		ColorUtils.background();
		List<String> newX = new ArrayList<String>();
		List<String> newY = new ArrayList<String>();
		
		for (int i = 0; i < toDo.size(); i++) {
			boolean hovered = false;
			
			hovered = mouseX >= Integer.valueOf(x.get(i)) && mouseY >= Integer.valueOf(y.get(i))
					&& mouseX < Integer.valueOf(x.get(i)) + 100 && mouseY < Integer.valueOf(y.get(i)) + 20;
			if (hovered) {
				Gui.drawRect(Integer.valueOf(x.get(i)), Integer.valueOf(y.get(i)), Integer.valueOf(x.get(i)) + 100,
						Integer.valueOf(y.get(i)) + 20, new Color(38, 222, 129).getRGB());
			} else {
				Gui.drawRect(Integer.valueOf(x.get(i)), Integer.valueOf(y.get(i)), Integer.valueOf(x.get(i)) + 100,
						Integer.valueOf(y.get(i)) + 20, new Color(43, 203, 186).getRGB());
			}
			drawCenteredString(fontRendererObj, toDo.get(i).split(":")[0], Integer.valueOf(x.get(i)) + 50,
					Integer.valueOf(y.get(i)) + 1, new Color(255, 255, 255).getRGB());
			GlStateManager.scale(0.5, 0.5, 0.5);
			drawCenteredString(fontRendererObj, toDo.get(i).split(":")[1], (Integer.valueOf(x.get(i)) + 50) * 2,
					(Integer.valueOf(y.get(i)) + 10) * 2, new Color(255, 255, 255).getRGB());
			GlStateManager.scale(2, 2, 2);
			PinnwallUtils.editAccount(toDo.get(i).split(":")[0], x.get(i), y.get(i), toDo.get(i).split(":")[0] + ":" + toDo.get(i).split(":")[1]);
			
			if (clicked == true && mouseX >= Integer.valueOf(x.get(i)) && mouseY >= Integer.valueOf(y.get(i))
					&& mouseX < Integer.valueOf(x.get(i)) + 100 && mouseY < Integer.valueOf(y.get(i)) + 20) {
				if(deleteEnabled == false) {
				String x2 = String.valueOf(mouseX - 50);

				if(Integer.valueOf(x2) <= 0) {
					x2 = "0";
				}
				
				if(Integer.valueOf(x2) >= this.width-100) {
					x2 = String.valueOf(this.width-100);
				}
				String y2 = String.valueOf(mouseY - 10);
				
				if(Integer.valueOf(y2) <= 38) {
					y2 = String.valueOf(38);
				}
				if(Integer.valueOf(y2) >= this.height - 56) {
					y2 = String.valueOf(this.height-56);
				}
				
				for (int i2 = 0; i2 < x.size(); i2++) {
					if (i2 == i) {
						newX.add(x2);
					} else {
						newX.add(x.get(i2));
					}
				}
				
				
				
				for (int i3 = 0; i3 < y.size(); i3++) {
					if (i3 == i) {
						newY.add(y2);
					} else {
						newY.add(y.get(i3));
					}
				}
				x.clear();
				for (int i2 = 0; i2 < newX.size(); i2++) {
					x.add(newX.get(i2));
				}
				y.clear();
				for (int i3 = 0; i3 < newY.size(); i3++) {
					y.add(newY.get(i3));
				}
				}else{
					PinnwallUtils.deleteAccount(toDo.get(i).split(":")[0]);
					PinnwallUtils.loadLists();
					toDo.clear();
					x.clear();
					y.clear();
					PinnwallUtils.loadLists();
					
					for (int i2 = 0; i2 < PinnwallUtils.list.size(); i2++) {
						
						toDo.add(PinnwallUtils.list.get(i2).split(":")[2] + ":" + PinnwallUtils.list.get(i2).split(":")[3]);
						
						x.add(PinnwallUtils.list.get(i2).split(":")[0]);
						
						y.add(PinnwallUtils.list.get(i2).split(":")[1]);
					}
					deleteEnabled = false;
					deleteButton.enabled = true;
				}
			}

//			if(update) {
//				x.clear();
//				for(int i2 = 0; i2 < newX.size(); i2++) {
//					x.add(newX.get(i2));
//				}
//				y.clear();
//				for(int i3 = 0; i3 < newY.size(); i3++) {
//					y.add(newY.get(i3));
//				}
//				update = false;
//			}

		}

		GL11.glDisable(3042);

		GL11.glDisable(3553);
		GL11.glDisable(2884);
		GL11.glEnable(3042);
		GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
		GL11.glBegin(7);

		int x = 100;
		int y = 100;

		GL11.glVertex2d((x), (x + 100));
		GL11.glVertex2d((y), (y + 100));
		GL11.glVertex2d((y), (y + 100));
		GL11.glVertex2d((x), (x + 100));

		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glEnable(2884);
		GL11.glDisable(3042);

		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		Tessellator var6 = Tessellator.getInstance();
		WorldRenderer var7 = var6.getWorldRenderer();
		// this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		float var8 = 32.0F;

		GlStateManager.disableDepth();
		byte var11 = 4;
		// this.overlayBackground(0, this.top, 255, 255);
		// this.overlayBackground(this.bottom, this.height, 255, 255);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
		GlStateManager.disableAlpha();
		GlStateManager.shadeModel(7425);
		GlStateManager.func_179090_x();
		var7.startDrawingQuads();
		var7.func_178974_a(0, 0);
		var7.addVertexWithUV((double) 0, (double) (10 + var11 + 28), 0.0D, 0.0D, 1.0D);
		var7.addVertexWithUV((double) this.width + 10000, (double) (10 + var11 + 28), 0.0D, 1.0D, 1.0D);
		var7.func_178974_a(0, 255);
		var7.addVertexWithUV((double) this.width + 10000, (double) 10 + 28, 0.0D, 1.0D, 0.0D);
		var7.addVertexWithUV((double) 0, (double) 10 + 28, 0.0D, 0.0D, 0.0D);
		var6.draw();
		var7.startDrawingQuads();
		var7.func_178974_a(0, 255);
		var7.addVertexWithUV((double) 0, (double) this.height - 36, 0.0D, 0.0D, 1.0D);
		var7.addVertexWithUV((double) this.width, (double) this.height - 36, 0.0D, 1.0D, 1.0D);
		var7.func_178974_a(0, 0);
		var7.addVertexWithUV((double) this.width, (double) (this.height - 36 - var11), 0.0D, 1.0D, 0.0D);
		var7.addVertexWithUV((double) 0, (double) (this.height - 36 - var11), 0.0D, 0.0D, 0.0D);
		var6.draw();

		GlStateManager.func_179098_w();
		GlStateManager.shadeModel(7424);
		GlStateManager.enableAlpha();
		GlStateManager.disableBlend();

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

		clicked = true;

		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {

		clicked = false;
		if (initMouse == 1) {
			update = true;
		}
		initMouse = 1;

		super.mouseReleased(mouseX, mouseY, state);
	}

}
