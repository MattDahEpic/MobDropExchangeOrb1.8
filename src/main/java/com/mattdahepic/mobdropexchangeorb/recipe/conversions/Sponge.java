package com.mattdahepic.mobdropexchangeorb.recipe.conversions;

import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.config.Config;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Sponge {
    public Sponge () {}
    public static void registerRecipes () {
        if (Config.convertSponges) {
            GameRegistry.addShapelessRecipe(new ItemStack(MobDropExchangeOrb.itemMobEssence,Config.spongeEssence),convert());
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sponge,2),produce());
        }
    }
    private static Object[] convert () {
        ItemStack orb = new ItemStack(MobDropExchangeOrb.itemMobDropExchangeOrb.setContainerItem(MobDropExchangeOrb.itemMobDropExchangeOrb),1,32767);
        ItemStack sponge = new ItemStack(Blocks.sponge);
        Object[] recipe = new Object[2];
        recipe[0] = orb;
        recipe[1] = sponge;
        return recipe;
    }
    private static Object[] produce () {
        ItemStack sponge = new ItemStack(Blocks.sponge);
        ItemStack essence = new ItemStack(MobDropExchangeOrb.itemMobEssence);
        Object[] recipe = new Object[Config.spongeEssence+1];
        recipe[0] = sponge;
        for (int i = 1; i <= Config.spongeEssence ; i++) {
            recipe[i] = essence;
        }
        return recipe;
    }
}
