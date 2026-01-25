package com.ysmhmcgames.ihc_more_ore.blocks.ore;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DisguisedChlorophyllOre extends Block {
    public DisguisedChlorophyllOre(Properties properties) {
        super(properties);
    }


    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        // 放置时安排tick
        if (!level.isClientSide()) {
            level.scheduleTick(pos, this, 2400 + level.random.nextInt(3601)); // 120秒-300秒后开始tick
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 转换周围方块为钻石块
        convertSurroundingBlocks(level, pos);



        // 继续安排下一次转换
        level.scheduleTick(pos, this, 2400 + level.random.nextInt(3601)); // 每120秒-300秒执行一次
    }


    private void convertSurroundingBlocks(ServerLevel level, BlockPos centerPos) {
        int radius = 1; // 转换半径1格

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                BlockPos targetPos = centerPos.offset(x, 0, z);
                BlockState targetState = level.getBlockState(targetPos);

                // 如果是深板岩，转换为叶绿矿
                if (targetState.is(Blocks.DEEPSLATE)) {
                    level.setBlockAndUpdate(targetPos, HCBlock.CHLOROPHYLL_ORE.get().defaultBlockState());
                }
            }

        }
    }

}
