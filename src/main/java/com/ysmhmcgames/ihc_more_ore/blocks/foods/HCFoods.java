package com.ysmhmcgames.ihc_more_ore.blocks.foods;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block.WeaponPlatform;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCFoods {
    public static final DeferredRegister.Blocks FOOD_BLOCK = DeferredRegister.createBlocks(IgnatiusHCsMoreOre.MODID);
    public static final DeferredRegister.Items FOODS = DeferredRegister.createItems(IgnatiusHCsMoreOre.MODID);


    // 矿石糖稀块
    public static final DeferredBlock<Block> CHIDE = registerBlock("ore_sugar_syrup_block",
            ()->new FoodBlock(BlockBehaviour.Properties.of().strength(1.0f).noOcclusion().noLootTable()));





    // 同步注册方块item
    private static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        FOODS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // 方块注册方法
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> blocks = FOOD_BLOCK.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    public static void register(IEventBus eventBus) {
        FOODS.register(eventBus);
        FOOD_BLOCK.register(eventBus);
    }

}
