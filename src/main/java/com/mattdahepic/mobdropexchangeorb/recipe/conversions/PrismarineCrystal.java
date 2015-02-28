package com.mattdahepic.mobdropexchangeorb.recipe.conversions;

import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PrismarineCrystal {
    public PrismarineCrystal() {}
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(MobDropExchangeOrb.itemMobEssence, Config.prismarineCrystalEssence),convert());
        GameRegistry.addShapelessRecipe(new ItemStack(Items.prismarine_crystals,2),produce());
    }
    private static Object[] convert () {
        ItemStack orb = new ItemStack(MobDropExchangeOrb.itemMobDropExchangeOrb.setContainerItem(MobDropExchangeOrb.itemMobDropExchangeOrb),1,32767);
        ItemStack crystal = new ItemStack(Items.prismarine_crystals);
        Object[] recipe = new Object[2];
        recipe[0] = orb;
        recipe[1] = crystal;
        return recipe;
    }
    private static Object[] produce () {
        ItemStack crystal = new ItemStack(Items.prismarine_crystals);
        ItemStack essence = new ItemStack(MobDropExchangeOrb.itemMobEssence);
        Object[] recipe = new Object[Config.prismarineCrystalEssence+1];
        recipe[0] = crystal;
        for (int i = 1; i <= Config.prismarineCrystalEssence ; i++) {
            recipe[i] = essence;
        }
        return recipe;
    }
}
