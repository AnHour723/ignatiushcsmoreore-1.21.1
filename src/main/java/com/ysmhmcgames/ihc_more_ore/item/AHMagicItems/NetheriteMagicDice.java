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

public class NetheriteMagicDice extends MagicSixSidedDice {

    public NetheriteMagicDice(Properties properties) {
        super(properties.durability(15));
    }

    private static int forceLvl = 0;
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
                        case 1 : {roll1(level, player, usedHand);break;}// 结算力量+1
                        case 2 : {roll2(level, player, usedHand);break;}// 获得一组地狱岩
                        case 3 : {roll3(level, player, usedHand);break;}// 获得一组萤石粉
                        case 4 : {roll4(level, player, usedHand);break;}// 扣除最大生命值一半血量
                        case 5 : {roll5(level, player, usedHand);break;}// 获得一个远古残骸
                        case 6 : {roll6(level, player, usedHand);break;}// 对周围所有生物扣除最大生命值一半的血量
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
                MobEffects.DAMAGE_BOOST,  // 力量效果
                diceTotal * 20,                // 持续时间：diceTotal秒
                forceLvl                   // 等级：forceLvl级
        ));
        // System.out.println("============");
    }

    public void roll1(Level level, Player player, InteractionHand usedHand){
        forceLvl = forceLvl + 1;
    }
    public void roll2(Level level, Player player, InteractionHand usedHand){
        // 创建地狱岩 ItemStack（数量 = 64）
        ItemStack item = new ItemStack(Items.NETHERRACK, 64);

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
        // 创建萤石 ItemStack（数量 = 64）
        ItemStack item = new ItemStack(Items.GLOWSTONE_DUST, 64);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }
    public void roll4(Level level, Player player, InteractionHand usedHand){
        // 获取玩家的最大生命值
        float maxHealth = player.getMaxHealth();
        // 计算一半血量
        float halfHealth = maxHealth / 2.0F;
        // 扣除血量（使用 hurt 方法）
        player.hurt(level.damageSources().playerAttack(player), halfHealth);
    }
    public void roll5(Level level, Player player, InteractionHand usedHand){
        // 创建远古残骸 ItemStack（数量 = 1）
        ItemStack item = new ItemStack(Items.ANCIENT_DEBRIS, 1);

        // 尝试加入玩家背包，返回未放入的数量（通常为 0）
        if (player.getInventory().add(item)) {
            // 播放拾取音效
            player.playSound(SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
        } else {
            // 背包满了，掉落到地上
            player.drop(item, false);
        }
    }
    public void roll6(Level level, Player player, InteractionHand usedHand){
        // 创建搜索区域
        AABB searchArea = player.getBoundingBox().inflate(5.0, 2.0, 5.0);// getBoundingBox() 获取碰撞边界框  inflate()扩展边界框的大小
        // level.getEntitiesOfClass()世界方法，获取指定区域内的实体 三个参数如下:
        List<LivingEntity> livingEntities = level.getEntitiesOfClass(
                LivingEntity.class,// 要获取的实体类型（生物实体）
                searchArea,// 搜索区域的边界框
                // 过滤条件: 不是玩家自己 && 实体是存活的 && 实体可以被攻击
                entity -> entity.isAlive() && entity.attackable()
        );
        for (LivingEntity target : livingEntities) {
            // 获取玩家的最大生命值
            float maxHealth = target.getMaxHealth();
            // 计算一半血量
            float halfHealth = maxHealth / 2.0F;
            // 造成伤害
            target.hurt(
                    level.damageSources().playerAttack(player),  // 伤害来源：玩家
                    halfHealth                                   // 伤害值
            );
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // 判断是否按住 Shift
        if (Screen.hasShiftDown()) {
            // 按住 Shift 时显示详细信息
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.one").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.two").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.three").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.four").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.five").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.six").withColor(0x80461B));
            tooltipComponents.add(Component.translatable("text.shift.dice.netherite.finally").withColor(0x80461B));
        }else {
            tooltipComponents.add(Component.translatable("text.shift.dice"));
        }



    }
}
