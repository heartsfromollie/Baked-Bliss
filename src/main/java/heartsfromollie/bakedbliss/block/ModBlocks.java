package heartsfromollie.bakedbliss.block;

import heartsfromollie.bakedbliss.BakedBliss;
import heartsfromollie.bakedbliss.block.custom.PlushieBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block HEARTSFROMOLLIE_PLUSHIE = registerBlockWithoutBlockItem("heartsfromollie_plushie",
            new PlushieBlock(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable().nonOpaque()));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(BakedBliss.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BakedBliss.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(BakedBliss.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BakedBliss.LOGGER.info("Registering ModBlocks for " + BakedBliss.MOD_ID);
    }
}