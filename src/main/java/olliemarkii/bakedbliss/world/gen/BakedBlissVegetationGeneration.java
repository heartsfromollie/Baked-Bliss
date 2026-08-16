package olliemarkii.bakedbliss.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import olliemarkii.bakedbliss.world.BakedBlissPlacedFeatures;

public class BakedBlissVegetationGeneration {
    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SNOWY_TAIGA, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, BakedBlissPlacedFeatures.NYXBERRY_BUSH_PLACED_KEY);
    }
}
