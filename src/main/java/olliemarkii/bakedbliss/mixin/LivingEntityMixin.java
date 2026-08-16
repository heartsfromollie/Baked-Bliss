package olliemarkii.bakedbliss.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    public abstract boolean isUsingItem();

    @Shadow
    public abstract ItemStack getUseItem();

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    //? if <=1.21.1 {
    /*@Inject(
            method = "eat(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/ItemStack;",
            at = @At("TAIL")
    )
    private void bakedbliss$applyPoison(
            Level world, ItemStack stack, FoodProperties foodComponent, CallbackInfoReturnable<ItemStack> cir
    ) {
    
    *///? } else {
    @Inject(
            method = "completeUsingItem",
            at = @At("HEAD")
    )
    private void bakedbliss$applyPoison(
            CallbackInfo ci
    ) {

        if (level().isClientSide() || !isUsingItem()) return;
        ItemStack stack = getUseItem();
        if (stack == null) return;
    //? }


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