package me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator;

import me.rexysaur.ccraft.objects.blocks.containers.generators.Generator;
import net.minecraft.block.material.Material;

public class GoldGenerator extends Generator {

	public GoldGenerator(String name, Material materialIn, int gui_id) {
		super(name, materialIn, TileEntityGoldGenerator.class, gui_id);
	}
}
