package olliemarkii.bakedbliss.recipe;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissItems;
import olliemarkii.bakedbliss.registry.BakedBlissRecipes;

public class NyxberryPoisonFoodRecipe extends SpecialCraftingRecipe {

    public NyxberryPoisonFoodRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {

        ItemStack food = ItemStack.EMPTY;
        ItemStack poison = ItemStack.EMPTY;

        for (int i = 0; i < input.getSize(); i++) {

            ItemStack stack = input.getStackInSlot(i);

            if (stack.isEmpty())
                continue;

            if (stack.isOf(BakedBlissItems.NYXBERRIES)) {

                if (!poison.isEmpty())
                    return false;

                poison = stack;
            }
            else if (stack.contains(DataComponentTypes.FOOD)) {

                if (!food.isEmpty())
                    return false;

                food = stack;
            }
            else {
                return false;
            }
        }

        return !food.isEmpty() && !poison.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {

        for (int i = 0; i < input.getSize(); i++) {

            ItemStack stack = input.getStackInSlot(i);

            if (stack.contains(DataComponentTypes.FOOD)) {

                ItemStack result = stack.copyWithCount(1);

                result.set(
                        BakedBlissComponents.NYXBERRY_POISON,
                        new NyxberryPoisonComponent(
                                200,
                                0
                        )
                );

                return result;
            }
        }

        return ItemStack.EMPTY;
    }



    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BakedBlissRecipes.NYXBERRY_POISON_FOOD;
    }
}