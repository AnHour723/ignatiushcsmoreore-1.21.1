package com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.AlloyFurnaceCoreBlockEntity;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.AnalysisRoomBlockEntity;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.HCBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

public class AlloyFurnaceCoreBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(1,1,1,1,1,1);// 碰撞体积
    public static final MapCodec<AnalysisRoomBlock> CODEC = simpleCodec(AnalysisRoomBlock::new);// 方块编码器

    public static final BooleanProperty IS_WORKING = BooleanProperty.create("is_working");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;




    public AlloyFurnaceCoreBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(IS_WORKING, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(IS_WORKING);
        builder.add(FACING);
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
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide()){
            return null;
        }

        return createTickerHelper(blockEntityType, HCBlockEntity.ALLOY_FURNACE_CORE_BLOCK_ENTITY.get(),
                (pLevel, blockPos, blockState, blockEntity)->{
            boolean currentState = blockEntity.tick(pLevel,blockPos,blockState);
            level.setBlockAndUpdate(blockPos, state.setValue(IS_WORKING, currentState));
        });
    }


    private boolean isStruct(Level level, BlockPos pos) {
        // 获取方块在指定位置的世界状态
        BlockState state = level.getBlockState(pos);

        // 检查方块状态是否包含水平朝向属性
        // hasProperty(): 检查方块是否有指定的属性
        Direction facing = state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)
                ? state.getValue(BlockStateProperties.HORIZONTAL_FACING)
                : Direction.NORTH; // 默认朝北

        // 计算正后方的中心点
        // 获取当前朝向的反方向
        // getOpposite(): 返回相反的方向
        Direction backDirection = facing.getOpposite(); // 正后方方向
        // 计算正后方的中心方块位置
        // relative(): 根据给定的方向偏移计算新位置
        // pos: 当前方块位置
        BlockPos centerPos = pos.relative(backDirection); // 正后方的中心方块
        Block struct = HCBlock.ALLOY_FURNACE_FRAMEWORK_BLOCK.get();

        // 朝北
        if(facing == Direction.NORTH){
            for(int x = -1; x <= 1 ;x++){
                for(int z = 0;z <= 2 ;z++){
                    BlockPos checkPos1 = pos.offset(x, 1, z);
                    BlockState blockState1 = level.getBlockState(checkPos1);
                    if (!blockState1.is(struct)) {
                        return false;
                    }
                    if(x == 0 && z == 1){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(Blocks.AIR)) {
                            return false;
                        }
                    }else if(x == 0 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(HCBlock.ALLOY_FURNACE_CORE_BLOCK)) {
                            return false;
                        }
                    }else{
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(struct)) {
                            return false;
                        }
                    }
                    BlockPos checkPos3 = pos.offset(x, -1, z);
                    BlockState blockState3 = level.getBlockState(checkPos3);
                    if (!blockState3.is(struct)) {
                        return false;
                    }
                }
            }
        }
        // 朝南
        if(facing == Direction.SOUTH){
            for(int x = -1; x <= 1 ;x++){
                for(int z = -2;z <= 0 ;z++){
                    BlockPos checkPos1 = pos.offset(x, 1, z);
                    BlockState blockState1 = level.getBlockState(checkPos1);
                    if (!blockState1.is(struct)) {
                        return false;
                    }
                    if(x == 0 && z == -1){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(Blocks.AIR)) {
                            return false;
                        }
                    }else if(x == 0 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(HCBlock.ALLOY_FURNACE_CORE_BLOCK)) {
                            return false;
                        }
                    }else{
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(struct)) {
                            return false;
                        }
                    }
                    BlockPos checkPos3 = pos.offset(x, -1, z);
                    BlockState blockState3 = level.getBlockState(checkPos3);
                    if (!blockState3.is(struct)) {
                        return false;
                    }
                }
            }
        }
        // 朝东
        if(facing == Direction.EAST){
            for(int x = -2; x <= 0 ;x++){
                for(int z = -1;z <= 1 ;z++){
                    BlockPos checkPos1 = pos.offset(x, 1, z);
                    BlockState blockState1 = level.getBlockState(checkPos1);
                    if (!blockState1.is(struct)) {
                        return false;
                    }
                    if(x == -1 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(Blocks.AIR)) {
                            return false;
                        }
                    }else if(x == 0 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(HCBlock.ALLOY_FURNACE_CORE_BLOCK)) {
                            return false;
                        }
                    }else{
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(struct)) {
                            return false;
                        }
                    }
                    BlockPos checkPos3 = pos.offset(x, -1, z);
                    BlockState blockState3 = level.getBlockState(checkPos3);
                    if (!blockState3.is(struct)) {
                        return false;
                    }
                }
            }
        }
        // 朝西
        if(facing == Direction.WEST){
            for(int x = 0; x <= 2 ;x++){
                for(int z = -1;z <= 1 ;z++){
                    BlockPos checkPos1 = pos.offset(x, 1, z);
                    BlockState blockState1 = level.getBlockState(checkPos1);
                    if (!blockState1.is(struct)) {
                        return false;
                    }
                    if(x == 1 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(Blocks.AIR)) {
                            return false;
                        }
                    }else if(x == 0 && z == 0){
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(HCBlock.ALLOY_FURNACE_CORE_BLOCK)) {
                            return false;
                        }
                    }else{
                        BlockPos checkPos2 = pos.offset(x, 0, z);
                        BlockState blockState2 = level.getBlockState(checkPos2);
                        if (!blockState2.is(struct)) {
                            return false;
                        }
                    }
                    BlockPos checkPos3 = pos.offset(x, -1, z);
                    BlockState blockState3 = level.getBlockState(checkPos3);
                    if (!blockState3.is(struct)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }



    // 当这个方块被破坏时即可调用这个方法
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){ // 判断 如果世界中的状态发生改变
            if(level.getBlockEntity(pos) instanceof AlloyFurnaceCoreBlockEntity alloyFurnaceCoreBlockEntity ){ // 获取层级 判断被破坏的位置是该方块实例
                // 常用于方块被破坏时丢弃方块内部物品
                alloyFurnaceCoreBlockEntity.drop();// 该方法存在于block entity类中
                // 方块状态改变通知周围方块
                level.updateNeighbourForOutputSignal(pos,this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {// 并且是我们处于服务端
            if(isStruct(level, pos)){
                // 检测判断条件 是否为该方块对应方块实体
                if(level.getBlockEntity(pos) instanceof AlloyFurnaceCoreBlockEntity alloyFurnaceCoreBlockEntity) {
                    // 打开菜单gui的方法
                    ((ServerPlayer) player).openMenu(new SimpleMenuProvider(alloyFurnaceCoreBlockEntity, Component.translatable("menu_text.alloy_furnace_core")), pos);
                }else{
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }else{
                player.displayClientMessage(Component.translatable("text.alloy_furnace_core.info"),true);

            }
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AlloyFurnaceCoreBlockEntity(blockPos,blockState);
    }
}
