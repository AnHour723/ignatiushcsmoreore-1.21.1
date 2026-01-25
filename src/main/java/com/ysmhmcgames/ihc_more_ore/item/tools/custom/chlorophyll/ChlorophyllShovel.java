package com.ysmhmcgames.ihc_more_ore.item.tools.custom.chlorophyll;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ChlorophyllShovel extends ShovelItem {
    public ChlorophyllShovel(Tier p_43114_, Properties p_43117_) {
        super(p_43114_, p_43117_);
    }

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
