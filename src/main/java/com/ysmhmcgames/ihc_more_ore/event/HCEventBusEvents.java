package com.ysmhmcgames.ihc_more_ore.event;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import com.ysmhmcgames.ihc_more_ore.entity.client.YangProjectileModel;
import com.ysmhmcgames.ihc_more_ore.entity.client.YinProjectileModel;
import com.ysmhmcgames.ihc_more_ore.renderer.TranslucentLivingLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Random;


@EventBusSubscriber(modid = IgnatiusHCsMoreOre.MODID)
public class HCEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(YinProjectileModel.LAYER_LOCATION, YinProjectileModel::createBodyLayer);
        event.registerLayerDefinition(YangProjectileModel.LAYER_LOCATION, YangProjectileModel::createBodyLayer);
    }

    // 对药水效果受伤事件特殊处理
    // LivingIncomingDamageEvent 用于处理实体受伤事件的核心类 => 专门用于修改伤害值的事件
    @SubscribeEvent
    public static void onLivingDamageForEffect(LivingIncomingDamageEvent event){
        LivingEntity entity = event.getEntity();


        // 量子化药水效果 处理
        if(entity.hasEffect(HCEffects.QUANTIFICATION_EFFECT)){
            if(new Random().nextFloat() < 0.5f){
                // 伤害设置为0
                // event.setAmount(0.0f);
                // 取消当前事件
                event.setCanceled(true);
            }
        }

        // 脆弱药水效果 处理
        if(entity.hasEffect(HCEffects.FRAIL_EFFECT)){
            // 获取等级
            int lvl = entity.getEffect(HCEffects.FRAIL_EFFECT).getAmplifier();
            // 计算伤害倍增：基础1倍 + 0.5×等级
            float multiplier = 1.0f + (0.5f * (lvl + 1));

            event.setAmount(event.getAmount() * multiplier);
        }

        // 闪耀药水效果 处理
        // 为实体回复生命值
        if(entity.hasEffect(HCEffects.GLISTENING_EFFECT)){
            // 获取等级
            int lvl = entity.getEffect(HCEffects.GLISTENING_EFFECT).getAmplifier();
            // 回复生命
            entity.heal(2 + lvl);

        }


    }


}
