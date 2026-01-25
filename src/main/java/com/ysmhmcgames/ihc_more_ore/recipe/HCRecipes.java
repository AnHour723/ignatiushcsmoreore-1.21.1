package com.ysmhmcgames.ihc_more_ore.recipe;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCRecipes {
    // 配方序列化器总类注册
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, IgnatiusHCsMoreOre.MODID);
    // 配方类型总类注册
    public static final DeferredRegister<RecipeType<?>> TYPE =
            DeferredRegister.create(Registries.RECIPE_TYPE, IgnatiusHCsMoreOre.MODID);

    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<AnalysisRoomRecipe>> ANALYSIS_ROOM_SERIALIZER =
            SERIALIZER.register("analysis_room", AnalysisRoomRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>,RecipeType<AnalysisRoomRecipe>> ANALYSIS_ROOM_TYPE =
            TYPE.register("analysis_room",() -> new RecipeType<AnalysisRoomRecipe>() {
                @Override
                public String toString() {// 重写toString()方法
                    return "analysis_room";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<AlloyFurnaceCoreRecipe>> FURNACE_CORE_SERIALIZER =
            SERIALIZER.register("furnace_core", AlloyFurnaceCoreRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>,RecipeType<AlloyFurnaceCoreRecipe>> FURNACE_CORE_TYPE =
            TYPE.register("furnace_core",() -> new RecipeType<AlloyFurnaceCoreRecipe>() {
                @Override
                public String toString() {// 重写toString()方法
                    return "furnace_core";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<FuelRecipe>> FUEL_SERIALIZER =
            SERIALIZER.register("combustible_material", FuelRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>,RecipeType<FuelRecipe>> FUEL_TYPE =
            TYPE.register("combustible_material",() -> new RecipeType<FuelRecipe>() {
                @Override
                public String toString() {// 重写toString()方法
                    return "combustible_material";
                }
            });


    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<SoulAltarRecipe>> SOUL_ALTAR_SERIALIZER =
            SERIALIZER.register("soul_altar", SoulAltarRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>,RecipeType<SoulAltarRecipe>> SOUL_ALTAR_TYPE =
            TYPE.register("soul_altar",() -> new RecipeType<>() {
                @Override
                public String toString() {// 重写toString()方法
                    return "soul_altar";
                }
            });


    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<WeaponPlatformRecipe>> WEAPON_PLATFORM_SERIALIZER =
            SERIALIZER.register("weapon_platform", WeaponPlatformRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>,RecipeType<WeaponPlatformRecipe>> WEAPON_PLATFORM_TYPE =
            TYPE.register("weapon_platform",() -> new RecipeType<>() {
                @Override
                public String toString() {// 重写toString()方法
                    return "weapon_platform";
                }
            });


    public static void register(IEventBus eventBus){
        SERIALIZER.register(eventBus);
        TYPE.register(eventBus);
    }

}
