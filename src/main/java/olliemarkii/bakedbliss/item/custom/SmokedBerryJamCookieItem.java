package olliemarkii.bakedbliss.item.custom;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class SmokedBerryJamCookieItem extends Item {


    public SmokedBerryJamCookieItem(Properties settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        ItemStack result = super.finishUsingItem(stack, world, user);

        if (!world.isClientSide()) {
            user.removeEffect(MobEffects.POISON);
            user.removeEffect(BakedBlissEffects.NYXBERRY_POISONING);
        }

        return result;
    }
}

