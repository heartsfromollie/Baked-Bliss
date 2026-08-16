package olliemarkii.bakedbliss.datagen;

//? if >=26.1 {
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
 //? } else if >1.21.1 {
/*import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
*///? } else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
*///? }
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.block.custom.StrawberryCropBlock;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class ModModelProvider extends FabricModelProvider {
    //? if >=26.1 {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }
    //? } else {
    /*public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    *///? }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCropBlock(BakedBlissBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        //? if >1.21.1 {
        blockStateModelGenerator.createCrossBlock(BakedBlissBlocks.NYXBERRY_BUSH, BlockModelGenerators.PlantType.NOT_TINTED,
        //? } else {
        /*blockStateModelGenerator.createCrossBlock(BakedBlissBlocks.NYXBERRY_BUSH, BlockModelGenerators.TintState.NOT_TINTED,
        *///? }
                        NyxberryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BakedBlissItems.BERRY_JAM, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.SMOKED_BERRY_JAM, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.BERRY_JAM_COOKIE, ModelTemplates.FLAT_ITEM);





        itemModelGenerator.generateFlatItem(BakedBlissItems.STRAWBERRY_PIE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.STRAWBERRY_SUNDAE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.DRIED_NYXBERRIES, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.CANDIED_DRIED_NYXBERRIES, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.NYXBERRY_JAM, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE, ModelTemplates.FLAT_ITEM);



    }
}
