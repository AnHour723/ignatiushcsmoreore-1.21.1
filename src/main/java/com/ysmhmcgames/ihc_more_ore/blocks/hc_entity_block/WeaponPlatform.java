package com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.HCBlockEntity;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.WeaponPlatformEntity;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WeaponPlatform extends BaseEntityBlock {
    // 设置物品碰撞参数
    public static final VoxelShape SHAPE = Block.box(0.0,0.0,0.0,16.0,16.0,16.0);
    // 创建 方块编码器
    public static final MapCodec<WeaponPlatform> CODEC = simpleCodec(WeaponPlatform::new);
    public static final BooleanProperty HAS_BLUEPRINT = BooleanProperty.create("has_blueprint");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public WeaponPlatform(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HAS_BLUEPRINT, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_BLUEPRINT);
        builder.add(FACING);
    }

    // 设置碰撞箱大小参数
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // 返回VoxelShape对象即可
        return SHAPE;
    }

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



    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide()){
            return null;
        }

        return createTickerHelper(blockEntityType, HCBlockEntity.WEAPON_PLATFORM_ENTITY.get(),
                (pLevel, blockPos, blockState, blockEntity)->{
                    boolean currentState = blockEntity.tick(pLevel,blockPos,blockState);
                    level.setBlockAndUpdate(blockPos, state.setValue(HAS_BLUEPRINT, currentState));
        });
    }


    // 此处需要返回一个方块实体类，去创建我们所要的方块实体优先
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WeaponPlatformEntity(blockPos,blockState);
    }

    // 当这个方块被破坏时即可调用这个方法
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){ // 判断 如果世界中的状态发生改变
            if(level.getBlockEntity(pos) instanceof WeaponPlatformEntity weaponPlatformEntity ){ // 获取层级 判断被破坏的位置是该方块实例
                // 常用于方块被破坏时丢弃方块内部物品
                weaponPlatformEntity.drop();// 该方法存在于block entity类中
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
            if(level.getBlockEntity(pos) instanceof WeaponPlatformEntity weaponPlatformEntity ) {
                // 打开菜单gui的方法
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(weaponPlatformEntity, Component.translatable("menu_text.weapon_platform_entity")), pos);
            }
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

}
