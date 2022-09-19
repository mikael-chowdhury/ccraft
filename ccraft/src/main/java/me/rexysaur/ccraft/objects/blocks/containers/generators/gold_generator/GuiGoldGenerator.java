package me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator;

import me.rexysaur.ccraft.objects.blocks.containers.generators.GuiGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiGoldGenerator extends GuiGenerator {

	public GuiGoldGenerator(InventoryPlayer playerInv, TileEntityGenerator chestInv, EntityPlayer player) {
		super(playerInv, chestInv, player, "gold_generator");
	}

}
