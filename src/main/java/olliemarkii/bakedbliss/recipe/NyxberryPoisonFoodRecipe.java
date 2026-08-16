package olliemarkii.bakedbliss.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissItems;
import olliemarkii.bakedbliss.registry.BakedBlissRecipes;

public class NyxberryPoisonFoodRecipe extends CustomRecipe {

    public NyxberryPoisonFoodRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level world) {

        ItemStack food = ItemStack.EMPTY;
        ItemStack poison = ItemStack.EMPTY;

        for (int i = 0; i < input.size(); i++) {

            ItemStack stack = input.getItem(i);

            if (stack.isEmpty())
                continue;

            if (stack.is(BakedBlissItems.NYXBERRIES)) {

                if (!poison.isEmpty())
                    return false;

                poison = stack;
            }
            else if (stack.has(DataComponents.FOOD)) {

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
    public ItemStack craft(CraftingInput input, HolderLookup.Provider lookup) {

        for (int i = 0; i < input.size(); i++) {

            ItemStack stack = input.getItem(i);

            if (stack.has(DataComponents.FOOD)) {

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
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BakedBlissRecipes.NYXBERRY_POISON_FOOD;
    }
}