package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRefineryOutput extends Slot {
	public SlotRefineryOutput(IInventory inventory) {
		super(inventory, 2, 102, 68);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
