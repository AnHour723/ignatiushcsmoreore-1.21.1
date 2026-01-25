package com.ysmhmcgames.ihc_more_ore.worldgen;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class HCPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");// 锡的替换key
    public static final ResourceKey<PlacedFeature> ALUMINUM_ORE_PLACED_KEY = registerKey("aluminum_ore_placed");// 锡的替换key
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");// 锡的替换key

    public static final ResourceKey<PlacedFeature> TILAMA_ORE_PLACED_KEY = registerKey("tilama_ore_placed");// 提拉马的替换key
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");// 红宝石的替换key

    public static final ResourceKey<PlacedFeature> TWILIGHT_CLOUD_ELEMENT_PLACED_KEY = registerKey("twilight_cloud_element_placed");// 暮云素的替换key

    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");// 钛矿的替换key
    public static final ResourceKey<PlacedFeature> ROSE_ORE_PLACED_KEY = registerKey("rose_ore_placed");// 玫红矿的替换key
    public static final ResourceKey<PlacedFeature> VIOLET_GEMSTONE_PLACED_KEY = registerKey("violet_gemstone_placed");// 紫罗兰矿的替换key
    public static final ResourceKey<PlacedFeature> PRECURSOR_ORE_PLACED_KEY = registerKey("precursor_ore_placed");// 元祖矿的替换key

    public static final ResourceKey<PlacedFeature> QUANTUM_DOMAIN_PLACED_KEY = registerKey("quantum_domain_placed");// 量子域的替换key
    public static final ResourceKey<PlacedFeature> INVISIBLE_BLOCK_PLACED_KEY = registerKey("invisible_block_placed");// 不可见方块的替换key

    public static final ResourceKey<PlacedFeature> PRISMATIC_COLORFUL_PLACED_KEY = registerKey("prismatic_colorful_placed");// 棱彩矿替换key

    public static final ResourceKey<PlacedFeature> THOUGHTS_ORE_PLACED_KEY = registerKey("thoughts_ore_placed");// 思绪矿替换key

    public static final ResourceKey<PlacedFeature> DEEPSEA_RESIDUE_PLACED_KEY = registerKey("deepsea_residue_placed");// 深海残渣替换key
    public static final ResourceKey<PlacedFeature> POSEIDON_ORE_PLACED_KEY = registerKey("poseidon_ore_placed");// 海神矿替换key

    public static final ResourceKey<PlacedFeature> PROFANE_BLOOD_PLACED_KEY = registerKey("profane_blood_placed");// 亵渎之血替换key
    public static final ResourceKey<PlacedFeature> HEROIC_REMAINS_PLACED_KEY = registerKey("heroic_remains_placed");// 英雄残骸替换key

    public static final ResourceKey<PlacedFeature> SPIRITUAL_COAL_ORE_PLACED_KEY = registerKey("spiritual_coal_ore_placed");// 灵煤矿替换key
    public static final ResourceKey<PlacedFeature> SALTPETRE_ORE_PLACED_KEY = registerKey("saltpetre_ore_placed");// 硝石矿替换key

    public static final ResourceKey<PlacedFeature> POLE_ORE_PLACED_KEY = registerKey("pole_ore_placed");// 极点矿替换key

    public static final ResourceKey<PlacedFeature> OVERWORLD_ORE_PLACED_KEY = registerKey("overworld_ore_placed");// 主界矿替换key

    /*==============================================================================================*/
    public static final ResourceKey<PlacedFeature> NETHER_HEYAN_ORE_PLACED_KEY = registerKey("nether_heyan_ore_placed");// 赫岩矿替换key
    public static final ResourceKey<PlacedFeature> NETHER_BLACK_CRYSTALS_ORE_PLACED_KEY = registerKey("nether_black_crystals_ore_placed");// 黑晶矿替换key
    public static final ResourceKey<PlacedFeature> NETHER_RED_LOTUS_BLOCK_PLACED_KEY = registerKey("nether_red_lotus_block_placed");// 红莲块替换key
    public static final ResourceKey<PlacedFeature> NETHER_PYROCARBON_ORE_PLACED_KEY = registerKey("nether_pyrocarbon_ore_placed");// 冥火矿替换key
    public static final ResourceKey<PlacedFeature> NETHER_HELL_S_ORE_PLACED_KEY = registerKey("nether_hell_s_ore_placed");// 狱炎矿替换key
    public static final ResourceKey<PlacedFeature> NETHER_SEYIN_ORE_PLACED_KEY = registerKey("nether_seyin_ore_placed");// 瑟银矿替换key

    public static final ResourceKey<PlacedFeature> NETHER_POLE_ORE_PLACED_KEY = registerKey("nether_pole_ore_placed");// 下界极点矿替换key


    public static final ResourceKey<PlacedFeature> NETHER_ORE_PLACED_KEY = registerKey("nether_ore_placed");// 下界矿替换key
    /*==============================================================================================*/
    public static final ResourceKey<PlacedFeature> END_GAZING_ORE_PLACED_KEY = registerKey("end_gazing_ore_placed");// 凝视矿替换key
    public static final ResourceKey<PlacedFeature> END_STARDUST_ORE_PLACED_KEY = registerKey("end_stardust_ore_placed");// 星尘矿替换key
    public static final ResourceKey<PlacedFeature> END_DIVINATION_DRAGON_ORE_PLACED_KEY = registerKey("end_divination_dragon_ore_placed");// 龙占矿替换key
    public static final ResourceKey<PlacedFeature> END_COLLAPSING_BLOCK_PLACED_KEY = registerKey("end_collapsing_block_placed");// 坍缩嵌块替换key
    public static final ResourceKey<PlacedFeature> END_ENDER_ORE_PLACED_KEY = registerKey("end_ender_ore_placed");// 末影矿替换key
    public static final ResourceKey<PlacedFeature> END_POLE_ORE_PLACED_KEY = registerKey("end_pole_ore_placed");// 终界极点矿替换key

    public static final ResourceKey<PlacedFeature> END_VOID_CRYSTAL_ORE_PLACED_KEY = registerKey("end_void_crystal_ore_placed");// 墨晶矿替换key

    public static final ResourceKey<PlacedFeature> END_ORE_PLACED_KEY = registerKey("end_ore_placed");// 终界矿替换key


    public static void bootstrap(BootstrapContext<PlacedFeature> context){
        var configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        // 锡 的生成
        register(context, TIN_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_TIN_ORE_KEY),
                /* 运用复制过来的原版的生成逻辑代码(方法)
                uniform 均匀分布     VerticalAnchor.absolute()垂直锚点绝对值
                含义：均匀生成到-64~80高度间
                */
                HCOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(-24),VerticalAnchor.absolute(72))));

        // 铝 的生成
        register(context, ALUMINUM_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_ALUMINUM_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(-36),VerticalAnchor.absolute(64))));

        // 银 的生成
        register(context, SILVER_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                HCOrePlacement.commonOrePlacement(8,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(32))));

        // 红宝石 的生成
        register(context, RUBY_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                HCOrePlacement.commonOrePlacement(8,HeightRangePlacement.triangle(VerticalAnchor.absolute(-16),VerticalAnchor.absolute(72))));
        // 提拉马 的生成
        register(context, TILAMA_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_TILAMA_ORE_KEY),
                HCOrePlacement.commonOrePlacement(10,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(72))));

        // 钛 的生成
        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_TITANIUM_ORE_KEY),
                HCOrePlacement.commonOrePlacement(8,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(16))));
        // 玫瑰宝石 的生成
        register(context, ROSE_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_ROSE_ORE_KEY),
                HCOrePlacement.commonOrePlacement(4,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(24))));
        // 紫罗兰 的生成
        register(context, VIOLET_GEMSTONE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_VIOLET_GEMSTONE_KEY),
                HCOrePlacement.commonOrePlacement(4,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(24))));
        // 元祖矿 的生成
        register(context, PRECURSOR_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_PRECURSOR_ORE_KEY),
                HCOrePlacement.commonOrePlacement(2,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(16))));


        // 量子域 的生成
        register(context, QUANTUM_DOMAIN_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_QUANTUM_DOMAIN_KEY),
                HCOrePlacement.commonOrePlacement(2,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(16))));
        // 不可见方块 的生成
        register(context, INVISIBLE_BLOCK_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_INVISIBLE_BLOCK_KEY),
                HCOrePlacement.commonOrePlacement(3,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(32))));

        // 棱彩矿 的生成
        register(context, PRISMATIC_COLORFUL_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_PRISMATIC_COLORFUL_KEY),
                HCOrePlacement.commonOrePlacement(2,HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(8))));

        // 暮云素 的生成
        register(context, TWILIGHT_CLOUD_ELEMENT_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_TWILIGHT_CLOUD_ELEMENT_KEY),
                HCOrePlacement.commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(150),VerticalAnchor.absolute(300))));

        // 思绪矿 的生成
        register(context, THOUGHTS_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_THOUGHTS_ORE_KEY),
                HCOrePlacement.commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));

        // 深海残渣 的生成
        register(context, DEEPSEA_RESIDUE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_DEEPSEA_RESIDUE_KEY),
                HCOrePlacement.commonOrePlacement(8,HeightRangePlacement.uniform(VerticalAnchor.absolute(15),VerticalAnchor.absolute(64))));
        // 海神矿 的生成
        register(context, POSEIDON_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_POSEIDON_ORE_KEY),
                HCOrePlacement.commonOrePlacement(6,HeightRangePlacement.uniform(VerticalAnchor.absolute(15),VerticalAnchor.absolute(64))));

        // 亵渎之血 的生成
        register(context, PROFANE_BLOOD_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_PROFANE_BLOOD_KEY),
                HCOrePlacement.commonOrePlacement(6,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(0))));
        // 英雄残骸 的生成
        register(context, HEROIC_REMAINS_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_HEROIC_REMAINS_KEY),
                HCOrePlacement.commonOrePlacement(6,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(0))));

        // 灵煤矿 的生成
        register(context, SPIRITUAL_COAL_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_SPIRITUAL_COAL_ORE_KEY),
                HCOrePlacement.commonOrePlacement(7,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(16))));
        // 硝石矿 的生成
        register(context, SALTPETRE_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_SALTPETRE_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(-32),VerticalAnchor.absolute(80))));
        // 极点矿 的生成
        register(context, POLE_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_POLE_ORE_KEY),
                HCOrePlacement.commonOrePlacement(3,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(-32))));

        // 主界矿 的生成
        register(context, OVERWORLD_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.OVERWORLD_ORE_KEY),
                HCOrePlacement.commonOrePlacement(1,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(-32))));

        /*======================================================================================*/
        // 赫岩矿 的生成
        register(context, NETHER_HEYAN_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_HEYAN_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 黑晶矿 的生成
        register(context, NETHER_BLACK_CRYSTALS_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_BLACK_CRYSTALS_ORE_KEY),
                HCOrePlacement.commonOrePlacement(10,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 红莲块 的生成
        register(context, NETHER_RED_LOTUS_BLOCK_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_RED_LOTUS_BLOCK_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 冥火矿 的生成
        register(context, NETHER_PYROCARBON_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_PYROCARBON_ORE_KEY),
                HCOrePlacement.commonOrePlacement(20,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 狱炎矿 的生成
        register(context, NETHER_HELL_S_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_HELL_S_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 瑟银矿 的生成
        register(context, NETHER_SEYIN_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_SEYIN_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 下界极点矿 的生成
        register(context, NETHER_POLE_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_POLE_ORE_KEY),
                HCOrePlacement.commonOrePlacement(3,HeightRangePlacement.uniform(VerticalAnchor.absolute(32),VerticalAnchor.absolute(127))));

        // 下届矿 的生成
        register(context, NETHER_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.NETHER_ORE_KEY),
                HCOrePlacement.commonOrePlacement(1,HeightRangePlacement.uniform(VerticalAnchor.absolute(80),VerticalAnchor.absolute(127))));

        /*======================================================================================*/
        // 凝视矿 的生成
        register(context, END_GAZING_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_GAZING_ORE_KEY),
                HCOrePlacement.commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 星尘矿 的生成
        register(context, END_STARDUST_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_STARDUST_ORE_KEY),
                HCOrePlacement.commonOrePlacement(14,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 龙占矿 的生成
        register(context, END_DIVINATION_DRAGON_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_DIVINATION_DRAGON_ORE_KEY),
                HCOrePlacement.commonOrePlacement(10,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 坍缩嵌块 的生成
        register(context, END_COLLAPSING_BLOCK_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_COLLAPSING_BLOCK_KEY),
                HCOrePlacement.commonOrePlacement(4,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 末影矿 的生成
        register(context, END_ENDER_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_ENDER_ORE_KEY),
                HCOrePlacement.commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));
        // 终界极点矿 的生成
        register(context, END_POLE_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_POLE_ORE_KEY),
                HCOrePlacement.commonOrePlacement(3,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));

        // 墨晶矿 的生成
        register(context, END_VOID_CRYSTAL_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_VOID_CRYSTAL_ORE_KEY),
                HCOrePlacement.commonOrePlacement(15,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));


        // 终界矿 的生成
        register(context, END_ORE_PLACED_KEY, configuredFeature.getOrThrow(HCConfiguredFeatures.END_ORE_KEY),
                HCOrePlacement.commonOrePlacement(1,HeightRangePlacement.uniform(VerticalAnchor.absolute(4),VerticalAnchor.absolute(127))));


    }

    public static ResourceKey<PlacedFeature> registerKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
