package me.rexysaur.ccraft.objects.items.items;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.objects.items.ItemBase;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.item.ItemStack;

public class RadioactiveCoal extends ItemBase implements IHasModel {

	public RadioactiveCoal(String name) {
		super(name, Main.CCRAFTMATERIALSTAB);
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return 12000;
	}
}
