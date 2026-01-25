package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.tools.SickleItem;
import com.ysmhmcgames.ihc_more_ore.item.tools.UpgradeTemplateItem;
import com.ysmhmcgames.ihc_more_ore.sound.HCSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCItems {
    // 声明总注册类型
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

    // 钢棒
    public static final DeferredItem<Item> STEEL_STICK = ITEMS.register("steel_stick",
            ()-> new Item(new Item.Properties()));
    // 提拉马棒
    public static final DeferredItem<Item> TILAMA_STICK = ITEMS.register("tilama_stick",
            ()-> new Item(new Item.Properties()));
    // 瑟银棒
    public static final DeferredItem<Item> SEYIN_STICK = ITEMS.register("seyin_stick",
            ()-> new Item(new Item.Properties()));
    // 末影棒
    public static final DeferredItem<Item> ENDER_STICK = ITEMS.register("ender_stick",
            ()-> new Item(new Item.Properties()));

    // 玻璃结晶模板
    public static final DeferredItem<Item> GLASS_CRYSTALLIZATION_TEMPLATE = ITEMS.register("glass_crystallization_template",
            ()-> new Item(new Item.Properties()));

    // 空白信息球
    public static final DeferredItem<Item> QUANTUM_INFORMATION_SPHERE = ITEMS.register("quantum_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子头盔信息球
    public static final DeferredItem<Item> QUANTUM_HELMET_INFORMATION_SPHERE = ITEMS.register("quantum_helmet_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子护甲信息球
    public static final DeferredItem<Item> QUANTUM_CHESTPLATE_INFORMATION_SPHERE = ITEMS.register("quantum_chestplate_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子裤腿信息球
    public static final DeferredItem<Item> QUANTUM_LEGGINGS_INFORMATION_SPHERE = ITEMS.register("quantum_leggings_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子靴子信息球
    public static final DeferredItem<Item> QUANTUM_BOOTS_INFORMATION_SPHERE = ITEMS.register("quantum_boots_information_sphere",
            ()-> new Item(new Item.Properties()));

    // 量子镰刀信息球
    public static final DeferredItem<Item> QUANTUM_SICKLE_INFORMATION_SPHERE = ITEMS.register("quantum_sickle_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子剑信息球
    public static final DeferredItem<Item> QUANTUM_SWORD_INFORMATION_SPHERE = ITEMS.register("quantum_sword_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子镐子信息球
    public static final DeferredItem<Item> QUANTUM_PICKAXE_INFORMATION_SPHERE = ITEMS.register("quantum_pickaxe_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子斧头信息球
    public static final DeferredItem<Item> QUANTUM_AXE_INFORMATION_SPHERE = ITEMS.register("quantum_axe_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子锹信息球
    public static final DeferredItem<Item> QUANTUM_SHOVEL_INFORMATION_SPHERE = ITEMS.register("quantum_shovel_information_sphere",
            ()-> new Item(new Item.Properties()));
    // 量子锄头信息球
    public static final DeferredItem<Item> QUANTUM_HOE_INFORMATION_SPHERE = ITEMS.register("quantum_hoe_information_sphere",
            ()-> new Item(new Item.Properties()));



    // 升级模板   合金 -> 量子
    public static final DeferredItem<Item> QUANTUM_UPGRADE_TEMPLATE = ITEMS.register("quantum_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"netherite","quantum"));
    // 升级模板   元祖 -> 棱彩
    public static final DeferredItem<Item> PRISMATIC_COLORFUL_UPGRADE_TEMPLATE = ITEMS.register("prismatic_colorful_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"netherite_or_precursor","prismatic_colorful"));
    // 升级模板   量子 -> 坍缩
    public static final DeferredItem<Item> COLLAPSING_UPGRADE_TEMPLATE = ITEMS.register("collapsing_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"quantum","collapsing"));
    // 升级模板   量子 -> 主界
    public static final DeferredItem<Item> OVERWORLD_UPGRADE_TEMPLATE = ITEMS.register("overworld_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"quantum","overworld"));
    // 升级模板   主界 -> 下界
    public static final DeferredItem<Item> NETHER_UPGRADE_TEMPLATE = ITEMS.register("nether_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"overworld","nether"));
    // 升级模板   下界 -> 终界
    public static final DeferredItem<Item> END_UPGRADE_TEMPLATE = ITEMS.register("end_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"nether","end"));

    // 武器图纸   风暴 -> 两级弓
    public static final DeferredItem<Item> POLE_BOW_UPGRADE_TEMPLATE = ITEMS.register("pole_bow_upgrade_template",
            ()-> new UpgradeTemplateItem(new Item.Properties(),"bow","pole"));



    // 唱片 蓝花楹ai
    public static final DeferredItem<Item> LANHUAYING_AI_MUSIC_DISC = ITEMS.register("lanhuaying_ai_music_disc",
            ()-> new Item(new Item.Properties().jukeboxPlayable(HCSounds.LANHUAYING_AI_KEY).stacksTo(1)));
    // 唱片 蓝花楹
    public static final DeferredItem<Item> LANHUAYING_MUSIC_DISC = ITEMS.register("lanhuaying_music_disc",
            ()-> new Item(new Item.Properties().jukeboxPlayable(HCSounds.LANHUAYING_KEY).stacksTo(1)));

    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
