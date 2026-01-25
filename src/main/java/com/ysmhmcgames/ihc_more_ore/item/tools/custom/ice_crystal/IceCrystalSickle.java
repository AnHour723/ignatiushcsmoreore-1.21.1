package com.ysmhmcgames.ihc_more_ore.item.tools.custom.ice_crystal;

import com.ysmhmcgames.ihc_more_ore.item.tools.SickleItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class IceCrystalSickle extends SickleItem {
    public IceCrystalSickle(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 调用父类处理基础伤害
        boolean result = super.hurtEnemy(stack, target, attacker);
        // 施加冰冻进度
        if (target.canFreeze()) {
            target.setTicksFrozen(200);  // 增加10秒冰冻进度
        }

        return result;
    }
}
