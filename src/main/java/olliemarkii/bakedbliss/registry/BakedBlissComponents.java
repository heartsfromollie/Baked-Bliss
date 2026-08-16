package olliemarkii.bakedbliss.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;

public class BakedBlissComponents {
    public static final DataComponentType<NyxberryPoisonComponent> NYXBERRY_POISON =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    BakedBliss.of("bakedbliss"),
                    DataComponentType.<NyxberryPoisonComponent>builder()
                            .persistent(NyxberryPoisonComponent.CODEC)
                            .networkSynchronized(NyxberryPoisonComponent.PACKET_CODEC)
                            .build()
            );
    public static void registerComponents() {
        BakedBliss.LOGGER.info("Register Baked Bliss Components for " + BakedBliss.MOD_ID);
    }
}
