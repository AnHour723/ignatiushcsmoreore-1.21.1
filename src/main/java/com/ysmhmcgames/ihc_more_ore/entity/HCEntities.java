package com.ysmhmcgames.ihc_more_ore.entity;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.entity.custom.YangProjectileEntity;
import com.ysmhmcgames.ihc_more_ore.entity.custom.YinProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, IgnatiusHCsMoreOre.MODID);

    public static final Supplier<EntityType<YinProjectileEntity>>  YIN_ARROW =
            ENTITY_TYPES.register("yin_arrow", () -> EntityType.Builder.<YinProjectileEntity>of(YinProjectileEntity::new, MobCategory.MISC)
                    .sized(0.2f,0.2f).build("yin_arrow"));
    public static final Supplier<EntityType<YangProjectileEntity>>  YANG_ARROW =
            ENTITY_TYPES.register("yang_arrow", () -> EntityType.Builder.<YangProjectileEntity>of(YangProjectileEntity::new, MobCategory.MISC)
                    .sized(0.2f,0.2f).build("yang_arrow"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
