package olliemarkii.bakedbliss.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;

public class BakedBlissFoodComponents {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().fast().nutrition(1).saturationModifier(0.3f).build();

    public static final FoodProperties  BERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.70f)
            .effect(new MobEffectInstance(MobEffects.JUMP, 150), 100).build();

    public static final FoodProperties  SMOKED_BERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.50f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 70), 100).build();

    public static final FoodProperties STRAWBERRY_PIE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodProperties STRAWBERRY_SUNDAE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.8F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160), 70).build();

    public static final FoodProperties DRIED_NYXBERRIES = new FoodProperties.Builder().fast().nutrition(2).saturationModifier(0.15f).build();

    public static final FoodProperties NYXBERRY_SWIRL_CHEESECAKE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodProperties CANDIED_DRIED_NYXBERRIES = new FoodProperties.Builder().fast().nutrition(2).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 170), 95).build();

}
