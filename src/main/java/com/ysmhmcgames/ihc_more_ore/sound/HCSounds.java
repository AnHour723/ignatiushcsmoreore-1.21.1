package com.ysmhmcgames.ihc_more_ore.sound;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HCSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, IgnatiusHCsMoreOre.MODID);// 声音延迟注册器



    // 创建 歌曲-蓝花楹ai
    public static final Supplier<SoundEvent> LANHUAYING_AI = registerSoundEvent("lan_hua_ying_ai");
    public static final ResourceKey<JukeboxSong> LANHUAYING_AI_KEY = createSong("lan_hua_ying_ai");
    // 创建 歌曲-蓝花楹
    public static final Supplier<SoundEvent> LANHUAYING = registerSoundEvent("lan_hua_ying");
    public static final ResourceKey<JukeboxSong> LANHUAYING_KEY = createSong("lan_hua_ying");

    
    // 创建 歌曲-浮沉
    public static final Supplier<SoundEvent> FUCHEN = registerSoundEvent("fu_chen");
    public static final ResourceKey<JukeboxSong> FUCHEN_KEY = createSong("fu_chen");


    private static ResourceKey<JukeboxSong> createSong(String name){// 创建歌曲辅助方法
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name){// 创建音效辅助方法
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }


    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
