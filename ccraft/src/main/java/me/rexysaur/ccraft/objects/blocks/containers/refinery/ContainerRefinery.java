package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.CustomContainer;
import me.rexysaur.ccraft.objects.blocks.containers.generators.SlotGeneratorOutput;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;

public class ContainerRefinery extends CustomContainer {
	public ContainerRefinery(InventoryPlayer playerInv, TileEntityGenerator chestInventory, EntityPlayer player) {
		super(playerInv, chestInventory, player);
		
		this.addSlotToContainer(new SlotRefineryInput(chestInventory));
		this.addSlotToContainer(new SlotGeneratorOutput(chestInventory));
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		System.err.println(slotId);
		
		if(clickTypeIn== ClickType.PICKUP) {
			if(slotId == 0) {
				ItemStack stack = this.inventorySlots.get(0).getStack();
				player.inventory.setPickedItemStack(stack);
				this.inventorySlots.get(0).decrStackSize(stack.getCount());
				return stack;
			} else return super.slotClick(slotId, dragType, clickTypeIn, player);
		} else return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
}
