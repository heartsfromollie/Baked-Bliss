package olliemarkii.bakedbliss;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import olliemarkii.bakedbliss.datagen.*;
import olliemarkii.bakedbliss.world.BakedBlissConfiguredFeatures;
import olliemarkii.bakedbliss.world.BakedBlissPlacedFeatures;

public class BakedBlissDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
	}

	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, BakedBlissConfiguredFeatures::boostrap);
		registryBuilder.add(Registries.PLACED_FEATURE, BakedBlissPlacedFeatures::bootstrap);
	}
}
