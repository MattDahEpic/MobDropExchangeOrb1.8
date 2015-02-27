package com.mattdahepic.mobdropexchangeorb.client;

import com.mattdahepic.mobdropexchangeorb.CommonProxy;
import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        // This is for rendering entities and so forth later on
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MobDropExchangeOrb.itemMobEssence,0,new ModelResourceLocation("mobdropexchangeorb:mobEssence","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MobDropExchangeOrb.itemMobDropExchangeOrb,0,new ModelResourceLocation("mobdropexchangeorb:mobDropExchangeOrb","inventory"));
    }
}
