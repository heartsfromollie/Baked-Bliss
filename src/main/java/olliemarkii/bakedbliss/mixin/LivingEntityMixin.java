package olliemarkii.bakedbliss.mixin;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
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
            method = "eatFood",
            at = @At("TAIL")
    )
    private void bakedbliss$applyPoison(
            World world, ItemStack stack, FoodComponent foodComponent, CallbackInfoReturnable<ItemStack> cir
    ) {

        NyxberryPoisonComponent poison = stack.get(BakedBlissComponents.NYXBERRY_POISON);

        if (poison == null)
            return;

        LivingEntity entity = (LivingEntity)(Object)this;

        entity.addStatusEffect(
                new StatusEffectInstance(
                        BakedBlissEffects.NYXBERRY_POISONING,
                        poison.duration(),
                        poison.amplifier()
                )
        );
    }

}