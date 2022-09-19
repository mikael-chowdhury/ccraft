package me.rexysaur.ccraft.util.handlers;

import me.rexysaur.ccraft.objects.blocks.containers.ContainerCustomChest;
import me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator.GuiGoldGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator.TileEntityGoldGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.GuiSilverChest;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.TileEntitySilverChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_SILVER_CHEST) {
			return new ContainerCustomChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_GOLD_GENERATOR) {
			return new ContainerCustomChest(player.inventory, (TileEntityGoldGenerator)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_SILVER_CHEST) {
			return new GuiSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_GOLD_GENERATOR) {
			return new GuiGoldGenerator(player.inventory, (TileEntityGoldGenerator)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		return null;
	}
	
	public static void registerGuis() {
		
	}
}
