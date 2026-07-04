package olliemarkii.bakedbliss.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;

public class BakedBlissFoodComponents {
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.3f).build();

    public static final FoodComponent  BERRY_JAM_COOKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 150), 100).build();

    public static final FoodComponent  SMOKED_BERRY_JAM_COOKIE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.50f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 70), 100).build();

    public static final FoodComponent STRAWBERRY_PIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodComponent STRAWBERRY_SUNDAE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160), 70).build();

    public static final FoodComponent DRIED_NYXBERRIES = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.15f).build();

    public static final FoodComponent NYXBERRY_SWIRL_CHEESECAKE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodComponent CANDIED_DRIED_NYXBERRIES = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 170), 95).build();

}
