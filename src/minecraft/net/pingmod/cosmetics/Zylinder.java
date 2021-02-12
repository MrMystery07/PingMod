package net.pingmod.cosmetics;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.pingmod.utils.ColorUtils;

public class Zylinder implements LayerRenderer{

	private final ZylinderHatRenderer classicHatRenderer;

	public Zylinder() {
		this.classicHatRenderer = new ZylinderHatRenderer();
	}

	@Override
	public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_,
			float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if(Controller.zylinder) {
			GL11.glPushMatrix();
			if (p_177141_1_.isSneaking()) {
				GlStateManager.translate(0, 0.255, 0);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("pingmod/white.png"));
			GlStateManager.color(1F, 1F, 1F);
			this.classicHatRenderer.render(p_177141_1_, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_,
					p_177141_8_);
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	public class ZylinderHatRenderer extends ModelBase {
		
	    ModelRenderer black1;
	    ModelRenderer black2;
	    ModelRenderer color1;
	    ModelRenderer black3;
		
		public ZylinderHatRenderer() {
		    textureWidth = 64;
		    textureHeight = 32;
		    
		      black1 = new ModelRenderer(this, 0, 0);
		      black1.addBox(0F, 0F, 0F, 10, 1, 10);
		      black1.setRotationPoint(-5F, -8F, -5F);
		      black1.setTextureSize(64, 32);
		      black1.mirror = true;
		      setRotation(black1, 0F, 0F, 0F);
		      black2 = new ModelRenderer(this, 0, 0);
		      black2.addBox(0F, 0F, 0F, 8, 1, 8);
		      black2.setRotationPoint(-4F, -9F, -4F);
		      black2.setTextureSize(64, 32);
		      black2.mirror = true;
		      setRotation(black2, 0F, 0F, 0F);
		      color1 = new ModelRenderer(this, 0, 0);
		      color1.addBox(0F, 0F, 0F, 8, 1, 8);
		      color1.setRotationPoint(-4F, -10F, -4F);
		      color1.setTextureSize(64, 32);
		      color1.mirror = true;
		      setRotation(color1, 0F, 0F, 0F);
		      black3 = new ModelRenderer(this, 0, 0);
		      black3.addBox(0F, 0F, 0F, 8, 5, 8);
		      black3.setRotationPoint(-4F, -15F, -4F);
		      black3.setTextureSize(64, 32);
		      black3.mirror = true;
		      setRotation(black3, 0F, 0F, 0F);
		    
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			GlStateManager.rotate(f3, 0, 1, 0);
			GlStateManager.rotate(f4, 1, 0, 0);
			GlStateManager.color(0.0F, 0.0F, 0.0F);
		    black1.render(f5);
		    black2.render(f5);
		    GlStateManager.color(1, 0, 1);
		    color1.render(f5);
		    GlStateManager.color(0.0F, 0.0F, 0.0F);
		    black3.render(f5);
			
		}
		
		  private void setRotation(ModelRenderer model, float x, float y, float z)
		  {
		    model.rotateAngleX = x;
		    model.rotateAngleY = y;
		    model.rotateAngleZ = z;
		  }
		  
		  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
		  {
		    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		  }
	}

	
}
