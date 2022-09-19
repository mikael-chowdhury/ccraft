package me.rexysaur.ccraft.init;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.entity.test.EntityTest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	public static void registerEntities() {
		registerEntity("test", EntityTest.class, Reference.ENTITY_TEST, 50, 13310623, 65354);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	@SuppressWarnings("unused")
	private static void registerNonMobEntity() {
		
	}
}
