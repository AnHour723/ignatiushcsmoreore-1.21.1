package com.ysmhmcgames.ihc_more_ore.blocks.entity;

import com.ysmhmcgames.ihc_more_ore.recipe.AnalysisRoomRecipe;
import com.ysmhmcgames.ihc_more_ore.recipe.AnalysisRoomRecipeInput;
import com.ysmhmcgames.ihc_more_ore.recipe.HCRecipes;
import com.ysmhmcgames.ihc_more_ore.screen.custom.AnalysisRoomMenu;
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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AnalysisRoomBlockEntity extends BlockEntity implements MenuProvider{
    public final ItemStackHandler inventory = new ItemStackHandler(2){

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };

    // 对槽位进行命名操作
    private static final int INPUT_SLOT = 0;// 输入槽位索引
    private static final int OUTPUT_SLOT = 1;// 输出槽位索引

    protected final ContainerData data;// 容器数据 -> 可以很轻松的让数据在服务器和客户端之间同步
    // 进度的作用: 放入物品时等待时间 以及 可以计算如同熔炉烧制时增长的箭头进度并同步
    private int progress = 0;// 进度
    private int max_progress = 1200;// 最大进度

    public AnalysisRoomBlockEntity(BlockPos pos, BlockState blockState) {
        super(HCBlockEntity.ANALYSIS_ROOM_BLOCK_ENTITY.get(), pos, blockState);
        data = new ContainerData() {// 容器数据  以便正确同步进度和最大进度  从服务器到客户端 以及 从客户端到服务端
            @Override
            public int get(int i) {
                return switch (i){
                    case 0->AnalysisRoomBlockEntity.this.progress;
                    case 1->AnalysisRoomBlockEntity.this.max_progress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                 switch (i){
                     case 0:AnalysisRoomBlockEntity.this.progress=value;
                     case 1:AnalysisRoomBlockEntity.this.max_progress=value;
                };
            }

            @Override
            public int getCount() {// 决定要保存多少变量
                return 2;// 此处保存两个 -> 一个当前进度 一个最大进度
            }
        };
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


    public void clearContents(){// 清空方块内所有物品方法
        inventory.setStackInSlot(0,ItemStack.EMPTY);
        inventory.setStackInSlot(1,ItemStack.EMPTY);
    }

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
        tag.put("inventory",inventory.serializeNBT(registries));// 序列化nbt并传入注册表
        tag.putInt("analysis_room.progress",progress);// 序列化nbt 传入进度
        tag.putInt("analysis_room.max_progress",max_progress);// 序列化nbt 传入最大进度

        super.saveAdditional(tag, registries);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries,tag.getCompound("inventory"));
        progress = tag.getInt("analysis_room.progress");// 读取进度
        max_progress = tag.getInt("analysis_room.max_progress");// 读取最大进度
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu_text.analysis_room");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AnalysisRoomMenu(i,inventory,this,this.data);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {// 自定义每tick执行的方法
        if(hasRecipe()){// 自定义方法:检测是否有配方
            increaseCraftingProgress();// 自定义方法:增加进度
            setChanged(level,blockPos,blockState);// 保存和同步

            if(hasCraftingFinshed()){// 自定义方法:配方是否制作完成
                craftItem();// 自定义方法:完成物品
                resetProgress();// 自定义方法:重置进度
            }
        }else{
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<RecipeHolder<AnalysisRoomRecipe>> recipe = getCurrentRecipe();// 创建一个类型为AnalysisRoom配方的holder并调用此配方

        ItemStack output = recipe.get().value().output();
        inventory.extractItem(INPUT_SLOT,1,false);
        inventory.setStackInSlot(OUTPUT_SLOT,new ItemStack(output.getItem(),
                inventory.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }
    private void setProgress() {
        Optional<RecipeHolder<AnalysisRoomRecipe>> recipe = getCurrentRecipe();

        int time = recipe.get().value().analysisTime();
        this.max_progress = time;
    }

    private void resetProgress() {
        this.progress = 0;
        this.max_progress = 1200;
    }

    private boolean hasCraftingFinshed() {
        return this.progress >= this.max_progress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<AnalysisRoomRecipe>> recipe = getCurrentRecipe();// 创建一个类型为AnalysisRoom配方的holder并调用此配方
        if(recipe.isEmpty()){
           return false;
        }
        setProgress();// 自定义方法:获取配方中的时间并设置配方时间
        ItemStack output = recipe.get().value().output();// 通过获取的配方来返回获取输出物品
        return canInsetAmountIntoOutputSlot(output.getCount()) && canInsetItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<AnalysisRoomRecipe>> getCurrentRecipe() {
        // 这里的目的是检测所有具有ANALYSIS_ROOM_TYPE类型标签的的配方,并将其与配方输入做对比
        return this.level.getRecipeManager()
                .getRecipeFor(HCRecipes.ANALYSIS_ROOM_TYPE.get(),
                        // 这里将方块实体内物品传入 配方输入类(输入物品处理器)
                        // 他会自动调取matches()方法来比对
                        new AnalysisRoomRecipeInput(inventory.getStackInSlot(INPUT_SLOT)),level);
    }

    private boolean canInsetItemIntoOutputSlot(ItemStack output) {
        return inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                inventory.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsetAmountIntoOutputSlot(int count) {
        int maxCount = inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : inventory.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = inventory.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    // getUpdatePacket 与 getUpdateTag 两个方法用于同步服务器和客户端数据
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

