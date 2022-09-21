package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.TileEntityCustomChest;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TileEntityRefinery extends TileEntityCustomChest {
	public static final int REFINE_TIME = 1000;
	
	public int fuelticks = 0;
	public int refiningticks = 0;
	
	public TileEntityRefinery() {
		super(2);
	}
	
	public World getWorld() {
		return world;
	}
	
	@Override
	public int getSizeInventory() {
		return 3;
	}
	
	public int getItemRefineTime() {
		return REFINE_TIME;
	}
	
	@Override
	public void tick() {
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getCount() > 0 &&  (this.getStackInSlot(2) == null || this.getStackInSlot(2).getItem() == getStackInSlot(0).getItem())) {
			if(this.fuelticks > 0) {
					this.refiningticks += 1;
					
					if(this.refiningticks >= getItemRefineTime()) {
						this.refiningticks = 0;
						RecipeRefinery recipe = Refinery.getRecipeFromInput(getStackInSlot(0).getItem());
						this.setInventorySlotContents(2, new ItemStack(recipe.output, (getStackInSlot(2) != null ? getStackInSlot(2).getCount() : 0)+1));
					}
			} else {
				ItemStack fuelstack = this.getStackInSlot(1);
				
				if(fuelstack != null && fuelstack.getCount() > 0) {
					FuelRefinery fuelitem = (FuelRefinery) fuelstack.getItem();
					this.fuelticks += fuelitem.duration_ticks;
					this.decrStackSize(1, 1);
				} else {
					this.refiningticks = 0;
				}
			}
		}
	}
	
	public boolean isRunning() {
		return this.fuelticks > 0 && this.refiningticks > 0;
	}
}
