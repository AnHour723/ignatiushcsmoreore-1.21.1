package com.ysmhmcgames.ihc_more_ore.enchantment;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, IgnatiusHCsMoreOre.MODID);
    // 元素采集 element collection
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> ELEMENT_COLLECTION =
            ENTITY_ENCHANTMENT_EFFECTS.register("element_collection", () -> ElementCollectionEnchantmentEffect.CODEC);
    // 灵魂收割 soul harvest
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SOUL_HARVEST =
            ENTITY_ENCHANTMENT_EFFECTS.register("soul_harvest", () -> SoulHarvestEnchantmentEffect.CODEC);
    // 安全收割 safe harvest
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SAFE_HARVEST =
            ENTITY_ENCHANTMENT_EFFECTS.register("safe_harvest", () -> SafeHarvestEnchantmentEffect.CODEC);
    // 撕裂 tear
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> TEAR =
            ENTITY_ENCHANTMENT_EFFECTS.register("tear", () -> TearEnchantmentEffect.CODEC);
    // 趁手 handy
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> HANDY =
            ENTITY_ENCHANTMENT_EFFECTS.register("handy", () -> HandyEnchantmentEffect.CODEC);
    // 精通 proficient
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> PROFICIENT =
            ENTITY_ENCHANTMENT_EFFECTS.register("proficient", () -> ProficientEnchantmentEffect.CODEC);
    // 破伤风 tetanus
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> TETANUS =
            ENTITY_ENCHANTMENT_EFFECTS.register("tetanus", () -> TetanusEnchantmentEffect.CODEC);


    public static void register(IEventBus eventBus){
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
