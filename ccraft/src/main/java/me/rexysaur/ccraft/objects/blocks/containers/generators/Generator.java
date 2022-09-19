package me.rexysaur.ccraft.objects.blocks.containers.generators;

import me.rexysaur.ccraft.objects.blocks.containers.CustomChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Generator extends CustomChest {
	public static PropertyBool RUNNING = PropertyBool.create("running");
	
	protected Generator(String name, Material materialIn, Class<? extends TileEntityGenerator> generatorClass, int gui_id) {
		super(name, materialIn, gui_id, generatorClass);
		setDefaultState(this.blockState.getBaseState().withProperty(RUNNING, false));
	}
	
	public boolean isRunning(World worldIn, BlockPos pos) {
		BlockPos posbelow = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
		Block blockbelow = worldIn.getBlockState(posbelow).getBlock();
		boolean mining = blockbelow.getRegistryName() == ((TileEntityGenerator)worldIn.getTileEntity(pos)).block.getRegistryName();
		
		return mining;
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
		return this.getDefaultState().withProperty(RUNNING, isRunning(worldIn, pos));
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
}