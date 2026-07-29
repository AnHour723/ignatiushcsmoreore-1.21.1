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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class IronMagicDice extends MagicSixSidedDice {

    public IronMagicDice(Properties properties) {
        super(properties.durability(6));
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
                        case 1 : {roll1(level, player, usedHand);break;}// 扣除周围五格内所有人3点血量(包括自己)
                        case 2 : {roll2(level, player, usedHand);break;}// 获得抗性提升I效果 20秒
                        case 3 : {roll3(level, player, usedHand);break;}// 无事发生
                        case 4 : {roll4(level, player, usedHand);break;}// 获得3个铁粒
                        case 5 : {roll5(level, player, usedHand);break;}// 额外扣除骰子一点耐久
                        case 6 : {roll6(level, player, usedHand);break;}// 获得生命恢复3 10秒
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
                MobEffects.DAMAGE_RESISTANCE,  // 抗性提升效果
                diceTotal * 20,                // 持续时间：diceTotal秒
                1                   // 等级：II级
        ));

        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        // 创建搜索区域
        AABB searchArea = player.getBoundingBox().inflate(5.0, 2.0, 5.0);// getBoundingBox() 获取碰撞边界框  inflate()扩展边界框的大小
        // level.getEntitiesOfClass()世界方法，获取指定区域内的实体 三个参数如下:
        List<LivingEntity> livingEntities = level.getEntitiesOfClass(
                LivingEntity.class,// 要获取的实体类型（生物实体）
                searchArea,// 搜索区域的边界框
                // 过滤条件: 实体是存活的 && 实体可以被攻击
                entity -> entity.isAlive() && entity.attackable()
        );
        for (LivingEntity target : livingEntities) {
            // 造成伤害
            target.hurt(
                    level.damageSources().playerAttack(player),  // 伤害来源：玩家
                    3                                   // 伤害值
            );
        }
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.DAMAGE_RESISTANCE,  // 抗性提升效果
                400,                // 持续时间：20秒（200ticks）
                0                   // 等级：I级
        ));
    }
    public void roll3(Level level, Player player, InteractionHand usedHand){

    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        // 创建铁粒 ItemStack（数量 = 3）
        ItemStack item = new ItemStack(Items.IRON_NUGGET, 3);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        ItemStack stack = player.getItemInHand(usedHand);
        // 获取当前损伤值
        int currentDamage = stack.getDamageValue();
        int maxDamage = stack.getMaxDamage();

        // 增加损伤值（扣1点耐久）
        if (currentDamage < maxDamage) {
            stack.setDamageValue(currentDamage + 1);
        }
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        player.addEffect(new MobEffectInstance(
                MobEffects.REGENERATION,    // 生命恢复效果
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
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.one").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.two").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.three").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.four").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.five").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.six").withColor(0xFBFBF9));
            tooltipComponents.add(Component.translatable("text.shift.dice.iron.finally").withColor(0xFBFBF9));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
