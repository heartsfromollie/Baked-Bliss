package olliemarkii.bakedbliss;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import olliemarkii.bakedbliss.registry.*;
import olliemarkii.bakedbliss.item.BakedBlissItemGroups;
import olliemarkii.bakedbliss.world.gen.BakedBlissWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakedBliss implements ModInitializer {
	public static final String MOD_ID = "bakedbliss";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BakedBlissItems.registerModItems();
		BakedBlissItemGroups.registerItemGroups();
		BakedBlissBlocks.registerModBlocks();
		BakedBlissEffects.registerEffects();
		BakedBlissComponents.registerComponents();
		BakedBlissRecipes.registerSpecialRecipes();
		BakedBlissWorldGeneration.generatedModWorldGen();

		CompostingChanceRegistry.INSTANCE.add(BakedBlissItems.STRAWBERRY, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(BakedBlissItems.NYXBERRIES, 0.15f);

	}
}
