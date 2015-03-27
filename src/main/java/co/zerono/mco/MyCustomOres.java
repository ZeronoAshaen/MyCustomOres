package co.zerono.mco;

import net.minecraft.block.BlockOre;
import co.zerono.mco.blocks.BlockMCO;
import co.zerono.mco.handlers.ConfigurationHandler;
import co.zerono.mco.handlers.GuiHandler;
import co.zerono.mco.init.ModBlocks;
import co.zerono.mco.init.ModItems;
import co.zerono.mco.network.PacketHandler;
import co.zerono.mco.proxy.IProxy;
import co.zerono.mco.reference.Messages;
import co.zerono.mco.reference.Reference;
import co.zerono.mco.reference.Settings;
import co.zerono.mco.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, certificateFingerprint = Reference.FINGERPRINT, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MyCustomOres 
{
    @Mod.Instance(Reference.MOD_NAME)
    public static MyCustomOres instance;
    
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
        ModItems.preInit();
        ModBlocks.preInit();
        LogHelper.info("PreInit Complete");
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	// Register with OreDictionary
    	ModBlocks.init();
    	ModItems.init();
    	//Register the GUI Handler
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	// Register the Items Event Handler
    	proxy.registerEventHandlers();
    	
        // Register the Waila data provider
        // TODO
        
        LogHelper.info("Init Complete");
    }
    
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	LogHelper.info("postInit Complete");
    }
}
