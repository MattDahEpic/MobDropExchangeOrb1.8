package com.mattdahepic.mobdropexchangeorb.client;

import com.mattdahepic.mobdropexchangeorb.CommonProxy;
import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        // This is for rendering entities and so forth later on
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MobDropExchangeOrb.itemMobEssence, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("mobdropexchangeorb:mobEssence","inventory");
            }
        });
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MobDropExchangeOrb.itemMobDropExchangeOrb, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("mobdropexchangeorb:mobDropExchangeOrb","inventory");
            }
        });
    }
}
