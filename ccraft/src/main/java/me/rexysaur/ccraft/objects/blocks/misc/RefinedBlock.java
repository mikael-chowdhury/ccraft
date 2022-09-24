package me.rexysaur.ccraft.objects.blocks.misc;

import me.rexysaur.ccraft.objects.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RefinedBlock extends BlockBase {
	public RefinedBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, tab);
		
		setHarvestLevel("pickaxe", 2);
		setHardness(10.0f);
	}
}
