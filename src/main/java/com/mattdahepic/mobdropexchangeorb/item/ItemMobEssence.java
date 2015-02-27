package com.mattdahepic.mobdropexchangeorb.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMobEssence extends Item {
    public ItemMobEssence () {
        super();
        this.setUnlocalizedName("mobEssence");
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }
}
