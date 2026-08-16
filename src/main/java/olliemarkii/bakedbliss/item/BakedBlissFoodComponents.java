package olliemarkii.bakedbliss.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
//? if >1.21.1 {
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
//? }
import olliemarkii.bakedbliss.registry.BakedBlissEffects;

public class BakedBlissFoodComponents {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            //? if <=1.21.1 {
            /*.fast()
             *///? }
            .nutrition(1).saturationModifier(0.3f).build();

    public static final FoodProperties  BERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.70f)
            //? if <=1.21.1 {
            /*.effect(new MobEffectInstance(MobEffects.JUMP, 150), 100)
             *///? }
            .build();

    public static final FoodProperties  SMOKED_BERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.50f)
            //? if <=1.21.1 {
            /*.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 70), 100)
             *///? }
            .build();

    public static final FoodProperties STRAWBERRY_PIE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodProperties STRAWBERRY_SUNDAE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.8F)
            //? if <=1.21.1 {
            /*.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160), 70)
             *///? }
            .build();

    public static final FoodProperties DRIED_NYXBERRIES = new FoodProperties.Builder()
            //? if <=1.21.1 {
            /*.fast()
             *///? }
            .nutrition(2).saturationModifier(0.15f).build();

    public static final FoodProperties NYXBERRY_SWIRL_CHEESECAKE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build();

    public static final FoodProperties CANDIED_DRIED_NYXBERRIES = new FoodProperties.Builder()
            //? if <=1.21.1 {
            /*.fast()
             *///? }
            .nutrition(2).saturationModifier(0.25f)
            //? if <=1.21.1 {
            /*.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 170), 95)
             *///? }
            .build();

    //? if >1.21.1 {

    // Consumable Components

    public static final Consumable STRAWBERRY_CONSUMABLE = Consumable.builder().consumeSeconds(0.8F).build();

    public static final Consumable BERRY_JAM_COOKIE_CONSUMABLE = Consumable.builder().onConsume(
            //? if >1.21.4 {
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 150))
             //? } else {
            /*new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP, 150))
            *///? }
    ).build();

    public static final Consumable SMOKED_BERRY_JAM_COOKIE_CONSUMABLE = Consumable.builder().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 70))
    ).build();

    public static final Consumable STRAWBERRY_SUNDAE_CONSUMABLE = Consumable.builder().onConsume(
            //? if >1.21.4 {
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 160))
             //? } else {
            /*new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160))
            *///? }
    ).build();

    public static final Consumable DRIED_NYXBERRIES_CONSUMABLE = Consumable.builder().consumeSeconds(0.8F).build();

    public static final Consumable CANDIED_DRIED_NYXBERRIES_CONSUMABLE = Consumable.builder().onConsume(
            //? if >1.21.4 {
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 170))
             //? } else {
            /*new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 170))
            *///? }
    ).build();

    //? }

}
