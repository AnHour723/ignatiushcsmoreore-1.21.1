package com.ysmhmcgames.ihc_more_ore.item.tools.custom.storm;

import com.ysmhmcgames.ihc_more_ore.item.tools.SickleItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class StormSickle extends SickleItem {
    public StormSickle(Tier tier, Properties properties) {
        super(tier, properties);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 调用父类处理基础伤害
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (!attacker.level().isClientSide()) {
            // 召唤闪电
            summonLightning(target, attacker);


        }

        return result;
    }

    /**
     *  召唤闪电攻击目标
     */
    private void summonLightning(LivingEntity target, LivingEntity attacker) {
        Level level = target.level();

        // 创建闪电
        LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        lightning.setPos(target.getX(), target.getY(), target.getZ());
        lightning.setVisualOnly(false);  // 真实闪电，会造成伤害

        // 设置闪电属性
        lightning.setCause(attacker instanceof ServerPlayer ? (ServerPlayer) attacker : null);

        // 在目标位置生成闪电
        level.addFreshEntity(lightning);


        // 额外雷击伤害
        if (!target.isInvulnerableTo(level.damageSources().lightningBolt())) {
            target.hurt(level.damageSources().lightningBolt(), 5.0f);
        }

    }

}
