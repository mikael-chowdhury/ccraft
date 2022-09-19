package me.rexysaur.ccraft.objects.items.tools;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.init.ItemInit;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CCRAFTTOOLSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
