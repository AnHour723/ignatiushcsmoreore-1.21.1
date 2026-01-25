package com.ysmhmcgames.ihc_more_ore.blocks;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;

import com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block.*;
import com.ysmhmcgames.ihc_more_ore.blocks.ore.DisguisedChlorophyllOre;
import com.ysmhmcgames.ihc_more_ore.blocks.ore.ProfaneBloodBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.ore.TwilightCloudElementBlock;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCBlock {
    // 声明总注册实例
    public static final DeferredRegister.Blocks ORE_BLOCK = DeferredRegister.createBlocks(IgnatiusHCsMoreOre.MODID);

    // 锡矿
    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 粗锡块
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 锡块
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层锡矿
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 铝矿
    public static final DeferredBlock<Block> ALUMINUM_ORE = registerBlock("aluminum_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层铝矿
    public static final DeferredBlock<Block> DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 粗铝块
    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = registerBlock("raw_aluminum_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 铝块
    public static final DeferredBlock<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 银矿
    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层银矿
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 粗银块
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 银块
    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 钢块
    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 提拉马矿
    public static final DeferredBlock<Block> TILAMA_ORE = registerBlock("tilama_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层提拉马矿
    public static final DeferredBlock<Block> DEEPSLATE_TILAMA_ORE = registerBlock("deepslate_tilama_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));


    // 暮云素
    public static final DeferredBlock<Block> TWILIGHT_CLOUD_ELEMENT= registerBlock("twilight_cloud_element",
            ()->new TwilightCloudElementBlock(Block.Properties.of().sound(SoundType.WOOD).noOcclusion().strength(5.0f).requiresCorrectToolForDrops()));
    // 暮云块
    public static final DeferredBlock<Block> TWILIGHT_CLOUD_BLOCK = registerBlock("twilight_cloud_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion().strength(5.0f)));
    // 风暴块
    public static final DeferredBlock<Block> STORM_BLOCK = registerBlock("storm_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(5.0f)));

    // 叶绿素块
    public static final DeferredBlock<Block> CHLOROPHYLL_BLOCK = registerBlock("chlorophyll_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 伪装的叶绿矿
    public static final DeferredBlock<Block> DISGUISED_CHLOROPHYLL_ORE = registerBlock("disguised_chlorophyll_ore",
            ()->new DisguisedChlorophyllOre(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 叶绿矿
    public static final DeferredBlock<Block> CHLOROPHYLL_ORE = registerBlock("chlorophyll_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 叶绿锭块
    public static final DeferredBlock<Block> CHLOROPHYLL_INGOT_BLOCK = registerBlock("chlorophyll_ingot_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 量子域
    public static final DeferredBlock<Block> QUANTUM_DOMAIN = registerBlock("quantum_domain",
            ()->new Block(Block.Properties.of().sound(SoundType.GLASS).noOcclusion().strength(10.0f).requiresCorrectToolForDrops()));
    // 不可见的方块
    public static final DeferredBlock<Block> INVISIBLE_BLOCK = registerBlock("invisible_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).noOcclusion() .requiresCorrectToolForDrops()));

    // 钛矿
    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 粗钛块
    public static final DeferredBlock<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 钛块
    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 海神矿
    public static final DeferredBlock<Block> POSEIDON_ORE = registerBlock("poseidon_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 红宝石矿
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层红宝石矿
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 红宝石块
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 玫红矿
    public static final DeferredBlock<Block> ROSE_ORE = registerBlock("rose_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层玫红矿
    public static final DeferredBlock<Block> DEEPSLATE_ROSE_ORE = registerBlock("deepslate_rose_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 紫罗兰矿
    public static final DeferredBlock<Block> VIOLET_ORE = registerBlock("violet_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 深层紫罗兰矿
    public static final DeferredBlock<Block> DEEPSLATE_VIOLET_ORE = registerBlock("deepslate_violet_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 棱彩矿
    public static final DeferredBlock<Block> PRISMATIC_COLORFUL_ORE = registerBlock("prismatic_colorful_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 棱彩块
    public static final DeferredBlock<Block> PRISMATIC_COLORFUL_BLOCK = registerBlock("prismatic_colorful_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));

    // 元祖矿
    public static final DeferredBlock<Block> PRECURSOR_ORE = registerBlock("precursor_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(6.0f).requiresCorrectToolForDrops()));
    // 深层元祖矿
    public static final DeferredBlock<Block> DEEPSLATE_PRECURSOR_ORE = registerBlock("deepslate_precursor_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(8.0f).requiresCorrectToolForDrops()));

    // 亵渎之血
    public static final DeferredBlock<Block> PROFANE_BLOOD = registerBlock("profane_blood",
            ()->new ProfaneBloodBlock(Block.Properties.of().sound(SoundType.SLIME_BLOCK).strength(10.0f).noLootTable()));

    // "英雄残骸"
    public static final DeferredBlock<Block> HEROIC_REMAINS = registerBlock("heroic_remains",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 圣钢块
    public static final DeferredBlock<Block> HOLY_STEEL_BLOCK = registerBlock("holy_steel_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));

    // 深海残渣
    public static final DeferredBlock<Block> DEEPSEA_RESIDUE = registerBlock("deepsea_residue",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 思绪矿
    public static final DeferredBlock<Block> THOUGHTS_ORE = registerBlock("thoughts_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // ============================主界矿==========================================
    public static final DeferredBlock<Block> OVERWORLD_ORE = registerBlock("overworld_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(20.0f).requiresCorrectToolForDrops()));

    // 闪金块
    public static final DeferredBlock<Block> FLASH_GOLD_BLOCK = registerBlock("flash_gold_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 赫岩矿
    public static final DeferredBlock<Block> HEYAN_ORE = registerBlock("heyan_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 黑晶矿
    public static final DeferredBlock<Block> BLACK_CRYSTALS_ORE = registerBlock("black_crystals_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 黑晶块
    public static final DeferredBlock<Block> BLACK_CRYSTALS_BLOCK = registerBlock("black_crystals_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 狱炎矿
    public static final DeferredBlock<Block> HELL_S_ORE = registerBlock("hell_s_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));

    // 瑟银矿
    public static final DeferredBlock<Block> SEYIN_ORE = registerBlock("seyin_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    // 瑟银块
    public static final DeferredBlock<Block> SEYIN_BLOCK = registerBlock("seyin_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(3.0f).requiresCorrectToolForDrops()));

    // 红莲块
    public static final DeferredBlock<Block> RED_LOTUS_BLOCK = registerBlock("red_lotus_block",
            ()->new Block(Block.Properties.of().sound(SoundType.NETHERITE_BLOCK).strength(5.0f).requiresCorrectToolForDrops()));

    //=========================================下届矿=========================================
    public static final DeferredBlock<Block> NETHER_ORE = registerBlock("nether_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(20.0f).requiresCorrectToolForDrops()));

    // 凝视矿
    public static final DeferredBlock<Block> GAZING_ORE = registerBlock("gazing_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));

    // 星尘矿
    public static final DeferredBlock<Block> STARDUST_ORE = registerBlock("stardust_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(9.0f).requiresCorrectToolForDrops()));

    // 龙占矿
    public static final DeferredBlock<Block> DIVINATION_DRAGON_ORE = registerBlock("divination_dragon_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(9.0f).requiresCorrectToolForDrops()));
    // 粗龙占块
    public static final DeferredBlock<Block> DIVINATION_DRAGON_BLOCK = registerBlock("divination_dragon_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));

    // 坍缩嵌块
    public static final DeferredBlock<Block> COLLAPSING_BLOCK = registerBlock("collapsing_block",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(12.0f).requiresCorrectToolForDrops()));

    // 末影矿
    public static final DeferredBlock<Block> ENDER_ORE = registerBlock("ender_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 终界矿
    public static final DeferredBlock<Block> END_ORE = registerBlock("end_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(20.0f).requiresCorrectToolForDrops()));




    // ====================================多维度生成矿=============================================
    // 极点矿
    public static final DeferredBlock<Block> POLE_ORE = registerBlock("pole_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 下界极点矿
    public static final DeferredBlock<Block> NETHER_POLE_ORE = registerBlock("nether_pole_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 终界极点矿
    public static final DeferredBlock<Block> END_POLE_ORE = registerBlock("end_pole_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(9.0f).requiresCorrectToolForDrops()));

    // 灵煤矿
    public static final DeferredBlock<Block> SPIRITUAL_COAL_ORE = registerBlock("spiritual_coal_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 深层灵煤矿
    public static final DeferredBlock<Block> DEEPSLATE_SPIRITUAL_COAL_ORE = registerBlock("deepslate_spiritual_coal_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(7.0f).requiresCorrectToolForDrops()));
    // 硝石矿
    public static final DeferredBlock<Block> SALTPETRE_ORE = registerBlock("saltpetre_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 深层硝石矿
    public static final DeferredBlock<Block> DEEPSLATE_SALTPETRE_ORE = registerBlock("deepslate_saltpetre_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(5.0f).requiresCorrectToolForDrops()));
    // 冥火矿
    public static final DeferredBlock<Block> PYROCARBON_ORE = registerBlock("pyrocarbon_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.SOUL_SAND).strength(9.0f).requiresCorrectToolForDrops()));
    // 墨晶矿
    public static final DeferredBlock<Block> VOID_CRYSTAL_ORE = registerBlock("void_crystal_ore",
            ()->new Block(Block.Properties.of().sound(SoundType.STONE).strength(9.0f).requiresCorrectToolForDrops()));


    // 置物台
    public static final DeferredBlock<Block> DISPLAY_STAND = registerBlock("display_stand",
            ()->new DisplayStand(BlockBehaviour.Properties.of().strength(3.0f).noOcclusion().requiresCorrectToolForDrops()));


    // 解析室
    public static final DeferredBlock<Block> ANALYSIS_ROOM_BLOCK = registerBlock("analysis_room_block",
            ()->new AnalysisRoomBlock(BlockBehaviour.Properties.of().strength(3.0f).noOcclusion().requiresCorrectToolForDrops()));

    // 合金熔炉核心
    public static final DeferredBlock<Block> ALLOY_FURNACE_CORE_BLOCK = registerBlock("alloy_furnace_core",
            ()->new AlloyFurnaceCoreBlock(BlockBehaviour.Properties.of().strength(3.0f)
                    .lightLevel(state -> state.getValue(AlloyFurnaceCoreBlock.IS_WORKING) ? 13 : 0)
                    .noOcclusion().requiresCorrectToolForDrops()));
    // 合金框架方块
    public static final DeferredBlock<Block> ALLOY_FURNACE_FRAMEWORK_BLOCK = registerBlock("alloy_furnace_framework",
            ()->new Block(BlockBehaviour.Properties.of().strength(5.0f).noOcclusion().requiresCorrectToolForDrops()));

    // 灵魂祭坛
    public static final DeferredBlock<Block> SOUL_ALTAR = registerBlock("soul_altar",
            ()->new SoulAltar(BlockBehaviour.Properties.of().strength(3.0f).noOcclusion()));

    // 武器台祭坛
    public static final DeferredBlock<Block> WEAPON_PLATFORM = registerBlock("weapon_platform",
            ()->new WeaponPlatform(BlockBehaviour.Properties.of().strength(3.0f).noOcclusion()));




    // 方块注册方法
    private static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        HCOreItem.ORE_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // 同步注册方块item
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> blocks = ORE_BLOCK.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    public static void register(IEventBus eventBus) {
        ORE_BLOCK.register(eventBus);
    }

}
