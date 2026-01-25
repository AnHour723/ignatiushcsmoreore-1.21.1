package com.ysmhmcgames.ihc_more_ore.entity.custom;

import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import com.ysmhmcgames.ihc_more_ore.entity.HCEntities;
import com.ysmhmcgames.ihc_more_ore.item.HCTools;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class YinProjectileEntity extends AbstractArrow {


    public YinProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public YinProjectileEntity(LivingEntity shooter, Level level){
        super(HCEntities.YIN_ARROW.get(), shooter, level, new ItemStack(HCTools.YIN_ARROW.get()), new ItemStack(HCTools.POLE_BOW.get()));
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(HCTools.YIN_ARROW.get());
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        // 检查是否是生物实体
        if (entity instanceof LivingEntity livingEntity) {
            // 计算当前弹射物速度
            Vec3 velocity = this.getDeltaMovement();
            double speed = velocity.length();  // 速度大小（方块/刻）

            // 根据速度计算持续时间
            int durationTicks = calculateDurationFromSpeed(speed);

            // 应用药水效果
            MobEffectInstance effect = new MobEffectInstance(
                    HCEffects.YIN_EFFECT,      // 药水效果：流血
                    durationTicks,                  // 持续时间：根据速度决定 (单位:tick)
                    0,                              // 效果等级：I
                    false,                          // 环境效果
                    false,                          // 显示粒子
                    true                            // 显示图标
            );

            // 应用效果
            livingEntity.addEffect(effect);
        }

    }

    /**
     * 根据速度计算持续时间
     * @param speed 弹射物速度（方块/刻）
     * @return 持续时间（tick）
     */
    private int calculateDurationFromSpeed(double speed) {
        // 基础持续时间：10秒（200 tick）
        int baseDuration = 200;

        // 速度阈值设定
        double minSpeed = 1.0;  // 最小有效速度
        double maxSpeed = 3.0;  // 最大参考速度（原版箭矢最大速度约3.0）

        // 速度-持续时间映射公式
        if (speed < minSpeed) {
            return baseDuration;  // 速度太低，应用默认效果时间
        }

        // 线性映射：速度越大，持续时间越长 (额外时间系数)
        double speedRatio = Math.min(speed , maxSpeed);

        // 计算最终持续时间
        // 基础10秒 + 额外时间(10 * speed)
        int extraDuration = (int)(baseDuration * speedRatio);
        int finalDuration = baseDuration + extraDuration;

        // 限制范围：最少10秒，最多(10*n,n>=1)秒
        return Math.max(baseDuration, finalDuration);
    }

}
