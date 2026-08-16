package olliemarkii.bakedbliss.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class NyxberryExtractItem extends Item {
    public NyxberryExtractItem(Properties settings) {
        super(settings);
    }
        @Override
        public UseAnim getUseAnimation(ItemStack stack) {
            return UseAnim.DRINK;
        }

        @Override
        public int getUseDuration(ItemStack stack, LivingEntity user) {
            return 25;
        }
    }

