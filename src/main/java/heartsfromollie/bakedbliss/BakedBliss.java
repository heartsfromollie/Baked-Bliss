package heartsfromollie.bakedbliss;

import heartsfromollie.bakedbliss.block.ModBlocks;
import heartsfromollie.bakedbliss.items.ModItemGroups;
import heartsfromollie.bakedbliss.items.ModItems;
import heartsfromollie.bakedbliss.sound.ModSounds;
import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakedBliss implements ModInitializer {
	public static final String MOD_ID = "bakedbliss";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();



		LOGGER.info("Turning on the oven...");
	}
}
