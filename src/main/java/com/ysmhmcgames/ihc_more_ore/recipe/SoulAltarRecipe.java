package com.ysmhmcgames.ihc_more_ore.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public record SoulAltarRecipe(List<Ingredient> inputItem, ItemStack output) implements Recipe<SoulAltarRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        for(int i=0;i<inputItem.size();i++){
            list.add(inputItem.get(i));
        }
        return list;
    }

    @Override
    public boolean matches(SoulAltarRecipeInput soulAltarRecipeInput, Level level) {
        if(level.isClientSide()){
            return false;
        }
        // 获取输入槽位的8个物品
        List<ItemStack> inputSlots = soulAltarRecipeInput.getList(); // 8个槽位
        List<Ingredient> recipeIngredients = this.inputItem; // JSON配方要求的物品集合

        return hasExactIngredients(inputSlots, recipeIngredients);// 自定义方法: 判断输入槽放置物品是否和配方一样

    }

    private boolean hasExactIngredients(List<ItemStack> inputSlots, List<Ingredient> recipeIngredients) {
        // 创建可修改的副本用于匹配
        List<ItemStack> slotCopy = new ArrayList<>(inputSlots);
        List<Ingredient> ingredientCopy = new ArrayList<>(recipeIngredients);

        // 移除所有空槽位
        slotCopy.removeIf(ItemStack::isEmpty);

        // 检查数量是否匹配
        if (slotCopy.size() != ingredientCopy.size()) {
            //System.out.println("物品数量不匹配: 输入=" + slotCopy.size() + ", 需要=" + ingredientCopy.size());
            return false;
        }

        // 进行有序匹配
        return matchIngredientsOrdered(slotCopy, ingredientCopy);// 自定义方法:
    }
    /**
     * 有序匹配 - 物品必须按照相同的顺序和位置匹配
     * @param inputItems 输入槽位物品（已过滤空槽）
     * @param recipeIngredients 配方要求物品
     * @return 是否完全匹配
     */
    private boolean matchIngredientsOrdered(List<ItemStack> inputItems, List<Ingredient> recipeIngredients) {
        // 确保列表大小相同
        if (inputItems.size() != recipeIngredients.size()) {
            return false;
        }

        // 遍历所有位置，进行一对一匹配
        for (int i = 0; i < inputItems.size(); i++) {
            ItemStack inputStack = inputItems.get(i);
            Ingredient requiredIngredient = recipeIngredients.get(i);

            // 如果当前位置不匹配，则失败
            if (!requiredIngredient.test(inputStack)) {
                return false;
            }
        }

        // 所有位置都匹配成功
        return true;
    }





    @Override
    public ItemStack assemble(SoulAltarRecipeInput soulAltarRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HCRecipes.SOUL_ALTAR_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return HCRecipes.SOUL_ALTAR_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<SoulAltarRecipe>{
        public static final MapCodec<SoulAltarRecipe> CODEC = RecordCodecBuilder.mapCodec(ins -> ins.group(
                Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
                    NonNullList<Ingredient> nonNullList = NonNullList.create();
                    nonNullList.addAll(ingredients);
                    return nonNullList;
                }, ingredients -> ingredients).forGetter(SoulAltarRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(SoulAltarRecipe::output)
        ).apply(ins,SoulAltarRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf,SoulAltarRecipe> STREAM_CODEC =
                StreamCodec.of(SoulAltarRecipe.Serializer::toNetwork, SoulAltarRecipe.Serializer::fromNetwork);

        private static SoulAltarRecipe fromNetwork(RegistryFriendlyByteBuf buffer){
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

            inputItemsIn.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

            ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
            return new SoulAltarRecipe(inputItemsIn,outputIn);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, SoulAltarRecipe recipe){

            buf.writeVarInt(recipe.inputItem.size());
            for (Ingredient ingredient : recipe.inputItem)
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
        }


        @Override
        public MapCodec<SoulAltarRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SoulAltarRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

}