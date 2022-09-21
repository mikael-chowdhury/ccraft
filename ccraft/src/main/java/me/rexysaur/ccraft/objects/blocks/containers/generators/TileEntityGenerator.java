package me.rexysaur.ccraft.objects.blocks.containers.generators;

import java.util.ArrayList;
import java.util.List;

import me.rexysaur.ccraft.objects.blocks.containers.TileEntityCustomChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityGenerator extends TileEntityCustomChest {
	public static List<TileEntityGenerator> GENERATORS = new ArrayList<TileEntityGenerator>();
	
	public ItemStackHandler outputSlot;
	
	public Item item;
	public Block block;
	
	public String id;
	
	public int ticknum = 0;
	public int tickrate;
	
	public TileEntityGenerator(String name, String id, Item item, Block block, int tickrate) {
		super(1);
		
		this.item = item;
		this.block = block;
		
		this.tickrate = tickrate;
		
		this.id = id;
		
		this.setCustomName(name);
		
		this.outputSlot = new ItemStackHandler();
		
		GENERATORS.add(this);
	}
	
	public World getWorld() {
		return world;
	}
	
	@Override
	public int getSizeInventory() {
		return 1;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
			return stack.getItem().getRegistryName() == item.getRegistryName();
	}
	
	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":gold_generator";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) outputSlot;
		}
		
		return super.getCapability(capability, facing);
	}
	
	public void update() {
		super.tick();
		
		BlockPos posbelow = new BlockPos(getPos().getX(), getPos().getY() - 1, getPos().getZ());
		Block blockbelow = world.getBlockState(posbelow).getBlock();
		boolean mining = blockbelow.getRegistryName() == block.getRegistryName();
		
		ItemStack output = this.getStackInSlot(0);
		
		if(mining) {
			if(output.getCount() < 64) {
				ticknum++;
				
				if(ticknum >= tickrate) {
					this.setInventorySlotContents(0, new ItemStack(item, (output != null ? output.getCount() : 0) + 1));
					
					ticknum = 0;
				}
				
			} else {
				ticknum = 0;
			}
		}
	}
}