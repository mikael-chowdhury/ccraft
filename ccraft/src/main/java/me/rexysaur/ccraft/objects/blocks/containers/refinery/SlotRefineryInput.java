package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRefineryInput extends Slot {
	public SlotRefineryInput(IInventory inventory) {
		super(inventory, 0, 65, 54);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return Refinery.hasItemGotRecipe(stack.getItem());
	}
}