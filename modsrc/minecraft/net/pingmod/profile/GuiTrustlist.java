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
import net.minecraft.util.ResourceLocation;
import net.pingmod.altmanager.GuiAccountMenu;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.PingMod;
import net.pingmod.utils.UIButton;
import net.pingmod.utils.UITrueFalseButton;

public class GuiTrustlist extends GuiScreen {

	private int top = 10;
	public static int idsTrust;
	public static int distance = 71;
	public static int heightCount = 62;
	public static List<String> trust = new ArrayList<String>();
	public static int line = 0;
	
	public static int idsScam;
	public static int distanceScam;
	public static int heightCountScam = 62;
	public static List<String> scam = new ArrayList<String>();
	public static int lineScam = 0;
	
	@Override
	public void initGui() {
		distanceScam = this.width/2+69;
		UIButton profileButton;
		UIButton profileButton2;
		ProfileUitls.loadListTrust();
		ProfileUitls.loadListScam();
		trust = ProfileUitls.listTrust;
		scam = ProfileUitls.listScam;
		this.buttonList.add(profileButton = new UIButton(100, this.width - 70, 5, 65, 20, "Dein Profil"));
		this.buttonList.add(new UIButton(101, this.width - 140, 5, 65, 20, "Accounts"));
		this.buttonList.add(new UIButton(102, 5, 5, 65, 20, "Mehrspieler"));
//		this.buttonList.add(new UIButton(103, 72, 5, 60, 20, "Teamspeak"));
		this.buttonList.add(new UIButton(104, 5, 27, 80, 12, "Mein Profil"));
		this.buttonList.add(profileButton2 = new UIButton(105, 87, 27, 70, 12, "Trustlisten"));
		this.buttonList.add(new UIButton(108, 87 + 72, 27, 85, 12, "Transaktionen"));
		this.buttonList.add(new UIButton(109, 87 + 72 + 87, 27, 65, 12, "Pinnwand"));
		this.buttonList.add(new UIButtonForTrustlisten(106, 9, 62));
//		this.buttonList.add(new UIButtonForTrustlisten(107, this.width/2 + 7, 62));
		profileButton.enabled = false;
		profileButton2.enabled = false;
		
		distance = 71;
		line = 0;
		heightCount = 62;
		idsTrust = 0;
		
		for(int i = 0; i < trust.size(); i++) {
			System.out.println(i + ":" + line);
			if(line == 5 || line == 6 || line == 7 || line == 8 || line == 9) {
				System.out.println("LINE 2");
			this.buttonList.add(new UIButtonForTrustlistPlayer(i, distance, heightCount, trust.get(line)));
			idsTrust = i;
			distance = distance + 60 + 2;
			line++;
//			if(line == 5) {
//				distance = 71;
//				heightCount = 146;
//			}
			}
			if(line == 0 || line == 1 || line == 2 || line == 3 || line == 4) {
				System.out.println("LINE 1");
			this.buttonList.add(new UIButtonForTrustlistPlayer(i, distance, heightCount, trust.get(line)));
			idsTrust++;
			distance = distance + 60 + 2;
			line++;
			if(line == 5) {
				distance = 9;
				heightCount = 104;
			}
			}
		}
//		
//		
//		distanceScam = this.width/2+69;
//		lineScam = 0;
//		heightCountScam = 62;
//		idsScam = idsTrust + 1;
//	
//		for(int i = idsScam; i < scam.size(); i++) {
//			System.out.println(i + ":" + line);
//			
//			if(lineScam == 2 || lineScam == 3 || lineScam == 4) {
//				System.out.println("LINE 2");
//			this.buttonList.add(new UIButtonForTrustlistPlayer(i, distanceScam, heightCountScam, scam.get(lineScam)));
//			idsScam = i;
//			distanceScam = distanceScam + 60 + 2;
//			lineScam++;
//			if(lineScam == 5) {
//				distanceScam = this.width/2+69;
//				heightCountScam = 146;
//			}
//			}
//			if(lineScam == 0 || lineScam == 1) {
//				System.out.println("LINE 1");
//			this.buttonList.add(new UIButtonForTrustlistPlayer(i, distanceScam, heightCountScam, scam.get(lineScam)));
//			idsScam++;
//			distanceScam = distanceScam + 60 + 2;
//			lineScam++;
//			if(lineScam == 2) {
//				distanceScam = 9;
//				heightCountScam = 104;
//			}
//			}
//		}
		
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
        int var4;
        int count = 0;
        for (var4 = 0; var4 < this.buttonList.size(); ++var4)
        {
            if(((GuiButton)this.buttonList.get(var4)).id == button.id && ((GuiButton)this.buttonList.get(var4)).id != 100 && ((GuiButton)this.buttonList.get(var4)).id != 101 && ((GuiButton)this.buttonList.get(var4)).id != 102 && ((GuiButton)this.buttonList.get(var4)).id != 103 && ((GuiButton)this.buttonList.get(var4)).id != 104 && ((GuiButton)this.buttonList.get(var4)).id != 105 && ((GuiButton)this.buttonList.get(var4)).id != 106 && ((GuiButton)this.buttonList.get(var4)).id != 107&& ((GuiButton)this.buttonList.get(var4)).id != 108&& ((GuiButton)this.buttonList.get(var4)).id != 109) {
            	this.mc.displayGuiScreen(new GuiEditTrust(((GuiButton)this.buttonList.get(var4)).displayString));
            	count++;
            	break;
            }
           }
		if(button.id == 106) {
			this.mc.displayGuiScreen(new GuiAddTrust());
		}
		
		if(button.id == 101) {
			this.mc.displayGuiScreen(new GuiAccountMenu());
		}
		
		if(button.id == 102) {
			this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu(), 0));
		}
		if(button.id == 104) {
			this.mc.displayGuiScreen(new GuiProfile());
		}
		if(button.id == 107) {
			this.mc.displayGuiScreen(new GuiAddScam());
		}
		if(button.id == 108) {
			this.mc.displayGuiScreen(new GuiTransaktionen());
		}
		if(button.id == 109) {
			this.mc.displayGuiScreen(new GuiPinnwall(false));
		}
		super.actionPerformed(button);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ColorUtils.background();
		Gui.drawRect(0, 0, this.width, 38, new Color(0, 0, 236).getRGB());

		Gui.drawRect(7, 60, this.width - 7, 45, new Color(0, 0, 236).getRGB());
//		Gui.drawRect(this.width / 2 + 5, 60, this.width - 7, 45, new Color(0, 0, 236).getRGB());
		
		this.drawString(fontRendererObj, "Trustliste", 9, 48, 0xffffff);
//		this.drawString(fontRendererObj, "Scammerliste", this.width / 2 + 5 + 2, 48, 0xffffff);
		
		GL11.glDisable(3042);

		GL11.glDisable(3553);
		GL11.glDisable(2884);
		GL11.glEnable(3042);
		GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.4F);
		GL11.glBegin(7);

//		GL11.glVertex2d((this.width / 2 + 5), (62 - 2));
//		GL11.glVertex2d((this.width - 7), (62 - 2));
//		GL11.glVertex2d((this.width - 7), (this.height - 5));
//		GL11.glVertex2d((this.width / 2 + 5), (this.height - 5));

		GL11.glVertex2d((9 - 2), (62 - 2));
		GL11.glVertex2d((this.width -7), (62 - 2));
		GL11.glVertex2d((this.width -7), (this.height - 5));
		GL11.glVertex2d((9 - 2), (this.height - 5));

//		GL11.glVertex2d(((this.width / 2 - 5) / 4 + 2), (62));
//		GL11.glVertex2d((this.width / 3 + 12), (62));
//		GL11.glVertex2d((this.width / 3 + 12), (this.height / 2 + 13));
//		GL11.glVertex2d(((this.width / 2 - 5) / 4 + 2), (this.height / 2 + 13));

//		GL11.glVertex2d((9), (62));
//		GL11.glVertex2d(((this.width / 2 - 5) / 4), (62));
//		GL11.glVertex2d(((this.width / 2 - 5) / 4), ((60 + (this.height + 15)) / 3 - 10 - 2));
//		GL11.glVertex2d((9), ((60 + (this.height + 15)) / 3 - 10 - 2));
//
//		GL11.glVertex2d((this.width / 2 - 7), (62));
//		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), (62));
//		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), ((60 + (this.height + 15)) / 3 - 10 - 2));
//		GL11.glVertex2d((this.width / 2 - 7), ((60 + (this.height + 15)) / 3 - 10 - 2));

//		GL11.glVertex2d((this.width / 2 - 7), ((60 + (this.height + 15)) / 3 - 10));
//		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), ((60 + (this.height + 15)) / 3 - 10));
//		GL11.glVertex2d(((((this.width / 2 - 5) / 4) * 3)), (this.height / 2 + 13));
//		GL11.glVertex2d((this.width / 2 - 7), (this.height / 2 + 13));
//
//		GL11.glVertex2d((9), ((60 + (this.height + 15)) / 3 - 10));
//		GL11.glVertex2d(((this.width / 2 - 5) / 4), ((60 + (this.height + 15)) / 3 - 10));
//		GL11.glVertex2d(((this.width / 2 - 5) / 4), (this.height / 2 + 13));
//		GL11.glVertex2d((9), (this.height / 2 + 13));

		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glEnable(2884);
		GL11.glDisable(3042);
		
		//drawButton(this.width / 2, this.height / 2, true, mouseX, mouseY);
        int var4;
        int count = 0;
        for (var4 = 0; var4 < this.buttonList.size(); ++var4)
        {
            ((GuiButton)this.buttonList.get(var4)).drawButton(this.mc, mouseX, mouseY);
            if(((GuiButton)this.buttonList.get(var4)).id <= idsTrust || ((GuiButton)this.buttonList.get(var4)).id <= idsScam) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			ResourceLocation location = new ResourceLocation("pingmod/" + trust.get(count) + ".png");
			mc.getTextureManager().bindTexture(location);
			Gui.drawModalRectWithCustomSizedTexture(((GuiButton)this.buttonList.get(var4)).xPosition+18, ((GuiButton)this.buttonList.get(var4)).yPosition + 5, 23, 23.0F, 23, 23, 23.0F, 23.0F);
			count++;
            }
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
}
