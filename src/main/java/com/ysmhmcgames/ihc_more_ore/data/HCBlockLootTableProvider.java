package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class HCBlockLootTableProvider extends BlockLootSubProvider {// 方块掉落表提供者
    protected HCBlockLootTableProvider(HolderLookup.Provider registries) {
        // FeatureFlags.REGISTRY 功能标志注册表    allFlags() 所有标志到这里为止
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }
    @Override
    protected void generate() {

        // 生成正常掉落自身物品
        dropSelf(HCBlock.TIN_BLOCK.get());// 锡矿掉落物表
        dropSelf(HCBlock.RAW_TIN_BLOCK.get());// 粗锡块掉落物表
        dropSelf(HCBlock.RAW_ALUMINUM_BLOCK.get());// 粗铝块掉落物表
        dropSelf(HCBlock.ALUMINUM_BLOCK.get());// 铝块掉落物表
        dropSelf(HCBlock.RAW_SILVER_BLOCK.get());// 粗银块掉落物表
        dropSelf(HCBlock.SILVER_BLOCK.get());// 银块掉落物表
        dropSelf(HCBlock.STEEL_BLOCK.get());// 钢块掉落物表

        dropSelf(HCBlock.TWILIGHT_CLOUD_ELEMENT.get());// 暮云素掉落物表
        dropSelf(HCBlock.TWILIGHT_CLOUD_BLOCK.get());// 暮云块掉落物表
        dropSelf(HCBlock.STORM_BLOCK.get());// 风暴块掉落物表

        dropSelf(HCBlock.QUANTUM_DOMAIN.get());// 量子域掉落物表
        dropSelf(HCBlock.INVISIBLE_BLOCK.get());// 不可见的方块掉落物表

        dropSelf(HCBlock.CHLOROPHYLL_BLOCK.get());// 叶绿素块掉落物表
        dropSelf(HCBlock.DISGUISED_CHLOROPHYLL_ORE.get());// 伪装的叶绿矿掉落物表
        dropSelf(HCBlock.CHLOROPHYLL_INGOT_BLOCK.get());// 叶绿锭块掉落物表

        dropSelf(HCBlock.RAW_TITANIUM_BLOCK.get());// 粗钛块掉落物表
        dropSelf(HCBlock.TITANIUM_BLOCK.get());// 钛块掉落物表

        dropSelf(HCBlock.RUBY_BLOCK.get());// 红宝石块掉落物表

        dropSelf(HCBlock.PRISMATIC_COLORFUL_BLOCK.get());// 棱彩块掉落物表

        dropSelf(HCBlock.HEROIC_REMAINS.get());// "英雄残骸"掉落物表
        dropSelf(HCBlock.HOLY_STEEL_BLOCK.get());// 圣钢块掉落物表

        dropSelf(HCBlock.FLASH_GOLD_BLOCK.get());// 闪金块掉落物表

        dropSelf(HCBlock.BLACK_CRYSTALS_BLOCK.get());// 黑晶块掉落物表

        dropSelf(HCBlock.SEYIN_BLOCK.get());// 瑟银块掉落物表

        dropSelf(HCBlock.RED_LOTUS_BLOCK.get());// 红莲块掉落物表


        dropSelf(HCBlock.DIVINATION_DRAGON_BLOCK.get());// 粗龙占块掉落物表

        dropSelf(HCBlock.SPIRITUAL_COAL_BLOCK.get());// 灵煤块掉落物表
        dropSelf(HCBlock.SALTPETRE_BLOCK.get());// 硝石块掉落物表
        dropSelf(HCBlock.PYROCARBON_BLOCK.get());// 冥火炭块掉落物表
        dropSelf(HCBlock.VOID_CRYSTAL_BLOCK.get());// 虚空墨晶块掉落物表

        dropSelf(HCBlock.DISPLAY_STAND.get());// 置物台掉落物表
        dropSelf(HCBlock.ANALYSIS_ROOM_BLOCK.get());// 解析室掉落物表
        dropSelf(HCBlock.ALLOY_FURNACE_CORE_BLOCK.get());// 合金熔炉核心掉落物表
        dropSelf(HCBlock.ALLOY_FURNACE_FRAMEWORK_BLOCK.get());// 合金熔炉框架掉落物表
        dropSelf(HCBlock.SOUL_ALTAR.get());// 灵魂祭坛掉落物表

        dropSelf(HCBlock.WEAPON_PLATFORM.get());// 武器台掉落物表

        // 生成锡矿方块掉落
        add(HCBlock.TIN_ORE.get(),
                block -> createOreDrop(HCBlock.TIN_ORE.get(), HCOreItem.RAW_TIN.get()));
        add(HCBlock.DEEPSLATE_TIN_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_TIN_ORE.get(), HCOreItem.RAW_TIN.get()));

        // 生成铝矿方块掉落
        add(HCBlock.ALUMINUM_ORE.get(),
                block -> createOreDrop(HCBlock.ALUMINUM_ORE.get(), HCOreItem.RAW_ALUMINUM.get()));
        add(HCBlock.DEEPSLATE_ALUMINUM_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_ALUMINUM_ORE.get(), HCOreItem.RAW_ALUMINUM.get()));

        // 生成银矿方块掉落
        add(HCBlock.SILVER_ORE.get(),
                block -> createOreDrop(HCBlock.SILVER_ORE.get(), HCOreItem.RAW_SILVER.get()));
        add(HCBlock.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_SILVER_ORE.get(), HCOreItem.RAW_SILVER.get()));

        // 生成提拉马矿方块掉落
        add(HCBlock.TILAMA_ORE.get(),
                block -> createOreDrop(HCBlock.TILAMA_ORE.get(), HCOreItem.RAW_TILAMA.get()));
        add(HCBlock.DEEPSLATE_TILAMA_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_TILAMA_ORE.get(), HCOreItem.RAW_TILAMA.get()));

        // 生成钛矿方块掉落
        add(HCBlock.TITANIUM_ORE.get(),
                block -> createOreDrop(HCBlock.TITANIUM_ORE.get(), HCOreItem.RAW_TITANIUM.get()));

        // 生成海神矿方块掉落
        add(HCBlock.POSEIDON_ORE.get(),
                block -> createOreDrop(HCBlock.POSEIDON_ORE.get(), HCOreItem.POSEIDON_FRAGMENT.get()));

        // 生成叶绿矿方块掉落
        add(HCBlock.CHLOROPHYLL_ORE.get(),
                block -> createOreDrop(HCBlock.CHLOROPHYLL_ORE.get(), HCOreItem.CHLOROPLAST.get()));

        // 生成红宝石矿方块掉落
        add(HCBlock.RUBY_ORE.get(),
                block -> createOreDrop(HCBlock.RUBY_ORE.get(), HCOreItem.RUBY.get()));
        add(HCBlock.DEEPSLATE_RUBY_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_RUBY_ORE.get(), HCOreItem.RUBY.get()));

        // 生成玫红矿方块掉落
        add(HCBlock.ROSE_ORE.get(),
                block -> createOreDrop(HCBlock.ROSE_ORE.get(), HCOreItem.BLOSSOMING_ROSE.get()));
        add(HCBlock.DEEPSLATE_ROSE_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_ROSE_ORE.get(), HCOreItem.BLOSSOMING_ROSE.get()));

        // 生成紫罗兰矿方块掉落
        add(HCBlock.VIOLET_ORE.get(),
                block -> createOreDrop(HCBlock.VIOLET_ORE.get(), HCOreItem.VIOLET_GEMSTONE.get()));
        add(HCBlock.DEEPSLATE_VIOLET_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_VIOLET_ORE.get(), HCOreItem.VIOLET_GEMSTONE.get()));

        // 生成棱彩矿方块掉落
        add(HCBlock.PRISMATIC_COLORFUL_ORE.get(),
                block -> createOreDrop(HCBlock.PRISMATIC_COLORFUL_ORE.get(), HCOreItem.PRISMATIC_COLORFUL_FRAGMENT.get()));

        // 生成元祖矿方块掉落
        add(HCBlock.PRECURSOR_ORE.get(),
                block -> createOreDrop(HCBlock.PRECURSOR_ORE.get(), HCOreItem.PRECURSOR_ELEMENT.get()));
        add(HCBlock.DEEPSLATE_PRECURSOR_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_PRECURSOR_ORE.get(), HCOreItem.PRECURSOR_ELEMENT.get()));

        // 生成主界矿方块掉落
        add(HCBlock.OVERWORLD_ORE.get(),
                block -> createOreDrop(HCBlock.OVERWORLD_ORE.get(), HCOreItem.OVERWORLD_CORE.get()));


        // 生成深海残渣方块掉落
        add(HCBlock.DEEPSEA_RESIDUE.get(),
                block -> creatMultipleOreDrops(HCBlock.DEEPSEA_RESIDUE.get(), HCOreItem.TENTACULUM_WITH_NERVES.get(),1,9));

        // 生成思绪矿方块掉落
        add(HCBlock.THOUGHTS_ORE.get(),
                block -> creatMultipleOreDrops(HCBlock.THOUGHTS_ORE.get(), HCOreItem.THOUGHT.get(),0,3));

        // 生成赫岩矿方块掉落
        add(HCBlock.HEYAN_ORE.get(),
                block -> createOreDrop(HCBlock.HEYAN_ORE.get(), HCOreItem.HEYAN.get()));
        // 生成黑晶矿方块掉落
        add(HCBlock.BLACK_CRYSTALS_ORE.get(),
                block -> createOreDrop(HCBlock.BLACK_CRYSTALS_ORE.get(), HCOreItem.BLACK_CRYSTALS.get()));

        // 生成狱炎矿方块掉落
        add(HCBlock.HELL_S_ORE.get(),
                block -> createOreDrop(HCBlock.HELL_S_ORE.get(), HCOreItem.HELL_S_STONE.get()));

        // 生成瑟银矿方块掉落
        add(HCBlock.SEYIN_ORE.get(),
                block -> createOreDrop(HCBlock.SEYIN_ORE.get(), HCOreItem.RAW_SEYIN.get()));

        // 生成叶绿矿方块掉落
        add(HCBlock.CHLOROPHYLL_ORE.get(),
                block -> createOreDrop(HCBlock.CHLOROPHYLL_ORE.get(), HCOreItem.CHLOROPLAST.get()));

        // ==========生成下届矿方块掉落==========
        add(HCBlock.NETHER_ORE.get(),
                block -> createOreDrop(HCBlock.NETHER_ORE.get(), HCOreItem.NETHER_CORE.get()));

        // 生成星尘矿方块掉落
        add(HCBlock.STARDUST_ORE.get(),
                block -> creatMultipleOreDrops(HCBlock.STARDUST_ORE.get(), HCOreItem.STARDUST.get(),2,5));

        // 生成龙占矿方块掉落
        add(HCBlock.DIVINATION_DRAGON_ORE.get(),
                block -> createOreDrop(HCBlock.DIVINATION_DRAGON_ORE.get(), HCOreItem.RAW_DIVINATION_DRAGON.get()));

        // 生成坍缩嵌块方块掉落
        add(HCBlock.COLLAPSING_BLOCK.get(),
                block -> createOreDrop(HCBlock.COLLAPSING_BLOCK.get(), HCOreItem.COLLAPSING_CREAM.get()));

        // 生成末影矿方块掉落
        add(HCBlock.ENDER_ORE.get(),
                block -> createOreDrop(HCBlock.ENDER_ORE.get(), HCOreItem.RAW_ENDER_ORE.get()));
        // 生成凝视矿方块掉落
        add(HCBlock.GAZING_ORE.get(),
                block -> createOreDrop(HCBlock.GAZING_ORE.get(), HCOreItem.GAZING.get()));

        // ====================生成终界矿方块掉落===================
        add(HCBlock.END_ORE.get(),
                block -> createOreDrop(HCBlock.END_ORE.get(), HCOreItem.END_CORE.get()));


        // ====================================多维度生成矿=============================================
        // 生成极点矿方块掉落
        add(HCBlock.POLE_ORE.get(),
                block -> createOreDrop(HCBlock.POLE_ORE.get(), HCOreItem.PURE_WHITE_POLE.get()));
        add(HCBlock.NETHER_POLE_ORE.get(),
                block -> createOreDrop(HCBlock.NETHER_POLE_ORE.get(), HCOreItem.PURE_BLACK_POLE.get()));
        add(HCBlock.END_POLE_ORE.get(),
                block -> createOreDrop(HCBlock.END_POLE_ORE.get(), HCOreItem.FUZZY_POLE.get()));

        // 生成灵煤矿方块掉落
        add(HCBlock.SPIRITUAL_COAL_ORE.get(),
                block -> createOreDrop(HCBlock.SPIRITUAL_COAL_ORE.get(), HCOreItem.SPIRITUAL_COAL.get()));
        add(HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE.get(),
                block -> createOreDrop(HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE.get(), HCOreItem.SPIRITUAL_COAL.get()));
        // 生成硝石矿方块掉落
        add(HCBlock.SALTPETRE_ORE.get(),
                block -> creatMultipleOreDrops(HCBlock.SALTPETRE_ORE.get(), HCOreItem.SALTPETRE.get(),1,4));
        add(HCBlock.DEEPSLATE_SALTPETRE_ORE.get(),
                block -> creatMultipleOreDrops(HCBlock.DEEPSLATE_SALTPETRE_ORE.get(), HCOreItem.SALTPETRE.get(),1,4));
        // 生成冥火矿方块掉落
        add(HCBlock.PYROCARBON_ORE.get(),
                block -> createOreDrop(HCBlock.PYROCARBON_ORE.get(), HCOreItem.PYROCARBON.get()));
        // 生成墨晶矿方块掉落
        add(HCBlock.VOID_CRYSTAL_ORE.get(),
                block -> createOreDrop(HCBlock.VOID_CRYSTAL_ORE.get(), HCOreItem.VOID_CRYSTAL.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // stream().map(Holder::value)::iterator 对获取到的延迟注册器的东西进行一个数据转换 方便BlockLootSubProvider类能够使用它
        // 这样做了之后代表该延迟注册器下每个方块都要有一个掉落物战利品表
        return HCBlock.ORE_BLOCK.getEntries().stream().map(Holder::value)::iterator;// 通过这种方式获取我们所有的方块 -> 用延迟注册器获取已注册物品列表
    }

    protected LootTable.Builder creatMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops){// 铜矿石的掉落方式
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops,maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

}
