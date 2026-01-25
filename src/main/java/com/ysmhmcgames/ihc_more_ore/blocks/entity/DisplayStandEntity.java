package com.ysmhmcgames.ihc_more_ore.blocks.entity;

import com.ysmhmcgames.ihc_more_ore.screen.custom.DisplayStandMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class DisplayStandEntity extends BlockEntity implements MenuProvider {
    public static final int MAX_COUNT = 64;// 创建最大容量

    // 先创建一个 物品处理器 并对其命名
    public final ItemStackHandler inventory = new ItemStackHandler(1){// 这里的数字表示几个插槽(几个格子)
        // 表示每个槽位最多能存放多少个东西
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            //return super.getStackLimit(slot, stack);
            return MAX_COUNT;// 只希望显示或者添加一个物品
        }

        // 这样写可以确保方块内的物品发生变化时会更新在客户端
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);// 更新方块 范围：周围三格方块
            }
        }
    };
    public DisplayStandEntity(BlockPos pos, BlockState blockState) {
        super(HCBlockEntity.DISPLAY_STAND_ENTITY.get(), pos, blockState);
    }

    // 为渲染添加一个物品旋转的参数
    private float rotation;// 创建一个旋转角度的变量
    public float getRenderingRotation(){// 每次调用获取渲染旋转方法时 旋转角度+0.5 当到达360度即设置为0为旋转一圈后持续旋转
        this.rotation += 0.5f;
        if(this.rotation >= 360){
            this.rotation = 0;
        }
        return this.rotation;
    }


    // 写一个清空方块内所有物品的方法
    public void clearContents(){
        inventory.setStackInSlot(0,ItemStack.EMPTY);// 设置零号位为空
    }

    // 方块破坏掉落所有内部物品的方法
    public void drop(){
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i=0;i<inventory.getSlots();i++){
            inv.setItem(i,inventory.getStackInSlot(i));
        }
        // 调用Containers的dropContents(容器掉落内容)的方法
        Containers.dropContents(this.level,this.worldPosition,inv);// 该方法需要一个存储内容，这里用前面的物品栈堆处理器来处理同步等操作
    }

    // 以下两个方法 用于保存和加载  将物品用nbt方式保存，这样可以永久保存(不写则每次离开世界会更新让方块内物品消失)
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory",inventory.serializeNBT(registries));// 序列化nbt并传入注册表
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries,tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu_text.display_stand");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new DisplayStandMenu(i,inventory,this);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);// 返回客户端绑定的区块实体数据包，传入参数
    }
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);// 返回无元数据的安全版本 传递registries
    }

}
