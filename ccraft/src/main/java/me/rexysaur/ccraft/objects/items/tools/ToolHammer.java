package me.rexysaur.ccraft.objects.items.tools;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ToolHammer extends ToolPickaxe {
	public ToolHammer(String name, ToolMaterial material) {
		super(name, material);

	}
	
	@Override
	public int getDamage(ItemStack stack) {
		return (int) Math.ceil(this.toolMaterial.getAttackDamage());
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		if(entityLiving.getEntityData().hasKey("isPlayer")) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			if(!player.isSneaking()) {
				
				RayTraceResult result = player.rayTrace(100D, 100);
				
				EnumFacing side = result.sideHit;
				
				BlockPos topleft;
				BlockPos middleleft;
				BlockPos bottomleft;
				BlockPos topmiddle;
				BlockPos bottommiddle;
				BlockPos topright;
				BlockPos middleright;
				BlockPos bottomright;

				if(side.getName() == "east" || side.getName() == "west") {
					topleft = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1);
					middleleft = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
					bottomleft = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1);
					
					topmiddle = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
					bottommiddle = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ());
					
					topright = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1);
					middleright = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
					bottomright = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1);
					
				} else if(side.getName() == "north" || side.getName() == "south") {
					topleft = new BlockPos(pos.getX()-1, pos.getY()+1, pos.getZ());
					middleleft = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
					bottomleft = new BlockPos(pos.getX()-1, pos.getY()-1, pos.getZ());
					
					topmiddle = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
					bottommiddle = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ());
					
					topright = new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ());
					middleright = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
					bottomright = new BlockPos(pos.getX()+1, pos.getY()-1, pos.getZ());
					
				} else {
					topleft = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1);
					middleleft = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
					bottomleft = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1);
					
					topmiddle = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
					bottommiddle = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
					
					topright = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1);
					middleright = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
					bottomright = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1);
				}

				BlockPos[] blockpositions = new BlockPos[] { topleft, middleleft, bottomleft, topmiddle, bottommiddle, topright, middleright, bottomright };
				
				for(BlockPos _pos : blockpositions) {
					IBlockState block = worldIn.getBlockState(_pos);

					if(player.inventory.getCurrentItem().canHarvestBlock(block)) {
						NonNullList<ItemStack> drops = NonNullList.create();
						
						block.getBlock().getDrops(drops, worldIn, pos, state, 1);
						
						for(ItemStack drop : drops) {
							worldIn.spawnEntity(new EntityItem(worldIn, _pos.getX(), _pos.getY(), _pos.getZ(), drop));
						}

						worldIn.setBlockToAir(_pos);
					}
				}
			}
		}
		
		
		return true;
	}
}
