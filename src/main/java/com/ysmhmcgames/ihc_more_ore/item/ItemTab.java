package com.ysmhmcgames.ihc_more_ore.item;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemTab {

    // 创建创造栏位的tab
    public static final DeferredRegister<CreativeModeTab> MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IgnatiusHCsMoreOre.MODID);

    // 创建具体tab
    //矿石tab
    public static final Supplier<CreativeModeTab> MORE_ORE_TAB = MODE_TAB.register("more_ore_tab",
            ()->CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("create_tab.more_ore_tab"))
                    .icon(()-> HCOreItem.TIN_INGOT.get().getDefaultInstance())// 以什么物品的图片作为tag
                    .displayItems(((itemDisplayParameters, output) -> {// 将物品加入该tab

                        for (Holder<Item> holder : HCOreItem.ORE_ITEMS.getEntries()) {// 遍历延迟注册器
                            output.accept(holder.value());
                        }
                        for (Holder<Block> holder : HCBlock.ORE_BLOCK.getEntries()) {
                            output.accept(holder.value());
                        }

//                        output.accept(HCOreItem.RAW_TIN.get());
//                        output.accept(HCOreItem.TIN_INGOT.get());
//                        output.accept(HCOreItem.TIN_NUGGET.get());
//                        output.accept(HCOreItem.RAW_ALUMINUM.get());
//                        output.accept(HCOreItem.ALUMINUM_INGOT.get());
//                        output.accept(HCOreItem.ALUMINUM_NUGGET.get());
//                        output.accept(HCOreItem.STEEL_INGOT.get());
//                        output.accept(HCOreItem.STEEL_NUGGET.get());
//                        output.accept(HCOreItem.ICE_CRYSTAL.get());
//                        output.accept(HCOreItem.ICE_CRYSTAL_INGOT.get());
//                        output.accept(HCOreItem.ACTIVE_FIRE.get());
//                        output.accept(HCOreItem.BLAZING_FIRE_INGOT.get());
//                        output.accept(HCOreItem.TWILIGHT_CLOUD.get());
//                        output.accept(HCOreItem.TWILIGHT_CLOUD_ELEMENT.get());
//                        output.accept(HCOreItem.TWILIGHT_CLOUD_INGOT.get());
//                        output.accept(HCOreItem.STORM_INGOT.get());
//                        output.accept(HCOreItem.CHLOROPHYLL.get());
//                        output.accept(HCOreItem.CHLOROPHYLL_CORE.get());
//                        output.accept(HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT.get());
//                        output.accept(HCOreItem.CHLOROPHYLL_INGOT.get());
//                        output.accept(HCOreItem.CHLOROPHYLL_NUGGET.get());
//                        output.accept(HCOreItem.QUANTUM_INGOT.get());
//                        output.accept(HCOreItem.XXX.get());
//                        output.accept(HCOreItem.UNSTABLE_XXX.get());
//                        output.accept(HCOreItem.RAW_TITANIUM.get());
//                        output.accept(HCOreItem.TITANIUM_INGOT.get());
//
//
//                        output.accept(HCBlock.TIN_ORE.get());
//                        output.accept(HCBlock.DEEPSLATE_TIN_ORE.get());
//                        output.accept(HCBlock.RAW_TIN_BLOCK.get());
//                        output.accept(HCBlock.TIN_BLOCK.get());
//                        output.accept(HCBlock.ALUMINUM_ORE.get());
//                        output.accept(HCBlock.DEEPSLATE_ALUMINUM_ORE.get());
//                        output.accept(HCBlock.RAW_ALUMINUM_BLOCK.get());
//                        output.accept(HCBlock.ALUMINUM_BLOCK.get());
//                        output.accept(HCBlock.STEEL_BLOCK.get());
//                        output.accept(HCBlock.TWILIGHT_CLOUD_BLOCK.get());
//                        output.accept(HCBlock.STORM_BLOCK.get());
//                        output.accept(HCBlock.CHLOROPHYLL_BLOCK.get());
//                        output.accept(HCBlock.DISGUISED_CHLOROPHYLL_ORE.get());
//                        output.accept(HCBlock.CHLOROPHYLL_ORE.get());
//                        output.accept(HCBlock.CHLOROPHYLL_INGOT_BLOCK.get());
//                        output.accept(HCBlock.QUANTUM_DOMAIN.get());
//                        output.accept(HCBlock.INVISIBLE_BLOCK.get());
//                        output.accept(HCBlock.TITANIUM_ORE.get());
//
//                        output.accept(HCBlock.DISPLAY_STAND.get());
//                        output.accept(HCBlock.ANALYSIS_ROOM_BLOCK.get());
//                        output.accept(HCBlock.ALLOY_FURNACE_CORE_BLOCK.get());
                    }))
                    .build());

    public static final Supplier<CreativeModeTab> FENG_S_TOOL_TAB = MODE_TAB.register("feng_s_tool_tab",
            ()->CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("create_tab.feng_s_tool_tab"))
                    .icon(()-> HCTools.QUANTUM_PICKAXE.get().getDefaultInstance())// 以什么物品的图片作为tag
                    .displayItems(((itemDisplayParameters, output) -> {// 将物品加入该tab

//                        output.accept(HCTools.QUANTUM_SWORD.get());
//                        output.accept(HCTools.QUANTUM_SICKLE.get());
//                        output.accept(HCTools.QUANTUM_AXE.get());
//                        output.accept(HCTools.QUANTUM_PICKAXE.get());
//                        output.accept(HCTools.QUANTUM_SHOVEL.get());
//                        output.accept(HCTools.QUANTUM_HOE.get());
                        for (Holder<Item> holder : HCTools.TOOLS.getEntries()) {// 遍历延迟注册器
                            output.accept(holder.value());
                        }
                        for (Holder<Item> holder : HCArmor.ARMOR.getEntries()) {
                            output.accept(holder.value());
                        }

                    }))
                    .build());

    public static final Supplier<CreativeModeTab> JANGTANGLALALA_S_TAB = MODE_TAB.register("jangtanglalala_s_groceries_tab",
            ()->CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("create_tab.jangtanglalala_s_groceries_tab"))
                    .icon(()-> HCItems.QUANTUM_UPGRADE_TEMPLATE.get().getDefaultInstance())// 以什么物品的图片作为tag
                    .displayItems(((itemDisplayParameters, output) -> {// 将物品加入该tab

                        for (Holder<Item> holder : HCItems.ITEMS.getEntries()) {// 遍历延迟注册器
                            output.accept(holder.value());
                        }

                    }))
                    .build());
}
