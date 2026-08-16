package olliemarkii.bakedbliss.datagen;

//? if >=26.1 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//? } else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
*///? }
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;
import static net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    //? if >=26.1 {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    //? } else {
    /*public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    *///? }
        super(output, registriesFuture);
    }



    //? if >=26.3 {
    /*@Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipeOutput1, BootstrapContext<Advancement> bootstrapContext1) {
        return new RecipeProvider(recipeOutput1,bootstrapContext1) {
            *///? } else if >=1.21.4 {
    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput exporter) {
        return new RecipeProvider(provider, exporter) {
            //? }
            @Override
            //? if >=1.21.4 {
            public void buildRecipes() {
                //? } else if >=1.20.4 {
                /*public void buildRecipes(RecipeOutput exporter) {
                 *///? } else if >1.18 {
                /*public void buildRecipes(Consumer<FinishedRecipe> exporter) {
                 *///? }

                List<ItemLike> SWEET_BERRY_SMELTABLES = List.of(Items.SWEET_BERRIES);
                List<ItemLike> NYXBERRY_SMELTABLES = List.of(BakedBlissItems.NYXBERRIES);
                oreSmelting(
                        //? <=1.21.1 {
                        /*exporter,
                         *///? }
                        SWEET_BERRY_SMELTABLES, RecipeCategory.FOOD,
                        //? if >=26.1 {
                        CookingBookCategory.FOOD,
                        //? }
                        BakedBlissItems.BERRY_JAM, 0.15f,
                        150, "sweet_berry_smeltables");

                oreSmelting(
                        //? <=1.21.1 {
                        /*exporter,
                         *///? }
                        NYXBERRY_SMELTABLES, RecipeCategory.FOOD,
                        //? if >=26.1 {
                        CookingBookCategory.FOOD,
                        //? }
                        BakedBlissItems.NYXBERRY_JAM, 0.15f,
                        150, "nyxberry_raisin_shit_idfk");


                SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.SWEET_BERRIES), RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM, 0.15f, 100
                        )
                        .unlockedBy("has_ingredient", has(Items.SWEET_BERRIES))
                        .save(exporter);

                SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BakedBlissItems.NYXBERRIES), RecipeCategory.FOOD, BakedBlissItems.DRIED_NYXBERRIES, 0.15f, 100
                        )
                        .unlockedBy("has_ingredient", has(BakedBlissItems.NYXBERRIES))
                        .save(exporter);


                shaped(RecipeCategory.FOOD, BakedBlissItems.BERRY_JAM_COOKIE)
                        .pattern("WJW")
                        .define('W', Items.WHEAT)
                        .define('J', BakedBlissItems.BERRY_JAM)
                        .unlockedBy(getHasName(BakedBlissItems.BERRY_JAM), has(BakedBlissItems.BERRY_JAM))
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(exporter);

                shaped(RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM_COOKIE)
                        .pattern("WSW")
                        .define('W', Items.WHEAT)
                        .define('S', BakedBlissItems.SMOKED_BERRY_JAM)
                        .unlockedBy(getHasName(BakedBlissItems.SMOKED_BERRY_JAM), has(BakedBlissItems.SMOKED_BERRY_JAM))
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(exporter);
                shaped(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_PIE)
                        .pattern("SUE")
                        .define('S', BakedBlissItems.STRAWBERRY)
                        .define('U', Items.SUGAR)
                        .define('E', Items.EGG)
                        .unlockedBy(getHasName(BakedBlissItems.STRAWBERRY), has(BakedBlissItems.STRAWBERRY))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                        .save(exporter);

                shaped(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_SUNDAE)
                        .pattern("SIS")
                        .pattern(" G ")
                        .define('S', BakedBlissItems.STRAWBERRY)
                        .define('I', Blocks.ICE)
                        .define('G', Items.GLASS_BOTTLE)
                        .unlockedBy(getHasName(BakedBlissItems.STRAWBERRY), has(BakedBlissItems.STRAWBERRY))
                        .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                        .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                        .save(exporter);

                //? if >=26.2 {
                /*shapeless(RecipeCategory.MISC, Items.DYE.blue(), 2)
                 *///? } else {
                shapeless(RecipeCategory.MISC, Items.BLUE_DYE, 2)
                //? }
                        .requires(BakedBlissItems.NYXBERRIES)
                        .unlockedBy(getHasName(BakedBlissItems.NYXBERRIES),
                                has(BakedBlissItems.NYXBERRIES)
                        ).save(exporter);

                shaped(RecipeCategory.FOOD, BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE, 2)
                        .pattern("NN")
                        .pattern("EM")
                        .pattern("WW")
                        .define('N', BakedBlissItems.NYXBERRIES)
                        .define('E', Items.EGG)
                        .define('M', Items.MILK_BUCKET)
                        .define('W', Items.WHEAT)
                        .unlockedBy(getHasName(BakedBlissItems.NYXBERRIES), has(BakedBlissItems.NYXBERRIES))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(exporter);

                shapeless(RecipeCategory.MISC, BakedBlissItems.CANDIED_DRIED_NYXBERRIES, 2)
                        .requires(BakedBlissItems.NYXBERRIES)
                        .requires(Items.SUGAR)
                        .unlockedBy(getHasName(BakedBlissItems.NYXBERRIES),
                                has(BakedBlissItems.NYXBERRIES)
                        ).save(exporter);
                //? if >=1.21.4 {
            }
        };
        //? }
    }


    @Override
    public String getName() {
        return "BakedBlissRecipeProvider";
    }
}
