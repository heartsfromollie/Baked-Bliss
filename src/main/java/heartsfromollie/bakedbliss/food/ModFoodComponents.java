package heartsfromollie.bakedbliss.food;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class ModFoodComponents {
    public static final FoodComponent WHITE_CHOCOLATE_COOKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150), 100).build();
    public static final FoodComponent  BERRY_JAM_COOKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 150), 100).build();
    public static final FoodComponent PUMPKIN_BREAD = new FoodComponent.Builder().nutrition(5).saturationModifier(0.76F).build();
    public static final FoodComponent PUMPKIN_SLICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
}
