package com.ysmhmcgames.ihc_more_ore.enchantment.custom;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public record ElementCollectionEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ElementCollectionEnchantmentEffect> CODEC = MapCodec.unit(ElementCollectionEnchantmentEffect::new);


    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        //System.out.println("运行了apply方法");
        // 1. 确保是玩家
        if (!(entity instanceof Player player)) {
            return;
        }

        // 2. 获取玩家手持的工具是否为锄头
        ItemStack tool = player.getMainHandItem();
        if (tool.isEmpty()) {
            return;
        }
        if (!(tool.getItem() instanceof HoeItem)) {
            return;
        }
        // 3. 获取被挖掘的方块
        BlockHitResult hitResult = getTargetedBlock(player, 5.0);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockPos blockPos = hitResult.getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);

        // 4. 检查是否是树叶
        if (!blockState.is(BlockTags.LEAVES)) {
            return;  // 不是树叶，直接返回
        }


        // 补：检测是否还有耐久
        // 减少3点耐久
        tool.setDamageValue(tool.getDamageValue() + 3);
        if (tool.getDamageValue() == tool.getMaxDamage()){
            return;
        }

        // 5. 计算掉落概率
        float dropChance = enchantmentLevel / 20f;
        //float dropChance = 1f;

        // 6. 随机判断是否掉落
        if (level.random.nextFloat() < dropChance) {
            // 7. 掉落树叶精华
            ItemStack essence = new ItemStack(HCOreItem.CHLOROPHYLL.get(), 1);


            ItemEntity itemEntity = new ItemEntity(
                    level,
                    blockPos.getX() + 0.5,
                    blockPos.getY() + 0.5,
                    blockPos.getZ() + 0.5,
                    essence
            );

            // 设置物理效果 (设置物品掉落时的物理运动效果)
            itemEntity.setDeltaMovement(
                    (level.random.nextDouble() - 0.5) * 0.1,
                    0.2,
                    (level.random.nextDouble() - 0.5) * 0.1
            );

            level.addFreshEntity(itemEntity);


        }
    }

    /**
     * 获取玩家指向的方块
     */
    private BlockHitResult getTargetedBlock(Player player, double range) {
        Vec3 eyePos = player.getEyePosition(1.0F);// 获取玩家眼睛位置
        Vec3 lookVec = player.getViewVector(1.0F);// 获取玩家视线方向向量
        Vec3 endPos = eyePos.add(lookVec.scale(range));// 计算视线终点位置

        // 进行射线检测
        return player.level().clip(new ClipContext(
                eyePos, // 起点：玩家眼睛位置
                endPos, // 终点：视线终点
                ClipContext.Block.OUTLINE,// 方块碰撞模式
                ClipContext.Fluid.NONE,// 液体处理
                player// 实体（用于碰撞检测）
        ));
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }


}
