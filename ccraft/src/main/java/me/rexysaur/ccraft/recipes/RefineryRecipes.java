package me.rexysaur.ccraft.recipes;

import me.rexysaur.ccraft.init.BlockInit;
import me.rexysaur.ccraft.objects.blocks.containers.refinery.RecipeRefinery;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class RefineryRecipes {
	public static void init() {
		new RecipeRefinery(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK), Item.getItemFromBlock(BlockInit.REFINED_DIAMOND_BLOCK));
	}
}
