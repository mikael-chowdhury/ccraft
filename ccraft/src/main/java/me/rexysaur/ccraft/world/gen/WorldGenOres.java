package me.rexysaur.ccraft.world.gen;

import java.util.Random;

import me.rexysaur.ccraft.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimension() == 0) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		generateOre(BlockInit.RANDOM_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 100, random.nextInt(6) + 5, 5);
		generateOre(BlockInit.RANDOM_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 15, random.nextInt(3) + 1, 1);
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int miny, int maxy, int size, int chances) {
		int deltaY = maxy-miny;
		
		for(int i = 0; i<chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), miny + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}
