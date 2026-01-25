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

// 若要输入多个物品 创建 无空列表即可NonNullList<Ingredient> inputItem
public record AnalysisRoomRecipe(Ingredient inputItem, ItemStack output, int analysisTime) implements Recipe<AnalysisRoomRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() { //
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    // matches()方法可以直接用于判断是否读取到配方
    @Override
    public boolean matches(AnalysisRoomRecipeInput analysisRoomRecipeInput, Level level) {// 决定了文件的读取输出,以及库存输入是否匹配
        if(level.isClientSide()){// 如果层级是客户端 则返回false
            return false;
        }
        return inputItem.test(analysisRoomRecipeInput.getItem(0));// 直接判断 inputItem(也就是从配方里读取的配方里输入物品) 是否和方块实体中物品匹配
    }

    @Override
    public ItemStack assemble(AnalysisRoomRecipeInput analysisRoomRecipeInput, HolderLookup.Provider provider) {
        return output.copy();// 返回输出物品即可
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;// 返回true即可
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;// 这里获取结果物品就是输出物品本身
    }

    @Override
    public RecipeSerializer<?> getSerializer() {// 序列化器
        return HCRecipes.ANALYSIS_ROOM_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {// 配方类型
        return HCRecipes.ANALYSIS_ROOM_TYPE.get();
    }

    // 我们在配方类中创建一个静态类 用于序列化器
    public static class Serializer implements RecipeSerializer<AnalysisRoomRecipe> {
        // 编码器 -> 读取JSON
        // 流编码器 -> 网络层面进行传输

        /* 该编码器会自动生成一个AnalysisRoomRecipe实例，生成规则如下:
            在JSON文件内部，他会寻找"ingredient"字段(这是JSON文件中输入或成分的名称),这将被创建为输入项  -->  就是将JSON文本里 ingredient 字段下的内容赋值给前文的 inputItem
            同时JSON文件中还会有一个 结果(result) 字段 会被创建为输出项  -->  就是将JSON文本里 result 字段下的内容赋值给前文的 output
            JSON文件中还会有一个 时间(analysis_time) 字段 会被创建为int项  -->  就是将JSON文本里 analysis_time 字段下的内容赋值给前文的 analysisTime
        */
        public static final MapCodec<AnalysisRoomRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(AnalysisRoomRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(AnalysisRoomRecipe::output),
                Codec.INT.fieldOf("analysis_time").forGetter(AnalysisRoomRecipe::analysisTime)
        ).apply(inst,AnalysisRoomRecipe::new));

        /*
        * 创建流编码器:
        *   流编码器的作用是让服务器和客服端也能够同步通信
        * */
        public static final StreamCodec<RegistryFriendlyByteBuf,AnalysisRoomRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, AnalysisRoomRecipe::inputItem,
                        ItemStack.STREAM_CODEC, AnalysisRoomRecipe::output,
                        ByteBufCodecs.INT, AnalysisRoomRecipe::analysisTime,
                        AnalysisRoomRecipe::new
                );

        @Override
        public MapCodec<AnalysisRoomRecipe> codec() { // 编码器
            return CODEC;// 直接返回编码器即可
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AnalysisRoomRecipe> streamCodec() {// 流编码器
            return STREAM_CODEC;
        }
    }

}
