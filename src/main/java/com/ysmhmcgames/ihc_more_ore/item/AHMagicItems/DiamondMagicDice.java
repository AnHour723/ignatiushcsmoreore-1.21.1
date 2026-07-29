package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;
import com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.model.MagicSixSidedDice;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class DiamondMagicDice extends MagicSixSidedDice {

    public DiamondMagicDice(Properties properties) {
        super(properties.durability(12));
    }

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
                        case 1 : {roll1(level, player, usedHand);break;}// 获得生命回复III 3秒
                        case 2 : {roll2(level, player, usedHand);break;}// 获得一个钻石
                        case 3 : {roll3(level, player, usedHand);break;}// 给副手物品+2点耐久
                        case 4 : {roll4(level, player, usedHand);break;}// 失明10min
                        case 5 : {roll5(level, player, usedHand);break;}// 清除所有效果
                        case 6 : {roll6(level, player, usedHand);break;}// 获得12个黑曜石
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

        ItemStack offhand = player.getOffhandItem();
        ItemStack stack = player.getItemInHand(usedHand);
        // 副手没有物品，无事发生
        if (offhand.isEmpty()) {
            return;
        }
        // 副手有物品，恢复 diceTotal 点耐久
        int maxDamage = offhand.getMaxDamage();
        int damageValue = offhand.getDamageValue();
        if(damageValue - diceTotal > 0){
            offhand.setDamageValue(offhand.getDamageValue() - diceTotal);
        }else {
            offhand.setDamageValue(0);// 设置物品损伤为0
        }
        stack.shrink(1);
        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.REGENERATION,  // 生命恢复效果
                60,                // 持续时间：3s
                2                   // 等级：III级
        ));
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        // 创建钻石 ItemStack（数量 = 1）
        ItemStack item = new ItemStack(Items.DIAMOND, 1);

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
        ItemStack offhand = player.getOffhandItem();
        // 副手没有物品，无事发生
        if (offhand.isEmpty()) {
            return;
        }
        // 副手有物品，恢复 2 点耐久
        offhand.setDamageValue(offhand.getDamageValue() - 2);
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.BLINDNESS,  // 失明效果
                12000,                // 持续时间：600s
                0                   // 等级：I级
        ));
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        boolean f = player.removeAllEffects();
        // System.out.println(f);
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        // 创建黑曜石 ItemStack（数量 = 12）
        ItemStack item = new ItemStack(Items.OBSIDIAN, 12);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.one").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.two").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.three").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.four").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.five").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.six").withColor(0x00FFFF));
            tooltipComponents.add(Component.translatable("text.shift.dice.diamond.finally").withColor(0x00FFFF));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
