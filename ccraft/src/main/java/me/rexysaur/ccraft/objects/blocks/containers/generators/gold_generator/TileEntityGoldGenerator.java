package me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator;

import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class TileEntityGoldGenerator extends TileEntityGenerator {
	public TileEntityGoldGenerator() {
		super("Gold Generator", "gold_generator", Items.GOLD_INGOT, Blocks.GOLD_ORE, 5000);
	}
}