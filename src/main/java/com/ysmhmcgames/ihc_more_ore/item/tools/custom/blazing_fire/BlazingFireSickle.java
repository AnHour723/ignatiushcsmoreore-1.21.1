package com.ysmhmcgames.ihc_more_ore.item.tools.custom.blazing_fire;

import com.ysmhmcgames.ihc_more_ore.item.tools.SickleItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class BlazingFireSickle extends SickleItem {


    public BlazingFireSickle(Tier tier, Properties properties) {
        super(tier, properties);
    }


    // 当攻击生物时
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 调用父类方法处理基础伤害
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (!attacker.level().isClientSide()) {
            // 施加火焰伤害
            target.igniteForTicks(100);  // 燃烧5秒 -> 100 tick
        }

        return result;
    }
}
