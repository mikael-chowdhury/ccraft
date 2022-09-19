package me.rexysaur.ccraft.objects.blocks.containers.generators;

import me.rexysaur.ccraft.objects.blocks.containers.TileEntityCustomChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiGenerator extends GuiContainer {
	private final ResourceLocation GUI_CUSTOM_CHEST_TEXTURE;
	
	private final InventoryPlayer playerInv;
	private final TileEntityCustomChest te;
	
	private EntityPlayer player;

	public GuiGenerator(InventoryPlayer playerInv, TileEntityGenerator chestInv, EntityPlayer player, String texture_name) {
		super(new ContainerGenerator(playerInv, chestInv, player));
		
		
		this.xSize = 175;
		this.ySize = 221;
		
		this.playerInv = playerInv;
		this.te = chestInv;
		
		this.player = player;
		
		this.GUI_CUSTOM_CHEST_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/" + texture_name + ".png");
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
	}
	
	@Override
	protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type) {
		if(slotId == 0) {
			ItemStack stack = this.inventorySlots.inventorySlots.get(0).getStack();
			
			this.player.inventory.addItemStackToInventory(stack);
		}
		else super.handleMouseClick(slotIn, slotId, mouseButton, type);
	}
}
