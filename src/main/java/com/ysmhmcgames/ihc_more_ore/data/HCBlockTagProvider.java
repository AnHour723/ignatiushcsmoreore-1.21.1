package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.util.HCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HCBlockTagProvider extends BlockTagsProvider {// 方块标签提供者


    public HCBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IgnatiusHCsMoreOre.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // 需要被锄头挖掘
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(HCBlock.RED_LOTUS_BLOCK.get())// 红莲块
        ;

        // 需要被铲子挖掘
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(HCBlock.DEEPSEA_RESIDUE.get())// 深海残渣
                .add(HCBlock.PYROCARBON_ORE.get())// 冥火矿
        ;
        // 需要被斧头挖掘
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(HCBlock.WEAPON_PLATFORM.get())
        ;


        // 需要被镐子挖掘
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(HCBlock.TIN_ORE.get())// 锡矿
                .add(HCBlock.RAW_TIN_BLOCK.get())// 粗锡块
                .add(HCBlock.TIN_BLOCK.get())// 锡块
                .add(HCBlock.DEEPSLATE_TIN_ORE.get())// 深层锡矿
                .add(HCBlock.ALUMINUM_ORE.get())// 铝矿
                .add(HCBlock.DEEPSLATE_ALUMINUM_ORE.get())// 深层铝矿
                .add(HCBlock.RAW_ALUMINUM_BLOCK.get())// 粗铝块
                .add(HCBlock.ALUMINUM_BLOCK.get())// 铝块
                .add(HCBlock.SILVER_ORE.get())// 银矿
                .add(HCBlock.DEEPSLATE_SILVER_ORE.get())// 深层银矿
                .add(HCBlock.RAW_SILVER_BLOCK.get())// 粗银块
                .add(HCBlock.SILVER_BLOCK.get())// 银块
                .add(HCBlock.TILAMA_ORE.get())// 提拉马矿
                .add(HCBlock.DEEPSLATE_TILAMA_ORE.get())// 深层提拉马矿
                .add(HCBlock.STEEL_BLOCK.get())// 钢块
                .add(HCBlock.TWILIGHT_CLOUD_ELEMENT.get())// 暮云素
                .add(HCBlock.TWILIGHT_CLOUD_BLOCK.get())// 暮云块
                .add(HCBlock.STORM_BLOCK.get())// 风暴块
                .add(HCBlock.CHLOROPHYLL_BLOCK.get())// 叶绿素块
                .add(HCBlock.DISGUISED_CHLOROPHYLL_ORE.get())// 伪装的叶绿矿
                .add(HCBlock.CHLOROPHYLL_ORE.get())// 叶绿矿
                .add(HCBlock.CHLOROPHYLL_INGOT_BLOCK.get())// 叶绿锭块
                .add(HCBlock.QUANTUM_DOMAIN.get())// 量子域
                .add(HCBlock.INVISIBLE_BLOCK.get())// 不可见的方块
                .add(HCBlock.TITANIUM_BLOCK.get())// 钛块
                .add(HCBlock.RAW_TITANIUM_BLOCK.get())// 粗钛块
                .add(HCBlock.TITANIUM_ORE.get())// 钛矿
                .add(HCBlock.POSEIDON_ORE.get())// 海神矿
                .add(HCBlock.RUBY_ORE.get())// 红宝石矿
                .add(HCBlock.DEEPSLATE_RUBY_ORE.get())// 深层红宝石矿
                .add(HCBlock.RUBY_BLOCK.get())// 红宝石块
                .add(HCBlock.ROSE_ORE.get())// 玫红矿
                .add(HCBlock.DEEPSLATE_ROSE_ORE.get())// 深层玫红矿
                .add(HCBlock.VIOLET_ORE.get())// 紫罗兰矿
                .add(HCBlock.DEEPSLATE_VIOLET_ORE.get())// 深层紫罗兰矿
                .add(HCBlock.PRISMATIC_COLORFUL_ORE.get())// 棱彩矿
                .add(HCBlock.PRISMATIC_COLORFUL_BLOCK.get())// 棱彩块
                .add(HCBlock.PRECURSOR_ORE.get())// 元祖矿
                .add(HCBlock.DEEPSLATE_PRECURSOR_ORE.get())// 深层元祖矿
                .add(HCBlock.HEROIC_REMAINS.get())// "英雄残骸"
                .add(HCBlock.HOLY_STEEL_BLOCK.get())// 圣钢块
                .add(HCBlock.THOUGHTS_ORE.get())// 思绪矿

                .add(HCBlock.OVERWORLD_ORE.get())// 主界矿

                .add(HCBlock.FLASH_GOLD_BLOCK.get())// 闪金块

                .add(HCBlock.HEYAN_ORE.get())// 赫岩矿
                .add(HCBlock.BLACK_CRYSTALS_ORE.get())// 黑晶矿
                .add(HCBlock.BLACK_CRYSTALS_BLOCK.get())// 黑晶块

                .add(HCBlock.HELL_S_ORE.get())// 狱炎矿

                .add(HCBlock.SEYIN_ORE.get())// 瑟银矿
                .add(HCBlock.SEYIN_BLOCK.get())// 瑟银块

                .add(HCBlock.NETHER_ORE.get())// 下届矿

                .add(HCBlock.GAZING_ORE.get())// 凝视矿

                .add(HCBlock.STARDUST_ORE.get())// 星尘矿

                .add(HCBlock.DIVINATION_DRAGON_ORE.get())// 龙占矿
                .add(HCBlock.DIVINATION_DRAGON_BLOCK.get())// 粗龙占块

                .add(HCBlock.COLLAPSING_BLOCK.get())// 坍缩嵌块

                .add(HCBlock.ENDER_ORE.get())// 末影矿

                .add(HCBlock.END_ORE.get())// 终界矿

                .add(HCBlock.POLE_ORE.get())// 极点矿
                .add(HCBlock.NETHER_POLE_ORE.get())// 下届极点矿
                .add(HCBlock.END_POLE_ORE.get())// 终界极点矿

                .add(HCBlock.SPIRITUAL_COAL_ORE.get())// 灵煤矿
                .add(HCBlock.SALTPETRE_ORE.get())// 硝石矿
                .add(HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE.get())// 深层灵煤矿
                .add(HCBlock.DEEPSLATE_SALTPETRE_ORE.get())// 深层硝石矿
                .add(HCBlock.VOID_CRYSTAL_ORE.get())// 墨晶矿

                .add(HCBlock.DISPLAY_STAND.get())// 置物台
                .add(HCBlock.ANALYSIS_ROOM_BLOCK.get())// 解析室
                .add(HCBlock.ALLOY_FURNACE_CORE_BLOCK.get())// 合金熔炉核心
                .add(HCBlock.ALLOY_FURNACE_FRAMEWORK_BLOCK.get())// 合金熔炉框架
        ;

        tag(BlockTags.NEEDS_STONE_TOOL)// 需要石头等级
                .add(HCBlock.TIN_ORE.get())// 锡矿
                .add(HCBlock.DEEPSLATE_TIN_ORE.get())// 深层锡矿
                .add(HCBlock.ALUMINUM_ORE.get())// 铝矿
                .add(HCBlock.DEEPSLATE_ALUMINUM_ORE.get())// 深层铝矿
                .add(HCBlock.TILAMA_ORE.get())// 提拉马矿
                .add(HCBlock.DEEPSLATE_TILAMA_ORE.get())// 深层提拉马矿
                .add(HCBlock.SILVER_ORE.get())// 银矿
                .add(HCBlock.DEEPSLATE_SILVER_ORE.get())// 深层银矿

                .add(HCBlock.RUBY_ORE.get())// 红宝石矿石
                .add(HCBlock.DEEPSLATE_RUBY_ORE.get())// 深层红宝石矿石

                .add(HCBlock.HEYAN_ORE.get())// 赫岩矿

                .add(HCBlock.GAZING_ORE.get())// 凝视矿

                .add(HCBlock.SPIRITUAL_COAL_ORE.get())// 灵煤矿
                .add(HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE.get())// 深层灵煤矿
                .add(HCBlock.SALTPETRE_ORE.get())// 硝石矿
                .add(HCBlock.DEEPSLATE_SALTPETRE_ORE.get())// 深层硝石矿
                .add(HCBlock.PYROCARBON_ORE.get())// 冥火矿
                .add(HCBlock.VOID_CRYSTAL_ORE.get())// 墨晶矿


                .add(HCBlock.DEEPSEA_RESIDUE.get())// 深海残渣
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)// 需要铁等级
                .add(HCBlock.TWILIGHT_CLOUD_ELEMENT.get())// 暮云素
                .add(HCBlock.DISGUISED_CHLOROPHYLL_ORE.get())// 伪装的叶绿矿
                .add(HCBlock.CHLOROPHYLL_ORE.get())// 叶绿矿
                .add(HCBlock.TITANIUM_ORE.get())// 钛矿
                .add(HCBlock.POSEIDON_ORE.get())// 海神矿
                .add(HCBlock.ROSE_ORE.get())// 玫红矿
                .add(HCBlock.DEEPSLATE_ROSE_ORE.get())// 深层玫红矿
                .add(HCBlock.VIOLET_ORE.get())// 紫罗兰矿
                .add(HCBlock.DEEPSLATE_VIOLET_ORE.get())// 深层紫罗兰矿
                .add(HCBlock.THOUGHTS_ORE.get())// 思绪矿

                .add(HCBlock.BLACK_CRYSTALS_ORE.get())// 黑晶矿

                .add(HCBlock.HELL_S_ORE.get())// 狱炎矿

                .add(HCBlock.SEYIN_ORE.get())// 瑟银矿

                .add(HCBlock.RED_LOTUS_BLOCK.get())// 红莲块

                .add(HCBlock.STARDUST_ORE.get())// 星尘矿

                .add(HCBlock.ENDER_ORE.get())// 末影矿
        ;


        // 添加需要钻石挖掘等级才能挖的东西  --  标签
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(HCBlock.INVISIBLE_BLOCK.get())// 不可见的方块
                .add(HCBlock.PRECURSOR_ORE.get())// 元祖矿
                .add(HCBlock.DEEPSLATE_PRECURSOR_ORE.get())// 深层元祖矿
                .add(HCBlock.HEROIC_REMAINS.get())// "英雄残骸"


                .add(HCBlock.DIVINATION_DRAGON_ORE.get())// 龙占矿


                .add(HCBlock.QUANTUM_DOMAIN.get())// 1.设置该方块(量子域)为钻石以下不能挖掘
                .add(HCBlock.PRISMATIC_COLORFUL_ORE.get())// 棱彩矿
                .add(HCBlock.POLE_ORE.get())// 极点矿
                .add(HCBlock.NETHER_POLE_ORE.get())// 下届极点矿
                .add(HCBlock.END_POLE_ORE.get())// 终界极点矿

                .add(HCBlock.COLLAPSING_BLOCK.get())// 坍缩嵌块

                .add(HCBlock.OVERWORLD_ORE.get())// 主界矿
                .add(HCBlock.NETHER_ORE.get())// 下界矿
                .add(HCBlock.END_ORE.get())// 终界矿
                ;
        // 添加钻石挖掘等级不能挖的东西  --  标签
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)

                .add(HCBlock.QUANTUM_DOMAIN.get())// 2.杜绝完钻石以下的挖掘等级后，在禁用钻石等级
                .add(HCBlock.PRISMATIC_COLORFUL_ORE.get())// 棱彩矿
                .add(HCBlock.POLE_ORE.get())// 极点矿
                .add(HCBlock.NETHER_POLE_ORE.get())// 下届极点矿
                .add(HCBlock.END_POLE_ORE.get())// 终界极点矿

                .add(HCBlock.COLLAPSING_BLOCK.get())// 坍缩嵌块

                .add(HCBlock.OVERWORLD_ORE.get())// 主界矿
                .add(HCBlock.NETHER_ORE.get())// 下界矿
                .add(HCBlock.END_ORE.get())// 终界矿

                ;

        // 添加需要下届合金挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(HCBlock.QUANTUM_DOMAIN.get())// 3.设置该方块(量子域)为下届合金等级挖掘
                .add(HCBlock.PRISMATIC_COLORFUL_ORE.get())// 棱彩矿
                .add(HCBlock.POLE_ORE.get())// 极点矿
                .add(HCBlock.NETHER_POLE_ORE.get())// 下届极点矿
                .add(HCBlock.END_POLE_ORE.get())// 终界极点矿

                ;
        // 添加 下届合金(5级) 挖掘等级不能挖的东西  --  标签
        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(HCTags.Blocks.NEEDS_NETHERITE_TOOL)// 4.因为继承了钻石不能挖掘的物品，所以移除需要下届合金能挖掘的物品出禁用表

                .add(HCBlock.OVERWORLD_ORE.get())// 主界矿 (需要等级大于下届合金等级，但是上文获取钻等级后则移除了继承钻石等级的矿石)
                .add(HCBlock.COLLAPSING_BLOCK.get())// 坍缩嵌块
                .add(HCBlock.NETHER_ORE.get())// 下界矿
                .add(HCBlock.END_ORE.get())// 终界矿
        ;

        // 添加需要 量子(6级) 挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_QUANTUM_TOOL)
                .add(HCBlock.OVERWORLD_ORE.get())// 主界矿
                .add(HCBlock.COLLAPSING_BLOCK.get())// 坍缩嵌块
                .addTag(HCTags.Blocks.NEEDS_NETHERITE_TOOL)
        ;
        // 添加 量子(6级) 挖掘等级不能挖的东西  --  标签
        tag(HCTags.Blocks.INCORRECT_FOR_QUANTUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(HCTags.Blocks.NEEDS_QUANTUM_TOOL)

                .add(HCBlock.NETHER_ORE.get())// 下界矿
                .add(HCBlock.END_ORE.get())// 终界矿
        ;

        // 添加需要 主界(7级) 挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_OVERWORLD_TOOL)
                .add(HCBlock.NETHER_ORE.get())// 下界矿
                .addTag(HCTags.Blocks.NEEDS_QUANTUM_TOOL)
        ;
        // 添加 主界(7级) 挖掘等级不能挖的东西  --  标签
        tag(HCTags.Blocks.INCORRECT_FOR_OVERWORLD_TOOL)
                .addTag(HCTags.Blocks.INCORRECT_FOR_QUANTUM_TOOL)
                .remove(HCTags.Blocks.NEEDS_OVERWORLD_TOOL)

                .add(HCBlock.END_ORE.get())// 终界矿
        ;

        // 添加需要 下界(8级) 挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_NETHER_TOOL)
                .add(HCBlock.END_ORE.get())// 终界矿
                .addTag(HCTags.Blocks.NEEDS_OVERWORLD_TOOL)
        ;
        // 添加 下界(8级) 挖掘等级不能挖的东西  --  标签
        tag(HCTags.Blocks.INCORRECT_FOR_NETHER_TOOL)
                .addTag(HCTags.Blocks.INCORRECT_FOR_OVERWORLD_TOOL)
                .remove(HCTags.Blocks.NEEDS_NETHER_TOOL);

        // 添加需要 终界(9级) 挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_END_TOOL)
                .addTag(HCTags.Blocks.NEEDS_NETHER_TOOL)
        ;
        // 添加 终界(9级) 挖掘等级不能挖的东西  --  标签
        tag(HCTags.Blocks.INCORRECT_FOR_END_TOOL)
                .addTag(HCTags.Blocks.INCORRECT_FOR_NETHER_TOOL)
                .remove(HCTags.Blocks.NEEDS_END_TOOL);

        // 添加需要 终极(10级) 挖掘等级才能挖的东西  --  标签
        tag(HCTags.Blocks.NEEDS_ULTIMATE_TOOL)
                .addTag(HCTags.Blocks.NEEDS_END_TOOL)
        ;
        // 添加 终极(10级) 挖掘等级不能挖的东西  --  标签
        tag(HCTags.Blocks.INCORRECT_FOR_ULTIMATE_TOOL)
                .addTag(HCTags.Blocks.INCORRECT_FOR_END_TOOL)
                .remove(HCTags.Blocks.NEEDS_ULTIMATE_TOOL);
    }
}
