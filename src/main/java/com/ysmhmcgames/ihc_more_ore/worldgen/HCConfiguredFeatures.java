package com.ysmhmcgames.ihc_more_ore.worldgen;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class HCConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TIN_ORE_KEY = registerKey("overworld_tin_ore");// 主世界锡矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ALUMINUM_ORE_KEY = registerKey("overworld_aluminum_ore");// 主世界铝矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SILVER_ORE_KEY = registerKey("overworld_silver_ore");// 主世界银矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TILAMA_ORE_KEY = registerKey("overworld_tilama_ore");// 主世界提拉马矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_RUBY_ORE_KEY = registerKey("overworld_ruby_ore");// 主世界红宝石矿石替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TWILIGHT_CLOUD_ELEMENT_KEY = registerKey("overworld_twilight_cloud_element");// 主世界暮云素替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("overworld_titanium_ore");// 主世界钛矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ROSE_ORE_KEY = registerKey("overworld_rose_ore");// 主世界玫红矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_VIOLET_GEMSTONE_KEY = registerKey("overworld_violet_gemstone");// 主世界紫罗兰矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_PRECURSOR_ORE_KEY = registerKey("overworld_precursor_ore");// 主世界元祖矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_INVISIBLE_BLOCK_KEY = registerKey("overworld_invisible_block");// 主世界量子域替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_QUANTUM_DOMAIN_KEY = registerKey("overworld_quantum_domain");// 主世界不可见方块替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_PRISMATIC_COLORFUL_KEY = registerKey("overworld_prismatic_colorful");// 主世界棱彩矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_THOUGHTS_ORE_KEY = registerKey("overworld_thoughts_ore");// 主世界思绪矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_PROFANE_BLOOD_KEY = registerKey("overworld_profane_blood");// 主世界亵渎之血替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_HEROIC_REMAINS_KEY = registerKey("overworld_heroic_remains");// 主世界英雄残骸替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_DEEPSEA_RESIDUE_KEY = registerKey("overworld_deepsea_residue_ore");// 主世界深海残渣替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_POSEIDON_ORE_KEY = registerKey("overworld_poseidon_ore");// 主世界海神矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SPIRITUAL_COAL_ORE_KEY = registerKey("overworld_spiritual_coal_ore");// 主世界灵煤矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SALTPETRE_ORE_KEY = registerKey("overworld_saltpetre_ore");// 主世界硝石矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_POLE_ORE_KEY = registerKey("overworld_pole_ore");// 主世界极点矿替换key


    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ORE_KEY = registerKey("overworld_overworld_ore");// 主世界主界矿替换key

    /*======================================================================================*/
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_HEYAN_ORE_KEY = registerKey("nether_heyan_ore");// 下界赫岩矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_BLACK_CRYSTALS_ORE_KEY = registerKey("nether_black_crystals_ore");// 下界黑晶矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_RED_LOTUS_BLOCK_KEY = registerKey("nether_red_lotus_block");// 下界红莲块替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_PYROCARBON_ORE_KEY = registerKey("nether_pyrocarbon_ore");// 下界冥火矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_HELL_S_ORE_KEY = registerKey("nether_hell_s_ore");// 下界狱炎矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_SEYIN_ORE_KEY = registerKey("nether_seyin_ore");// 下界瑟银矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_POLE_ORE_KEY = registerKey("nether_nether_pole_ore");// 下界极点矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_ORE_KEY = registerKey("nether_nether_ore");// 下界矿替换key
    /*======================================================================================*/
    public static final ResourceKey<ConfiguredFeature<?,?>> END_GAZING_ORE_KEY = registerKey("end_gazing_ore");// 终界凝视矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> END_STARDUST_ORE_KEY = registerKey("end_stardust_ore");// 终界星尘矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> END_DIVINATION_DRAGON_ORE_KEY = registerKey("end_divination_dragon_ore");// 终界龙占矿替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> END_COLLAPSING_BLOCK_KEY = registerKey("end_collapsing_block");// 终界坍缩嵌块替换key
    public static final ResourceKey<ConfiguredFeature<?,?>> END_ENDER_ORE_KEY = registerKey("end_ender_ore");// 终界末影矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> END_POLE_ORE_KEY = registerKey("end_end_pole_ore");// 终界极点矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> END_VOID_CRYSTAL_ORE_KEY = registerKey("end_void_crystal_ore_ore");// 终界墨晶矿替换key

    public static final ResourceKey<ConfiguredFeature<?,?>> END_ORE_KEY = registerKey("end_end_ore");// 终界矿替换key

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context){
        // 替换规则
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);// 替换普通石头标签的方块
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);// 替换深层石头的方块

        RuleTest gravelReplaceables = new BlockMatchTest(Blocks.GRAVEL);// 替换沙砾的方块
        RuleTest sandReplaceables = new BlockMatchTest(Blocks.SAND);// 替换沙子的方块

        RuleTest airReplaceables = new BlockMatchTest(Blocks.AIR);// 替换深层空气的方块

        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);// 替换下届岩的方块
        RuleTest soulSandReplaceables = new BlockMatchTest(Blocks.SOUL_SAND);// 替换灵魂沙的方块
        RuleTest soulSoilReplaceables = new BlockMatchTest(Blocks.SOUL_SOIL);// 替换灵魂土的方块
        RuleTest basaltReplaceables = new BlockMatchTest(Blocks.BASALT);// 替换玄武岩的方块
        RuleTest netherWartBlockReplaceables = new BlockMatchTest(Blocks.NETHER_WART_BLOCK);// 替换下届疣块的方块
        RuleTest warpedCrimsonBlockReplaceables = new BlockMatchTest(Blocks.WARPED_NYLIUM);// 替换诡异菌岩的方块

        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);// 替换末地石的方块

        // 锡 的生成
        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.TIN_ORE.get().defaultBlockState()),// 规则:用锡矿石替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTinOres, 12));// 替换类型为ORE 规则为用锡矿石替换深浅层石头 矿脉中矿石数量最大值为10
        // 铝 的生成
        List<OreConfiguration.TargetBlockState> overworldAluminumOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.ALUMINUM_ORE.get().defaultBlockState()),// 规则:用铝矿石替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_ALUMINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAluminumOres, 12));// 替换类型为ORE 规则为用铝矿石替换深浅层石头 矿脉中矿石数量最大值为10
        // 银 的生成
        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.SILVER_ORE.get().defaultBlockState()),// 规则:用银矿石替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 8));// 替换类型为ORE 规则为用银矿石替换深浅层石头 矿脉中矿石数量最大值为8
        // 红宝石 的生成
        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.RUBY_ORE.get().defaultBlockState()),// 规则:用红宝石矿石替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 8));// 替换类型为ORE 规则为用红宝石矿石替换深浅层石头 矿脉中矿石数量最大值为8

        // 提拉马 的生成
        List<OreConfiguration.TargetBlockState> overworldTilamaOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.TILAMA_ORE.get().defaultBlockState()),// 规则:用提拉马矿石替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_TILAMA_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_TILAMA_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTilamaOres, 10));// 替换类型为ORE 规则为用提拉马矿石替换深浅层石头 矿脉中矿石数量最大值为10

        // 钛矿 的生成
        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.TITANIUM_ORE.get().defaultBlockState(), 8));// 替换类型为ORE 规则为用钛矿替换深浅层石头 矿脉中矿石数量最大值为8
        // 玫红矿 的生成
        List<OreConfiguration.TargetBlockState> overworldRoseOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.ROSE_ORE.get().defaultBlockState()),// 规则:用玫红矿替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_ROSE_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_ROSE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRoseOres, 6));// 替换类型为ORE 规则为用玫红矿替换深浅层石头 矿脉中矿石数量最大值为6
        // 紫罗兰矿 的生成
        List<OreConfiguration.TargetBlockState> overworldVioletOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.VIOLET_ORE.get().defaultBlockState()),// 规则:用紫罗兰矿替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_VIOLET_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_VIOLET_GEMSTONE_KEY, Feature.ORE, new OreConfiguration(overworldVioletOres, 6));// 替换类型为ORE 规则为用紫罗兰矿替换深浅层石头 矿脉中矿石数量最大值为6

        // 亵渎之血 的生成
        register(context, OVERWORLD_PROFANE_BLOOD_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.PROFANE_BLOOD.get().defaultBlockState(), 3));// 替换类型为ORE 规则为用亵渎之血替换深层石头 矿脉中矿石数量最大值为6
        // 英雄残骸 的生成
        register(context, OVERWORLD_HEROIC_REMAINS_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.HEROIC_REMAINS.get().defaultBlockState(), 3));// 替换类型为ORE 规则为用英雄残骸替换深层石头 矿脉中矿石数量最大值为6


        // 量子域 的生成
        List<OreConfiguration.TargetBlockState> overworldQuantumOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.QUANTUM_DOMAIN.get().defaultBlockState()),// 规则:用量子域替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.QUANTUM_DOMAIN.get().defaultBlockState())
        );
        register(context, OVERWORLD_QUANTUM_DOMAIN_KEY, Feature.SCATTERED_ORE, new OreConfiguration(overworldQuantumOres, 2, 0.2f));// 替换类型为SCATTERED_ORE 规则为用量子域替换深浅层石头 矿脉中矿石数量最大值为2
        // 不可见方块 的生成
        List<OreConfiguration.TargetBlockState> overworldInvisibleOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.INVISIBLE_BLOCK.get().defaultBlockState()),// 规则:用不可见方块替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.INVISIBLE_BLOCK.get().defaultBlockState())
        );
        register(context, OVERWORLD_INVISIBLE_BLOCK_KEY, Feature.SCATTERED_ORE, new OreConfiguration(overworldInvisibleOres, 3, 0.5f));// 替换类型为SCATTERED_ORE 规则为用不可见方块替换深浅层石头 矿脉中矿石数量最大值为3 矿石暴露在空气中时的生成概率为1-0.5f

        // 棱彩矿 的生成
        register(context, OVERWORLD_PRISMATIC_COLORFUL_KEY, Feature.SCATTERED_ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.PRISMATIC_COLORFUL_ORE.get().defaultBlockState(), 3));// 替换类型为SCATTERED_ORE 规则为用棱彩矿替换深浅层石头 矿脉中矿石数量最大值为3

        // 元祖矿 的生成
        List<OreConfiguration.TargetBlockState> overworldPrecursorOres = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.PRECURSOR_ORE.get().defaultBlockState()),// 规则:用元祖矿替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_PRECURSOR_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_PRECURSOR_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPrecursorOres, 4));// 替换类型为ORE 规则为用元祖矿替换深浅层石头 矿脉中矿石数量最大值为3

        // 暮云素 的生成
        register(context, OVERWORLD_TWILIGHT_CLOUD_ELEMENT_KEY, Feature.ORE, new OreConfiguration(airReplaceables,
                HCBlock.TWILIGHT_CLOUD_ELEMENT.get().defaultBlockState(), 7));// 替换类型为ORE 规则为用暮云素替换空气 矿脉中矿石数量最大值为7

        // 思绪矿 的生成
        register(context, OVERWORLD_THOUGHTS_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.THOUGHTS_ORE.get().defaultBlockState(), 5));// 替换类型为ORE 规则为用思绪矿替换深层石头 矿脉中矿石数量最大值为5

        // 深海残渣 的生成
        List<OreConfiguration.TargetBlockState> overworldDeepseaResidue = List.of(
                OreConfiguration.target(gravelReplaceables, HCBlock.DEEPSEA_RESIDUE.get().defaultBlockState()),// 规则:用深海残渣替换
                OreConfiguration.target(sandReplaceables, HCBlock.DEEPSEA_RESIDUE.get().defaultBlockState())
        );
        register(context, OVERWORLD_DEEPSEA_RESIDUE_KEY, Feature.ORE, new OreConfiguration(overworldDeepseaResidue, 5));// 替换类型为ORE 规则为用深海残渣替换沙砾沙子 矿脉中矿石数量最大值为5

        // 海神矿 的生成
        List<OreConfiguration.TargetBlockState> overworldPoseidonOre = List.of(
                OreConfiguration.target(gravelReplaceables, HCBlock.POSEIDON_ORE.get().defaultBlockState()),// 规则:用海神矿替换
                OreConfiguration.target(sandReplaceables, HCBlock.POSEIDON_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_POSEIDON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPoseidonOre, 5));// 替换类型为ORE 规则为用海神矿替换沙砾沙子 矿脉中矿石数量最大值为5

        // 灵煤矿 的生成
        List<OreConfiguration.TargetBlockState> overworldSpiritualCoalOre = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.SPIRITUAL_COAL_ORE.get().defaultBlockState()),// 规则:用灵煤矿替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_SPIRITUAL_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSpiritualCoalOre, 14));// 替换类型为ORE 规则为用灵煤矿替换深浅石头 矿脉中矿石数量最大值为14
        // 硝石矿 的生成
        List<OreConfiguration.TargetBlockState> overworldSaltpetreOre = List.of(
                OreConfiguration.target(stoneReplaceables, HCBlock.SALTPETRE_ORE.get().defaultBlockState()),// 规则:用硝石矿替换
                OreConfiguration.target(deepslateReplaceables, HCBlock.DEEPSLATE_SALTPETRE_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_SALTPETRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSaltpetreOre, 10));// 替换类型为ORE 规则为用硝石矿替换深浅石头 矿脉中矿石数量最大值为10


        // 极点矿 的生成
        register(context, OVERWORLD_POLE_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.POLE_ORE.get().defaultBlockState(), 3));// 替换类型为SCATTERED_ORE 规则为用极点矿替换深石头 矿脉中矿石数量最大值为3


        // 主界矿 的生成
        register(context, OVERWORLD_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(deepslateReplaceables,
                HCBlock.OVERWORLD_ORE.get().defaultBlockState(), 1));// 替换类型为SCATTERED_ORE 规则为用主界矿替换深层石头 矿脉中矿石数量最大值为1

        /*=======================================================================================================================*/
        // 赫岩矿 的生成
        register(context, NETHER_HEYAN_ORE_KEY, Feature.ORE, new OreConfiguration(basaltReplaceables,
                HCBlock.HEYAN_ORE.get().defaultBlockState(), 8));// 替换类型为ORE 规则为用赫岩矿替换玄武岩 矿脉中矿石数量最大值为8
        // 黑晶矿 的生成
        List<OreConfiguration.TargetBlockState> netherBlackCrystalsOre = List.of(
                OreConfiguration.target(netherrackReplaceables, HCBlock.BLACK_CRYSTALS_ORE.get().defaultBlockState()),// 规则:用黑晶矿替换
                OreConfiguration.target(warpedCrimsonBlockReplaceables, HCBlock.BLACK_CRYSTALS_ORE.get().defaultBlockState())
        );
        register(context, NETHER_BLACK_CRYSTALS_ORE_KEY, Feature.ORE, new OreConfiguration(netherBlackCrystalsOre, 5));// 替换类型为ORE 规则为用黑晶矿替换诡异菌块下界岩 矿脉中矿石数量最大值为5
        // 红莲块 的生成
        register(context, NETHER_RED_LOTUS_BLOCK_KEY, Feature.ORE, new OreConfiguration(netherWartBlockReplaceables,
                HCBlock.RED_LOTUS_BLOCK.get().defaultBlockState(), 5));// 替换类型为ORE 规则为用红莲块替换下界疣 矿脉中矿石数量最大值为5
        // 冥火矿 的生成
        List<OreConfiguration.TargetBlockState> netherPyrocarbonOreOre = List.of(
                OreConfiguration.target(soulSandReplaceables, HCBlock.PYROCARBON_ORE.get().defaultBlockState()),// 规则:用冥火矿替换
                OreConfiguration.target(soulSoilReplaceables, HCBlock.PYROCARBON_ORE.get().defaultBlockState())
        );
        register(context, NETHER_PYROCARBON_ORE_KEY, Feature.ORE, new OreConfiguration(netherPyrocarbonOreOre, 12));// 替换类型为ORE 规则为用冥火矿替换灵魂沙土 矿脉中矿石数量最大值为12
        // 狱炎矿 的生成
        register(context, NETHER_HELL_S_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                HCBlock.HELL_S_ORE.get().defaultBlockState(), 6));// 替换类型为ORE 规则为用狱炎矿替换下界岩 矿脉中矿石数量最大值为6
        // 瑟银矿 的生成
        register(context, NETHER_SEYIN_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                HCBlock.SEYIN_ORE.get().defaultBlockState(), 8));// 替换类型为ORE 规则为用瑟银矿替换下界岩 矿脉中矿石数量最大值为8

        // 下界极点矿 的生成
        register(context, NETHER_POLE_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(netherrackReplaceables,
                HCBlock.NETHER_POLE_ORE.get().defaultBlockState(), 3));// 替换类型为SCATTERED_ORE 规则为用极点矿替换下界岩 矿脉中矿石数量最大值为3

        // 下界矿 的生成
        register(context, NETHER_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(netherrackReplaceables,
                HCBlock.NETHER_ORE.get().defaultBlockState(), 1));// 替换类型为SCATTERED_ORE 规则为用下界矿替换下界岩 矿脉中矿石数量最大值为1

        /*=======================================================================================================================*/
        // 凝视矿
        register(context, END_GAZING_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.GAZING_ORE.get().defaultBlockState(), 8));// 替换类型为ORE 规则为用凝视矿替换末地石 矿脉中矿石数量最大值为8
        // 星尘矿
        register(context, END_STARDUST_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.STARDUST_ORE.get().defaultBlockState(), 10));// 替换类型为ORE 规则为用星尘矿替换末地石 矿脉中矿石数量最大值为10
        // 龙占矿
        register(context, END_DIVINATION_DRAGON_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.DIVINATION_DRAGON_ORE.get().defaultBlockState(), 6));// 替换类型为ORE 规则为用龙占矿替换末地石 矿脉中矿石数量最大值为6
        // 坍缩嵌块
        register(context, END_COLLAPSING_BLOCK_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.COLLAPSING_BLOCK.get().defaultBlockState(), 4));// 替换类型为ORE 规则为用凝视矿替换末地石 矿脉中矿石数量最大值为4
        // 末影矿
        register(context, END_ENDER_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.ENDER_ORE.get().defaultBlockState(), 8));// 替换类型为ORE 规则为用星尘矿替换末地石 矿脉中矿石数量最大值为8

        // 终界极点矿 的生成
        register(context, END_POLE_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.END_POLE_ORE.get().defaultBlockState(), 3));// 替换类型为SCATTERED_ORE 规则为用极点矿替换末地石 矿脉中矿石数量最大值为3

        // 墨晶矿
        register(context, END_VOID_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.VOID_CRYSTAL_ORE.get().defaultBlockState(), 12));// 替换类型为ORE 规则为用墨晶矿替换末地石 矿脉中矿石数量最大值为12

        // 终界矿
        register(context, END_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(endStoneReplaceables,
                HCBlock.END_ORE.get().defaultBlockState(), 1));// 替换类型为SCATTERED_ORE 规则为用龙占矿替换末地石 矿脉中矿石数量最大值为1




    }

    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?,?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
