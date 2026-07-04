package olliemarkii.bakedbliss.registry;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.component.NyxberryPoisonComponent;

public class BakedBlissComponents {
    public static final ComponentType<NyxberryPoisonComponent> NYXBERRY_POISON =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    Identifier.of(BakedBliss.MOD_ID, "bakedbliss"),
                    ComponentType.<NyxberryPoisonComponent>builder()
                            .codec(NyxberryPoisonComponent.CODEC)
                            .packetCodec(NyxberryPoisonComponent.PACKET_CODEC)
                            .build()
            );
    public static void registerComponents() {
        BakedBliss.LOGGER.info("Register Baked Bliss Components for " + BakedBliss.MOD_ID);
    }
}
