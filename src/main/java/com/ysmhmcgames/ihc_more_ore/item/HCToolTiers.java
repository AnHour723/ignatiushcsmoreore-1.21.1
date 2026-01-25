package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.util.HCTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class HCToolTiers {
    // 创建材质 材质等级为特殊的自定义tag   users-耐久  speed-挖掘效率  attackDamageBonus-攻击系数  enchantValue-附魔参数  最后为该武器的维修物品
    // 量子材质
    public static final Tier QUANTUM = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_QUANTUM_TOOL,
            2541,15f,5f,28,()-> Ingredient.of(HCOreItem.QUANTUM_INGOT));

    // 锡材质
    public static final Tier TIN = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            225,6f,1.9f,14,()-> Ingredient.of(HCOreItem.TIN_INGOT));
    // 铝材质
    public static final Tier ALUMINUM = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            275,6f,2.1f,14,()-> Ingredient.of(HCOreItem.ALUMINUM_INGOT));
    // 银材质
    public static final Tier SILVER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            444,12f,2.7f,22,()-> Ingredient.of(HCOreItem.SILVER_INGOT));

    // 钢材质
    public static final Tier STEEL = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            500,6f,2f,14,()-> Ingredient.of(HCOreItem.STEEL_INGOT));


    // 寒晶材质
    public static final Tier ICE_CRYSTAL = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            305,7f,2.5f,18,()-> Ingredient.of(HCOreItem.ICE_CRYSTAL_INGOT));
    // 烈炎材质
    public static final Tier BLAZING_FIRE = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            305,7f,2.5f,18,()-> Ingredient.of(HCOreItem.BLAZING_FIRE_INGOT));

    // 提拉马材质
    public static final Tier TILAMA = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            555,8f,2f,15,()-> Ingredient.of(HCOreItem.TILAMA_INGOT));

    // 红宝石材质
    public static final Tier RUBY = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            333,6f,2f,12,()-> Ingredient.of(HCOreItem.RUBY));

    // 圣钢材质
    public static final Tier HOLY_STEEL = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            1211,8f,3f,14,()-> Ingredient.of(HCOreItem.HOLY_STEEL_INGOT));

    // 海神材质
    public static final Tier POSEIDON = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1051,7f,3f,14,()-> Ingredient.of(HCOreItem.POSEIDON_INGOT));


    // 暮云材质
    public static final Tier TWILIGHT_CLOUD = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1555,9f,3.5f,18,()-> Ingredient.of(HCOreItem.TWILIGHT_CLOUD_INGOT));
    // 风暴材质
    public static final Tier STORM = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1555,9f,3.5f,20,()-> Ingredient.of(HCOreItem.STORM_INGOT));

    // 叶绿材质
    public static final Tier CHLOROPHYLL = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            777,9f,2.5f,20,()-> Ingredient.of(HCOreItem.CHLOROPHYLL_INGOT));


    // 钛材质
    public static final Tier TITANIUM = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1657,10f,3.5f,12,()-> Ingredient.of(HCOreItem.TITANIUM_INGOT));
    // 玫瑰宝石材质
    public static final Tier ROSE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1123,9f,3f,10,()-> Ingredient.of(HCOreItem.ROSE_GEMSTONE));
    // 紫罗兰宝石材质
    public static final Tier VIOLET = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1613,8f,3f,18,()-> Ingredient.of(HCOreItem.VIOLET_GEMSTONE));

    // 元祖材质
    public static final Tier PRECURSOR = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1755,8f,3f,14,()-> Ingredient.of(HCOreItem.PRECURSOR_INGOT));


    // 不可见的材质
    public static final Tier INVISIBLE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1780,9f,4f,15,()-> Ingredient.of(HCOreItem.XXX));

    // 棱彩材质
    public static final Tier PRISMATIC_COLORFUL = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_QUANTUM_TOOL,
            2777,7.7f,6f,30,()-> Ingredient.of(HCOreItem.PRISMATIC_COLORFUL_INGOT));

    // 主界材质
    public static final Tier OVERWORLD = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_OVERWORLD_TOOL,
            3005,17f,7f,32,()-> Ingredient.of(HCOreItem.OVERWORLD_CORE));

    // 灵魂材质
    public static final Tier SOUL = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1500,8f,4f,24,()-> Ingredient.of(HCOreItem.SOUL_STEEL_INGOT));


    // 黑晶材质
    public static final Tier BLACK_CRYSTALS = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1222,8f,4f,10,()-> Ingredient.of(HCOreItem.BLACK_CRYSTALS));

    // 瑟银材质
    public static final Tier SEYIN = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            876,12f,3.5f,22,()-> Ingredient.of(HCOreItem.SEYIN_INGOT));

    // 狱炎材质
    public static final Tier HELL_S = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1555,9f,4f,10,()-> Ingredient.of(HCOreItem.HELL_S_INGOT));

    // 下界材质
    public static final Tier NETHER = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_NETHER_TOOL,
            3557,20f,8f,32,()-> Ingredient.of(HCOreItem.NETHER_CORE));

    // 末影材质
    public static final Tier ENDER = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            3557,22f,2f,32,()-> Ingredient.of(HCOreItem.ENDER_INGOT));

    // 坍缩材质
    public static final Tier COLLAPSING = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_OVERWORLD_TOOL,
            2351,18f,10f,22,()-> Ingredient.of(HCOreItem.COLLAPSING_INGOT));


    // 终界材质
    public static final Tier END = new SimpleTier(HCTags.Blocks.INCORRECT_FOR_END_TOOL,
            4108,25f,10f,32,()-> Ingredient.of(HCOreItem.END_CORE));
}
