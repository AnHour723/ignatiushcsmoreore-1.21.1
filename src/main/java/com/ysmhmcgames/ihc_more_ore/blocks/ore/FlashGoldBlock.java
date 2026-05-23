package com.ysmhmcgames.ihc_more_ore.blocks.ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FlashGoldBlock extends Block {
    public FlashGoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack heldItem = player.getItemInHand(hand);

        // 检查是否手持镐子
        boolean isPickaxe = heldItem.getItem() instanceof net.minecraft.world.item.PickaxeItem;

        if (isPickaxe) {
            if (!level.isClientSide()) {
                // 转换方块
                BlockState newState = HCBlock.FLASH_GOLD_FRAGILE_BLOCK.get().defaultBlockState();
                // 在原方块位置放置目标方块
                level.setBlock(pos, newState, 3);

                // 播放转换音效
                level.playSound(null, pos,
                        SoundEvents.GLASS_BREAK,
                        SoundSource.BLOCKS,
                        1.0F, 1.0F);


                // 消耗工具耐久
                if (!player.getAbilities().instabuild) {
                    stack.hurtAndBreak(5, player, EquipmentSlot.MAINHAND);
                }
            }

            return ItemInteractionResult.SUCCESS;
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
