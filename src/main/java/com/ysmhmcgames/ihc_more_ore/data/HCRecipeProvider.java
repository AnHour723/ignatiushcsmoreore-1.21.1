package com.ysmhmcgames.ihc_more_ore.data;

import com.ysmhmcgames.ihc_more_ore.blocks.HCBlock;
import com.ysmhmcgames.ihc_more_ore.item.HCArmor;
import com.ysmhmcgames.ihc_more_ore.item.HCItems;
import com.ysmhmcgames.ihc_more_ore.item.HCOreItem;
import com.ysmhmcgames.ihc_more_ore.item.HCTools;
import com.ysmhmcgames.ihc_more_ore.util.HCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HCRecipeProvider extends RecipeProvider implements IConditionBuilder {// 配方提供者
    public HCRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        /*===============================模组矿石 && 方块==============================================*/
        // 粗铝块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.RAW_ALUMINUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.RAW_ALUMINUM.get())
                .unlockedBy("has_raw_aluminum",has(HCOreItem.RAW_ALUMINUM))
                .save(recipeOutput);
        // 铝块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.ALUMINUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 铝锭 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.ALUMINUM_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.ALUMINUM_NUGGET.get())
                .unlockedBy("has_aluminum_nugget",has(HCOreItem.ALUMINUM_NUGGET))
                .save(recipeOutput,"ignatiushcsmoreore:aluminum_ingot_from_aluminum_nugget");
        // 铝粒 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.ALUMINUM_NUGGET.get(),9)
                .requires(HCOreItem.ALUMINUM_INGOT)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:aluminum_nugget_from_aluminum_ingot");
        // 粗铝 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.RAW_ALUMINUM.get(),9)
                .requires(HCBlock.RAW_ALUMINUM_BLOCK)
                .unlockedBy("has_raw_aluminum_block",has(HCBlock.RAW_ALUMINUM_BLOCK))
                .save(recipeOutput);
        // 铝锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.ALUMINUM_INGOT.get(),9)
                .requires(HCBlock.ALUMINUM_BLOCK)
                .unlockedBy("has_aluminum_block",has(HCBlock.ALUMINUM_BLOCK))
                .save(recipeOutput);


        // 铝矿
        List<ItemLike> ALUMINUM_SMELTABLES = List.of(HCOreItem.RAW_ALUMINUM,
                HCBlock.ALUMINUM_ORE,HCBlock.DEEPSLATE_ALUMINUM_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, HCOreItem.ALUMINUM_INGOT.get(),0.25f,200,"aluminum");
        // 高炉配方
        oreBlasting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, HCOreItem.ALUMINUM_INGOT.get(),0.25f,200,"aluminum");

        /*=================================*/
        // 粗锡块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.RAW_TIN_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.RAW_TIN.get())
                .unlockedBy("has_raw_tin",has(HCOreItem.RAW_TIN))
                .save(recipeOutput);
        // 锡块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.TIN_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 锡锭 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.TIN_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.TIN_NUGGET.get())
                .unlockedBy("has_tin_nugget",has(HCOreItem.TIN_NUGGET))
                .save(recipeOutput,"ignatiushcsmoreore:tin_ingot_from_tin_nugget");
        // 锡粒 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.TIN_NUGGET.get(),9)
                .requires(HCOreItem.TIN_INGOT)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:tin_nugget_from_tin_ingot");
        // 粗锡 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.RAW_TIN.get(),9)
                .requires(HCBlock.RAW_TIN_BLOCK)
                .unlockedBy("has_raw_tin_block",has(HCBlock.RAW_TIN_BLOCK))
                .save(recipeOutput);
        // 锡锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.TIN_INGOT.get(),9)
                .requires(HCBlock.TIN_BLOCK)
                .unlockedBy("has_tin_block",has(HCBlock.TIN_BLOCK))
                .save(recipeOutput);

        // 锡矿
        List<ItemLike> TIN_SMELTABLES = List.of(HCOreItem.RAW_TIN,
                HCBlock.TIN_ORE,HCBlock.DEEPSLATE_TIN_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, HCOreItem.TIN_INGOT.get(),0.25f,200,"tin");
        // 高炉配方
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, HCOreItem.TIN_INGOT.get(),0.25f,200,"tin");

        /*=================================*/
        // 粗银块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.RAW_SILVER_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.RAW_SILVER.get())
                .unlockedBy("has_raw_silver",has(HCOreItem.RAW_SILVER))
                .save(recipeOutput);
        // 银块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.SILVER_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 银锭 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.SILVER_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.SILVER_NUGGET.get())
                .unlockedBy("has_silver_nugget",has(HCOreItem.SILVER_NUGGET))
                .save(recipeOutput,"ignatiushcsmoreore:silver_ingot_from_silver_nugget");
        // 银粒 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.SILVER_NUGGET.get(),9)
                .requires(HCOreItem.SILVER_INGOT)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:silver_nugget_from_silver_ingot");
        // 粗银 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.RAW_SILVER.get(),9)
                .requires(HCBlock.RAW_SILVER_BLOCK)
                .unlockedBy("has_raw_silver_block",has(HCBlock.RAW_SILVER_BLOCK))
                .save(recipeOutput);
        // 银锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.SILVER_INGOT.get(),9)
                .requires(HCBlock.SILVER_BLOCK)
                .unlockedBy("has_silver_block",has(HCBlock.SILVER_BLOCK))
                .save(recipeOutput);

        // 银矿
        List<ItemLike> SILVER_SMELTABLES = List.of(HCOreItem.RAW_SILVER,
                HCBlock.SILVER_ORE,HCBlock.DEEPSLATE_SILVER_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, HCOreItem.SILVER_INGOT.get(),0.25f,200,"silver");
        // 高炉配方
        oreBlasting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, HCOreItem.SILVER_INGOT.get(),0.25f,200,"silver");

        /*=================================*/
        // 钢锭 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.STEEL_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.STEEL_NUGGET.get())
                .unlockedBy("has_steel_nugget",has(HCOreItem.STEEL_NUGGET))
                .save(recipeOutput,"ignatiushcsmoreore:steel_ingot_from_steel_nugget");
        // 钢粒 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.STEEL_NUGGET.get(),9)
                .requires(HCOreItem.STEEL_INGOT)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:steel_nugget_from_steel_ingot");
        // 钢块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.STEEL_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:steel_block_from_steel_ingot");
        // 钢锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.STEEL_INGOT.get(),9)
                .requires(HCBlock.STEEL_BLOCK)
                .unlockedBy("has_steel_block",has(HCBlock.STEEL_BLOCK))
                .save(recipeOutput,"ignatiushcsmoreore:steel_ingot_from_steel_block");


        /*=================================*/
        // 暮云块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.TWILIGHT_CLOUD_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.TWILIGHT_CLOUD_INGOT.get())
                .unlockedBy("has_twilight_cloud_ingot",has(HCOreItem.TWILIGHT_CLOUD_INGOT))
                .save(recipeOutput);
        // 暮云锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.TWILIGHT_CLOUD_INGOT.get(),9)
                .requires(HCBlock.TWILIGHT_CLOUD_BLOCK)
                .unlockedBy("has_twilight_cloud_block",has(HCBlock.TWILIGHT_CLOUD_BLOCK))
                .save(recipeOutput);

        /*=================================*/
        // 风暴块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.STORM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.STORM_INGOT.get())
                .unlockedBy("has_storm_ingot",has(HCOreItem.STORM_INGOT))
                .save(recipeOutput);
        // 风暴锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.STORM_INGOT.get(),9)
                .requires(HCBlock.STORM_BLOCK)
                .unlockedBy("has_storm_block",has(HCBlock.STORM_BLOCK));

        /*=================================*/
        // 叶绿素块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.CHLOROPHYLL_BLOCK.get())
                .pattern("BAB")
                .pattern("AOA")
                .pattern("BAB")
                .define('A', Items.EMERALD)
                .define('B', Items.IRON_INGOT)
                .define('O', HCOreItem.CHLOROPHYLL.get())
                .unlockedBy("has_chloroplast",has(HCOreItem.CHLOROPLAST))
                .save(recipeOutput);
        // 叶绿核心
        List<ItemLike> CHLOROPHYLL_CORE_SMELTABLES = List.of(HCBlock.CHLOROPHYLL_BLOCK);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, CHLOROPHYLL_CORE_SMELTABLES, RecipeCategory.MISC, HCOreItem.CHLOROPHYLL_CORE.get(),0.25f,200,"tilama");
        // 高炉配方
        oreBlasting(recipeOutput, CHLOROPHYLL_CORE_SMELTABLES, RecipeCategory.MISC, HCOreItem.CHLOROPHYLL_CORE.get(),0.25f,200,"tilama");
        // 伪装的叶绿矿 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.DISGUISED_CHLOROPHYLL_ORE.get())
                .pattern("AAA")
                .pattern("AOA")
                .pattern("AAA")
                .define('A', Items.DEEPSLATE)
                .define('O', HCOreItem.CHLOROPHYLL_CORE.get())
                .unlockedBy("has_chlorophyll_core",has(HCOreItem.CHLOROPHYLL_CORE))
                .save(recipeOutput);
        // 叶绿团 有序 工作台
        List<ItemLike> INACTIVATED_CHLOROPHYLL_SMELTABLES = List.of(HCOreItem.CHLOROPLAST);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, INACTIVATED_CHLOROPHYLL_SMELTABLES, RecipeCategory.MISC, HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT.get(),0.25f,200,"tilama");
        // 高炉配方
        oreBlasting(recipeOutput, INACTIVATED_CHLOROPHYLL_SMELTABLES, RecipeCategory.MISC, HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT.get(),0.25f,200,"tilama");


        // 叶绿锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.CHLOROPHYLL_INGOT.get(),1)
                .requires(HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT)
                .requires(HCOreItem.CHLOROPHYLL)
                .unlockedBy("has_inactivated_chlorophyll_ingot",has(HCOreItem.INACTIVATED_CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        ;

        // 叶绿锭块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.CHLOROPHYLL_INGOT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', HCOreItem.CHLOROPHYLL_INGOT.get())
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 叶绿锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.CHLOROPHYLL_INGOT.get(),9)
                .requires(HCBlock.CHLOROPHYLL_INGOT_BLOCK)
                .unlockedBy("has_chlorophyll_block",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput,"ignatiushcsmoreore:chlorophyll_ingot_from_chlorophyll_block");
        ;

        /*=================================*/
        // 提拉马矿
        List<ItemLike> TILAMA_SMELTABLES = List.of(HCOreItem.RAW_TILAMA,
                HCBlock.TILAMA_ORE,HCBlock.DEEPSLATE_TILAMA_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, TILAMA_SMELTABLES, RecipeCategory.MISC, HCOreItem.TILAMA_INGOT.get(),0.25f,200,"tilama");
        // 高炉配方
        oreBlasting(recipeOutput, TILAMA_SMELTABLES, RecipeCategory.MISC, HCOreItem.TILAMA_INGOT.get(),0.25f,200,"tilama");

        /*=================================*/
        // 粗钛块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.RAW_TITANIUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.RAW_TITANIUM.get())
                .unlockedBy("has_raw_titanium",has(HCOreItem.RAW_TITANIUM))
                .save(recipeOutput);
        // 钛块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.TITANIUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 粗钛 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.RAW_TITANIUM.get(),9)
                .requires(HCBlock.RAW_TITANIUM_BLOCK)
                .unlockedBy("has_raw_titanium_block",has(HCBlock.RAW_TITANIUM_BLOCK))
                .save(recipeOutput);
        // 钛锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.TITANIUM_INGOT.get(),9)
                .requires(HCBlock.TITANIUM_BLOCK)
                .unlockedBy("has_titanium_block",has(HCBlock.TITANIUM_BLOCK))
                .save(recipeOutput);

        // 钛矿
        List<ItemLike> TITANIUM_SMELTABLES = List.of(HCOreItem.RAW_TITANIUM,
                HCBlock.TITANIUM_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, HCOreItem.TITANIUM_INGOT.get(),0.25f,200,"titanium");
        // 高炉配方
        oreBlasting(recipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, HCOreItem.TITANIUM_INGOT.get(),0.25f,200,"titanium");

        /*=================================*/
        // 红宝石块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.RUBY_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.RUBY.get())
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);
        // 红宝石 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.RUBY.get(),9)
                .requires(HCBlock.RUBY_BLOCK)
                .unlockedBy("has_ruby_block",has(HCBlock.RUBY_BLOCK))
                .save(recipeOutput);

        // 红宝石矿
        List<ItemLike> RUBY_SMELTABLES = List.of(HCBlock.DEEPSLATE_RUBY_ORE,
                HCBlock.RUBY_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, HCOreItem.RUBY.get(),0.25f,200,"ruby");
        // 高炉配方
        oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, HCOreItem.RUBY.get(),0.25f,200,"ruby");

        /*=================================*/
        // 紫罗兰矿
        List<ItemLike> VIOLET_SMELTABLES = List.of(HCBlock.DEEPSLATE_VIOLET_ORE,
                HCBlock.VIOLET_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, VIOLET_SMELTABLES, RecipeCategory.MISC, HCOreItem.VIOLET_GEMSTONE.get(),0.25f,200,"violet");
        // 高炉配方
        oreBlasting(recipeOutput, VIOLET_SMELTABLES, RecipeCategory.MISC, HCOreItem.VIOLET_GEMSTONE.get(),0.25f,200,"violet");

        /*=================================*/
        // 元祖矿
        List<ItemLike> PRECURSOR_SMELTABLES = List.of(HCOreItem.PRECURSOR_ELEMENT,
                HCBlock.PRECURSOR_ORE,HCBlock.DEEPSLATE_PRECURSOR_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, PRECURSOR_SMELTABLES, RecipeCategory.MISC, HCOreItem.PRECURSOR_INGOT.get(),0.25f,200,"precursor");
        // 高炉配方
        oreBlasting(recipeOutput, PRECURSOR_SMELTABLES, RecipeCategory.MISC, HCOreItem.PRECURSOR_INGOT.get(),0.25f,200,"precursor");

        /*=================================*/
        // 赫岩矿
        List<ItemLike> HEYAN_SMELTABLES = List.of(HCBlock.HEYAN_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, HEYAN_SMELTABLES, RecipeCategory.MISC, HCOreItem.HEYAN.get(),0.25f,200,"heyan");
        // 高炉配方
        oreBlasting(recipeOutput, HEYAN_SMELTABLES, RecipeCategory.MISC, HCOreItem.HEYAN.get(),0.25f,200,"heyan");

        /*=================================*/
        // 黑晶矿 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.BLACK_CRYSTALS_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .unlockedBy("has_black_crystals",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);
        // 黑晶矿 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.BLACK_CRYSTALS.get(),9)
                .requires(HCBlock.BLACK_CRYSTALS_BLOCK)
                .unlockedBy("has_black_crystals_block",has(HCBlock.BLACK_CRYSTALS_BLOCK))
                .save(recipeOutput);


        List<ItemLike> BLACK_CRYSTALS_SMELTABLES = List.of(HCBlock.BLACK_CRYSTALS_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, BLACK_CRYSTALS_SMELTABLES, RecipeCategory.MISC, HCOreItem.BLACK_CRYSTALS.get(),0.25f,200,"black_crystals");
        // 高炉配方
        oreBlasting(recipeOutput, BLACK_CRYSTALS_SMELTABLES, RecipeCategory.MISC, HCOreItem.BLACK_CRYSTALS.get(),0.25f,200,"black_crystals");

        /*=================================*/
        // 狱炎矿
        List<ItemLike> HELL_S_ORE_SMELTABLES = List.of(HCBlock.HELL_S_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, HELL_S_ORE_SMELTABLES, RecipeCategory.MISC, HCOreItem.HELL_S_STONE.get(),0.25f,200,"hell_s_ingot");
        // 高炉配方
        oreBlasting(recipeOutput, HELL_S_ORE_SMELTABLES, RecipeCategory.MISC, HCOreItem.HELL_S_STONE.get(),0.25f,200,"hell_s_ingot");

        /*=================================*/
        // 瑟银块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.SEYIN_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.SEYIN_INGOT.get())
                .unlockedBy("has_seyin",has(HCOreItem.SEYIN_INGOT))
                .save(recipeOutput);
        // 瑟银 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.SEYIN_INGOT.get(),9)
                .requires(HCBlock.SEYIN_BLOCK)
                .unlockedBy("has_seyin_block",has(HCBlock.SEYIN_BLOCK))
                .save(recipeOutput);


        List<ItemLike> SEYIN_SMELTABLES = List.of(HCBlock.SEYIN_ORE,
                HCOreItem.RAW_SEYIN);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, SEYIN_SMELTABLES, RecipeCategory.MISC, HCOreItem.SEYIN_INGOT.get(),0.25f,200,"seyin");
        // 高炉配方
        oreBlasting(recipeOutput, SEYIN_SMELTABLES, RecipeCategory.MISC, HCOreItem.SEYIN_INGOT.get(),0.25f,200,"seyin");

        /*=================================*/
        // 红莲
        List<ItemLike> RED_LOTUS_SMELTABLES = List.of(HCBlock.RED_LOTUS_BLOCK);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 高炉配方
        oreBlasting(recipeOutput, RED_LOTUS_SMELTABLES, RecipeCategory.MISC, HCOreItem.REFINED_RED_LOTUS.get(),0.25f,200,"red_lotus");

        /*=================================*/
        // 凝视
        List<ItemLike> GAZING_SMELTABLES = List.of(HCBlock.GAZING_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, GAZING_SMELTABLES, RecipeCategory.MISC, HCOreItem.GAZING.get(),0.25f,200,"gazing");
        // 高炉配方
        oreBlasting(recipeOutput, GAZING_SMELTABLES, RecipeCategory.MISC, HCOreItem.GAZING.get(),0.25f,200,"gazing");

        /*=================================*/
        // 星尘
        List<ItemLike> STARDUST_SMELTABLES = List.of(HCBlock.STARDUST_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, STARDUST_SMELTABLES, RecipeCategory.MISC, HCOreItem.STARDUST.get(),0.25f,200,"stardust");
        // 高炉配方
        oreBlasting(recipeOutput, STARDUST_SMELTABLES, RecipeCategory.MISC, HCOreItem.STARDUST.get(),0.25f,200,"stardust");

        /*=================================*/
        // 星尘
        List<ItemLike> ENDER_SMELTABLES = List.of(HCBlock.ENDER_ORE,HCOreItem.RAW_ENDER_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, ENDER_SMELTABLES, RecipeCategory.MISC, HCOreItem.ENDER_INGOT.get(),0.25f,200,"stardust");
        // 高炉配方
        oreBlasting(recipeOutput, ENDER_SMELTABLES, RecipeCategory.MISC, HCOreItem.ENDER_INGOT.get(),0.25f,200,"stardust");





        /*===============================模组工具==============================================*/
        // 铝制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ALUMINUM_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ALUMINUM_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ALUMINUM_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ALUMINUM_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ALUMINUM_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot",has(HCOreItem.ALUMINUM_INGOT))
                .save(recipeOutput);

        // 锡制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TIN_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.TIN_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.TIN_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.TIN_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.TIN_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.TIN_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot",has(HCOreItem.TIN_INGOT))
                .save(recipeOutput);

        // 银制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SILVER_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.SILVER_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.SILVER_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.SILVER_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.SILVER_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot",has(HCOreItem.SILVER_INGOT))
                .save(recipeOutput);

        // 钢制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STEEL_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.STEEL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);

        // 寒晶制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ICE_CRYSTAL_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.ICE_CRYSTAL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ice_crystal_ingot",has(HCOreItem.ICE_CRYSTAL_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ICE_CRYSTAL_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.ICE_CRYSTAL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ice_crystal_ingot",has(HCOreItem.ICE_CRYSTAL_INGOT))
                .save(recipeOutput);
        // 弓
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ICE_CRYSTAL_BOW.get())
                .pattern(" XY")
                .pattern("X Y")
                .pattern(" XY")
                .define('X', HCOreItem.ICE_CRYSTAL_INGOT.get())
                .define('Y', Items.STRING)
                .unlockedBy("has_ice_crystal_bow",has(HCOreItem.ICE_CRYSTAL_INGOT))
                .save(recipeOutput);
        // 烈炎制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLAZING_FIRE_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.BLAZING_FIRE_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_blazing_fire_ingot",has(HCOreItem.BLAZING_FIRE_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLAZING_FIRE_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.BLAZING_FIRE_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_blazing_fire_ingot",has(HCOreItem.BLAZING_FIRE_INGOT))
                .save(recipeOutput);
        // 弓
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLAZING_FIRE_BOW.get())
                .pattern(" XY")
                .pattern("X Y")
                .pattern(" XY")
                .define('X', HCOreItem.BLAZING_FIRE_INGOT.get())
                .define('Y', Items.STRING)
                .unlockedBy("has_blazing_fire_bow",has(HCOreItem.BLAZING_FIRE_INGOT))
                .save(recipeOutput);
        // 风暴制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STORM_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.STORM_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_storm_ingot",has(HCOreItem.STORM_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STORM_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.STORM_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_storm_ingot",has(HCOreItem.STORM_INGOT))
                .save(recipeOutput);
        // 弓
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.STORM_BOW.get())
                .pattern(" XY")
                .pattern("X Y")
                .pattern(" XY")
                .define('X', HCOreItem.STORM_INGOT.get())
                .define('Y', Items.STRING)
                .unlockedBy("has_storm_bow",has(HCOreItem.STORM_INGOT))
                .save(recipeOutput);

        // 提拉马制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TILAMA_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.TILAMA_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);

        // 红宝石制工具 有序 工作台
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.RUBY_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.RUBY.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.RUBY_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.RUBY.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.RUBY_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.RUBY.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.RUBY_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.RUBY.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.RUBY_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.RUBY.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_ruby",has(HCOreItem.RUBY))
                .save(recipeOutput);

        // 叶绿制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.CHLOROPHYLL_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.CHLOROPHYLL_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_chlorophyll_ingot",has(HCOreItem.CHLOROPHYLL_INGOT))
                .save(recipeOutput);

        // 海神制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.POSEIDON_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.POSEIDON_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.POSEIDON_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.POSEIDON_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.POSEIDON_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.POSEIDON_INGOT.get())
                .unlockedBy("has_poseidon_ingot",has(HCOreItem.POSEIDON_INGOT))
                .save(recipeOutput);

        // 钛制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.TITANIUM_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.TITANIUM_INGOT.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);

        // 元祖制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.PRECURSOR_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.PRECURSOR_INGOT.get())
                .define('Y', HCItems.TILAMA_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.PRECURSOR_INGOT))
                .save(recipeOutput);

        // 玫瑰制工具 有序 工作台
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ROSE_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ROSE_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ROSE_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ROSE_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ROSE_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ROSE_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ROSE_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ROSE_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ROSE_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ROSE_GEMSTONE.get())
                .unlockedBy("has_rose_gemstone",has(HCOreItem.ROSE_GEMSTONE))
                .save(recipeOutput);

        // 狱炎制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HELL_S_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.HELL_S_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_precursor_ingot",has(HCOreItem.HELL_S_INGOT))
                .save(recipeOutput);

        // 紫罗兰制工具 有序 工作台
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.VIOLET_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.VIOLET_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_violet_ingot",has(HCOreItem.VIOLET_GEMSTONE))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.VIOLET_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.VIOLET_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_violet_ingot",has(HCOreItem.VIOLET_GEMSTONE))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.VIOLET_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.VIOLET_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_violet_ingot",has(HCOreItem.VIOLET_GEMSTONE))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.VIOLET_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.VIOLET_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_violet_ingot",has(HCOreItem.VIOLET_GEMSTONE))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.VIOLET_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.VIOLET_GEMSTONE.get())
                .define('Y', Items.STICK)
                .unlockedBy("has_violet_ingot",has(HCOreItem.VIOLET_GEMSTONE))
                .save(recipeOutput);

        // 黑晶制工具 有序 工作台
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLACK_CRYSTALS_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_black_crystals_ingot",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLACK_CRYSTALS_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_black_crystals_ingot",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLACK_CRYSTALS_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_black_crystals_ingot",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLACK_CRYSTALS_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_black_crystals_ingot",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.BLACK_CRYSTALS_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.BLACK_CRYSTALS.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_black_crystals_ingot",has(HCOreItem.BLACK_CRYSTALS))
                .save(recipeOutput);

        // 圣钢制工具 有序 工作台
        // 弓
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_BOW.get())
                .pattern(" XY")
                .pattern("X Y")
                .pattern(" XY")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', Items.STRING)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.HOLY_STEEL_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .define('Y', HCItems.STEEL_STICK)
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.HOLY_STEEL_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.HOLY_STEEL_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.HOLY_STEEL_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.HOLY_STEEL_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.HOLY_STEEL_INGOT.get())
                .unlockedBy("has_holy_steel_ingot",has(HCOreItem.HOLY_STEEL_INGOT))
                .save(recipeOutput);

        // 狱炎制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SOUL_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.SOUL_STEEL_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_soul_steel_ingot",has(HCOreItem.SOUL_STEEL_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.SOUL_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.SOUL_STEEL_INGOT.get())
                .define('Y', HCItems.SEYIN_STICK)
                .unlockedBy("has_soul_steel_ingot",has(HCOreItem.SOUL_STEEL_INGOT))
                .save(recipeOutput);


        // 末影制工具 有序 工作台
        // 镰刀
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_SICKLE.get())
                .pattern("XXX")
                .pattern("  Y")
                .pattern(" Y ")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 镐子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_PICKAXE.get())
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 斧头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_AXE.get())
                .pattern("XX")
                .pattern("XY")
                .pattern(" Y")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 锹
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_SHOVEL.get())
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 锄头
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCTools.ENDER_HOE.get())
                .pattern("XX")
                .pattern(" Y")
                .pattern(" Y")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .define('Y', HCItems.ENDER_STICK)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 头盔
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ENDER_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ENDER_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 裤腿
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ENDER_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);
        // 靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCArmor.ENDER_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', HCOreItem.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);


        // 量子制工具 有序 工作台
        // 量子空白信息求
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.QUANTUM_INFORMATION_SPHERE.get())
                .pattern(" X ")
                .pattern("XYX")
                .pattern(" X ")
                .define('X', HCOreItem.QUANTUM_INGOT.get())
                .define('Y', HCTags.Items.GLASS_KEY)
                .unlockedBy("has_quantum_ingot",has(HCOreItem.QUANTUM_INGOT))
                .save(recipeOutput);
        // 量子制工具 无序 工作台
        // 镰刀
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_SICKLE_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND)
                .requires(Items.DIAMOND)
                .requires(Items.DIAMOND)
                .requires(Items.STICK)
                .requires(Items.STICK)
                .unlockedBy("has_quantum_sickle_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 剑
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_SWORD_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_SWORD)
                .unlockedBy("has_quantum_sword_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 镐子
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_PICKAXE_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_PICKAXE)
                .unlockedBy("has_quantum_pickaxe_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 斧头
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_AXE_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_AXE)
                .unlockedBy("has_quantum_axe_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 锄头
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_HOE_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_HOE)
                .unlockedBy("has_quantum_hoe_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 锹
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_SHOVEL_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_SHOVEL)
                .unlockedBy("has_quantum_shovel_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 头盔
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_HELMET_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_HELMET)
                .unlockedBy("has_quantum_helmet_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 胸甲
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_CHESTPLATE_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_CHESTPLATE)
                .unlockedBy("has_quantum_chestplate_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 裤腿
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_LEGGINGS_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_LEGGINGS)
                .unlockedBy("has_quantum_leggings_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);
        // 靴子
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.QUANTUM_BOOTS_INFORMATION_SPHERE.get(),1)
                .requires(HCItems.QUANTUM_INFORMATION_SPHERE)
                .requires(Items.DIAMOND_BOOTS)
                .unlockedBy("has_quantum_boots_information_sphere",has(HCItems.QUANTUM_INFORMATION_SPHERE))
                .save(recipeOutput);


        // 国王制工具 无序 工作台
        // 剑
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.EMPEROR_S_SWORD.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_SWORD)
                .unlockedBy("has_xxx_from_sword",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 镐子
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.EMPEROR_S_PICKAXE.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_PICKAXE)
                .unlockedBy("has_xxx_from_pickaxe",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 斧头
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.EMPEROR_S_AXE.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_AXE)
                .unlockedBy("has_xxx_from_axe",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 锄头
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.EMPEROR_S_HOE.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_HOE)
                .unlockedBy("has_xxx_from_hoe",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 锹
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.EMPEROR_S_SHOVEL.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_SHOVEL)
                .unlockedBy("has_xxx_from_shovel",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 头盔
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCArmor.EMPEROR_S_HELMET.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_HELMET)
                .unlockedBy("has_xxx_from_helmet",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 胸甲
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCArmor.EMPEROR_S_CHESTPLATE.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_CHESTPLATE)
                .unlockedBy("has_xxx_from_chestplate",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 裤腿
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCArmor.EMPEROR_S_LEGGINGS.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_LEGGINGS)
                .unlockedBy("has_xxx_from_leggings",has(HCOreItem.XXX))
                .save(recipeOutput);
        // 靴子
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCArmor.EMPEROR_S_BOOTS.get(),1)
                .requires(HCOreItem.XXX)
                .requires(Items.IRON_BOOTS)
                .unlockedBy("has_xxx_from_boots",has(HCOreItem.XXX))
                .save(recipeOutput);


        /*===============================模组杂货==============================================*/
        // 不可见
        List<ItemLike> INVISIBLE = List.of(HCBlock.INVISIBLE_BLOCK);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, INVISIBLE, RecipeCategory.MISC, HCOreItem.UNSTABLE_XXX.get(),0.25f,200,"unstable_xxx");
        // 高炉配方
        oreBlasting(recipeOutput, INVISIBLE, RecipeCategory.MISC, HCOreItem.UNSTABLE_XXX.get(),0.25f,200,"unstable_xxx");


        // 钢棒 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.STEEL_STICK.get(),2)
                .pattern("X")
                .pattern("Y")
                .pattern("X")
                .define('X', HCOreItem.STEEL_NUGGET)
                .define('Y', HCOreItem.STEEL_INGOT)
                .unlockedBy("has_steel_ingot",has(HCOreItem.STEEL_INGOT))
                .save(recipeOutput);
        // 提拉马棒 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.TILAMA_STICK.get(),2)
                .pattern("X")
                .pattern("X")
                .define('X', HCOreItem.TILAMA_INGOT)
                .unlockedBy("has_tilama_ingot",has(HCOreItem.TILAMA_INGOT))
                .save(recipeOutput);
        // 瑟银棒 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.SEYIN_STICK.get(),2)
                .pattern("X")
                .pattern("X")
                .define('X', HCOreItem.SEYIN_INGOT)
                .unlockedBy("has_seyin_ingot",has(HCOreItem.SEYIN_INGOT))
                .save(recipeOutput);
        // 末影棒 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.ENDER_STICK.get(),2)
                .pattern("X")
                .pattern("X")
                .define('X', Items.ENDER_PEARL)
                .unlockedBy("has_ender_ingot",has(HCOreItem.ENDER_INGOT))
                .save(recipeOutput);


        // 玻璃结晶模板 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.GLASS_CRYSTALLIZATION_TEMPLATE,3)
                .pattern(" X ")
                .pattern("X X")
                .pattern(" X ")
                .define('X', HCTags.Items.GLASS_KEY)
                .unlockedBy("has_glass",has(HCTags.Items.GLASS_KEY))
                .save(recipeOutput);
        ;
        // 玫瑰宝石 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.ROSE_GEMSTONE.get(),1)
                .requires(HCItems.GLASS_CRYSTALLIZATION_TEMPLATE)
                .requires(HCOreItem.BLOSSOMING_ROSE)
                .unlockedBy("has_glass_crystallization_template",has(HCItems.GLASS_CRYSTALLIZATION_TEMPLATE))
                .save(recipeOutput);
        ;

        // 棱彩 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.PRISMATIC_COLORFUL_CORE,1)
                .pattern("ROY")
                .pattern("GSC")
                .pattern("BKP")
                .define('R', Items.RED_DYE)
                .define('O', Items.ORANGE_DYE)
                .define('Y', Items.YELLOW_DYE)
                .define('G', Items.GREEN_DYE)
                .define('C', Items.CYAN_DYE)
                .define('B', Items.BLUE_DYE)
                .define('P', Items.PURPLE_DYE)
                .define('S', HCOreItem.PRISMATIC_COLORFUL_FRAGMENT)
                .define('K', HCTags.Items.GLASS_KEY)
                .unlockedBy("has_prismatic_colorful_fragment",has(HCOreItem.PRISMATIC_COLORFUL_FRAGMENT))
                .save(recipeOutput);
        // 棱彩
        List<ItemLike> PRISMATIC_COLORFUL = List.of(HCOreItem.PRISMATIC_COLORFUL_CORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, PRISMATIC_COLORFUL, RecipeCategory.MISC, HCOreItem.PRISMATIC_COLORFUL_INGOT.get(),0.25f,200,"unstable_xxx");
        // 高炉配方
        oreBlasting(recipeOutput, PRISMATIC_COLORFUL, RecipeCategory.MISC, HCOreItem.PRISMATIC_COLORFUL_INGOT.get(),0.25f,200,"unstable_xxx");


        // 归乡 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCOreItem.HOMECOMING,1)
                .pattern("AAA")
                .pattern("AOA")
                .pattern("AAA")
                .define('A', HCOreItem.THOUGHT)
                .define('O', Items.ENDER_PEARL)
                .unlockedBy("has_thought",has(HCOreItem.THOUGHT))
                .save(recipeOutput);


        // 闪金块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.FLASH_GOLD_BLOCK,1)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', HCOreItem.FLASH_GOLD_INGOT)
                .unlockedBy("has_flash_gold_ingot",has(HCOreItem.FLASH_GOLD_INGOT))
                .save(recipeOutput);
        // 闪金 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.FLASH_GOLD_INGOT.get(),9)
                .requires(HCBlock.FLASH_GOLD_BLOCK)
                .unlockedBy("has_flash_gold_block",has(HCBlock.FLASH_GOLD_BLOCK))
                .save(recipeOutput);



        // 合金框架 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.ALLOY_FURNACE_FRAMEWORK_BLOCK,1)
                .pattern(" A ")
                .pattern("AOA")
                .pattern(" A ")
                .define('A', Items.IRON_INGOT)
                .define('O', HCBlock.TITANIUM_BLOCK)
                .unlockedBy("has_titanium_block",has(HCBlock.TITANIUM_BLOCK))
                .save(recipeOutput);
        // 合金熔炉核心 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.ALLOY_FURNACE_CORE_BLOCK,1)
                .pattern("AAA")
                .pattern("AOA")
                .pattern("AAA")
                .define('A', HCOreItem.TITANIUM_INGOT)
                .define('O', Items.FURNACE)
                .unlockedBy("has_titanium_ingot",has(HCOreItem.TITANIUM_INGOT))
                .save(recipeOutput);
        // 解析室 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.ANALYSIS_ROOM_BLOCK,1)
                .pattern("XXX")
                .pattern("AOA")
                .pattern("XXX")
                .define('A', Items.IRON_INGOT)
                .define('O', Items.REDSTONE)
                .define('X', HCBlock.QUANTUM_DOMAIN)
                .unlockedBy("has_quantum_domain",has(HCBlock.QUANTUM_DOMAIN))
                .save(recipeOutput);
        // 灵魂祭坛 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.SOUL_ALTAR,1)
                .pattern("XOX")
                .pattern("AAA")
                .pattern("XXX")
                .define('A', Items.SOUL_SAND)
                .define('O', HCOreItem.RUBY)
                .define('X', Items.STONE_BRICKS)
                .unlockedBy("has_quantum_domain",has(HCBlock.QUANTUM_DOMAIN))
                .save(recipeOutput);

        // 武器台 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.WEAPON_PLATFORM,1)
                .pattern("AOB")
                .pattern("XXX")
                .pattern("X X")
                .define('A', Items.SMITHING_TABLE)
                .define('B', ItemTags.ANVIL)
                .define('O', Items.PAPER)
                .define('X', ItemTags.PLANKS)
                .unlockedBy("has_smithing_table",has(Items.SMITHING_TABLE))
                .save(recipeOutput);

        // 棱彩块 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCBlock.PRISMATIC_COLORFUL_BLOCK,1)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', HCOreItem.PRISMATIC_COLORFUL_INGOT)
                .unlockedBy("has_prismatic_colorful_ingot",has(HCOreItem.PRISMATIC_COLORFUL_INGOT))
                .save(recipeOutput);
        // 棱彩锭 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCOreItem.PRISMATIC_COLORFUL_INGOT,9)
                .requires(HCBlock.PRISMATIC_COLORFUL_BLOCK)
                .unlockedBy("has_prismatic_colorful_block",has(HCBlock.PRISMATIC_COLORFUL_BLOCK))
                .save(recipeOutput,"ignatiushcsmoreore:prismatic_colorful_ingot_from_prismatic_colorful_block");

        // 蓝花楹 有序 工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HCItems.LANHUAYING_MUSIC_DISC,1)
                .pattern("XXX")
                .pattern("XAX")
                .pattern("XXX")
                .define('X', Items.BLUE_ORCHID)
                .define('A', Items.DIAMOND)
                .unlockedBy("has_blue_orchid",has(Items.BLUE_ORCHID))
                .save(recipeOutput);
        // 蓝花楹 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.LANHUAYING_MUSIC_DISC,1)
                .requires(HCItems.LANHUAYING_AI_MUSIC_DISC)
                .unlockedBy("has_lanhuaying_ai",has(HCItems.LANHUAYING_AI_MUSIC_DISC))
                .save(recipeOutput,"ignatiushcsmoreore:lanhuaying_from_ai");
        // 蓝花楹ai 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCItems.LANHUAYING_AI_MUSIC_DISC,1)
                .requires(HCItems.LANHUAYING_MUSIC_DISC)
                .unlockedBy("has_lanhuaying",has(HCItems.LANHUAYING_MUSIC_DISC))
                .save(recipeOutput,"ignatiushcsmoreore:ai_from_lanhuaying");

        /*=================================*/
        // 灵煤
        List<ItemLike> SPIRITUAL_COAL_SMELTABLES = List.of(HCBlock.SPIRITUAL_COAL_ORE,
                HCBlock.DEEPSLATE_SPIRITUAL_COAL_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, SPIRITUAL_COAL_SMELTABLES, RecipeCategory.MISC, HCOreItem.SPIRITUAL_COAL.get(),0.25f,200,"precursor");
        // 高炉配方
        oreBlasting(recipeOutput, SPIRITUAL_COAL_SMELTABLES, RecipeCategory.MISC, HCOreItem.SPIRITUAL_COAL.get(),0.25f,200,"precursor");
        /*=================================*/
        // 硝石
        List<ItemLike> SALTPETRE_SMELTABLES = List.of(HCBlock.SALTPETRE_ORE,
                HCBlock.DEEPSLATE_SALTPETRE_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, SALTPETRE_SMELTABLES, RecipeCategory.MISC, HCOreItem.SALTPETRE.get(),0.25f,200,"precursor");
        // 高炉配方
        oreBlasting(recipeOutput, SALTPETRE_SMELTABLES, RecipeCategory.MISC, HCOreItem.SALTPETRE.get(),0.25f,200,"precursor");
        /*=================================*/
        // 冥火炭
        List<ItemLike> PYROCARBON_SMELTABLES = List.of(HCBlock.PYROCARBON_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, PYROCARBON_SMELTABLES, RecipeCategory.MISC, HCOreItem.PYROCARBON.get(),0.25f,200,"precursor");
        // 高炉配方
        oreBlasting(recipeOutput, PYROCARBON_SMELTABLES, RecipeCategory.MISC, HCOreItem.PYROCARBON.get(),0.25f,200,"precursor");
        /*=================================*/
        // 虚空墨晶
        List<ItemLike> VOID_CRYSTAL_SMELTABLES = List.of(HCBlock.VOID_CRYSTAL_ORE);// 将熔炼结果一样的物品放到一个表里面 一起生成配方
        // 熔炉配方
        oreSmelting(recipeOutput, VOID_CRYSTAL_SMELTABLES, RecipeCategory.MISC, HCOreItem.VOID_CRYSTAL.get(),0.25f,200,"precursor");
        // 高炉配方
        oreBlasting(recipeOutput, VOID_CRYSTAL_SMELTABLES, RecipeCategory.MISC, HCOreItem.VOID_CRYSTAL.get(),0.25f,200,"precursor");

        /*=================================*/
        // 阳子弹 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.YANG_ARROW,4)
                .requires(HCOreItem.PURE_WHITE_POLE)
                .requires(HCOreItem.FUZZY_POLE)
                .unlockedBy("has_yang",has(HCOreItem.PURE_WHITE_POLE))
                .save(recipeOutput);
        // 阴子弹 无序 工作台
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HCTools.YIN_ARROW,4)
                .requires(HCOreItem.PURE_BLACK_POLE)
                .requires(HCOreItem.FUZZY_POLE)
                .unlockedBy("has_yin",has(HCOreItem.PURE_BLACK_POLE))
                .save(recipeOutput);


    }
}
