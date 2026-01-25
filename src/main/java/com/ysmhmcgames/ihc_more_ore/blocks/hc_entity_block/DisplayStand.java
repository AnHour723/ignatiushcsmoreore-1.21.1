package com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.DisplayStandEntity;
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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DisplayStand extends BaseEntityBlock {
    // 设置物品碰撞参数
    public static final VoxelShape SHAPE = Block.box(3.0,0.0,3.0,13.0,15.0,13.0);

//    public static final VoxelShape SHAPE= Shapes.or(//自定碰撞箱 复杂
//            // 四边杯壁
//            box(4, 9.5, 5, 1, 3, 6),
//            box(11, 9.5, 5, 1, 3, 6),
//            box(5, 9.5, 4, 6, 3, 1),
//            box(5, 9.5, 11, 6, 3, 1),
//            // 上层底盘
//            box(4, 8.5, 4, 8, 1, 8),
//            // 中心支柱
//            box(7, 0.5, 7, 2, 8, 2),
//            // 二层底盘
//            box(5, 1, 5, 6, 1, 6),
//            //底盘
//            box(2, 0, 2, 12, 1, 12)
//    );

    // 创建 方块编码器
    public static final MapCodec<DisplayStand> CODEC = simpleCodec(DisplayStand::new);

    public DisplayStand(Properties properties) {
        super(properties);
    }

    // 设置碰撞箱大小参数
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // 返回VoxelShape对象即可
        return SHAPE;
    }

//    @Override
//    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
//        return this.SHAPE;
//    }
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
//        return SHAPE; // 用于实体碰撞
//    }
//    @Override
//    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
//        return Shapes.empty(); // 中心镂空部分不遮挡光线
//    }


    // 在此处返回编码器
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.CODEC;
    }


    // 对方块进行渲染操作，需要返回他的MODEL，不这么做方块将不可见
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


    // 此处需要返回一个方块实体类，去创建我们所要的方块实体优先
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DisplayStandEntity(blockPos,blockState);
    }

    // 当这个方块被破坏时即可调用这个方法
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){ // 判断 如果世界中的状态发生改变
            if(level.getBlockEntity(pos) instanceof DisplayStandEntity alloyFurnaceEntity){ // 获取层级 判断被破坏的位置是该方块实例
                // 常用于方块被破坏时丢弃方块内部物品
                alloyFurnaceEntity.drop();// 该方法存在于block entity类中
                // 方块状态改变通知周围方块
                level.updateNeighbourForOutputSignal(pos,this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }


    // 右键触发
    @Override //stack -> 玩家物品堆栈点
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 先上检测判断条件 是否为该方块对应方块实体
        if(level.getBlockEntity(pos) instanceof DisplayStandEntity displayStandEntity){
            // 打开菜单gui的方法
            if(player.isCrouching() && !level.isClientSide()){// 判断玩家是否蹲下 并且是我们处于服务端
                ((ServerPlayer)player).openMenu(new SimpleMenuProvider(displayStandEntity, Component.translatable("menu_text.display_stand")),pos);
                return ItemInteractionResult.SUCCESS;
            }
            if(displayStandEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()){ // 检测实体方块内没物品 且 手上有物品
                displayStandEntity.inventory.insertItem(0,stack.copy(),false);// 这里false表示不是模拟，会实际发生
                stack.shrink(stack.getCount());// 手上物品栈堆中减少所有值,并放入物品栈堆中
                //level.playSound(player,pos, SoundEvents.ITEM_PICKUP,SoundSource.BLOCKS,1f,2f);// 播放音效给予玩家反馈

            }else if(stack.isEmpty()){// 如果手上物品栈堆为空
                ItemStack stackDisplayStand = displayStandEntity.inventory.extractItem(0,displayStandEntity.inventory.getStackInSlot(0).getCount(),false);// 获取方块实体储存槽物品
                player.setItemInHand(InteractionHand.MAIN_HAND, stackDisplayStand);// 将物品给予玩家主手
                displayStandEntity.clearContents();// 清空方块实体储存槽
            }else if(displayStandEntity.inventory.getStackInSlot(0).getItem() == stack.getItem()){// 如果手上栈堆物品与方块实体储存槽物品相同,则运行以下
                if(displayStandEntity.inventory.getStackInSlot(0).getCount()+stack.getCount() <= displayStandEntity.MAX_COUNT){// 如果 方块实体储存槽物品数量 + 手上栈堆物品数量 小于 堆叠总数 则将手上物品全部放入方块实体储存槽中
                    displayStandEntity.inventory.insertItem(0,stack.copy(),false);// 这里false表示不是模拟，会实际发生
                    stack.shrink(stack.getCount()+displayStandEntity.inventory.getStackInSlot(0).getCount());// 手上物品栈堆中减少
                }else{// 当 方块实体储存槽物品数量 + 手上栈堆物品数量 大于 堆叠总数, 则交换两个物品
                    ItemStack stackDisplayStand = displayStandEntity.inventory.extractItem(0,displayStandEntity.inventory.getStackInSlot(0).getCount(),false);// 获取方块实体储存槽物品
                    displayStandEntity.clearContents();// 清空
                    displayStandEntity.inventory.insertItem(0,stack.copy(),false);// 这里false表示不是模拟，会实际发生
                    stack.shrink(stack.getCount());// 手上物品栈堆中减少
                    player.setItemInHand(InteractionHand.MAIN_HAND,stackDisplayStand);// 将物品给予玩家主手
                }
            }else if(displayStandEntity.inventory.getStackInSlot(0).getItem() != stack.getItem()){ // 当主手和方块实体槽位物品不一致时,交换两个物品
                ItemStack stackDisplayStand = displayStandEntity.inventory.extractItem(0,displayStandEntity.inventory.getStackInSlot(0).getCount(),false);// 获取方块实体储存槽物品
                displayStandEntity.clearContents();// 清空方块实体储存槽
                displayStandEntity.inventory.insertItem(0,stack.copy(),false);// 将方块实体的储存槽位赋值为物品栈堆
                stack.shrink(stack.getCount());// 将手上物品栈堆中减少,并放入物品栈堆中
                player.setItemInHand(InteractionHand.MAIN_HAND,stackDisplayStand);// 将物品给予玩家主手
            }
        }
        return ItemInteractionResult.SUCCESS;// 返回成功信息
    }
}
