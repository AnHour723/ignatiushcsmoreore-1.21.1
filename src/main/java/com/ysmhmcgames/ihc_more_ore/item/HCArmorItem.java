package com.ysmhmcgames.ihc_more_ore.item;

import com.google.common.collect.ImmutableMap;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

// 全套效果
public class HCArmorItem extends ArmorItem {
    public static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>,List<MobEffectInstance>>())
                    .put(HCArmorMaterials.POSEIDON_ARMOR_MATERIAL,
                            // MobEffectInstance类两个布尔值，第一个为例子是否显示(t为不显示)，第二个为ui(背包ui不受影响)是否显示(f为不显示)
                            List.of(new MobEffectInstance(MobEffects.WATER_BREATHING,200,0,true,false)))
                    .put(HCArmorMaterials.ROSE_ARMOR_MATERIAL,
                            // MobEffectInstance类两个布尔值，第一个为例子是否显示(t为不显示)，第二个为ui是否显示(t为不显示)
                            List.of(new MobEffectInstance(MobEffects.REGENERATION,200,0,true,false)))
                    .put(HCArmorMaterials.EMPEROR_S_ARMOR_MATERIAL,
                            // MobEffectInstance类两个布尔值，第一个为例子是否显示(t为不显示)，第二个为ui是否显示(t为不显示)
                            List.of(new MobEffectInstance(MobEffects.INVISIBILITY,200,1,true,false)))
                    .put(HCArmorMaterials.HOLY_STEEL_ARMOR_MATERIAL,
                            // MobEffectInstance类两个布尔值，第一个为例子是否显示(t为不显示)，第二个为ui是否显示(t为不显示)
                            List.of(new MobEffectInstance(HCEffects.SANCTUARY_EFFECT,200,0,true,false)))
                    .build();

    public HCArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)){
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()){
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorMaterial(mapArmorMaterial, player)){
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect){
            for(MobEffectInstance effect : mapEffect){
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorMaterial(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
