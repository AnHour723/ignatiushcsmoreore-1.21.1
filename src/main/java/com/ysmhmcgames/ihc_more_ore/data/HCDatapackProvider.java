package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.enchantment.HCEnchantments;
import com.ysmhmcgames.ihc_more_ore.worldgen.HCBiomeModifiers;
import com.ysmhmcgames.ihc_more_ore.worldgen.HCConfiguredFeatures;
import com.ysmhmcgames.ihc_more_ore.worldgen.HCPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HCDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, HCConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, HCPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, HCBiomeModifiers::bootstrap)

            .add(Registries.ENCHANTMENT, HCEnchantments::bootstrap)
            ;




    public HCDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(IgnatiusHCsMoreOre.MODID));
    }
}
