package com.ysmhmcgames.ihc_more_ore.screen;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.screen.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, IgnatiusHCsMoreOre.MODID);

    // 注册置物台菜单
    public static final DeferredHolder<MenuType<?>, MenuType<DisplayStandMenu>> DISPLAY_STAND_MENU =
            registerMenuType("display_stand_menu", DisplayStandMenu::new);
    // 注册解析室菜单
    public static final DeferredHolder<MenuType<?>, MenuType<AnalysisRoomMenu>> ANALYSIS_ROOM_MENU =
            registerMenuType("analysis_room_menu", AnalysisRoomMenu::new);
    // 注册合金熔炉核心菜单
    public static final DeferredHolder<MenuType<?>, MenuType<AlloyFurnaceCoreMenu>> ALLOY_FURNACE_CORE_MENU =
            registerMenuType("alloy_furnace_core_menu", AlloyFurnaceCoreMenu::new);

    // 注册灵魂祭坛菜单
    public static final DeferredHolder<MenuType<?>, MenuType<SoulAltarMenu>> SOUL_ALTAR_MENU =
            registerMenuType("soul_altar_menu", SoulAltarMenu::new);

    // 注册武器台菜单
    public static final DeferredHolder<MenuType<?>, MenuType<WeaponPlatformMenu>> WEAPON_PLATFORM_MENU =
            registerMenuType("weapon_platform_menu", WeaponPlatformMenu::new);


    public static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>,MenuType<T>> registerMenuType(String name,
                                                                                                            IContainerFactory<T> factory){
        return MENUS.register(name,() -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
