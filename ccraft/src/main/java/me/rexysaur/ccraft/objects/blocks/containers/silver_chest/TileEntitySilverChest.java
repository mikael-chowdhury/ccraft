package me.rexysaur.ccraft.objects.blocks.containers.silver_chest;

import me.rexysaur.ccraft.objects.blocks.containers.TileEntityCustomChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TileEntitySilverChest extends TileEntityCustomChest {
	public TileEntitySilverChest() {
		super();
		
		setCustomName("Silver Chest");
	}

	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":silver_chest";
	}
}
