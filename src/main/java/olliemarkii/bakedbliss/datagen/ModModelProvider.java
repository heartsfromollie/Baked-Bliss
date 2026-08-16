package olliemarkii.bakedbliss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.block.custom.StrawberryCropBlock;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import static net.minecraft.data.models.model.ModelTemplates.FLAT_ITEM;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCropBlock(BakedBlissBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.createCrossBlock(BakedBlissBlocks.NYXBERRY_BUSH, BlockModelGenerators.TintState.NOT_TINTED,
                NyxberryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BakedBlissItems.BERRY_JAM, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.SMOKED_BERRY_JAM, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.BERRY_JAM_COOKIE, FLAT_ITEM);





        itemModelGenerator.generateFlatItem(BakedBlissItems.STRAWBERRY_PIE, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.STRAWBERRY_SUNDAE, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.DRIED_NYXBERRIES, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.CANDIED_DRIED_NYXBERRIES, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.NYXBERRY_JAM, FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE, FLAT_ITEM);



    }
}
