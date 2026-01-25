package com.ysmhmcgames.ihc_more_ore.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ColdResistantEffect extends MobEffect {

    protected ColdResistantEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    // 药水触发效果
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        // 重置冰冻进度
        livingEntity.setTicksFrozen(0);
        return true;
    }
    // 药水触发周期 duration为持续时间，单位为游戏刻(tick)
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
