package com.ysmhmcgames.ihc_more_ore.item.tools;

import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SickleItem extends SwordItem {
    // 横扫攻击范围
    private static final float SWEEP_RANGE = 4.0f;
    // 右键技能伤害范围 以玩家为中心，这个半径内的敌人都会受到伤害
    private static final float AOE_RADIUS = 5.0f;
    // 右键技能CD
    public static final int CD = 60;

    public SickleItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // 右键触发使用
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // 获取玩家手中的镰刀物品
        ItemStack sickle = player.getItemInHand(hand);

        // 只在服务器端执行逻辑（避免客户端-服务器不同步）
        if (!level.isClientSide) {
            // 检查冷却时间
            if (player.getCooldowns().isOnCooldown(this)) {
                // 如果还在冷却中，返回"通过"，不执行技能
                return InteractionResultHolder.pass(sickle);
            }

            // 执行范围攻击技能
            performAreaOfEffectAttack(level, player);

            // 设置冷却时间
            // 这个镰刀物品将在60ticks内无法再次使用右键技能
            player.getCooldowns().addCooldown(this, CD);

            // 播放技能效果
            playSkillEffects(level, player);

            // 返回成功结果
            return InteractionResultHolder.success(sickle);
        }

        // 客户端：返回消耗结果（播放动画等）
        return InteractionResultHolder.consume(sickle);
    }
    // 执行范围攻击
    private void performAreaOfEffectAttack(Level level, Player player) {
        // 计算攻击区域
        // AABB：轴对齐边界框，定义一个立方体区域
        // inflate：扩展区域，这里以玩家为中心创建5x4x5的区域 (向六个方向等量扩展)
        AABB attackArea = player.getBoundingBox()
                .inflate(AOE_RADIUS, 2.0, AOE_RADIUS);
        // 获取区域内的所有生物实体
        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,  // 只获取生物实体
                attackArea,          // 攻击区域
                entity -> shouldAttack(entity, player)  // 过滤条件
        );
        // 计算伤害
        // 获取玩家的攻击力属性值
        float playerDamage = (float)player.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 对每个目标造成伤害
        for (LivingEntity target : targets) {
            // 造成伤害
            target.hurt(
                    level.damageSources().playerAttack(player),  // 伤害来源：玩家
                    playerDamage                                   // 伤害值
            );
            // 添加击退效果
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            double distance = Math.sqrt(dx * dx + dz * dz);

            if (distance > 0) {
                // 标准化方向向量
                dx /= distance;
                dz /= distance;

                // 应用击退
                target.knockback(
                        0.4f,  // 击退力度
                        -dx,                 // X方向（远离玩家）
                        -dz                  // Z方向
                );
            }
            // 可选：添加负面效果
            target.addEffect(new MobEffectInstance(
                    HCEffects.BLEEDING_EFFECT,  // 流血效果
                    20,                // 持续时间：1秒（20ticks）
                    0                   // 等级：I级
            ));
        }
//        // 发送攻击消息
//        if (!targets.isEmpty()) {
//            player.displayClientMessage(
//                    Component.literal("镰刀旋风击中了 " + targets.size() + " 个目标！"),
//                    true
//            );
//        }
    }
    // 判断是否应该攻击这个实体
    private boolean shouldAttack(LivingEntity target, Player player) {
        return target != player &&                     // 不是玩家自己
                target.isAlive() &&                     // 目标还活着
                !player.isAlliedTo(target) &&           // 不是盟友（如驯服的狼）
                target.attackable() &&                  // 可以被攻击
                target.distanceTo(player) <= AOE_RADIUS; // 在攻击范围内
    }
    // 播放技能特效
    private void playSkillEffects(Level level, Player player) {
        // 播放音效
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.PLAYER_ATTACK_SWEEP,  // 横扫攻击音效
                SoundSource.PLAYERS,              // 音效分类：玩家
                1.0F,                             // 音量：100%
                0.8F                              // 音调：稍低
        );

        // 生成粒子效果
        for (int i = 0; i < 30; i++) {  // 生成30个粒子
            // 随机位置（在以玩家为中心，半径5的圆内）
            double angle = Math.PI * 2 * i / 30;
            double radius = AOE_RADIUS * level.random.nextDouble();
            double x = player.getX() + Math.cos(angle) * radius;
            double z = player.getZ() + Math.sin(angle) * radius;
            double y = player.getY() + 1.0 + level.random.nextDouble();

            // 添加横扫攻击粒子
            level.addParticle(
                    ParticleTypes.SWEEP_ATTACK,  // 粒子类型：横扫特效
                    x, y, z,                     // 粒子位置
                    0, 0.05, 0                   // 粒子运动方向
            );
        }

        // 可选：屏幕震动效果
        if (level.isClientSide && player == Minecraft.getInstance().player) {
            // 这里可以添加客户端屏幕效果
        }
    }

    // 重写左键效果
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        // 只在服务器端处理
        if (!player.level().isClientSide && entity instanceof LivingEntity mainTarget) {
            // 执行横扫攻击
            performSweepAttack(player.level(), player, mainTarget);

            // 触发攻击事件
            player.setLastHurtMob(mainTarget);// 记录玩家最近攻击的生物实体，用于触发游戏内的各种相关机制
        }

        // 返回false表示不取消原版攻击逻辑
        return false;
    }


    // 进行横扫攻击
    private void performSweepAttack(Level level, Player player, LivingEntity mainTarget) {
        // 获取横扫范围内的所有生物
        List<LivingEntity> nearbyTargets = getNearbyEntities(level, player, SWEEP_RANGE / 2);

        // 计算基础伤害（镰刀的攻击力）
        float baseDamage = (float)player.getAttributeValue(Attributes.ATTACK_DAMAGE);

        // int secondaryHits = 0;  // 记录击中的额外目标数量

        for (LivingEntity target : nearbyTargets) {
            // 跳过主目标和玩家自己
            if (target == mainTarget || target == player) continue;

            // 跳过盟友和死亡目标
            if (player.isAlliedTo(target) || !target.isAlive()) continue;

            // 造成全额伤害（没有衰减）
            target.hurt(
                    level.damageSources().playerAttack(player),
                    baseDamage
            );

            // secondaryHits++;

            // 播放横扫粒子
            if (level.isClientSide) {
                spawnSweepParticles(level, player, target);
            }
        }

        // 显示横扫命中信息
//        if (secondaryHits > 0) {
//            player.displayClientMessage(
//                    Component.literal("§e横扫击中了额外的 " + secondaryHits + " 个目标"),
//                    true
//            );
//        }
    }
    // 获取玩家周围的实体
    private List<LivingEntity> getNearbyEntities(Level level, Player player, float range) {
        // 创建搜索区域
        AABB searchArea = player.getBoundingBox().inflate(range, 2.0, range);// getBoundingBox() 获取碰撞边界框  inflate()扩展边界框的大小
        // level.getEntitiesOfClass()世界方法，获取指定区域内的实体 三个参数如下:
        return level.getEntitiesOfClass(
                LivingEntity.class,// 要获取的实体类型（生物实体）
                searchArea,// 搜索区域的边界框
                // 过滤条件: 不是玩家自己 && 实体是存活的 && 实体可以被攻击
                //entity -> entity != player && entity.isAlive() && entity.attackable()
                entity -> isInFrontOfPlayer(player, entity, range, 60)
        );
    }

    /**
     * 判断实体是否在玩家面前区域内
     * @param player 玩家
     * @param entity 目标实体
     * @param range 最大距离
     * @param angleDegrees 角度范围（例如90表示面前90度扇形）
     * @return 是否在面前
     */
    private boolean isInFrontOfPlayer(Player player, LivingEntity entity, float range, float angleDegrees) {
        // 1. 排除玩家自己
        if (entity == player) {
            return false;
        }
        // 2. 排除死亡实体
        if (!entity.isAlive()) {
            return false;
        }
        // 3. 计算距离
        double distance = player.distanceTo(entity);
        if (distance > range) {
            return false;
        }
        // 4. 计算角度差
        Vec3 playerLook = player.getLookAngle();  // 玩家看向的方向向量
        // 玩家到实体的方向向量
        Vec3 toEntity = new Vec3(
                entity.getX() - player.getX(),
                0,  // 忽略垂直差异
                entity.getZ() - player.getZ()
        ).normalize();
        // 计算点积（cosθ）
        double dot = playerLook.x * toEntity.x + playerLook.z * toEntity.z;
        // 计算角度（弧度转度）
        double angleBetween = Math.toDegrees(Math.acos(dot));
        // 检查是否在指定角度范围内
        return Math.abs(angleBetween) <= angleDegrees / 2.0;
    }

    // 生成横扫粒子效果
    private void spawnSweepParticles(Level level, Player player, LivingEntity target) {
        // 计算玩家到目标的方向
        double dx = target.getX() - player.getX();
        double dz = target.getZ() - player.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);

        if (distance > 0) {
            // 标准化方向
            dx /= distance;
            dz /= distance;

            // 生成多个粒子
            for (int i = 0; i < 5; i++) {
                double offset = 1.0 + level.random.nextDouble() * 0.5;
                double px = player.getX() + dx * offset;
                double pz = player.getZ() + dz * offset;
                double py = player.getY() + 1.0;

                level.addParticle(
                        ParticleTypes.SWEEP_ATTACK,
                        px, py, pz,
                        dx * 0.2, 0.0, dz * 0.2
                );
            }
        }
    }
}
