package me.rexysaur.ccraft.objects.blocks.containers.generators;

import me.rexysaur.ccraft.objects.blocks.containers.RenderCustomChest;

public class RenderGenerator extends RenderCustomChest {

	public RenderGenerator(String texture_name) {
		super(texture_name);
		this.MODEL = new ModelGenerator();
	}

}
