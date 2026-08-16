package olliemarkii.bakedbliss.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;

import java.util.List;

public class BakedBlissConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> NYXBERRY_BUSH_KEY = registerKey("nyxberry_bush");






    public static void boostrap(BootstrapContext<ConfiguredFeature<?,?>> context){


        //? if >=26.1 {
        context.register(NYXBERRY_BUSH_KEY, new ConfiguredFeature<>(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(BakedBlissBlocks.NYXBERRY_BUSH.defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3))))
        ));
        //? } else {
        /*register(context, NYXBERRY_BUSH_KEY,
                Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BakedBlissBlocks.NYXBERRY_BUSH
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                ));
        *///? }
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, BakedBliss.of(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}