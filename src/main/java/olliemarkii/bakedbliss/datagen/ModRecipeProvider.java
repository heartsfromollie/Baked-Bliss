package olliemarkii.bakedbliss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.server.recipe.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        List<ItemLike> SWEET_BERRY_SMELTABLES = List.of(Items.SWEET_BERRIES);
        List<ItemLike> NYXBERRY_SMELTABLES = List.of(BakedBlissItems.NYXBERRIES);
        oreSmelting(exporter, SWEET_BERRY_SMELTABLES, RecipeCategory.FOOD, BakedBlissItems.BERRY_JAM, 0.15f,
                150, "sweet_berry_smeltables");

        oreSmelting(exporter, NYXBERRY_SMELTABLES, RecipeCategory.FOOD, BakedBlissItems.NYXBERRY_JAM, 0.15f,
                150, "nyxberry_raisin_shit_idfk");


        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.SWEET_BERRIES), RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM, 0.15f, 100
                )
                .unlockedBy(
                        RecipeProvider.getHasName(Items.SWEET_BERRIES),
                        RecipeProvider.has(Items.SWEET_BERRIES)
                )
                .save(exporter);

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BakedBlissItems.NYXBERRIES), RecipeCategory.FOOD, BakedBlissItems.DRIED_NYXBERRIES, 0.15f, 100
                )
                .unlockedBy(
                        RecipeProvider.getHasName(BakedBlissItems.NYXBERRIES),
                        RecipeProvider.has(BakedBlissItems.NYXBERRIES)
                )
                .save(exporter);


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BakedBlissItems.BERRY_JAM_COOKIE)
                .pattern("WJW")
                .define('W', Items.WHEAT)
                .define('J', BakedBlissItems.BERRY_JAM)
                .unlockedBy(getHasName(BakedBlissItems.BERRY_JAM), has(BakedBlissItems.BERRY_JAM))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(BakedBlissItems.BERRY_JAM_COOKIE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM_COOKIE)
                .pattern("WSW")
                .define('W', Items.WHEAT)
                .define('S', BakedBlissItems.SMOKED_BERRY_JAM)
                .unlockedBy(getHasName(BakedBlissItems.SMOKED_BERRY_JAM), has(BakedBlissItems.SMOKED_BERRY_JAM))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE)));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_PIE)
                .pattern("SUE")
                .define('S', BakedBlissItems.STRAWBERRY)
                .define('U', Items.SUGAR)
                .define('E', Items.EGG)
                .unlockedBy(getHasName(BakedBlissItems.STRAWBERRY), has(BakedBlissItems.STRAWBERRY))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(BakedBlissItems.STRAWBERRY_PIE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_SUNDAE)
                .pattern("SIS")
                .pattern(" G ")
                .define('S', BakedBlissItems.STRAWBERRY)
                .define('I', Blocks.ICE)
                .define('G', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(BakedBlissItems.STRAWBERRY), has(BakedBlissItems.STRAWBERRY))
                .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(BakedBlissItems.STRAWBERRY_SUNDAE)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE, 2)
                .requires(BakedBlissItems.NYXBERRIES)
                .unlockedBy(getHasName(BakedBlissItems.NYXBERRIES),
                        has(BakedBlissItems.NYXBERRIES)
                ).save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE,2)
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
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BakedBlissItems.CANDIED_DRIED_NYXBERRIES, 2)
                .requires(BakedBlissItems.NYXBERRIES)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(BakedBlissItems.NYXBERRIES),
                        has(BakedBlissItems.NYXBERRIES)
                ).save(exporter);

    }
}
