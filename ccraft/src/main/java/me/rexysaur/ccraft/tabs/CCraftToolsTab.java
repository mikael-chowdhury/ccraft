package me.rexysaur.ccraft.tabs;

import me.rexysaur.ccraft.init.ItemInit;
import net.minecraft.item.ItemStack;

public class CCraftToolsTab extends CreativeTab {
	public CCraftToolsTab() {
		super("ccrafttools");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.OBSIDIAN_CHESTPLATE);
	}
}
