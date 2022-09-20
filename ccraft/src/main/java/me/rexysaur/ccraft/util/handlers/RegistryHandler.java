package me.rexysaur.ccraft.util.handlers;

import java.lang.reflect.Field;

import me.rexysaur.ccraft.Main;
import me.rexysaur.ccraft.init.BlockInit;
import me.rexysaur.ccraft.init.EntityInit;
import me.rexysaur.ccraft.init.ItemInit;
import me.rexysaur.ccraft.objects.blocks.containers.RenderCustomChest;
import me.rexysaur.ccraft.objects.blocks.containers.generators.Generator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.RenderGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.TileEntityGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.generators.gold_generator.TileEntityGoldGenerator;
import me.rexysaur.ccraft.objects.blocks.containers.silver_chest.TileEntitySilverChest;
import me.rexysaur.ccraft.recipes.SmeltingRecipes;
import me.rexysaur.ccraft.util.interfaces.IHasModel;
import me.rexysaur.ccraft.world.gen.WorldGenOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
    	ForgeRegistries.ITEMS.registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
    
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
    	ForgeRegistries.BLOCKS.registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    	TileEntityHandler.registerTileEntities();
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderCustomChest("silver_chest"));
    	
    	// Generators
    	for (TileEntityGenerator generator : TileEntityGenerator.GENERATORS) {
    		ClientRegistry.bindTileEntitySpecialRenderer(generator.getClass(), new RenderGenerator(generator.id));
    	}
    }
    
    
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
    	Main.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.SILVER_CHEST), 0, "inventory");
    	
    	Main.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.GOLD_GENERATOR), 0, "inventory");
    	
    	// Generators
    	for (Generator generator : Generator.GENERATORS) {
    		Field field;
			try {
				field = BlockInit.class.getClass().getField(generator.getUnlocalizedName().toUpperCase());
	    		Block value;
				try {
					
					value = (Block) field.get(BlockInit.class);
		    		Main.proxy.registerItemRenderer(Item.getItemFromBlock(value), 0, "inventory");
		    		
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
    	}
    	
    	
        for(Item item : ItemInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }
        
	    for (Block block : BlockInit.BLOCKS) {
		    if(block instanceof IHasModel) {
			    ((IHasModel)block).registerModels();
		    }
	    }
    }

    public static void preInitRegistries()
    {
		 GameRegistry.registerWorldGenerator(new WorldGenOres(), 4);
		 
		 EntityInit.registerEntities();
		 RenderHandler.registerEntityRenders();
		 
		 MinecraftForge.EVENT_BUS.register(new CCraftEventHandler());
    }
    
    public static void initRegistries()
    {
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    	
    	SmeltingRecipes.init();
    }
    
    public static void postInitRegistries()
    {
        
    }
    
    public static void serverRegistries(FMLServerStartingEvent event)
    {
        
    }
}