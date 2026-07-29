package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.model.MagicSixSidedDice;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Random;

public class EnderMagicDice extends MagicSixSidedDice {

    public EnderMagicDice(Properties properties) {
        super(properties.durability(5));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        super.use(level, player, usedHand);

        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {
            if((stack.getMaxDamage() - stack.getDamageValue()) <= 0){
                finallyUse(level, player, usedHand, stack.get(HCComponents.DICE_TOTAL_DATA));
                stack.shrink(1);
                return InteractionResultHolder.success(stack);
            }else{
                // 获取当前损伤值
                int currentDamage = stack.getDamageValue();
                int maxDamage = stack.getMaxDamage();

                // 增加损伤值（扣1点耐久）
                if (currentDamage < maxDamage) {
                    stack.setDamageValue(currentDamage + 1);
                }

                // 1~6 随机数
                int roll = level.random.nextInt(6) + 1;


                if(stack.get(HCComponents.DICE_TOTAL_DATA) == null){
                    stack.set(HCComponents.DICE_TOTAL_DATA.get(), 0);
                }
                stack.set(HCComponents.DICE_DATA.get(), roll);// 设置物品投掷点数信息数据
                stack.set(HCComponents.DICE_TOTAL_DATA.get(), stack.get(HCComponents.DICE_TOTAL_DATA) + roll);// 设置物品投掷总点数信息数据
                //stack.set(DataComponents.CUSTOM_MODEL_DATA, stack.get(HCComponents.DICE_DATA));
                // 发送消息给玩家
                player.displayClientMessage(
                        Component.translatable("dice_data.ignatiushcsmoreore.msg").append(stack.get(HCComponents.DICE_DATA) + "").withColor(0xa8a8a8),
                        true
                );

                // 设置冷却时间
                setCD(player, 60);
                if(stack.getDamageValue() < stack.getMaxDamage()){
                    switch (roll){
                        case 1 : {roll1(level, player, usedHand);break;}// x轴正方向位移10格
                        case 2 : {roll2(level, player, usedHand);break;}// x轴负方向位移10格
                        case 3 : {roll3(level, player, usedHand);break;}// y轴正方向位移5格
                        case 4 : {roll4(level, player, usedHand);break;}// y轴负方向位移5格
                        case 5 : {roll5(level, player, usedHand);break;}// z轴正方向位移10格
                        case 6 : {roll6(level, player, usedHand);break;}// z轴负方向位移10格
                        default:break;
                    }
                }
            }
        }


        return InteractionResultHolder.success(stack);
    }

    @Override
    public void finallyUse(Level level, Player player, InteractionHand usedHand, int diceTotal) {
        super.finallyUse(level, player, usedHand, diceTotal);
        // 半径 r（单位：格）
        double r = diceTotal;

        // 获取玩家当前位置
        Vec3 pos = player.position();

        // 生成随机偏移量（-r 到 r 之间）
        Random random = new Random();
        double offsetX = (random.nextDouble() * 2 - 1) * r;
        double offsetZ = (random.nextDouble() * 2 - 1) * r;
        double offsetY = (random.nextDouble() * 2 - 1) * (r / 2);

        // 计算新位置
        Vec3 newPos = new Vec3(pos.x + offsetX, pos.y + offsetY, pos.z + offsetZ);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }


        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);

        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（x 轴 +10，y 和 z 保持不变）
        Vec3 newPos = new Vec3(pos.x + 10, pos.y, pos.z);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);

    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（x 轴 -10，y 和 z 保持不变）
        Vec3 newPos = new Vec3(pos.x - 10, pos.y, pos.z);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }
    public void roll3(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（y 轴 +5 ，x 和 z 保持不变）
        Vec3 newPos = new Vec3(pos.x, pos.y + 5, pos.z);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（y 轴 -5 ，x 和 z 保持不变）
        Vec3 newPos = new Vec3(pos.x, pos.y - 5, pos.z);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（z 轴 +10 ，x 和 y 保持不变）
        Vec3 newPos = new Vec3(pos.x, pos.y, pos.z + 10);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        // 获取玩家当前位置
        Vec3 pos = player.position();
        // 计算新位置（z 轴 -10 ，x 和 y 保持不变）
        Vec3 newPos = new Vec3(pos.x, pos.y, pos.z - 10);

        // 播放粒子音效和特效
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < 20; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                    pos.x + (level.random.nextDouble() - 0.5),
                    pos.y + level.random.nextDouble() * 2,
                    pos.z + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }

        // 传送玩家
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.one").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.two").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.three").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.four").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.five").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.six").withColor(0xDF00FF));
            tooltipComponents.add(Component.translatable("text.shift.dice.ender.finally").withColor(0xDF00FF));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
