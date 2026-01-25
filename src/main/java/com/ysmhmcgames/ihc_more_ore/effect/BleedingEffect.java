package com.ysmhmcgames.ihc_more_ore.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.NeoForgeMod;

public class BleedingEffect extends MobEffect {

    public BleedingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    // 药水触发效果
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.getHealth() > 0.0F) {
            Registry<DamageType> typeReg = livingEntity.damageSources().damageTypes;
            Holder.Reference<DamageType> dType = (Holder.Reference)typeReg.
                    getHolderOrThrow(DamageTypes.MAGIC);
            livingEntity.hurt(new DamageSource(dType), 1.0f+(amplifier*0.2f));
        }

        return true;
    }
    // 药水触发周期 duration为持续时间，单位为游戏刻(tick)
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
