package olliemarkii.bakedbliss;

import net.fabricmc.api.ModInitializer;

//? if <26.1 {
/*import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
*///? } else {
import net.fabricmc.fabric.api.registry.CompostableRegistry;
//? }

//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
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

		//? if <26.1 {
		/*CompostingChanceRegistry.INSTANCE.add(BakedBlissItems.STRAWBERRY, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(BakedBlissItems.NYXBERRIES, 0.15f);
		*///? } else {
		CompostableRegistry.INSTANCE.add(BakedBlissItems.STRAWBERRY, 0.25f);
		CompostableRegistry.INSTANCE.add(BakedBlissItems.NYXBERRIES, 0.15f);
		//? }
	}

	//? if >=1.21.11 {
	public static Identifier of(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
	 
	//? } else {
	/*public static ResourceLocation of(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
	*///? }

}
