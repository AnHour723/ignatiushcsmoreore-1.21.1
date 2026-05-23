package com.ysmhmcgames.ihc_more_ore.item.food;

import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FlashGoldFoodItem extends Item {
    public FlashGoldFoodItem(Properties properties, int nutrition, float saturationModifier) {
        super(properties.food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationModifier).fast().effect(
                // duration -> 持续时间    probability -> 概率
                () -> new MobEffectInstance(MobEffects.GLOWING, 600), 1.0f
        ).effect(
                // duration -> 持续时间    probability -> 概率
                () -> new MobEffectInstance(HCEffects.GLISTENING_EFFECT, 600), 1.0f
        ).build()));
    }
}
