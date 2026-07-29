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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class RedLotusMagicDice extends MagicSixSidedDice {

    public RedLotusMagicDice(Properties properties) {
        super(properties.durability(9));
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
                        case 1 : {roll1(level, player, usedHand);break;}// 点燃自己
                        case 2 : {roll2(level, player, usedHand);break;}// 熄灭自己的火焰
                        case 3 : {roll3(level, player, usedHand);break;}// 抗火10min
                        case 4 : {roll4(level, player, usedHand);break;}// 清空所有buff
                        case 5 : {roll5(level, player, usedHand);break;}// 防寒10min
                        case 6 : {roll6(level, player, stack);break;}// 点燃周围5格内生物
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
        player.addEffect(new MobEffectInstance(
                MobEffects.REGENERATION,  // 生命恢复效果
                diceTotal * 60,                // 持续时间：diceTotal秒
                2                   // 等级：III级
        ));


        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        // 点燃自己 30 分钟
        player.setRemainingFireTicks(36000);
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        player.clearFire();
    }
    public void roll3(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.FIRE_RESISTANCE,  // 抗火效果
                2400,                // 持续时间：120秒
                0                   // 等级：I级
        ));
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        player.removeAllEffects();
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                HCEffects.COLD_RESISTANT_EFFECT,  // 抗寒效果
                2400,                // 持续时间：120秒
                0                   // 等级：I级
        ));
    }
    public void roll6(Level level, Player player, ItemStack stack){
        // 创建搜索区域
        AABB searchArea = player.getBoundingBox().inflate(5.0, 2.0, 5.0);// getBoundingBox() 获取碰撞边界框  inflate()扩展边界框的大小
        // level.getEntitiesOfClass()世界方法，获取指定区域内的实体 三个参数如下:
        List<LivingEntity> livingEntities = level.getEntitiesOfClass(
                LivingEntity.class,// 要获取的实体类型（生物实体）
                searchArea,// 搜索区域的边界框
                // 过滤条件: 不是玩家自己 && 实体是存活的 && 实体可以被攻击
                entity -> entity != player && entity.isAlive() && entity.attackable()
        );
        for (LivingEntity target : livingEntities) {
            // 点燃目标
            target.setRemainingFireTicks(36000);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.one").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.two").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.three").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.four").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.five").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.six").withColor(0xFF0000));
            tooltipComponents.add(Component.translatable("text.shift.dice.red_lotus.finally").withColor(0xFF0000));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
