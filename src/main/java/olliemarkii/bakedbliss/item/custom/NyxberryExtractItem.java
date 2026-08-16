package olliemarkii.bakedbliss.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

//? if <=1.21.1 {
/*import net.minecraft.world.item.UseAnim;
*///? } else {
import net.minecraft.world.item.ItemUseAnimation;
//? }

public class NyxberryExtractItem extends Item {
    public NyxberryExtractItem(Properties settings) {
        super(settings);
    }

    //? if <=1.21.1 {
    /*@Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
    *///?} else {

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.DRINK;
    }
    //? }

    @Override
        public int getUseDuration(ItemStack stack, LivingEntity user) {
            return 25;
        }
    }

