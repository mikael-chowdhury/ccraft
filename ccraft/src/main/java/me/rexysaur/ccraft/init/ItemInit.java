package me.rexysaur.ccraft.init;

import java.util.ArrayList;
import java.util.List;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.objects.items.ItemBase;
import me.rexysaur.ccraft.objects.items.armour.ArmourBase;
import me.rexysaur.ccraft.objects.items.items.RadioactiveCoal;
import me.rexysaur.ccraft.objects.items.tools.ToolAxe;
import me.rexysaur.ccraft.objects.items.tools.ToolHammer;
import me.rexysaur.ccraft.objects.items.tools.ToolHoe;
import me.rexysaur.ccraft.objects.items.tools.ToolPickaxe;
import me.rexysaur.ccraft.objects.items.tools.ToolShovel;
import me.rexysaur.ccraft.objects.items.tools.ToolSword;
import me.rexysaur.ccraft.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;


public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Materials
	public static final ArmorMaterial ARMOUR_OBSIDIAN = EnumHelper.addArmorMaterial("armor_obsidian", Reference.MOD_ID + ":obsidian", 1500, new int[] {6, 9, 11, 7}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f);
	public static final ArmorMaterial ARMOUR_URANIUM = EnumHelper.addArmorMaterial("armor_uranium", Reference.MOD_ID + ":uranium", 2000, new int[] {8, 11, 13, 9}, 20, SoundEvents.BLOCK_METAL_STEP, 10.0f);
	
	public static final ToolMaterial TOOL_OBSIDIAN = EnumHelper.addToolMaterial("tool_obsidian", 4, 3500, 20, 15, 15);
	public static final ToolMaterial TOOL_URANIUM = EnumHelper.addToolMaterial("tool_uranium", 5, 5000, 30, 20, 20);
	
	public static final Item OBSIDIAN_INGOT = new ItemBase("obsidian_ingot", Main.CCRAFTMATERIALSTAB);
	public static final Item URANIUM_INGOT = new ItemBase("uranium_ingot", Main.CCRAFTMATERIALSTAB);
	
	public static final Item RADIOACTIVE_COAL = new RadioactiveCoal("radioactive_coal");
	
	// Tools
	public static final Item OBSIDIAN_SWORD = new ToolSword("obsidian_sword", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_AXE = new ToolAxe("obsidian_axe", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_PICKAXE = new ToolPickaxe("obsidian_pickaxe", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_SHOVEL = new ToolShovel("obsidian_shovel", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_HOE = new ToolHoe("obsidian_hoe", TOOL_OBSIDIAN);
	
	public static final Item URANIUM_SWORD = new ToolSword("uranium_sword", TOOL_URANIUM);
	public static final Item URANIUM_AXE = new ToolAxe("uranium_axe", TOOL_URANIUM);
	public static final Item URANIUM_PICKAXE = new ToolPickaxe("uranium_pickaxe", TOOL_URANIUM);
	public static final Item URANIUM_SHOVEL = new ToolShovel("uranium_shovel", TOOL_URANIUM);
	public static final Item URANIUM_HOE = new ToolHoe("uranium_hoe", TOOL_URANIUM);
	public static final Item URANIUM_HAMMER = new ToolHammer("uranium_hammer", TOOL_URANIUM);
	
	// Armour
	public static final Item OBSIDIAN_HELMET = new ArmourBase("obsidian_helmet", ARMOUR_OBSIDIAN, EntityEquipmentSlot.HEAD);
	public static final Item OBSIDIAN_CHESTPLATE = new ArmourBase("obsidian_chestplate", ARMOUR_OBSIDIAN, EntityEquipmentSlot.CHEST);
	public static final Item OBSIDIAN_LEGGINGS = new ArmourBase("obsidian_leggings", ARMOUR_OBSIDIAN, EntityEquipmentSlot.LEGS);
	public static final Item OBSIDIAN_BOOTS = new ArmourBase("obsidian_boots", ARMOUR_OBSIDIAN, EntityEquipmentSlot.FEET);
	
	public static final Item URANIUM_HELMET = new ArmourBase("uranium_helmet", ARMOUR_URANIUM, EntityEquipmentSlot.HEAD);
	public static final Item URANIUM_CHESTPLATE = new ArmourBase("uranium_chestplate", ARMOUR_URANIUM, EntityEquipmentSlot.CHEST);
	public static final Item URANIUM_LEGGINGS = new ArmourBase("uranium_leggings", ARMOUR_URANIUM, EntityEquipmentSlot.LEGS);
	public static final Item URANIUM_BOOTS = new ArmourBase("uranium_boots", ARMOUR_URANIUM, EntityEquipmentSlot.FEET);
}