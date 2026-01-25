package com.ysmhmcgames.ihc_more_ore.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public record AlloyFurnaceCoreRecipe(List<Ingredient> inputItem, ItemStack output) implements Recipe<AlloyFurnaceCoreRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        for(int i=0;i<inputItem.size();i++){
            list.add(inputItem.get(i));
        }
        return list;
    }

    @Override
    public boolean matches(AlloyFurnaceCoreRecipeInput alloyFurnaceCoreRecipeInput, Level level) {
        if(level.isClientSide()){
            return false;
        }
        // 获取输入槽位的10个物品
        List<ItemStack> inputSlots = alloyFurnaceCoreRecipeInput.getList(); // 10个槽位
        List<Ingredient> recipeIngredients = this.inputItem; // JSON配方要求的物品集合

        // 调试信息
        // System.out.println("配方需要物品数: " + recipeIngredients.size() + " | 输入槽位物品数: " + inputSlots.size());

        return hasExactIngredients(inputSlots, recipeIngredients);// 自定义方法: 判断输入槽放置物品是否和配方一样

//      return inputItem.get(0).test(alloyFurnaceCoreRecipeInput.getItem(0));
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

        // 进行无序匹配
        return matchIngredientsUnordered(slotCopy, ingredientCopy);// 自定义方法:
    }

    /**
     * 无序匹配算法：检查两个列表是否包含相同的物品（忽略顺序）
     */
    private boolean matchIngredientsUnordered(List<ItemStack> inputItems, List<Ingredient> recipeIngredients) {
        // 如果都为空，直接返回false
        if (inputItems.isEmpty() && recipeIngredients.isEmpty()) {
            return false;
        }

        // 创建标记数组，记录配方物品是否已匹配
        boolean[] matched = new boolean[recipeIngredients.size()];
        int matchCount = 0;

        // 遍历每个输入物品，尝试匹配配方物品
        for (ItemStack inputItem : inputItems) {
            boolean foundMatch = false;

            for (int i = 0; i < recipeIngredients.size(); i++) {
                if (!matched[i] && recipeIngredients.get(i).test(inputItem)) {
                    // 找到匹配，标记为已匹配
                    matched[i] = true;
                    matchCount++;
                    foundMatch = true;
                    break;
                }
            }

            // 如果输入物品没有匹配任何配方物品，返回false
            if (!foundMatch) {
                // System.out.println("未匹配的物品: " + inputItem.getItem());
                return false;
            }
        }

        // 检查是否所有配方物品都匹配了
        boolean result = (matchCount == recipeIngredients.size());
        // System.out.println("匹配结果: " + result + " (匹配数: " + matchCount + ")");
        return result;
    }


    @Override
    public ItemStack assemble(AlloyFurnaceCoreRecipeInput alloyFurnaceCoreRecipeInput, HolderLookup.Provider provider) {
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
        return HCRecipes.FURNACE_CORE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return HCRecipes.FURNACE_CORE_TYPE.get();
    }
    public static class Serializer implements RecipeSerializer<AlloyFurnaceCoreRecipe>{

        public static final MapCodec<AlloyFurnaceCoreRecipe> CODEC = RecordCodecBuilder.mapCodec(ins -> ins.group(
                Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
                    NonNullList<Ingredient> nonNullList = NonNullList.create();
                    nonNullList.addAll(ingredients);
                    return nonNullList;
                }, ingredients -> ingredients).forGetter(AlloyFurnaceCoreRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(AlloyFurnaceCoreRecipe::output)
        ).apply(ins,AlloyFurnaceCoreRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf,AlloyFurnaceCoreRecipe> STREAM_CODEC =
                StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        private static AlloyFurnaceCoreRecipe fromNetwork(RegistryFriendlyByteBuf buffer){
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

            inputItemsIn.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

            ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
            return new AlloyFurnaceCoreRecipe(inputItemsIn,outputIn);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, AlloyFurnaceCoreRecipe recipe){

            buf.writeVarInt(recipe.inputItem.size());
            for (Ingredient ingredient : recipe.inputItem)
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
        }


        @Override
        public MapCodec<AlloyFurnaceCoreRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AlloyFurnaceCoreRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

}
