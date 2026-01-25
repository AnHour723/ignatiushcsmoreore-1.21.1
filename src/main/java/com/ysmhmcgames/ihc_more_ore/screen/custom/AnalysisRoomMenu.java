package com.ysmhmcgames.ihc_more_ore.screen.custom;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.AnalysisRoomBlockEntity;
import com.ysmhmcgames.ihc_more_ore.screen.HCMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;


public class AnalysisRoomMenu extends AbstractContainerMenu {
    public final AnalysisRoomBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    public AnalysisRoomMenu(int containerId, Inventory inv, FriendlyByteBuf extraFata) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraFata.readBlockPos()),new SimpleContainerData(2));
    }

    public AnalysisRoomMenu(int containerId, Inventory inv, BlockEntity blockEntity, ContainerData data) {
        super(HCMenuTypes.ANALYSIS_ROOM_MENU.get(), containerId);
        this.blockEntity = ((AnalysisRoomBlockEntity)blockEntity);
        this.level=inv.player.level();
        this.data = data;

        addPlayerInventory(inv);// 在菜单中生成背包栏位
        addPlayerHotbar(inv);// 在菜单中生成快捷栏位

        this.addSlot(new SlotItemHandler(this.blockEntity.inventory,0,54,35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory,1,105,35));

        this.addDataSlots(data);// 同步数据 同步progress与max_progress
    }

    // 可以使用data数据 编写下面两个方法
    public boolean isCrafting(){// 自定义方法:检测是否在制作
        return data.get(0) > 0;
    }
    public int getScaledPProgressProgress(){// 自定义方法:计算"箭头"的进度
        int progress = this.data.get(0);
        int max_progress = this.data.get(1);
        int pProgressPixelSize = 31;

        return max_progress != 0 && progress != 0 ? progress * pProgressPixelSize / max_progress : 0;
    }

    private static final int TE_INVENTORY_SLOT_COUNT = 2;// 自定义方块实体的库存槽 (可根据自定义库存槽数量更改)
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem())return ItemStack.EMPTY;
        ItemStack sourceStack =sourceSlot.getItem();
        ItemStack copyOfSourceStack =sourceStack.copy();

        if(pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT){
            if(!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)){
                return ItemStack.EMPTY;
            }
        }else if(pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT){
            if(!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)){
                return ItemStack.EMPTY;
            }
        }else{
            System.out.println("slotIndex:"+pIndex);
            return ItemStack.EMPTY;
        }

        if(sourceStack.getCount() == 0){
            sourceSlot.set(ItemStack.EMPTY);
        }else{
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn,sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level,blockEntity.getBlockPos()),
                player, HCBlock.ANALYSIS_ROOM_BLOCK.get());
    }

    private void addPlayerInventory(Inventory playerInventory){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9 , 8 + j *18, 86 + i * 18));
            }

        }
    }
    private void addPlayerHotbar(Inventory playerInventory){
        for(int i = 0; i < 9; ++i){
            this.addSlot(new Slot(playerInventory, i , 8+i*18, 144));
        }
    }
}
