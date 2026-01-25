package com.ysmhmcgames.ihc_more_ore.enchantment;

import com.mojang.serialization.MapCodec;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.ElementCollectionEnchantmentEffect;
import com.ysmhmcgames.ihc_more_ore.enchantment.custom.SoulHarvestEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, IgnatiusHCsMoreOre.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> ELEMENT_COLLECTION =
            ENTITY_ENCHANTMENT_EFFECTS.register("element_collection", () -> ElementCollectionEnchantmentEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SOUL_HARVEST =
            ENTITY_ENCHANTMENT_EFFECTS.register("soul_harvest", () -> SoulHarvestEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus){
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
