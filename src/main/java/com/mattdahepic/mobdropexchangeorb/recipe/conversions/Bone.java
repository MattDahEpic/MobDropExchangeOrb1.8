package com.mattdahepic.mobdropexchangeorb.recipe.conversions;

import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Bone {
    public Bone () {}
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(MobDropExchangeOrb.itemMobEssence, Config.boneEssence), convert()); //turn into essence
        GameRegistry.addShapelessRecipe(new ItemStack(Items.bone,2),produce());
    }
    private static Object[] convert () {
        ItemStack orb = new ItemStack(MobDropExchangeOrb.itemMobDropExchangeOrb.setContainerItem(MobDropExchangeOrb.itemMobDropExchangeOrb),1,32767);
        ItemStack arrow = new ItemStack(Items.bone);
        Object[] recipe = new Object[2];
        recipe[0] = orb;
        recipe[1] = arrow;
        return recipe;
    }
    private static Object[] produce () {
        ItemStack arrow = new ItemStack(Items.bone);
        ItemStack essence = new ItemStack(MobDropExchangeOrb.itemMobEssence);
        Object[] recipe = new Object[Config.boneEssence+1];
        recipe[0] = arrow;
        for (int i = 1; i <= Config.boneEssence; i++) {
            recipe[i] = essence;
        }
        return recipe;
    }
}
