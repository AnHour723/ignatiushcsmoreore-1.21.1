package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
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

public class WoodenMagicDice extends MagicSixSidedDice {

    public WoodenMagicDice(Properties properties) {
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
                        case 1 : {roll1(level, player, usedHand);break;}// 获得幸运1效果10秒
                        case 2 : {roll2(level, player, usedHand);break;}// 获得霉运1效果10秒
                        case 3 : {roll3(level, player, stack);break;}// 获得幸运2效果10秒
                        case 4 : {roll4(level, player, usedHand);break;}// 获得霉运2效果10秒
                        case 5 : {roll5(level, player, usedHand);break;}// 获得霉运3效果10秒
                        case 6 : {roll6(level, player, usedHand);break;}// 获得幸运3效果10秒
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
        // 创建木棍 ItemStack（数量 = n / 4）
        ItemStack item = new ItemStack(Items.STICK, diceTotal / 4);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }

        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.LUCK,    // 幸运效果
                200,                // 持续时间：10秒（200ticks）
                0                   // 等级：I级
        ));
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.UNLUCK,  // 霉运效果
                200,                // 持续时间：10秒（200ticks）
                0                   // 等级：I级
        ));
    }
    public void roll3(Level level, Player player, ItemStack stack){
        player.addEffect(new MobEffectInstance(
                MobEffects.LUCK,    // 幸运效果
                200,                // 持续时间：10秒（200ticks）
                1                   // 等级：II级
        ));
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.UNLUCK,  // 霉运效果
                200,                // 持续时间：10秒（200ticks）
                1                   // 等级：II级
        ));
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.UNLUCK,  // 霉运效果
                200,                // 持续时间：10秒（200ticks）
                2                   // 等级：III级
        ));
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.LUCK,    // 幸运效果
                200,                // 持续时间：10秒（200ticks）
                2                   // 等级：III级
        ));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.one").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.two").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.three").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.four").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.five").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.six").withColor(0x8B4513));
            tooltipComponents.add(Component.translatable("text.shift.dice.wooden.finally").withColor(0x8B4513));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
