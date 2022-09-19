package me.rexysaur.ccraft.objects.items.tools;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.init.ItemInit;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
	public ToolMaterial toolMaterial;
	
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		
		this.toolMaterial = material;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CCRAFTTOOLSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public float getAttackDamage() {
		return (float) (this.toolMaterial.getAttackDamage());
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
