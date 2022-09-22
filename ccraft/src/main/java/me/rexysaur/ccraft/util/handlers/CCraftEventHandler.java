package me.rexysaur.ccraft.util.handlers;

import me.rexysaur.ccraft.entity.test.EntityTest;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import me.rexysaur.ccraft.util.interfaces.ITickable;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CCraftEventHandler {
	@SubscribeEvent
	public void playerLogin(PlayerLoggedInEvent event) {
		NBTTagCompound nbt = event.player.getEntityData();
		nbt.setBoolean("isPlayer", true);
		
		EntityPlayer p = event.player;
		
		EntityTest test = new EntityTest(event.player.getEntityWorld());
		p.getEntityWorld().spawnEntity(test);
	}
	
	@EventHandler
	public void spawnEntities(FMLLoadCompleteEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if(biome.getBiomeName() == "desert"){
				biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(EntityTest.class, 100, 2, 10));
			}
		}
	}
	
	@SubscribeEvent
	public void tick(PlayerTickEvent event) {
		for (TileEntityGenerator gen : TileEntityGenerator.GENERATORS) {
			gen.update();
		}
		
		for (ITickable tickable : TickHandler.TICKABLES) {
			tickable.tick();
		}
	}
}