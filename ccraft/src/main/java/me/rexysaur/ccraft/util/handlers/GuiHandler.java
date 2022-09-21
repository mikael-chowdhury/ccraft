package me.rexysaur.ccraft.util.handlers;

import java.util.ArrayList;
import java.util.List;

import me.rexysaur.ccraft.gui.GuiObject;
import me.rexysaur.ccraft.objects.blocks.containers.CustomContainer;
import me.rexysaur.ccraft.objects.blocks.containers.generators.ContainerGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.GuiGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.GuiSilverChest;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.TileEntitySilverChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	public static List<GuiObject> GUIS = new ArrayList<GuiObject>();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_SILVER_CHEST) {
			return new CustomContainer(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		ContainerGenerator container = null;
		for (GuiObject gui : GUIS) {
			if(ID == gui.id) {
				container = new ContainerGenerator(player.inventory, (TileEntityGenerator)world.getTileEntity(new BlockPos(x, y, z)), player);
			}
		}
		
		return container;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_SILVER_CHEST) {
			return new GuiSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}

		GuiContainer container = null;
		
		for (GuiObject gui : GUIS) {
			if(ID == gui.id) {
				container = new GuiGenerator(player.inventory, (TileEntityGenerator)world.getTileEntity(new BlockPos(x, y, z)), player, gui.name);
			}
		}
		
		return container;
	}
	
	public static void registerGuis() {
		
	}
}
