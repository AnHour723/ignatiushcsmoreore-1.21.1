package com.ysmhmcgames.ihc_more_ore.blocks.entity;

import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import com.ysmhmcgames.ihc_more_ore.recipe.*;
import com.ysmhmcgames.ihc_more_ore.screen.custom.DisplayStandMenu;
import com.ysmhmcgames.ihc_more_ore.screen.custom.SoulAltarMenu;
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

public class SoulAltarEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(9){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };


    // 对槽位进行命名操作
    private static final int INPUT_SLOT[] = {0,1,2,3,4,5,6,7};// 输入槽位索引
    private static final int NORTH_SLOT = 0;// 输入槽位索引
    private static final int NORTHWEST_SLOT = 1;// 输入槽位索引
    private static final int WEST_SLOT = 2;// 输入槽位索引
    private static final int SOUTHWEST_SLOT = 3;// 输入槽位索引
    private static final int SOUTH = 4;// 输入槽位索引
    private static final int SOUTHEAST_SLOT = 5;// 输入槽位索引
    private static final int EAST_SLOT = 6;// 输入槽位索引
    private static final int NORTHEAST_SLOT = 7;// 输入槽位索引

    private static final int OUTPUT_SLOT = 8;// 输出槽位索引

    protected final ContainerData data;// 容器数据 -> 可以很轻松的让数据在服务器和客户端之间同步
    // 进度的作用: 放入物品时等待时间 以及 可以计算如同熔炉烧制时增长的箭头进度并同步
    private final int MAXP = 1200;
    private int progress = 0;// 进度
    private int max_progress = this.MAXP;// 最大进度
    private int soul_level = 0;// 灵魂等级
    public SoulAltarEntity(BlockPos pos, BlockState blockState) {
        super(HCBlockEntity.SOUL_ALTAR_ENTITY.get(), pos, blockState);
        data = new ContainerData() {// 容器数据  以便正确同步进度和最大进度  从服务器到客户端 以及 从客户端到服务端
            @Override
            public int get(int i) {
                return switch (i){
                    case 0->SoulAltarEntity.this.progress;
                    case 1->SoulAltarEntity.this.max_progress;
                    case 2->SoulAltarEntity.this.soul_level;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i){
                    case 0:SoulAltarEntity.this.progress=value;
                    case 1:SoulAltarEntity.this.max_progress=value;
                    case 2:SoulAltarEntity.this.soul_level=value;
                };
            }

            @Override
            public int getCount() {// 决定要保存多少变量
                return 3;// 此处保存三个 -> 一个当前进度 一个最大进度 一个等级
            }
        };
    }

    public void clearContents(){// 清空方块内所有物品方法
        for(int i = 0; i<9 ;i++){
            inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }


    public void tick(Level level, BlockPos blockPos, BlockState blockState){
        if(hasRecipe()){
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinshed()){
                craftItem();
                resetProgress();
            }
        }else{
            resetProgress();
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<SoulAltarRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()){
            return false;
        }
        ItemStack output = recipe.get().value().output();
        return canInsetAmountIntoOutputSlot(output.getCount()) && canInsetItemIntoOutputSlot(output);
    }
    private Optional<RecipeHolder<SoulAltarRecipe>> getCurrentRecipe() {
        NonNullList<ItemStack> list = NonNullList.create();
        for(int i = 0 ; i < 8 ;i++){
            list.add(inventory.getStackInSlot(i));
        }
        return this.level.getRecipeManager()
                .getRecipeFor(HCRecipes.SOUL_ALTAR_TYPE.get(),
                        new SoulAltarRecipeInput(list),level);
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

    private boolean hasCraftingFinshed() {
        return this.progress >= this.max_progress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void resetProgress() {
        this.progress = 0;
        this.max_progress = this.MAXP;
    }

    private void craftItem() {
        Optional<RecipeHolder<SoulAltarRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().output();
        for(int i = 0 ;i < 8 ;i++ ){
            inventory.extractItem(INPUT_SLOT[i],1,false);
        }
        inventory.setStackInSlot(OUTPUT_SLOT,new ItemStack(output.getItem(),
                inventory.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
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
        super.saveAdditional(tag, registries);
        tag.put("inventory",inventory.serializeNBT(registries));// 序列化nbt并传入注册表
        tag.putInt("soul_altar.progress",progress);// 序列化nbt 传入进度
        tag.putInt("soul_altar.max_progress",max_progress);// 序列化nbt 传入最大进度
        tag.putInt("soul_altar.soul_level",soul_level);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries,tag.getCompound("inventory"));
        progress = tag.getInt("soul_altar.progress");// 读取进度
        max_progress = tag.getInt("soul_altar.max_progress");// 读取最大进度
        soul_level = tag.getInt("soul_altar.soul_level");
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu_text.soul_altar_entity");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SoulAltarMenu(i,inventory,this, this.data);
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
