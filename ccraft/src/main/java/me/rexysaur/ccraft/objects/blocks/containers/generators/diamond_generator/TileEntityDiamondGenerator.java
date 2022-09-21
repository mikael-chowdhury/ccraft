package me.rexysaur.ccraft.objects.blocks.containers.generators.diamond_generator;

import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class TileEntityDiamondGenerator extends TileEntityGenerator {
	public TileEntityDiamondGenerator() {
		super("Diamond Generator", "diamond_generator", Items.DIAMOND, Blocks.DIAMOND_ORE, 10000);
	}
}