package olliemarkii.bakedbliss.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.block.custom.NyxberryBushBlock;
import olliemarkii.bakedbliss.block.custom.StrawberryCropBlock;

import java.util.function.Function;

public class BakedBlissBlocks {

    public static final Block STRAWBERRY_CROP = register("strawberry_crop",
            StrawberryCropBlock::new,
            //? if >1.21.4 {
            BlockBehaviour.Properties.of().noCollision()
            //? } else {
            /*BlockBehaviour.Properties.of().noCollission()
            *///? }
                    .randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).mapColor(MapColor.PLANT),
            false);

    public static final Block NYXBERRY_BUSH = register("nyxberry_bush",
            NyxberryBushBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH),
            false);



    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {

        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties
                //? if >=1.21.4 {
                .setId(blockKey)
                //? }
        );

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties()
                    //? if >=1.21.4 {
                    .setId(itemKey).useBlockDescriptionPrefix()
                    //? }
                    );
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, BakedBliss.of(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, BakedBliss.of(name));
    }


    public static void registerModBlocks() {
        BakedBliss.LOGGER.info("Registering Baked Bliss Blocks for " + BakedBliss.MOD_ID);
    }

}
