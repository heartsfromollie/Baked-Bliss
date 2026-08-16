package olliemarkii.bakedbliss.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.recipe.NyxberryPoisonFoodRecipe;

public class BakedBlissRecipes {

    public static final SimpleCraftingRecipeSerializer<NyxberryPoisonFoodRecipe> NYXBERRY_POISON_FOOD =
            Registry.register(
                    BuiltInRegistries.RECIPE_SERIALIZER,
                    ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, "nyxberry_poison_food"),
                    new SimpleCraftingRecipeSerializer<>(NyxberryPoisonFoodRecipe::new)
            );
    public static void registerSpecialRecipes() {
        BakedBliss.LOGGER.info("Register Special Baked Bliss Recipes " + BakedBliss.MOD_ID);
    }
}
