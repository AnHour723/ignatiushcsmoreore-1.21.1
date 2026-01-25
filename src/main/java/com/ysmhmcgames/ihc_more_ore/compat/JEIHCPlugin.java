package com.ysmhmcgames.ihc_more_ore.compat;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.recipe.*;
import com.ysmhmcgames.ihc_more_ore.screen.custom.AlloyFurnaceCoreScreen;
import com.ysmhmcgames.ihc_more_ore.screen.custom.AnalysisRoomScreen;
import com.ysmhmcgames.ihc_more_ore.screen.custom.SoulAltarScreen;
import com.ysmhmcgames.ihc_more_ore.screen.custom.WeaponPlatformScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIHCPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {// 注册Categories方法
        // 灵魂祭坛
        registration.addRecipeCategories(new SoulAltarRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
        // 合金炉
        registration.addRecipeCategories(new AlloyFurnaceCoreRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
        // 解析室
        registration.addRecipeCategories(new AnalysisRoomRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
        // 武器台
        registration.addRecipeCategories(new WeaponPlatformCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        // jei 灵魂祭坛配方
        List<SoulAltarRecipe> soulAltarRecipes = recipeManager
                .getAllRecipesFor(HCRecipes.SOUL_ALTAR_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(SoulAltarRecipeCategory.SOUL_ALTAR_RECIPE_RECIPE_TYPE, soulAltarRecipes);

        // jei 合金炉配方
        List<AlloyFurnaceCoreRecipe> alloyFurnaceCoreRecipes = recipeManager
                .getAllRecipesFor(HCRecipes.FURNACE_CORE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(AlloyFurnaceCoreRecipeCategory.ALLOY_FURNACE_CORE_RECIPE_RECIPE_TYPE, alloyFurnaceCoreRecipes);

        // jei 解析室
        List<AnalysisRoomRecipe> analysisRoomRecipes = recipeManager
                .getAllRecipesFor(HCRecipes.ANALYSIS_ROOM_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(AnalysisRoomRecipeCategory.ANALYSIS_ROOM_RECIPE_RECIPE_TYPE, analysisRoomRecipes);

        // jei 武器台
        List<WeaponPlatformRecipe> weaponPlatformRecipes = recipeManager
                .getAllRecipesFor(HCRecipes.WEAPON_PLATFORM_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(WeaponPlatformCategory.WEAPON_PLATFORM_RECIPE_RECIPE_TYPE, weaponPlatformRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {// 点击箭头可以跳转该配方类型所有配方

        // 调转合金炉配方
        registration.addRecipeClickArea(AlloyFurnaceCoreScreen.class, 137, 16, 17, 28,
                AlloyFurnaceCoreRecipeCategory.ALLOY_FURNACE_CORE_RECIPE_RECIPE_TYPE);
        // 调转解析室配方
        registration.addRecipeClickArea(AnalysisRoomScreen.class, 80, 28, 17, 31,
                AnalysisRoomRecipeCategory.ANALYSIS_ROOM_RECIPE_RECIPE_TYPE);
        // 调转武器套配方
        registration.addRecipeClickArea(WeaponPlatformScreen.class, 123, 29, 24, 24,
                WeaponPlatformCategory.WEAPON_PLATFORM_RECIPE_RECIPE_TYPE);
    }
}
