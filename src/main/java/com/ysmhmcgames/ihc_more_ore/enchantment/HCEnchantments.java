package com.ysmhmcgames.ihc_more_ore.enchantment;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.*;
import com.ysmhmcgames.ihc_more_ore.util.HCTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

import java.util.function.Supplier;

public class HCEnchantments {
    // 元素采集
    public static final ResourceKey<Enchantment> ENTITY_ENCHANTMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "element_collection"));
    // 灵魂收割
    public static final ResourceKey<Enchantment> SOUL_HARVEST = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "soul_harvest"));
    // 安全收割 safe harvest
    public static final ResourceKey<Enchantment> SAFE_HARVEST = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "safe_harvest"));
    // 撕裂 tear
    public static final ResourceKey<Enchantment> TEAR = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "tear"));
    // 趁手 handy
    public static final ResourceKey<Enchantment> HANDY = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "handy"));
    // 精通 proficient
    public static final ResourceKey<Enchantment> PROFICIENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "proficient"));
    // 破伤风 tetanus
    public static final ResourceKey<Enchantment> TETANUS = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "tetanus"));

    public static void bootstrap(BootstrapContext<Enchantment> context){
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        // 元素采集
        register(context, ENTITY_ENCHANTMENT, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.HOES),// 适用物品：锄头
                1,// 权重 1-10（原版标准）
                10,// 最大等级
                Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                2,// 铁砧成本
                EquipmentSlotGroup.MAINHAND))// 装备槽：主手
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.MINING_EXCLUSIVE))// 模组互斥关系 和 时运、精准采集冲突
                .withEffect(EnchantmentEffectComponents.HIT_BLOCK, // 效果组件：击中方块(触发)
                        new ElementCollectionEnchantmentEffect()));// 触发自定义效果

        // 灵魂收割
        register(context, SOUL_HARVEST, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HCTags.Items.SICKLE),// 适用物品：镰刀
                        1,// 权重 1-10（原版标准）
                        3,// 最大等级
                        Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                        Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                        2,// 铁砧成本
                        EquipmentSlotGroup.MAINHAND))// 装备槽：主手
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new SoulHarvestEnchantmentEffect()));// 触发自定义效果

        // 安全收割
        register(context, SAFE_HARVEST, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HCTags.Items.SICKLE),// 适用物品：镰刀
                        1,// 权重 1-10（原版标准）
                        1,// 最大等级
                        Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                        Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                        5,// 铁砧成本
                        EquipmentSlotGroup.MAINHAND))// 装备槽：主手
                );

        // 撕裂
        register(context, TEAR, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(HCTags.Items.SICKLE),// 适用物品：镰刀
                7,// 权重 1-10（原版标准）
                10,// 最大等级
                Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                2,// 铁砧成本
                EquipmentSlotGroup.MAINHAND))// 装备槽：主手
        );

        // 趁手
        register(context, HANDY, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(HCTags.Items.SICKLE),// 适用物品：镰刀
                3,// 权重 1-10（原版标准）
                5,// 最大等级
                Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                3,// 铁砧成本
                EquipmentSlotGroup.MAINHAND))// 装备槽：主手
        );

        // 精通
        register(context, PROFICIENT, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(HCTags.Items.SICKLE),// 适用物品：镰刀
                4,// 权重 1-10（原版标准）
                5,// 最大等级
                Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                3,// 铁砧成本
                EquipmentSlotGroup.MAINHAND))// 装备槽：主手
        );

        // 破伤风
        register(context, TETANUS, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(HCTags.Items.IS_TETANUS),// 适用物品：对应tag
                3,// 权重 1-10（原版标准）
                5,// 最大等级
                Enchantment.dynamicCost(5,7),// 最小附魔成本 ==> 最小基础成本，等级1附魔需要5级经验   每级增加成本，每升一级增加7级经验需求
                Enchantment.dynamicCost(25,7),// 最大附魔成本 ==> 最大基础成本，等级1附魔最多需要25级经验   每级增加成本，每升一级增加7级经验需求
                /*作用：在铁砧中合并、修复、升级消耗的经验等级
                  计算方式：每次铁砧操作消耗 成本 × 操作次数*/
                3,// 铁砧成本
                EquipmentSlotGroup.MAINHAND))// 装备槽：主手
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new TetanusEnchantmentEffect()));

    }

    private static void register(BootstrapContext<Enchantment> register, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder){

        register.register(key, builder.build(key.location()));
    }
}
