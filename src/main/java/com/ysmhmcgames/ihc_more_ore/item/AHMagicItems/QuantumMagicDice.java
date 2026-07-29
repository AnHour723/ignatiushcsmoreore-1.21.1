package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.model.MagicSixSidedDice;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class QuantumMagicDice extends MagicSixSidedDice {

    public QuantumMagicDice(Properties properties) {
        super(properties.durability(7));
    }

    private static int forceLvl = 0;
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        super.use(level, player, usedHand);

        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {
            if((stack.getMaxDamage() - stack.getDamageValue()) <= 0){
                finallyUse(level, player, usedHand, stack.get(HCComponents.DICE_TOTAL_DATA));
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
                        case 1 : {roll1(level, player, usedHand);break;}// 获得一个量子域
                        case 2 : {roll2(level, player, usedHand);break;}// 获得一个不可见方块
                        case 3 : {roll3(level, player, usedHand);break;}// 隐身10min
                        case 4 : {roll4(level, player, usedHand);break;}// 直接损毁骰子
                        case 5 : {roll5(level, player, usedHand);break;}// 总点数翻倍
                        case 6 : {roll6(level, player, usedHand);break;}// 恢复骰子满耐久
                        default:break;
                    }
                }

            }
        }


        return InteractionResultHolder.success(stack);
    }

    // 重写左键效果
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        // 只在服务器端处理
        if (!player.level().isClientSide && entity instanceof LivingEntity mainTarget) {
            if(stack.getMaxDamage() - stack.getDamageValue() <= 0){
                float damage = stack.get(HCComponents.DICE_TOTAL_DATA);

                // 触发攻击事件
                player.setLastHurtMob(mainTarget);// 记录玩家最近攻击的生物实体，用于触发游戏内的各种相关机制

                // 让目标受到 damage 点伤害（使用玩家攻击伤害源）
                mainTarget.hurt(player.level().damageSources().playerAttack(player), damage);

                // 销毁物品
                stack.shrink(1);
            }

        }

        // 返回false表示不取消原版攻击逻辑
        return false;
    }

    @Override
    public void finallyUse(Level level, Player player, InteractionHand usedHand, int diceTotal) {
        super.finallyUse(level, player, usedHand, diceTotal);

        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        // 创建量子域 ItemStack（数量 = 1）
        ItemStack item = new ItemStack(HCBlock.QUANTUM_DOMAIN, 1);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        // 创建不可见方块 ItemStack（数量 = 1）
        ItemStack item = new ItemStack(HCBlock.INVISIBLE_BLOCK, 1);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }
    public void roll3(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.INVISIBILITY,    // 隐身效果
                12000,                // 持续时间：10min
                0                   // 等级：I级
        ));
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        ItemStack stack = player.getItemInHand(usedHand);
        stack.shrink(1);
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        ItemStack stack = player.getItemInHand(usedHand);
        stack.set(HCComponents.DICE_TOTAL_DATA.get(), stack.get(HCComponents.DICE_TOTAL_DATA) * 2);// 设置物品投掷总点数信息数据
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        ItemStack stack = player.getItemInHand(usedHand);
        stack.setDamageValue(0);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.one").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.two").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.three").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.four").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.five").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.six").withColor(0x800080));
            tooltipComponents.add(Component.translatable("text.shift.dice.quantum.finally").withColor(0x800080));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
