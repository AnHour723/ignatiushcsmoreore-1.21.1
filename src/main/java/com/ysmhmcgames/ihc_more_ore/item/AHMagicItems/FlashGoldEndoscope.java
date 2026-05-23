package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FlashGoldEndoscope extends Item {
    public static final int CD = 600;
    public static final double AOE_RADIUS = 7.0;
    public FlashGoldEndoscope(Properties properties) {
        super(properties.durability(30));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {
        // 获取该物品
        ItemStack stack = player.getItemInHand(usedHand);
        // 计算选中区域
        // AABB：轴对齐边界框，定义一个立方体区域
        // inflate：扩展区域，这里以玩家为中心创建5x4x5的区域 (向六个方向等量扩展)
        AABB selectArea = player.getBoundingBox()
                .inflate(AOE_RADIUS, AOE_RADIUS, AOE_RADIUS);
        // 获取区域内的所有生物实体
        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,  // 只获取生物实体
                selectArea,          // 选中区域
                entity -> shouldSelected(entity, player)  // 过滤条件
        );
        if(targets.isEmpty()){
            player.displayClientMessage(
                    Component.translatable("text.flash_gold_endoscope.info"),
                    true
            );
        }else{
            // 对每个目标进行处理
            for (LivingEntity target : targets) {
                // 添加负面效果
                target.addEffect(new MobEffectInstance(
                        HCEffects.FRAIL_EFFECT,  // 易损效果
                        300,                // 持续时间：15秒
                        0                   // 等级：I级
                ));
                target.addEffect(new MobEffectInstance(
                        MobEffects.GLOWING,  // 发光效果
                        300,                // 持续时间：15秒
                        0                   // 等级：I级
                ));

            }
            player.getCooldowns().addCooldown(this, CD);
            // 使物品减去1点耐久
            /*
            * player 为目标的物品
            * EquipmentSlot.MAINHAND 为槽位是主手
            * */
            stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }



        return super.use(level, player, usedHand);
    }

    // 判断是否应该攻击这个实体
    private boolean shouldSelected(LivingEntity target, Player player) {
        return target != player &&                     // 不是玩家自己
                target.isAlive() &&                     // 目标还活着
                !player.isAlliedTo(target) &&           // 不是盟友（如驯服的狼）
                target.attackable() &&                  // 可以被攻击
                target.distanceTo(player) <= AOE_RADIUS; // 在攻击范围内
    }
}
