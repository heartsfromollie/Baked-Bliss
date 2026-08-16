package olliemarkii.bakedbliss.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(
            method = "eat(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/ItemStack;",
            at = @At("TAIL")
    )
    private void bakedbliss$applyPoison(
            Level world, ItemStack stack, FoodProperties foodComponent, CallbackInfoReturnable<ItemStack> cir
    ) {

        NyxberryPoisonComponent poison = stack.get(BakedBlissComponents.NYXBERRY_POISON);

        if (poison == null)
            return;

        LivingEntity entity = (LivingEntity)(Object)this;

        entity.addEffect(
                new MobEffectInstance(
                        BakedBlissEffects.NYXBERRY_POISONING,
                        poison.duration(),
                        poison.amplifier()
                )
        );
    }

}