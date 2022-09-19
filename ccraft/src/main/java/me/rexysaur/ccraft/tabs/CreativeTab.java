package me.rexysaur.ccraft.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs
{;	
	public CreativeTab(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return null;
	}
}