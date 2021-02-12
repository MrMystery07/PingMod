package net.pingmod.profile;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import net.pingmod.utils.UIButton;
import net.pingmod.utils.UITrueFalseButton;

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
import net.minecraft.util.ResourceLocation;
import net.pingmod.addons.GuiAddonList;
import net.pingmod.altmanager.AccountUtils;
import net.pingmod.altmanager.GuiAccountMenu;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.PingMod;

public class GuiProfile extends GuiScreen {

	public static int height2;
	public static int width2;

	public static List<String> news = new ArrayList<String>();
	public static List<String> messanges = new ArrayList<String>();

	public static String server = "x-mod.team";
	public static String addons = "0";
	public static String cosmetics = "0";
	public static String emotes = "0";
	
	public static UITrueFalseButton slider;
	
	private int top = 10;

	@Override
	public void initGui() {
		news.clear();
		messanges.clear();
		UIButton profileButton;
		UIButton profileButton2;
		news.add("PingMod Beta:Die PingMod Beta wurde exportiert!:03.02.2021:");
		this.buttonList.add(profileButton = new UIButton(0, this.width - 70, 5, 65, 20, "Dein Profil"));
		this.buttonList.add(new UIButton(1, this.width - 140, 5, 65, 20, "Accounts"));
		this.buttonList.add(new UIButton(2, 5, 5, 65, 20, "Mehrspieler"));
//		this.buttonList.add(new UIButton(3, 72, 5, 60, 20, "Teamspeak"));
		this.buttonList.add(profileButton2 = new UIButton(4, 5, 27, 80, 12, "Mein Profil"));
		this.buttonList.add(new UIButton(5, 87, 27, 70, 12, "Trustlisten"));
		this.buttonList.add(new UIButton(6, 87 + 72, 27, 85, 12, "Transaktionen"));
		this.buttonList.add(new UIButton(7, 87 + 72 + 87, 27, 65, 12, "Pinnwand"));
		profileButton.enabled = false;
		profileButton2.enabled = false;
//		messanges.add("DevManuu:Das ist die erste Zeile:Das ist die zweite Zeile:01.01.2020:");
//		messanges.add("FlooTastisch:Das ist die erste Zeile:Das ist die zweite Zeile:02.02.2010:");
//		messanges.add("AbgegrieftHD:Das ist die erste Zeile:Das ist die zweite Zeile:03.03.2020:");
//		messanges.add("DevManuu:Das ist die erste Zeile:Das ist die zweite Zeile:01.01.2020:");
//		messanges.add("FlooTastisch:Das ist die erste Zeile:Das ist die zweite Zeile:02.02.2010:");
//		messanges.add("AbgegrieftHD:Das ist die erste Zeile:Das ist die zweite Zeile:03.03.2020:");
		messanges.add("x_MrMystery_x:Danke für's herunterladen §b@"+ Minecraft.getMinecraft().getSession().getUsername() +":§r§7Sollten Fehler mit den Köpfen auftreten, bitte MC neustarten.:10.02.2021:");
		
//		for(int i = 0; i < messanges.size(); i++) {
//			File file = new File(
//					"C:/Users/cziep/Desktop/PingMod-All/PingMod-1.8.0/workspace/src/minecraft/assets/minecraft/pingmod/"
//							+ messanges.get(i).split(":")[0] + ".png");
//			if(!file.exists()) {
//			try {
//				try {
//					InputStream in = new URL("https://cravatar.eu/helmavatar/" + messanges.get(i).split(":")[0] + "/64.png").openStream();		
//					Files.copy(in, Paths.get(file.getAbsolutePath()));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}catch (Exception e) {
//			}
//			}
//		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		if(button.id == 2) {
			this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu(), 0));
		}
		if(button.id == 5) {
			this.mc.displayGuiScreen(new GuiTrustlist());
		}
		if(button.id == 6) {
			this.mc.displayGuiScreen(new GuiTransaktionen());
		}
		if(button.id == 7) {
			this.mc.displayGuiScreen(new GuiPinnwall(false));
		}
		if(button.id == 10) {
			if(slider.enabled) {
				slider.enabled = false;
			}else {
				slider.enabled = true;
			}
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		height2 = this.height;
		width2 = this.width;
		ColorUtils.background();
		Gui.drawRect(0, 0, this.width, 38, new Color(0, 0, 236).getRGB());
		// Gui.drawRect(7, 140, 207, 45, Integer.MIN_VALUE);
		Gui.drawRect(7, 60, this.width / 2 - 5, 45, new Color(0, 0, 236).getRGB());
		Gui.drawRect(this.width / 2 + 5, 60, this.width - 7, 45, new Color(0, 0, 236).getRGB());
		Gui.drawRect(7, this.height / 2 + 25, this.width / 2 - 5, this.height / 2 + 40, new Color(0, 0, 236).getRGB());

		Gui.drawRect((this.width / 2 - 5) / 4, 62, 9, 72, new Color(0, 0, 236).getRGB());
		Gui.drawRect(this.width / 2 - 7, 62, ((this.width / 2 - 5) / 4) * 3, 72, new Color(0, 0, 236).getRGB());
		Gui.drawRect((this.width / 2 - 5) / 4, (60 + (this.height + 15)) / 3 - 10, 9, (60 + (this.height + 15)) / 3,
				new Color(0, 0, 236).getRGB());
		Gui.drawRect(this.width / 2 - 7, (60 + (this.height + 15)) / 3 - 10, ((this.width / 2 - 5) / 4) * 3,
				(60 + (this.height + 15)) / 3, new Color(0, 0, 236).getRGB());
		Gui.drawRect(this.width / 3 + 12, 62, (this.width / 2 - 5) / 4 + 2, 72, new Color(0, 0, 236).getRGB());
		this.drawString(fontRendererObj, "Profilinformationen", 9, 48, 0xffffff);
		this.drawString(fontRendererObj, "Nachrichten", this.width / 2 + 5 + 2, 48, 0xffffff);
		this.drawString(fontRendererObj, "News", 9, this.height / 2 + 28, 0xffffff);

		this.mc.getTextureManager().bindTexture(new ResourceLocation("pingmod/profilinfos.png"));
		float fw = 192.0F;
		float fh = 192.0F;
		float u = 24.0F;
		float v = 24.0F;

		Gui.drawModalRectWithCustomSizedTexture(this.width / 2 - 85, -19, u, v, 100, 100, fw, fh);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("pingmod/message.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width - 88, -19, u, v, 100, 100, fw, fh);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("pingmod/zeitung.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / 2 - 85, this.height / 3 - 5, u, v, 100, 100, fw, fh);
		
//		File file = new File(
//				"C:/Users/cziep/Desktop/PingMod-All/PingMod-1.8.0/workspace/src/minecraft/assets/minecraft/pingmod/"
//						+ Minecraft.getMinecraft().session.getUsername() + ".png");
//		if(!file.exists()) {
//		try (InputStream in = new URL("https://cravatar.eu/helmavatar/" + Minecraft.getMinecraft().session.getUsername() + "/64.png").openStream()) {
//			try {
//				Files.copy(in, Paths.get(file.getAbsolutePath()));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		}
//		
//		this.mc.getTextureManager().bindTexture(new ResourceLocation("pingmod/" + Minecraft.getMinecraft().session.getUsername() + ".png"));
//		GL11.glEnable(3042);
//			GL11.glColor4f(0.9F, 0.9F, 0.9F, 1.0F);
//		Gui.drawModalRectWithCustomSizedTexture(5, 5, 23, 23.0F, 23, 23, 23.0F, 23.0F);
		GL11.glDisable(3042);

		GL11.glDisable(3553);
		GL11.glDisable(2884);
		GL11.glEnable(3042);
		GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
		GL11.glBegin(7);

		GL11.glVertex2d((9 - 2), (this.height / 2 + 40));
		GL11.glVertex2d((this.width / 2 - 5), (this.height / 2 + 40));
		GL11.glVertex2d((this.width / 2 - 5), (this.height - 5));
		GL11.glVertex2d((9 - 2), (this.height - 5));

		GL11.glVertex2d((this.width / 2 + 5), (62 - 2));
		GL11.glVertex2d((this.width - 7), (62 - 2));
		GL11.glVertex2d((this.width - 7), (this.height - 5));
		GL11.glVertex2d((this.width / 2 + 5), (this.height - 5));

		GL11.glVertex2d((9 - 2), (62 - 2));
		GL11.glVertex2d((this.width / 2 - 5), (62 - 2));
		GL11.glVertex2d((this.width / 2 - 5), (this.height / 2 + 15));
		GL11.glVertex2d((9 - 2), (this.height / 2 + 15));

		GL11.glVertex2d(((this.width / 2 - 5) / 4 + 2), (62));
		GL11.glVertex2d((this.width / 3 + 12), (62));
		GL11.glVertex2d((this.width / 3 + 12), (this.height / 2 + 13));
		GL11.glVertex2d(((this.width / 2 - 5) / 4 + 2), (this.height / 2 + 13));

		GL11.glVertex2d((9), (62));
		GL11.glVertex2d(((this.width / 2 - 5) / 4), (62));
		GL11.glVertex2d(((this.width / 2 - 5) / 4), ((60 + (this.height + 15)) / 3 - 10 - 2));
		GL11.glVertex2d((9), ((60 + (this.height + 15)) / 3 - 10 - 2));

		GL11.glVertex2d((this.width / 2 - 7), (62));
		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), (62));
		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), ((60 + (this.height + 15)) / 3 - 10 - 2));
		GL11.glVertex2d((this.width / 2 - 7), ((60 + (this.height + 15)) / 3 - 10 - 2));

		GL11.glVertex2d((this.width / 2 - 7), ((60 + (this.height + 15)) / 3 - 10));
		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), ((60 + (this.height + 15)) / 3 - 10));
		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), (this.height / 2 + 13));
		GL11.glVertex2d((this.width / 2 - 7), (this.height / 2 + 13));

		GL11.glVertex2d((9), ((60 + (this.height + 15)) / 3 - 10));
		GL11.glVertex2d(((this.width / 2 - 5) / 4), ((60 + (this.height + 15)) / 3 - 10));
		GL11.glVertex2d(((this.width / 2 - 5) / 4), (this.height / 2 + 13));
		GL11.glVertex2d((9), (this.height / 2 + 13));

		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glEnable(2884);
		GL11.glDisable(3042);

		drawNews();
		drawMessages();
		
		GlStateManager.scale(0.8, 0.8, 0.8);
		Minecraft.getMinecraft().fontRendererObj.drawString("Emotes", 22, 79, 0xffffff);
		Minecraft.getMinecraft().fontRendererObj.drawString("Cosmetics", 15, this.height/2, 0xffffff);
		Minecraft.getMinecraft().fontRendererObj.drawString("Addons", this.width / 2-5, 79, 0xffffff);
		Minecraft.getMinecraft().fontRendererObj.drawString("Spielzeit", this.width / 2-6, this.height/2, 0xffffff);
		Minecraft.getMinecraft().fontRendererObj.drawString("Lieblings Server", this.width / 5 + 8, 79, 0xffffff);
		GlStateManager.scale(1.25, 1.25, 1.25);
		GlStateManager.scale(1.8, 1.8, 1.8);
		drawCenteredString(fontRendererObj, emotes, this.width / 25, this.height / 6 + 1, 0xffffff);
		drawCenteredString(fontRendererObj, cosmetics, this.width / 25, this.height / 4  + 2, 0xffffff);
		drawCenteredString(fontRendererObj, addons, this.width / 4 - 6, this.height / 6 + 1, 0xffffff);
		drawCenteredString(fontRendererObj, PingMod.onlinetimewithpingmod + "h", this.width / 4 - 5, this.height / 4  + 2, 0xffffff);
		GlStateManager.scale(0.55555555555, 0.55555555555, 0.55555555555);
        int var4;

        for (var4 = 0; var4 < this.buttonList.size(); ++var4)
        {
            ((GuiButton)this.buttonList.get(var4)).drawButton(this.mc, mouseX, mouseY);
        }
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
		GlStateManager.translate(Minecraft.getMinecraft().displayWidth - (Minecraft.getMinecraft().displayWidth * 2), 0,
				0);
		var7.startDrawingQuads();
		var7.func_178974_a(0, 0);
		var7.addVertexWithUV((double) this.height, (double) (this.top + var11 + 28), 0.0D, 0.0D, 1.0D);
		var7.addVertexWithUV((double) this.width + 10000, (double) (this.top + var11 + 28), 0.0D, 1.0D, 1.0D);
		var7.func_178974_a(0, 255);
		var7.addVertexWithUV((double) this.width + 10000, (double) this.top + 28, 0.0D, 1.0D, 0.0D);
		var7.addVertexWithUV((double) this.height, (double) this.top + 28, 0.0D, 0.0D, 0.0D);
		var6.draw();

		GlStateManager.func_179098_w();
		GlStateManager.shadeModel(7424);
		GlStateManager.enableAlpha();
		GlStateManager.disableBlend();

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public static void drawNews() {
		if (news.size() == 0) {

		}
		if (news.size() == 1 || news.size() == 2 || news.size() == 3) {
			Gui.drawRect(9, height2 / 2 + 40 + 4, width2 / 2 - 5 - 4, height2 / 2 + 40 + 4 + 20,
					new Color(31, 58, 255).getRGB());
			Gui.drawRect(9, height2 / 2 + 40 + 4, 9 + 2, height2 / 2 + 40 + 4 + 20, new Color(38, 222, 129).getRGB());
			String title = "";
			String description = "";
			String updated = "";
			title = "§f" + news.get(0).split(":")[0];
			description = "§7" + news.get(0).split(":")[1];
			updated = "§aUpdated: §a" + news.get(0).split(":")[2];
			GL11.glScaled(0.5, 0.5, 0.5);
			Minecraft.getMinecraft().fontRendererObj.drawString(title, 28, height2 + 40 + 4 + 2 + 45, 0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(description, 28, height2 + 40 + 4 + 2 + 56 + 3,
					0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(updated, 28, height2 + 40 + 4 + 2 + 56 + 3 + 13,
					0xffffff);
			GL11.glScaled(2.0, 2.0, 2.0);
		}
		if (news.size() == 2 || news.size() == 3) {
			Gui.drawRect(9, height2 / 2 + 40 + 4 + 20 + 4, width2 / 2 - 5 - 4, height2 / 2 + 40 + 4 + 20 + 4 + 20,
					new Color(31, 58, 255).getRGB());
			Gui.drawRect(9, height2 / 2 + 40 + 4 + 20 + 4, 9 + 2, height2 / 2 + 40 + 4 + 20 + 4 + 20,
					new Color(38, 222, 129).getRGB());
			String title = "";
			String description = "";
			String updated = "";
			title = "§f" + news.get(1).split(":")[0];
			description = "§7" + news.get(1).split(":")[1];
			updated = "§aUpdated: §a" + news.get(1).split(":")[2];
			GL11.glScaled(0.5, 0.5, 0.5);
			Minecraft.getMinecraft().fontRendererObj.drawString(title, 28, height2 + 40 + 4 + 2 + 45 + 20 + 4 + 20 + 4,
					0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(description, 28,
					height2 + 40 + 4 + 2 + 56 + 3 + 20 + 4 + 20 + 4, 0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(updated, 28,
					height2 + 40 + 4 + 2 + 56 + 3 + 13 + 20 + 4 + 20 + 4, 0xffffff);
			GL11.glScaled(2.0, 2.0, 2.0);
		}
		if (news.size() == 3) {
			Gui.drawRect(9, height2 / 2 + 40 + 4 + 20 + 4 + 20 + 4, width2 / 2 - 5 - 4,
					height2 / 2 + 40 + 4 + 20 + 4 + 20 + 20 + 4, new Color(31, 58, 255).getRGB());
			Gui.drawRect(9, height2 / 2 + 40 + 4 + 20 + 4 + 20 + 4, 9 + 2, height2 / 2 + 40 + 4 + 20 + 4 + 20 + 20 + 4,
					new Color(38, 222, 129).getRGB());
			String title = "";
			String description = "";
			String updated = "";
			title = "§f" + news.get(2).split(":")[0];
			description = "§7" + news.get(2).split(":")[1];
			updated = "§aUpdated: §a" + news.get(2).split(":")[2];
			GL11.glScaled(0.5, 0.5, 0.5);
			Minecraft.getMinecraft().fontRendererObj.drawString(title, 28,
					height2 + 40 + 4 + 2 + 45 + 20 + 4 + 20 + 4 + 20 + 4 + 20 + 4, 0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(description, 28,
					height2 + 40 + 4 + 2 + 56 + 3 + 20 + 4 + 20 + 4 + 20 + 4 + 20 + 4, 0xffffff);
			Minecraft.getMinecraft().fontRendererObj.drawString(updated, 28,
					height2 + 40 + 4 + 2 + 56 + 3 + 13 + 20 + 4 + 20 + 4 + 20 + 4 + 20 + 4, 0xffffff);
			GL11.glScaled(2.0, 2.0, 2.0);
		}
	}

	public static void drawMessages() {
		int distance = 0;
		for (int i = 0; i < messanges.size(); i++) {
			if (i != 6) {
				Gui.drawRect(width2 / 2 + 5 + 2, 60 + 2 + distance, width2 - 7 - 2, 60 + 2 + 20 + 7 + distance,
						new Color(31, 58, 255).getRGB());
				Gui.drawRect(width2 / 2 + 5 + 2, 60 + 2 + distance, width2 / 2 + 5 + 2 + 2, 60 + 2 + 20 + 7 + distance,
						new Color(38, 222, 129).getRGB());
				AccountUtils.drawAltFace(width2 / 2 + 5 + 2 + 2 + 2, 60 + 2 + 2 + distance, 23, 23, true,
						messanges.get(i).split(":")[0]);

				Minecraft.getMinecraft().fontRendererObj.drawString(messanges.get(i).split(":")[0],
						width2 / 2 + 5 + 2 + 30, 60 + 4 + distance, 0xffffff);
				Minecraft.getMinecraft().fontRendererObj.drawString("§a" + messanges.get(i).split(":")[3], width2 - 60,
						60 + 4 + distance, 0xffffff);

				GL11.glScaled(0.5, 0.5, 0.5);
				Minecraft.getMinecraft().fontRendererObj.drawString("§7" + messanges.get(i).split(":")[1],
						(width2 / 2 + 5 + 2 + 30) * 2, (60 + 14 + distance) * 2, 0xffffff);
				Minecraft.getMinecraft().fontRendererObj.drawString("§7" + messanges.get(i).split(":")[2],
						(width2 / 2 + 5 + 2 + 30) * 2, (60 + 20 + distance) * 2, 0xffffff);
				GL11.glScaled(2.0, 2.0, 2.0);
				distance = distance + 29;
			}
		}
	}

}
