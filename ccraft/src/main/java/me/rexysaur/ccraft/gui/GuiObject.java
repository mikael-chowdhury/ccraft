package me.rexysaur.ccraft.gui;

import me.rexysaur.ccraft.objects.blocks.containers.CustomContainer;
import me.rexysaur.ccraft.util.handlers.GuiHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiObject {
	public int id;
	public String name;
	
	public Class<? extends CustomContainer> container;
	public Class<? extends TileEntity> tileentity;
	public Class<? extends GuiContainer> guicontainer;
	
	public GuiObject(int id, String name, Class<? extends CustomContainer> container, Class<? extends TileEntity> tileentity, Class<? extends GuiContainer> guicontainer) {
		this.id = id;
		this.name = name;
		
		this.container = container;
		this.tileentity = tileentity;
		this.guicontainer = guicontainer;
		
		GuiHandler.GUIS.add(this);
	}
}
