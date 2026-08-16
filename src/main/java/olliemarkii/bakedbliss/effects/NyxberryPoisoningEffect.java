package olliemarkii.bakedbliss.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class NyxberryPoisoningEffect extends MobEffect {
    public NyxberryPoisoningEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 0F) {
            entity.hurt(entity.damageSources().magic(), 1.5F);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 15 >> amplifier;
        return i > 0 ? duration % i == 0 : true;
    }
}
