package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems.model;

import com.ysmhmcgames.ihc_more_ore.data_attachment.HCComponents;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class MagicSixSidedDice extends Item {

    public MagicSixSidedDice(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {


        }



        return super.use(level, player, usedHand);
    }


    // 无耐久使用
    public void finallyUse(Level level, Player player, InteractionHand usedHand, int diceTotal){

    }
    public void setCD(Player player, int cd){
        player.getCooldowns().addCooldown(this, cd);
    }


    /**
     * 控制物品是否可以损耗耐久
     * 返回 false 表示不会因耐久归零而消失
     */
    @Override
    public boolean isDamageable(ItemStack stack) {
        return false; // 关键：禁止因耐久耗尽而消失
    }

    /**
     * 控制是否显示耐久条
     * 如果想让玩家看到耐久度变化，返回 true
     */
//    @Override
//    public boolean isBarVisible(ItemStack stack) {
//        return true; // 显示耐久条
//    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("dice_data.ignatiushcsmoreore.info").withColor(0xa8a8a8));
        tooltipComponents.add(Component.literal("\uD83C\uDFB2  " + stack.get(HCComponents.DICE_DATA)));
        tooltipComponents.add(Component.translatable("dice_total_data.ignatiushcsmoreore.info").withColor(0xa8a8a8));
        tooltipComponents.add(Component.literal("\uD83C\uDFB2  " + stack.get(HCComponents.DICE_TOTAL_DATA)));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
