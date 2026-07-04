package olliemarkii.bakedbliss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SWEET_BERRY_SMELTABLES = List.of(Items.SWEET_BERRIES);
        List<ItemConvertible> NYXBERRY_SMELTABLES = List.of(BakedBlissItems.NYXBERRIES);
        offerSmelting(exporter, SWEET_BERRY_SMELTABLES, RecipeCategory.FOOD, BakedBlissItems.BERRY_JAM, 0.15f,
                150, "sweet_berry_smeltables");

        offerSmelting(exporter, NYXBERRY_SMELTABLES, RecipeCategory.FOOD, BakedBlissItems.NYXBERRY_JAM, 0.15f,
                150, "nyxberry_raisin_shit_idfk");


        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(Items.SWEET_BERRIES), RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM, 0.15f, 100
                )
                .criterion(
                        RecipeProvider.hasItem(Items.SWEET_BERRIES),
                        RecipeProvider.conditionsFromItem(Items.SWEET_BERRIES)
                )
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(BakedBlissItems.NYXBERRIES), RecipeCategory.FOOD, BakedBlissItems.DRIED_NYXBERRIES, 0.15f, 100
                )
                .criterion(
                        RecipeProvider.hasItem(BakedBlissItems.NYXBERRIES),
                        RecipeProvider.conditionsFromItem(BakedBlissItems.NYXBERRIES)
                )
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BakedBlissItems.BERRY_JAM_COOKIE)
                .pattern("WJW")
                .input('W', Items.WHEAT)
                .input('J', BakedBlissItems.BERRY_JAM)
                .criterion(hasItem(BakedBlissItems.BERRY_JAM), conditionsFromItem(BakedBlissItems.BERRY_JAM))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(getRecipeName(BakedBlissItems.BERRY_JAM_COOKIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BakedBlissItems.SMOKED_BERRY_JAM_COOKIE)
                .pattern("WSW")
                .input('W', Items.WHEAT)
                .input('S', BakedBlissItems.SMOKED_BERRY_JAM)
                .criterion(hasItem(BakedBlissItems.SMOKED_BERRY_JAM), conditionsFromItem(BakedBlissItems.SMOKED_BERRY_JAM))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(getRecipeName(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_PIE)
                .pattern("SUE")
                .input('S', BakedBlissItems.STRAWBERRY)
                .input('U', Items.SUGAR)
                .input('E', Items.EGG)
                .criterion(hasItem(BakedBlissItems.STRAWBERRY), conditionsFromItem(BakedBlissItems.STRAWBERRY))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .offerTo(exporter, Identifier.of(getRecipeName(BakedBlissItems.STRAWBERRY_PIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BakedBlissItems.STRAWBERRY_SUNDAE)
                .pattern("SIS")
                .pattern(" G ")
                .input('S', BakedBlissItems.STRAWBERRY)
                .input('I', Blocks.ICE)
                .input('G', Items.GLASS_BOTTLE)
                .criterion(hasItem(BakedBlissItems.STRAWBERRY), conditionsFromItem(BakedBlissItems.STRAWBERRY))
                .criterion(hasItem(Blocks.ICE), conditionsFromItem(Blocks.ICE))
                .criterion(hasItem(Blocks.GLASS), conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter, Identifier.of(getRecipeName(BakedBlissItems.STRAWBERRY_SUNDAE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 2)
                .input(BakedBlissItems.NYXBERRIES)
                .criterion(hasItem(BakedBlissItems.NYXBERRIES),
                        conditionsFromItem(BakedBlissItems.NYXBERRIES)
                ).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE,2)
                .pattern("NN")
                .pattern("EM")
                .pattern("WW")
                .input('N', BakedBlissItems.NYXBERRIES)
                .input('E', Items.EGG)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .criterion(hasItem(BakedBlissItems.NYXBERRIES), conditionsFromItem(BakedBlissItems.NYXBERRIES))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(getRecipeName(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BakedBlissItems.CANDIED_DRIED_NYXBERRIES, 2)
                .input(BakedBlissItems.NYXBERRIES)
                .input(Items.SUGAR)
                .criterion(hasItem(BakedBlissItems.NYXBERRIES),
                        conditionsFromItem(BakedBlissItems.NYXBERRIES)
                ).offerTo(exporter);

    }
}
