package com.ysmhmcgames.ihc_more_ore.effect;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class SanctuaryEffect extends MobEffect {

    protected SanctuaryEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        // 绘制白色粒子圆
        drawHealingCircle(livingEntity);


        // 治疗圆形区域内的所有实体
        healEntitiesInCircle(livingEntity, amplifier);

        return true;
    }
    // 药水触发周期 duration为持续时间，单位为游戏刻(tick)
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 100 == 0;
    }



    /* 绘制白色粒子圆
     */
    private void drawHealingCircle(LivingEntity centerEntity) {
        // 只在客户端生成粒子
        if (!centerEntity.level().isClientSide()) {
            return;
        }

        // 生成稀疏白色粒子圆
        double radius = 5.0;
        double centerX = centerEntity.getX();
        double centerZ = centerEntity.getZ();
        double y = centerEntity.getY() + 0.1;  // 贴近地面

        // 每圈20个粒子，稀疏分布
        for (int i = 0; i < 40; i++) {
            double angle = Math.PI * 2 * i / 40;
            double x = centerX + radius * Math.cos(angle);
            double z = centerZ + radius * Math.sin(angle);

            centerEntity.level().addParticle(
                    ParticleTypes.END_ROD,
                    x, y, z,
                    0, 0.02, 0
            );
        }

    }
    /**
     * 治疗圆形区域内的所有实体 - 直接回复生命值
     * 每次触发恢复2点生命值
     */
    private void healEntitiesInCircle(LivingEntity centerEntity, int amplifier) {
        if (!centerEntity.level().isClientSide()) {

            ServerLevel level = (ServerLevel) centerEntity.level();
            // 检查施法者是否为玩家
            if (!(centerEntity instanceof Player casterPlayer)) {
                return;  // 非玩家无法使用饱食度
            }

            // 检查饱食度是否足够
            int foodLevel = casterPlayer.getFoodData().getFoodLevel();
            if (foodLevel <= 0) {
                // 饱食度不足，无法治疗
                return;
            }

            // 扣除1点饱食度
            casterPlayer.getFoodData().setFoodLevel(foodLevel - 1);


            // 定义治疗范围（半径5格）
            double radius = 5.0;
            double radiusSquared = radius * radius;

            // 获取中心位置
            double centerX = centerEntity.getX();
            double centerY = centerEntity.getY() + 1.0;  // 从腰部高度开始
            double centerZ = centerEntity.getZ();

            // 创建搜索范围
            AABB searchArea = new AABB(
                    centerX - radius, centerY - 2, centerZ - radius,
                    centerX + radius, centerY + 3, centerZ + radius
            );

            // 获取范围内的所有实体
            List<LivingEntity> nearbyEntities = centerEntity.level()
                    .getEntitiesOfClass(LivingEntity.class, searchArea);

            // 遍历并治疗实体
            for (LivingEntity target : nearbyEntities) {
                if (isFriendly(centerEntity, target)) {
                    // 检查距离是否在圆形范围内
                    double dx = target.getX() - centerX;
                    double dy = target.getY() - (centerY - 1);
                    double dz = target.getZ() - centerZ;
                    double distanceSquared = dx * dx + dy * dy + dz * dz;

                    if (distanceSquared <= radiusSquared) {
                        // 直接恢复2点生命值
                        float healAmount = 2.0f;  // 每次恢复2点生命值


                        // 治疗实体
                        target.heal(healAmount);

                    }

                }
            }

        }
    }
    /**
     * 判断是否为友方单位
     */
    private boolean isFriendly(LivingEntity caster, LivingEntity target) {
        // 1. 自己总是友方
        if (caster == target) {
            return true;
        }
        // 2. 同阵营的玩家
        if (caster instanceof Player casterPlayer && target instanceof Player targetPlayer) {
            // 简化：同队伍或同UUID
            if (casterPlayer.getTeam() != null && casterPlayer.getTeam().isAlliedTo(targetPlayer.getTeam())) {
                return true;
            }
            return casterPlayer.getUUID().equals(targetPlayer.getUUID());
        }
        // 3. 驯服的动物
        if (target instanceof TamableAnimal pet) {
            return pet.getOwnerUUID() != null &&
                    pet.getOwnerUUID().equals(caster.getUUID());
        }

        return false;
    }



}
