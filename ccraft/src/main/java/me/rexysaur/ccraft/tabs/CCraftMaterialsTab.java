package me.rexysaur.ccraft.tabs;

import me.rexysaur.ccraft.init.ItemInit;
import net.minecraft.item.ItemStack;

public class CCraftMaterialsTab extends CreativeTab {

	public CCraftMaterialsTab() {
		super("ccraftmaterials");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.OBSIDIAN_INGOT);
	}
}
