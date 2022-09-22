package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import java.util.ArrayList;
import java.util.List;

import me.rexysaur.ccraft.gui.GuiObject;
import me.rexysaur.ccraft.objects.blocks.containers.CustomChest;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Refinery extends CustomChest {
	public static List<RecipeRefinery> RECIPES = new ArrayList<RecipeRefinery>();
	public static List<FuelRefinery> FUELS = new ArrayList<FuelRefinery>();
	
	public static PropertyBool RUNNING = PropertyBool.create("running");
	
	public Refinery(String name, Material materialIn, int gui_id) {
		super(name, materialIn, gui_id, TileEntityRefinery.class);
		setDefaultState(this.blockState.getBaseState().withProperty(RUNNING, false));
	}
	
	public static boolean hasItemGotRecipe(Item item) {
		boolean hasRecipe = false;
		
		for (RecipeRefinery recipe : RECIPES) {
			if(recipe.input == item) {
				hasRecipe = true;
				break;
			}
		}
		
		return hasRecipe;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return super.getDefaultState().withProperty(RUNNING, ((TileEntityRefinery)worldIn.getTileEntity(pos)).isRunning());
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState().withProperty(RUNNING, meta == 0 ? false : true);
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((boolean)state.getValue(RUNNING)) ? 1 : 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {RUNNING});
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(RUNNING, false);
	} 
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}
	
	public static RecipeRefinery getRecipeFromInput(Item item) {
		RecipeRefinery recipe = null;
		
		for(RecipeRefinery _recipe : RECIPES) {
			if(_recipe.input == item) {
				recipe = _recipe;
				break;
			}
		}
		
		return recipe;
	}
}
