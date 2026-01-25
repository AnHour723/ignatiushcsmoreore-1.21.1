package com.ysmhmcgames.ihc_more_ore.item.tools.custom.pole;

import com.ysmhmcgames.ihc_more_ore.entity.HCEntities;
import com.ysmhmcgames.ihc_more_ore.entity.custom.YangProjectileEntity;
import com.ysmhmcgames.ihc_more_ore.entity.custom.YinProjectileEntity;
import com.ysmhmcgames.ihc_more_ore.item.HCTools;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import java.util.function.Predicate;

public class PoleBowItem extends BowItem {

    public static final Predicate<ItemStack> ARROW =
            (itemStack) -> itemStack.is(HCTools.YIN_ARROW) || itemStack.is(HCTools.YANG_ARROW);

    public PoleBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if (!itemstack.isEmpty()) {
                // 计算蓄力时间
                int i = this.getUseDuration(stack, entityLiving) - timeLeft;
                i = EventHooks.onArrowLoose(stack, level, player, i, !itemstack.isEmpty());
                if (i < 0) {
                    return;
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {

                    AbstractArrow arrow = null;
                    if(itemstack.is(HCTools.YANG_ARROW)){
                        // 创建 YangProjectileEntity 作为箭矢
                        arrow = new YangProjectileEntity(HCEntities.YANG_ARROW.get(), level);

                    }else{

                        // 创建 YangProjectileEntity 作为箭矢
                        arrow = new YinProjectileEntity(HCEntities.YIN_ARROW.get(), level);
                    }

                    // 设置基础属性
                    arrow.setPos(
                            entityLiving.getX(),
                            entityLiving.getY() + entityLiving.getEyeHeight() - 0.1,
                            entityLiving.getZ()
                    );

                    // 设置速度和方向
                    Vec3 direction = entityLiving.getViewVector(1.0F);
                    float velocity = f * 3.0F;  // 与弓相同的速度计算

                    arrow.shoot(
                            direction.x,
                            direction.y,
                            direction.z,
                            velocity,
                            1.0F
                    );

                    // 设置所有者
                    arrow.setOwner(entityLiving);

                    // 添加到世界
                    level.addFreshEntity(arrow);

                    // 消耗弹药
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW;
    }
}
