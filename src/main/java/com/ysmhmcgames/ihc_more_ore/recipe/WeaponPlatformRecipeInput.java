package com.ysmhmcgames.ihc_more_ore.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record WeaponPlatformRecipeInput(NonNullList<ItemStack> input) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return this.input.get(index);
    }

    public List<ItemStack> getList(){
        return this.input;
    }

    @Override
    public int size() {
        return this.input.size();
    }
}