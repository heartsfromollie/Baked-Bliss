package olliemarkii.bakedbliss.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class SmokedBerryJamCookieItem extends Item {


    public SmokedBerryJamCookieItem(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);

        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.POISON);
            user.removeStatusEffect(BakedBlissEffects.NYXBERRY_POISONING);
        }

        return result;
    }
}

