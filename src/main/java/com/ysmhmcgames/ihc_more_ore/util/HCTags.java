package com.ysmhmcgames.ihc_more_ore.util;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HCTags {
    public static class Blocks{
        // 创建 下届合金等级tag (5级)
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createTag("needs_netherite_tool");

        // 创建 量子等级tag (6级)
        public static final TagKey<Block> NEEDS_QUANTUM_TOOL = createTag("needs_quantum_tool");
        public static final TagKey<Block> INCORRECT_FOR_QUANTUM_TOOL = createTag("incorrect_for_quantum_tool");

        // 创建 主界矿等级tag (7级)
        public static final TagKey<Block> NEEDS_OVERWORLD_TOOL = createTag("needs_overworld_tool");
        public static final TagKey<Block> INCORRECT_FOR_OVERWORLD_TOOL = createTag("incorrect_for_overworld_tool");

        // 创建 下界矿等级tag (8级)
        public static final TagKey<Block> NEEDS_NETHER_TOOL = createTag("needs_nether_tool");
        public static final TagKey<Block> INCORRECT_FOR_NETHER_TOOL = createTag("incorrect_for_nether_tool");

        // 创建 终界矿等级tag (9级)
        public static final TagKey<Block> NEEDS_END_TOOL = createTag("needs_end_tool");
        public static final TagKey<Block> INCORRECT_FOR_END_TOOL = createTag("incorrect_for_end_tool");

        // 创建 终极等级等级tag (10级)
        public static final TagKey<Block> NEEDS_ULTIMATE_TOOL = createTag("needs_ultimate_tool");
        public static final TagKey<Block> INCORRECT_FOR_ULTIMATE_TOOL = createTag("incorrect_for_ultimate_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,name));
        }
    }
    public static class Items{
        // 创建一个tag
        public static final TagKey<Item> MORE_ORE = createTag("more_ore");


        public static final TagKey<Item> SICKLE = createTag("sickle");


        public static final TagKey<Item> GLASS_KEY = createTag("glass_key");

        public static final TagKey<Item> IS_FUEL = createTag("is_fuel");

        public static final TagKey<Item> IS_BLUEPRINT = createTag("is_blueprint");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,name));
        }
    }
}

