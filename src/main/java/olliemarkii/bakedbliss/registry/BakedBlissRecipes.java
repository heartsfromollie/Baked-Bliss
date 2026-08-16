package olliemarkii.bakedbliss.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
//? if <=1.21.1 {
/*import net.minecraft.util.Unit;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
*///?} else {
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
//? }
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.recipe.NyxberryPoisonFoodRecipe;

public class BakedBlissRecipes {

    //? if <=1.21.1 {
    /*public static final SimpleCraftingRecipeSerializer<NyxberryPoisonFoodRecipe> NYXBERRY_POISON_FOOD =
            Registry.register(
                    BuiltInRegistries.RECIPE_SERIALIZER,
                    BakedBliss.of("nyxberry_poison_food"),
                    new SimpleCraftingRecipeSerializer<>(NyxberryPoisonFoodRecipe::new)
            );
    *///?} else {
    public static final RecipeSerializer<NyxberryPoisonFoodRecipe> NYXBERRY_POISON_FOOD = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            BakedBliss.of("nyxberry_poison_food"),
            //? if >=26.1 {
            new RecipeSerializer<>(NyxberryPoisonFoodRecipe.CODEC, NyxberryPoisonFoodRecipe.STREAM_CODEC)
            //? } else {
            /*new CustomRecipe.Serializer<>(NyxberryPoisonFoodRecipe::new)
            *///? }

    );

    public static final RecipeType<NyxberryPoisonFoodRecipe> NYXBERRY_POISON_FOOD_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE,
            BakedBliss.of("nyxberry_poison_food"),
            new RecipeType<NyxberryPoisonFoodRecipe>() { }
    );
    //? }
    public static void registerSpecialRecipes() {
        BakedBliss.LOGGER.info("Register Special Baked Bliss Recipes " + BakedBliss.MOD_ID);
    }
}
