package com.ysmhmcgames.ihc_more_ore.blocks.ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TwilightCloudElementBlock extends Block {
    public TwilightCloudElementBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 检查是否为服务器端
        if (!level.isClientSide()) {
            // 获取玩家主手物品
            ItemStack mainHandItem = player.getMainHandItem();

            // 检查主手是否为钻石块
            if (mainHandItem.is(Items.DIAMOND_BLOCK)) {
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

                // 消耗1个钻石块
                if (!player.getAbilities().instabuild) {
                    mainHandItem.shrink(1);
                }

                // 替换方块为暮云块
                level.setBlockAndUpdate(pos, HCBlock.TWILIGHT_CLOUD_BLOCK.get().defaultBlockState());



                return ItemInteractionResult.SUCCESS;
            }
        }
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
