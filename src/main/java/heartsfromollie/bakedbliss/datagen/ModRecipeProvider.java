package heartsfromollie.bakedbliss.datagen;

import heartsfromollie.bakedbliss.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> BERRY_SMELTABLES = List.of(Items.SWEET_BERRIES);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.MISC ,ModItems.COCOA_POWDER, Items.COCOA_BEANS, 2);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.MISC ,ModItems.WHITE_COCOA_POWDER, ModItems.WHITE_COCOA_BEANS, 2);
        offerSmelting(recipeExporter, BERRY_SMELTABLES, RecipeCategory.FOOD, ModItems.BERRY_JAM, 0.15f,
                150, "berry_smeltables");





        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WHITE_CHOCOLATE_COOKIE)
                .pattern("HWH")
                .input('H', Items.WHEAT)
                .input('W', ModItems.WHITE_COCOA_POWDER)
                .criterion(hasItem(ModItems.WHITE_COCOA_POWDER), conditionsFromItem(ModItems.WHITE_COCOA_POWDER))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BERRY_JAM_COOKIE)
                .pattern("WJW")
                .input('W', Items.WHEAT)
                .input('J', ModItems.BERRY_JAM)
                .criterion(hasItem(ModItems.BERRY_JAM), conditionsFromItem(ModItems.BERRY_JAM))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PUMPKIN_BREAD, 3)
                .pattern("PPP")
                .pattern("WWW")
                .input('W', Items.WHEAT)
                .input('P', ModItems.PUMPKIN_SLICE)
                .criterion(hasItem(ModItems.PUMPKIN_SLICE), conditionsFromItem(ModItems.PUMPKIN_SLICE))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WHITE_COCOA_BEANS, 2)
                .pattern("WBW")
                .input('B', Items.COCOA_BEANS)
                .input('W', Items.WHITE_DYE)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PUMPKIN_SLICE, 4)
                .input(Blocks.PUMPKIN)
                .criterion(hasItem(Blocks.PUMPKIN), conditionsFromItem(Blocks.PUMPKIN))
                .offerTo(recipeExporter);

    }
}
