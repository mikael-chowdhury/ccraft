package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import net.minecraft.item.Item;

public class RecipeRefinery {
	public Item input, output;
	
	public RecipeRefinery(Item input, Item output) {
		this.input = input;
		this.output = output;
		
		Refinery.RECIPES.add(this);
	}
}