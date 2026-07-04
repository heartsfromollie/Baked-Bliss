package olliemarkii.bakedbliss.registry;

import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.recipe.NyxberryPoisonFoodRecipe;

public class BakedBlissRecipes {

    public static final SpecialRecipeSerializer<NyxberryPoisonFoodRecipe> NYXBERRY_POISON_FOOD =
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    Identifier.of(BakedBliss.MOD_ID, "nyxberry_poison_food"),
                    new SpecialRecipeSerializer<>(NyxberryPoisonFoodRecipe::new)
            );
    public static void registerSpecialRecipes() {
        BakedBliss.LOGGER.info("Register Special Baked Bliss Recipes " + BakedBliss.MOD_ID);
    }
}
