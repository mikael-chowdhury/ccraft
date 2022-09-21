package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiRefinery extends GuiContainer {
	private final ResourceLocation GUI_CUSTOM_CHEST_TEXTURE;
	
	private final InventoryPlayer playerInv;
	private final TileEntityRefinery te;
	
	@SuppressWarnings("unused")
	private EntityPlayer player;

	public GuiRefinery(InventoryPlayer playerInv, TileEntityRefinery chestInv, EntityPlayer player) {
		super(new ContainerRefinery(playerInv, chestInv, player));
		
		this.xSize = 175;
		this.ySize = 221;
		
		this.playerInv = playerInv;
		this.te = chestInv;
		
		this.player = player;
		
		this.GUI_CUSTOM_CHEST_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/refinery.png");
	}
	
	public boolean isRunning() {
		return te.isRunning();
	}

	public TileEntityRefinery getTileEntity() {
		return (TileEntityRefinery) this.te.getWorld().getTileEntity(this.te.getPos());
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CUSTOM_CHEST_TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize-92, 000000);
		
		TileEntityRefinery tileentity = getTileEntity();

		if(isRunning()) {
			this.fontRenderer.drawString("Refining... " + ((int)Math.floor(100.0 * tileentity.refiningticks / tileentity.getItemRefineTime())) + "%", 50, 20, 4210752);
		}
	}
}
