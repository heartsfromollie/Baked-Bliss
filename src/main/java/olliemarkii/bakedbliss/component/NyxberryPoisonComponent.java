package olliemarkii.bakedbliss.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record NyxberryPoisonComponent(int duration, int amplifier) {

    public static final Codec<NyxberryPoisonComponent> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.INT.fieldOf("duration").forGetter(NyxberryPoisonComponent::duration),
                            Codec.INT.fieldOf("amplifier").forGetter(NyxberryPoisonComponent::amplifier)
                    ).apply(instance, NyxberryPoisonComponent::new)
            );

    public static final PacketCodec<RegistryByteBuf, NyxberryPoisonComponent> PACKET_CODEC =
            PacketCodec.tuple(
                    PacketCodecs.INTEGER,
                    NyxberryPoisonComponent::duration,

                    PacketCodecs.INTEGER,
                    NyxberryPoisonComponent::amplifier,

                    NyxberryPoisonComponent::new
            );

}
