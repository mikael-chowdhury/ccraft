package me.rexysaur.ccraft.objects.blocks.containers.generators.diamond_generator;

import me.rexysaur.ccraft.gui.GuiObject;
import me.rexysaur.ccraft.objects.blocks.containers.generators.ContainerGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.Generator;
import net.minecraft.block.material.Material;

public class DiamondGenerator extends Generator {

	public DiamondGenerator(String name, Material materialIn, int gui_id) {
		super(name, materialIn, TileEntityDiamondGenerator.class, gui_id);
		
		new GuiObject(gui_id, "diamond_generator", ContainerGenerator.class, TileEntityDiamondGenerator.class, GuiDiamondGenerator.class);
	}
}
