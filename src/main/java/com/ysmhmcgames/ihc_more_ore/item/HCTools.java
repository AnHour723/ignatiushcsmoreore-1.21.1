package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.tools.SickleItem;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.blazing_fire.BlazingFireBow;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.blazing_fire.BlazingFireSickle;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.blazing_fire.BlazingFireSword;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.chlorophyll.*;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.ice_crystal.IceCrystalBow;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.ice_crystal.IceCrystalSickle;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.ice_crystal.IceCrystalSword;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.pole.PoleBowItem;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.storm.StormBow;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.storm.StormSickle;
import com.ysmhmcgames.ihc_more_ore.item.tools.custom.storm.StormSword;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


/*
原版代码参考：
* public static final Item STONE_SWORD = registerItem(
        "stone_sword", new SwordItem(Tiers.STONE, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.STONE, 3, -2.4F)))
    );
    public static final Item STONE_SHOVEL = registerItem(
        "stone_shovel", new ShovelItem(Tiers.STONE, new Item.Properties().attributes(ShovelItem.createAttributes(Tiers.STONE, 1.5F, -3.0F)))
    );
    public static final Item STONE_PICKAXE = registerItem(
        "stone_pickaxe", new PickaxeItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 1.0F, -2.8F)))
    );
    public static final Item STONE_AXE = registerItem(
        "stone_axe", new AxeItem(Tiers.STONE, new Item.Properties().attributes(AxeItem.createAttributes(Tiers.STONE, 7.0F, -3.2F)))
    );
    public static final Item STONE_HOE = registerItem(
        "stone_hoe", new HoeItem(Tiers.STONE, new Item.Properties().attributes(HoeItem.createAttributes(Tiers.STONE, -1.0F, -2.0F)))
* */

public class HCTools {
    // 声明总注册类型
    public static final DeferredRegister.Items TOOLS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

    // 创建铝工具
    public static final DeferredItem<SickleItem> ALUMINUM_SICKLE = TOOLS.register("aluminum_sickle",
            ()-> new SickleItem(HCToolTiers.ALUMINUM, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.ALUMINUM,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> ALUMINUM_SWORD = TOOLS.register("aluminum_sword",
            ()-> new SwordItem(HCToolTiers.ALUMINUM, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.ALUMINUM,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> ALUMINUM_PICKAXE = TOOLS.register("aluminum_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.ALUMINUM, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.ALUMINUM,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> ALUMINUM_SHOVEL = TOOLS.register("aluminum_shovel",
            ()-> new ShovelItem(HCToolTiers.ALUMINUM, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.ALUMINUM,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> ALUMINUM_AXE = TOOLS.register("aluminum_axe",
            ()-> new AxeItem(HCToolTiers.ALUMINUM, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.ALUMINUM,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> ALUMINUM_HOE = TOOLS.register("aluminum_hoe",
            ()-> new HoeItem(HCToolTiers.ALUMINUM, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.ALUMINUM,-1.0f,-2.0f))));

    // 创建锡工具
    public static final DeferredItem<SickleItem> TIN_SICKLE = TOOLS.register("tin_sickle",
            ()-> new SickleItem(HCToolTiers.TIN, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.TIN,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> TIN_SWORD = TOOLS.register("tin_sword",
            ()-> new SwordItem(HCToolTiers.TIN, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.TIN,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> TIN_PICKAXE = TOOLS.register("tin_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.TIN, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.TIN,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> TIN_SHOVEL = TOOLS.register("tin_shovel",
            ()-> new ShovelItem(HCToolTiers.TIN, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.TIN,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> TIN_AXE = TOOLS.register("tin_axe",
            ()-> new AxeItem(HCToolTiers.TIN, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.TIN,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> TIN_HOE = TOOLS.register("tin_hoe",
            ()-> new HoeItem(HCToolTiers.TIN, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.TIN,-1.0f,-2.0f))));

    // 创建钢工具
    public static final DeferredItem<SickleItem> STEEL_SICKLE = TOOLS.register("steel_sickle",
            ()-> new SickleItem(HCToolTiers.STEEL, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.STEEL,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> STEEL_SWORD = TOOLS.register("steel_sword",
            ()-> new SwordItem(HCToolTiers.STEEL, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.STEEL,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE = TOOLS.register("steel_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.STEEL, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.STEEL,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = TOOLS.register("steel_shovel",
            ()-> new ShovelItem(HCToolTiers.STEEL, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.STEEL,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> STEEL_AXE = TOOLS.register("steel_axe",
            ()-> new AxeItem(HCToolTiers.STEEL, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.STEEL,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> STEEL_HOE = TOOLS.register("steel_hoe",
            ()-> new HoeItem(HCToolTiers.STEEL, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.STEEL,-1.0f,-2.0f))));

    // 创建银工具
    public static final DeferredItem<SickleItem> SILVER_SICKLE = TOOLS.register("silver_sickle",
            ()-> new SickleItem(HCToolTiers.SILVER, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.SILVER,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> SILVER_SWORD = TOOLS.register("silver_sword",
            ()-> new SwordItem(HCToolTiers.SILVER, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.SILVER,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> SILVER_PICKAXE = TOOLS.register("silver_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.SILVER, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.SILVER,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> SILVER_SHOVEL = TOOLS.register("silver_shovel",
            ()-> new ShovelItem(HCToolTiers.SILVER, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.SILVER,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> SILVER_AXE = TOOLS.register("silver_axe",
            ()-> new AxeItem(HCToolTiers.SILVER, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.SILVER,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> SILVER_HOE = TOOLS.register("silver_hoe",
            ()-> new HoeItem(HCToolTiers.SILVER, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.SILVER,-1.0f,-2.0f))));

    // 创建寒晶工具
    public static final DeferredItem<SickleItem> ICE_CRYSTAL_SICKLE = TOOLS.register("ice_crystal_sickle",
            ()-> new IceCrystalSickle(HCToolTiers.ICE_CRYSTAL, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.ICE_CRYSTAL,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> ICE_CRYSTAL_SWORD = TOOLS.register("ice_crystal_sword",
            ()-> new IceCrystalSword(HCToolTiers.ICE_CRYSTAL, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.ICE_CRYSTAL,3.0f,-2.4f))));
    public static final DeferredItem<Item> ICE_CRYSTAL_BOW = TOOLS.register("ice_crystal_bow",
            () -> new IceCrystalBow(new Item.Properties().durability(555)));
    // 创建烈炎工具
    public static final DeferredItem<SickleItem> BLAZING_FIRE_SICKLE = TOOLS.register("blazing_fire_sickle",
            ()-> new BlazingFireSickle(HCToolTiers.BLAZING_FIRE, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.BLAZING_FIRE,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> BLAZING_FIRE_SWORD = TOOLS.register("blazing_fire_sword",
            ()-> new BlazingFireSword(HCToolTiers.BLAZING_FIRE, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.BLAZING_FIRE,3.0f,-2.4f))));
    public static final DeferredItem<Item> BLAZING_FIRE_BOW = TOOLS.register("blazing_fire_bow",
            () -> new BlazingFireBow(new Item.Properties().durability(555)));
    // 创建风暴工具
    public static final DeferredItem<SickleItem> STORM_SICKLE = TOOLS.register("storm_sickle",
            ()-> new StormSickle(HCToolTiers.STORM, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.STORM,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> STORM_SWORD = TOOLS.register("storm_sword",
            ()-> new StormSword(HCToolTiers.STORM, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.STORM,3.0f,-2.4f))));
    public static final DeferredItem<Item> STORM_BOW = TOOLS.register("storm_bow",
            () -> new StormBow(new Item.Properties().durability(666)));

    // 创建提拉马工具
    public static final DeferredItem<SickleItem> TILAMA_SICKLE = TOOLS.register("tilama_sickle",
            ()-> new SickleItem(HCToolTiers.TILAMA, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.TILAMA,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> TILAMA_SWORD = TOOLS.register("tilama_sword",
            ()-> new SwordItem(HCToolTiers.TILAMA, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.TILAMA,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> TILAMA_PICKAXE = TOOLS.register("tilama_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.TILAMA, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.TILAMA,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> TILAMA_SHOVEL = TOOLS.register("tilama_shovel",
            ()-> new ShovelItem(HCToolTiers.TILAMA, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.TILAMA,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> TILAMA_AXE = TOOLS.register("tilama_axe",
            ()-> new AxeItem(HCToolTiers.TILAMA, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.TILAMA,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> TILAMA_HOE = TOOLS.register("tilama_hoe",
            ()-> new HoeItem(HCToolTiers.TILAMA, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.TILAMA,-1.0f,-2.0f))));

    // 创建红宝石工具
    public static final DeferredItem<SwordItem> RUBY_SWORD = TOOLS.register("ruby_sword",
            ()-> new SwordItem(HCToolTiers.RUBY, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.RUBY,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> RUBY_PICKAXE = TOOLS.register("ruby_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.RUBY, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.RUBY,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> RUBY_SHOVEL = TOOLS.register("ruby_shovel",
            ()-> new ShovelItem(HCToolTiers.RUBY, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.RUBY,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> RUBY_AXE = TOOLS.register("ruby_axe",
            ()-> new AxeItem(HCToolTiers.RUBY, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.RUBY,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> RUBY_HOE = TOOLS.register("ruby_hoe",
            ()-> new HoeItem(HCToolTiers.RUBY, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.RUBY,-1.0f,-2.0f))));

    // 创建叶绿工具
    public static final DeferredItem<SickleItem> CHLOROPHYLL_SICKLE = TOOLS.register("chlorophyll_sickle",
            ()-> new ChlorophyllSickle(HCToolTiers.CHLOROPHYLL, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.CHLOROPHYLL,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> CHLOROPHYLL_SWORD = TOOLS.register("chlorophyll_sword",
            ()-> new ChlorophyllSword(HCToolTiers.CHLOROPHYLL, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.CHLOROPHYLL,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> CHLOROPHYLL_PICKAXE = TOOLS.register("chlorophyll_pickaxe",
            ()-> new ChlorophyllPickaxe(HCToolTiers.CHLOROPHYLL, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.CHLOROPHYLL,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> CHLOROPHYLL_SHOVEL = TOOLS.register("chlorophyll_shovel",
            ()-> new ChlorophyllShovel(HCToolTiers.CHLOROPHYLL, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.CHLOROPHYLL,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> CHLOROPHYLL_AXE = TOOLS.register("chlorophyll_axe",
            ()-> new ChlorophyllAxe(HCToolTiers.CHLOROPHYLL, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.CHLOROPHYLL,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> CHLOROPHYLL_HOE = TOOLS.register("chlorophyll_hoe",
            ()-> new ChlorophyllHoe(HCToolTiers.CHLOROPHYLL, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.CHLOROPHYLL,-1.0f,-2.0f))));

    // 创建海神工具
    public static final DeferredItem<SickleItem> POSEIDON_SICKLE = TOOLS.register("poseidon_sickle",
            ()-> new SickleItem(HCToolTiers.POSEIDON, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.POSEIDON,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> POSEIDON_SWORD = TOOLS.register("poseidon_sword",
            ()-> new SwordItem(HCToolTiers.POSEIDON, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.POSEIDON,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> POSEIDON_PICKAXE = TOOLS.register("poseidon_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.POSEIDON, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.POSEIDON,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> POSEIDON_SHOVEL = TOOLS.register("poseidon_shovel",
            ()-> new ShovelItem(HCToolTiers.POSEIDON, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.POSEIDON,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> POSEIDON_AXE = TOOLS.register("poseidon_axe",
            ()-> new AxeItem(HCToolTiers.POSEIDON, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.POSEIDON,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> POSEIDON_HOE = TOOLS.register("poseidon_hoe",
            ()-> new HoeItem(HCToolTiers.POSEIDON, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.POSEIDON,-1.0f,-2.0f))));

    // 创建钛工具
    public static final DeferredItem<SickleItem> TITANIUM_SICKLE = TOOLS.register("titanium_sickle",
            ()-> new SickleItem(HCToolTiers.TITANIUM, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.TITANIUM,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> TITANIUM_SWORD = TOOLS.register("titanium_sword",
            ()-> new SwordItem(HCToolTiers.TITANIUM, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.TITANIUM,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> TITANIUM_PICKAXE = TOOLS.register("titanium_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.TITANIUM, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.TITANIUM,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> TITANIUM_SHOVEL = TOOLS.register("titanium_shovel",
            ()-> new ShovelItem(HCToolTiers.TITANIUM, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.TITANIUM,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> TITANIUM_AXE = TOOLS.register("titanium_axe",
            ()-> new AxeItem(HCToolTiers.TITANIUM, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.TITANIUM,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> TITANIUM_HOE = TOOLS.register("titanium_hoe",
            ()-> new HoeItem(HCToolTiers.TITANIUM, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.TITANIUM,-1.0f,-2.0f))));

    // 创建元祖工具
    public static final DeferredItem<SickleItem> PRECURSOR_SICKLE = TOOLS.register("precursor_sickle",
            ()-> new SickleItem(HCToolTiers.PRECURSOR, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.PRECURSOR,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> PRECURSOR_SWORD = TOOLS.register("precursor_sword",
            ()-> new SwordItem(HCToolTiers.PRECURSOR, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.PRECURSOR,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> PRECURSOR_PICKAXE = TOOLS.register("precursor_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.PRECURSOR, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.PRECURSOR,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> PRECURSOR_SHOVEL = TOOLS.register("precursor_shovel",
            ()-> new ShovelItem(HCToolTiers.PRECURSOR, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.PRECURSOR,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> PRECURSOR_AXE = TOOLS.register("precursor_axe",
            ()-> new AxeItem(HCToolTiers.PRECURSOR, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.PRECURSOR,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> PRECURSOR_HOE = TOOLS.register("precursor_hoe",
            ()-> new HoeItem(HCToolTiers.PRECURSOR, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.PRECURSOR,-1.0f,-2.0f))));

    // 创建狱炎工具
    public static final DeferredItem<SickleItem> HELL_S_SICKLE = TOOLS.register("hell_s_sickle",
            ()-> new SickleItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.HELL_S,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> HELL_S_SWORD = TOOLS.register("hell_s_sword",
            ()-> new SwordItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.HELL_S,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> HELL_S_PICKAXE = TOOLS.register("hell_s_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.HELL_S,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> HELL_S_SHOVEL = TOOLS.register("hell_s_shovel",
            ()-> new ShovelItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.HELL_S,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> HELL_S_AXE = TOOLS.register("hell_s_axe",
            ()-> new AxeItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.HELL_S,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> HELL_S_HOE = TOOLS.register("hell_s_hoe",
            ()-> new HoeItem(HCToolTiers.HELL_S, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.HELL_S,-1.0f,-2.0f))));


    // 创建玫瑰宝石工具
    public static final DeferredItem<SwordItem> ROSE_SWORD = TOOLS.register("rose_sword",
            ()-> new SwordItem(HCToolTiers.ROSE, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.ROSE,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> ROSE_PICKAXE = TOOLS.register("rose_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.ROSE, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.ROSE,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> ROSE_SHOVEL = TOOLS.register("rose_shovel",
            ()-> new ShovelItem(HCToolTiers.ROSE, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.ROSE,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> ROSE_AXE = TOOLS.register("rose_axe",
            ()-> new AxeItem(HCToolTiers.ROSE, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.ROSE,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> ROSE_HOE = TOOLS.register("rose_hoe",
            ()-> new HoeItem(HCToolTiers.ROSE, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.ROSE,-1.0f,-2.0f))));


    // 创建紫罗兰工具
    public static final DeferredItem<SwordItem> VIOLET_SWORD = TOOLS.register("violet_sword",
            ()-> new SwordItem(HCToolTiers.VIOLET, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.VIOLET,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> VIOLET_PICKAXE = TOOLS.register("violet_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.VIOLET, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.VIOLET,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> VIOLET_SHOVEL = TOOLS.register("violet_shovel",
            ()-> new ShovelItem(HCToolTiers.VIOLET, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.VIOLET,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> VIOLET_AXE = TOOLS.register("violet_axe",
            ()-> new AxeItem(HCToolTiers.VIOLET, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.VIOLET,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> VIOLET_HOE = TOOLS.register("violet_hoe",
            ()-> new HoeItem(HCToolTiers.VIOLET, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.VIOLET,-1.0f,-2.0f))));

    // 创建黑晶工具
    public static final DeferredItem<SwordItem> BLACK_CRYSTALS_SWORD = TOOLS.register("black_crystals_sword",
            ()-> new SwordItem(HCToolTiers.BLACK_CRYSTALS, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.BLACK_CRYSTALS,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> BLACK_CRYSTALS_PICKAXE = TOOLS.register("black_crystals_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.BLACK_CRYSTALS, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.BLACK_CRYSTALS,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> BLACK_CRYSTALS_SHOVEL = TOOLS.register("black_crystals_shovel",
            ()-> new ShovelItem(HCToolTiers.BLACK_CRYSTALS, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.BLACK_CRYSTALS,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> BLACK_CRYSTALS_AXE = TOOLS.register("black_crystals_axe",
            ()-> new AxeItem(HCToolTiers.BLACK_CRYSTALS, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.BLACK_CRYSTALS,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> BLACK_CRYSTALS_HOE = TOOLS.register("black_crystals_hoe",
            ()-> new HoeItem(HCToolTiers.BLACK_CRYSTALS, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.BLACK_CRYSTALS,-1.0f,-2.0f))));

    // 创建国王的工具
    public static final DeferredItem<SwordItem> EMPEROR_S_SWORD = TOOLS.register("emperor_s_sword",
            ()-> new SwordItem(HCToolTiers.INVISIBLE, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.INVISIBLE,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> EMPEROR_S_PICKAXE = TOOLS.register("emperor_s_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.INVISIBLE, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.INVISIBLE,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> EMPEROR_S_SHOVEL = TOOLS.register("emperor_s_shovel",
            ()-> new ShovelItem(HCToolTiers.INVISIBLE, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.INVISIBLE,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> EMPEROR_S_AXE = TOOLS.register("emperor_s_axe",
            ()-> new AxeItem(HCToolTiers.INVISIBLE, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.INVISIBLE,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> EMPEROR_S_HOE = TOOLS.register("emperor_s_hoe",
            ()-> new HoeItem(HCToolTiers.INVISIBLE, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.INVISIBLE,-1.0f,-2.0f))));

    // 创建量子工具
    public static final DeferredItem<SickleItem> QUANTUM_SICKLE = TOOLS.register("quantum_sickle",
            ()-> new SickleItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.QUANTUM,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> QUANTUM_SWORD = TOOLS.register("quantum_sword",
            ()-> new SwordItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.QUANTUM,3.0f,-1.5f))));
    public static final DeferredItem<PickaxeItem> QUANTUM_PICKAXE = TOOLS.register("quantum_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.QUANTUM,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> QUANTUM_SHOVEL = TOOLS.register("quantum_shovel",
            ()-> new ShovelItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.QUANTUM,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> QUANTUM_AXE = TOOLS.register("quantum_axe",
            ()-> new AxeItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.QUANTUM,10.0f,-3.8f))));
    public static final DeferredItem<HoeItem> QUANTUM_HOE = TOOLS.register("quantum_hoe",
            ()-> new HoeItem(HCToolTiers.QUANTUM, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.QUANTUM,-1.0f,-2.0f))));


    // 创建圣钢工具
    public static final DeferredItem<BowItem> HOLY_STEEL_BOW = TOOLS.register("holy_steel_bow",
            ()-> new BowItem(new Item.Properties().durability(1000)));
    public static final DeferredItem<SwordItem> HOLY_STEEL_SWORD = TOOLS.register("holy_steel_sword",
            ()-> new SwordItem(HCToolTiers.HOLY_STEEL, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.HOLY_STEEL,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> HOLY_STEEL_PICKAXE = TOOLS.register("holy_steel_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.HOLY_STEEL, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.HOLY_STEEL,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> HOLY_STEEL_SHOVEL = TOOLS.register("holy_steel_shovel",
            ()-> new ShovelItem(HCToolTiers.HOLY_STEEL, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.HOLY_STEEL,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> HOLY_STEEL_AXE = TOOLS.register("holy_steel_axe",
            ()-> new AxeItem(HCToolTiers.HOLY_STEEL, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.HOLY_STEEL,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> HOLY_STEEL_HOE = TOOLS.register("holy_steel_hoe",
            ()-> new HoeItem(HCToolTiers.HOLY_STEEL, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.HOLY_STEEL,-1.0f,-2.0f))));

    // 创建狱炎工具
    public static final DeferredItem<SickleItem> SOUL_SICKLE = TOOLS.register("soul_sickle",
            ()-> new SickleItem(HCToolTiers.SOUL, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.SOUL,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> SOUL_SWORD = TOOLS.register("soul_sword",
            ()-> new SwordItem(HCToolTiers.SOUL, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.SOUL,3.0f,-2.4f))));

    // 创建末影工具
    public static final DeferredItem<SickleItem> ENDER_SICKLE = TOOLS.register("ender_sickle",
            ()-> new SickleItem(HCToolTiers.ENDER, new Item.Properties()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.ENDER,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> ENDER_SWORD = TOOLS.register("ender_sword",
            ()-> new SwordItem(HCToolTiers.ENDER, new Item.Properties()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.ENDER,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> ENDER_PICKAXE = TOOLS.register("ender_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.ENDER, new Item.Properties()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.ENDER,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> ENDER_SHOVEL = TOOLS.register("ender_shovel",
            ()-> new ShovelItem(HCToolTiers.ENDER, new Item.Properties()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.ENDER,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> ENDER_AXE = TOOLS.register("ender_axe",
            ()-> new AxeItem(HCToolTiers.ENDER, new Item.Properties()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.ENDER,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> ENDER_HOE = TOOLS.register("ender_hoe",
            ()-> new HoeItem(HCToolTiers.ENDER, new Item.Properties()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.ENDER,-1.0f,-2.0f))));

    // 创建棱彩工具
    public static final DeferredItem<SickleItem> PRISMATIC_COLORFUL_SICKLE = TOOLS.register("prismatic_colorful_sickle",
            ()-> new SickleItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,3.0f,-0.5f))));
    public static final DeferredItem<SwordItem> PRISMATIC_COLORFUL_SWORD = TOOLS.register("prismatic_colorful_sword",
            ()-> new SwordItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,5.0f,-1.0f))));
    public static final DeferredItem<PickaxeItem> PRISMATIC_COLORFUL_PICKAXE = TOOLS.register("prismatic_colorful_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> PRISMATIC_COLORFUL_SHOVEL = TOOLS.register("prismatic_colorful_shovel",
            ()-> new ShovelItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> PRISMATIC_COLORFUL_AXE = TOOLS.register("prismatic_colorful_axe",
            ()-> new AxeItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,10.0f,-3.8f))));
    public static final DeferredItem<HoeItem> PRISMATIC_COLORFUL_HOE = TOOLS.register("prismatic_colorful_hoe",
            ()-> new HoeItem(HCToolTiers.PRISMATIC_COLORFUL, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.PRISMATIC_COLORFUL,-1.0f,-2.0f))));


    // 创建主界工具
    public static final DeferredItem<SwordItem> OVERWORLD_SWORD = TOOLS.register("overworld_sword",
            ()-> new SwordItem(HCToolTiers.OVERWORLD, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.OVERWORLD,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> OVERWORLD_PICKAXE = TOOLS.register("overworld_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.OVERWORLD, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.OVERWORLD,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> OVERWORLD_SHOVEL = TOOLS.register("overworld_shovel",
            ()-> new ShovelItem(HCToolTiers.OVERWORLD, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.OVERWORLD,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> OVERWORLD_AXE = TOOLS.register("overworld_axe",
            ()-> new AxeItem(HCToolTiers.OVERWORLD, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.OVERWORLD,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> OVERWORLD_HOE = TOOLS.register("overworld_hoe",
            ()-> new HoeItem(HCToolTiers.OVERWORLD, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.OVERWORLD,-1.0f,-2.0f))));

    // 创建坍缩工具
    public static final DeferredItem<SickleItem> COLLAPSING_SICKLE = TOOLS.register("collapsing_sickle",
            ()-> new SickleItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.COLLAPSING,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> COLLAPSING_SWORD = TOOLS.register("collapsing_sword",
            ()-> new SwordItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.COLLAPSING,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> COLLAPSING_PICKAXE = TOOLS.register("collapsing_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.COLLAPSING,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> COLLAPSING_SHOVEL = TOOLS.register("collapsing_shovel",
            ()-> new ShovelItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.COLLAPSING,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> COLLAPSING_AXE = TOOLS.register("collapsing_axe",
            ()-> new AxeItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.COLLAPSING,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> COLLAPSING_HOE = TOOLS.register("collapsing_hoe",
            ()-> new HoeItem(HCToolTiers.COLLAPSING, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.COLLAPSING,-1.0f,-2.0f))));
    // 创建下界工具
    public static final DeferredItem<SickleItem> NETHER_SICKLE = TOOLS.register("nether_sickle",
            ()-> new SickleItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// SickleItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SickleItem.createAttributes(HCToolTiers.NETHER,2.0f,-1.0f))));
    public static final DeferredItem<SwordItem> NETHER_SWORD = TOOLS.register("nether_sword",
            ()-> new SwordItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.NETHER,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> NETHER_PICKAXE = TOOLS.register("nether_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.NETHER,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> NETHER_SHOVEL = TOOLS.register("nether_shovel",
            ()-> new ShovelItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.NETHER,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> NETHER_AXE = TOOLS.register("nether_axe",
            ()-> new AxeItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.NETHER,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> NETHER_HOE = TOOLS.register("nether_hoe",
            ()-> new HoeItem(HCToolTiers.NETHER, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.NETHER,-1.0f,-2.0f))));

    // 创建终界工具
    public static final DeferredItem<SwordItem> END_SWORD = TOOLS.register("end_sword",
            ()-> new SwordItem(HCToolTiers.END, new Item.Properties().fireResistant()// SwordItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(SwordItem.createAttributes(HCToolTiers.END,3.0f,-2.4f))));
    public static final DeferredItem<PickaxeItem> END_PICKAXE = TOOLS.register("end_pickaxe",
            ()-> new PickaxeItem(HCToolTiers.END, new Item.Properties().fireResistant()// PickaxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(PickaxeItem.createAttributes(HCToolTiers.END,1.0f,-2.0f))));
    public static final DeferredItem<ShovelItem> END_SHOVEL = TOOLS.register("end_shovel",
            ()-> new ShovelItem(HCToolTiers.END, new Item.Properties().fireResistant()// ShovelItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(ShovelItem.createAttributes(HCToolTiers.END,1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> END_AXE = TOOLS.register("end_axe",
            ()-> new AxeItem(HCToolTiers.END, new Item.Properties().fireResistant()// AxeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(AxeItem.createAttributes(HCToolTiers.END,7.0f,-3.2f))));
    public static final DeferredItem<HoeItem> END_HOE = TOOLS.register("end_hoe",
            ()-> new HoeItem(HCToolTiers.END, new Item.Properties().fireResistant()// HoeItem()第一个参数为矿石模组工具等级，第二个参数为属性方法
                    .attributes(HoeItem.createAttributes(HCToolTiers.END,-1.0f,-2.0f))));


    // 两级工具
    public static final DeferredItem<Item> POLE_BOW = TOOLS.register("pole_bow",
            () -> new PoleBowItem(new Item.Properties().fireResistant().durability(777)));
    public static final DeferredItem<Item> YIN_ARROW = TOOLS.register("yin_arrow",
            () -> new ArrowItem(new Item.Properties()));
    public static final DeferredItem<Item> YANG_ARROW = TOOLS.register("yang_arrow",
            () -> new ArrowItem(new Item.Properties()));

    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        TOOLS.register(iEventBus);
    }
}
