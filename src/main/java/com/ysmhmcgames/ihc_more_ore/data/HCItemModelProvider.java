package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.HCArmor;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import com.ysmhmcgames.ihc_more_ore.item.HCTools;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class HCItemModelProvider extends ItemModelProvider {// 物品模型提供者
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static{
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public HCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IgnatiusHCsMoreOre.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleOreItem(HCOreItem.RAW_ALUMINUM);// 粗铝 物品模型
        simpleOreItem(HCOreItem.ALUMINUM_INGOT);// 铝锭 物品模型
        simpleOreItem(HCOreItem.ALUMINUM_NUGGET);// 铝粒 物品模型

        simpleOreItem(HCOreItem.RAW_TIN);// 粗锡 物品模型
        simpleOreItem(HCOreItem.TIN_INGOT);// 锡锭 物品模型
        simpleOreItem(HCOreItem.TIN_NUGGET);// 锡粒 物品模型

        simpleOreItem(HCOreItem.STEEL_INGOT);// 钢锭 物品模型
        simpleOreItem(HCOreItem.STEEL_NUGGET);// 钢粒 物品模型

        simpleOreItem(HCOreItem.RAW_SILVER);// 粗银 物品模型
        simpleOreItem(HCOreItem.SILVER_INGOT);// 银锭 物品模型
        simpleOreItem(HCOreItem.SILVER_NUGGET);// 银粒 物品模型

        simpleOreItem(HCOreItem.RAW_TILAMA);// 粗提拉马 物品模型
        simpleOreItem(HCOreItem.TILAMA_INGOT);// 提拉马锭 物品模型

        simpleOreItem(HCOreItem.ICE_CRYSTAL_INGOT);// 寒晶锭 物品模型
        simpleOreItem(HCOreItem.BLAZING_FIRE_INGOT);// 烈炎锭 物品模型
        simpleOreItem(HCOreItem.ACTIVE_FIRE);// 活火 物品模型
        simpleOreItem(HCOreItem.ICE_CRYSTAL);// 冰晶 物品模型

        simpleOreItem(HCOreItem.TWILIGHT_CLOUD_INGOT);// 暮云锭 物品模型
        simpleOreItem(HCOreItem.STORM_INGOT);// 风暴锭 物品模型

        simpleOreItem(HCOreItem.CHLOROPHYLL);// 叶绿素 物品模型
        simpleOreItem(HCOreItem.CHLOROPHYLL_CORE);// 叶绿核心 物品模型
        simpleOreItem(HCOreItem.CHLOROPLAST);// 叶绿团 物品模型
        simpleOreItem(HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT);// 失活的叶绿锭 物品模型
        simpleOreItem(HCOreItem.CHLOROPHYLL_INGOT);// 叶绿锭 物品模型
        simpleOreItem(HCOreItem.CHLOROPHYLL_NUGGET);// 叶绿粒 物品模型

        simpleOreItem(HCOreItem.RUBY);// 红宝石 物品模型

        simpleOreItem(HCOreItem.UNSTABLE_QUANTUM_STRUCTURE);// 不稳定的量子结构 物品模型
        simpleOreItem(HCOreItem.QUANTUM_INGOT);// 量子锭 物品模型
        simpleOreItem(HCOreItem.XXX);// ??? 物品模型
        simpleOreItem(HCOreItem.UNSTABLE_XXX);// 不稳定的??? 物品模型

        simpleOreItem(HCOreItem.RAW_TITANIUM);// 粗钛 物品模型
        simpleOreItem(HCOreItem.TITANIUM_INGOT);// 钛锭 物品模型

        simpleOreItem(HCOreItem.POSEIDON_FRAGMENT);// 海神碎片 物品模型
        simpleOreItem(HCOreItem.POSEIDON_INGOT);// 海神锭 物品模型

        simpleOreItem(HCOreItem.BLOSSOMING_ROSE);// 绽放玫瑰 物品模型
        simpleOreItem(HCOreItem.ROSE_GEMSTONE);// 玫瑰宝石 物品模型
        simpleOreItem(HCOreItem.VIOLET_GEMSTONE);// 紫罗兰宝石 物品模型

        simpleOreItem(HCOreItem.PRISMATIC_COLORFUL_FRAGMENT);// 棱彩碎片 物品模型
        simpleOreItem(HCOreItem.PRISMATIC_COLORFUL_CORE);// 棱彩核心 物品模型
        simpleOreItem(HCOreItem.PRISMATIC_COLORFUL_INGOT);// 棱彩锭 物品模型

        simpleOreItem(HCOreItem.PRECURSOR_ELEMENT);// 元祖素 物品模型
        simpleOreItem(HCOreItem.PRECURSOR_INGOT);// 元祖锭 物品模型

        simpleOreItem(HCOreItem.PROFANE_CRYSTAL);// 亵渎结晶 物品模型

        simpleOreItem(HCOreItem.THE_WILL_OF_THE_HERO);// "英雄意志" 物品模型
        simpleOreItem(HCOreItem.HOLY_STEEL_INGOT);// 圣钢 物品模型

        simpleOreItem(HCOreItem.TENTACULUM_WITH_NERVES);// 活跃触觉 物品模型

        simpleOreItem(HCOreItem.THOUGHT);// "思绪" 物品模型
        simpleOreItem(HCOreItem.HOMECOMING);// "归乡" 物品模型
        simpleOreItem(HCOreItem.MAPLELEAVES_IN_MY_HOMETOWN);// "故乡的"枫叶 物品模型
        simpleOreItem(HCOreItem.ONE_STRIKE_KILLS);// "魂归故里" 物品模型

        simpleOreItem(HCOreItem.OVERWORLD_CORE);// ===================主界核心 物品模型=================


        simpleOreItem(HCOreItem.SOUL_ESSENCE);// 灵魂精华 物品模型
        simpleOreItem(HCOreItem.SOUL_STEEL_INGOT);// 灵魂钢锭 物品模型

        simpleOreItem(HCOreItem.FLASH_GOLD_INGOT);// 闪金锭 物品模型

        simpleOreItem(HCOreItem.HEYAN);// 赫岩 物品模型
        simpleOreItem(HCOreItem.BLACK_CRYSTALS);// 黑晶 物品模型

        simpleOreItem(HCOreItem.HELL_S_STONE);// 狱炎岩 物品模型
        simpleOreItem(HCOreItem.HELL_S_INGOT);// 狱炎锭 物品模型

        simpleOreItem(HCOreItem.RAW_SEYIN);// 粗瑟银 物品模型
        simpleOreItem(HCOreItem.SEYIN_INGOT);// 瑟银锭 物品模型

        simpleOreItem(HCOreItem.REFINED_RED_LOTUS);// 精炼红莲 物品模型

        simpleOreItem(HCOreItem.NETHER_CORE);//===================下届核心 物品模型=================

        simpleOreItem(HCOreItem.GAZING);// "凝视" 物品模型
        simpleOreItem(HCOreItem.EERIE_EYE);// 诡异之眼 物品模型

        simpleOreItem(HCOreItem.STARDUST);// 星尘 物品模型

        simpleOreItem(HCOreItem.RAW_DIVINATION_DRAGON);// 粗龙占 物品模型

        simpleOreItem(HCOreItem.COLLAPSING_CREAM);// 坍缩精元 物品模型
        simpleOreItem(HCOreItem.COLLAPSING_INGOT);// 坍缩锭 物品模型
        simpleOreItem(HCOreItem.COLLAPSING_CORE);// 坍缩核心 物品模型

        simpleOreItem(HCOreItem.RAW_ENDER_ORE);// 粗末影矿 物品模型
        simpleOreItem(HCOreItem.ENDER_INGOT);// 末影锭 物品模型

        simpleOreItem(HCOreItem.END_CORE);// 终界核心 物品模型

        // ====================================多维度生成矿=============================================
        simpleOreItem(HCOreItem.PURE_WHITE_POLE);// 纯净白极点 物品模型
        simpleOreItem(HCOreItem.PURE_BLACK_POLE);// 纯净黑极点 物品模型
        simpleOreItem(HCOreItem.FUZZY_POLE);// 模糊极点 物品模型
        simpleOreItem(HCOreItem.TAI_JI);// 太极 物品模型
        simpleOreItem(HCOreItem.POLE_INGOT);// 两极锭 物品模型

        simpleOreItem(HCOreItem.SPIRITUAL_COAL);// 灵煤 物品模型
        simpleOreItem(HCOreItem.SALTPETRE);// 硝石 物品模型
        simpleOreItem(HCOreItem.PYROCARBON);// 冥火炭 物品模型
        simpleOreItem(HCOreItem.VOID_CRYSTAL);// 虚空墨晶 物品模型

        /*============================================================*/

        simpleItem(HCItems.STEEL_STICK);// 钢棒 物品模型
        simpleItem(HCItems.TILAMA_STICK);// 提拉马棒 物品模型
        simpleItem(HCItems.SEYIN_STICK);// 瑟银棒 物品模型
        simpleItem(HCItems.ENDER_STICK);// 末影棒 物品模型

        simpleItem(HCItems.GLASS_CRYSTALLIZATION_TEMPLATE);// 玻璃结晶模板 物品模型

        simpleItem(HCItems.QUANTUM_UPGRADE_TEMPLATE);// 升级图纸  合金 -> 量子    物品模型
        simpleItem(HCItems.PRISMATIC_COLORFUL_UPGRADE_TEMPLATE);// 升级图纸  合金 -> 棱彩     物品模型
        simpleItem(HCItems.COLLAPSING_UPGRADE_TEMPLATE);// 升级图纸  量子 -> 坍缩    物品模型
        simpleItem(HCItems.OVERWORLD_UPGRADE_TEMPLATE);// 升级图纸  量子 -> 主界    物品模型
        simpleItem(HCItems.NETHER_UPGRADE_TEMPLATE);// 升级图纸  主界 -> 下界    物品模型
        simpleItem(HCItems.END_UPGRADE_TEMPLATE);// 升级图纸  下界 -> 终界    物品模型

        simpleItem(HCItems.POLE_BOW_UPGRADE_TEMPLATE);// 武器锻造图纸  风暴弓 -> 两级弓    物品模型

        simpleItem(HCItems.LANHUAYING_MUSIC_DISC);// 唱片  蓝花楹
        simpleItem(HCItems.LANHUAYING_AI_MUSIC_DISC);// 唱片  蓝花楹ai
        simpleItem(HCItems.FUCHEN_MUSIC_DISC);// 唱片  浮沉

        simpleItem(HCItems.QUANTUM_INFORMATION_SPHERE);// 量子空白信息球 物品模型
        simpleItem(HCItems.QUANTUM_HELMET_INFORMATION_SPHERE);// 量子头盔信息球 物品模型
        simpleItem(HCItems.QUANTUM_CHESTPLATE_INFORMATION_SPHERE);// 量子护甲信息球 物品模型
        simpleItem(HCItems.QUANTUM_LEGGINGS_INFORMATION_SPHERE);// 量子裤腿信息球 物品模型
        simpleItem(HCItems.QUANTUM_BOOTS_INFORMATION_SPHERE);// 量子靴子信息球 物品模型

        simpleItem(HCItems.QUANTUM_SICKLE_INFORMATION_SPHERE);// 量子镰刀信息球 物品模型
        simpleItem(HCItems.QUANTUM_SWORD_INFORMATION_SPHERE);// 量子剑信息球 物品模型
        simpleItem(HCItems.QUANTUM_PICKAXE_INFORMATION_SPHERE);// 量子镐子信息球 物品模型
        simpleItem(HCItems.QUANTUM_AXE_INFORMATION_SPHERE);// 量子斧头信息球 物品模型
        simpleItem(HCItems.QUANTUM_SHOVEL_INFORMATION_SPHERE);// 量子锹信息球 物品模型
        simpleItem(HCItems.QUANTUM_HOE_INFORMATION_SPHERE);// 量子锄头信息球 物品模型

        /*============================================================*/
        // 铝工具
        handheldItem(HCTools.ALUMINUM_SWORD.get());
        handheldItem(HCTools.ALUMINUM_SICKLE.get());
        handheldItem(HCTools.ALUMINUM_AXE.get());
        handheldItem(HCTools.ALUMINUM_HOE.get());
        handheldItem(HCTools.ALUMINUM_PICKAXE.get());
        handheldItem(HCTools.ALUMINUM_SHOVEL.get());
        // 锡工具
        handheldItem(HCTools.TIN_SWORD.get());
        handheldItem(HCTools.TIN_SICKLE.get());
        handheldItem(HCTools.TIN_AXE.get());
        handheldItem(HCTools.TIN_HOE.get());
        handheldItem(HCTools.TIN_PICKAXE.get());
        handheldItem(HCTools.TIN_SHOVEL.get());
        // 银工具
        handheldItem(HCTools.SILVER_SWORD.get());
        handheldItem(HCTools.SILVER_SICKLE.get());
        handheldItem(HCTools.SILVER_AXE.get());
        handheldItem(HCTools.SILVER_HOE.get());
        handheldItem(HCTools.SILVER_PICKAXE.get());
        handheldItem(HCTools.SILVER_SHOVEL.get());
        // 钢工具
        handheldItem(HCTools.STEEL_SWORD.get());
        handheldItem(HCTools.STEEL_SICKLE.get());
        handheldItem(HCTools.STEEL_AXE.get());
        handheldItem(HCTools.STEEL_HOE.get());
        handheldItem(HCTools.STEEL_PICKAXE.get());
        handheldItem(HCTools.STEEL_SHOVEL.get());

        // 寒晶工具
        handheldItem(HCTools.ICE_CRYSTAL_SWORD.get());
        handheldItem(HCTools.ICE_CRYSTAL_SICKLE.get());
        // 烈炎工具
        handheldItem(HCTools.BLAZING_FIRE_SWORD.get());
        handheldItem(HCTools.BLAZING_FIRE_SICKLE.get());
        // 风暴工具
        handheldItem(HCTools.STORM_SWORD.get());
        handheldItem(HCTools.STORM_SICKLE.get());

        // 提拉马工具
        handheldItem(HCTools.TILAMA_SWORD.get());
        handheldItem(HCTools.TILAMA_SICKLE.get());
        handheldItem(HCTools.TILAMA_AXE.get());
        handheldItem(HCTools.TILAMA_HOE.get());
        handheldItem(HCTools.TILAMA_PICKAXE.get());
        handheldItem(HCTools.TILAMA_SHOVEL.get());
        // 红宝石工具
        handheldItem(HCTools.RUBY_SWORD.get());
        handheldItem(HCTools.RUBY_AXE.get());
        handheldItem(HCTools.RUBY_HOE.get());
        handheldItem(HCTools.RUBY_PICKAXE.get());
        handheldItem(HCTools.RUBY_SHOVEL.get());

        // 叶绿工具
        handheldItem(HCTools.CHLOROPHYLL_SWORD.get());
        handheldItem(HCTools.CHLOROPHYLL_SICKLE.get());
        handheldItem(HCTools.CHLOROPHYLL_AXE.get());
        handheldItem(HCTools.CHLOROPHYLL_HOE.get());
        handheldItem(HCTools.CHLOROPHYLL_PICKAXE.get());
        handheldItem(HCTools.CHLOROPHYLL_SHOVEL.get());
        // 海神工具
        handheldItem(HCTools.POSEIDON_SWORD.get());
        handheldItem(HCTools.POSEIDON_SICKLE.get());
        handheldItem(HCTools.POSEIDON_AXE.get());
        handheldItem(HCTools.POSEIDON_HOE.get());
        handheldItem(HCTools.POSEIDON_PICKAXE.get());
        handheldItem(HCTools.POSEIDON_SHOVEL.get());

        // 钛工具
        handheldItem(HCTools.TITANIUM_SWORD.get());
        handheldItem(HCTools.TITANIUM_SICKLE.get());
        handheldItem(HCTools.TITANIUM_AXE.get());
        handheldItem(HCTools.TITANIUM_HOE.get());
        handheldItem(HCTools.TITANIUM_PICKAXE.get());
        handheldItem(HCTools.TITANIUM_SHOVEL.get());
        // 元祖工具
        handheldItem(HCTools.PRECURSOR_SWORD.get());
        handheldItem(HCTools.PRECURSOR_SICKLE.get());
        handheldItem(HCTools.PRECURSOR_AXE.get());
        handheldItem(HCTools.PRECURSOR_HOE.get());
        handheldItem(HCTools.PRECURSOR_PICKAXE.get());
        handheldItem(HCTools.PRECURSOR_SHOVEL.get());
        // 狱炎工具
        handheldItem(HCTools.HELL_S_SWORD.get());
        handheldItem(HCTools.HELL_S_SICKLE.get());
        handheldItem(HCTools.HELL_S_AXE.get());
        handheldItem(HCTools.HELL_S_HOE.get());
        handheldItem(HCTools.HELL_S_PICKAXE.get());
        handheldItem(HCTools.HELL_S_SHOVEL.get());

        // 紫罗兰工具
        handheldItem(HCTools.VIOLET_SWORD.get());
        handheldItem(HCTools.VIOLET_AXE.get());
        handheldItem(HCTools.VIOLET_HOE.get());
        handheldItem(HCTools.VIOLET_PICKAXE.get());
        handheldItem(HCTools.VIOLET_SHOVEL.get());

        // 玫瑰工具
        handheldItem(HCTools.ROSE_SWORD.get());
        handheldItem(HCTools.ROSE_AXE.get());
        handheldItem(HCTools.ROSE_HOE.get());
        handheldItem(HCTools.ROSE_PICKAXE.get());
        handheldItem(HCTools.ROSE_SHOVEL.get());
        // 黑晶工具
        handheldItem(HCTools.BLACK_CRYSTALS_SWORD.get());
        handheldItem(HCTools.BLACK_CRYSTALS_AXE.get());
        handheldItem(HCTools.BLACK_CRYSTALS_HOE.get());
        handheldItem(HCTools.BLACK_CRYSTALS_PICKAXE.get());
        handheldItem(HCTools.BLACK_CRYSTALS_SHOVEL.get());

        // 圣钢工具
        handheldItem(HCTools.HOLY_STEEL_SWORD.get());
        handheldItem(HCTools.HOLY_STEEL_AXE.get());
        handheldItem(HCTools.HOLY_STEEL_HOE.get());
        handheldItem(HCTools.HOLY_STEEL_PICKAXE.get());
        handheldItem(HCTools.HOLY_STEEL_SHOVEL.get());

        // 灵魂工具
        handheldItem(HCTools.SOUL_SWORD.get());
        handheldItem(HCTools.SOUL_SICKLE.get());

        // 末影工具
        handheldItem(HCTools.ENDER_SICKLE.get());
        handheldItem(HCTools.ENDER_SWORD.get());
        handheldItem(HCTools.ENDER_AXE.get());
        handheldItem(HCTools.ENDER_HOE.get());
        handheldItem(HCTools.ENDER_PICKAXE.get());
        handheldItem(HCTools.ENDER_SHOVEL.get());

        // 国王的新工具
        handheldItem(HCTools.EMPEROR_S_PICKAXE.get());
        handheldItem(HCTools.EMPEROR_S_SWORD.get());
        handheldItem(HCTools.EMPEROR_S_AXE.get());
        handheldItem(HCTools.EMPEROR_S_HOE.get());
        handheldItem(HCTools.EMPEROR_S_SHOVEL.get());

        // 棱彩的工具
        handheldItem(HCTools.PRISMATIC_COLORFUL_SICKLE.get());
        handheldItem(HCTools.PRISMATIC_COLORFUL_PICKAXE.get());
        handheldItem(HCTools.PRISMATIC_COLORFUL_SWORD.get());
        handheldItem(HCTools.PRISMATIC_COLORFUL_AXE.get());
        handheldItem(HCTools.PRISMATIC_COLORFUL_HOE.get());
        handheldItem(HCTools.PRISMATIC_COLORFUL_SHOVEL.get());
        // 主界的工具
        handheldItem(HCTools.OVERWORLD_PICKAXE.get());
        handheldItem(HCTools.OVERWORLD_SWORD.get());
        handheldItem(HCTools.OVERWORLD_AXE.get());
        handheldItem(HCTools.OVERWORLD_HOE.get());
        handheldItem(HCTools.OVERWORLD_SHOVEL.get());
        // 坍缩的工具
        handheldItem(HCTools.COLLAPSING_SICKLE.get());
        handheldItem(HCTools.COLLAPSING_PICKAXE.get());
        handheldItem(HCTools.COLLAPSING_SWORD.get());
        handheldItem(HCTools.COLLAPSING_AXE.get());
        handheldItem(HCTools.COLLAPSING_HOE.get());
        handheldItem(HCTools.COLLAPSING_SHOVEL.get());
        // 下界的工具
        handheldItem(HCTools.NETHER_SICKLE.get());
        handheldItem(HCTools.NETHER_PICKAXE.get());
        handheldItem(HCTools.NETHER_SWORD.get());
        handheldItem(HCTools.NETHER_AXE.get());
        handheldItem(HCTools.NETHER_HOE.get());
        handheldItem(HCTools.NETHER_SHOVEL.get());
        // 终界的工具
        handheldItem(HCTools.END_PICKAXE.get());
        handheldItem(HCTools.END_SWORD.get());
        handheldItem(HCTools.END_AXE.get());
        handheldItem(HCTools.END_HOE.get());
        handheldItem(HCTools.END_SHOVEL.get());

        /*============================================================*/
        // 铝装备
        trimmedArmorItem(HCArmor.ALUMINUM_HELMET);
        trimmedArmorItem(HCArmor.ALUMINUM_CHESTPLATE);
        trimmedArmorItem(HCArmor.ALUMINUM_LEGGINGS);
        trimmedArmorItem(HCArmor.ALUMINUM_BOOTS);
        // 锡装备
        trimmedArmorItem(HCArmor.TIN_HELMET);
        trimmedArmorItem(HCArmor.TIN_CHESTPLATE);
        trimmedArmorItem(HCArmor.TIN_LEGGINGS);
        trimmedArmorItem(HCArmor.TIN_BOOTS);
        // 银装备
        trimmedArmorItem(HCArmor.SILVER_HELMET);
        trimmedArmorItem(HCArmor.SILVER_CHESTPLATE);
        trimmedArmorItem(HCArmor.SILVER_LEGGINGS);
        trimmedArmorItem(HCArmor.SILVER_BOOTS);
        // 海神装备
        trimmedArmorItem(HCArmor.POSEIDON_HELMET);
        trimmedArmorItem(HCArmor.POSEIDON_CHESTPLATE);
        trimmedArmorItem(HCArmor.POSEIDON_LEGGINGS);
        trimmedArmorItem(HCArmor.POSEIDON_BOOTS);
        // 玫瑰装备
        trimmedArmorItem(HCArmor.ROSE_HELMET);
        trimmedArmorItem(HCArmor.ROSE_CHESTPLATE);
        trimmedArmorItem(HCArmor.ROSE_LEGGINGS);
        trimmedArmorItem(HCArmor.ROSE_BOOTS);

        // 圣钢装备
        trimmedArmorItem(HCArmor.HOLY_STEEL_HELMET);
        trimmedArmorItem(HCArmor.HOLY_STEEL_CHESTPLATE);
        trimmedArmorItem(HCArmor.HOLY_STEEL_LEGGINGS);
        trimmedArmorItem(HCArmor.HOLY_STEEL_BOOTS);

        // 末影装备
        trimmedArmorItem(HCArmor.ENDER_HELMET);
        trimmedArmorItem(HCArmor.ENDER_CHESTPLATE);
        trimmedArmorItem(HCArmor.ENDER_LEGGINGS);
        trimmedArmorItem(HCArmor.ENDER_BOOTS);

        // 量子装备
        trimmedArmorItem(HCArmor.QUANTUM_HELMET);
        trimmedArmorItem(HCArmor.QUANTUM_CHESTPLATE);
        trimmedArmorItem(HCArmor.QUANTUM_LEGGINGS);
        trimmedArmorItem(HCArmor.QUANTUM_BOOTS);

        // 国王的新装备
        trimmedArmorItem(HCArmor.EMPEROR_S_HELMET);
        trimmedArmorItem(HCArmor.EMPEROR_S_CHESTPLATE);
        trimmedArmorItem(HCArmor.EMPEROR_S_LEGGINGS);
        trimmedArmorItem(HCArmor.EMPEROR_S_BOOTS);

        // 棱彩的新装备
        trimmedArmorItem(HCArmor.PRISMATIC_COLORFUL_HELMET);
        trimmedArmorItem(HCArmor.PRISMATIC_COLORFUL_CHESTPLATE);
        trimmedArmorItem(HCArmor.PRISMATIC_COLORFUL_LEGGINGS);
        trimmedArmorItem(HCArmor.PRISMATIC_COLORFUL_BOOTS);

        // 主界的新装备
        trimmedArmorItem(HCArmor.OVERWORLD_HELMET);
        trimmedArmorItem(HCArmor.OVERWORLD_CHESTPLATE);
        trimmedArmorItem(HCArmor.OVERWORLD_LEGGINGS);
        trimmedArmorItem(HCArmor.OVERWORLD_BOOTS);
        // 下界的新装备
        trimmedArmorItem(HCArmor.NETHER_HELMET);
        trimmedArmorItem(HCArmor.NETHER_CHESTPLATE);
        trimmedArmorItem(HCArmor.NETHER_LEGGINGS);
        trimmedArmorItem(HCArmor.NETHER_BOOTS);
        // 终界的新装备
        trimmedArmorItem(HCArmor.END_HELMET);
        trimmedArmorItem(HCArmor.END_CHESTPLATE);
        trimmedArmorItem(HCArmor.END_LEGGINGS);
        trimmedArmorItem(HCArmor.END_BOOTS);
    }

    private void simpleOreItem(DeferredItem<?> deferredItem){
//        ResourceLocation item = deferredItem.getId();
//        basicItem(item);

        ResourceLocation item = deferredItem.getId();
        String itemName = item.getPath();

        // 1. 模型名称就是物品名称（不包含路径）
        // 模型文件：models/item/itemName.json
        ItemModelBuilder builder = this.getBuilder(itemName)
                .parent(new ModelFile.UncheckedModelFile("item/generated"));

        // 2. 纹理路径包含 ore/ 子目录
        // 引用：textures/item/ore/itemName.png
        builder.texture(
                "layer0",
                ResourceLocation.fromNamespaceAndPath(
                        item.getNamespace(),
                        "item/ore/" + itemName
                )
        );


    }

    public ItemModelBuilder handheldItem(ResourceLocation item) {
        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)this
                .getBuilder(item.toString()))
                .parent(new ModelFile.UncheckedModelFile("item/handheld")))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/tool/" + item.getPath()));
    }

    private void simpleItem(DeferredItem<?> deferredItem){
//        ResourceLocation item = deferredItem.getId();
//        basicItem(item);

        ResourceLocation item = deferredItem.getId();
        String itemName = item.getPath();

        // 1. 模型名称就是物品名称（不包含路径）
        // 模型文件：models/item/itemName.json
        ItemModelBuilder builder = this.getBuilder(itemName)
                .parent(new ModelFile.UncheckedModelFile("item/generated"));

        // 2.
        // 引用：textures/item/itemName.png
        builder.texture(
                "layer0",
                ResourceLocation.fromNamespaceAndPath(
                        item.getNamespace(),
                        "item/" + itemName
                )
        );
    }



//    public ItemModelBuilder basicItem(ResourceLocation item) {
//        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(item.toString())).parent(new ModelFile.UncheckedModelFile("item/generated"))).texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/ore/" + item.getPath()));
//    }


    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem){
        final String MODID = IgnatiusHCsMoreOre.MODID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem ){
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()){
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(),
                            mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                            ResourceLocation.fromNamespaceAndPath(MODID,
                                "item/" + itemDeferredItem.getId().getPath()));
            });
        }

    }


}
