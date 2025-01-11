package heartsfromollie.bakedbliss.datagen;


import heartsfromollie.bakedbliss.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COCOA_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_COCOA_BEANS, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_COCOA_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_CHOCOLATE_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BERRY_JAM_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_SLICE, Models.GENERATED);
    }
}