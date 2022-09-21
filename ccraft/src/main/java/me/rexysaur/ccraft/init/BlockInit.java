package me.rexysaur.ccraft.init;

import java.util.ArrayList;
import java.util.List;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.objects.blocks.BlockBase;
import me.rexysaur.ccraft.objects.blocks.containers.generators.diamond_generator.DiamondGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator.GoldGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.refinery.Refinery;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.SilverChest;
import me.rexysaur.ccraft.objects.blocks.misc.RandomBlock;
import me.rexysaur.ccraft.objects.blocks.ore.UraniumOre;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block SILVER_BLOCK = new BlockBase("silver_block", Material.IRON, Main.CCRAFTBLOCKSTAB);
	public static final Block RANDOM_BLOCK = new RandomBlock("random_block", Material.ROCK);
	
	public static final Block SILVER_CHEST = new SilverChest("silver_chest", Material.WOOD);
	
	public static final Block GOLD_GENERATOR = new GoldGenerator("gold_generator", Material.ROCK, Reference.GUI_GOLD_GENERATOR);
	public static final Block DIAMOND_GENERATOR = new DiamondGenerator("diamond_generator", Material.ROCK, Reference.GUI_DIAMOND_GENERATOR);
	
	// Ores
	public static final Block URANIUM_ORE = new UraniumOre("uranium_ore", Material.ROCK);
	
	// Refinery
	public static final Block REFINERY = new Refinery("refinery", Material.IRON, Reference.GUI_REFINERY);
	
	public static final Block REFINED_GOLD_BLOCK = new BlockBase("refined_gold_block", Material.IRON, Main.CCRAFTBLOCKSTAB);
	public static final Block REFINED_DIAMOND_BLOCK = new BlockBase("refined_diamond_block", Material.IRON, Main.CCRAFTBLOCKSTAB);
}
