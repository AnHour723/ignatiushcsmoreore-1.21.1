package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

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
        ),0.5f);
        /*====================海洋结构======================*/
        this.addOcean(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ),0.5f);
        /*====================古代结构======================*/
        this.addAncientStructure(List.of(
                HCItems.OVERWORLD_UPGRADE_TEMPLATE.get()
        ),0.25f);
        this.addAncientStructure(List.of(
                HCItems.PRISMATIC_COLORFUL_UPGRADE_TEMPLATE.get()
        ),0.4f);
        this.addAncientStructure(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ),0.7f);
        /*====================下界结构======================*/
        this.addNether(List.of(
                HCItems.NETHER_UPGRADE_TEMPLATE.get()
        ),0.25f);
        this.addNether(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ),0.7f);
        /*====================末地结构======================*/
        this.addEndCityTreasure(List.of(
                HCItems.END_UPGRADE_TEMPLATE.get()
        ),0.25f);
        this.addEndCityTreasure(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get(),
                HCItems.COLLAPSING_UPGRADE_TEMPLATE.get(),
                HCItems.POLE_BOW_UPGRADE_TEMPLATE.get()
        ),0.4f);
        this.addEndCityTreasure(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ),0.7f);
        /*===================掠夺者前哨站====================*/
        this.addPillagerOutpost(List.of(
                HCItems.GLASS_CRYSTALLIZATION_TEMPLATE.get()
        ),0.7f);


        // stronghold_corridor 要塞走廊
        this.addStrongholdCorridor(List.of(
                HCItems.LANHUAYING_AI_MUSIC_DISC.get(),
                HCItems.LANHUAYING_MUSIC_DISC.get()
        ),0.36f);

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
    private void addSimpleOverworld(List<Item> items, float r){
        this.addAbandonedMineshaft(items, r);
        this.addDesertPyramid(items, r);
        this.addJungleTemple(items, r);
        this.addJungleTempleDispenser(items, r);
        this.addIglooChest(items, r);
        this.addSimpleDungeon(items, r);
        this.addStrongholdCorridor(items, r);
        this.addStrongholdCrossing(items, r);
        this.addStrongholdLibrary(items, r);
        this.addWoodlandMansion(items, r);
        this.addUnderwaterRuinBig(items, r);
        this.addUnderwaterRuinSmall(items, r);
    }

    /*====================古代结构======================*/
    private void addAncientStructure(List<Item> items, float r){
        this.addAncientCity(items, r);
        this.addAncientCityIceBox(items, r);
    }

    /*====================海洋结构======================*/
    private void addOcean(List<Item> items, float r){
        this.addBuriedTreasure(items, r);
        this.addShipwreckMap(items, r);
        this.addShipwreckSupply(items, r);
        this.addShipwreckTreasure(items, r);
    }

    /*====================下界结构======================*/
    private void addNether(List<Item> items, float r){
        this.addBastionBridge(items, r);
        this.addBastionHoglinStable(items, r);
        this.addBastionOther(items, r);
        this.addBastionTreasure(items, r);
        this.addNetherBridge(items, r);
        this.addRuinedPortal(items, r);
    }

    /*===================主世界结构=======================*/
    // abandoned_mineshaft 废弃矿井
    private void addAbandonedMineshaft(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_abandoned_mineshaft",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // desert_pyramid 沙漠神殿
    private void addDesertPyramid(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_desert_pyramid",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // jungle_temple 丛林神庙
    private void addJungleTemple(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_jungle_temple",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // jungle_temple_dispenser 丛林神庙发射器
    private void addJungleTempleDispenser(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_jungle_temple_dispenser",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple_dispenser")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // igloo_chest 雪屋地下室
    private void addIglooChest(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_igloo_chest",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/igloo_chest")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // simple_dungeon 地牢
    private void addSimpleDungeon(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_simple_dungeon",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // stronghold_corridor 要塞走廊
    private void addStrongholdCorridor(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_stronghold_corridor",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // stronghold_crossing 要塞十字路口
    private void addStrongholdCrossing(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_stronghold_crossing",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // stronghold_library 要塞图书馆
    private void addStrongholdLibrary(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_stronghold_library",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_library")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // woodland_mansion 林地府邸
    private void addWoodlandMansion(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_woodland_mansion",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/woodland_mansion")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // underwater_ruin_big 大型海底废墟
    private void addUnderwaterRuinBig(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_underwater_ruin_big",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_big")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // underwater_ruin_small 小型海底废墟
    private void addUnderwaterRuinSmall(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_underwater_ruin_small",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_small")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

    /*====================海洋结构======================*/
    // buried_treasure 埋藏的宝藏
    private void addBuriedTreasure(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_buried_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/buried_treasure")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // shipwreck_map 沉船地图
    private void addShipwreckMap(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_shipwreck_map",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_map")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // shipwreck_supply 沉船补给箱
    private void addShipwreckSupply(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_shipwreck_supply",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // shipwreck_treasure 沉船宝箱
    private void addShipwreckTreasure(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_shipwreck_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

    /*====================下界结构======================*/
    // bastion_bridge 堡垒遗迹-桥梁
    private void addBastionBridge(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_bastion_bridge",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_bridge")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // bastion_hoglin_stable 堡垒遗迹-猪灵厩
    private void addBastionHoglinStable(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_bastion_hoglin_stable",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // bastion_other 堡垒遗迹-其他
    private void addBastionOther(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_bastion_other",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_other")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // bastion_treasure 堡垒遗迹-宝藏
    private void addBastionTreasure(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_bastion_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // nether_bridge 下界要塞
    private void addNetherBridge(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_nether_bridge",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/nether_bridge")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // ruined_portal 废弃传送门
    private void addRuinedPortal(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_ruined_portal",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ruined_portal")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

    /*====================古代结构======================*/
    // ancient_city 远古城市
    private void addAncientCity(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_ancient_city",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // ancient_city_ice_box 远古城市冰库
    private void addAncientCityIceBox(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_ancient_city_ice_box",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city_ice_box")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

    /*====================末地结构======================*/
    // end_city_treasure 末地城
    private void addEndCityTreasure(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_end_city_treasure",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

    /*====================其他结构======================*/
    // pillager_outpost 掠夺者前哨站
    private void addPillagerOutpost(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_pillager_outpost",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }
    // spawn_bonus_chest 出生点奖励箱
    private void addSpawnBonusChest(List<Item> items, float r){
        for(Item item:items){
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            String itemName = itemId.getPath();
            this.add(itemName + "_from_spawn_bonus_chest",
                    new AddItemModifier(new LootItemCondition[]{
                            new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/spawn_bonus_chest")).build(),
                            new LootItemRandomChanceCondition(ConstantValue.exactly(r))  // 固定r概率
                    }, item));
        }
    }

}
