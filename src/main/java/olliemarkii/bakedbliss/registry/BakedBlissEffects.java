package olliemarkii.bakedbliss.registry;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.effects.NyxberryPoisoningEffect;

public class BakedBlissEffects {

    public static final RegistryEntry<StatusEffect> NYXBERRY_POISONING = registerStatusEffect("nyxberry_poisoning", new NyxberryPoisoningEffect(StatusEffectCategory.NEUTRAL, 0x7552df));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BakedBliss.MOD_ID, name), statusEffect);
    }


    public static void registerEffects() {
        BakedBliss.LOGGER.info("Register Baked Bliss Effects for " + BakedBliss.MOD_ID);
    }
}
