package olliemarkii.bakedbliss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import olliemarkii.bakedbliss.registry.BakedBlissBlocks;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.block.custom.StrawberryCropBlock;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }







    @Override
    public void generate() {

        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        LootItemBlockStatePropertyCondition.Builder mature =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(BakedBlissBlocks.STRAWBERRY_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(StrawberryCropBlock.AGE, 5));

        add(BakedBlissBlocks.STRAWBERRY_CROP,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(mature)
                                .add(LootItem.lootTableItem(BakedBlissItems.STRAWBERRY)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0F, 3.0F)))))
        );

        this.add(BakedBlissBlocks.NYXBERRY_BUSH,
                    block -> this.applyExplosionDecay(
                        block,
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BakedBlissBlocks.NYXBERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NyxberryBushBlock.AGE, 3))
                                                )
                                                .add(LootItem.lootTableItem(BakedBlissItems.NYXBERRIES))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BakedBlissBlocks.NYXBERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NyxberryBushBlock.AGE, 2))
                                                )
                                                .add(LootItem.lootTableItem(BakedBlissItems.NYXBERRIES))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                )
        );
    }
}
