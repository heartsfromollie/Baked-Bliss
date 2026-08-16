package olliemarkii.bakedbliss;

import net.fabricmc.api.ClientModInitializer;
//? if <=1.21.4 {
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
 *///? } else if <26.1 {
/*import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
*///? }
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import java.util.ArrayList;
import java.util.List;

public class BakedBlissClient implements ClientModInitializer {

    private static final int PURPLE = 0x6c46df;


    @Override
    public void onInitializeClient() {
        //? if <=1.21.4 {
        /*BlockRenderLayerMap.INSTANCE.putBlock(BakedBlissBlocks.STRAWBERRY_CROP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BakedBlissBlocks.NYXBERRY_BUSH, RenderType.cutout());
        *///? } else if <26.1 {
        /*BlockRenderLayerMap.putBlock(BakedBlissBlocks.STRAWBERRY_CROP, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BakedBlissBlocks.NYXBERRY_BUSH, ChunkSectionLayer.CUTOUT);
        *///? }


            ItemTooltipCallback.EVENT.register(
                    (ItemStack stack,
                     Item.TooltipContext context,
                     TooltipFlag type,
                     List<Component> lines) -> {

                        if (!stack.has(BakedBlissComponents.NYXBERRY_POISON))
                            return;

                        if (lines.isEmpty())
                            return;

                        Component name = lines.get(0);

                        lines.set(
                                0,
                                name.copy().withStyle(style -> style.withItalic(true))
                        );}
            );
        }
    }
