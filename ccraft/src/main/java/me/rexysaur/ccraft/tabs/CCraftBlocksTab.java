package me.rexysaur.ccraft.tabs;

import me.rexysaur.ccraft.init.BlockInit;
import net.minecraft.item.ItemStack;

public class CCraftBlocksTab extends CreativeTab {

	public CCraftBlocksTab() {
		super("ccraftblocks");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockInit.SILVER_BLOCK);
	}
}
