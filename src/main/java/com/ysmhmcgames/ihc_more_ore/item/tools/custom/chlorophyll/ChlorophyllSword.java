package com.ysmhmcgames.ihc_more_ore.item.tools.custom.chlorophyll;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ChlorophyllSword extends SwordItem {
    public ChlorophyllSword(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // 在物品库存中每tick检查的方法
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        // 每5秒恢复1耐久
        if (!level.isClientSide() && level.getGameTime() % 100 == 0) {
            if (stack.isDamaged()) {
                stack.setDamageValue(stack.getDamageValue() - 1);
            }
        }
    }

}
