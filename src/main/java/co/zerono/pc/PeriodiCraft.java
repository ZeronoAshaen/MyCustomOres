package co.zerono.pc;

import net.minecraft.block.BlockOre;
import co.zerono.pc.blocks.BlockPC;
import co.zerono.pc.handlers.ConfigurationHandler;
import co.zerono.pc.handlers.GuiHandler;
import co.zerono.pc.init.ModBlocks;
import co.zerono.pc.init.RegOre;
import co.zerono.pc.network.PacketHandler;
import co.zerono.pc.proxy.IProxy;
import co.zerono.pc.reference.Messages;
import co.zerono.pc.reference.Reference;
import co.zerono.pc.reference.Settings;
import co.zerono.pc.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, certificateFingerprint = Reference.FINGERPRINT, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PeriodiCraft 
{
    @Mod.Instance(Reference.MOD_NAME)
    public static PeriodiCraft instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    
    @Mod.EventHandler
    public void invalidFigerprint(FMLFingerprintViolationEvent event)
    {
        // Report (log) to the user that the version of Essence Craft
        // they are using has been changed/tampered with
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@"))
        {
            LogHelper.info(Messages.NO_FINGERPRINT_MESSAGE);
        }
        else
        {
            LogHelper.warn(Messages.INVALID_FINGERPRINT_MESSAGE);
        }
    }
    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        PacketHandler.init();
        proxy.registerKeybindings();
        // TODO ModItems.Init();
        ModBlocks.init();
        // TODO RegOre.init();
        LogHelper.info("PreInit Complete");
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Register the GUI Handler
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	// Initialize Tile Entities
    	// Initialize custom rendering and pre-load textures (Client only)
    	// Register the Items Event Handler
    	proxy.registerEventHandlers();
    	
        // TODO Recipes.Init();
        // Register the Waila data provider
        // TODO
        
        LogHelper.info("Init Complete");
    }
    
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Register recipes
    	
    	
    	LogHelper.info("postInit Complete");
    }
}
