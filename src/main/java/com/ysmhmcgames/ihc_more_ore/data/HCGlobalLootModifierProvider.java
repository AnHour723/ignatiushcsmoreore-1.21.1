package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HCGlobalLootModifierProvider extends GlobalLootModifierProvider { // 战利品表提供者

    public HCGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, IgnatiusHCsMoreOre.MODID);
    }

    @Override
    protected void start() {
        /*===================主世界一般结构结构=======================*/
        this.addSimpleOverworld(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ));
        /*====================海洋结构======================*/
        this.addOcean(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ));
        /*====================古代结构======================*/
        this.addAncientStructure(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get(),
                HCItems.PRISMATIC_COLORFUL_UPGRADE_TEMPLATE.get(),
                HCItems.OVERWORLD_UPGRADE_TEMPLATE.get()
        ));
        /*====================下界结构======================*/
        this.addNether(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get(),
                HCItems.NETHER_UPGRADE_TEMPLATE.get()
        ));
        /*====================末地结构======================*/
        this.addEndCityTreasure(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get(),
                HCItems.END_UPGRADE_TEMPLATE.get(),
                HCItems.COLLAPSING_UPGRADE_TEMPLATE.get(),
                HCItems.POLE_BOW_UPGRADE_TEMPLATE.get()
        ));
        /*===================掠夺者前哨站====================*/
        this.addPillagerOutpost(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ));


        /*===================主世界结构=======================*/
        // abandoned_mineshaft 废弃矿井
        // desert_pyramid 沙漠神殿
        // jungle_temple 丛林神庙
        // jungle_temple_dispenser 丛林神庙发射器
        // igloo_chest 雪屋地下室
        // simple_dungeon 地牢
        // stronghold_corridor 要塞走廊
        // stronghold_crossing 要塞十字路口
        // stronghold_library 要塞图书馆
        // woodland_mansion 林地府邸
        // underwater_ruin_big 大型海底废墟
        // underwater_ruin_small 小型海底废墟
        /*====================海洋结构======================*/
        // buried_treasure 埋藏的宝藏
        // shipwreck_map 沉船地图
        // shipwreck_supply 沉船补给箱
        // shipwreck_treasure 沉船宝箱
        /*====================下界结构======================*/
        // bastion_bridge 堡垒遗迹-桥梁
        // bastion_hoglin_stable 堡垒遗迹-猪灵厩
        // bastion_other 堡垒遗迹-其他
        // bastion_treasure 堡垒遗迹-宝藏
        // nether_bridge 下界要塞
        // ruined_portal 废弃传送门
        /*====================古代结构======================*/
        // ancient_city 远古城市
        // ancient_city_ice_box 远古城市冰库
        /*====================末地结构======================*/
        // end_city_treasure 末地城
        /*====================其他结构======================*/
        // pillager_outpost 掠夺者前哨站
        // spawn_bonus_chest 出生点奖励箱


    }

    /*===================主世界一般结构结构=======================*/
    private void addSimpleOverworld(List<Item> items){
        this.addAbandonedMineshaft(items);
        this.addDesertPyramid(items);
        this.addJungleTemple(items);
        this.addJungleTempleDispenser(items);
        this.addIglooChest(items);
        this.addSimpleDungeon(items);
        this.addStrongholdCorridor(items);
        this.addStrongholdCrossing(items);
        this.addStrongholdLibrary(items);
        this.addWoodlandMansion(items);
        this.addUnderwaterRuinBig(items);
        this.addUnderwaterRuinSmall(items);
    }

    /*====================古代结构======================*/
    private void addAncientStructure(List<Item> items){
        this.addAncientCity(items);
        this.addAncientCityIceBox(items);
    }

    /*====================海洋结构======================*/
    private void addOcean(List<Item> items){
        this.addBuriedTreasure(items);
        this.addShipwreckMap(items);
        this.addShipwreckSupply(items);
        this.addShipwreckTreasure(items);
    }

    /*====================下界结构======================*/
    private void addNether(List<Item> items){
        this.addBastionBridge(items);
        this.addBastionHoglinStable(items);
        this.addBastionOther(items);
        this.addBastionTreasure(items);
        this.addNetherBridge(items);
        this.addRuinedPortal(items);
    }

    /*===================主世界结构=======================*/
    // abandoned_mineshaft 废弃矿井
    private void addAbandonedMineshaft(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_abandoned_mineshaft",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build()
                    }, item));
        }
    }
    // desert_pyramid 沙漠神殿
    private void addDesertPyramid(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_desert_pyramid",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build()
                    }, item));
        }
    }
    // jungle_temple 丛林神庙
    private void addJungleTemple(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_jungle_temple",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                    }, item));
        }
    }
    // jungle_temple_dispenser 丛林神庙发射器
    private void addJungleTempleDispenser(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_jungle_temple_dispenser",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple_dispenser")).build()
                    }, item));
        }
    }
    // igloo_chest 雪屋地下室
    private void addIglooChest(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_igloo_chest",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/igloo_chest")).build()
                    }, item));
        }
    }
    // simple_dungeon 地牢
    private void addSimpleDungeon(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_simple_dungeon",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build()
                    }, item));
        }
    }
    // stronghold_corridor 要塞走廊
    private void addStrongholdCorridor(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_stronghold_corridor",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor")).build()
                    }, item));
        }
    }
    // stronghold_crossing 要塞十字路口
    private void addStrongholdCrossing(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_stronghold_crossing",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing")).build()
                    }, item));
        }
    }
    // stronghold_library 要塞图书馆
    private void addStrongholdLibrary(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_stronghold_library",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_library")).build()
                    }, item));
        }
    }
    // woodland_mansion 林地府邸
    private void addWoodlandMansion(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_woodland_mansion",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/woodland_mansion")).build()
                    }, item));
        }
    }
    // underwater_ruin_big 大型海底废墟
    private void addUnderwaterRuinBig(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_underwater_ruin_big",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_big")).build()
                    }, item));
        }
    }
    // underwater_ruin_small 小型海底废墟
    private void addUnderwaterRuinSmall(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_underwater_ruin_small",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_small")).build()
                    }, item));
        }
    }

    /*====================海洋结构======================*/
    // buried_treasure 埋藏的宝藏
    private void addBuriedTreasure(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_buried_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/buried_treasure")).build()
                    }, item));
        }
    }
    // shipwreck_map 沉船地图
    private void addShipwreckMap(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_shipwreck_map",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_map")).build()
                    }, item));
        }
    }
    // shipwreck_supply 沉船补给箱
    private void addShipwreckSupply(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_shipwreck_supply",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build()
                    }, item));
        }
    }
    // shipwreck_treasure 沉船宝箱
    private void addShipwreckTreasure(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_shipwreck_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure")).build()
                    }, item));
        }
    }

    /*====================下界结构======================*/
    // bastion_bridge 堡垒遗迹-桥梁
    private void addBastionBridge(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_bastion_bridge",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_bridge")).build()
                    }, item));
        }
    }
    // bastion_hoglin_stable 堡垒遗迹-猪灵厩
    private void addBastionHoglinStable(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_bastion_hoglin_stable",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable")).build()
                    }, item));
        }
    }
    // bastion_other 堡垒遗迹-其他
    private void addBastionOther(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_bastion_other",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_other")).build()
                    }, item));
        }
    }
    // bastion_treasure 堡垒遗迹-宝藏
    private void addBastionTreasure(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_bastion_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build()
                    }, item));
        }
    }
    // nether_bridge 下界要塞
    private void addNetherBridge(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_nether_bridge",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/nether_bridge")).build()
                    }, item));
        }
    }
    // ruined_portal 废弃传送门
    private void addRuinedPortal(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_ruined_portal",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ruined_portal")).build()
                    }, item));
        }
    }

    /*====================古代结构======================*/
    // ancient_city 远古城市
    private void addAncientCity(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_ancient_city",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build()
                    }, item));
        }
    }
    // ancient_city_ice_box 远古城市冰库
    private void addAncientCityIceBox(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_ancient_city_ice_box",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city_ice_box")).build()
                    }, item));
        }
    }

    /*====================末地结构======================*/
    // end_city_treasure 末地城
    private void addEndCityTreasure(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_end_city_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build()
                    }, item));
        }
    }

    /*====================其他结构======================*/
    // pillager_outpost 掠夺者前哨站
    private void addPillagerOutpost(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_pillager_outpost",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost")).build()
                    }, item));
        }
    }
    // spawn_bonus_chest 出生点奖励箱
    private void addSpawnBonusChest(List<Item> items){
        for(Item item:items){
            this.add("chisel_from_spawn_bonus_chest",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/spawn_bonus_chest")).build()
                    }, item));
        }
    }

}
