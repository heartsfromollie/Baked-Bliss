package olliemarkii.bakedbliss;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.registry.BakedBlissComponents;
import olliemarkii.bakedbliss.registry.BakedBlissEffects;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class BakedBlissClient implements ClientModInitializer {

    private static final int PURPLE = 0x6c46df;


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BakedBlissBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BakedBlissBlocks.NYXBERRY_BUSH, RenderLayer.getCutout());

            ItemTooltipCallback.EVENT.register(
                    (ItemStack stack,
                     Item.TooltipContext context,
                     TooltipType type,
                     List<Text> lines) -> {

                        if (!stack.contains(BakedBlissComponents.NYXBERRY_POISON))
                            return;

                        if (lines.isEmpty())
                            return;

                        Text name = lines.get(0);

                        lines.set(
                                0,
                                name.copy().styled(style -> style.withItalic(true))
                        );}
            );
        }
    }
