package com.ysmhmcgames.ihc_more_ore.data_attachment;

import com.mojang.serialization.Codec;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCComponents {

    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, IgnatiusHCsMoreOre.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>// 注册骰子随机点数
            DICE_DATA = COMPONENTS.register("dice_data", () ->
            DataComponentType.<Integer>builder()
                    .persistent(Codec.INT) // 磁盘序列化
                    .networkSynchronized( // 网络同步
                            net.minecraft.network.codec.ByteBufCodecs.VAR_INT)
                    .build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>// 注册骰子总点数
            DICE_TOTAL_DATA = COMPONENTS.register("dice_total_data", () ->
            DataComponentType.<Integer>builder()
                    .persistent(Codec.INT) // 磁盘序列化
                    .networkSynchronized( // 网络同步
                            net.minecraft.network.codec.ByteBufCodecs.VAR_INT)
                    .build()
    );

}
