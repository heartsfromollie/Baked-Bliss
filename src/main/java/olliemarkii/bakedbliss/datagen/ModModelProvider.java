package olliemarkii.bakedbliss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.block.custom.StrawberryCropBlock;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import static net.minecraft.data.client.Models.GENERATED;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(BakedBlissBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(BakedBlissBlocks.NYXBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                NyxberryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BakedBlissItems.BERRY_JAM, GENERATED);

        itemModelGenerator.register(BakedBlissItems.SMOKED_BERRY_JAM, GENERATED);

        itemModelGenerator.register(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE, GENERATED);

        itemModelGenerator.register(BakedBlissItems.BERRY_JAM_COOKIE, GENERATED);





        itemModelGenerator.register(BakedBlissItems.STRAWBERRY_PIE, GENERATED);

        itemModelGenerator.register(BakedBlissItems.STRAWBERRY_SUNDAE, GENERATED);

        itemModelGenerator.register(BakedBlissItems.DRIED_NYXBERRIES, GENERATED);

        itemModelGenerator.register(BakedBlissItems.CANDIED_DRIED_NYXBERRIES, GENERATED);

        itemModelGenerator.register(BakedBlissItems.NYXBERRY_JAM, GENERATED);

        itemModelGenerator.register(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE, GENERATED);



    }
}
