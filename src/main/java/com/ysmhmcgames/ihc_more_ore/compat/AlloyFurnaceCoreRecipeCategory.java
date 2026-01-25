package com.ysmhmcgames.ihc_more_ore.compat;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.recipe.AlloyFurnaceCoreRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class AlloyFurnaceCoreRecipeCategory implements IRecipeCategory<AlloyFurnaceCoreRecipe> {
    private static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"alloy_furnace_core");
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/alloy_furnace_core/alloy_furnace_core_gui.png");


    public static final RecipeType<AlloyFurnaceCoreRecipe> ALLOY_FURNACE_CORE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, AlloyFurnaceCoreRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AlloyFurnaceCoreRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);// 创建背景  长为非背包部分ui长，宽为图宽
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(HCBlock.ALLOY_FURNACE_CORE_BLOCK));// 类型为原版物品栈堆  设置配方图标
    }


    @Override
    public RecipeType<AlloyFurnaceCoreRecipe> getRecipeType() {
        return ALLOY_FURNACE_CORE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ignatiushcsmoreore.alloy_furnace_core");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AlloyFurnaceCoreRecipe recipe, IFocusGroup focuses) {

        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int count = ingredients.size();
        for (int i = 0; i < count; i++) {
            if (count <= 5) {
                Ingredient ingredient = ingredients.get(i);
                // 安全地添加输入槽位
                if (!ingredient.isEmpty()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, 26 + i * 18, 15)
                            .addIngredients(ingredient);
                }
            } else {
                Ingredient ingredient = ingredients.get(i);
                // 安全地添加输入槽位
                if (!ingredient.isEmpty()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, 26 + i % 5 * 18, 15 + 18)
                            .addIngredients(ingredient);
                }
            }


            builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 60).addItemStack(recipe.getResultItem(null));


        }
    }
    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

//    @Override
//    public void draw(AlloyFurnaceCoreRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
//        background.draw(guiGraphics);// 绘制背景图
//    }

}
