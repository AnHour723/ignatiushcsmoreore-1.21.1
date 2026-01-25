package com.ysmhmcgames.ihc_more_ore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FireproofEffect extends MobEffect {
    protected FireproofEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    // 药水触发效果
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        // 免疫火焰持续燃烧
        if (livingEntity.isOnFire()) {
            livingEntity.clearFire();
        }
        return true;
    }
    // 药水触发周期 duration为持续时间，单位为游戏刻(tick)
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
