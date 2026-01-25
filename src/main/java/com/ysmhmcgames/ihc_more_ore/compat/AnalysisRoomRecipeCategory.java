package com.ysmhmcgames.ihc_more_ore.compat;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.recipe.AnalysisRoomRecipe;
import com.ysmhmcgames.ihc_more_ore.recipe.SoulAltarRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class AnalysisRoomRecipeCategory implements IRecipeCategory<AnalysisRoomRecipe> {
    private static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"analysis_room");
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/analysis_room_gui.png");


    public static final RecipeType<AnalysisRoomRecipe> ANALYSIS_ROOM_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, AnalysisRoomRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AnalysisRoomRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);// 创建背景  长为非背包部分ui长，宽为图宽
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(HCBlock.ANALYSIS_ROOM_BLOCK));// 类型为原版物品栈堆  设置配方图标
    }


    @Override
    public RecipeType<AnalysisRoomRecipe> getRecipeType() {
        return ANALYSIS_ROOM_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ignatiushcsmoreore.analysis_room_block");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AnalysisRoomRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 35).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 105, 35).addItemStack(recipe.getResultItem(null));
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }


}
