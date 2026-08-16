package olliemarkii.bakedbliss.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissItems;
import olliemarkii.bakedbliss.registry.BakedBlissRecipes;

public class NyxberryPoisonFoodRecipe extends CustomRecipe {

    public NyxberryPoisonFoodRecipe(CraftingBookCategory category) {
        //? if >=26.1 {
        super();
        //? } else {
        /*super(category);
        *///? }
    }

    public static final MapCodec<NyxberryPoisonFoodRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    CraftingBookCategory.CODEC.fieldOf("category").forGetter(NyxberryPoisonFoodRecipe::category)
            ).apply(instance, NyxberryPoisonFoodRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, NyxberryPoisonFoodRecipe> STREAM_CODEC = StreamCodec.composite(
            CraftingBookCategory.STREAM_CODEC,
            NyxberryPoisonFoodRecipe::category,
            NyxberryPoisonFoodRecipe::new
    );

    @Override
    public CraftingBookCategory category() {
        return super.category();
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
    //? if >=26.1 {
    @Override
    public ItemStack assemble(CraftingInput input) {
    //? } else {
    /*@Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider lookup) {
    *///?}


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




    //? if <=1.21.1 {
    /*@Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BakedBlissRecipes.NYXBERRY_POISON_FOOD;
    }
    *///? } else {
    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return BakedBlissRecipes.NYXBERRY_POISON_FOOD;
    }
    //? }
}