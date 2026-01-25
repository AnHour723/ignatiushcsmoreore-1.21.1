package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/*
* 原版数据参考:
*                   皮革(护甲值)  锁链(护甲值)  铁(护甲值)   金(护甲值)   钻石(护甲值、盔甲韧性)  下届合金(护甲值、盔甲韧性、击退抗性)
 * 头盔(HELMET)          1           2         2          2               3、 2                 3、 3、 0.1(10%)
 * 胸甲(CHESTPLATE)      3           5         6          5               8、 2                 8、 3、 0.1(10%)
 * 护腿(LEGGINGS)        2           4         5          3               6、 2                 6、 3、 0.1(10%)
 * 靴子(BOOTS)           1           1         2          1               3、 2                 3、 2、 0.1(10%)
* */
public class HCArmorMaterials {
    // 量子
    public static final Holder<ArmorMaterial> QUANTUM_ARMOR_MATERIAL = register("quantum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,5);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,7);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,9);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,5);// 头盔护甲值
                attribute.put(ArmorItem.Type.BODY,11);// 全身(适用于动物盔甲)甲护甲值
                // 附魔等级-16   韧性-5   抗击退-0.2(百分比)   穿戴音效-同钻石套   修复材料-量子锭
            }), 16, 5f, 0.2f, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> HCOreItem.QUANTUM_INGOT.get());

    // 铝材质
    public static final Holder<ArmorMaterial> ALUMINUM_ARMOR_MATERIAL = register("aluminum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,2);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,6);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,6);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,2);// 头盔护甲值
            }), 8, 0, 0, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.ALUMINUM_INGOT.get());

    // 锡材质
    public static final Holder<ArmorMaterial> TIN_ARMOR_MATERIAL = register("tin",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,2);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,5);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,4);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,2);// 头盔护甲值
            }), 8, 0f, 0f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.TIN_INGOT.get());

    // 银材质
    public static final Holder<ArmorMaterial> SILVER_ARMOR_MATERIAL = register("silver",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,3);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,6);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,6);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,3);// 头盔护甲值
            }), 12, 1f, 0.1f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.SILVER_INGOT.get());

    // 海神材质
    public static final Holder<ArmorMaterial> POSEIDON_ARMOR_MATERIAL = register("poseidon",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,2);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,6);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,5);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,2);// 头盔护甲值
            }), 12, 0f, 0f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.POSEIDON_INGOT.get());

    // 玫瑰宝石材质
    public static final Holder<ArmorMaterial> ROSE_ARMOR_MATERIAL = register("rose",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,4);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,6);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,5);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,4);// 头盔护甲值
            }), 12, 1.0f, 0.2f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.ROSE_GEMSTONE.get());


    // 圣钢材质
    public static final Holder<ArmorMaterial> HOLY_STEEL_ARMOR_MATERIAL = register("holy_steel",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,3);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,7);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,6);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,3);// 头盔护甲值
            }), 15, 2.0f, 0.1f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.HOLY_STEEL_INGOT.get());

    // 末影材质
    public static final Holder<ArmorMaterial> ENDER_ARMOR_MATERIAL = register("ender",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,3);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,8);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,7);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,3);// 头盔护甲值
            }), 17, 2.0f, 0.1f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.ENDER_INGOT.get());

    // 不可见的材质
    public static final Holder<ArmorMaterial> EMPEROR_S_ARMOR_MATERIAL = register("xxx",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,3);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,8);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,7);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,3);// 头盔护甲值
            }), 18, 1.0f, 0.2f, SoundEvents.ARMOR_EQUIP_IRON, () -> HCOreItem.XXX.get());

    // 棱彩材质
    public static final Holder<ArmorMaterial> PRISMATIC_COLORFUL_ARMOR_MATERIAL = register("prismatic_colorful",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,5);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,8);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,10);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,5);// 头盔护甲值
            }), 18, 5f, 0.2f, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> HCOreItem.PRISMATIC_COLORFUL_INGOT.get());

    // 主界材质
    public static final Holder<ArmorMaterial> OVERWORLD_ARMOR_MATERIAL = register("overworld",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,5);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,10);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,12);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,5);// 头盔护甲值
            }), 20, 6f, 0.3f, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> HCOreItem.OVERWORLD_CORE.get());

    // 下界材质
    public static final Holder<ArmorMaterial> NETHER_ARMOR_MATERIAL = register("nether",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,6);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,11);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,13);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,6);// 头盔护甲值
            }), 20, 6f, 0.3f, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> HCOreItem.NETHER_CORE.get());

    // 终界材质
    public static final Holder<ArmorMaterial> END_ARMOR_MATERIAL = register("end",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS,6);// 靴子护甲值
                attribute.put(ArmorItem.Type.LEGGINGS,11);// 护腿护甲值
                attribute.put(ArmorItem.Type.CHESTPLATE,13);// 胸甲护甲值
                attribute.put(ArmorItem.Type.HELMET,6);// 头盔护甲值
            }), 22, 7f, 0.4f, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> HCOreItem.END_CORE.get());



    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantAbility, float toughness, float knockbackResistance,
                                                  Holder<SoundEvent> equipSound , Supplier<Item> ingredientItem){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for(ArmorItem.Type type : ArmorItem.Type.values()){
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantAbility, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
