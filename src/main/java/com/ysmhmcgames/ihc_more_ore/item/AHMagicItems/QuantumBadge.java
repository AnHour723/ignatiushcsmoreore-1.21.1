package com.ysmhmcgames.ihc_more_ore.item.AHMagicItems;

import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class QuantumBadge extends Item {
    public static final int CD = 600; // 设置cd为30s

    public QuantumBadge(Properties properties) {
        super(properties.durability(50));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {

        ItemStack stack = player.getItemInHand(usedHand);
        // 给予使用者量子化效果
        player.addEffect(new MobEffectInstance(HCEffects.QUANTIFICATION_EFFECT, 300 , 0));
        // 设置冷却时间
        player.getCooldowns().addCooldown(this, CD);
        // 扣除1点耐久
        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);


        return InteractionResultHolder.success(stack);
    }
}
