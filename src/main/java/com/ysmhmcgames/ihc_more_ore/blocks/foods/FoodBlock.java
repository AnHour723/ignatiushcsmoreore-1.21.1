package com.ysmhmcgames.ihc_more_ore.blocks.foods;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FoodBlock extends Block {
    public static final MapCodec<FoodBlock> CODEC = simpleCodec(FoodBlock::new);
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
//    protected static final float AABB_OFFSET = 1.0F;
//    protected static final float AABB_SIZE_PER_BITE = 2.0F;
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            // 0次被吃：完整蛋糕 (1,0,1) 到 (15,8,15)
            Block.box(1.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 1次被吃：从左边开始吃 (3,0,1) 到 (15,8,15)
            Block.box(3.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 2次被吃：又吃一口 (5,0,1) 到 (15,8,15)
            Block.box(5.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 3次被吃 (7,0,1) 到 (15,8,15)
            Block.box(7.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 4次被吃 (9,0,1) 到 (15,8,15)
            Block.box(9.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 5次被吃 (11,0,1) 到 (15,8,15)
            Block.box(11.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            // 6次被吃：只剩最后一口 (13,0,1) 到 (15,8,15)
            Block.box(13.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F)
    };

    public FoodBlock(Properties properties) {
        super(properties);

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, pos, state, player);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_BITE[(Integer)state.getValue(BITES)];
    }

    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);// 玩家统计更新、记录玩家吃蛋糕片的成就统计
            player.getFoodData().eat(2, 0.1F);// 恢复饥饿值和饱和度
            int i = (Integer)state.getValue(BITES);// 获取当前被吃次数
            level.gameEvent(player, GameEvent.EAT, pos);// 发送玩家吃东西事件
            if (i < 6) {
                // 设置当前方块点击(被吃的次数),使其+1
                /* 第三个参数描述
                二进制位标志
                int flags = 3;  // 二进制: 11

                实际上包含两个标志位：
                1. CLIENT (1 << 0) = 1    // 更新客户端
                2. SERVER (1 << 1) = 2    // 更新服务端

                1 | 2 = 3，表示同时更新客户端和服务端
                * */
                level.setBlock(pos, (BlockState)state.setValue(BITES, i + 1), 3);
            } else {
                level.removeBlock(pos, false);// 如果被吃次数超过指定，则破坏此方块
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);// 发送方块破坏事件
            }

            return InteractionResult.SUCCESS;
        }
    }


    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }


}
