package com.ysmhmcgames.ihc_more_ore.item.tools;


import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class UpgradeTemplateItem extends Item {
    protected String upgradeTemplateName;
    protected String equipment;
    protected String ore;

    public UpgradeTemplateItem(Properties properties, String up, String need) {
        super(properties);
        this.upgradeTemplateName = need + "_upgradeTemplateName";
        this.equipment = up + "_equipment";
        this.ore = need + "_ore";
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("upgrade_template.ignatiushcsmoreore." + upgradeTemplateName).withColor(0xa8a8a8));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("upgrade_template.ignatiushcsmoreore.use_up").withColor(0xa8a8a8));
        tooltipComponents.add(Component.translatable("upgrade_template.ignatiushcsmoreore." + equipment).withColor(0x5454fc));
        tooltipComponents.add(Component.translatable("upgrade_template.ignatiushcsmoreore.need_material").withColor(0xa8a8a8));
        tooltipComponents.add(Component.translatable("upgrade_template.ignatiushcsmoreore." + ore).withColor(0x5454fc));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


}
