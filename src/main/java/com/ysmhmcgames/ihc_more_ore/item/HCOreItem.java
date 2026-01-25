package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.miscellaneous.HomecomingItem;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCOreItem {
    // 声明总注册类型
    public static final DeferredRegister.Items ORE_ITEMS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

    // 粗铝
    public static final DeferredItem<Item> RAW_ALUMINUM = ORE_ITEMS.register("raw_aluminum",
            ()-> new Item(new Item.Properties()));
    // 铝锭
    public static final DeferredItem<Item> ALUMINUM_INGOT = ORE_ITEMS.register("aluminum_ingot",
            ()-> new Item(new Item.Properties()));
    // 铝粒
    public static final DeferredItem<Item> ALUMINUM_NUGGET = ORE_ITEMS.register("aluminum_nugget",
            ()-> new Item(new Item.Properties()));
    // 粗锡
    public static final DeferredItem<Item> RAW_TIN = ORE_ITEMS.register("raw_tin",
            ()-> new Item(new Item.Properties()));
    // 锡锭
    public static final DeferredItem<Item> TIN_INGOT = ORE_ITEMS.register("tin_ingot",
            ()-> new Item(new Item.Properties()));
    // 锡粒
    public static final DeferredItem<Item> TIN_NUGGET = ORE_ITEMS.register("tin_nugget",
            ()-> new Item(new Item.Properties()));
    // 钢锭
    public static final DeferredItem<Item> STEEL_INGOT= ORE_ITEMS.register("steel_ingot",
            ()-> new Item(new Item.Properties()));
    // 钢粒
    public static final DeferredItem<Item> STEEL_NUGGET= ORE_ITEMS.register("steel_nugget",
            ()-> new Item(new Item.Properties()));

    // 粗银
    public static final DeferredItem<Item> RAW_SILVER = ORE_ITEMS.register("raw_silver",
            ()-> new Item(new Item.Properties()));
    // 银锭
    public static final DeferredItem<Item> SILVER_INGOT = ORE_ITEMS.register("silver_ingot",
            ()-> new Item(new Item.Properties()));
    // 银粒
    public static final DeferredItem<Item> SILVER_NUGGET = ORE_ITEMS.register("silver_nugget",
            ()-> new Item(new Item.Properties()));

    // 粗提拉马
    public static final DeferredItem<Item> RAW_TILAMA= ORE_ITEMS.register("raw_tilama",
            ()-> new Item(new Item.Properties()));
    // 提拉马锭
    public static final DeferredItem<Item> TILAMA_INGOT= ORE_ITEMS.register("tilama_ingot",
            ()-> new Item(new Item.Properties()));

    // 寒晶锭
    public static final DeferredItem<Item> ICE_CRYSTAL_INGOT= ORE_ITEMS.register("ice_crystal_ingot",
            ()-> new Item(new Item.Properties()));
    // 烈炎锭
    public static final DeferredItem<Item> BLAZING_FIRE_INGOT= ORE_ITEMS.register("blazing_fire_ingot",
            ()-> new Item(new Item.Properties()));
    // 活火
    public static final DeferredItem<Item> ACTIVE_FIRE= ORE_ITEMS.register("active_fire",
            ()-> new Item(new Item.Properties()));
    // 冰晶
    public static final DeferredItem<Item> ICE_CRYSTAL= ORE_ITEMS.register("ice_crystal",
            ()-> new Item(new Item.Properties()));


    // 暮云锭
    public static final DeferredItem<Item> TWILIGHT_CLOUD_INGOT= ORE_ITEMS.register("twilight_cloud_ingot",
            ()-> new Item(new Item.Properties()));
    // 风暴锭
    public static final DeferredItem<Item> STORM_INGOT= ORE_ITEMS.register("storm_ingot",
            ()-> new Item(new Item.Properties()));


    // 叶绿素
    public static final DeferredItem<Item> CHLOROPHYLL= ORE_ITEMS.register("chlorophyll",
            ()-> new Item(new Item.Properties()));
    // 叶绿核心
    public static final DeferredItem<Item> CHLOROPHYLL_CORE= ORE_ITEMS.register("chlorophyll_core",
            ()-> new Item(new Item.Properties()));
    // 叶绿团
    public static final DeferredItem<Item> CHLOROPLAST= ORE_ITEMS.register("chloroplast",
            ()-> new Item(new Item.Properties()));
    // 失活的叶绿锭
    public static final DeferredItem<Item> INACTIVATED_CHLOROPHYLL_INGOT = ORE_ITEMS.register("inactivated_chlorophyll_ingot",
            ()-> new Item(new Item.Properties()));
    // 叶绿锭
    public static final DeferredItem<Item> CHLOROPHYLL_INGOT= ORE_ITEMS.register("chlorophyll_ingot",
            ()-> new Item(new Item.Properties()));
    // 叶绿粒
    public static final DeferredItem<Item> CHLOROPHYLL_NUGGET= ORE_ITEMS.register("chlorophyll_nugget",
            ()-> new Item(new Item.Properties()));

    // 红宝石
    public static final DeferredItem<Item> RUBY= ORE_ITEMS.register("ruby",
            ()-> new Item(new Item.Properties()));

    // 不稳定的量子结构
    public static final DeferredItem<Item> UNSTABLE_QUANTUM_STRUCTURE= ORE_ITEMS.register("unstable_quantum_structure",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 量子锭
    public static final DeferredItem<Item> QUANTUM_INGOT= ORE_ITEMS.register("quantum_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));
    // ???
    public static final DeferredItem<Item> XXX= ORE_ITEMS.register("xxx",
            ()-> new Item(new Item.Properties()));
    // 不稳定的???
    public static final DeferredItem<Item> UNSTABLE_XXX= ORE_ITEMS.register("unstable_xxx",
            ()-> new Item(new Item.Properties()));
    // 粗钛
    public static final DeferredItem<Item> RAW_TITANIUM= ORE_ITEMS.register("raw_titanium",
            ()-> new Item(new Item.Properties()));
    // 钛锭
    public static final DeferredItem<Item> TITANIUM_INGOT= ORE_ITEMS.register("titanium_ingot",
            ()-> new Item(new Item.Properties()));

    // 海神碎片
    public static final DeferredItem<Item> POSEIDON_FRAGMENT= ORE_ITEMS.register("poseidon_fragment",
            ()-> new Item(new Item.Properties()));
    // 海神锭
    public static final DeferredItem<Item> POSEIDON_INGOT= ORE_ITEMS.register("poseidon_ingot",
            ()-> new Item(new Item.Properties()));

    // 绽放玫瑰
    public static final DeferredItem<Item> BLOSSOMING_ROSE= ORE_ITEMS.register("blossoming_rose",
            ()-> new Item(new Item.Properties()));
    // 玫瑰宝石
    public static final DeferredItem<Item> ROSE_GEMSTONE= ORE_ITEMS.register("rose_gemstone",
            ()-> new Item(new Item.Properties()));

    // 紫罗兰宝石
    public static final DeferredItem<Item> VIOLET_GEMSTONE= ORE_ITEMS.register("violet_gemstone",
            ()-> new Item(new Item.Properties()));

    // 棱彩碎片
    public static final DeferredItem<Item> PRISMATIC_COLORFUL_FRAGMENT= ORE_ITEMS.register("prismatic_colorful_fragment",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 棱彩核心
    public static final DeferredItem<Item> PRISMATIC_COLORFUL_CORE= ORE_ITEMS.register("prismatic_colorful_core",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 棱彩锭
    public static final DeferredItem<Item> PRISMATIC_COLORFUL_INGOT= ORE_ITEMS.register("prismatic_colorful_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));// 防火

    // 元祖素
    public static final DeferredItem<Item> PRECURSOR_ELEMENT= ORE_ITEMS.register("precursor_element",
            ()-> new Item(new Item.Properties()));
    // 元祖锭
    public static final DeferredItem<Item> PRECURSOR_INGOT= ORE_ITEMS.register("precursor_ingot",
            ()-> new Item(new Item.Properties()));

    // 亵渎结晶
    public static final DeferredItem<Item> PROFANE_CRYSTAL= ORE_ITEMS.register("profane_crystal",
            ()-> new Item(new Item.Properties()));

    // "英雄意志"
    public static final DeferredItem<Item> THE_WILL_OF_THE_HERO= ORE_ITEMS.register("the_will_of_the_hero",
            ()-> new Item(new Item.Properties()));
    // 圣钢
    public static final DeferredItem<Item> HOLY_STEEL_INGOT= ORE_ITEMS.register("holy_steel_ingot",
            ()-> new Item(new Item.Properties()));

    // 活跃触觉
    public static final DeferredItem<Item> TENTACULUM_WITH_NERVES= ORE_ITEMS.register("tentaculum_with_nerves",
            ()-> new Item(new Item.Properties()));

    // "思绪"
    public static final DeferredItem<Item> THOUGHT= ORE_ITEMS.register("thought",
            ()-> new Item(new Item.Properties()));
    // "归乡"
    public static final DeferredItem<Item> HOMECOMING= ORE_ITEMS.register("homecoming",
            ()-> new HomecomingItem(new Item.Properties()));;
    // "故乡的"枫叶
    public static final DeferredItem<Item> MAPLELEAVES_IN_MY_HOMETOWN= ORE_ITEMS.register("mapleleaves_in_my_hometown",
            ()-> new Item(new Item.Properties()));;
    // "魂归故里"
    public static final DeferredItem<Item> ONE_STRIKE_KILLS= ORE_ITEMS.register("one_strike_kills",
            ()-> new Item(new Item.Properties()));


    // ============================主界核心==========================================
    public static final DeferredItem<Item> OVERWORLD_CORE= ORE_ITEMS.register("overworld_core",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 灵魂精华
    public static final DeferredItem<Item> SOUL_ESSENCE= ORE_ITEMS.register("soul_essence",
            ()-> new Item(new Item.Properties().fireResistant()));;
    // 灵魂钢锭
    public static final DeferredItem<Item> SOUL_STEEL_INGOT= ORE_ITEMS.register("soul_steel_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 闪金锭
    public static final DeferredItem<Item> FLASH_GOLD_INGOT= ORE_ITEMS.register("flash_gold_ingot",
            ()-> new Item(new Item.Properties()));

    // 赫岩
    public static final DeferredItem<Item> HEYAN= ORE_ITEMS.register("heyan",
            ()-> new Item(new Item.Properties()));
    // 黑晶
    public static final DeferredItem<Item> BLACK_CRYSTALS= ORE_ITEMS.register("black_crystals",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 狱炎岩
    public static final DeferredItem<Item> HELL_S_STONE= ORE_ITEMS.register("hell_s_stone",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 狱炎锭
    public static final DeferredItem<Item> HELL_S_INGOT= ORE_ITEMS.register("hell_s_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 粗瑟银
    public static final DeferredItem<Item> RAW_SEYIN= ORE_ITEMS.register("raw_seyin",
            ()-> new Item(new Item.Properties()));
    // 瑟银锭
    public static final DeferredItem<Item> SEYIN_INGOT= ORE_ITEMS.register("seyin_ingot",
            ()-> new Item(new Item.Properties()));

    // 精炼红莲
    public static final DeferredItem<Item> REFINED_RED_LOTUS= ORE_ITEMS.register("refined_red_lotus",
            ()-> new Item(new Item.Properties().fireResistant()));

    //=========================================下届核心=========================================
    public static final DeferredItem<Item> NETHER_CORE= ORE_ITEMS.register("nether_core",
            ()-> new Item(new Item.Properties().fireResistant()));

    // "凝视"
    public static final DeferredItem<Item> GAZING= ORE_ITEMS.register("gazing",
            ()-> new Item(new Item.Properties()));
    // 诡异之眼
    public static final DeferredItem<Item> EERIE_EYE= ORE_ITEMS.register("eerie_eye",
            ()-> new Item(new Item.Properties()));

    // 星尘
    public static final DeferredItem<Item> STARDUST= ORE_ITEMS.register("stardust",
            ()-> new Item(new Item.Properties()));

    // 粗龙占
    public static final DeferredItem<Item> RAW_DIVINATION_DRAGON= ORE_ITEMS.register("raw_divination_dragon",
            ()-> new Item(new Item.Properties()));

    // 坍缩精元
    public static final DeferredItem<Item> COLLAPSING_CREAM= ORE_ITEMS.register("collapsing_cream",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 坍缩锭
    public static final DeferredItem<Item> COLLAPSING_INGOT= ORE_ITEMS.register("collapsing_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));
    // 坍缩核心
    public static final DeferredItem<Item> COLLAPSING_CORE= ORE_ITEMS.register("collapsing_core",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 粗末影矿
    public static final DeferredItem<Item> RAW_ENDER_ORE= ORE_ITEMS.register("raw_ender_ore",
            ()-> new Item(new Item.Properties()));
    // 末影锭
    public static final DeferredItem<Item> ENDER_INGOT= ORE_ITEMS.register("ender_ingot",
            ()-> new Item(new Item.Properties()));

    // 终界核心
    public static final DeferredItem<Item> END_CORE= ORE_ITEMS.register("end_core",
            ()-> new Item(new Item.Properties().fireResistant()));

    // ====================================多维度生成矿=============================================
    // 纯净白极点
    public static final DeferredItem<Item> PURE_WHITE_POLE= ORE_ITEMS.register("pure_white_pole",
            ()-> new Item(new Item.Properties()));
    // 纯净黑极点
    public static final DeferredItem<Item> PURE_BLACK_POLE= ORE_ITEMS.register("pure_black_pole",
            ()-> new Item(new Item.Properties()));
    // 模糊极点
    public static final DeferredItem<Item> FUZZY_POLE= ORE_ITEMS.register("fuzzy_pole",
            ()-> new Item(new Item.Properties()));
    // 太极
    public static final DeferredItem<Item> TAI_JI= ORE_ITEMS.register("taiji",
            ()-> new Item(new Item.Properties()));
    // 两极锭
    public static final DeferredItem<Item> POLE_INGOT= ORE_ITEMS.register("pole_ingot",
            ()-> new Item(new Item.Properties().fireResistant()));

    // 灵煤
    public static final DeferredItem<Item> SPIRITUAL_COAL= ORE_ITEMS.register("spiritual_coal",
            ()-> new FuelItem(new Item.Properties(),3200));// 200 烧制 1个物品
    // 硝石
    public static final DeferredItem<Item> SALTPETRE= ORE_ITEMS.register("saltpetre",
            ()-> new FuelItem(new Item.Properties(), 2000));
    // 冥火炭
    public static final DeferredItem<Item> PYROCARBON= ORE_ITEMS.register("pyrocarbon",
            ()-> new FuelItem(new Item.Properties(), 4800));
    // 虚空墨晶
    public static final DeferredItem<Item> VOID_CRYSTAL= ORE_ITEMS.register("void_crystal",
            ()-> new FuelItem(new Item.Properties().fireResistant(), 6400));

    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ORE_ITEMS.register(iEventBus);
    }

}
