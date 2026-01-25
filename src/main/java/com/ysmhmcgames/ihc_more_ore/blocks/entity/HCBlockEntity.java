package com.ysmhmcgames.ihc_more_ore.blocks.entity;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.blocks.hc_entity_block.SoulAltar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCBlockEntity {
    // 注册方块实体总类实例
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, IgnatiusHCsMoreOre.MODID);

    // 方块实体的注册
    // 注册置物台实体
    public static final Supplier<BlockEntityType<DisplayStandEntity>> DISPLAY_STAND_ENTITY =
            BLOCK_ENTITY.register("display_stand_entity",() -> BlockEntityType.Builder.of(
                    DisplayStandEntity::new, HCBlock.DISPLAY_STAND.get() // 将注册的方块实体和具体方块进行绑定
            ).build(null));
    // 注册解析室实体
    public static final Supplier<BlockEntityType<AnalysisRoomBlockEntity>> ANALYSIS_ROOM_BLOCK_ENTITY =
            BLOCK_ENTITY.register("analysis_room_block_entity",() -> BlockEntityType.Builder.of(
                    AnalysisRoomBlockEntity::new, HCBlock.ANALYSIS_ROOM_BLOCK.get() // 将注册的方块实体和具体方块进行绑定
            ).build(null));
    // 注册合金熔炉核心实体
    public static final Supplier<BlockEntityType<AlloyFurnaceCoreBlockEntity>> ALLOY_FURNACE_CORE_BLOCK_ENTITY =
            BLOCK_ENTITY.register("alloy_furnace_core_block_entity",() -> BlockEntityType.Builder.of(
                    AlloyFurnaceCoreBlockEntity::new, HCBlock.ALLOY_FURNACE_CORE_BLOCK.get() // 将注册的方块实体和具体方块进行绑定
            ).build(null));

    // 注册灵魂祭坛实体
    public static final Supplier<BlockEntityType<SoulAltarEntity>> SOUL_ALTAR_ENTITY =
            BLOCK_ENTITY.register("soul_altar_entity",() -> BlockEntityType.Builder.of(
                    SoulAltarEntity::new, HCBlock.SOUL_ALTAR.get() // 将注册的方块实体和具体方块进行绑定
            ).build(null));

    // 注册武器台实体
    public static final Supplier<BlockEntityType<WeaponPlatformEntity>> WEAPON_PLATFORM_ENTITY =
            BLOCK_ENTITY.register("weapon_platform_entity",() -> BlockEntityType.Builder.of(
                    WeaponPlatformEntity::new, HCBlock.WEAPON_PLATFORM.get() // 将注册的方块实体和具体方块进行绑定
            ).build(null));

    // 注册方法 便于注册到总线
    public static void register(IEventBus eventBus){
        BLOCK_ENTITY.register(eventBus);
    }
}