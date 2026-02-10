package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class HCBlockStateProvider extends BlockStateProvider {// 方块状态提供者

    public HCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IgnatiusHCsMoreOre.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(HCBlock.TIN_ORE);// 锡矿 模型
        blockWithItem(HCBlock.RAW_TIN_BLOCK);// 粗锡块 模型
        blockWithItem(HCBlock.TIN_BLOCK);// 锡块 模型
        blockWithItem(HCBlock.DEEPSLATE_TIN_ORE);// 深层锡矿 模型

        blockWithItem(HCBlock.ALUMINUM_ORE);// 铝矿 模型
        blockWithItem(HCBlock.DEEPSLATE_ALUMINUM_ORE);// 深层铝矿 模型
        blockWithItem(HCBlock.RAW_ALUMINUM_BLOCK);// 粗铝块 模型
        blockWithItem(HCBlock.ALUMINUM_BLOCK);// 铝块 模型

        blockWithItem(HCBlock.SILVER_ORE);// 银矿 模型
        blockWithItem(HCBlock.DEEPSLATE_SILVER_ORE);// 深层银矿 模型
        blockWithItem(HCBlock.RAW_SILVER_BLOCK);// 粗银块 模型
        blockWithItem(HCBlock.SILVER_BLOCK);// 银块 模型

        blockWithItem(HCBlock.STEEL_BLOCK);// 钢块 模型

        blockWithItem(HCBlock.TILAMA_ORE);// 提拉马矿 模型
        blockWithItem(HCBlock.DEEPSLATE_TILAMA_ORE);// 深层提拉马矿 模型

        blockWithItem(HCBlock.TWILIGHT_CLOUD_ELEMENT);// 暮云素 模型
        blockWithItem(HCBlock.TWILIGHT_CLOUD_BLOCK);// 暮云块 模型
        blockWithItem(HCBlock.STORM_BLOCK);// 风暴块 模型

        blockWithItem(HCBlock.CHLOROPHYLL_BLOCK);// 叶绿素块 模型
        blockWithItem(HCBlock.DISGUISED_CHLOROPHYLL_ORE);// 伪装的叶绿矿 模型
        blockWithItem(HCBlock.CHLOROPHYLL_ORE);// 叶绿矿 模型
        blockWithItem(HCBlock.CHLOROPHYLL_INGOT_BLOCK);// 叶绿锭块 模型

        blockWithItem(HCBlock.QUANTUM_DOMAIN);// 量子域 模型
        blockWithItem(HCBlock.INVISIBLE_BLOCK);// 不可见的方块 模型

        blockWithItem(HCBlock.TITANIUM_ORE);// 钛矿 模型
        blockWithItem(HCBlock.RAW_TITANIUM_BLOCK);// 粗钛块 模型
        blockWithItem(HCBlock.TITANIUM_BLOCK);// 钛块 模型

        blockWithItem(HCBlock.POSEIDON_ORE);// 海神矿 模型

        blockWithItem(HCBlock.RUBY_ORE);// 红宝石矿 模型
        blockWithItem(HCBlock.DEEPSLATE_RUBY_ORE);// 深层红宝石矿 模型
        blockWithItem(HCBlock.RUBY_BLOCK);// 红宝石块 模型

        blockWithItem(HCBlock.ROSE_ORE);// 玫红矿 模型
        blockWithItem(HCBlock.DEEPSLATE_ROSE_ORE);// 深层玫红矿 模型

        blockWithItem(HCBlock.VIOLET_ORE);// 紫罗兰矿 模型
        blockWithItem(HCBlock.DEEPSLATE_VIOLET_ORE);// 深层紫罗兰矿 模型

        blockWithItem(HCBlock.PRISMATIC_COLORFUL_ORE);// 棱彩矿 模型
        blockWithItem(HCBlock.PRISMATIC_COLORFUL_BLOCK);// 棱彩块 模型

        blockWithItem(HCBlock.PRECURSOR_ORE);// 元祖矿 模型
        blockWithItem(HCBlock.DEEPSLATE_PRECURSOR_ORE);// 深层元祖矿 模型

        blockWithItem(HCBlock.PROFANE_BLOOD);// 亵渎之血 模型

        blockWithItem(HCBlock.HEROIC_REMAINS);// "英雄残骸" 模型
        blockWithItem(HCBlock.HOLY_STEEL_BLOCK);// 圣钢块 模型

        blockWithItem(HCBlock.THOUGHTS_ORE);// 思绪矿 模型

        blockWithItem(HCBlock.DEEPSEA_RESIDUE);// 深海残渣 模型

        blockWithItem(HCBlock.OVERWORLD_ORE);//===================主界矿 模型===================

        blockWithItem(HCBlock.FLASH_GOLD_BLOCK);// 闪金块 模型

        blockWithItem(HCBlock.HEYAN_ORE);// 赫岩矿 模型
        blockWithItem(HCBlock.BLACK_CRYSTALS_ORE);// 黑晶矿 模型
        blockWithItem(HCBlock.BLACK_CRYSTALS_BLOCK);// 黑晶块 模型

        blockWithItem(HCBlock.HELL_S_ORE);// 狱炎矿 模型

        blockWithItem(HCBlock.SEYIN_ORE);// 瑟银矿 模型
        blockWithItem(HCBlock.SEYIN_BLOCK);// 瑟银块 模型

        blockWithItem(HCBlock.RED_LOTUS_BLOCK);// 红莲块 模型

        blockWithItem(HCBlock.NETHER_ORE);//===================下届矿 模型===================

        blockWithItem(HCBlock.GAZING_ORE);// 凝视矿 模型

        blockWithItem(HCBlock.STARDUST_ORE);// 星尘矿 模型

        blockWithItem(HCBlock.DIVINATION_DRAGON_ORE);// 龙占矿 模型
        blockWithItem(HCBlock.DIVINATION_DRAGON_BLOCK);// 粗龙占块 模型

        blockWithItem(HCBlock.COLLAPSING_BLOCK);// 坍缩嵌块 模型

        blockWithItem(HCBlock.ENDER_ORE);// 末影矿 模型
        blockWithItem(HCBlock.END_ORE);//===================终界矿 模型=====================

        // ====================================多维度生成矿=============================================
        blockWithItem(HCBlock.POLE_ORE);// 极点矿 模型
        blockWithItem(HCBlock.NETHER_POLE_ORE);// 下届极点矿 模型
        blockWithItem(HCBlock.END_POLE_ORE);// 终界极点矿 模型

        blockWithItem(HCBlock.SPIRITUAL_COAL_ORE);// 灵煤矿 模型
        blockWithItem(HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE);// 深层灵煤矿 模型
        blockWithItem(HCBlock.SALTPETRE_ORE);// 硝石矿 模型
        blockWithItem(HCBlock.DEEPSLATE_SALTPETRE_ORE);// 深层硝石矿 模型
        blockWithItem(HCBlock.PYROCARBON_ORE);// 冥火矿 模型
        blockWithItem(HCBlock.VOID_CRYSTAL_ORE);// 墨晶矿 模型

        blockWithItem(HCBlock.SPIRITUAL_COAL_BLOCK);// 灵煤块 模型
        blockWithItem(HCBlock.SALTPETRE_BLOCK);// 硝石块 模型
        blockWithItem(HCBlock.PYROCARBON_BLOCK);// 冥火碳块 模型
        blockWithItem(HCBlock.VOID_CRYSTAL_BLOCK);// 虚空墨晶块 模型



        blockWithItem(HCBlock.ALLOY_FURNACE_FRAMEWORK_BLOCK);// 合金熔炉框架 模型

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        String blockName = deferredBlock.getId().getPath();
        simpleBlockWithItem(deferredBlock.get(),models().cubeAll(blockName,modLoc("block/ore/"+blockName)));
    }

}
