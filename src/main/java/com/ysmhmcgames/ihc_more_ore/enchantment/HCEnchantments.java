package com.ysmhmcgames.ihc_more_ore.enchantment;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.ElementCollectionEnchantmentEffect;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.SoulHarvestEnchantmentEffect;
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

public class HCEnchantments {
    // 元素采集
    public static final ResourceKey<Enchantment> ENTITY_ENCHANTMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "element_collection"));
    // 灵魂收割
    public static final ResourceKey<Enchantment> SOUL_HARVEST = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "soul_harvest"));

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

    }

    private static void register(BootstrapContext<Enchantment> register, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder){

        register.register(key, builder.build(key.location()));
    }
}
