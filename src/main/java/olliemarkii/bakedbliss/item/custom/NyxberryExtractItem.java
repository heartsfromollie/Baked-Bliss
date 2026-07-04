package olliemarkii.bakedbliss.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class NyxberryExtractItem extends Item {
    public NyxberryExtractItem(Settings settings) {
        super(settings);
    }
        @Override
        public UseAction getUseAction(ItemStack stack) {
            return UseAction.DRINK;
        }

        @Override
        public int getMaxUseTime(ItemStack stack, LivingEntity user) {
            return 25;
        }
    }

