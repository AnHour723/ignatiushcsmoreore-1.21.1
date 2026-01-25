package com.ysmhmcgames.ihc_more_ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.HCBlockEntity;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import com.ysmhmcgames.ihc_more_ore.enchantment.HCEnchantmentEffects;
import com.ysmhmcgames.ihc_more_ore.entity.HCEntities;
import com.ysmhmcgames.ihc_more_ore.item.*;
import com.ysmhmcgames.ihc_more_ore.loot.HCLootModifiers;
import com.ysmhmcgames.ihc_more_ore.recipe.HCRecipes;
import com.ysmhmcgames.ihc_more_ore.screen.HCMenuTypes;
import com.ysmhmcgames.ihc_more_ore.sound.HCSounds;
import com.ysmhmcgames.ihc_more_ore.util.HCItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(IgnatiusHCsMoreOre.MODID)
public class IgnatiusHCsMoreOre {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ignatiushcsmoreore";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public IgnatiusHCsMoreOre(IEventBus modEventBus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (IgnatiusHCsMoreOre) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        HCOreItem.register(modEventBus);// item注册
        HCTools.register(modEventBus);// 工具物品的注册
        HCItems.register(modEventBus);// 杂货物品的注册
        HCArmor.register(modEventBus);// 装备物品的注册
        HCBlock.register(modEventBus); // block注册
        ItemTab.MODE_TAB.register(modEventBus);
        HCBlockEntity.register(modEventBus);// block entity注册

        HCEffects.register(modEventBus); // 效果注册

        HCMenuTypes.register(modEventBus);// 菜单注册
        HCRecipes.register(modEventBus);// 配方注册

        HCEnchantmentEffects.register(modEventBus);// 附魔注册

        HCEntities.register(modEventBus);// 实体注册

        HCSounds.register(modEventBus);// 声音注册

        HCLootModifiers.register(modEventBus);// 战利品表注册

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        HCItemProperties.addCustomItemProperties();
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


}
