package com.ysmhmcgames.ihc_more_ore.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record FuelRecipe(Ingredient inputItem, int fuelValue) implements Recipe<FuelRecipeInput> {
    @Override
    public boolean matches(FuelRecipeInput fuelRecipeInput, Level level) {
        if(level.isClientSide()){// 如果层级是客户端 则返回false
            return false;
        }
        return inputItem.test(fuelRecipeInput.getItem(0));// 直接判断 inputItem(也就是从配方里读取的配方里输入物品) 是否和方块实体中物品匹配
    }

    @Override
    public ItemStack assemble(FuelRecipeInput fuelRecipeInput, HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HCRecipes.FUEL_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return HCRecipes.FUEL_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<FuelRecipe> {
        // 编码器 -> 读取JSON
        // 流编码器 -> 网络层面进行传输

        public static final MapCodec<FuelRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(FuelRecipe::inputItem),
                Codec.INT.fieldOf("burning_time").forGetter(FuelRecipe::fuelValue)
        ).apply(inst,FuelRecipe::new));


        public static final StreamCodec<RegistryFriendlyByteBuf,FuelRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, FuelRecipe::inputItem,
                        ByteBufCodecs.INT, FuelRecipe::fuelValue,
                        FuelRecipe::new
                );

        @Override
        public MapCodec<FuelRecipe> codec() { // 编码器
            return CODEC;// 直接返回编码器即可
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FuelRecipe> streamCodec() {// 流编码器
            return STREAM_CODEC;
        }
    }

}
