package me.rexysaur.ccraft.objects.blocks.containers.generators.diamond_generator;

import me.rexysaur.ccraft.objects.blocks.containers.generators.GuiGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiDiamondGenerator extends GuiGenerator {

	public GuiDiamondGenerator(InventoryPlayer playerInv, TileEntityGenerator chestInv, EntityPlayer player) {
		super(playerInv, chestInv, player, "diamond_generator");
	}

}
