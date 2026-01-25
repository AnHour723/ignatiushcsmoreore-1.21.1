package com.ysmhmcgames.ihc_more_ore.blocks.ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ProfaneBloodBlock extends Block {
    public ProfaneBloodBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 检查是否为服务器端
        if (!level.isClientSide()) {
            // 获取玩家主手物品
            ItemStack mainHandItem = player.getMainHandItem();

            // 检查主手是否为钻石
            if (mainHandItem.is(HCItems.GLASS_CRYSTALLIZATION_TEMPLATE)) {
                // 播放音效
                level.playSound(null, pos,
                        SoundEvents.METAL_BREAK, SoundSource.BLOCKS,
                        1.0F, 1.0F);

                // 生成粒子效果
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                            pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                            10, 0.5, 0.5, 0.5, 0.1);
                }

                // 生成物品
                ItemStack essence = new ItemStack(HCOreItem.PROFANE_CRYSTAL.get(), 1);
                ItemEntity itemEntity = new ItemEntity(
                        level,
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        essence
                );
                // 设置物理效果 (设置物品掉落时的物理运动效果)
                itemEntity.setDeltaMovement(
                        (level.random.nextDouble() - 0.5) * 0.1,
                        0.2,
                        (level.random.nextDouble() - 0.5) * 0.1
                );
                // 将实体物品加入世界
                level.addFreshEntity(itemEntity);


                // 消耗1个玻璃模板
                if (!player.getAbilities().instabuild) {
                    mainHandItem.shrink(1);
                }

                // 替换方块为深板岩
                level.setBlockAndUpdate(pos, Blocks.DEEPSLATE.defaultBlockState());



                return ItemInteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
