package me.rexysaur.ccraft;

import me.rexysaur.ccraft.proxy.CommonProxy;
import me.rexysaur.ccraft.recipes.SmeltingRecipes;
import me.rexysaur.ccraft.tabs.CCraftBlocksTab;
import me.rexysaur.ccraft.tabs.CCraftMaterialsTab;
import me.rexysaur.ccraft.tabs.CCraftToolsTab;
import me.rexysaur.ccraft.util.Reference;
import me.rexysaur.ccraft.util.handlers.CCraftEventHandler;
import me.rexysaur.ccraft.util.handlers.RegistryHandler;
import me.rexysaur.ccraft.world.gen.WorldGenOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.NAME)
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	 public static final CreativeTabs CCRAFTMATERIALSTAB = new CCraftMaterialsTab();
	 public static final CreativeTabs CCRAFTBLOCKSTAB = new CCraftBlocksTab();
	 public static final CreativeTabs CCRAFTTOOLSTAB = new CCraftToolsTab();
	 
	 @EventHandler
	 public void preInit(FMLPreInitializationEvent event) {
		 RegistryHandler.preInitRegistries();
	 }
	 
	 @EventHandler
	 public void init(FMLInitializationEvent event) {
		 RegistryHandler.initRegistries();
	 }
	 
	 @EventHandler
	 public void postInit(FMLPostInitializationEvent event) {
		 RegistryHandler.postInitRegistries();
	 }
	 
	 @EventHandler
	 public void serverInit (FMLServerStartingEvent event) {
		 RegistryHandler.serverRegistries(event);
	 }
}
