package com.ysmhmcgames.ihc_more_ore.compat;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.recipe.WeaponPlatformRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeaponPlatformCategory implements IRecipeCategory<WeaponPlatformRecipe> {
    private static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"weapon_platform");
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/weapon_platform_gui.png");


    public static final RecipeType<WeaponPlatformRecipe> WEAPON_PLATFORM_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, WeaponPlatformRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;


    public WeaponPlatformCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);// 创建背景  长为非背包部分ui长，宽为图宽
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(HCBlock.WEAPON_PLATFORM));// 类型为原版物品栈堆  设置配方图标

    }

    @Override
    public RecipeType<WeaponPlatformRecipe> getRecipeType() {
        return WEAPON_PLATFORM_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ignatiushcsmoreore.weapon_platform");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WeaponPlatformRecipe recipe, IFocusGroup focuses) {
        NonNullList<Ingredient> ingredients = recipe.getIngredients();

        // 定义槽位位置
        int[][] slotPositions = {
                {8, 33},   // 顶部
                {44, 33}, // 右上
                {80, 33}, // 右
                {80, 15}, // 右下
                {98, 15},  // 底部
                {98, 33},  // 左下
                {98, 51},  // 左
                {80, 51}   // 左上
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
            builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 33)
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

}
