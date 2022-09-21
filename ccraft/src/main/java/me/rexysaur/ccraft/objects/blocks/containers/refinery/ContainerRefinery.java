package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.CustomContainer;
import me.rexysaur.ccraft.objects.blocks.containers.generators.SlotGeneratorOutput;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;

public class ContainerRefinery extends CustomContainer {
	public ContainerRefinery(InventoryPlayer playerInv, TileEntityRefinery chestInventory, EntityPlayer player) {
		super(playerInv, chestInventory, player);
		
		this.addSlotToContainer(new SlotRefineryInput(chestInventory));
		this.addSlotToContainer(new SlotRefineryFuel(chestInventory));
		this.addSlotToContainer(new SlotGeneratorOutput(chestInventory));
	}
}
