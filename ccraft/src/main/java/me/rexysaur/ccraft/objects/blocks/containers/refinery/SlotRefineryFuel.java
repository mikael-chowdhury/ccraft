package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRefineryFuel extends Slot {
	public SlotRefineryFuel(IInventory inventory) {
		super(inventory, 1, 63, 80);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return Refinery.FUELS.contains(stack.getItem());
	}
}