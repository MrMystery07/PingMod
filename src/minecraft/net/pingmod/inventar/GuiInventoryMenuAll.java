package net.pingmod.inventar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Container;
import net.pingmod.addons.GuiAddonList;
import net.pingmod.utils.ColorUtils;
import net.pingmod.utils.UIButton;
import net.pingmod.utils.UITrueFalseButton;

public class GuiInventoryMenuAll extends GuiScreen{

	public static int slotX;
	public static int slotY;
	
    protected int xSize = 176;

    /** The Y size of the inventory window in pixels. */
    protected int ySize = 166;

    /** A list of the players inventory slots */
    /**
     * Starting X position for the Gui. Inconsistent use for Gui backgrounds.
     */
    protected int guiLeft;

    /**
     * Starting Y position for the Gui. Inconsistent use for Gui backgrounds.
     */
    protected int guiTop;
	
	public static GuiInventoryList listGui;
	private int selected = -1;
	public static List<String> addonList = new ArrayList<String>();
	
	public GuiInventoryMenuAll() {
		addonList.add("Flügel");
		addonList.add("Durchsichtige Flügel");
		addonList.add("Hexenhut");
		addonList.add("Classichat");
		addonList.add("Zylinder");
		addonList.add("Cloaks");
		addonList.add("Partikel");
	}
	
	@Override
	public void onGuiClosed() {
		addonList.clear();
		super.onGuiClosed();
	}
	
	@Override
	public void initGui() {
		this.listGui = new GuiInventoryList(mc, addonList);
		this.listGui.setDimensions(this.width, this.height, 38, this.height - 64);
		
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        String text = "";
        
        if(Minecraft.getMinecraft().theWorld == null) {
        	text = "Zurück zum Hauptmenü";
        }else {
        	text = "Zurück zum Spiel";
        }
        
        this.buttonList.add(new UIButton(0, this.width/2 - 100, this.height - 28, text));
        
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) {
			if(Minecraft.getMinecraft().theWorld == null) {
				this.mc.displayGuiScreen(new GuiMainMenu());
			}else {
				this.mc.displayGuiScreen(new GuiIngameMenu());
			}
		}
		super.actionPerformed(button);
	}
	
	  protected void mouseClicked(int par1, int par2, int par3) throws IOException {
		    if (par2 >= 36 && par2 <= this.height - 57 && (
		      par1 >= this.width / 2 + 140 || par1 <= this.width / 2 - 126))
		      this.listGui.elementClicked(-1, false, 0, 0); 
		    super.mouseClicked(par1, par2, par3);
		  }
		  
		  public void handleMouseInput() throws IOException {
		    super.handleMouseInput();
		    this.listGui.handleMouseInput();
		  }
	
		    public static void drawEntityOnScreen(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_)
		    {
		        GlStateManager.enableColorMaterial();
		        GlStateManager.pushMatrix();
		        GlStateManager.translate((float)p_147046_0_, (float)p_147046_1_, 50.0F);
		        GlStateManager.scale((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
		        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		        float var6 = p_147046_5_.renderYawOffset;
		        float var7 = p_147046_5_.rotationYaw;
		        float var8 = p_147046_5_.rotationPitch;
		        float var9 = p_147046_5_.prevRotationYawHead;
		        float var10 = p_147046_5_.rotationYawHead;
		        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		        RenderHelper.enableStandardItemLighting();
		        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		        GlStateManager.rotate(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		        p_147046_5_.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
		        p_147046_5_.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
		        p_147046_5_.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
		        p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
		        p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
		        GlStateManager.translate(0.0F, 0.0F, 0.0F);
		        RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
		        var11.func_178631_a(180.0F);
		        var11.func_178633_a(false);
		        var11.renderEntityWithPosYaw(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		        var11.func_178633_a(true);
		        p_147046_5_.renderYawOffset = var6;
		        p_147046_5_.rotationYaw = var7;
		        p_147046_5_.rotationPitch = var8;
		        p_147046_5_.prevRotationYawHead = var9;
		        p_147046_5_.rotationYawHead = var10;
		        GlStateManager.popMatrix();
		        RenderHelper.disableStandardItemLighting();
		        GlStateManager.disableRescaleNormal();
		        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		        GlStateManager.func_179090_x();
		        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
		    }
		  
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ColorUtils.background();
		
		this.listGui.drawScreen(mouseX, mouseY, partialTicks);
		
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        int var4 = this.guiLeft;
        int var5 = this.guiTop;
        
        drawCenteredString(fontRendererObj, "§eUm Cosmetics zu de/aktivieren, den Befehl /cosmetic eingeben", width/2, height - 42, 0xffffff);
        
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}
