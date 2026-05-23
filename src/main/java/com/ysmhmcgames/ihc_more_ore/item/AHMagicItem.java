package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.FlashGoldEndoscope;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.QuantumBadge;
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


    // 创建注册方法，之后到主类中进行bus注册
    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
