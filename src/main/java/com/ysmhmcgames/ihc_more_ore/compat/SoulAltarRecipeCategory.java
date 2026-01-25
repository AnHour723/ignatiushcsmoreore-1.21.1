package com.ysmhmcgames.ihc_more_ore.compat;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.recipe.SoulAltarRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulAltarRecipeCategory implements IRecipeCategory<SoulAltarRecipe> {
    private static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"soul_altar");
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/soul_altar_gui.png");


    public static final RecipeType<SoulAltarRecipe> SOUL_ALTAR_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, SoulAltarRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SoulAltarRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);// 创建背景  长为非背包部分ui长，宽为图宽
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(HCBlock.SOUL_ALTAR));// 类型为原版物品栈堆  设置配方图标
    }

    @Override
    public RecipeType<SoulAltarRecipe> getRecipeType() {
        return SOUL_ALTAR_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {// 配方名显示
        return Component.translatable("block.ignatiushcsmoreore.soul_altar");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SoulAltarRecipe recipe, IFocusGroup focuses) {// 设置配方(显示)
//        builder.addSlot(RecipeIngredientRole.INPUT, 80, 5).addIngredients(recipe.getIngredients().get(0));
//        builder.addSlot(RecipeIngredientRole.INPUT, 106, 11).addIngredients(recipe.getIngredients().get(1));
//        builder.addSlot(RecipeIngredientRole.INPUT, 115, 35).addIngredients(recipe.getIngredients().get(2));
//        builder.addSlot(RecipeIngredientRole.INPUT, 106, 57).addIngredients(recipe.getIngredients().get(3));
//        builder.addSlot(RecipeIngredientRole.INPUT, 80, 65).addIngredients(recipe.getIngredients().get(4));
//        builder.addSlot(RecipeIngredientRole.INPUT, 54, 57).addIngredients(recipe.getIngredients().get(5));
//        builder.addSlot(RecipeIngredientRole.INPUT, 45, 35).addIngredients(recipe.getIngredients().get(6));
//        builder.addSlot(RecipeIngredientRole.INPUT, 54, 11).addIngredients(recipe.getIngredients().get(7));

//        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 35).addItemStack(recipe.getResultItem(null));

        // 获取配料列表
        NonNullList<Ingredient> ingredients = recipe.getIngredients();


        // 定义槽位位置
        int[][] slotPositions = {
                {80, 5},   // 顶部
                {106, 11}, // 右上
                {115, 35}, // 右
                {106, 57}, // 右下
                {80, 65},  // 底部
                {54, 57},  // 左下
                {45, 35},  // 左
                {54, 11}   // 左上
        };

        // 安全地添加输入槽位
        for (int i = 0; i < Math.min(ingredients.size(), 8); i++) {
            Ingredient ingredient = ingredients.get(i);
            int[] pos = slotPositions[i];

            if (!ingredient.isEmpty()) {
                builder.addSlot(RecipeIngredientRole.INPUT, pos[0], pos[1])
                        .addIngredients(ingredient);
            }
        }

        // 添加输出槽位
        ItemStack result = recipe.getResultItem(null);
        if (!result.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 35)
                    .addItemStack(result);
        }


    }
    // 提供默认配料（可选）
    private List<Ingredient> getDefaultIngredients() {
        // 返回一个默认的配料列表
        NonNullList<Ingredient> defaults = NonNullList.create();
        defaults.add(Ingredient.of(Items.COBBLESTONE));  // 示例默认值
        return defaults;
    }


    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    //    @Override
//    public void draw(SoulAltarRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
//        background.draw(guiGraphics);// 绘制背景图
//    }
}
