package net.pingmod.utils;

import java.io.IOException;import net.pingmod.utils.UIButton;
import java.util.HashSet;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;

public class RenderUtils {

	  private static final Minecraft mc = Minecraft.getMinecraft();
	  
	  private static final HashSet<String> loadedSkins = new HashSet<String>();
	  
	  private static void bindSkinTexture(String name) {
	    ResourceLocation location = AbstractClientPlayer.getLocationSkin(name + ".png");
	    if (loadedSkins.contains(name)) {
	      mc.getTextureManager().bindTexture(location);
	      return;
	    } 
	    try {
	      ThreadDownloadImageData img = 
	        AbstractClientPlayer.getDownloadImageSkin(location, name);
	      img.loadTexture(mc.getResourceManager());
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	    mc.getTextureManager().bindTexture(location);
	    loadedSkins.add(name);
	  }
	  
	  public static void drawAltFace(String name, int x, int y, int w, int h, boolean selected) {
	    try {
	      bindSkinTexture(name);
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
	      Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, w, h, fw, fh);
	      fw = 192.0F;
	      fh = 192.0F;
	      u = 120.0F;
	      v = 24.0F;
	      Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, w, h, fw, fh);
	      GL11.glDisable(3042);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
}
