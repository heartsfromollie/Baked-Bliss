package olliemarkii.bakedbliss.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record NyxberryPoisonComponent(int duration, int amplifier) {

    public static final Codec<NyxberryPoisonComponent> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.INT.fieldOf("duration").forGetter(NyxberryPoisonComponent::duration),
                            Codec.INT.fieldOf("amplifier").forGetter(NyxberryPoisonComponent::amplifier)
                    ).apply(instance, NyxberryPoisonComponent::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, NyxberryPoisonComponent> PACKET_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.INT,
                    NyxberryPoisonComponent::duration,

                    ByteBufCodecs.INT,
                    NyxberryPoisonComponent::amplifier,

                    NyxberryPoisonComponent::new
            );

}
