package com.ysmhmcgames.ihc_more_ore.worldgen;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class HCBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("add_tin_ore");// 锡
    public static final ResourceKey<BiomeModifier> ADD_ALUMINUM_ORE = registerKey("add_aluminum_ore");// 铝
    public static final ResourceKey<BiomeModifier> ADD_SILVER_ORE = registerKey("add_silver_ore");// 银

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("add_ruby_ore");// 红宝石
    public static final ResourceKey<BiomeModifier> ADD_TILAMA_ORE = registerKey("add_tilama_ore");// 提拉马

    public static final ResourceKey<BiomeModifier> ADD_TWILIGHT_CLOUD_ELEMENT = registerKey("add_twilight_cloud_element");// 暮云素

    public static final ResourceKey<BiomeModifier> ADD_TITANIUM_ORE = registerKey("add_titanium_ore");// 钛
    public static final ResourceKey<BiomeModifier> ADD_ROSE_ORE = registerKey("add_rose_ore");// 玫瑰宝石
    public static final ResourceKey<BiomeModifier> ADD_VIOLET_ORE = registerKey("add_violet_ore");// 紫罗兰
    public static final ResourceKey<BiomeModifier> ADD_PRECURSOR_ORE = registerKey("add_precursor_ore");// 元祖

    public static final ResourceKey<BiomeModifier> ADD_QUANTUM_DOMAIN = registerKey("add_quantum_domain");// 量子域
    public static final ResourceKey<BiomeModifier> ADD_INVISIBLE_BLOCK = registerKey("add_invisible_block");// 不可见的方块

    public static final ResourceKey<BiomeModifier> ADD_PRISMATIC_COLORFUL_ORE = registerKey("add_prismatic_colorful_ore");// 棱彩

    public static final ResourceKey<BiomeModifier> ADD_THOUGHTS_ORE = registerKey("add_thoughts_ore");// 思绪

    public static final ResourceKey<BiomeModifier> ADD_DEEPSEA_RESIDUE = registerKey("add_deepsea_residue");// 深海残渣
    public static final ResourceKey<BiomeModifier> ADD_POSEIDON_ORE = registerKey("add_poseidon_ore");// 海神

    public static final ResourceKey<BiomeModifier> ADD_PROFANE_BLOOD = registerKey("add_profane_blood");// 亵渎之血
    public static final ResourceKey<BiomeModifier> ADD_HEROIC_REMAINS = registerKey("add_heroic_remains");// 英雄残骸

    public static final ResourceKey<BiomeModifier> ADD_SPIRITUAL_COAL_ORE = registerKey("add_spiritual_coal_ore");// 灵煤
    public static final ResourceKey<BiomeModifier> ADD_SALTPETRE_ORE = registerKey("add_saltpetre_ore");// 硝石

    public static final ResourceKey<BiomeModifier> ADD_POLE_ORE = registerKey("add_pole_ore");// 极点

    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_ORE = registerKey("add_overworld_ore");// 主界矿
    /*==============================================================*/
    public static final ResourceKey<BiomeModifier> ADD_HEYAN_ORE = registerKey("add_heyan_ore");// 赫岩
    public static final ResourceKey<BiomeModifier> ADD_BLACK_CRYSTALS_ORE = registerKey("add_black_crystals_ore");// 黑晶
    public static final ResourceKey<BiomeModifier> ADD_RED_LOTUS_BLOCK = registerKey("add_red_lotus_block");// 红莲
    public static final ResourceKey<BiomeModifier> ADD_PYROCARBON_ORE = registerKey("add_pyrocarbon_ore");// 冥火
    public static final ResourceKey<BiomeModifier> ADD_HELL_S_ORE = registerKey("add_hell_s_ore");// 狱炎
    public static final ResourceKey<BiomeModifier> ADD_SEYIN_ORE = registerKey("add_seyin_ore");// 瑟银

    public static final ResourceKey<BiomeModifier> ADD_NETHER_POLE_ORE = registerKey("add_nether_pole_ore");// 下界极点矿

    public static final ResourceKey<BiomeModifier> ADD_NETHER_ORE = registerKey("add_nether_ore");// 下界矿
    /*==============================================================*/
    public static final ResourceKey<BiomeModifier> ADD_GAZING_ORE = registerKey("add_gazing_ore");// 凝视矿
    public static final ResourceKey<BiomeModifier> ADD_STARDUST_ORE = registerKey("add_stardust_ore");// 星尘矿
    public static final ResourceKey<BiomeModifier> ADD_DIVINATION_DRAGON_ORE = registerKey("add_divination_dragon_ore");// 龙占矿
    public static final ResourceKey<BiomeModifier> ADD_COLLAPSING_BLOCK = registerKey("add_collapsing_block");// 坍缩嵌块
    public static final ResourceKey<BiomeModifier> ADD_ENDER_ORE = registerKey("add_ender_ore");// 末影矿

    public static final ResourceKey<BiomeModifier> ADD_END_POLE_ORE = registerKey("add_end_pole_ore");// 终界极点矿

    public static final ResourceKey<BiomeModifier> ADD_VOID_CRYSTAL_ORE = registerKey("add_void_crystal_ore");// 墨晶矿

    public static final ResourceKey<BiomeModifier> ADD_END_ORE = registerKey("add_end_ore");// 终界矿




    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        // 主世界生成
        // 全群系 生成 锡
        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 铝
        context.register(ADD_ALUMINUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.ALUMINUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 银
        context.register(ADD_SILVER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 红宝石
        context.register(ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 提拉马
        context.register(ADD_TILAMA_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.TILAMA_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 暮云素
        context.register(ADD_TWILIGHT_CLOUD_ELEMENT, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.TWILIGHT_CLOUD_ELEMENT_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 钛
        context.register(ADD_TITANIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 玫瑰宝石
        context.register(ADD_ROSE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.ROSE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 紫罗兰
        context.register(ADD_VIOLET_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.VIOLET_GEMSTONE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 元祖
        context.register(ADD_PRECURSOR_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.PRECURSOR_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 量子域
        context.register(ADD_QUANTUM_DOMAIN, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.QUANTUM_DOMAIN_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 不可见的方块
        context.register(ADD_INVISIBLE_BLOCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.INVISIBLE_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 棱彩
        context.register(ADD_PRISMATIC_COLORFUL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.PRISMATIC_COLORFUL_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 思绪
        context.register(ADD_THOUGHTS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.THOUGHTS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全海洋群系 生成 深海残渣
        context.register(ADD_DEEPSEA_RESIDUE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),// 生成在全海洋群系
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.DEEPSEA_RESIDUE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全海洋群系 生成 海神
        context.register(ADD_POSEIDON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),// 生成在全海洋群系
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.POSEIDON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 亵渎之血
        context.register(ADD_PROFANE_BLOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.PROFANE_BLOOD_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 英雄残骸
        context.register(ADD_HEROIC_REMAINS, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.HEROIC_REMAINS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 灵煤矿
        context.register(ADD_SPIRITUAL_COAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.SPIRITUAL_COAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 硝石矿
        context.register(ADD_SALTPETRE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.SALTPETRE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 极点矿
        context.register(ADD_POLE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.POLE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 主界矿
        context.register(ADD_OVERWORLD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),// 生成在主世界
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.OVERWORLD_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        /*=======================================================================================================================*/
        // 玄武岩三角洲群系 生成 赫岩矿
        context.register(ADD_HEYAN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BASALT_DELTAS)),// 生成在玄武岩三角洲
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_HEYAN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 诡异森林群系 生成 黑晶矿
        context.register(ADD_BLACK_CRYSTALS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.WARPED_FOREST)),// 生成在诡异森林
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_BLACK_CRYSTALS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 绯红森林群系 生成 红莲块
        context.register(ADD_RED_LOTUS_BLOCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST)),// 生成在绯红森林
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_RED_LOTUS_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 灵魂沙峡谷群系 生成 冥火矿
        context.register(ADD_PYROCARBON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),// 生成在灵魂沙峡谷
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_PYROCARBON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 狱炎矿
        context.register(ADD_HELL_S_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),// 生成在地狱
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_HELL_S_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 瑟银矿
        context.register(ADD_SEYIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),// 生成在地狱
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_SEYIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 下界极点矿
        context.register(ADD_NETHER_POLE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),// 生成在地狱
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_POLE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 下界矿
        context.register(ADD_NETHER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),// 生成在地狱
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.NETHER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        /*=======================================================================================================================*/
        // 全群系 生成 凝视矿
        context.register(ADD_GAZING_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_GAZING_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 星尘矿
        context.register(ADD_STARDUST_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_STARDUST_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 龙占矿
        context.register(ADD_DIVINATION_DRAGON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_DIVINATION_DRAGON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 坍缩嵌块
        context.register(ADD_COLLAPSING_BLOCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_COLLAPSING_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 末影矿
        context.register(ADD_ENDER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_ENDER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 全群系 生成 终界极点矿
        context.register(ADD_END_POLE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_POLE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        // 全群系 生成 墨晶矿
        context.register(ADD_VOID_CRYSTAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_VOID_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        // 全群系 生成 终界矿
        context.register(ADD_END_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),// 生成在末地
                HolderSet.direct(placedFeatures.getOrThrow(HCPlacedFeatures.END_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }


    public static ResourceKey<BiomeModifier> registerKey(String name){
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name));
    }


}
