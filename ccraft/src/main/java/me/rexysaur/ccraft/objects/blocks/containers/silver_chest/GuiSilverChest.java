package me.rexysaur.ccraft.objects.blocks.containers.silver_chest;

import me.rexysaur.ccraft.objects.blocks.containers.GuiCustomChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiSilverChest extends GuiCustomChest {
	public GuiSilverChest(InventoryPlayer playerInv, TileEntitySilverChest chestInv, EntityPlayer player) {
		super(playerInv, chestInv, player, "silver_chest");
	}
}