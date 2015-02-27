package com.mattdahepic.mobdropexchangeorb.recipe.conversions;

import com.mattdahepic.mobdropexchangeorb.MobDropExchangeOrb;
import com.mattdahepic.mobdropexchangeorb.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PrismarineShard {
    public PrismarineShard () {}
    public static void registerRecipes () {
        GameRegistry.addShapelessRecipe(new ItemStack(MobDropExchangeOrb.itemMobEssence,Config.prismarineShardEssence), convert());
        GameRegistry.addShapelessRecipe(new ItemStack(Items.prismarine_shard,2),produce());
    }
    private static Object[] convert () {
        ItemStack orb = new ItemStack(MobDropExchangeOrb.itemMobDropExchangeOrb.setContainerItem(MobDropExchangeOrb.itemMobDropExchangeOrb),1,32767);
        ItemStack shard = new ItemStack(Items.prismarine_shard);
        Object[] recipe = new Object[2];
        recipe[0] = orb;
        recipe[1] = shard;
        return recipe;
    }
    private static Object[] produce () {
        ItemStack shard = new ItemStack(Items.prismarine_shard);
        ItemStack essence = new ItemStack(MobDropExchangeOrb.itemMobEssence);
        Object[] recipe = new Object[Config.prismarineShardEssence+1];
        recipe[0] = shard;
        for (int i = 0; i <= Config.prismarineShardEssence ; i++) {
            recipe[i] = essence;
        }
        return recipe;
    }
}
