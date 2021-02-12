package net.pingmod.addons;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class AddonUtils {

	  private static void bindSkinTexture() {
		    ResourceLocation location = new ResourceLocation("pingmod/addon.png");
		    Minecraft.getMinecraft().getTextureManager().bindTexture(location);
		  }
		  
		  public static void drawAltFace(int x, int y, int w, int h, boolean selected) {
		    try {
		      bindSkinTexture();
		      GL11.glEnable(3042);
		      if (selected) {
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		      } else {
		        GL11.glColor4f(0.9F, 0.9F, 0.9F, 1.0F);
		      } 
		      float fw = 192.0F;
		      float fh = 192.0F;
		      float u = 24.0F;
		      float v = 24.0F;
		      Gui.drawModalRectWithCustomSizedTexture(x, y, 23, 23.3F, w, h, 23.5F, 23.5F);
		      fw = 192.0F;
		      fh = 192.0F;
		      u = 120.0F;
		      v = 24.0F;
		      //Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, w, h, fw, fh);
		      GL11.glDisable(3042);
		    } catch (Exception e) {
		      e.printStackTrace();
		    } 
		  }
	
}
