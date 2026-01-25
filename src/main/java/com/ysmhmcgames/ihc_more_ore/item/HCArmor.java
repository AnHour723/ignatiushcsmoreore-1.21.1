package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCArmor {
    // 声明总注册类型
    public static final DeferredRegister.Items ARMOR = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

    /*
         耐久:最终耐久 = 盔甲部位基数 × 耐久系数
            头盔(HELMET) => 基数(11) * 自定义系数
            胸甲(CHESTPLATE) => 基数(16) * 自定义系数
            裤腿(LEGGINGS) => 基数(15) * 自定义系数
            靴子(BOOTS) => 基数(13) * 自定义系数

            原版参数:
                皮革->5
                金->7
                铁->15
                钻石->33
                下届合金->37
    */
    // 铝装备
    public static final DeferredItem<ArmorItem> ALUMINUM_HELMET = ARMOR.register("aluminum_helmet",
            () -> new ArmorItem(HCArmorMaterials.ALUMINUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));// 耐久系数
    public static final DeferredItem<ArmorItem> ALUMINUM_CHESTPLATE = ARMOR.register("aluminum_chestplate",
            () -> new ArmorItem(HCArmorMaterials.ALUMINUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final DeferredItem<ArmorItem> ALUMINUM_LEGGINGS = ARMOR.register("aluminum_leggings",
            () -> new ArmorItem(HCArmorMaterials.ALUMINUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(16))));
    public static final DeferredItem<ArmorItem> ALUMINUM_BOOTS = ARMOR.register("aluminum_boots",
            () -> new ArmorItem(HCArmorMaterials.ALUMINUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));
    // 锡装备
    public static final DeferredItem<ArmorItem> TIN_HELMET = ARMOR.register("tin_helmet",
            () -> new ArmorItem(HCArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(14))));// 耐久系数
    public static final DeferredItem<ArmorItem> TIN_CHESTPLATE = ARMOR.register("tin_chestplate",
            () -> new ArmorItem(HCArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(14))));
    public static final DeferredItem<ArmorItem> TIN_LEGGINGS = ARMOR.register("tin_leggings",
            () -> new ArmorItem(HCArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(14))));
    public static final DeferredItem<ArmorItem> TIN_BOOTS = ARMOR.register("tin_boots",
            () -> new ArmorItem(HCArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(14))));
    // 银装备
    public static final DeferredItem<ArmorItem> SILVER_HELMET = ARMOR.register("silver_helmet",
            () -> new ArmorItem(HCArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(13))));// 耐久系数
    public static final DeferredItem<ArmorItem> SILVER_CHESTPLATE = ARMOR.register("silver_chestplate",
            () -> new ArmorItem(HCArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(13))));
    public static final DeferredItem<ArmorItem> SILVER_LEGGINGS = ARMOR.register("silver_leggings",
            () -> new ArmorItem(HCArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(13))));
    public static final DeferredItem<ArmorItem> SILVER_BOOTS = ARMOR.register("silver_boots",
            () -> new ArmorItem(HCArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(13))));

    // 海神装备
    public static final DeferredItem<ArmorItem> POSEIDON_HELMET = ARMOR.register("poseidon_helmet",
            () -> new HCArmorItem(HCArmorMaterials.POSEIDON_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));// 耐久系数
    public static final DeferredItem<ArmorItem> POSEIDON_CHESTPLATE = ARMOR.register("poseidon_chestplate",
            () -> new HCArmorItem(HCArmorMaterials.POSEIDON_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final DeferredItem<ArmorItem> POSEIDON_LEGGINGS = ARMOR.register("poseidon_leggings",
            () -> new HCArmorItem(HCArmorMaterials.POSEIDON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final DeferredItem<ArmorItem> POSEIDON_BOOTS = ARMOR.register("poseidon_boots",
            () -> new HCArmorItem(HCArmorMaterials.POSEIDON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    // 玫瑰宝石装备
    public static final DeferredItem<ArmorItem> ROSE_HELMET = ARMOR.register("rose_helmet",
            () -> new HCArmorItem(HCArmorMaterials.ROSE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(36))));// 耐久系数
    public static final DeferredItem<ArmorItem> ROSE_CHESTPLATE = ARMOR.register("rose_chestplate",
            () -> new HCArmorItem(HCArmorMaterials.ROSE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(36))));
    public static final DeferredItem<ArmorItem> ROSE_LEGGINGS = ARMOR.register("rose_leggings",
            () -> new HCArmorItem(HCArmorMaterials.ROSE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(36))));
    public static final DeferredItem<ArmorItem> ROSE_BOOTS = ARMOR.register("rose_boots",
            () -> new HCArmorItem(HCArmorMaterials.ROSE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(36))));

    // 圣钢装备
    public static final DeferredItem<ArmorItem> HOLY_STEEL_HELMET = ARMOR.register("holy_steel_helmet",
            () -> new HCArmorItem(HCArmorMaterials.HOLY_STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));// 耐久系数
    public static final DeferredItem<ArmorItem> HOLY_STEEL_CHESTPLATE = ARMOR.register("holy_steel_chestplate",
            () -> new HCArmorItem(HCArmorMaterials.HOLY_STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredItem<ArmorItem> HOLY_STEEL_LEGGINGS = ARMOR.register("holy_steel_leggings",
            () -> new HCArmorItem(HCArmorMaterials.HOLY_STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredItem<ArmorItem> HOLY_STEEL_BOOTS = ARMOR.register("holy_steel_boots",
            () -> new HCArmorItem(HCArmorMaterials.HOLY_STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));
    // 末影装备
    public static final DeferredItem<ArmorItem> ENDER_HELMET = ARMOR.register("ender_helmet",
            () -> new ArmorItem(HCArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));// 耐久系数
    public static final DeferredItem<ArmorItem> ENDER_CHESTPLATE = ARMOR.register("ender_chestplate",
            () -> new ArmorItem(HCArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredItem<ArmorItem> ENDER_LEGGINGS = ARMOR.register("ender_leggings",
            () -> new ArmorItem(HCArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredItem<ArmorItem> ENDER_BOOTS = ARMOR.register("ender_boots",
            () -> new ArmorItem(HCArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));
    // 国王的装备
    public static final DeferredItem<ArmorItem> EMPEROR_S_HELMET = ARMOR.register("emperor_s_helmet",
            () -> new ArmorItem(HCArmorMaterials.EMPEROR_S_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));// 耐久系数
    public static final DeferredItem<ArmorItem> EMPEROR_S_CHESTPLATE = ARMOR.register("emperor_s_chestplate",
            () -> new ArmorItem(HCArmorMaterials.EMPEROR_S_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredItem<ArmorItem> EMPEROR_S_LEGGINGS = ARMOR.register("emperor_s_leggings",
            () -> new ArmorItem(HCArmorMaterials.EMPEROR_S_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredItem<ArmorItem> EMPEROR_S_BOOTS = ARMOR.register("emperor_s_boots",
            () -> new ArmorItem(HCArmorMaterials.EMPEROR_S_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));


    // 量子装备
    public static final DeferredItem<ArmorItem> QUANTUM_HELMET = ARMOR.register("quantum_helmet",
            () -> new ArmorItem(HCArmorMaterials.QUANTUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(45))));// 耐久系数
    public static final DeferredItem<ArmorItem> QUANTUM_CHESTPLATE = ARMOR.register("quantum_chestplate",
            () -> new ArmorItem(HCArmorMaterials.QUANTUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));
    public static final DeferredItem<ArmorItem> QUANTUM_LEGGINGS = ARMOR.register("quantum_leggings",
            () -> new ArmorItem(HCArmorMaterials.QUANTUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));
    public static final DeferredItem<ArmorItem> QUANTUM_BOOTS = ARMOR.register("quantum_boots",
            () -> new ArmorItem(HCArmorMaterials.QUANTUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(45))));

    // 棱彩装备
    public static final DeferredItem<ArmorItem> PRISMATIC_COLORFUL_HELMET = ARMOR.register("prismatic_colorful_helmet",
            () -> new ArmorItem(HCArmorMaterials.PRISMATIC_COLORFUL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(47))));// 耐久系数
    public static final DeferredItem<ArmorItem> PRISMATIC_COLORFUL_CHESTPLATE = ARMOR.register("prismatic_colorful_chestplate",
            () -> new ArmorItem(HCArmorMaterials.PRISMATIC_COLORFUL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(47))));
    public static final DeferredItem<ArmorItem> PRISMATIC_COLORFUL_LEGGINGS = ARMOR.register("prismatic_colorful_leggings",
            () -> new ArmorItem(HCArmorMaterials.PRISMATIC_COLORFUL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(47))));
    public static final DeferredItem<ArmorItem> PRISMATIC_COLORFUL_BOOTS = ARMOR.register("prismatic_colorful_boots",
            () -> new ArmorItem(HCArmorMaterials.PRISMATIC_COLORFUL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(47))));

    // 主界装备
    public static final DeferredItem<ArmorItem> OVERWORLD_HELMET = ARMOR.register("overworld_helmet",
            () -> new ArmorItem(HCArmorMaterials.OVERWORLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));// 耐久系数
    public static final DeferredItem<ArmorItem> OVERWORLD_CHESTPLATE = ARMOR.register("overworld_chestplate",
            () -> new ArmorItem(HCArmorMaterials.OVERWORLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredItem<ArmorItem> OVERWORLD_LEGGINGS = ARMOR.register("overworld_leggings",
            () -> new ArmorItem(HCArmorMaterials.OVERWORLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredItem<ArmorItem> OVERWORLD_BOOTS = ARMOR.register("overworld_boots",
            () -> new ArmorItem(HCArmorMaterials.OVERWORLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    // 下界装备
    public static final DeferredItem<ArmorItem> NETHER_HELMET = ARMOR.register("nether_helmet",
            () -> new ArmorItem(HCArmorMaterials.NETHER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(60))));// 耐久系数
    public static final DeferredItem<ArmorItem> NETHER_CHESTPLATE = ARMOR.register("nether_chestplate",
            () -> new ArmorItem(HCArmorMaterials.NETHER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(60))));
    public static final DeferredItem<ArmorItem> NETHER_LEGGINGS = ARMOR.register("nether_leggings",
            () -> new ArmorItem(HCArmorMaterials.NETHER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(60))));
    public static final DeferredItem<ArmorItem> NETHER_BOOTS = ARMOR.register("nether_boots",
            () -> new ArmorItem(HCArmorMaterials.NETHER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(60))));

    // 终界装备
    public static final DeferredItem<ArmorItem> END_HELMET = ARMOR.register("end_helmet",
            () -> new ArmorItem(HCArmorMaterials.END_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(70))));// 耐久系数
    public static final DeferredItem<ArmorItem> END_CHESTPLATE = ARMOR.register("end_chestplate",
            () -> new ArmorItem(HCArmorMaterials.END_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(70))));
    public static final DeferredItem<ArmorItem> END_LEGGINGS = ARMOR.register("end_leggings",
            () -> new ArmorItem(HCArmorMaterials.END_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(70))));
    public static final DeferredItem<ArmorItem> END_BOOTS = ARMOR.register("end_boots",
            () -> new ArmorItem(HCArmorMaterials.END_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(70))));


    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ARMOR.register(iEventBus);
    }
}
