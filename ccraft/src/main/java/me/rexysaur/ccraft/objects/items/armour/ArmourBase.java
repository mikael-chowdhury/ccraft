package me.rexysaur.ccraft.objects.items.armour;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.init.ItemInit;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmourBase extends ItemArmor implements IHasModel {
	public ArmourBase(String name, ArmorMaterial material, EntityEquipmentSlot slot) {
		super(material, 0, slot);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CCRAFTTOOLSTAB);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,  0, "inventory");
	}
}
