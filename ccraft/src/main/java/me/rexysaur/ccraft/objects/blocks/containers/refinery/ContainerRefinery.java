package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.CustomContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerRefinery extends CustomContainer {
	public ContainerRefinery(InventoryPlayer playerInv, TileEntityRefinery chestInventory, EntityPlayer player) {
		super(playerInv, chestInventory, player);
		
		this.addSlotToContainer(new SlotRefineryInput(chestInventory));
		this.addSlotToContainer(new SlotRefineryFuel(chestInventory));
		this.addSlotToContainer(new SlotRefineryOutput(chestInventory));
	}
}
