package com.ysmhmcgames.ihc_more_ore.blocks.entity;

import com.ysmhmcgames.ihc_more_ore.recipe.*;
import com.ysmhmcgames.ihc_more_ore.screen.custom.AlloyFurnaceCoreMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
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

public class AlloyFurnaceCoreBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(12){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };
    // 对槽位进行命名操作
    private static final int INPUT_SLOT[] = {0,1,2,3,4,5,6,7,8,9};// 输入槽位索引
    private static final int FUEL_SLOT = 10;// 燃料槽位索引
    private static final int OUTPUT_SLOT = 11;// 输出槽位索引

    protected final ContainerData data;// 容器数据 -> 可以很轻松的让数据在服务器和客户端之间同步
    // 进度的作用: 放入物品时等待时间 以及 可以计算如同熔炉烧制时增长的箭头进度并同步
    private int progress = 0;// 进度
    private int max_progress = 200;// 最大进度
    private int fuel = 0;// 燃料进度
    private int max_fuel = 1600;// 燃料进度

    public AlloyFurnaceCoreBlockEntity(BlockPos pos, BlockState blockState) {
        super(HCBlockEntity.ALLOY_FURNACE_CORE_BLOCK_ENTITY.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> AlloyFurnaceCoreBlockEntity.this.progress;
                    case 1 -> AlloyFurnaceCoreBlockEntity.this.max_progress;
                    case 2 -> AlloyFurnaceCoreBlockEntity.this.fuel;
                    case 3 -> AlloyFurnaceCoreBlockEntity.this.max_fuel;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i){
                    case 0:AlloyFurnaceCoreBlockEntity.this.progress = value;
                    case 1:AlloyFurnaceCoreBlockEntity.this.max_progress = value;
                    case 2:AlloyFurnaceCoreBlockEntity.this.fuel = value;
                    case 3:AlloyFurnaceCoreBlockEntity.this.max_fuel = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    public void clearContents(){
        for(int i = 0; i < 12; i++ ){
            inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }


    public void drop(){
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i=0;i<inventory.getSlots();i++){
            inv.setItem(i,inventory.getStackInSlot(i));
        }
        // 调用Containers的dropContents(容器掉落内容)的方法
        Containers.dropContents(this.level,this.worldPosition,inv);// 该方法需要一个存储内容，这里用前面的物品栈堆处理器来处理同步等操作
    }


    public boolean tick(Level pLevel, BlockPos blockPos, BlockState blockState) {
        // 自定义方法*2:检测是否有配方 + 检测是否有燃料
        if(hasRecipe() && isFuel()){
            //if(hasFuel()){
                increaseCraftingProgress();// 自定义方法:增加进度
                setChanged(level,blockPos,blockState);// 保存和同步

                if(hasCraftingFinshed()){// 自定义方法:配方是否制作完成
                    craftItem();// 自定义方法:完成物品
                    resetProgress();// 自定义方法:重置进度
                }
            //}
        }else{
            resetProgress();
        }
        if(this.fuel > 0){
            decreaseFuel();// 自定义方法:减少燃料值
        }
        return fuel > 0;
    }

    private void decreaseFuel() {
        fuel--;
    }

    public void setFuelValue() {
        Optional<RecipeHolder<FuelRecipe>> recipe = getFuelRecipe();
        inventory.extractItem(FUEL_SLOT,1,false);
        this.fuel = recipe.get().value().fuelValue();
    }

    private boolean isFuel() {

        if(this.fuel <= 0){
            if(hasFuel()){
                setFuelValue();
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
    private boolean hasFuel() {
        Optional<RecipeHolder<FuelRecipe>> recipe = getFuelRecipe();
        if(recipe.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private void craftItem() {
        Optional<RecipeHolder<AlloyFurnaceCoreRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().output();
        for(int i = 0 ;i < 10 ;i++ ){
            inventory.extractItem(INPUT_SLOT[i],1,false);
        }
        inventory.setStackInSlot(OUTPUT_SLOT,new ItemStack(output.getItem(),
                inventory.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
        this.max_progress = 200;
    }

    private boolean hasCraftingFinshed() {
        return this.progress >= this.max_progress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<AlloyFurnaceCoreRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()){
            return false;
        }
        ItemStack output = recipe.get().value().output();
        return canInsetAmountIntoOutputSlot(output.getCount()) && canInsetItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<FuelRecipe>> getFuelRecipe() {
        // 这里的目的是检测所有具有ANALYSIS_ROOM_TYPE类型标签的的配方,并将其与配方输入做对比
        return this.level.getRecipeManager()
                .getRecipeFor(HCRecipes.FUEL_TYPE.get(),
                        // 这里将方块实体内物品传入 配方输入类(输入物品处理器)
                        // 他会自动调取matches()方法来比对
                        new FuelRecipeInput(inventory.getStackInSlot(FUEL_SLOT)),level);
    }

    private Optional<RecipeHolder<AlloyFurnaceCoreRecipe>> getCurrentRecipe() {
        NonNullList<ItemStack> list = NonNullList.create();
        for(int i = 0 ; i < 10 ;i++){
            list.add(inventory.getStackInSlot(i));
        }
        return this.level.getRecipeManager()
                .getRecipeFor(HCRecipes.FURNACE_CORE_TYPE.get(),
                        new AlloyFurnaceCoreRecipeInput(list),level);
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


    // 以下两个方法 用于保存和加载  将物品用nbt方式保存，这样可以永久保存(不写则每次离开世界会更新让方块内物品消失)
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory",inventory.serializeNBT(registries));// 序列化nbt并传入注册表
        tag.putInt("alloy_furnace_core.progress",progress);// 序列化nbt 传入进度
        tag.putInt("alloy_furnace_core.max_progress",max_progress);// 序列化nbt 传入最大进度
        tag.putInt("alloy_furnace_core.fuel",fuel);// 序列化nbt 传入最大进度
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries,tag.getCompound("inventory"));
        progress = tag.getInt("alloy_furnace_core.progress");// 读取进度
        max_progress = tag.getInt("alloy_furnace_core.max_progress");// 读取最大进度
        fuel = tag.getInt("alloy_furnace_core.fuel");
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu_text.alloy_furnace_core");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AlloyFurnaceCoreMenu(i,inventory,this, this.data);
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
