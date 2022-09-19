package me.rexysaur.ccraft.objects.blocks.misc;

import java.util.List;
import java.util.Random;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.init.BlockInit;
import me.rexysaur.ccraft.init.ItemInit;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import scala.actors.threadpool.Arrays;


public class RandomBlock extends Block implements IHasModel {
	public RandomBlock(String name, Material material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CCRAFTBLOCKSTAB);
		
		setHardness(10.0f);
		setResistance(100.0f);
		setLightLevel(50.0f);
		setLightOpacity(14);
		setDefaultSlipperiness(0.0f);
		setHarvestLevel("axe", 3);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = new Random();
		ItemStack drop = new ItemStack(ItemInit.ITEMS.get(rand.nextInt(ItemInit.ITEMS.size())));
		ItemStack[] items = { drop };
		return (List<ItemStack>) Arrays.asList(items);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
