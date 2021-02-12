package net.pingmod.cosmetics;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class WitchHat implements LayerRenderer {

	private final WitchHatHatrenderer witchHatRenderer;

	public WitchHat() {
		this.witchHatRenderer = new WitchHatHatrenderer();
	}

	@Override
	public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_,
			float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if(Controller.witchHat) {
			GL11.glPushMatrix();
			if (p_177141_1_.isSneaking()) {
				GlStateManager.translate(0, 0.255, 0);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/witch.png"));
			GlStateManager.color(1F, 1, 1F);
			this.witchHatRenderer.render(p_177141_1_, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_,
					p_177141_8_);
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	public class WitchHatHatrenderer extends ModelBase {
		private ModelRenderer witchHat;

		public WitchHatHatrenderer() {
			this.witchHat = (new ModelRenderer(this)).setTextureSize(64, 128);
			this.witchHat.setRotationPoint(-5.0F, -10.03125F, -5.0F);
			this.witchHat.setTextureOffset(0, 64).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
			ModelRenderer modelrenderer = (new ModelRenderer(this)).setTextureSize(64, 128);
			modelrenderer.setRotationPoint(1.75F, -4.0F, 2.0F);
			modelrenderer.setTextureOffset(0, 76).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
			modelrenderer.rotateAngleX = -0.05235988F;
			modelrenderer.rotateAngleZ = 0.02617994F;
			this.witchHat.addChild(modelrenderer);
			ModelRenderer modelrenderer1 = (new ModelRenderer(this)).setTextureSize(64, 128);
			modelrenderer1.setRotationPoint(1.75F, -4.0F, 2.0F);
			modelrenderer1.setTextureOffset(0, 87).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
			modelrenderer1.rotateAngleX = -0.10471976F;
			modelrenderer1.rotateAngleZ = 0.05235988F;
			modelrenderer.addChild(modelrenderer1);
			ModelRenderer modelrenderer2 = (new ModelRenderer(this)).setTextureSize(64, 128);
			modelrenderer2.setRotationPoint(1.75F, -2.0F, 2.0F);
			modelrenderer2.setTextureOffset(0, 95).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
			modelrenderer2.rotateAngleX = -0.20943952F;
			modelrenderer2.rotateAngleZ = 0.10471976F;
			modelrenderer1.addChild(modelrenderer2);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			GlStateManager.rotate(f3, 0, 1, 0);
			GlStateManager.rotate(f4, 1, 0, 0);
			this.witchHat.render(f5);

		}
	}

}
