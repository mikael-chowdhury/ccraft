package me.rexysaur.ccraft.objects.blocks.containers.generators;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotGeneratorOutput extends Slot {
	public SlotGeneratorOutput(IInventory inventory) {
		super(inventory, 0, 80, 66);
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer playerIn) {
		return true;
	}
}
