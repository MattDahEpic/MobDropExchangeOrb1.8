package com.mattdahepic.mobdropexchangeorb;

import com.mattdahepic.mobdropexchangeorb.config.Config;
import com.mattdahepic.mobdropexchangeorb.item.ItemMobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.item.ItemMobEssence;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

@Mod(modid = MobDropExchangeOrb.MODID,name = MobDropExchangeOrb.NAME,version = MobDropExchangeOrb.VERSION,guiFactory = "com.mattdahepic.mobdropexchangeorb.config.MobDropExchangeOrbConfigFactory")
public class MobDropExchangeOrb {
    @Mod.Instance("mobdropexchangeorb")
    public static MobDropExchangeOrb instance;

    public static final String MODID = "mobdropexchangeorb";
    public static final String NAME = "Mob Drop Exchange Orb";
    public static final String VERSION = "mc1.7.10-v1.4";

    @SidedProxy(clientSide = "com.mattdahepic.mobdropexchangeorb.client.ClientProxy",serverSide = "com.mattdahepic.mobdropexchangeorb.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

    //blocks

    //item
    public static Item itemMobDropExchangeOrb;
    public static Item itemMobEssence;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(instance);
        Config.load(event);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        itemMobDropExchangeOrb = new ItemMobDropExchangeOrb();
        itemMobEssence = new ItemMobEssence();
        proxy.registerBlocksItems();
        proxy.registerRecipes();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.log(MobDropExchangeOrb.MODID,Level.INFO,"Ready to transmute!",null);
    }
}
