package com.ysmhmcgames.ihc_more_ore.enchantment.custom;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record TetanusEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<TetanusEnchantmentEffect> CODEC = MapCodec.unit(TetanusEnchantmentEffect::new);
    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        int time = i * 20;
        if (entity instanceof LivingEntity living) {
            living.addEffect(
                    new MobEffectInstance(
                            HCEffects.BLEEDING_EFFECT,
                            time,
                            0,
                            false,
                            true
                    )
            );
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
