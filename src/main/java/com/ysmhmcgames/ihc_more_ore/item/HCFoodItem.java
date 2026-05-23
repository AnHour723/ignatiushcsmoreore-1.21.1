package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import com.ysmhmcgames.ihc_more_ore.item.food.FlashGoldFoodItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCFoodItem {
    // 声明总注册类型
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

//    // 闪金牛排
//    public static final DeferredItem<Item> FLASH_GOLD_BEEF = ITEMS.register("flash_gold_beef",
//            // nutrition -> 营养(增加的饱食度)    saturationModifier -> 饱和度(回血的相关值)[计算为营养值 * 倍率]
//            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(1.75f).fast().effect(
//                    // duration -> 持续时间    probability -> 概率
//                    () -> new MobEffectInstance(MobEffects.GLOWING, 600), 1.0f
//            ).build())));

    // 闪金熟牛排
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_BEEF = ITEMS.register("flash_gold_cooked_beef",
            // nutrition -> 营养(增加的饱食度)    saturationModifier -> 饱和度(回血的相关值)[计算为营养值 * 倍率]
            ()-> new FlashGoldFoodItem(new Item.Properties(),10,1.75f));
    // 闪金熟羊排
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_MUTTON = ITEMS.register("flash_gold_cooked_mutton",
            ()-> new FlashGoldFoodItem(new Item.Properties(),8,1.75f));
    // 闪金熟猪排
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_PORKCHOP = ITEMS.register("flash_gold_cooked_porkchop",
            ()-> new FlashGoldFoodItem(new Item.Properties(),10,2f));
    // 闪金熟鸡肉
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_CHICKEN = ITEMS.register("flash_gold_cooked_chicken",
            ()-> new FlashGoldFoodItem(new Item.Properties(),8,1.5f));
    // 闪金熟兔肉
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_RABBIT = ITEMS.register("flash_gold_cooked_rabbit",
            ()-> new FlashGoldFoodItem(new Item.Properties(),7,1.5f));
    // 闪金熟鳕鱼
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_COD = ITEMS.register("flash_gold_cooked_cod",
            ()-> new FlashGoldFoodItem(new Item.Properties(),7,1.5f));
    // 闪金熟鲑鱼
    public static final DeferredItem<Item> FLASH_GOLD_COOKED_SALMON = ITEMS.register("flash_gold_cooked_salmon",
            ()-> new FlashGoldFoodItem(new Item.Properties(),8,1.75f));
    // 闪金面包
    public static final DeferredItem<Item> FLASH_GOLD_BREAD = ITEMS.register("flash_gold_bread",
            ()-> new FlashGoldFoodItem(new Item.Properties(),7,1.75f));
    // 闪金烤马铃薯
    public static final DeferredItem<Item> FLASH_GOLD_BAKED_POTATO = ITEMS.register("flash_gold_baked_potato",
            ()-> new FlashGoldFoodItem(new Item.Properties(),4,2f));
    // 闪金甜菜根
    public static final DeferredItem<Item> FLASH_GOLD_BEETROOT = ITEMS.register("flash_gold_beetroot",
            ()-> new FlashGoldFoodItem(new Item.Properties(),2,1.75f));
    // 闪金西瓜片
    public static final DeferredItem<Item> FLASH_GOLD_MELON_SLICE = ITEMS.register("flash_gold_melon_slice",
            ()-> new FlashGoldFoodItem(new Item.Properties(),4,2f));
    // 闪金干海带
    public static final DeferredItem<Item> FLASH_GOLD_DRIED_KELP = ITEMS.register("flash_gold_dried_kelp",
            ()-> new FlashGoldFoodItem(new Item.Properties(),2,1.5f));
    // 闪金曲奇
    public static final DeferredItem<Item> FLASH_GOLD_COOKIE = ITEMS.register("flash_gold_cookie",
            ()-> new FlashGoldFoodItem(new Item.Properties(),5,0.5f));
    // 闪金河豚
    public static final DeferredItem<Item> FLASH_GOLD_PUFFERFISH = ITEMS.register("flash_gold_pufferfish",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(1f).alwaysEdible().fast().effect(
                    // duration -> 持续时间    probability -> 概率
                    () -> new MobEffectInstance(MobEffects.POISON, 600), 0.3f
            ).effect(
                    () -> new MobEffectInstance(MobEffects.REGENERATION, 600), 0.4f
            ).effect(
                    () -> new MobEffectInstance(MobEffects.GLOWING, 600), 1.0f
            ).effect(
                    () -> new MobEffectInstance(HCEffects.GLISTENING_EFFECT, 600), 1.0f
            ).build())));



    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
