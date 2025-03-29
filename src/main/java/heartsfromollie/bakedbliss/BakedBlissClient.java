package heartsfromollie.bakedbliss;

import heartsfromollie.bakedbliss.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BakedBlissClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTSFROMOLLIE_PLUSHIE, RenderLayer.getCutout());

    }
}
