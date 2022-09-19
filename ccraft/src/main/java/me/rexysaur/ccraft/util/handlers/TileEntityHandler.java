package me.rexysaur.ccraft.util.handlers;

import me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator.TileEntityGoldGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.TileEntitySilverChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySilverChest.class, new ResourceLocation(Reference.MOD_ID + ":silver_chest"));
		GameRegistry.registerTileEntity(TileEntityGoldGenerator.class, new ResourceLocation(Reference.MOD_ID + ":gold_generator"));
	}
}