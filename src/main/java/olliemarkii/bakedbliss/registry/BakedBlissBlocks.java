package olliemarkii.bakedbliss.registry;

import net.minecraft.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

public class BakedBlissBlocks {

    public static final Block STRAWBERRY_CROP = registerBlockWithoutBlockItem("strawberry_crop",
            new StrawberryCropBlock(BlockBehaviour.Properties.of().noCollission()
                    .randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).mapColor(MapColor.PLANT)));

    public static final Block NYXBERRY_BUSH = registerBlockWithoutBlockItem("nyxberry_bush",
            new NyxberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));



    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }


    public static void registerModBlocks() {
        BakedBliss.LOGGER.info("Registering Baked Bliss Blocks for " + BakedBliss.MOD_ID);
    }

}
