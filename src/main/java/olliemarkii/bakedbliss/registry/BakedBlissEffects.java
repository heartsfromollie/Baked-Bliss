package olliemarkii.bakedbliss.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.effects.NyxberryPoisoningEffect;

public class BakedBlissEffects {

    public static final Holder<MobEffect> NYXBERRY_POISONING = registerStatusEffect("nyxberry_poisoning", new NyxberryPoisoningEffect(MobEffectCategory.NEUTRAL, 0x7552df));


    private static Holder<MobEffect> registerStatusEffect(String name, MobEffect statusEffect){
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, name), statusEffect);
    }


    public static void registerEffects() {
        BakedBliss.LOGGER.info("Register Baked Bliss Effects for " + BakedBliss.MOD_ID);
    }
}
