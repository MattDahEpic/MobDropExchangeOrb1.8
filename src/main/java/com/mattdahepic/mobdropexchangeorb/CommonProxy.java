package com.mattdahepic.mobdropexchangeorb;

import com.mattdahepic.mobdropexchangeorb.config.Config;
import com.mattdahepic.mobdropexchangeorb.recipe.RecipeRegisterer;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers() {}
    public void registerBlocksItems() {
        GameRegistry.registerItem(MobDropExchangeOrb.itemMobDropExchangeOrb,"mobDropExchangeOrb");
        GameRegistry.registerItem(MobDropExchangeOrb.itemMobEssence,"mobEssence");
    }
    public void registerRecipes() {
        RecipeRegisterer.registerRecipes(Config.convertMusicDisks,Config.convertWitchDrops,Config.convertSponges,Config.convertWitherSkulls,Config.orbHardMode);
    }
}
