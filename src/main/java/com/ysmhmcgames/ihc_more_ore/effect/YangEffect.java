package com.ysmhmcgames.ihc_more_ore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.Collection;

public class YangEffect extends MobEffect {
    public YangEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
    // 药水触发效果
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        if (livingEntity.hasEffect(HCEffects.YIN_EFFECT)) {
            MobEffectInstance yangEffect = livingEntity.getEffect(HCEffects.YANG_EFFECT);
            MobEffectInstance yinEffect = livingEntity.getEffect(HCEffects.YIN_EFFECT);

            if(yinEffect.getDuration() > yangEffect.getDuration()){
                // 造成魔法伤害
                livingEntity.hurt(livingEntity.damageSources().magic(), 50);
                // 移除反应buff
                livingEntity.removeEffect(HCEffects.YANG_EFFECT);
                livingEntity.removeEffect(HCEffects.YIN_EFFECT);
            }


        }
        return true;
    }

    // 每tick都检测
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

}
