package com.ysmhmcgames.ihc_more_ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.HCBlockEntity;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.renderer.AnalysisRoomBlockEntityRenderer;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.renderer.DisplayStandEntityRenderer;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.renderer.SoulAltarRenderer;
import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;
import com.ysmhmcgames.ihc_more_ore.entity.HCEntities;
import com.ysmhmcgames.ihc_more_ore.entity.client.YangProjectileRenderer;
import com.ysmhmcgames.ihc_more_ore.entity.client.YinProjectileModel;
import com.ysmhmcgames.ihc_more_ore.entity.client.YinProjectileRenderer;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItem;
import com.ysmhmcgames.ihc_more_ore.item.HCArmor;
import com.ysmhmcgames.ihc_more_ore.screen.HCMenuTypes;
import com.ysmhmcgames.ihc_more_ore.screen.custom.*;
import com.ysmhmcgames.ihc_more_ore.util.HCItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.List;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = IgnatiusHCsMoreOre.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = IgnatiusHCsMoreOre.MODID, value = Dist.CLIENT)
public class IgnatiusHCsMoreOreClient {
    public IgnatiusHCsMoreOreClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {// 服务端初始化代码

            HCItemProperties.addCustomItemProperties();

            // 设置半透明渲染层
            ItemBlockRenderTypes.setRenderLayer(HCBlock.QUANTUM_DOMAIN.get(),
                    RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(HCBlock.ANALYSIS_ROOM_BLOCK.get(),
                    RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(HCBlock.INVISIBLE_BLOCK.get(),
                    RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(HCBlock.TWILIGHT_CLOUD_ELEMENT.get(),
                    RenderType.translucent());

            EntityRenderers.register(HCEntities.YIN_ARROW.get(), YinProjectileRenderer::new);
            EntityRenderers.register(HCEntities.YANG_ARROW.get(), YangProjectileRenderer::new);



            // 注册自定义谓词 "dice_data"
//            ItemProperties.register(
//                    AHMagicItem.FLASH_GOLD_MAGIC_DICE.get(), // 你的物品
//                    ResourceLocation.parse("ignatiushcsmoreore:dice_data"), // 谓词名称
//                    (stack, level, entity, seed) -> {
//                        // 从 Data Component 读取 dice_data 值
//                        Integer value = stack.get(HCComponents.DICE_DATA.get());
//                        // 如果组件存在，返回对应的浮点数（1.0 ~ 6.0）
//                        // 如果不存在，返回 0.0（fallback）
//                        return value != null ? value.floatValue() : 0.0f;
//                    }
//            );
            List<Item> diceItems = List.of(
                    AHMagicItem.WOODEN_MAGIC_DICE.get(),
                    AHMagicItem.IRON_MAGIC_DICE.get(),
                    AHMagicItem.DIAMOND_MAGIC_DICE.get(),
                    AHMagicItem.NETHERITE_MAGIC_DICE.get(),
                    AHMagicItem.QUANTUM_MAGIC_DICE.get(),
                    AHMagicItem.FLASH_GOLD_MAGIC_DICE.get(),
                    AHMagicItem.BLACK_CRYSTALS_MAGIC_DICE.get(),
                    AHMagicItem.RED_LOTUS_MAGIC_DICE.get(),
                    AHMagicItem.ENDER_MAGIC_DICE.get()
            );
            // 为每个物品注册同一个自定义谓词 "dice_data"
            for (Item item : diceItems) {
                ItemProperties.register(
                        item, // 你的物品
                        ResourceLocation.parse("ignatiushcsmoreore:dice_data"), // 谓词名称
                        (stack, level, entity, seed) -> {
                            // 从 Data Component 读取 dice_data 值
                            Integer value = stack.get(HCComponents.DICE_DATA.get());
                            // 如果组件存在，返回对应的浮点数（1.0 ~ 6.0）
                            // 如果不存在，返回 0.0（fallback）
                            return value != null ? value.floatValue() : 0.0f;
                        }
                );
            }


        });

    }


    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(HCBlockEntity.DISPLAY_STAND_ENTITY.get(),DisplayStandEntityRenderer::new);
        event.registerBlockEntityRenderer(HCBlockEntity.ANALYSIS_ROOM_BLOCK_ENTITY.get(), AnalysisRoomBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(HCBlockEntity.SOUL_ALTAR_ENTITY.get(), SoulAltarRenderer::new);
    }

    @SubscribeEvent
    public static void registerScreen(RegisterMenuScreensEvent event){
        event.register(HCMenuTypes.DISPLAY_STAND_MENU.get(), DisplayStandScreen::new);
        event.register(HCMenuTypes.ANALYSIS_ROOM_MENU.get(), AnalysisRoomScreen::new);
        event.register(HCMenuTypes.ALLOY_FURNACE_CORE_MENU.get(), AlloyFurnaceCoreScreen::new);
        event.register(HCMenuTypes.SOUL_ALTAR_MENU.get(), SoulAltarScreen::new);
        event.register(HCMenuTypes.WEAPON_PLATFORM_MENU.get(), WeaponPlatformScreen::new);
    }

}
