package com.ysmhmcgames.ihc_more_ore.enchantment.custom;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record SoulHarvestEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<SoulHarvestEnchantmentEffect> CODEC = MapCodec.unit(SoulHarvestEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 position) {


        if(serverLevel.random.nextFloat() < enchantmentLevel * 0.1f){// 等级1=10%, 等级2=20%, 等级3=30%
            int minCount = 1;
            int maxCount = Math.min(enchantmentLevel, 3);  // 等级1=1-1, 等级2=1-2, 等级3=1-3
            int dropCount = minCount + serverLevel.random.nextInt(maxCount);

            ItemStack soulItem = new ItemStack(HCOreItem.SOUL_ESSENCE.get(), dropCount);

            ItemEntity soulEntity = new ItemEntity(
                    serverLevel,
                    position.x(),
                    position.y() + 0.5,
                    position.z(),
                    soulItem
            );
            // 设置抛射效果
            soulEntity.setDeltaMovement(
                    (serverLevel.random.nextFloat() - 0.5f) * 0.2f,
                    0.3f + serverLevel.random.nextFloat() * 0.2f,
                    (serverLevel.random.nextFloat() - 0.5f) * 0.2f
            );
            serverLevel.addFreshEntity(soulEntity);// 向游戏世界添加实体对象
        }
    }
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
