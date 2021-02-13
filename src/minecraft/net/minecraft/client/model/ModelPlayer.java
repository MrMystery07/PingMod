package net.minecraft.client.model;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.pingmod.cosmetics.Controller;
import net.pingmod.utils.ColorUtils;

public class ModelPlayer extends ModelBiped {
	public ModelRenderer field_178734_a;
	public ModelRenderer field_178732_b;
	public ModelRenderer field_178733_c;
	public ModelRenderer field_178731_d;
	public ModelRenderer field_178730_v;
	private ModelRenderer field_178729_w;
	private ModelRenderer field_178736_x;
	private ModelRenderer animatedCape;
	private boolean field_178735_y;
	private static final String __OBFID = "CL_00002626";

	private ModelRenderer wing;
	private ModelRenderer wingTip;
	boolean flying = false;

	public ModelPlayer(float p_i46304_1_, boolean p_i46304_2_) {
		super(p_i46304_1_, 0.0F, 64, 64);
		this.field_178735_y = p_i46304_2_;
		this.field_178736_x = new ModelRenderer(this, 24, 0);
		this.field_178736_x.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, p_i46304_1_);
		this.field_178729_w = new ModelRenderer(this, 0, 0);
		this.field_178729_w.setTextureSize(64, 32);
		this.field_178729_w.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i46304_1_);
		this.animatedCape = new ModelRenderer(this, 0, 0);
		this.animatedCape.setTextureSize(21, 17);
		this.animatedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i46304_1_);
        byte var1 = -16;

		if (p_i46304_2_) {
			this.bipedLeftArm = new ModelRenderer(this, 32, 48);
			this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, p_i46304_1_);
			this.bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
			this.bipedRightArm = new ModelRenderer(this, 40, 16);
			this.bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, p_i46304_1_);
			this.bipedRightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
			this.field_178734_a = new ModelRenderer(this, 48, 48);
			this.field_178734_a.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, p_i46304_1_ + 0.25F);
			this.field_178734_a.setRotationPoint(5.0F, 2.5F, 0.0F);
			this.field_178732_b = new ModelRenderer(this, 40, 32);
			this.field_178732_b.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, p_i46304_1_ + 0.25F);
			this.field_178732_b.setRotationPoint(-5.0F, 2.5F, 10.0F);
//			if (Controller.wings || Controller.ghostWings) {
			this.setTextureOffset("wingtip.bone", 112, 136);
			this.setTextureOffset("wing.skin", -56, 88);
			this.setTextureOffset("wing.bone", 112, 88);
			this.setTextureOffset("wingtip.skin", -56, 144);

			int bw = this.textureWidth;
			int bh = this.textureHeight;

			this.textureWidth = 256;
			this.textureHeight = 256;

			this.wing = new ModelRenderer(this, "wing");
			this.wing.setTextureSize(256, 256);
			this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
			this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
			this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
			this.wing.isHidden = true;
			this.wingTip = new ModelRenderer(this, "wingtip");
			this.wingTip.setTextureSize(256, 256);
			this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
			this.wingTip.isHidden = true;
			this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
			this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
			this.wing.addChild(this.wingTip);
			this.textureWidth = bw;
			this.textureHeight = bh;
//			}
		} else {
			this.bipedLeftArm = new ModelRenderer(this, 32, 48);
			this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i46304_1_);
			this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			this.field_178734_a = new ModelRenderer(this, 48, 48);
			this.field_178734_a.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i46304_1_ + 0.25F);
			this.field_178734_a.setRotationPoint(5.0F, 2.0F, 0.0F);
			this.field_178732_b = new ModelRenderer(this, 40, 32);
			this.field_178732_b.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, p_i46304_1_ + 0.25F);
			this.field_178732_b.setRotationPoint(-5.0F, 2.0F, 10.0F);
//			if (Controller.wings || Controller.ghostWings) {
			this.setTextureOffset("wingtip.bone", 112, 136);
			this.setTextureOffset("wing.skin", -56, 88);
			this.setTextureOffset("wing.bone", 112, 88);
			this.setTextureOffset("wingtip.skin", -56, 144);

			int bw = this.textureWidth;
			int bh = this.textureHeight;

			this.textureWidth = 256;
			this.textureHeight = 256;

			this.wing = new ModelRenderer(this, "wing");
			this.wing.setTextureSize(256, 256);
			this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
			this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
			this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
			this.wing.isHidden = true;
			this.wingTip = new ModelRenderer(this, "wingtip");
			this.wingTip.setTextureSize(256, 256);
			this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
			this.wingTip.isHidden = true;
			this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
			this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
			this.wing.addChild(this.wingTip);
			this.textureWidth = bw;
			this.textureHeight = bh;
//			}
		}

		this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i46304_1_);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		this.field_178733_c = new ModelRenderer(this, 0, 48);
		this.field_178733_c.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i46304_1_ + 0.25F);
		this.field_178733_c.setRotationPoint(1.9F, 12.0F, 0.0F);
		this.field_178731_d = new ModelRenderer(this, 0, 32);
		this.field_178731_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i46304_1_ + 0.25F);
		this.field_178731_d.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.field_178730_v = new ModelRenderer(this, 16, 32);
		this.field_178730_v.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i46304_1_ + 0.25F);
		this.field_178730_v.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_,
			float p_78088_6_, float p_78088_7_) {
		super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
		GlStateManager.pushMatrix();

		if (this.isChild) {
			float var8 = 2.0F;
			GlStateManager.scale(1.0F / var8, 1.0F / var8, 1.0F / var8);
			GlStateManager.translate(0.0F, 24.0F * p_78088_7_, 0.0F);
			this.field_178733_c.render(p_78088_7_);
			this.field_178731_d.render(p_78088_7_);
			this.field_178734_a.render(p_78088_7_);
			this.field_178732_b.render(p_78088_7_);
			this.field_178730_v.render(p_78088_7_);
		} else {
			if (p_78088_1_.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}

			this.field_178733_c.render(p_78088_7_);
			this.field_178731_d.render(p_78088_7_);
			this.field_178734_a.render(p_78088_7_);
			this.field_178732_b.render(p_78088_7_);
			this.field_178730_v.render(p_78088_7_);
			if (Controller.wings) {
//            GlStateManager.enableLighting();
				Minecraft.getMinecraft().getTextureManager()
						.bindTexture(new ResourceLocation("textures/entity/enderdragon/dragon.png"));
				float anSpeed = 100.0F;
				if (!p_78088_1_.onGround || this.flying) {
					anSpeed = 10.0F;
					this.flying = true;
				}
				float f1 = p_78088_3_ + p_78088_4_ / anSpeed;
				float f2 = p_78088_3_ + p_78088_4_ / 100.0F;
				float f3 = f1 * 3.1415027F * 2.0F;
				float f4 = (float) (0.125F - Math.cos(f3) * 0.2F);
				float fs5 = f2 * 3.1415027F * 2.0F;
				float f7 = (float) (0.125F - Math.cos(fs5) * 0.2F);
				if ((this.flying) && ((int) (f4 * 100.0F) == (int) (f7 * 100.0F))) {
					this.flying = false;
					anSpeed = 100.0F;
				}
				GlStateManager.scale(0.13D, 0.13D, 0.13D);
				GlStateManager.translate(0.0D, -0.3D, 1.1D);
				GlStateManager.rotate(25.0F, -50.0F, 0.0F, 0.0F);
				Minecraft.getMinecraft().fontRendererObj.drawString("", 0, 0, ColorUtils.rainbowEffect(1000000, 1.0F).getRGB());
//            GlStateManager.blendFunc(1, 1);
//            GlStateManager.enableBlend();
				for (int i = 0; i < 2; i++) {
					float f6 = f1 * 3.1415027F * 2.0F;
					this.wing.rotateAngleX = (0.125F - (float) Math.cos(f6) * 0.2F);
					this.wing.rotateAngleY = 0.25F;
					this.wing.rotateAngleZ = (-(float) (Math.sin(f6) + 1.225D) * 0.3F);
					this.wingTip.rotateAngleZ = (-(float) (Math.sin(f6 + 2.0F) + 0.5D) * 0.75F);
					this.wing.isHidden = false;
					this.wingTip.isHidden = false;
					GlStateManager.disableLighting();
					this.wing.render(p_78088_7_);
					this.wing.isHidden = true;
					this.wingTip.isHidden = true;

					if (i == 0) {
						GlStateManager.scale(-1.0F, 1.0F, 1.0F);
					}
				}
//            GlStateManager.disableBlend();
			}else if (Controller.ghostWings) {
	            GlStateManager.enableLighting();
					Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation("textures/entity/enderdragon/dragon.png"));
					float anSpeed = 100.0F;
					if (!p_78088_1_.onGround || this.flying) {
						anSpeed = 10.0F;
						this.flying = true;
					}
					float f1 = p_78088_3_ + p_78088_4_ / anSpeed;
					float f2 = p_78088_3_ + p_78088_4_ / 100.0F;
					float f3 = f1 * 3.1415027F * 2.0F;
					float f4 = (float) (0.125F - Math.cos(f3) * 0.2F);
					float fs5 = f2 * 3.1415027F * 2.0F;
					float f7 = (float) (0.125F - Math.cos(fs5) * 0.2F);
					if ((this.flying) && ((int) (f4 * 100.0F) == (int) (f7 * 100.0F))) {
						this.flying = false;
						anSpeed = 100.0F;
					}
					GlStateManager.scale(0.13D, 0.13D, 0.13D);
					GlStateManager.translate(0.0D, -0.3D, 1.1D);
					GlStateManager.rotate(25.0F, -50.0F, 0.0F, 0.0F);
					Minecraft.getMinecraft().fontRendererObj.drawString("", 0, 0, ColorUtils.rainbowEffect(1000000, 1.0F).getRGB());
	            GlStateManager.blendFunc(1, 1);
	            GlStateManager.enableBlend();
					for (int i = 0; i < 2; i++) {
						float f6 = f1 * 3.1415027F * 2.0F;
						this.wing.rotateAngleX = (0.125F - (float) Math.cos(f6) * 0.2F);
						this.wing.rotateAngleY = 0.25F;
						this.wing.rotateAngleZ = (-(float) (Math.sin(f6) + 1.225D) * 0.3F);
						this.wingTip.rotateAngleZ = (-(float) (Math.sin(f6 + 2.0F) + 0.5D) * 0.75F);
						this.wing.isHidden = false;
						this.wingTip.isHidden = false;
						this.wing.render(p_78088_7_);
						this.wing.isHidden = true;
						this.wingTip.isHidden = true;

						if (i == 0) {
							GlStateManager.scale(-1.0F, 1.0F, 1.0F);
						}
					}
	            GlStateManager.disableBlend();
				}else {

				}
		}

		GlStateManager.popMatrix();
	}

	public void func_178727_b(float p_178727_1_) {
		func_178685_a(this.bipedHead, this.field_178736_x);
		this.field_178736_x.rotationPointX = 0.0F;
		this.field_178736_x.rotationPointY = 0.0F;
		this.field_178736_x.render(p_178727_1_);
	}

	public void func_178728_c(float p_178728_1_) {
		this.field_178729_w.render(p_178728_1_);
	}
	
	public void renderAnimatedCape(float p_178728_1_) {
		this.animatedCape.render(p_178728_1_);
	}


	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used
	 * for animating the movement of arms and legs, where par1 represents the
	 * time(so that arms and legs swing back and forth) and par2 represents how
	 * "far" arms and legs can swing at most.
	 */
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
			float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
		func_178685_a(this.bipedLeftLeg, this.field_178733_c);
		func_178685_a(this.bipedRightLeg, this.field_178731_d);
		func_178685_a(this.bipedLeftArm, this.field_178734_a);
		func_178685_a(this.bipedRightArm, this.field_178732_b);
		func_178685_a(this.bipedBody, this.field_178730_v);

		if (p_78087_7_.isSneaking()) {
			this.field_178729_w.rotationPointY = 2.0F;
		} else {
			this.field_178729_w.rotationPointY = 0.0F;
		}
	
	}

	public void func_178725_a() {
		this.bipedRightArm.render(0.0625F);
		this.field_178732_b.render(0.0625F);
	}

	public void func_178726_b() {
		this.bipedLeftArm.render(0.0625F);
		this.field_178734_a.render(0.0625F);
	}

	public void func_178719_a(boolean p_178719_1_) {
		super.func_178719_a(p_178719_1_);
		this.field_178734_a.showModel = p_178719_1_;
		this.field_178732_b.showModel = p_178719_1_;
		this.field_178733_c.showModel = p_178719_1_;
		this.field_178731_d.showModel = p_178719_1_;
		this.field_178730_v.showModel = p_178719_1_;
		this.field_178729_w.showModel = p_178719_1_;
		this.field_178736_x.showModel = p_178719_1_;
	}

	public void postRenderHiddenArm(float p_178718_1_) {
		if (this.field_178735_y) {
			++this.bipedRightArm.rotationPointX;
			this.bipedRightArm.postRender(p_178718_1_);
			--this.bipedRightArm.rotationPointX;
		} else {
			this.bipedRightArm.postRender(p_178718_1_);
		}
	}
}
