package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.HCArmor;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import com.ysmhmcgames.ihc_more_ore.item.HCTools;
import com.ysmhmcgames.ihc_more_ore.util.HCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HCItemTagProvider extends ItemTagsProvider {// 物品标签提供者
    public HCItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags
            , @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, IgnatiusHCsMoreOre.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .remove(HCTools.BLAZING_FIRE_SWORD.get())
                .remove(HCTools.BLAZING_FIRE_SICKLE.get())
                .remove(HCTools.ICE_CRYSTAL_SICKLE.get())
                .remove(HCTools.ICE_CRYSTAL_SWORD.get())
                ;

        tag(HCTags.Items.IS_BLUEPRINT)
                .add(HCItems.QUANTUM_UPGRADE_TEMPLATE.get())
                .add(HCItems.PRISMATIC_COLORFUL_UPGRADE_TEMPLATE.get())
                .add(HCItems.COLLAPSING_UPGRADE_TEMPLATE.get())
                .add(HCItems.OVERWORLD_UPGRADE_TEMPLATE.get())
                .add(HCItems.NETHER_UPGRADE_TEMPLATE.get())
                .add(HCItems.END_UPGRADE_TEMPLATE.get())
        ;

        tag(ItemTags.BOW_ENCHANTABLE) // 属于弓箭类(便于支持附魔)
                .add(HCTools.ICE_CRYSTAL_BOW.get()) // 冰晶
                .add(HCTools.BLAZING_FIRE_BOW.get()) // 烈炎
                .add(HCTools.STORM_BOW.get()) // 风暴
                .add(HCTools.HOLY_STEEL_BOW.get()) // 圣钢
                ;

        tag(ItemTags.SWORDS) // 属于镐子类(便于支持附魔)
                .addTag(HCTags.Items.SICKLE) // 镰刀
                .add(HCTools.ALUMINUM_SWORD.get()) // 铝
                .add(HCTools.TIN_SWORD.get()) // 锡
                .add(HCTools.STEEL_SWORD.get()) // 钢
                .add(HCTools.SILVER_SWORD.get()) // 银
                .add(HCTools.ICE_CRYSTAL_SWORD.get()) // 寒晶
                .add(HCTools.BLAZING_FIRE_SWORD.get()) // 烈炎
                .add(HCTools.STORM_SWORD.get()) // 风暴
                .add(HCTools.TILAMA_SWORD.get()) // 提拉马
                .add(HCTools.RUBY_SWORD.get()) // 红宝石
                .add(HCTools.CHLOROPHYLL_SWORD.get()) // 叶绿
                .add(HCTools.POSEIDON_SWORD.get()) // 海神
                .add(HCTools.TITANIUM_SWORD.get()) // 钛
                .add(HCTools.PRECURSOR_SWORD.get()) // 元祖
                .add(HCTools.HELL_S_SWORD.get()) // 狱炎
                .add(HCTools.ROSE_SWORD.get()) // 玫瑰
                .add(HCTools.VIOLET_SWORD.get()) // 紫罗兰
                .add(HCTools.BLACK_CRYSTALS_SWORD.get()) // 黑晶
                .add(HCTools.EMPEROR_S_SWORD.get()) // 国王的新
                .add(HCTools.QUANTUM_SWORD.get()) // 量子
                .add(HCTools.HOLY_STEEL_SWORD.get()) // 圣钢
                .add(HCTools.ENDER_SWORD.get()) // 末影
                .add(HCTools.PRISMATIC_COLORFUL_SWORD.get()) // 棱彩
                .add(HCTools.COLLAPSING_SWORD.get()) // 坍缩
                .add(HCTools.OVERWORLD_SWORD.get()) // 主界
                .add(HCTools.NETHER_SWORD.get()) // 下界
                .add(HCTools.END_SWORD.get()) // 终界
        ;

        tag(ItemTags.PICKAXES) // 属于镐子类(便于支持附魔)
                .add(HCTools.ALUMINUM_PICKAXE.get()) // 铝
                .add(HCTools.TIN_PICKAXE.get()) // 锡
                .add(HCTools.STEEL_PICKAXE.get()) // 钢
                .add(HCTools.SILVER_PICKAXE.get()) // 银
                .add(HCTools.TILAMA_PICKAXE.get()) // 提拉马
                .add(HCTools.RUBY_PICKAXE.get()) // 红宝石
                .add(HCTools.CHLOROPHYLL_PICKAXE.get()) // 叶绿
                .add(HCTools.POSEIDON_PICKAXE.get()) // 海神
                .add(HCTools.TITANIUM_PICKAXE.get()) // 钛
                .add(HCTools.PRECURSOR_PICKAXE.get()) // 元祖
                .add(HCTools.HELL_S_PICKAXE.get()) // 狱炎
                .add(HCTools.ROSE_PICKAXE.get()) // 玫瑰
                .add(HCTools.VIOLET_PICKAXE.get()) // 紫罗兰
                .add(HCTools.BLACK_CRYSTALS_PICKAXE.get()) // 黑晶
                .add(HCTools.EMPEROR_S_PICKAXE.get()) // 国王的新
                .add(HCTools.QUANTUM_PICKAXE.get()) // 量子
                .add(HCTools.HOLY_STEEL_PICKAXE.get()) // 圣钢
                .add(HCTools.ENDER_PICKAXE.get()) // 末影
                .add(HCTools.PRISMATIC_COLORFUL_PICKAXE.get()) // 棱彩
                .add(HCTools.COLLAPSING_PICKAXE.get()) // 坍缩
                .add(HCTools.OVERWORLD_PICKAXE.get()) // 主界
                .add(HCTools.NETHER_PICKAXE.get()) // 下界
                .add(HCTools.END_PICKAXE.get()) // 终界
    ;

        tag(ItemTags.AXES) // 属于斧头类(便于支持附魔)
                .add(HCTools.ALUMINUM_AXE.get()) // 铝
                .add(HCTools.TIN_AXE.get()) // 锡
                .add(HCTools.STEEL_AXE.get()) // 钢
                .add(HCTools.SILVER_AXE.get()) // 银
                .add(HCTools.TILAMA_AXE.get()) // 提拉马
                .add(HCTools.RUBY_AXE.get()) // 红宝石
                .add(HCTools.CHLOROPHYLL_AXE.get()) // 叶绿
                .add(HCTools.POSEIDON_AXE.get()) // 海神
                .add(HCTools.TITANIUM_AXE.get()) // 钛
                .add(HCTools.PRECURSOR_AXE.get()) // 元祖
                .add(HCTools.HELL_S_AXE.get()) // 狱炎
                .add(HCTools.ROSE_AXE.get()) // 玫瑰
                .add(HCTools.VIOLET_AXE.get()) // 紫罗兰
                .add(HCTools.BLACK_CRYSTALS_AXE.get()) // 黑晶
                .add(HCTools.EMPEROR_S_AXE.get()) // 国王的新
                .add(HCTools.QUANTUM_AXE.get()) // 量子
                .add(HCTools.HOLY_STEEL_AXE.get()) // 圣钢
                .add(HCTools.ENDER_AXE.get()) // 末影
                .add(HCTools.PRISMATIC_COLORFUL_AXE.get()) // 棱彩
                .add(HCTools.COLLAPSING_AXE.get()) // 坍缩
                .add(HCTools.OVERWORLD_AXE.get()) // 主界
                .add(HCTools.NETHER_AXE.get()) // 下界
                .add(HCTools.END_AXE.get()) // 终界
        ;

        tag(ItemTags.HOES) // 属于锄头类(便于支持附魔)
                .add(HCTools.ALUMINUM_HOE.get()) // 铝
                .add(HCTools.TIN_HOE.get()) // 锡
                .add(HCTools.STEEL_HOE.get()) // 钢
                .add(HCTools.SILVER_HOE.get()) // 银
                .add(HCTools.TILAMA_HOE.get()) // 提拉马
                .add(HCTools.RUBY_HOE.get()) // 红宝石
                .add(HCTools.CHLOROPHYLL_HOE.get()) // 叶绿
                .add(HCTools.POSEIDON_HOE.get()) // 海神
                .add(HCTools.TITANIUM_HOE.get()) // 钛
                .add(HCTools.PRECURSOR_HOE.get()) // 元祖
                .add(HCTools.HELL_S_HOE.get()) // 狱炎
                .add(HCTools.ROSE_HOE.get()) // 玫瑰
                .add(HCTools.VIOLET_HOE.get()) // 紫罗兰
                .add(HCTools.BLACK_CRYSTALS_HOE.get()) // 黑晶
                .add(HCTools.EMPEROR_S_HOE.get()) // 国王的新
                .add(HCTools.QUANTUM_HOE.get()) // 量子
                .add(HCTools.HOLY_STEEL_HOE.get()) // 圣钢
                .add(HCTools.ENDER_HOE.get()) // 末影
                .add(HCTools.PRISMATIC_COLORFUL_HOE.get()) // 棱彩
                .add(HCTools.COLLAPSING_HOE.get()) // 坍缩
                .add(HCTools.OVERWORLD_HOE.get()) // 主界
                .add(HCTools.NETHER_HOE.get()) // 下界
                .add(HCTools.END_HOE.get()) // 终界
        ;

        tag(ItemTags.SHOVELS) // 属于锹类(便于支持附魔)
                .add(HCTools.ALUMINUM_SHOVEL.get()) // 铝
                .add(HCTools.TIN_SHOVEL.get()) // 锡
                .add(HCTools.STEEL_SHOVEL.get()) // 钢
                .add(HCTools.SILVER_SHOVEL.get()) // 银
                .add(HCTools.TILAMA_SHOVEL.get()) // 提拉马
                .add(HCTools.RUBY_SHOVEL.get()) // 红宝石
                .add(HCTools.CHLOROPHYLL_SHOVEL.get()) // 叶绿
                .add(HCTools.POSEIDON_SHOVEL.get()) // 海神
                .add(HCTools.TITANIUM_SHOVEL.get()) // 钛
                .add(HCTools.PRECURSOR_SHOVEL.get()) // 元祖
                .add(HCTools.HELL_S_SHOVEL.get()) // 狱炎
                .add(HCTools.ROSE_SHOVEL.get()) // 玫瑰
                .add(HCTools.VIOLET_SHOVEL.get()) // 紫罗兰
                .add(HCTools.BLACK_CRYSTALS_SHOVEL.get()) // 黑晶
                .add(HCTools.EMPEROR_S_SHOVEL.get()) // 国王的新
                .add(HCTools.QUANTUM_SHOVEL.get()) // 量子
                .add(HCTools.HOLY_STEEL_SHOVEL.get()) // 圣钢
                .add(HCTools.ENDER_SHOVEL.get()) // 末影
                .add(HCTools.PRISMATIC_COLORFUL_SHOVEL.get()) // 棱彩
                .add(HCTools.COLLAPSING_SHOVEL.get()) // 坍缩
                .add(HCTools.OVERWORLD_SHOVEL.get()) // 主界
                .add(HCTools.NETHER_SHOVEL.get()) // 下界
                .add(HCTools.END_SHOVEL.get()) // 终界
        ;

        tag(HCTags.Items.GLASS_KEY)
                .add(Items.GLASS)
                .add(Items.WHITE_STAINED_GLASS)
                .add(Items.ORANGE_STAINED_GLASS)
                .add(Items.MAGENTA_STAINED_GLASS)
                .add(Items.LIGHT_BLUE_STAINED_GLASS)
                .add(Items.YELLOW_STAINED_GLASS)
                .add(Items.LIME_STAINED_GLASS)
                .add(Items.PINK_STAINED_GLASS)
                .add(Items.GRAY_STAINED_GLASS)
                .add(Items.LIGHT_GRAY_STAINED_GLASS)
                .add(Items.CYAN_STAINED_GLASS)
                .add(Items.PURPLE_STAINED_GLASS)
                .add(Items.BLUE_STAINED_GLASS)
                .add(Items.BROWN_STAINED_GLASS)
                .add(Items.GREEN_STAINED_GLASS)
                .add(Items.RED_STAINED_GLASS)
                .add(Items.BLACK_STAINED_GLASS)
                .add(Items.TINTED_GLASS)
        ;

        tag(HCTags.Items.SICKLE)
                .add(HCTools.QUANTUM_SICKLE.get())
                .add(HCTools.TIN_SICKLE.get())
                .add(HCTools.ALUMINUM_SICKLE.get())
                .add(HCTools.STEEL_SICKLE.get())
                .add(HCTools.SILVER_SICKLE.get())
                .add(HCTools.ICE_CRYSTAL_SICKLE.get())
                .add(HCTools.BLAZING_FIRE_SICKLE.get())
                .add(HCTools.TILAMA_SICKLE.get())
                .add(HCTools.STORM_SICKLE.get())
                .add(HCTools.CHLOROPHYLL_SICKLE.get())
                .add(HCTools.POSEIDON_SICKLE.get())
                .add(HCTools.TITANIUM_SICKLE.get())
                .add(HCTools.PRECURSOR_SICKLE.get())
                .add(HCTools.HELL_S_SICKLE.get())
                .add(HCTools.SOUL_SICKLE.get())
                .add(HCTools.ENDER_SICKLE.get())
                .add(HCTools.PRISMATIC_COLORFUL_SICKLE.get()) // 棱彩
                .add(HCTools.COLLAPSING_SICKLE.get()) // 坍缩
                .add(HCTools.NETHER_SICKLE.get()) // 下界
        ;

        tag(ItemTags.HEAD_ARMOR)// 属于头盔类(便于支持附魔)
                .add(HCArmor.ALUMINUM_HELMET.get())
                .add(HCArmor.TIN_HELMET.get())
                .add(HCArmor.SILVER_HELMET.get())
                .add(HCArmor.POSEIDON_HELMET.get())
                .add(HCArmor.ROSE_HELMET.get())
                .add(HCArmor.HOLY_STEEL_HELMET.get())
                .add(HCArmor.ENDER_HELMET.get())
                .add(HCArmor.EMPEROR_S_HELMET.get())
                .add(HCArmor.QUANTUM_HELMET.get())
                .add(HCArmor.PRISMATIC_COLORFUL_HELMET.get())
                .add(HCArmor.OVERWORLD_HELMET.get())
                .add(HCArmor.NETHER_HELMET.get())
                .add(HCArmor.END_HELMET.get())
        ;
        tag(ItemTags.CHEST_ARMOR)// 属于护甲类(便于支持附魔)
                .add(HCArmor.ALUMINUM_CHESTPLATE.get())
                .add(HCArmor.TIN_CHESTPLATE.get())
                .add(HCArmor.SILVER_CHESTPLATE.get())
                .add(HCArmor.POSEIDON_CHESTPLATE.get())
                .add(HCArmor.ROSE_CHESTPLATE.get())
                .add(HCArmor.HOLY_STEEL_CHESTPLATE.get())
                .add(HCArmor.ENDER_CHESTPLATE.get())
                .add(HCArmor.EMPEROR_S_CHESTPLATE.get())
                .add(HCArmor.QUANTUM_CHESTPLATE.get())
                .add(HCArmor.PRISMATIC_COLORFUL_CHESTPLATE.get())
                .add(HCArmor.OVERWORLD_CHESTPLATE.get())
                .add(HCArmor.NETHER_CHESTPLATE.get())
                .add(HCArmor.END_CHESTPLATE.get())
        ;
        tag(ItemTags.LEG_ARMOR)// 属于裤腿类(便于支持附魔)
                .add(HCArmor.ALUMINUM_LEGGINGS.get())
                .add(HCArmor.TIN_LEGGINGS.get())
                .add(HCArmor.SILVER_LEGGINGS.get())
                .add(HCArmor.POSEIDON_LEGGINGS.get())
                .add(HCArmor.ROSE_LEGGINGS.get())
                .add(HCArmor.HOLY_STEEL_LEGGINGS.get())
                .add(HCArmor.ENDER_LEGGINGS.get())
                .add(HCArmor.EMPEROR_S_LEGGINGS.get())
                .add(HCArmor.QUANTUM_LEGGINGS.get())
                .add(HCArmor.PRISMATIC_COLORFUL_LEGGINGS.get())
                .add(HCArmor.OVERWORLD_LEGGINGS.get())
                .add(HCArmor.NETHER_LEGGINGS.get())
                .add(HCArmor.END_LEGGINGS.get())
        ;
        tag(ItemTags.FOOT_ARMOR)// 属于靴子类(便于支持附魔)
                .add(HCArmor.ALUMINUM_BOOTS.get())
                .add(HCArmor.TIN_BOOTS.get())
                .add(HCArmor.SILVER_BOOTS.get())
                .add(HCArmor.POSEIDON_BOOTS.get())
                .add(HCArmor.ROSE_BOOTS.get())
                .add(HCArmor.HOLY_STEEL_BOOTS.get())
                .add(HCArmor.ENDER_BOOTS.get())
                .add(HCArmor.EMPEROR_S_BOOTS.get())
                .add(HCArmor.QUANTUM_BOOTS.get())
                .add(HCArmor.PRISMATIC_COLORFUL_BOOTS.get())
                .add(HCArmor.OVERWORLD_BOOTS.get())
                .add(HCArmor.NETHER_BOOTS.get())
                .add(HCArmor.END_BOOTS.get())
        ;


        tag(HCTags.Items.IS_FUEL)
                .add(Items.COAL)
        ;


        tag(ItemTags.TRIM_MATERIALS)
        ;

        tag(ItemTags.TRIM_TEMPLATES)
                .add(HCItems.QUANTUM_UPGRADE_TEMPLATE.get())
                .add(HCItems.PRISMATIC_COLORFUL_UPGRADE_TEMPLATE.get())
                .add(HCItems.COLLAPSING_UPGRADE_TEMPLATE.get())
                .add(HCItems.OVERWORLD_UPGRADE_TEMPLATE.get())
                .add(HCItems.NETHER_UPGRADE_TEMPLATE.get())
                .add(HCItems.END_UPGRADE_TEMPLATE.get())
        ;
    }
}
