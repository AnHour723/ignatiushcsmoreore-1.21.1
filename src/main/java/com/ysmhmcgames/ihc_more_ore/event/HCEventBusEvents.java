package com.ysmhmcgames.ihc_more_ore.event;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.entity.client.YangProjectileModel;
import com.ysmhmcgames.ihc_more_ore.entity.client.YinProjectileModel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


@EventBusSubscriber(modid = IgnatiusHCsMoreOre.MODID)
public class HCEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(YinProjectileModel.LAYER_LOCATION, YinProjectileModel::createBodyLayer);
        event.registerLayerDefinition(YangProjectileModel.LAYER_LOCATION, YangProjectileModel::createBodyLayer);
    }
}
