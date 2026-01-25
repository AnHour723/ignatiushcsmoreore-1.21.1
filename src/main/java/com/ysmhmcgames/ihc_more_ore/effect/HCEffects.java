package com.ysmhmcgames.ihc_more_ore.effect;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, IgnatiusHCsMoreOre.MODID);

    /*
     MobEffectCategory 中
            BENEFICIAL: 对生物有益的
            HARMFUL: 对生物有害的
            NEUTRAL: 对生物既不好也不坏的
     */
    // 可以像这样到此结束 完成一个简易的效果注册
//    public static final Holder<MobEffect> BLEEDING_EFFECT = MOB_EFFECTS.register("bleeding",
//            () -> new BleedingEffect(MobEffectCategory.HARMFUL,0x8b0000));

    // 或者像这样 附赠修改属性在药水持续时间内
    public static final Holder<MobEffect> BLEEDING_EFFECT = MOB_EFFECTS.register("bleeding",
            () -> new BleedingEffect(MobEffectCategory.HARMFUL,0x8b0000)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,// 修改属性为移动速度
                            // 修改器标识符 唯一标识这个属性修改器 防止不同模组的修改器冲突
                            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"bleeding"),
                            -0.25f,// 值为-0.25
                            /* 这里表示根据上值计算
                                ADD_MULTIPLIED_TOTAL    最终值 = 基础值 × (1 + 修改值)   百分比修改
                                ADD_VALUE               最终值 = 基础值 + 修改值         直接加减
                                ADD_MULTIPLIED_BASE    基础值 = 基础值 × (1 + 修改值)   修改基础值
                            */
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> YANG_EFFECT = MOB_EFFECTS.register("yang",
            () -> new YangEffect(MobEffectCategory.NEUTRAL,0x000000));
    public static final Holder<MobEffect> YIN_EFFECT = MOB_EFFECTS.register("yin",
            () -> new YinEffect(MobEffectCategory.NEUTRAL,0xffffff));

    public static final Holder<MobEffect> FIREPROOF_EFFECT = MOB_EFFECTS.register("fireproof",
            () -> new FireproofEffect(MobEffectCategory.BENEFICIAL,0xe65b3b));
    public static final Holder<MobEffect> COLD_RESISTANT_EFFECT = MOB_EFFECTS.register("cold_resistant",
            () -> new ColdResistantEffect(MobEffectCategory.BENEFICIAL,0x40aadb));
    public static final Holder<MobEffect> SANCTUARY_EFFECT = MOB_EFFECTS.register("sanctuary",
            () -> new SanctuaryEffect(MobEffectCategory.BENEFICIAL,0xF5F5DC));


    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
