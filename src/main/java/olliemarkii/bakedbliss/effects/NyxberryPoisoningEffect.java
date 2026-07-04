package olliemarkii.bakedbliss.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class NyxberryPoisoningEffect extends StatusEffect {
    public NyxberryPoisoningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 0F) {
            entity.damage(entity.getDamageSources().magic(), 1.5F);
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 15 >> amplifier;
        return i > 0 ? duration % i == 0 : true;
    }
}
