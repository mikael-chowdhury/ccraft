package me.rexysaur.ccraft.objects.blocks.containers.refinery;

import me.rexysaur.ccraft.objects.blocks.containers.ModelCustomChest;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderRefinery extends TileEntitySpecialRenderer<TileEntityRefinery>{
	private final ResourceLocation TEXTURE;
	protected ModelBase MODEL = new ModelCustomChest();
	
	public final String texture_name;
	
	public RenderRefinery(String texture_name) {
		this.texture_name = texture_name;
		
		this.TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/blocks/" + texture_name + ".png");
	}
}
