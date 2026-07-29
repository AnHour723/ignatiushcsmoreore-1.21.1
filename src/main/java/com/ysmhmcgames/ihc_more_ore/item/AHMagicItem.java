package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.*;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AHMagicItem {
    // 声明总注册类型
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);

    // 闪金窥基
    public static final DeferredItem<Item> FLASH_GOLD_ENDOSCOPE = ITEMS.register("flash_gold_endoscope",
            ()-> new FlashGoldEndoscope(new Item.Properties().stacksTo(1)));

    // 量子徽章
    public static final DeferredItem<Item> QUANTUM_BADGE = ITEMS.register("quantum_badge",
            ()-> new QuantumBadge(new Item.Properties().stacksTo(1)));


    // 木骰子
    public static final DeferredItem<Item> WOODEN_MAGIC_DICE = ITEMS.register("wooden_magic_dice",
            ()-> new WoodenMagicDice(new Item.Properties().stacksTo(1)));
    // 铁骰子
    public static final DeferredItem<Item> IRON_MAGIC_DICE = ITEMS.register("iron_magic_dice",
            ()-> new IronMagicDice(new Item.Properties().stacksTo(1)));
    // 钻石骰子
    public static final DeferredItem<Item> DIAMOND_MAGIC_DICE = ITEMS.register("diamond_magic_dice",
            ()-> new DiamondMagicDice(new Item.Properties().stacksTo(1)));
    // 下界合金骰子
    public static final DeferredItem<Item> NETHERITE_MAGIC_DICE = ITEMS.register("netherite_magic_dice",
            ()-> new NetheriteMagicDice(new Item.Properties().stacksTo(1)));
    // 量子骰子
    public static final DeferredItem<Item> QUANTUM_MAGIC_DICE = ITEMS.register("quantum_magic_dice",
            ()-> new QuantumMagicDice(new Item.Properties().stacksTo(1)));
    // 闪金骰子
    public static final DeferredItem<Item> FLASH_GOLD_MAGIC_DICE = ITEMS.register("flash_gold_magic_dice",
            ()-> new FlashGoldMagicDice(new Item.Properties().stacksTo(1)));
    // 黑晶骰子
    public static final DeferredItem<Item> BLACK_CRYSTALS_MAGIC_DICE = ITEMS.register("black_crystals_magic_dice",
            ()-> new BlackCrystalsMagicDice(new Item.Properties().stacksTo(1)));
    // 红莲骰子
    public static final DeferredItem<Item> RED_LOTUS_MAGIC_DICE = ITEMS.register("red_lotus_magic_dice",
            ()-> new RedLotusMagicDice(new Item.Properties().stacksTo(1)));
    // 末影骰子
    public static final DeferredItem<Item> ENDER_MAGIC_DICE = ITEMS.register("ender_magic_dice",
            ()-> new EnderMagicDice(new Item.Properties().stacksTo(1)));

    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
