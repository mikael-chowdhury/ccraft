package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.objects.items.ItemBase;

public class FuelRefinery extends ItemBase {
	public String name;
	public int duration_ticks;
	
	public FuelRefinery(String name, int duration_ticks) {
		super(name, Main.CCRAFTMATERIALSTAB);
		this.name = name;
		this.duration_ticks = duration_ticks;
		
		Refinery.FUELS.add(this);
	}
}
