package me.rexysaur.ccraft.objects.items.items;

import me.rexysaur.ccraft.objects.blocks.containers.refinery.FuelRefinery;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.item.ItemStack;

public class RadioactiveCoal extends FuelRefinery implements IHasModel {

	public RadioactiveCoal(String name) {
		super(name, 12000);
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return 12000;
	}
}
