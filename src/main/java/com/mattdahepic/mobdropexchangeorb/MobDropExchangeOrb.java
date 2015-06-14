package com.mattdahepic.mobdropexchangeorb;

import com.mattdahepic.mdecore.helpers.LogHelper;
import com.mattdahepic.mdecore.update.UpdateChecker;
import com.mattdahepic.mobdropexchangeorb.config.Config;
import com.mattdahepic.mobdropexchangeorb.item.ItemMobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.item.ItemMobEssence;
import com.mattdahepic.mobdropexchangeorb.network.PacketHandler;
import com.mattdahepic.mobdropexchangeorb.network.SyncPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

@Mod(modid = MobDropExchangeOrb.MODID,name = MobDropExchangeOrb.NAME,version = MobDropExchangeOrb.VERSION,dependencies = "required-after:mdecore@[1.8-1.1.2);")
public class MobDropExchangeOrb {
    @Mod.Instance("mobdropexchangeorb")
    public static MobDropExchangeOrb instance;

    public static final String MODID = "mobdropexchangeorb";
    public static final String NAME = "Mob Drop Exchange Orb";
    public static final String VERSION = "1.8-1.5";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/MobDropExchangeOrb1.8/master/version.txt";

    @SidedProxy(clientSide = "com.mattdahepic.mobdropexchangeorb.client.ClientProxy",serverSide = "com.mattdahepic.mobdropexchangeorb.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

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
        PacketHandler.initPackets();
        itemMobDropExchangeOrb = new ItemMobDropExchangeOrb();
        itemMobEssence = new ItemMobEssence();
        proxy.registerBlocksItems();
        proxy.registerRecipes();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info(MODID,"Ready to transmute!");
        UpdateChecker.updateCheck(MODID,NAME,UPDATE_URL,VERSION,false,null);
    }
    @SubscribeEvent
    public void playerJoined (PlayerEvent.PlayerLoggedInEvent event) {
        UpdateChecker.updateCheck(MODID,NAME,UPDATE_URL,VERSION,true,event.player);
        if (!event.player.worldObj.isRemote) {
            if (event.player instanceof EntityPlayerMP) {
                LogHelper.info(MODID,"Sending configuration settings packet from the server to the connecting client "+event.player.getDisplayName()+".");
                IMessage sync = new SyncPacket.SyncMessage(Config.blazeEssence,Config.stringEssence,Config.spiderEyeEssence,Config.gunpowderEssence,Config.enderPealEssence,Config.ghastTearEssence,Config.magmaCreamEssence,Config.arrowEssence,Config.boneEssence,Config.slimeBallEssence,Config.rottenFleshEssence,Config.convertMusicDisks,Config.convertWitchDrops,Config.glassBottleEssence,Config.glowstoneEssence,Config.redstoneEssence,Config.stickEssence,Config.sugarEssence,Config.orbHasDurability,Config.orbDurability,Config.orbHardMode);
                PacketHandler.net.sendTo(sync,(EntityPlayerMP) event.player);
            }
        }
    }
}
