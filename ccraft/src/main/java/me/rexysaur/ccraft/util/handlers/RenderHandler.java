package me.rexysaur.ccraft.util.handlers;

import me.rexysaur.ccraft.entity.test.EntityTest;
import me.rexysaur.ccraft.entity.test.RenderTest;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new IRenderFactory<EntityTest>() {
			@Override
			public Render<? super EntityTest> createRenderFor(RenderManager manager) {
				return new RenderTest(manager);
			}
		});
	}
}
