package me.rexysaur.ccraft.objects.blocks.containers.silver_chest;

import me.rexysaur.ccraft.objects.blocks.containers.CustomChest;
import me.rexysaur.ccraft.util.Reference;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.block.material.Material;

public class SilverChest extends CustomChest implements IHasModel {
	public SilverChest(String name, Material material) {
		super(name, material, Reference.GUI_SILVER_CHEST, TileEntitySilverChest.class);
		
	}
}
