package com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.AnalysisRoomBlockEntity;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.HCBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class AnalysisRoomBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(1,1,1,1,1,1);// 碰撞体积
    public static final MapCodec<AnalysisRoomBlock> CODEC = simpleCodec(AnalysisRoomBlock::new);// 方块编码器


    public AnalysisRoomBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.CODEC; // 返回编码器
    }

    @Override
    protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.SHAPE;// 返回碰撞箱
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AnalysisRoomBlockEntity(blockPos,blockState);
    }

    // 当这个方块被破坏时即可调用这个方法
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){ // 判断 如果世界中的状态发生改变
            if(level.getBlockEntity(pos) instanceof AnalysisRoomBlockEntity analysisRoomBlockEntity ){ // 获取层级 判断被破坏的位置是该方块实例
                // 常用于方块被破坏时丢弃方块内部物品
                analysisRoomBlockEntity.drop();// 该方法存在于block entity类中
                // 方块状态改变通知周围方块
                level.updateNeighbourForOutputSignal(pos,this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {// 并且是我们处于服务端
            // 检测判断条件 是否为该方块对应方块实体
            if(level.getBlockEntity(pos) instanceof AnalysisRoomBlockEntity analysisRoomBlockEntity) {
                // 打开菜单gui的方法
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(analysisRoomBlockEntity, Component.translatable("menu_text.analysis_room")), pos);
            }else{
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide())return null;// 不让ticker方法在客户端运行

        // 调用ticker的辅助方法
        return createTickerHelper(blockEntityType, HCBlockEntity.ANALYSIS_ROOM_BLOCK_ENTITY.get(),
                (level1,blockPos,blockState,blockEntity)->blockEntity.tick(level1,blockPos,blockState));
    }
}
