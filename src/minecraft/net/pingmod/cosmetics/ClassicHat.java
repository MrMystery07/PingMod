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

public class ClassicHat implements LayerRenderer{

	private final ClassicHatRenderer classicHatRenderer;

	public ClassicHat() {
		this.classicHatRenderer = new ClassicHatRenderer();
	}

	@Override
	public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_,
			float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if(Controller.classicHat) {
			GL11.glPushMatrix();
			if (p_177141_1_.isSneaking()) {
				GlStateManager.translate(0, 0.255, 0);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("pingmod/white.png"));
			GlStateManager.color(1F, 1, 1F);
			this.classicHatRenderer.render(p_177141_1_, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_,
					p_177141_8_);
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	public class ClassicHatRenderer extends ModelBase {
	    ModelRenderer black1;
	    ModelRenderer black2;
	    ModelRenderer Shape1;
	    ModelRenderer Shape2;
	    ModelRenderer Shape3;
	    ModelRenderer Shape4;
	    ModelRenderer Shape5;
	    ModelRenderer Shape6;
	    ModelRenderer Shape7;
	    ModelRenderer Shape8;
	    ModelRenderer Shape9;
	    ModelRenderer Shape10;
	    ModelRenderer Shape11;
	    ModelRenderer Shape12;
	    ModelRenderer Shape13;
	    ModelRenderer Shape14;
	    ModelRenderer Shape15;
	    ModelRenderer Shape16;
	    ModelRenderer Shape17;
	    ModelRenderer Shape18;
	    ModelRenderer Shape19;
	    ModelRenderer Shape20;
	    ModelRenderer Shape21;
	    ModelRenderer Shape22;
	    ModelRenderer Shape23;
	    ModelRenderer Shape24;
	    ModelRenderer Shape25;
	    ModelRenderer Shape26;
	    ModelRenderer Shape27;
	    ModelRenderer Shape28;
		public ClassicHatRenderer() {
		    textureWidth = 64;
		    textureHeight = 32;
		    
		      black1 = new ModelRenderer(this, 0, 0);
		      black1.addBox(0F, 0F, 0F, 14, 1, 14);
		      black1.setRotationPoint(-7F, -8F, -7F);
		      black1.setTextureSize(64, 32);
		      black1.mirror = true;
		      setRotation(black1, 0F, 0F, 0F);
		      black2 = new ModelRenderer(this, 0, 0);
		      black2.addBox(0F, 0F, 0F, 8, 2, 8);
		      black2.setRotationPoint(-4F, -11F, -4F);
		      black2.setTextureSize(64, 32);
		      black2.mirror = true;
		      setRotation(black2, 0F, 0F, 0F);
		      Shape1 = new ModelRenderer(this, 0, 0);
		      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape1.setRotationPoint(-4F, -9F, -4F);
		      Shape1.setTextureSize(64, 32);
		      Shape1.mirror = true;
		      setRotation(Shape1, 0F, 0F, 0F);
		      Shape2 = new ModelRenderer(this, 0, 0);
		      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape2.setRotationPoint(-3F, -9F, -4F);
		      Shape2.setTextureSize(64, 32);
		      Shape2.mirror = true;
		      setRotation(Shape2, 0F, 0F, 0F);
		      Shape3 = new ModelRenderer(this, 0, 0);
		      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape3.setRotationPoint(-2F, -9F, -4F);
		      Shape3.setTextureSize(64, 32);
		      Shape3.mirror = true;
		      setRotation(Shape3, 0F, 0F, 0F);
		      Shape4 = new ModelRenderer(this, 0, 0);
		      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape4.setRotationPoint(-1F, -9F, -4F);
		      Shape4.setTextureSize(64, 32);
		      Shape4.mirror = true;
		      setRotation(Shape4, 0F, 0F, 0F);
		      Shape5 = new ModelRenderer(this, 0, 0);
		      Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape5.setRotationPoint(0F, -9F, -4F);
		      Shape5.setTextureSize(64, 32);
		      Shape5.mirror = true;
		      setRotation(Shape5, 0F, 0F, 0F);
		      Shape6 = new ModelRenderer(this, 0, 0);
		      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape6.setRotationPoint(1F, -9F, -4F);
		      Shape6.setTextureSize(64, 32);
		      Shape6.mirror = true;
		      setRotation(Shape6, 0F, 0F, 0F);
		      Shape7 = new ModelRenderer(this, 0, 0);
		      Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape7.setRotationPoint(2F, -9F, -4F);
		      Shape7.setTextureSize(64, 32);
		      Shape7.mirror = true;
		      setRotation(Shape7, 0F, 0F, 0F);
		      Shape8 = new ModelRenderer(this, 0, 0);
		      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape8.setRotationPoint(3F, -9F, -4F);
		      Shape8.setTextureSize(64, 32);
		      Shape8.mirror = true;
		      setRotation(Shape8, 0F, 0F, 0F);
		      Shape9 = new ModelRenderer(this, 0, 0);
		      Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape9.setRotationPoint(3F, -9F, -3F);
		      Shape9.setTextureSize(64, 32);
		      Shape9.mirror = true;
		      setRotation(Shape9, 0F, 0F, 0F);
		      Shape10 = new ModelRenderer(this, 0, 0);
		      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape10.setRotationPoint(3F, -9F, -2F);
		      Shape10.setTextureSize(64, 32);
		      Shape10.mirror = true;
		      setRotation(Shape10, 0F, 0F, 0F);
		      Shape11 = new ModelRenderer(this, 0, 0);
		      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape11.setRotationPoint(3F, -9F, -1F);
		      Shape11.setTextureSize(64, 32);
		      Shape11.mirror = true;
		      setRotation(Shape11, 0F, 0F, 0F);
		      Shape12 = new ModelRenderer(this, 0, 0);
		      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape12.setRotationPoint(3F, -9F, 0F);
		      Shape12.setTextureSize(64, 32);
		      Shape12.mirror = true;
		      setRotation(Shape12, 0F, 0F, 0F);
		      Shape13 = new ModelRenderer(this, 0, 0);
		      Shape13.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape13.setRotationPoint(3F, -9F, 1F);
		      Shape13.setTextureSize(64, 32);
		      Shape13.mirror = true;
		      setRotation(Shape13, 0F, 0F, 0F);
		      Shape14 = new ModelRenderer(this, 0, 0);
		      Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape14.setRotationPoint(3F, -9F, 2F);
		      Shape14.setTextureSize(64, 32);
		      Shape14.mirror = true;
		      setRotation(Shape14, 0F, 0F, 0F);
		      Shape15 = new ModelRenderer(this, 0, 0);
		      Shape15.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape15.setRotationPoint(3F, -9F, 3F);
		      Shape15.setTextureSize(64, 32);
		      Shape15.mirror = true;
		      setRotation(Shape15, 0F, 0F, 0F);
		      Shape16 = new ModelRenderer(this, 0, 0);
		      Shape16.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape16.setRotationPoint(2F, -9F, 3F);
		      Shape16.setTextureSize(64, 32);
		      Shape16.mirror = true;
		      setRotation(Shape16, 0F, 0F, 0F);
		      Shape17 = new ModelRenderer(this, 0, 0);
		      Shape17.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape17.setRotationPoint(1F, -9F, 3F);
		      Shape17.setTextureSize(64, 32);
		      Shape17.mirror = true;
		      setRotation(Shape17, 0F, 0F, 0F);
		      Shape18 = new ModelRenderer(this, 0, 0);
		      Shape18.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape18.setRotationPoint(0F, -9F, 3F);
		      Shape18.setTextureSize(64, 32);
		      Shape18.mirror = true;
		      setRotation(Shape18, 0F, 0F, 0F);
		      Shape19 = new ModelRenderer(this, 0, 0);
		      Shape19.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape19.setRotationPoint(-1F, -9F, 3F);
		      Shape19.setTextureSize(64, 32);
		      Shape19.mirror = true;
		      setRotation(Shape19, 0F, 0F, 0F);
		      Shape20 = new ModelRenderer(this, 0, 0);
		      Shape20.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape20.setRotationPoint(-2F, -9F, 3F);
		      Shape20.setTextureSize(64, 32);
		      Shape20.mirror = true;
		      setRotation(Shape20, 0F, 0F, 0F);
		      Shape21 = new ModelRenderer(this, 0, 0);
		      Shape21.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape21.setRotationPoint(-3F, -9F, 3F);
		      Shape21.setTextureSize(64, 32);
		      Shape21.mirror = true;
		      setRotation(Shape21, 0F, 0F, 0F);
		      Shape22 = new ModelRenderer(this, 0, 0);
		      Shape22.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape22.setRotationPoint(-4F, -9F, 3F);
		      Shape22.setTextureSize(64, 32);
		      Shape22.mirror = true;
		      setRotation(Shape22, 0F, 0F, 0F);
		      Shape23 = new ModelRenderer(this, 0, 0);
		      Shape23.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape23.setRotationPoint(-4F, -9F, 2F);
		      Shape23.setTextureSize(64, 32);
		      Shape23.mirror = true;
		      setRotation(Shape23, 0F, 0F, 0F);
		      Shape24 = new ModelRenderer(this, 0, 0);
		      Shape24.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape24.setRotationPoint(-4F, -9F, 1F);
		      Shape24.setTextureSize(64, 32);
		      Shape24.mirror = true;
		      setRotation(Shape24, 0F, 0F, 0F);
		      Shape25 = new ModelRenderer(this, 0, 0);
		      Shape25.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape25.setRotationPoint(-4F, -9F, 0F);
		      Shape25.setTextureSize(64, 32);
		      Shape25.mirror = true;
		      setRotation(Shape25, 0F, 0F, 0F);
		      Shape26 = new ModelRenderer(this, 0, 0);
		      Shape26.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape26.setRotationPoint(-4F, -9F, -1F);
		      Shape26.setTextureSize(64, 32);
		      Shape26.mirror = true;
		      setRotation(Shape26, 0F, 0F, 0F);
		      Shape27 = new ModelRenderer(this, 0, 0);
		      Shape27.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape27.setRotationPoint(-4F, -9F, -2F);
		      Shape27.setTextureSize(64, 32);
		      Shape27.mirror = true;
		      setRotation(Shape27, 0F, 0F, 0F);
		      Shape28 = new ModelRenderer(this, 0, 0);
		      Shape28.addBox(0F, 0F, 0F, 1, 1, 1);
		      Shape28.setRotationPoint(-4F, -9F, -3F);
		      Shape28.setTextureSize(64, 32);
		      Shape28.mirror = true;
		      setRotation(Shape28, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			GlStateManager.rotate(f3, 0, 1, 0);
			GlStateManager.rotate(f4, 1, 0, 0);
			GlStateManager.color(0.0F, 0.0F, 0.0F);
		    black1.render(f5);
		    black2.render(f5);
		    
		    Random rnd = new Random();
		    int var;
		    
		    var = 1;
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape1.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape2.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape3.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape4.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape5.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape6.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape7.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape8.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape9.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape10.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape11.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape12.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape13.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape14.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape15.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape16.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape17.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape18.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape19.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape20.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape21.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape22.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape23.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape24.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 1;
		    Shape25.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape26.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 2;
		    Shape27.render(f5);
		    if(var == 0) {
		    	GlStateManager.color(0.7411764705882353F, 0.7647058823529412F, 0.7803921568627451F);
		    }else if(var == 1) {
		    	GlStateManager.color(0.5843137254901961F, 0.6470588235294118F, 0.6509803921568627F);					
		    }else if(var == 2) {
		    	GlStateManager.color(0.4980392156862745F, 0.5490196078431373F, 0.5529411764705882F);
		    }
		    var = 0;
		    Shape28.render(f5);
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
